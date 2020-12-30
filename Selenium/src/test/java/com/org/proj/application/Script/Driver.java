package com.org.proj.application.Script;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ssts.pcloudy.Connector;
import com.ssts.pcloudy.Version;
import com.ssts.pcloudy.appium.PCloudyAppiumSession;
import com.ssts.pcloudy.dto.appium.booking.BookingDtoDevice;
import com.ssts.pcloudy.dto.device.MobileDevice;
import com.ssts.pcloudy.dto.file.PDriveFileDTO;
import com.ssts.util.reporting.MultipleRunReport;

import Fillo.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import mx4j.log.Log;

public class Driver {
    public WebDriver driver;
    public WebDriver mobileDriver;
      private File classpathRoot;
      private File appDir;
      private File app;
      GlobalVariables gVar = new GlobalVariables();
      private DesiredCapabilities capabilities = new DesiredCapabilities();
    private BookingDtoDevice aDevice;
      protected static final Logger s_objlog4j = Logger.getLogger(Driver.class);
    File logFile = new File(Thread.currentThread().getName() + ".txt");
      static String reportName = "ExecutionReport.html";
      
      public static ExtentTest s_objextendTest = null;
      public static ExtentReports s_objExtentReport = null;
      public static ExtentTest s_parentExtentTest=null;
      public static ExtentTest s_childExtentTest=null;
      long st;
      
      static int totalTestCases = 0;
      static int executedTestCases = 0;
      static String executionStartTime;
      static String executionEndTime;
      private GenericUtilityLibrary gUtilLib;
      String startTime;
      static int counter = 0;
      String reportsLocation;
      static int sequentialfailureCount = 0;
      static boolean terminateForSequentialFailure = false;
      static ArrayList<String> failedTests = new ArrayList<String>();
      static HashMap<String, String> defectIds = new HashMap<String, String>();
    
    Connector con;
    String authToken;
    PCloudyAppiumSession pCloudySession;
    boolean blnMobileExecutionFlag=false;
    boolean blnIsOnlyWebExecution = false;
    boolean blnIsMobileAndWebExecution = false;
    PrintWriter wr;
    
      public static void retrieveCountersFromFile(String fileName, String type) throws IOException {

            File file = new File(fileName);
            if(type.equals("read")) {
                  if (file.exists()) {
                        try {
                              BufferedReader br = new BufferedReader(new FileReader(fileName));
                              String line = "";
                              if(line.startsWith("counter")) {
                                    String counterIs = line.substring(line.indexOf("=")+1, line.length()).trim();
                                    counter = Integer.parseInt(counterIs);
                              }
                              br.close();
                        } catch (Exception e) {
                              e.printStackTrace();
                        }
                  }else {
                        counter = 0;
                        File tempFile = new File(fileName);
                        boolean createFile = tempFile.createNewFile();
                        if(createFile){
                              PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
                              pw.write("counter="+ String.valueOf(counter));
                              pw.println("\n");
                              if(failedTests.size()> 0) {
                                    String failed = "";
                                    Iterator<String> itr = failedTests.iterator();
                                    while(itr.hasNext()){
                                          String name = itr.next().trim();
                                          failed = failed+ "," + name;
                                    }
                                    if(failed.startsWith(","))failed = failed.substring(1, failed.length());
                                    pw.println("\n");
                                    pw.write("failedTests="+ failed);
                              }
                              pw.close();
                        }
                  }
            }else {
                  File tempFile = new File(fileName);
                  if (tempFile.exists())tempFile.delete();
                  boolean createFile = tempFile.createNewFile();
                  if(createFile){
                        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
                        pw.write("counter="+ String.valueOf(counter));
                        if(failedTests.size()> 0) {
                              String failed = "";
                              Iterator<String> itr = failedTests.iterator();
                              while(itr.hasNext()) {
                                    String name = itr.next().trim();
                                    failed = failed+ "," + name;
                              }
                              if(failed.startsWith(","))failed = failed.substring(1, failed.length());
                              pw.println("\n");
                              pw.write("failedTests="+ failed);
                        }
                        pw.close();
                  }
            }
      }
      
      public void getTestExecutionDetails(String fileName) {
            
            try {
            int count = 0;
            String testCase = "";
              BufferedReader in = new BufferedReader(new FileReader(fileName));
              String str;
              while ((str = in.readLine()) != null) {
                  str = str.replaceAll("^\\s+", "");
                  if(str.trim().contains("<span class='test-name'>") ||  str.trim().contains("<span class='test-status label right outline capitalize")){
                        if(str.trim().contains("<span class='test-name'>")){
                              count = count + 1;
                              str = str.replaceAll("<span class='test-name'>","");
                              testCase = str.replaceAll("</span>","").trim();
                        }else {
                              str =str.replace("</span>", "").trim();
                              str =str.substring(str.indexOf(">")+1,  str.length());
                              if(str.equalsIgnoreCase("fail")) {
                                    if(!failedTests.contains(testCase)) failedTests.add(testCase);
                              }
                        }
                  }
               }
              in.close();
          } catch (IOException e) {
            //logger.error(className, "Unable to read contents from '" + fileName + "'.\n" + ExceptionUtils.getStackTrace(e));
          }
      }
      
      public enum typeOfBrowser {
            Firefox, Chrome, IE, Android, AndroidChrome, WS, iOS, iOSSafari, Firefox_Android, Firefox_iOS, Chrome_iOS;
      }
      
      @BeforeTest
      //@Parameters({ "browser" })
      public void setup() throws Exception {
            gUtilLib = new GenericUtilityLibrary();
            initExcelFiles();
            initializeDB();
            if(GlobalVariables.g_reRunIterations == 0 && GlobalVariables.g_reRunFailedTests) GlobalVariables.g_reRunFailedTests = false;
            if(GlobalVariables.g_reRunFailedTests){
                  executionStartTime = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss z").format(Calendar.getInstance().getTime());
                  reportsLocation = GlobalVariables.g_reportsLocation;
                  /*File fileIs = new File(reportsLocation);
                  if(!fileIs.exists())fileIs.mkdirs();*/
            }else reportsLocation = GlobalVariables.g_reportsLocation;
            
            if(GlobalVariables.g_terminateExecutionForSequentialFailureOf > 0) terminateForSequentialFailure = true;
            File file1 = new File(reportsLocation + File.separator + "donot-delete.txt");
            if(file1.exists())file1.delete();

            //GenericWebObjectLibrary.triggerAppiumLauncher();
      }

    private void log(String msg) throws FileNotFoundException {
        if (wr == null) {
            wr = new PrintWriter(logFile);
        }
        String log = "\t\t|" + Thread.currentThread().getName() + "\t|\t" + msg;
        wr.println(log);
        wr.flush();
        // System.err.println(log);
    }
    public void setup(URL appiumEndpoint, BookingDtoDevice aDevice) throws Exception {
        this.aDevice = aDevice;
        log("Inside Setup");
        gUtilLib = new GenericUtilityLibrary();
        log("before init Excel");
        initExcelFiles();
        s_objExtentReport = new ExtentReports("reports" + File.separator + "ExecutionReport" + aDevice.model + ".html", false);
        s_objExtentReport.loadConfig(new File("src" + File.separator + "test" + File.separator + "resources" + File.separator + "extent-config.xml"));
        
        gVar.g_strAppiumServerURL = appiumEndpoint;
        log("Setup done");
    }

      @AfterTest
      public void teardown() throws Exception {
      
            if(GlobalVariables.driver != null) closeDriver();
            if(GlobalVariables.g_reRunFailedTests) {
                  File file1 = new File(reportsLocation + File.separator + "donot-delete.txt");
                  if(file1.exists())file1.delete();   
                  File file = new File(reportsLocation + File.separator + reportName);
                  if(counter > 0){
                        String nameOfFile = reportName.substring(0, reportName.indexOf("."))+"-Rerun";
                        String fileType = reportName.substring(reportName.indexOf("."), reportName.length());
                        File rnameFile = new File(reportsLocation + File.separator + nameOfFile+String.valueOf(counter) + fileType);
                        if(rnameFile.exists())rnameFile.delete();
                        file.renameTo(new File(reportsLocation + File.separator + nameOfFile+String.valueOf(counter)+fileType));
                  }     
                  executionEndTime = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss z").format(Calendar.getInstance().getTime());
                  HashMap<String, Object> info = new HashMap<String, Object>();
                  info.put("total", totalTestCases);
                  info.put("endedAt", executionEndTime);
                  info.put("executed", executedTestCases);
                  info.put("startedAt", executionStartTime);
                  info.put("reportsLocation", reportsLocation);
                  if(defectIds.size() > 0)info.put("defects", defectIds);
                  if(GlobalVariables.g_triggerEmails){
                        String bodyContent ="Hi All,<br/><br/>Please find attached the '<b>" + GlobalVariables.g_ReportType + " </b> execution report' for <b>"
                        + GlobalVariables.g_Application +"</b> application triggered  at <b>" + executionStartTime + "</b>.<br/><br/>";
                        String subject= GlobalVariables.g_ReportType + " execution report for  "+ GlobalVariables.g_Application +" application.";
                        SendReportsViaEmail.sendEmail(info, subject, bodyContent, GlobalVariables.g_TO, GlobalVariables.g_CC, GlobalVariables.g_Application);
                  }     
            }
      }

