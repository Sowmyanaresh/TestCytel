package com.org.proj.application.Script;

import groovy.json.internal.JsonFastParser;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.relevantcodes.extentreports.LogStatus;

public class JIRARestAPI extends Driver{
	
	 GlobalVariables gVar = new GlobalVariables();
     
	    public boolean executeZAPI(String m_baseURI, String m_Method, String m_Body) throws Exception {
	        boolean bStatus = false;
	        Response response = null;

	        try {
	            String m_Header = "Content-Type:application/json;charset=UTF-8";
	            String m_Parameters = "empty";
	            //this.child.log(LogStatus.INFO, "Request URL=", m_baseURI);
	           System.out.println("Request URL=" + m_baseURI);
	            RequestSpecification req = RestAssured.given().auth().preemptive().basic(GenericUtilityLibrary.getValueFromIniFile("START_JIRA", "g_JiraUsername"), GenericUtilityLibrary.getValueFromIniFile("START_JIRA", "g_JiraPassword")).request().with();
	            String[] headers;
	            if(m_Header.contains("!")) {
	                headers = m_Header.split("!");
	            } else {
	                headers = new String[]{m_Header};
	            }

	            String paramKey;
	            for(int i = 0; i < headers.length; ++i) {
	                String headerKey = headers[i].split(":")[0];
	                paramKey = headers[i].split(":")[1];
	                req = req.header(headerKey, paramKey, new Object[0]);
	                //this.child.log(LogStatus.INFO, "Header " + (i + 1) + "===" + headerKey, paramKey);
	            }

	            System.out.println("params=" + m_Parameters + "value");
	            if(!m_Parameters.contentEquals("empty")) {
	                String[] params;
	                if(m_Parameters.contains("!")) {
	                    params = m_Parameters.split("!");
	                } else {
	                    params = new String[]{m_Parameters};
	                }

	                for(int j = 0; j < params.length; ++j) {
	                    paramKey = params[j].split(":")[0];
	                    String paramValue = params[j].split(":")[1];
	                    req = req.param(paramKey, new Object[]{paramValue});
	                    //this.child.log(LogStatus.INFO, "Parameter " + (j + 1) + "===" + paramKey, paramValue);
	                }
	            }

	            if(!m_Body.contentEquals("empty")) {
	                //this.child.log(LogStatus.INFO, "Request Body=", m_Body);
	            	System.out.println("Request Body="+m_Body);
	                req = req.body(m_Body);
	            }

	            if(m_Method.contentEquals("GET")) {
	                response = (Response)req.when().get(m_baseURI, new Object[0]);
	            } else if(m_Method.contentEquals("POST")) {
	            	System.out.println("Entered into POST method");
	            	System.out.println("req body=" + req.request());
	                response = (Response)req.when().post(m_baseURI, new Object[0]);
	            } else if(m_Method.contentEquals("PUT")) {
	                response = (Response)req.when().put(m_baseURI, new Object[0]);
	            }else if(m_Method.contentEquals("PATCH")) {
	            	System.out.println("Entered into PATCH method");
	            	System.out.println("req body=" + req.request());
	                response = (Response)req.when().patch(m_baseURI, new Object[0]);
	            }

	            this.gVar.runTimeJsonResponse = response;
	            this.gVar.runtimeRestAPIResponse = response.getBody().asString();
	            getIssueTextInJIRA();
	            if((response != null && response.getStatusCode() == 200) || response.getStatusCode() == 204) {
	            	System.out.println("ZAPI Response code=" + Integer.toString(response.getStatusCode()));
	            	System.out.println("ZAPI Response Body=" + response.getBody().asString());
	                bStatus = true;
	            } else {
	            	
	            	System.out.println("ZAPI response=" + response.getBody().asString());
	            }
	        } catch (Exception e) {
	        	//System.out.println( e.printStackTrace(););
	            //logger4j.error(this.gVar.g_strStepDescription + " is failed due to exception thrown");
	            e.printStackTrace();
	        }

	        return bStatus;
	    }

	    public void getIssueTextInJIRA() {	 
	    	JSONObject object = new JSONObject(this.gVar.runtimeRestAPIResponse);	    	 
	    	JSONObject object1 =(JSONObject) object.get("fields");
	    	JSONObject object2 =(JSONObject) object1.get("description");
	    	object2.keySet();
	    	for ( int k=0; k<object2.keySet().size();k++)
	    	{
	    		System.out.print(object2.keys());
	    	}
	    	JSONObject jo = object2.getJSONObject("content");
	    	//long id = jo.getLong("text");
	    	String name = jo.getString("text");
	    	double clat = jo.getDouble("lat");
	    	
	    	JSONObject object3 =(JSONObject) object2.get("content");
	    	JSONArray jsonarr_1 = (JSONArray) object3.get("content");
	    	//Get data for Results array
	    	System.out.print(jsonarr_1.length());
	    	for(int i=0;i<jsonarr_1.length();i++)
	    	{		    	
	    		JSONObject jsonobj_2 = (JSONObject)jsonarr_1.get(i);
	    		JSONArray jsonarr_5 = (JSONArray) jsonobj_2.get("content");
	    		
	    		JSONObject jsonobj_6 = (JSONObject)jsonarr_5.get(0);
	    		String str=(String) jsonobj_6.toString();
	    		String[] arrOfStr = str.split(":");
	    		for(int j=0;j<arrOfStr.length;j++)
	    		{
	    			//String[] arrOfStr1 =  arrOfStr[j].split(",");
	    			// String[] arrOfStr2 =  arrOfStr1[0].split(":");
	    			System.out.println(arrOfStr[1].toString());
	    		}
	    	}
		    	 
	    	
	    
	    	
			//return strText;
	    	
	    }
	    
	    public boolean updateUserStoryInTFS(String execStatus, String transitionStatusID) throws Exception {
	        boolean bStatus = false;
	        try {
	        	//if(this.executeZAPI(GenericUtilityLibrary.getValueFromIniFile("START_JIRA", "g_issueIDGetURL")+GenericUtilityLibrary.getValueFromIniFile("START_JIRA", "g_UserStoryKey"), "GET", "empty")) {
	        	if(this.executeZAPI(GenericUtilityLibrary.getValueFromIniFile("START_JIRA", "g_issueIDGetURL")+ GlobalVariables.g_UserStoryKey, "GET", "empty")) {
	        	JSONObject object = new JSONObject(this.gVar.runtimeRestAPIResponse);
	        	
	                String issueID = object.getString("id");
	                System.out.println("issue ID from json object=" + issueID);
	                if(this.executeZAPI(GenericUtilityLibrary.getValueFromIniFile("START_JIRA", "g_issueIDGetURL")+issueID+"/transitions", "POST", "{\"status\": {\"name\": \""+execStatus+"\"},\"transition\": {\"id\": \""+transitionStatusID+"\"}}")) {
	                   		System.out.println("Successfully Updated user story status in JIRA");
                       		bStatus=true;
                   	}else{
                   		System.out.println("Failed to Update user story status in JIRA");			                       		
                   	   	                                
   	                } 
	        	} else {
	        		
	        		System.out.println("Failed to get issueID from JIRA");
               
	        	}  
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return bStatus;
	    }

}
