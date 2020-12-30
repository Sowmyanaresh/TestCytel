package com.org.proj.application.Script;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jayway.restassured.response.Response;

import Fillo.Recordset;

public class GlobalVariables {
	
	public static String ExecuteColHeader= "Execute";
	public static String FunctionNameColHeader = "FunctionName";
	public static String ActionColHeader = "ActionOrKeyword";
	public static String ObjectNameColHeader = "ObjectLogicalName";
	public static String FindMethodColHeader="FindMethod";
	public static String XPathQueryColHeader = "XpathQuery_PropertyName";
	public static String PropertyValueColHeader = "PropertyValue";
	public static String TagNameColHeader = "TagName";
	public static String FunctionDescColHeader = "FunctionDescription";
	public static String StepDescColHeader = "StepDescription";
	public static String ExpectedResultsDescColHeader = "ExpectedResults";

	public static String g_UserStoryKey;
	public static String g_CreditScore;
	
	public static String g_strSoapPort;
	public static String g_strSoapBaseURI;
	public static String g_strRestBaseURI;
	
	public static String g_strRallyURL;
	public static String g_strRallyProxy;
	public static String g_strRappyApiKey;
	public static String g_strControllerFilePath;
	public static String g_strTestDataFilePath;
	public static String g_strTestCaseFilePath;
	public static String g_strControllerSheetName;
	public static String g_strKeywordLibraryFilePath;
	public static String g_strObjectRepositoryFilePath;
	public static String g_strODBQAConnectionString;
	public static String g_strODSQAUserID;
	public static String g_strODSQAPwd;
	public static int g_intTotalRecords;
	public static int g_intTotalColumns;
	public static Connection g_objConnection;
	public static String g_strClientId;
	public static String g_strClientSecret;
	public static String g_strAuthTokenUrl;
	public static String g_strAccessToken;
	public static String g_strMobileClientId;
	public static String g_strMobileAuthToken;
	public static String g_SQLConnectionURL;
	public static String g_ODSDBPassword;
	public static String g_ODSDBODBCDataSource;
	public static String g_ODSDBUserID;
	
	public static URL g_strAppiumServerURL;
	public static String g_strIOSUDID;
	public static String g_strIOSDeviceName;
	public static String g_strIOSPlatformVersion;
	public static String g_strIOSPlatformName;
	public static String g_strIOSAppName;
	public static String g_strIOSBrowserName;
	public static String g_strAndroidBrowserName;
	public static String g_strAndroidPlatformName;
	public static String g_strAndroidPlatformVersion ;
	public static String g_strAndroidDeviceName ;
	public static String g_strAndroidAppName;
	public static String g_strAndroidUDID;
	public static String g_strAndroidSdkPath;
	
	public static String g_strBrowserType;
	public static String strKeywordExecStatus;
	public static String g_strParamValues;
	public static String g_strStepDescription;
	public static String g_strKeywordDescription;
	public static String g_strFunction;
	public static String g_strLogicalName;
	public static String g_strExpectedResults;
	
	public static Response runTimeJsonResponse;
	public static String runtimeRestAPIResponse;
	public static String runtimeRestAPIResponseCode;
	public static String runtimeRestAPIResponseMsg;
	public static String runTimeRestAPIValue1;

	public static String UniqueValue;
	
	public static WebElement g_objTestObject;
	
	public Recordset objRSKeywordsToExec;
	public Recordset objRSTestScenario;
	public Object runtimeVariables;
	public static String c_elementText = null;
	
	public static long smallWait=10;
	public static long mediumWait=20;
	public static long extMediumWait=10;
	public static long longWait=15;
	public static long MobileWait=2;
	public static HashMap<String, Object> variables = new HashMap<String, Object>();
	public static String g_strCreateMember;
	public static String g_strregDataFilePath;
	public static String strRunID;
	
	public static WebDriver driver;
	public static java.sql.Connection connection;
	
	public static int g_reRunIterations;
	public static boolean g_reRunFailedTests;
	
	public static int g_terminateExecutionForSequentialFailureOf;
	
	public static boolean g_captureScreenShotsForPassedSteps;
	
	public static boolean g_captureScreenShot = false;
	
	public  HashMap<String, Object> runtimeVariable1 = new HashMap<String, Object>();
	
	 public static boolean g_triggerEmails;
	public static String g_Application;
    public static String g_Domain;
    public static String g_Mailusername;
    public static String g_MailPaswword;
    public static String g_ExchageURI;
    public static String g_TO;
    public static String g_CC;
    public static String g_From;
    public static String g_ReportType;
    
    
    public static boolean g_updateResultsInRally;
    public static String g_strDownloadFilePath;
    public static String g_reportsLocation;
    
    public static String g_RunLocal;
    public static String g_pcloudyUserId;
    public static String g_pcloudyIndUrl;
    public static String g_pcloudyUsaUrl;
    public static String g_pcloudyPublicUrl;
    public static String g_pcloudyIndApiKey;
    public static String g_pcloudyUsaApiKey;
    public static String g_pcloudyPublicKey;
    public static String g_pcloudyEnvironment;
   
    public static Connection con=null;
	public static Statement stmt=null;
	public static ResultSet rs=null;
	public static String DBURL;
	public static String DBUserName;
	public static String DBPassword;
   
    
    
}
