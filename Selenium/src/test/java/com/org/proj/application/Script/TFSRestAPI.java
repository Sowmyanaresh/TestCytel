//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.org.proj.application.Script;

import Fillo.Recordset;
import testlink.api.java.client.TestLinkAPIResults;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.json.JSONArray;
import org.json.JSONObject;

public class TFSRestAPI extends Driver{
    GlobalVariables gVar = new GlobalVariables();
      
    public boolean executeTFSAPI(String m_baseURI, String m_Method, String m_Body) throws Exception {
        boolean bStatus = false;
        Response response = null;

        try {
            String m_Header = "Content-Type:application/json;charset=UTF-8";
            String m_Parameters = "empty";
            //this.child.log(LogStatus.INFO, "Request URL=", m_baseURI);
           System.out.println("Request URL=" + m_baseURI);
            RequestSpecification req = RestAssured.given().auth().preemptive().basic(GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_TFSUsername"), GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_TFSPassword")).request().with();
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
            if(response != null && response.getStatusCode() == 200) {
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

    public boolean updateTestCaseStatusInTFS(String execStatus) throws Exception {
        boolean bStatus = false;
        try {
        	if(execStatus.equalsIgnoreCase("PASS")){
        		execStatus="Passed";    			
    		}else{
    			execStatus="Failed";    			
    		}
        	
            if(this.executeTFSAPI(GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_TestPlanPostURL"), "POST", "{\"name\":"+GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_testPlanName")+",\"area\":{\"name\":"+GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_testAreaName")+"},\"iteration\":"+GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_testIterationName")+"}")) {
                JSONObject object = new JSONObject(this.gVar.runtimeRestAPIResponse);
                String testPlanID = object.getString("id");
                System.out.println("testPlan ID from json object=" + testPlanID);
                if(this.executeTFSAPI(GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_TestRunPostURL"), "POST", "{  \"name\":"+GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_testPlanName")+",  \"plan\": {    \"id\": "+"\""+ testPlanID+"\" }}")) {
                    object = new JSONObject(this.gVar.runtimeRestAPIResponse);
                    String testRunID = object.getString("id");
                    System.out.println("testRunID from json object=" + testRunID);
                    if(this.executeTFSAPI(GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_TestCaseAddToSuitePostURL")+testPlanID+"/suites/"+String.valueOf(Integer.parseInt(testPlanID)+1)+"/testcases/1?api-version=5.0-preview.3", "POST", "empty")) {
                    	if(this.executeTFSAPI(GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_TestPointGetURL")+testPlanID+"/suites/"+String.valueOf(Integer.parseInt(testPlanID)+1)+"/points?api-version=5.0-preview.2", "GET", "empty")) {
                    		object = new JSONObject(this.gVar.runtimeRestAPIResponse);
                    		JSONArray arr = object.getJSONArray("value");
		                    int testPointID = arr.getJSONObject(0).getInt("id");
		                    if(this.executeTFSAPI(GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_testCaseResultUpdateURL")+testRunID+"/results?api-version=5.0-preview.5", "POST", "[{\"testCase\": {\"id\": \"1\",\"name\": \"Verify Google Search Home Page Launch\"},\"testPoint\":{\"id\": "+String.valueOf(testPointID)+"},\"priority\": 2,\"outcome\": \""+execStatus+"\"}]")) {
		                       	System.out.println("Successfully Updated Test Case Result status in TFS");
		                       	object = new JSONObject(this.gVar.runtimeRestAPIResponse);
	                    		arr = object.getJSONArray("value");
			                    int testResultID = arr.getJSONObject(0).getInt("id");
		                       	if(this.executeTFSAPI(GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_testCaseResultUpdateURL")+testRunID+"/results?api-version=5.0-preview.5", "PATCH", "[  {    \"id\": "+testResultID+",    \"state\": \"Completed\",    \"comment\": \"Google home page launched successfully\"  }]")) {
		                       		System.out.println("Successfully Updated Test Case state in TFS");
		                       		s_childExtentTest.log(LogStatus.INFO, "TFS update", "Execution results updated successfully as PASS for test case");
		                       		bStatus=true;
		                       	}else{
		                       		System.out.println("Failed to Update test case state in TFS");
		                       		s_childExtentTest.log(LogStatus.INFO, "TFS update", "Execution results updated successfully as FAIL for test case");
		                       	}		                       		
                                //this.child.log(LogStatus.INFO, this.gVar.g_strStepDescription, "Updated Test Case Result status as FAIL in TFS");
                            } else {
                            	System.out.println("Failed to Update test case Result status in TFS");
                               // this.child.log(LogStatus.FAIL, this.gVar.g_strStepDescription, "Failed to Update Step Result status in TFS");
                            }
                    	} else {
                        	System.out.println("Failed to get Test Point ID from TFS");
                           
                        }  
                    } else {
                    	System.out.println("Failed to Add Test case to Test Suite in TFS");
                       
                    }  	
                } else {
                	System.out.println("Failed to Add Test Run ID in TFS");
                   
                }  
            } else {
            	System.out.println("Failed to Add Test Plan ID in TFS");
               
            }  
        } catch (Exception e) {
            //logger4j.error("Exception Thrown", e);
            //this.child.log(LogStatus.FAIL, this.gVar.g_strStepDescription, this.gVar.g_strStepDescription + " is failed due to exception thrown");
            e.printStackTrace();
        }

        return bStatus;
    }
}