      @Test
      public void runtestsInSuite() throws Exception {
            Execute();
      }
      
      public void Execute() throws Exception {
        GenericWebObjectLibrary library = null;
        GenericWebObjectLibrary globalLibrary;
        int testLinkStatusCounter=0;
            if(GlobalVariables.g_reRunFailedTests) retrieveCountersFromFile(reportsLocation + File.separator + "donot-delete.txt", "");
            try {
                  int resCount = 0;
                  boolean isStepPass = false;
                  Recordset objRSTestSuite = queryTestControllerSheet();
                  if(s_objExtentReport == null){
                        s_objExtentReport = new ExtentReports(reportsLocation + File.separator + reportName, true);
                                      s_objExtentReport.addSystemInfo("Browser Version", "84.04");
                                      String value=System.getProperty("os.arch");  
                                      System.out.println(value);
                                    	String bit=StringUtils.right(value, 2);
                                    	 s_objExtentReport.addSystemInfo("OS Bit",bit);
                                    
                                      
                        s_objExtentReport.loadConfig(new File("src"+File.separator+"test"+File.separator+"resources"+File.separator+"extent-config.xml"));
                  }else s_objExtentReport = new ExtentReports(reportsLocation + File.separator + reportName, true);
                  
                  if(objRSTestSuite==null) {
                        s_parentExtentTest = s_objExtentReport.startTest("No Tests", "No tests selected for execution");
                        s_parentExtentTest.setStartedTime( new Date());
                        st=System.currentTimeMillis();
                        startTime=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                        s_parentExtentTest.log(LogStatus.FAIL, "No Tests","Read from Excel has been failed due to exception");
                        s_parentExtentTest.setEndedTime(new Date());
                        s_objExtentReport.endTest(s_parentExtentTest);
                  }
                  totalTestCases = objRSTestSuite.getCount();
                  
                 /* if (totalTestCases > 0) {                       
                        if(GenericUtilityLibrary.getValueFromIniFile("START_JIRA", "g_UpdateStatusInJIRA").equalsIgnoreCase("true")){
                              JIRARestAPI jiraAPI = new JIRARestAPI();                            
                                    jiraAPI.updateUserStoryInTFS("In Progress","21");                          
                        }
                  }*/
                  
                  while (objRSTestSuite.next()) {                             
                        boolean runTest = true;
                        boolean errorOccured = false;
                        if(!terminateForSequentialFailure){
                              sequentialfailureCount = 0;
                              GlobalVariables.g_terminateExecutionForSequentialFailureOf = 1;
                        }
                        if(GlobalVariables.g_reRunFailedTests && !failedTests.contains(objRSTestSuite.getField("TestCaseID")) && counter > 0) runTest = false;
                        
                        if(runTest && sequentialfailureCount < GlobalVariables.g_terminateExecutionForSequentialFailureOf) {
                              if(counter == 0) executedTestCases = executedTestCases + 1;
                              try { 
                                    GlobalVariables.g_strBrowserType = objRSTestSuite.getField("Browsers");
                      //  openDriver(GlobalVariables.g_strBrowserType);
                                  //  s_objExtentReport.addSystemInfo("Browser", GlobalVariables.g_strBrowserType);
                                   // s_objExtentReport.i(s_objExtentReport.addSystemInfo("Broser", GlobalVariables.g_strBrowserType);
                                    
                                 //   s_objExtentReport.startTest(GlobalVariables.g_strBrowserType);
                                   // s_objExtentReport.addSystemInfo(info)
                                    Recordset objRSTestData = queryTestDataSheet(objRSTestSuite);
                                    s_parentExtentTest = s_objExtentReport.startTest(objRSTestSuite.getField("TestCaseID"));
                                    s_parentExtentTest.setStartedTime(new Date());
                        
                                    st=System.currentTimeMillis();
                        
                                    startTime=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                                    //while (objRSTestData.next()) {
                                          if (objRSTestSuite.getField("TestCaseID") != "") {
                                                int g_arrintIterations = Integer.parseInt(objRSTestSuite.getField("Iterations"));
                                                String[] g_arrBrowsers = GenericUtilityLibrary.arrGetBrowsers(objRSTestSuite.getField("Browsers"));
                                                for (int intBrowsers = 0; intBrowsers < g_arrBrowsers.length; intBrowsers++) {
                                                      for (int intIterationCounter = 0; intIterationCounter < g_arrintIterations; intIterationCounter++) {
                                                            objRSTestData.next();
                                                            openDriver(GlobalVariables.g_strBrowserType);
                                                            gVar.objRSTestScenario = queryTestScriptSheet(objRSTestSuite);
                                                            if(gVar.objRSTestScenario == null){
                                                                  s_parentExtentTest.log(LogStatus.FAIL, "No testcase defined","Read from Excel has been failed due to exception");
                                                                  s_parentExtentTest.setEndedTime(new Date());
                                                                  s_objExtentReport.endTest(s_parentExtentTest);
                                                            }
                                                            while (gVar.objRSTestScenario.next()) {
                                                                  isStepPass = true;
                                                                  String strExecStatus = null;
                                                                  if (gVar.objRSTestScenario.getField(GlobalVariables.FunctionNameColHeader) != "Comment") {
                                                                  gVar.g_strStepDescription = gVar.objRSTestScenario.getField(gVar.FunctionDescColHeader) + gVar.objRSTestScenario.getField(gVar.ExpectedResultsDescColHeader);
                                                                  ArrayList<String> getFieldNames = gVar.objRSTestScenario.getFieldNames();
                                                                  if(getFieldNames.contains(gVar.ExpectedResultsDescColHeader)){
                                                                  if(!gVar.objRSTestScenario.getField(gVar.ExpectedResultsDescColHeader).trim().equals("")){
                                                                              gVar.g_strExpectedResults = gVar.objRSTestScenario.getField(gVar.FunctionNameColHeader) + " : "
                                                                                          + gVar.objRSTestScenario.getField(gVar.ExpectedResultsDescColHeader);
                                                                              gVar.g_strStepDescription = gVar.g_strExpectedResults;
                                                                        }
                                                                  }
                                                                  strExecStatus = gVar.objRSTestScenario.getField(GlobalVariables.ExecuteColHeader).toUpperCase();
                                                                  if (strExecStatus.contentEquals("YC") || strExecStatus.contentEquals("YS")) {
                                                                  s_childExtentTest=s_objExtentReport.startTest(gVar.objRSTestScenario.getField(gVar.FunctionDescColHeader) + gVar.objRSTestScenario.getField(gVar.ExpectedResultsDescColHeader) );
                                                                        s_childExtentTest.setStartedTime(new Date());
                                                                        s_parentExtentTest.appendChild(s_childExtentTest);
                                                                        boolean handled = false;
                                                                        String functionName = gVar.objRSTestScenario.getField(GlobalVariables.FunctionNameColHeader);
                                                                        if(functionName.contains("_")) gVar.objRSKeywordsToExec = queryTestKeywordSheet();      
                                                                        else {
                                                                              handled = true;
                                                                              String[] g_arrParams = GenericUtilityLibrary.arrGetTestDataParams(gVar.objRSTestScenario);
                                                                              isStepPass = blnWorkFlowExecuteFromStepsOFScript(g_arrParams, g_arrintIterations, objRSTestSuite.getField("TestCaseID"), objRSTestData);
                                                                              s_childExtentTest.setEndedTime(new Date());
                                                                              s_parentExtentTest.setEndedTime(new Date());
                                                                              Arrays.fill(g_arrParams, null);
                                                                              if(!isStepPass){
                                                                                    ++resCount;
                                                                                    errorOccured = true;
                                                                                    break;
                                                                              }
                                                                        }
                  
                                                                        if(gVar.objRSKeywordsToExec == null && !handled){
                                                                              s_childExtentTest.log(LogStatus.FAIL, "No Business Functions defined","Read from Excel has been failed due to exception");
                                                                              s_childExtentTest.setEndedTime(new Date());
                                                                              s_parentExtentTest.setEndedTime(new Date());
                                                                              s_objExtentReport.endTest(s_parentExtentTest);
                                                                        }

                                                                        try {
                                                                              while (gVar.objRSKeywordsToExec.next()) {
                                                                                    s_objlog4j.info("ActionOrKeyword from keywords=" + gVar.objRSKeywordsToExec.getField("ActionOrKeyword"));
                                                                                    String[] g_arrParams = GenericUtilityLibrary.arrGetTestDataParams(gVar.objRSTestScenario, gVar.objRSKeywordsToExec);
                                                        
                                                        if(blnIsOnlyWebExecution){
                                                            library = new GenericWebObjectLibrary(this.driver, this.s_childExtentTest, this.gUtilLib);
                                                        }else if(blnIsMobileAndWebExecution){
                                                            if(GlobalVariables.g_RunLocal.equalsIgnoreCase("true")){
                                                                if(gVar.objRSKeywordsToExec.getField("ActionOrKeyword").contains("switchtoMobile")){
                                                                    //blnMobileExecutionFlag = true;
                                                                    library = new GenericWebObjectLibrary(this.mobileDriver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                                else if(gVar.objRSKeywordsToExec.getField("ActionOrKeyword").contains("switchtoPortal")){
                                                                    //blnMobileExecutionFlag=false;
                                                                    library = new GenericWebObjectLibrary(this.driver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                            }else{
                                                                if(gVar.objRSKeywordsToExec.getField("ActionOrKeyword").contains("switchtoMobile")){
                                                                    blnMobileExecutionFlag = true;
                                                                    library = new GenericWebObjectLibrary(this.mobileDriver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                                else if(gVar.objRSKeywordsToExec.getField("ActionOrKeyword").contains("switchtoPortal")){
                                                                    blnMobileExecutionFlag=false;
                                                                    library = new GenericWebObjectLibrary(this.driver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                            }
                                                        }else{
                                                            if(GlobalVariables.g_RunLocal.equalsIgnoreCase("true")){
                                                                if(gVar.objRSKeywordsToExec.getField("ActionOrKeyword").contains("switchtoMobile")){
                                                                    //blnMobileExecutionFlag = true;
                                                                    library = new GenericWebObjectLibrary(this.mobileDriver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                                else if(gVar.objRSKeywordsToExec.getField("ActionOrKeyword").contains("switchtoPortal")){
                                                                    //blnMobileExecutionFlag=false;
                                                                    library = new GenericWebObjectLibrary(this.driver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                                else{
                                                                    library = new GenericWebObjectLibrary(this.mobileDriver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                            }else{
                                                                if(gVar.objRSKeywordsToExec.getField("ActionOrKeyword").contains("switchtoMobile")){
                                                                    blnMobileExecutionFlag = true;
                                                                    library = new GenericWebObjectLibrary(this.mobileDriver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                                else if(gVar.objRSKeywordsToExec.getField("ActionOrKeyword").contains("switchtoPortal")){
                                                                    blnMobileExecutionFlag=false;
                                                                    library = new GenericWebObjectLibrary(this.driver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                                else{
                                                                    library = new GenericWebObjectLibrary(this.mobileDriver, this.s_childExtentTest, this.gUtilLib);
                                                                }
                                                            }
                                                        }
                                                        globalLibrary=library;
                                                        
                                                                                    isStepPass = blnWorkFlowExecute(globalLibrary,g_arrParams, g_arrintIterations, objRSTestSuite.getField("TestCaseID"), objRSTestData);
                                                                                    Arrays.fill(g_arrParams, null);
                                                                                    try {
                                                                                          Assert.assertTrue(isStepPass);
                                                                                    } catch (AssertionError e) {
                                                                                          ++resCount;
                                                                                          if (!isStepPass && strExecStatus.contentEquals("YS")) {
                                                                                                errorOccured = true;
                                                                                                break;
                                                                                          }
                                                                                    }
                                                                              }
                                                                        }catch(Exception e){
                                                                              if(handled && isStepPass){}
                                                                              else  {
                                                                                    errorOccured = true;
                                                                                    break;
                                                                              }
                                                                        }
                                                                        s_childExtentTest.setEndedTime(new Date());
                                                                  }
                                                                  //commented by greeshma
                                                            //}
                                                            /*s_childExtentTest.setEndedTime(new Date());
                                                            s_parentExtentTest.setEndedTime(new Date());
                                                            s_objExtentReport.endTest(s_parentExtentTest);
                                                            s_objExtentReport.flush();*/
                                                            if (!isStepPass && strExecStatus.contentEquals("YS")) {
                                                                  errorOccured = true;
                                                                  break;
                                                            }
                                                      }
                                                }
                                          }
                                    }
                                    closeDriver();
                                    
                                    if(GenericUtilityLibrary.getValueFromIniFile("START_TESTLINK", "g_Run").equalsIgnoreCase("true")){
                                          if(resCount > 0){
                                                ++testLinkStatusCounter;
                                          TestLinkRestAPI.reportResult(objRSTestSuite.getField("TestLink_ID"),"Fail");
                                          }else{
                                          TestLinkRestAPI.reportResult(objRSTestSuite.getField("TestLink_ID"),"Pass");
                                          }
                                    }
                                    
                                    if(GenericUtilityLibrary.getValueFromIniFile("START_TFS", "g_UpdateStatusInTFS").equalsIgnoreCase("true")){
                                          TFSRestAPI tfsAPI = new TFSRestAPI();
                                          if(resCount > 0){
                                                tfsAPI.updateTestCaseStatusInTFS("Fail");
                                          }else{
                                                tfsAPI.updateTestCaseStatusInTFS("Pass");
                                          }
                                    }
                                    
                                    s_childExtentTest.setEndedTime(new Date());
                                    if(GlobalVariables.g_updateResultsInRally){
                                          HashMap<String, String> info = new HashMap<String, String>();
                                          s_childExtentTest=s_objExtentReport.startTest("Update execution results in Rally");
                                          s_childExtentTest.setStartedTime( new Date());
                                          if (resCount > 0) {
                                                info = RallyRest.updateTCVerdict(objRSTestSuite.getField("TestCaseID"), "Fail"); 
                                                for(Map.Entry<String, String> entry : info.entrySet()){
                                                      String key = entry.getKey();
                                                      String value = entry.getValue();
                                                      if(value.equals("fail")) s_childExtentTest.log(LogStatus.WARNING, "Rally update", "Update of execution results failed for test case " + key);
                                                      else s_childExtentTest.log(LogStatus.PASS, "Rally update", "Execution results updated successfully for test case " + value);
                                                }
                                                s_childExtentTest.setEndedTime(new Date());
                                                s_parentExtentTest.appendChild(s_childExtentTest);
                                                //Assert.assertTrue(false); 
                                          } else {
                                                info =  RallyRest.updateTCVerdict(objRSTestSuite.getField("TestCaseID"), "Pass"); 
                                                for(Map.Entry<String, String> entry : info.entrySet()){
                                                      String key = entry.getKey();
                                                      String value = entry.getValue();
                                                      if(value.equals("fail")) s_childExtentTest.log(LogStatus.WARNING, "Rally update", "Update of execution results failed for test case " + key);
                                                      else s_childExtentTest.log(LogStatus.PASS, "Rally update", "Execution results updated successfully for test case " + value);
                                                }
                                                s_childExtentTest.setEndedTime(new Date());
                                                s_parentExtentTest.appendChild(s_childExtentTest);
                                          }
                                    }
                                    s_parentExtentTest.setEndedTime(new Date());
                                    s_objExtentReport.endTest(s_parentExtentTest);
                                    s_objExtentReport.flush();
                              }
                        } catch (Exception e) {
                              closeDriver(); //uncommented this line (31-03-2020)
                              errorOccured = true;
                              s_childExtentTest.setEndedTime(new Date());    
                              if(GlobalVariables.g_updateResultsInRally){
                                          HashMap<String, String> info = new HashMap<String, String>();
                                          s_childExtentTest=s_objExtentReport.startTest("Update execution results in Rally");
                                          s_childExtentTest.setStartedTime( new Date());
                                          if (resCount > 0) {
                                                info = RallyRest.updateTCVerdict(objRSTestSuite.getField("TestCaseID"), "Fail"); 
                                                for(Map.Entry<String, String> entry : info.entrySet()){
                                                      String key = entry.getKey();
                                                      String value = entry.getValue();
                                                      if(value.equals("fail")) s_childExtentTest.log(LogStatus.WARNING, "Rally update", "Update of execution results failed for test case " + key);
                                                      else s_childExtentTest.log(LogStatus.PASS, "Rally update", "Execution results updated successfully for test case " + value);
                                                }
                                                s_childExtentTest.setEndedTime(new Date());
                                                s_parentExtentTest.appendChild(s_childExtentTest);
                                                //Assert.assertTrue(false); 
                                          } else {
                                                info =  RallyRest.updateTCVerdict(objRSTestSuite.getField("TestCaseID"), "Pass"); 
                                                for(Map.Entry<String, String> entry : info.entrySet()){
                                                      String key = entry.getKey();
                                                      String value = entry.getValue();
                                                      if(value.equals("fail")) s_childExtentTest.log(LogStatus.WARNING, "Rally update", "Update of execution results failed for test case " + key);
                                                      else s_childExtentTest.log(LogStatus.PASS, "Rally update", "Execution results updated successfully for test case " + value);
                                                }
                                                s_childExtentTest.setEndedTime(new Date());
                                                s_parentExtentTest.appendChild(s_childExtentTest);
                                          }
                                    }
                              // isTestPass = false;
                        }
                        
                        if(errorOccured) sequentialfailureCount = sequentialfailureCount + 1;
                        else sequentialfailureCount = 0;    
                        }
                  }
                 /* if(GenericUtilityLibrary.getValueFromIniFile("START_JIRA", "g_UpdateStatusInJIRA").equalsIgnoreCase("true")){
                        JIRARestAPI jiraAPI = new JIRARestAPI();
                        if(testLinkStatusCounter==0){
                              jiraAPI.updateUserStoryInTFS("Done","31");
                        }else{
                              jiraAPI.updateUserStoryInTFS("In Progress","21");
                        }
                  }*/
                  //if(resCount > 0) {
                        //Assert.assertTrue(isStepPass);
                  //}
                  /*
                  * if (resCount > 0) {
                  * RallyRest.updateTCVerdict(objRSTestSuite.getField("TestCaseID"),
                  * "Fail"); Assert.assertTrue(false); } else
                  * RallyRest.updateTCVerdict(objRSTestSuite.getField("TestCaseID"),
                  * "Pass");
                  */
            } catch (Exception e) {
                  e.printStackTrace();
                  // Assert.assertTrue(isTestPass);
            } finally {
                  closeDriver();
                  s_parentExtentTest.setEndedTime(new Date());
                  s_objExtentReport.endTest(s_parentExtentTest);
                  s_objExtentReport.flush();
                  
                  if (terminateForSequentialFailure && sequentialfailureCount == GlobalVariables.g_terminateExecutionForSequentialFailureOf) GlobalVariables.g_reRunFailedTests = false;
                  if(GlobalVariables.g_reRunFailedTests) retrieveCountersFromFile(reportsLocation +File.separator + "donot-delete.txt", "read");
                  if(GlobalVariables.g_reRunFailedTests && counter < GlobalVariables.g_reRunIterations) {
                        failedTests = new ArrayList<String>();
                        getTestExecutionDetails(reportsLocation+File.separator + reportName);
                        if(failedTests.size() > 0 ) {
                                    String fileName = "", nameOfFile = "";
                                    File file = new File(reportsLocation + File.separator + reportName);
                                    String fileType = reportName.substring(reportName.indexOf("."), reportName.length());
                                    if(counter == 0) {
                                          nameOfFile = reportName.substring(0, reportName.indexOf("."))+ "-FirstRun";
                                          fileName = reportsLocation + File.separator + nameOfFile+fileType;
                                    } else {
                                          nameOfFile = reportName.substring(0, reportName.indexOf("."))+ "-Rerun";
                                          fileName = reportsLocation + File.separator + nameOfFile+String.valueOf(counter)+fileType;
                                    }
                                    File rnameFile = new File(fileName);
                                    if(rnameFile.exists())rnameFile.delete();
                                    file.renameTo(new File(fileName));
                                    counter = counter + 1;
                                    Execute();  
                        }
                  }
                  // Assert.assertTrue(isTestPass);
            }
      }

      public boolean blnWorkFlowExecuteFromStepsOFScript(String[] m_arrParams,
                  int m_intIteration, String strTCID, Recordset RSTestData) throws Exception {
            boolean blnRetValue = true;
            //GenericWebObjectLibrary genericObjectLib = new GenericWebObjectLibrary(GlobalVariables.driver, GlobalVariables.connection);
        GenericWebObjectLibrary genericObjectLib = new GenericWebObjectLibrary(this.driver, this.s_childExtentTest, this.gUtilLib);
            if (gVar.objRSTestScenario.getField(GlobalVariables.FunctionNameColHeader) != "Comment") {
                  // check if step needs to be executed or not
                  gVar.strKeywordExecStatus = gVar.objRSTestScenario.getField(GlobalVariables.ExecuteColHeader).toUpperCase();
                  if (gVar.strKeywordExecStatus.contentEquals("YC") || gVar.strKeywordExecStatus.contentEquals("YS")) {
                        gVar.g_strParamValues = GenericUtilityLibrary.strGetTestDataParamValues(RSTestData, m_arrParams,
                                    gVar.objRSTestScenario, m_intIteration, strTCID);
                        GlobalVariables.g_captureScreenShot = false;
                        GlobalVariables.g_strKeywordDescription = gVar.objRSTestScenario.getField(gVar.FunctionDescColHeader);
                        gVar.g_strFunction = gVar.objRSTestScenario.getField(GlobalVariables.FunctionNameColHeader).trim();
                        if (gVar.objRSTestScenario.getField(GlobalVariables.ObjectNameColHeader).contentEquals("")) {
                              blnRetValue = executeFunction(genericObjectLib, gVar.g_strFunction, gVar.g_strParamValues);
                        } else {
                              GlobalVariables.g_strLogicalName = gVar.objRSTestScenario
                                          .getField(GlobalVariables.ObjectNameColHeader);
                              blnRetValue = executeFunction(genericObjectLib, gVar.g_strFunction, gVar.g_strParamValues);
                        }
                        if(GlobalVariables.g_captureScreenShot && GlobalVariables.g_captureScreenShotsForPassedSteps) 
                        	captureScreenshotForPass(strTCID, gVar.g_strFunction);      
                        if (blnRetValue == false) {
                              if(GlobalVariables.driver != null){
                                    captureScreenshot(strTCID, gVar.g_strFunction);
                                    closeDriver();
                              }     
                        }
                  }
            }
            return blnRetValue;
      }
      
      public boolean blnWorkFlowExecute(GenericWebObjectLibrary genericObjectLib,String[] m_arrParams, int m_intIteration, String strTCID, Recordset RSTestData) throws Exception {
            boolean blnRetValue = true;
            //GenericWebObjectLibrary genericObjectLib = new GenericWebObjectLibrary(GlobalVariables.driver,  GlobalVariables.connection);
            
            if (gVar.objRSKeywordsToExec.getField(GlobalVariables.ActionColHeader) != "Comment") {
                  // check if step needs to be executed or not
                  gVar.strKeywordExecStatus = gVar.objRSKeywordsToExec.getField(GlobalVariables.ExecuteColHeader).toUpperCase();
                  if (gVar.strKeywordExecStatus.contentEquals("YC") || gVar.strKeywordExecStatus.contentEquals("YS")) {
                        gVar.g_strParamValues = GenericUtilityLibrary.strGetTestDataParamValues(RSTestData, m_arrParams,
                                    gVar.objRSKeywordsToExec, m_intIteration, strTCID);
                        GlobalVariables.g_strKeywordDescription = gVar.objRSKeywordsToExec.getField(gVar.StepDescColHeader);
                        // gVar.objRSKeywordsToExec.getField("StepDescription");
                        gVar.g_strFunction = gVar.objRSKeywordsToExec.getField(GlobalVariables.ActionColHeader).trim();
                        if(gVar.g_strFunction.contains("_")) {
                              Recordset rs =  queryTestKeywordSheetNestedFunctions(gVar.g_strFunction);
                              if(rs == null) {
                                          s_childExtentTest.log(LogStatus.FAIL, "Business Function '<b>" + gVar.g_strFunction + " </b>' is not valid/missing.","Read from excel failed due to exception");
                                          s_childExtentTest.setEndedTime(new Date());
                                          s_parentExtentTest.setEndedTime(new Date());
                                          s_objExtentReport.endTest(s_parentExtentTest);
                                    }
                              try { 
                                          while (rs.next()) {
                                                gVar.g_strParamValues = "";
                                                s_objlog4j.info("ActionOrKeyword from keywords=" + rs.getField(GlobalVariables.ActionColHeader));
                                                try{
                                                      String[] g_arrParamsNested = GenericUtilityLibrary.arrGetTestDataParams(rs);
                                                      if(g_arrParamsNested.length > 0) {
                                                            String[] arrParams = new String[g_arrParamsNested.length];
                                                            for (int i = 0; i < g_arrParamsNested.length; i++) {
                                                                  if(!g_arrParamsNested[i].trim().equals("")){
                                                                        String val = g_arrParamsNested[i];
                                                                        val = val.toLowerCase();
                                                                        val = val.replace("param", "");
                                                                        arrParams[i] =  m_arrParams[Integer.parseInt(val)-1];
                                                                  }
                                                            }
                                                            gVar.g_strParamValues = GenericUtilityLibrary.strGetTestDataParamValues(RSTestData, arrParams, gVar.objRSKeywordsToExec, m_intIteration, strTCID);
                                                      }
                                                }catch(Exception e){}
                                                if (rs.getField(GlobalVariables.ExecuteColHeader).toUpperCase().contentEquals("YC") || rs.getField(GlobalVariables.ExecuteColHeader).contentEquals("YS")) {
                                                      GlobalVariables.g_strKeywordDescription = rs.getField(gVar.StepDescColHeader);
                                                      GlobalVariables.g_captureScreenShot = false;
                                                      if (rs.getField(GlobalVariables.ObjectNameColHeader).contentEquals("")) {
                                                            blnRetValue = executeFunction(genericObjectLib, rs.getField("ActionOrKeyword"), gVar.g_strParamValues);
                                                      } else {
                                                            GlobalVariables.g_strLogicalName = rs.getField(GlobalVariables.ObjectNameColHeader);
                                                            blnRetValue = executeFunction(genericObjectLib, rs.getField("ActionOrKeyword"), gVar.g_strParamValues);
                                                      }
                                                      if(GlobalVariables.g_captureScreenShot && GlobalVariables.g_captureScreenShotsForPassedSteps) captureScreenshotForPass(strTCID, gVar.g_strFunction);      
                                                      if (blnRetValue == false) {
                                                            if (!(GlobalVariables.g_strBrowserType.equals("WS")))
                                                                  captureScreenshot(strTCID, rs.getField(GlobalVariables.ActionColHeader));
                                                            closeDriver();
                                                            break;
                                                      }
                                                }
                                          }
                                    }catch(Exception e){
                                          if(GlobalVariables.driver != null){
                                                captureScreenshot(strTCID, gVar.g_strFunction);
                                                closeDriver();
                                          }
                                          return false;
                                    }
                        
                        }else {
                              
                              GlobalVariables.g_captureScreenShot = false;
                              if (gVar.objRSKeywordsToExec.getField(GlobalVariables.ObjectNameColHeader).contentEquals("")) {
                                    blnRetValue = executeFunction(genericObjectLib, gVar.g_strFunction, gVar.g_strParamValues);
                              } else {
                                    GlobalVariables.g_strLogicalName = gVar.objRSKeywordsToExec
                                                .getField(GlobalVariables.ObjectNameColHeader);
                                    blnRetValue = executeFunction(genericObjectLib, gVar.g_strFunction, gVar.g_strParamValues);
                              }
                              if(GlobalVariables.g_captureScreenShot && GlobalVariables.g_captureScreenShotsForPassedSteps) 
                            	  captureScreenshotForPass(strTCID, gVar.g_strFunction);
                              if (blnRetValue == false) {
                                    if(GlobalVariables.driver != null){
                                          captureScreenshot(strTCID, gVar.g_strFunction);
                                          closeDriver();
                                    }
                              }
                        }
                  }
            }
            return blnRetValue;
      }

      @SuppressWarnings("finally")
      public boolean executeFunction(GenericWebObjectLibrary genericObjectLib, String method, String parameter)
                  throws Exception {
            boolean blnRetValue = false;

            try {
                  Class<?> c = Class.forName("com.org.proj.application.Script.GenericWebObjectLibrary");
                  // s_objlog4j.info("Loaded class: " + c);
                  s_objlog4j.info("parameter=" + parameter);
                  String[] words = parameter.split("~");
                  Class<?> par[] = new Class[words.length];
                  for (int i = 0; i < words.length; i++) {
                        par[i] = String.class;
                        // s_objlog4j.info("Word "+(i+1)+"="+words[i]);
                  }
                  Method myMethod;
                  Object o;
                  if (parameter.contentEquals("")) {
                        myMethod = c.getDeclaredMethod(method);
                        o = myMethod.invoke(genericObjectLib);
                  } else {
                        myMethod = c.getDeclaredMethod(method, par);
                        o = myMethod.invoke(genericObjectLib, (Object[]) words);
                  }

                  // s_objlog4j.info("Output: " + o);
                  if (o.toString().contentEquals("true")) {
                        blnRetValue = true;
                  }
            } catch (Exception e) {
                  e.printStackTrace();
            } finally {
                  return blnRetValue;
            }
      }

      public void initExcelFiles() {
            try {
                  /** Initialize all excel file path variables */
                   GlobalVariables.g_strRestBaseURI = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strRestBaseURI");
                  GlobalVariables.g_strSoapBaseURI = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strSoapBaseURI");
                  GlobalVariables.g_strSoapPort = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strSoapPort");
                  
                  
                  GlobalVariables.g_strAccessToken = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strAccessToken");

                  
                  
                  GlobalVariables.g_Application = GenericUtilityLibrary.getValueFromIniFile("START_EMAILS", "g_Application");
                  GlobalVariables.g_Domain = GenericUtilityLibrary.getValueFromIniFile("START_EMAILS", "g_Domain");
                  GlobalVariables.g_Mailusername = GenericUtilityLibrary.getValueFromIniFile("START_EMAILS", "g_Mailusername");
                  GlobalVariables.g_MailPaswword = GenericUtilityLibrary.getValueFromIniFile("START_EMAILS", "g_MailPaswword");
                  GlobalVariables.g_ExchageURI = GenericUtilityLibrary.getValueFromIniFile("START_EMAILS", "g_ExchageURI");
                  GlobalVariables.g_TO = GenericUtilityLibrary.getValueFromIniFile("START_EMAILS", "g_TO");
                  GlobalVariables.g_CC = GenericUtilityLibrary.getValueFromIniFile("START_EMAILS", "g_CC");
                  GlobalVariables.g_From = GenericUtilityLibrary.getValueFromIniFile("START_EMAILS", "g_From");
                  GlobalVariables.g_ReportType = GenericUtilityLibrary.getValueFromIniFile("START_EMAILS", "g_ReportType");
                  
                  
            
                  
                  GlobalVariables.g_reportsLocation = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strResultsFilePath");
                  
                  
                  GlobalVariables.g_updateResultsInRally = Boolean.parseBoolean(GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD", "g_updateResultsInRally"));
                  
                  
                  
                  GlobalVariables.g_triggerEmails = Boolean.parseBoolean(GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD", "g_triggerEmails"));
                  
                  GlobalVariables.g_reRunFailedTests = Boolean.parseBoolean(GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD", "g_reRunFailedTests"));
                  GlobalVariables.g_reRunIterations = Integer.parseInt(GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD", "g_reRunIterations"));
            
                  GlobalVariables.g_captureScreenShotsForPassedSteps = Boolean.parseBoolean(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_captureScreenShotsForPassSteps"));
                  GlobalVariables.g_terminateExecutionForSequentialFailureOf = Integer.parseInt(GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD", "g_terminateExecutionForSequentialFailureOf"));
                  
                  GlobalVariables.g_strRallyURL = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strRallyURL");
                  GlobalVariables.g_strRallyProxy = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strRallyProxy");
                  GlobalVariables.g_strRappyApiKey = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strRappyApiKey");
                  GlobalVariables.g_strControllerFilePath = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strControllersFilePath")
                              + GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strControllerFileName");
                  GlobalVariables.g_strTestDataFilePath = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strTestDataFilesPath")
                              + GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD", "g_strTestDataFileName");
                  GlobalVariables.g_strTestCaseFilePath = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strTestCasesFilePath")
                              + GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD", "g_strTestCaseFileName");
                  GlobalVariables.g_strControllerSheetName = GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD",
                              "g_strControllerSheetName");
                  GlobalVariables.g_strKeywordLibraryFilePath = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strKeywordLibraryFilesPath")
                              + GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD", "g_strKeywordLibraryFileName");
                  GlobalVariables.g_strObjectRepositoryFilePath = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strObjectRepositoryFilesPath")
                              + GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD", "g_strObjectRepositoryFileName");
                  GlobalVariables.g_strODBQAConnectionString = GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD",
                              "g_ODSDBODBCDataSource");
                  GlobalVariables.g_strODSQAUserID = GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD",
                              "g_ODSDBUserID");
                  GlobalVariables.g_strODSQAPwd = GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD",
                              "g_ODSDBPassword");
                  GlobalVariables.g_strClientId = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strClientId");
                  GlobalVariables.g_strClientSecret = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strClientSecret");
                  GlobalVariables.g_strAuthTokenUrl = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
                              "g_strAuthTokenURL");

                  
                  GlobalVariables.g_strIOSUDID = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE", "g_IOSUDID");
                  GlobalVariables.g_strIOSDeviceName = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_IOSDeviceName");
                  GlobalVariables.g_strIOSPlatformVersion = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_IOSPlatformVersion");
                  GlobalVariables.g_strIOSPlatformName = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_IOSPlatformName");
                  GlobalVariables.g_strIOSAppName = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE", "g_IOSAppName");
                  GlobalVariables.g_strIOSBrowserName = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_IOSBrowserName");
                  GlobalVariables.g_strAndroidBrowserName = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_AndroidBrowserName");
                  GlobalVariables.g_strAndroidPlatformName = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_AndroidPlatformName");
                  GlobalVariables.g_strAndroidPlatformVersion = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_AndroidPlatformVersion");
                  GlobalVariables.g_strAndroidDeviceName = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_AndroidDeviceName");
                  GlobalVariables.g_strAndroidDeviceName = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_AndroidDeviceUDID");
                  GlobalVariables.g_strAndroidAppName = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_AndroidAppName");
                  GlobalVariables.g_strAndroidSdkPath = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_AndroidSdkPath");
                  GlobalVariables.g_strCreateMember = GenericUtilityLibrary.getValueFromIniFile("START_DEVICE",
                              "g_CreateMember");
                  GlobalVariables.g_SQLConnectionURL = GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD",
                              "g_SQLConnectionURL");
                  GlobalVariables.g_ODSDBODBCDataSource = GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD",
                              "g_ODSDBODBCDataSource");
                  GlobalVariables.g_ODSDBUserID = GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD",
                              "g_ODSDBUserID");
                  GlobalVariables.g_ODSDBPassword = GenericUtilityLibrary.getValueFromIniFile("START_EDM_PREPROD",
                              "g_ODSDBPassword");

            GlobalVariables.g_RunLocal=GenericUtilityLibrary.getValueFromIniFile("START_PCLOUDY", "g_RunLocal");
            GlobalVariables.g_pcloudyEnvironment=GenericUtilityLibrary.getValueFromIniFile("START_PCLOUDY", "g_pcloudyEnvironment");
            GlobalVariables.g_pcloudyUserId=GenericUtilityLibrary.getValueFromIniFile("START_PCLOUDY", "g_pcloudyUserId");
            GlobalVariables.g_pcloudyIndUrl=GenericUtilityLibrary.getValueFromIniFile("START_PCLOUDY", "g_pcloudyIndUrl");
            GlobalVariables.g_pcloudyUsaUrl=GenericUtilityLibrary.getValueFromIniFile("START_PCLOUDY", "g_pcloudyUsaUrl");
            GlobalVariables.g_pcloudyPublicUrl=GenericUtilityLibrary.getValueFromIniFile("START_PCLOUDY", "g_pcloudyPublicUrl");
            GlobalVariables.g_pcloudyIndApiKey=GenericUtilityLibrary.getValueFromIniFile("START_PCLOUDY", "g_pcloudyIndApiKey");
            GlobalVariables.g_pcloudyUsaApiKey=GenericUtilityLibrary.getValueFromIniFile("START_PCLOUDY", "g_pcloudyUsaApiKey");
            GlobalVariables.g_pcloudyPublicKey=GenericUtilityLibrary.getValueFromIniFile("START_PCLOUDY", "g_pcloudyPublicKey");
            

            } catch (Exception e) {
                  e.printStackTrace();
            }
      }
      
      public void captureScreenshotForPass(String testCaseId, String actionName) throws Exception {
    	  
           String location = reportsLocation.substring(reportsLocation.indexOf("\\reports"), reportsLocation.length());
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMMddHHmms");// dd/MM/yyyy
            Date now = new Date();
            String strDate = sdfDate.format(now);
            File scrFile = ((TakesScreenshot) GlobalVariables.driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(reportsLocation + File.separator + "screenshots" + File.separator+ testCaseId + strDate + ".png");
            FileUtils.copyFile(scrFile, destFile);
            location = "\\" + location.substring(1, location.length());
            s_childExtentTest.log(LogStatus.PASS, "Image Captured",s_childExtentTest.addScreenCapture(".\\screenshots\\" + testCaseId + strDate + ".png"));
      }
      
      public void captureScreenshot(String testCaseId, String actionName) throws Exception {
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMMddHHmms");// dd/MM/yyyy
        File scrFile = null;
        File destFile;
        String base64 = null;
            Date now = new Date();
            String strDate = sdfDate.format(now);
        if(blnMobileExecutionFlag) {
            scrFile = pCloudySession.takeScreenshot();
            destFile = new File("reports" + File.separator + "screenshots", scrFile.getName());
        }else{
            scrFile = ((TakesScreenshot) GlobalVariables.driver).getScreenshotAs(OutputType.FILE);
            destFile = new File("reports" + File.separator + "screenshots" + File.separator + testCaseId + strDate + ".png");
        }
            FileUtils.copyFile(scrFile, destFile);
            //s_childExtentTest.log(LogStatus.FAIL, "Image Captured",      s_childExtentTest.addScreenCapture(".\\screenshots\\" + testCaseId + strDate + ".png"));
        s_childExtentTest.log(LogStatus.FAIL, "Image Captured", s_childExtentTest.addScreenCapture(destFile.getAbsolutePath()));
        //s_childExtentTest.log(LogStatus.FAIL, "Image Captured", s_childExtentTest.addBase64ScreenShot(base64));
      }

      @SuppressWarnings({ "rawtypes", "static-access" })
    public void openDriver(String browser) {
        
            try {
                  switch (typeOfBrowser.valueOf(browser)) {
                  case Firefox:
                blnIsOnlyWebExecution=true;
                        s_objlog4j.info("FF is selected");
                    
                        FirefoxProfile profile = new FirefoxProfile();
                        
                driver = new FirefoxDriver(profile);

                driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                    
                        break;
                  case Chrome:
                blnIsOnlyWebExecution=true;
                        s_objlog4j.info("Google chrome is selected");
                  System.setProperty("webdriver.chrome.driver",GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "webdriver.chrome.driver"));

                        HashMap<String, Object> prefs = new HashMap<String, Object>();
                      //  prefs.put("download.default_directory", "C:\\ABC\\DEF\\SELENIUMFRAMEWORK\\downloads");
                     //   prefs.put("download.default_directory", "D:\\Cytel_Automation\\eAutomation-master\\Selenium\\downloadCsv");
                        DesiredCapabilities caps = DesiredCapabilities.chrome();
                       String BrowserName = caps.getBrowserName();
                        s_objExtentReport.addSystemInfo("Browser Name", BrowserName);
                        

                        ChromeOptions options = new ChromeOptions();
                        options.setExperimentalOption("prefs", prefs);
                        options.addArguments("--test-type");
                        //options.addArguments("--start-maximized");
                        options.addArguments("start-fullscreen");

                        caps.setCapability(ChromeOptions.CAPABILITY, options);
                        // options.setExperimentalOption("prefs", prefs);
                        
                        driver = new ChromeDriver(caps);
                        Thread.sleep(3000);
                     //   Dimension dim=driver.manage().window().getSize();
                       // System.out.println(dim);
                        //s_objExtentReport.addSystemInfo("Display Resolution",dim.toString());
                        
                       
                        break;
                  case IE:
                blnIsOnlyWebExecution=true;
                s_objlog4j.info("Internet Explorer is selected");
                System.setProperty("webdriver.ie.driver", GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "webdriver.ie.driver"));
                DesiredCapabilities dcie = DesiredCapabilities.internetExplorer();
                dcie.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                driver = new InternetExplorerDriver(dcie);
                driver.manage().window().maximize();
                break;
                    
                case Firefox_Android:
                    blnIsMobileAndWebExecution=true;
                    s_objlog4j.info("Android is selected");
                    if (GlobalVariables.g_RunLocal.equalsIgnoreCase("true")) {
                        //runExecutionOnPCloudy();
                        classpathRoot = new File(System.getProperty("user.dir"));
                        appDir = new File(classpathRoot, "src/test/resources/Apps/");
                        app = new File(appDir, GlobalVariables.g_strAndroidAppName);
                        capabilities.setCapability(CapabilityType.BROWSER_NAME, GlobalVariables.g_strAndroidBrowserName);
                        capabilities.setCapability("platformVersion", GlobalVariables.g_strAndroidPlatformVersion);
                        capabilities.setCapability("deviceName", GlobalVariables.g_strAndroidDeviceName);
                        capabilities.setCapability("platformName", GlobalVariables.g_strAndroidPlatformName);
                        capabilities.setCapability(MobileCapabilityType.UDID, GlobalVariables.g_strAndroidUDID);
                        // capabilities.setCapability("fullReset",true);
                        capabilities.setCapability("newCommandTimeout", 50000);
                        capabilities.setCapability("unicodeKeyboard", true);
                        capabilities.setCapability("resetKeyboard", true);
                        capabilities.setCapability("app", app.getAbsolutePath());
                       
                        capabilities.setCapability("appPackage", "com.sec.android.app.shealth");
                        capabilities.setCapability("appActivity", "com.sec.android.app.shealth.SplashScreenActivity");
                        //capabilities.setCapability("autoWebview", "true");
                    } else {
                        runExecutionOnPCloudy("Android");
                        capabilities.setCapability("newCommandTimeout", 600);
                        capabilities.setCapability("launchTimeout", 90000);
                        capabilities.setCapability("deviceName", aDevice.capabilities.deviceName);
                        capabilities.setCapability("browserName", aDevice.capabilities.browserName);
                        capabilities.setCapability("platformName", "Android");
                        
                        capabilities.setCapability("appPackage", "com.sec.android.app.shealth");
                        capabilities.setCapability("appActivity", "com.sec.android.app.shealth.SplashScreenActivity");
                        capabilities.setCapability("unicodeKeyboard", true);
                        capabilities.setCapability("resetKeyboard", true);
                        capabilities.setCapability("automationName", "uiautomator2");
                        capabilities.setCapability("systemPort", new Random().nextInt(2000) + 1024);
                        capabilities.setCapability("rotatable", true);
                        if (aDevice.getVersion().compareTo(new Version("9.3")) >= 0)
                            capabilities.setCapability("automationName", "XCUITest");
                        else
                            capabilities.setCapability("automationName", "Appium");
                    }
                    Thread.sleep(5000);
                    mobileDriver = new AndroidDriver(gVar.g_strAppiumServerURL, capabilities);
                    
                    
                    FirefoxProfile profile1 = new FirefoxProfile();
                    
                    driver = new FirefoxDriver(profile1);
                    
                    driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    
                    break;
                    
            case Android:
                    blnIsOnlyWebExecution=false;
                    s_objlog4j.info("Android is selected");
                    if (GlobalVariables.g_RunLocal.equalsIgnoreCase("true")) {
                        classpathRoot = new File(System.getProperty("user.dir"));
                        appDir = new File(classpathRoot, "src/test/resources/Apps/");
                        app = new File(appDir, GlobalVariables.g_strAndroidAppName);
                        capabilities.setCapability(CapabilityType.BROWSER_NAME, GlobalVariables.g_strAndroidBrowserName);
                        capabilities.setCapability("platformVersion", GlobalVariables.g_strAndroidPlatformVersion);
                        capabilities.setCapability("deviceName", GlobalVariables.g_strAndroidDeviceName);
                        capabilities.setCapability("platformName", GlobalVariables.g_strAndroidPlatformName);
                        capabilities.setCapability(MobileCapabilityType.UDID, GlobalVariables.g_strAndroidUDID);
                        // capabilities.setCapability("fullReset",true);
                        capabilities.setCapability("newCommandTimeout", 50000);
                        capabilities.setCapability("unicodeKeyboard", true);
                        capabilities.setCapability("resetKeyboard", true);
                        capabilities.setCapability("app", app.getAbsolutePath());
                        //capabilities.setCapability("autoWebview", "true");
                    } else {
                        runExecutionOnPCloudy("Android");
                        blnMobileExecutionFlag=true;
                        capabilities.setCapability("newCommandTimeout", 600);
                        capabilities.setCapability("launchTimeout", 90000);
                        capabilities.setCapability("deviceName", aDevice.capabilities.deviceName);
                        capabilities.setCapability("browserName", aDevice.capabilities.browserName);
                        capabilities.setCapability("platformName", "Android");
                         capabilities.setCapability("unicodeKeyboard", true);
                        capabilities.setCapability("resetKeyboard", true);
                        capabilities.setCapability("automationName", "uiautomator2");
                        capabilities.setCapability("systemPort", new Random().nextInt(2000) + 1024);
                        capabilities.setCapability("rotatable", true);
                        if (aDevice.getVersion().compareTo(new Version("9.3")) >= 0)
                            capabilities.setCapability("automationName", "XCUITest");
                        else
                            capabilities.setCapability("automationName", "Appium");
                    }
                    driver = new AndroidDriver(gVar.g_strAppiumServerURL, capabilities);
                    
                    
                    break;
                    
                case Firefox_iOS:
                    blnIsMobileAndWebExecution=true;
                    s_objlog4j.info("iOS is selected");
                    
                    if (GlobalVariables.g_RunLocal.equalsIgnoreCase("true")) {
                        //runExecutionOnPCloudy();
                        classpathRoot = new File(System.getProperty("user.dir"));
                        appDir = new File(classpathRoot, "src/test/resources/Apps/");
                        app = new File(appDir, GlobalVariables.g_strIOSAppName);
                        capabilities.setCapability(CapabilityType.BROWSER_NAME, GlobalVariables.g_strIOSBrowserName);
                        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, GlobalVariables.g_strIOSDeviceName);
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, GlobalVariables.g_strIOSPlatformVersion);
                        capabilities.setCapability(MobileCapabilityType.UDID, GlobalVariables.g_strIOSUDID);
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, GlobalVariables.g_strIOSPlatformName);
                         capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                        capabilities.setCapability("startIWDP",true);
                    } else {
                        runExecutionOnPCloudy("iOS");
                       capabilities.setCapability("usePrebuiltWDA", false);
                        capabilities.setCapability("acceptsAlerts", true);
                        capabilities.setCapability("newCommandTimeout", 600);
                        capabilities.setCapability("launchTimeout", 90000);
                        capabilities.setCapability("platformName", "ios");
                        capabilities.setCapability("deviceName", aDevice.capabilities.deviceName);
                        capabilities.setCapability("browserName", aDevice.capabilities.browserName);
                        if (aDevice.getVersion().compareTo(new Version("9.3")) >= 0)
                            capabilities.setCapability("automationName", "XCUITest");
                        else
                            capabilities.setCapability("automationName", "Appium");
                        
                    }
                    //driver = new IOSDriver(gVar.g_strAppiumServerURL, capabilities);
                    
                    mobileDriver = new IOSDriver(gVar.g_strAppiumServerURL, capabilities);
                    
                    /*FirefoxProfile profile2 = new FirefoxProfile();
                     
                     driver = new FirefoxDriver(profile2);
                     */
                    s_objlog4j.info("Google chrome is selected");
                    System.setProperty("webdriver.chrome.driver", GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "webdriver.chrome.driver"));
                    
                    DesiredCapabilities caps1 = DesiredCapabilities.chrome();
                    
                    ChromeOptions options1 = new ChromeOptions();
                    //options.setExperimentalOption("prefs", prefs);
                    caps1.setCapability(ChromeOptions.CAPABILITY, options1);
                    // options.setExperimentalOption("prefs", prefs);
                    options1.addArguments("--test-type");
                   // options1.addArguments("start-maximized");
                    options1.addArguments("window-size=800,480");
                    driver = new ChromeDriver(caps1);
                    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    
                    break;

            case iOS:
                    s_objlog4j.info("iOS is selected");
                    blnIsOnlyWebExecution=false;
                    if (GlobalVariables.g_RunLocal.equalsIgnoreCase("true")) {
                        classpathRoot = new File(System.getProperty("user.dir"));
                        appDir = new File(classpathRoot, "src/test/resources/Apps/");
                        app = new File(appDir, GlobalVariables.g_strIOSAppName);
                        capabilities.setCapability(CapabilityType.BROWSER_NAME, GlobalVariables.g_strIOSBrowserName);
                        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, GlobalVariables.g_strIOSDeviceName);
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, GlobalVariables.g_strIOSPlatformVersion);
                        capabilities.setCapability(MobileCapabilityType.UDID, GlobalVariables.g_strIOSUDID);
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, GlobalVariables.g_strIOSPlatformName);
                        // capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                        capabilities.setCapability("startIWDP",true);
                    } else {
                        runExecutionOnPCloudy("iOS");
                        blnMobileExecutionFlag=true;
                        capabilities.setCapability("usePrebuiltWDA", false);
                        capabilities.setCapability("acceptsAlerts", true);
                        capabilities.setCapability("newCommandTimeout", 600);
                        capabilities.setCapability("launchTimeout", 90000);
                        capabilities.setCapability("platformName", "ios");
                        capabilities.setCapability("deviceName", aDevice.capabilities.deviceName);
                        capabilities.setCapability("browserName", aDevice.capabilities.browserName);
                        if (aDevice.getVersion().compareTo(new Version("9.3")) >= 0)
                            capabilities.setCapability("automationName", "XCUITest");
                        else
                            capabilities.setCapability("automationName", "Appium");
                        
                    }
                    driver = new IOSDriver(gVar.g_strAppiumServerURL, capabilities);
                    // driver=driver1;
                    // Thread.sleep(10000);
                    break;

                  case iOSSafari:
                        s_objlog4j.info("iOS Safari is selected");
                        classpathRoot = new File(System.getProperty("user.dir"));
                        appDir = new File(classpathRoot, "src/test/resources/Apps/");
                        app = new File(appDir, GlobalVariables.g_strIOSAppName);
                        capabilities.setCapability(CapabilityType.BROWSER_NAME, GlobalVariables.g_strIOSBrowserName);
                        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, GlobalVariables.g_strIOSDeviceName);
                      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                                    GlobalVariables.g_strIOSPlatformVersion);
                        capabilities.setCapability(MobileCapabilityType.UDID, GlobalVariables.g_strIOSUDID);
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, GlobalVariables.g_strIOSPlatformName);
                        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                       capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                        //GlobalVariables.driver = new IOSDriver(new URL(GlobalVariables.g_strAppiumServerURL), capabilities);
                        break;

                  case AndroidChrome:
                        s_objlog4j.info("Android Google chrome is selected");
                        DesiredCapabilities capabilitiesAndrChrome = new DesiredCapabilities();
                        capabilitiesAndrChrome.setCapability("browserName", GlobalVariables.g_strAndroidBrowserName);
                        // capabilities.setCapability(CapabilityType.BROWSER_NAME,
                        // "Browser");
                        capabilitiesAndrChrome.setCapability("platformVersion", GlobalVariables.g_strAndroidPlatformVersion);
                        capabilitiesAndrChrome.setCapability("deviceName", GlobalVariables.g_strAndroidDeviceName);
                        
                        capabilitiesAndrChrome.setCapability("platformName", GlobalVariables.g_strAndroidPlatformName);
                        capabilitiesAndrChrome.setCapability("newCommandTimeout", "1000");
                        //GlobalVariables.driver = new AndroidDriver(new URL(GlobalVariables.g_strAppiumServerURL), capabilitiesAndrChrome);
                        // driver=driver1;
                        break;
                  case WS:
                blnIsOnlyWebExecution=true;
                        s_objlog4j.info("WS is selected");
               driver = new HtmlUnitDriver();
                        break;
                  
                  default:
                break;

                  }
            } catch (MalformedURLException e) {
                  e.printStackTrace();
            } catch (InterruptedException e) {
                  e.printStackTrace();
            } catch (Exception e) {
                  e.printStackTrace();
            }

      }

    public void closeDriver() {
     if (driver != null)
            driver.quit(); 
        if(mobileDriver!=null)mobileDriver.quit();
        /*else
            s_objlog4j.info("Driver is not launched");*/
    }

      public Recordset queryTestControllerSheet() throws Exception {
            String g_strControllerSql = "Select * from " + GlobalVariables.g_strControllerSheetName + " where Run='YES'";

            s_objlog4j.info(g_strControllerSql);

            return GenericUtilityLibrary.readFromExcel(GlobalVariables.g_strControllerFilePath, g_strControllerSql);

      }

      public Recordset queryTestDataSheet(Recordset objRSTestSuite) throws Exception {
            /** Get the Test data Sheet Name */
            String strTestDataSheetName = objRSTestSuite.getField("TestScriptName").split("_")[0];

            /**
            * build the query for the test data
            */

            String g_strTestDataSql = "Select * from " + strTestDataSheetName + " where TCID='"
                        + objRSTestSuite.getField("TestCaseID") + "'";
            s_objlog4j.info(g_strTestDataSql);

            /**
            * return the Recordset for the Test data Sheet
            */

            return GenericUtilityLibrary.readFromExcel(GlobalVariables.g_strTestDataFilePath, g_strTestDataSql);

      }

      public Recordset queryTestScriptSheet(Recordset objRSTestSuite) throws Exception {
            /** Get the Scenario Sheet Name */
            String strScenarioSheetName = objRSTestSuite.getField("TestScriptName").split("_")[0];

            /**
            * build the query for the scenario controller
            */
            String g_strScenarioSql = "Select * from " + strScenarioSheetName + " where TestCaseID='"
                        + objRSTestSuite.getField("TestCaseID") + "'";

            s_objlog4j.info(g_strScenarioSql);

            /**
            * return the Recordset for the Test Scenario Sheet
            */
            return GenericUtilityLibrary.readFromExcel(GlobalVariables.g_strTestCaseFilePath, g_strScenarioSql);

      }

      public Recordset queryTestKeywordSheetNestedFunctions(String functionName) throws Exception {
            /** Get the keyword Sheet Name */
            
            String strKeywordSheetName = functionName.split("_")[0];
            String g_strKeywordSql = "Select * from " + strKeywordSheetName + " where FunctionName='" + functionName + "'";
            s_objlog4j.info("Keyword sql=" + g_strKeywordSql);
            Recordset rs = null;
            try{
                  rs = GenericUtilityLibrary.readFromExcel(gVar.g_strKeywordLibraryFilePath, g_strKeywordSql);
            }catch(Exception e){
            }
            return rs;
      }
      
      public Recordset queryTestKeywordSheet() throws Exception {
            /** Get the keyword Sheet Name */

            String strKeywordSheetName = gVar.objRSTestScenario.getField(GlobalVariables.FunctionNameColHeader)
                        .split("_")[0];
            String g_strKeywordSql = "Select * from " + strKeywordSheetName + " where FunctionName='"
                        + gVar.objRSTestScenario.getField("FunctionName") + "'";

            s_objlog4j.info("Keyword sql=" + g_strKeywordSql);
            Recordset rs = null;
            try{
                  rs = GenericUtilityLibrary.readFromExcel(GlobalVariables.g_strKeywordLibraryFilePath, g_strKeywordSql);
            }catch(Exception e){

            }
            return rs;

      }
    public void runExecutionOnPCloudy(String strDeviceType) throws Exception {
        // User Authentication over pCloudy
        File fileToBeUploaded;
        if(GlobalVariables.g_pcloudyEnvironment.equalsIgnoreCase("India")){
            con = new Connector(GlobalVariables.g_pcloudyIndUrl);
            authToken = con.authenticateUser(GlobalVariables.g_pcloudyUserId, GlobalVariables.g_pcloudyIndApiKey);
        }
        else{
            con = new Connector(GlobalVariables.g_pcloudyUsaUrl);
            authToken = con.authenticateUser(GlobalVariables.g_pcloudyUserId, GlobalVariables.g_pcloudyUsaApiKey);
        }
        ArrayList<MobileDevice> selectedDevices = new ArrayList<MobileDevice>();
        // Populate the selected Devices here
        // selectedDevices.add(MobileDevice.getNew("Samsung_GalaxyE7_Android_5.1.1", 143, "GalaxyE7", "Galaxy E7", "android", "5.1.1", "Samsung")); // For hard coding the device
        /*
         * if ("".equalsIgnoreCase(System.getenv("pCloudy_Devices"))) { // To select multiple devices manually, use either of these: selectedDevices.addAll(con.chooseMultipleDevices(authToken,
         * "android")); // selectedDevices.addAll(CloudyCONNECTOR.chooseSingleDevice(authToken, "android"));
         *
         * } else { System.out.println("Running from Jenkins"); selectedDevices.addAll(con.chooseDevicesFromArrayOfFullNames(authToken, "android", System.getenv("pCloudy_Devices").split(","))); }
         */
        
        //Select device based on requirement
        if(strDeviceType.equalsIgnoreCase("Android")){
            selectedDevices.addAll(con.chooseMultipleDevices(authToken, "Android"));
        }else{
            selectedDevices.addAll(con.chooseMultipleDevices(authToken, "iOS"));
        }
        
        String sessionName = selectedDevices.get(0).display_name + " Appium Session";
        BookingDtoDevice[] bookedDevices = con.AppiumApis().bookDevicesForAppium(authToken, selectedDevices,5, sessionName);
        
        // Book the selected devices in pCloudy
        s_objlog4j.info("Devices booked successfully");
        System.out.println("Devices booked successfully");
        
        // Select apk in pCloudy Cloud Drive
        
        if(strDeviceType.equalsIgnoreCase("Android")){
           
            fileToBeUploaded = new File("./"+GlobalVariables.g_strAndroidAppName);
        }else{
            fileToBeUploaded = new File("./"+GlobalVariables.g_strIOSAppName);
        }
         
        PDriveFileDTO alreadyUploadedApp = con.getAvailableAppIfUploaded(authToken, fileToBeUploaded.getName());
        
        if (alreadyUploadedApp == null) {
            System.out.println("Uploading App: " + fileToBeUploaded.getAbsolutePath());
            s_objlog4j.info("Uploading App: " + fileToBeUploaded.getAbsolutePath());
            PDriveFileDTO uploadedApp = con.uploadApp(authToken, fileToBeUploaded, false);
            System.out.println("App uploaded");
            s_objlog4j.info("App uploaded");
            alreadyUploadedApp = new PDriveFileDTO();
            alreadyUploadedApp.file = uploadedApp.file;
        } else {
            System.out.println(" App already present. Not uploading... ");
            s_objlog4j.info("App already present. Not uploading...");
        }
        
        
        con.AppiumApis().initAppiumHubForApp(authToken, alreadyUploadedApp);
        
        URL endpoint = con.AppiumApis().getAppiumEndpoint(authToken);
        System.out.println("Appium Endpoint: " + endpoint);
        s_objlog4j.info("Appium Endpoint: " + endpoint);
        gVar.g_strAppiumServerURL= endpoint;
        
        URL reportFolderOnPCloudy = con.AppiumApis().getAppiumReportFolder(authToken);
        System.out.println("Report Folder: " + reportFolderOnPCloudy);
        s_objlog4j.info("Report Folder: " + reportFolderOnPCloudy);
        List<Thread> allThreads = new ArrayList<Thread>();
        MultipleRunReport multipleReports = new MultipleRunReport();
        
        aDevice = bookedDevices[0];
        pCloudySession = new PCloudyAppiumSession(con, authToken, aDevice);
        
        
        
    }
      /**
      * initializeDB method cleans up DB and initialize before test cases execution
      * @param envName
      *            This describes the environment name to connect corresponding DB
      * @return Void This methods does not return any thing
      * @author Serath Gorantla
      */
      public void initializeDB() throws Exception{
            try{
            //Class.forName(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBDriverClass"));                
                  gVar.DBURL=GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBUrl");
                  gVar.DBUserName=GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBUserID");
                  gVar.DBPassword=GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBPassword");                    
            }catch(Exception e){
                  e.printStackTrace();
            }
      }

}

