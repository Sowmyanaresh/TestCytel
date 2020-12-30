package com.org.proj.application.Script;

import com.relevantcodes.extentreports.LogStatus;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class TestLinkRestAPI extends Driver{	

	public static void reportResult(String TestCaseID, String Result) throws Exception{
		String Notes= null;
		if(Result.equalsIgnoreCase("PASS")){
			Result=TestLinkAPIResults.TEST_PASSED;
			Notes="Executed successfully.";
		}else{
			Result=TestLinkAPIResults.TEST_FAILED;
			Notes="Execution Failed.";
		}

		TestLinkAPIClient api=new TestLinkAPIClient(GenericUtilityLibrary.getValueFromIniFile("START_TESTLINK", "g_DEVKEY"), 
				GenericUtilityLibrary.getValueFromIniFile("START_TESTLINK", "g_URL"));
		
		api.reportTestCaseResult(GenericUtilityLibrary.getValueFromIniFile("START_TESTLINK", "g_TestProject"), 
				GenericUtilityLibrary.getValueFromIniFile("START_TESTLINK", "g_TestPlan"), 
				TestCaseID, GenericUtilityLibrary.getValueFromIniFile("START_TESTLINK", "g_Build"), Notes, Result);
		if(Result.equalsIgnoreCase("p")){
			s_childExtentTest.log(LogStatus.INFO, "TestLink update", "Execution results updated successfully as PASS for test case " + TestCaseID);
		}else{
			s_childExtentTest.log(LogStatus.INFO, "TestLink update", "Execution results updated successfully as FAIL for test case " + TestCaseID);
		}
		
	}


}
