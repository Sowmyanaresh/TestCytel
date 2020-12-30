package com.org.proj.application.Script;

import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import org.ini4j.Wini;

public class GenericUtilityLibrary
  extends Driver
{
  public static String getValueFromIniFile(String sectionName, String keyName)
    throws Exception
  {
    Wini ini = new Wini(new File("../Resources/autotst_Selenium.ini"));
    String value = (String)ini.get(sectionName, keyName, String.class);
    return value;
  }
  
  public static Recordset readFromExcel(String m_strExcelFileName, String g_strControllerSql)
    throws Exception
  {
    Recordset recordset = null;
    try
    {
      Fillo fillo = new Fillo();
      s_objlog4j.info("Excel file path=" + m_strExcelFileName);
      Connection connection = fillo.getConnection(m_strExcelFileName);
      
      recordset = connection.executeQuery(g_strControllerSql);
    }
    catch (Exception e)
    {
    	s_objextendTest.log(LogStatus.ERROR, "readFromExcel", "readFromExcel has thrown exception");
      e.printStackTrace();
    }
    return recordset;
  }
  
  public static Recordset readFromExcelFromSpecRow(String m_strExcelFileName, String g_strControllerSql, String RowNumber)
    throws Exception
  {
    Recordset recordset = null;
    try
    {
      System.setProperty("ROW", RowNumber);
      Fillo fillo = new Fillo();
      s_objlog4j.info("Excel file path=" + m_strExcelFileName);
      Connection connection = fillo.getConnection(m_strExcelFileName);
      
      recordset = connection.executeQuery(g_strControllerSql);
    }
    catch (Exception e)
    {
    	s_objextendTest.log(LogStatus.ERROR, "readFromExcel", "readFromExcel has thrown exception");
      e.printStackTrace();
    }
    return recordset;
  }
  
  public static void updateExcel(String m_strExcelFileName, String g_strControllerSql)
    throws Exception
  {
    try
    {
      Fillo fillo = new Fillo();
      s_objlog4j.info("Excel file path=" + m_strExcelFileName);
      Connection connection = fillo.getConnection(m_strExcelFileName);
      connection.executeUpdate(g_strControllerSql);
    }
    catch (Exception e)
    {
    	s_objextendTest.log(LogStatus.ERROR, "updateExcel", "updateExcel has thrown exception");
      e.printStackTrace();
    }
  }
  
  public static enum typeOfBrowser
  {
    IE,  FIREFOX,  CHROME,  WS, ANDROID, IOS, FIREFOX_ANDROID, FIREFOX_IOS ;
  }
  
  public static String[] arrGetBrowsers(String m_strBrowsers)
    throws Exception
  {
    String[] arrTempValues = m_strBrowsers.split(",");
    String strBrowserType = null;
    for (int intCounter = 0; intCounter < arrTempValues.length; intCounter++)
    {
      switch (typeOfBrowser.valueOf(arrTempValues[intCounter].toUpperCase()))
      {
      case IE: 
        strBrowserType = "iexplore";
        break;
      case FIREFOX: 
        strBrowserType = "firefox";
        break;
      case CHROME: 
        strBrowserType = "chrome";
      case ANDROID: 
          strBrowserType = "Android";
      case IOS: 
          strBrowserType = "iOS";
      case WS:
          strBrowserType = "WS";
      case FIREFOX_ANDROID:
          strBrowserType = "Firefox_Android";
      case FIREFOX_IOS:
          strBrowserType = "Firefox_iOS";
      }
      arrTempValues[intCounter] = strBrowserType;
    }
    return arrTempValues;
  }
  
  
  
  
  	public static String[] arrGetTestDataParams(Recordset m_rsTestScenario)
		    throws Exception
		  {
		    String strTempValue = "";
		    String[] arrTempValues = null;
		    String strParam = "#";
		    try
		    {
		      for (int intCounters = 0; intCounters <= 9; intCounters++)
		      {
		        strTempValue = m_rsTestScenario.getField("Param" + Integer.toString(intCounters + 1));
		        if (!strTempValue.contentEquals("")) {
		          strParam = strParam + "," +strTempValue;
		        }
		      }
		      arrTempValues = strParam.replace("#,", "").replace("#", "").split(",");
		    }
		    catch (Exception e)
		    {
		    	s_objextendTest.log(LogStatus.ERROR, "arrGetTestDataParams", GlobalVariables.g_strStepDescription);
		      e.printStackTrace();
		    }
		    return arrTempValues;
		  }
  
  
  
  
  
  public static String[] arrGetTestDataParams(Recordset m_rsTestScenario, Recordset m_rsKeywordData)
    throws Exception
  {
    String strTempValue = "";
    String[] arrTempValues = null;
    String strParam = "#";
    try
    {
      for (int intCounters = 0; intCounters <= 9; intCounters++)
      {
        strTempValue = m_rsKeywordData.getField("Param" + Integer.toString(intCounters + 1));
        if (!strTempValue.contentEquals("")) {
          strParam = strParam + "," + m_rsTestScenario.getField(strTempValue);
        }
      }
      arrTempValues = strParam.replace("#,", "").replace("#", "").split(",");
    }
    catch (Exception e)
    {
    	s_objextendTest.log(LogStatus.ERROR, "arrGetTestDataParams", GlobalVariables.g_strStepDescription);
      e.printStackTrace();
    }
    return arrTempValues;
  }
  
  public static String strGetTestDataParamValuesNested(Recordset rsTestData, String[] m_arrTestParams, int m_intIteration, String strTCID)
		    throws Exception {
	  	String strTestData = "#";
	    
	   
	    String strTempValue = "";
	    try
	    {
	      for (int intCounter = 0; intCounter < m_arrTestParams.length; intCounter++) {
	        if (!m_arrTestParams[intCounter].contentEquals(""))
	        {
	          
	         // while (rsTestData.next())
	        //  {
	            strTempValue = rsTestData.getField(m_arrTestParams[intCounter]);
	            if (strTempValue.contentEquals("")) {
	              strTestData = strTestData + "~";
	            } else {
	              strTestData = strTestData + "~" + strTempValue;
	           // }
	          }
	        }
	        else
	        {
	          strTestData = strTestData + "~";
	        }
	      }
	      strTestData = strTestData + "~#";
	      
	      strTestData = strTestData.replace("#~", "").replace("~#", "").replace("#", "");
	      s_objlog4j.info(strTestData);
	    }
	    catch (Exception e)
	    {
	    s_objextendTest.log(LogStatus.ERROR, "strGetTestDataParamValues", GlobalVariables.g_strStepDescription);
	    e.printStackTrace();
	    } 
	    return strTestData;
		  
		  }
  
  
  
  
  
  
  
  public static String strGetTestDataParamValues(Recordset rsTestData, String[] m_arrTestParams, Recordset m_rsKeywordData, int m_intIteration, String strTCID)
    throws Exception
  {
    String strTestData = "#";
    String strSheetName = "";
    String strTestDataSql = "";
    //Recordset rsTestData = null;
    String strTempValue = "";
    try
    {
      for (int intCounter = 0; intCounter < m_arrTestParams.length; intCounter++) {
        if (!m_arrTestParams[intCounter].contentEquals(""))
        {
          if (strSheetName != m_arrTestParams[intCounter].split("_")[0])
          {
            strSheetName = m_arrTestParams[intCounter].split("_")[0];
            
            //strTestDataSql = "Select * from " + strSheetName + " where TCID='" + strTCID + "'";
            //rsTestData = readFromExcel(m_objTestDataConn, strTestDataSql);
          }
         // while (rsTestData.next())
        //  {
            strTempValue = rsTestData.getField(m_arrTestParams[intCounter]);
            if (strTempValue.contentEquals("")) {
              strTestData = strTestData + "~";
            } else {
              strTestData = strTestData + "~" + strTempValue;
           // }
          }
        }
        else
        {
          strTestData = strTestData + "~";
        }
      }
      strTestData = strTestData + "~#";
      
      strTestData = strTestData.replace("#~", "").replace("~#", "").replace("#", "");
      s_objlog4j.info(strTestData);
    }
    catch (Exception e)
    {
    	s_objextendTest.log(LogStatus.ERROR, "strGetTestDataParamValues", GlobalVariables.g_strStepDescription);
      e.printStackTrace();
    }
    return strTestData;
  }
  
  public String[] arrGetObjInfoFromExcel(String m_objcnnObjectRepositoryExcel, String m_strFindString)
    throws Exception
  {
    String[] arrTempValues = { "", "", "", "" };
    String strSheetName = "";
    String strORSql = "";
    Recordset rsTestData = null;
    String strTempValue = "";
    try
    {
      strSheetName = m_strFindString.split("_")[0];
      
      strORSql = "Select * from " + strSheetName + " where LogicalName='" + m_strFindString + "'";
      rsTestData = readFromExcel(m_objcnnObjectRepositoryExcel, strORSql);
      rsTestData.moveFirst();
      
      strTempValue = rsTestData.getField(GlobalVariables.FindMethodColHeader);
      if (strTempValue.contentEquals("")) {
        arrTempValues[0] = "";
      } else {
        arrTempValues[0] = strTempValue;
      }
      strTempValue = rsTestData.getField(GlobalVariables.XPathQueryColHeader);
      if (strTempValue.contentEquals("")) {
        arrTempValues[1] = "";
      } else {
        arrTempValues[1] = strTempValue;
      }
      strTempValue = rsTestData.getField(GlobalVariables.PropertyValueColHeader);
      if (strTempValue.contentEquals("")) {
        arrTempValues[2] = "";
      } else {
        arrTempValues[2] = strTempValue;
      }
      strTempValue = rsTestData.getField(GlobalVariables.TagNameColHeader);
      if (strTempValue.contentEquals("")) {
        arrTempValues[3] = "";
      } else {
        arrTempValues[3] = strTempValue;
      }
    }
    catch (Exception e)
    {
    	s_objextendTest.log(LogStatus.ERROR, "arrGetObjInfoFromExcel", GlobalVariables.g_strStepDescription);
      e.printStackTrace();
    }
    return arrTempValues;
  }
}
