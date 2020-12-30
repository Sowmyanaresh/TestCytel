package com.org.proj.application.Script;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.io.IOException;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;

import com.rallydev.rest.util.Fetch;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rallydev.rest.RallyRestApi;
import com.rallydev.rest.request.QueryRequest;
import com.rallydev.rest.request.UpdateRequest;
import com.rallydev.rest.response.QueryResponse;
import com.rallydev.rest.response.UpdateResponse;

import com.rallydev.rest.util.QueryFilter;

public class RallyRest {

	public static HashMap<String, String> updateTCVerdict (String testCaseID, String verdict){
		
		HashMap<String, String> info = new HashMap<String, String>();
		String status = "";
		if(testCaseID.contains("_TC")){
			StringTokenizer str = new StringTokenizer(testCaseID, "_");
			while(str.hasMoreTokens()){
				String token = str.nextToken().trim(); 
				if(token.startsWith("TC")){
					status = updateTestCase(token, verdict);
					info.put(token, status);
				}
			}
		}else {
			status = updateTestCase(testCaseID, verdict);
			info.put(testCaseID, status);
		}
		return info;
	}
	
	public static String updateTestCase(String tc_id, String verdict) {
		
		RallyRestApi rallyApi = null;
		try {
			rallyApi = new RallyRestApi(new URI("https://rally.com"),
					"jjjj");
			rallyApi.setProxy(new URI("http://proxy."));

			QueryRequest request = new QueryRequest("Testcase");
			request.setFetch(new Fetch("LastResult", "Method"));
			request.setQueryFilter(new QueryFilter("FormattedID", "=", tc_id));
			QueryResponse response = rallyApi.query(request);
			if(response.getResults().size() > 0) {
				try {
					String status = "";
					JsonObject jsonObj = response.getResults().get(0).getAsJsonObject();
					JsonElement jsonElement = jsonObj.getAsJsonObject("LastResult").getAsJsonPrimitive("_ref");
					JsonObject jsonUpdObj = new JsonObject();
					jsonUpdObj.addProperty("Verdict", verdict);
					Date date = new java.util.Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
					jsonUpdObj.addProperty("Date", sdf.format(date));
					UpdateRequest updateRequest = new UpdateRequest(jsonElement.getAsString(), jsonUpdObj);
					UpdateResponse updResponse = rallyApi.update(updateRequest);
					if (updResponse.wasSuccessful()) status = "pass";
					else status = "fail";
					if(status.equals("pass")) {
						try {
							String method = jsonObj.get("Method").getAsString();
							if(!method.equals("Automated")) {
								String methodRef = jsonObj.get("_ref").getAsString();
								JsonObject jsonUpdMethod = new JsonObject();
								jsonUpdMethod.addProperty("Method", "Automated");
								UpdateRequest updateRequestMethod = new UpdateRequest(methodRef, jsonUpdMethod);
								rallyApi.update(updateRequestMethod);
								return status;
							}
						}catch(Exception e) {
							return status;
						}
					}
					return status;
				}catch(Exception e) {
					return "fail";
				}
			} else return "fail";
		} catch (Exception e) {
			return "fail";
		}
		finally {
			try {
				rallyApi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
