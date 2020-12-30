package com.org.proj.application.Script;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import microsoft.exchange.webservices.data.misc.TimeSpan;

import static io.restassured.path.xml.XmlPath.with;

import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.config;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.config.EncoderConfig.encoderConfig;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.ini4j.Wini;
import org.json.JSONObject;
import org.json.XML;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

import Exception.FilloException;
import Fillo.Fillo;
import Fillo.Recordset;
import Fillo.Connection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.path.xml.XmlPath.with;

import com.org.proj.application.Script.GenericWebObjectLibrary.typeOfLocator;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ExceptionInfo;
import com.thoughtworks.selenium.Wait;

/**
 * GenericWebObjectLibrary class defines all the keywords library This class
 * extends Driver class
 * 
 * @author Sarath Gorantla
 */
public class GenericWebObjectLibrary extends Driver {
	public static final String ORACLE_JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String CONNECTION_STRING = "jdbc:oracle:thin:@";
	public static final String ACCESS_TOKEN = "access_token";
	public static final String CLIENT_ID = "client_id";
	public static final String X_IBM_CLIENT_ID = "x-ibm-client-id";
	public static final String CLIENT_SECRET = "client_secret";

	public static final String GRANT_TYPE = "grant_type";
	public static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
	public static final String SCOPE = "scope";
	public static final String SCOPE_APP_SCOPE = "appscope";
	public static final String AUTHORIZATION = "Authorization";
	public static final String BEARER = "Bearer";
	public static final String BASIC = "Basic";
	public static final int HTTP_servererror = 400;
	public static final int HTTP_servererror1 = 404;

	public static final int HTTP_OK = 200;
	public static final int HTTP_FORBIDDEN = 403;
	public static final int HTTP_UNAUTHORIZED = 401;
	public static java.sql.Connection con;
	private static final String CHAR_LIST = "abcde";
	private static final String DIGIT_LIST = "1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;
	private static final int RANDOM_DIGIT_LENGTH = 2;

	private File classpathRoot;
	private File appDir;
	private File app;
	GlobalVariables gVar = new GlobalVariables();
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	private static WebDriver driver;
	public static AndroidDriver mobileDriver;
	private static GenericUtilityLibrary gUtilLib;
	//GenericUtilityLibrary gUtilLib = new GenericUtilityLibrary();
	// GlobalVariables gVar = new GlobalVariables();

	/**
	 * GenericWebObjectLibrary is a constructor
	 * 
	 * @param webdriver
	 *            is the parameter
	 * @author Sarath Gorantla
	 */
	public GenericWebObjectLibrary(WebDriver driver, ExtentTest s_childExtentTest, GenericUtilityLibrary gUtilLib) {
        //this.portalDriver = portalDriver;
    	this.driver=driver;
        this.s_childExtentTest = s_childExtentTest;
        this.gUtilLib = gUtilLib;
        GlobalVariables.driver =driver;
/*        this.mobileDriver=mobileDriver;
        GlobalVariables.driver =driver;*/
    }
	
	public boolean switchtoPortal(){
    	boolean bStatus = false;
    	
    	try {
			//this.driver = portalDriver;
			bStatus=true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription, GlobalVariables.g_strKeywordDescription+" is successful");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription, GlobalVariables.g_strKeywordDescription+" is failed");
			e.printStackTrace();
		}
    	
    	return bStatus;
    }
	
	public boolean switchtoMobile(){
    	boolean bStatus = false;
    	
    	try {
			//this.driver = mobileDriver;
			bStatus=true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription, GlobalVariables.g_strKeywordDescription+" is successful");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription, GlobalVariables.g_strKeywordDescription+" is failed");
			e.printStackTrace();
		}
    	
    	return bStatus;
    }

	/**
	 * typeOfLocator is enum type which describes the four types of locators
	 * 
	 * @author Sarath Gorantla
	 */
	public enum typeOfLocator {
		EVALUATEXPATH, EVALUATECSSSELECTOR, EVALUATEID, EVALUATELINKTEXT, EVALUATENAME, EVALUATECLASS, UIAUTOMATOR, ACCESSIBILITYID, UIAUTOMATION;
	}

	private static String input;
	private static int num;
	private static String[] units = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight",
			" Nine" };
	private static String[] teen = { " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen",
			" Seventeen", " Eighteen", " Nineteen" };
	private static String[] tens = { " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty",
			" Ninety" };
	private static String[] maxs = { "", "", " Hundred", " Thousand", " Lakh", " Crore" };

	private static String digits(String temp) // TO RETURN SELECTED NUMBERS IN
	// WORDS
	{
		String converted = "";
		for (int i = temp.length() - 1; i >= 0; i--) {
			int ch = temp.charAt(i) - 48;
			if (i == 0 && ch > 1 && temp.length() > 1)
				converted = tens[ch - 2] + converted; // IF TENS DIGIT STARTS
			// WITH 2 OR MORE IT
			// FALLS UNDER TENS
			else if (i == 0 && ch == 1 && temp.length() == 2) // IF TENS DIGIT
			// STARTS WITH 1
			// IT FALLS
			// UNDER TEENS
			{
				int sum = 0;
				for (int j = 0; j < 2; j++)
					sum = (sum * 10) + (temp.charAt(j) - 48);
				return teen[sum - 10];
			} else {
				if (ch > 0)
					converted = units[ch] + converted;
			} // IF SINGLE DIGIT PROVIDED
		}
		return converted;
	}

	private static String numToString(int x) // CONVERT THE NUMBER TO STRING
	{
		String num = "";
		while (x != 0) {
			num = ((char) ((x % 10) + 48)) + num;
			x /= 10;
		}
		return num;
	}

	public static String convertNumberToWords(int n) {
		input = numToString(n);
		String converted = "";
		int pos = 1;
		boolean hun = false;
		while (input.length() > 0) {
			if (pos == 1) // TENS AND UNIT POSITION
			{
				if (input.length() >= 2) // TWO DIGIT NUMBERS
				{
					String temp = input.substring(input.length() - 2, input.length());
					input = input.substring(0, input.length() - 2);
					converted += digits(temp);
				} else if (input.length() == 1) // 1 DIGIT NUMBER
				{
					converted += digits(input);
					input = "";
				}
				pos++;
			} else if (pos == 2) // HUNDRED POSITION
			{
				String temp = input.substring(input.length() - 1, input.length());
				input = input.substring(0, input.length() - 1);
				if (converted.length() > 0 && digits(temp) != "") {
					converted = (digits(temp) + maxs[pos] + " and") + converted;
					hun = true;
				} else {
					if (digits(temp) == "") {
						converted = (" and") + converted;
					} else
						converted = (digits(temp) + maxs[pos]) + converted;
					hun = true;
				}
				pos++;
			} else if (pos > 2) // REMAINING NUMBERS PAIRED BY TWO
			{
				if (input.length() >= 2) // EXTRACT 2 DIGITS
				{
					String temp = input.substring(input.length() - 2, input.length());
					input = input.substring(0, input.length() - 2);
					if (!hun && converted.length() > 0)
						converted = digits(temp) + maxs[pos] + " and" + converted;
					else {
						if (digits(temp) == "")
							;
						else
							converted = digits(temp) + maxs[pos] + converted;
					}
				} else if (input.length() == 1) // EXTRACT 1 DIGIT
				{
					if (!hun && converted.length() > 0)
						converted = digits(input) + maxs[pos] + " and" + converted;
					else {
						if (digits(input) == "")
							;
						else
							converted = digits(input) + maxs[pos] + converted;
						input = "";
					}
				}
				pos++;
			}
		}
		return converted;
	}

	/**
	 * createWebElement method creates a webdriver element based on its presence
	 * and visibility
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return WebElement
	 * @author Sarath Gorantla
	 */
	public WebElement createWebElement(String locator, String value) throws Exception {
		WebElement element = null;

		switch (typeOfLocator.valueOf(locator)) {
		case EVALUATEXPATH:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				element = driver.findElement(By.xpath(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATECSSSELECTOR:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				element = driver.findElement(By.cssSelector(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATEID:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				element = driver.findElement(By.id(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATELINKTEXT:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				element = driver.findElement(By.linkText(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATENAME:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				element = driver.findElement(By.name(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATECLASS:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				element = driver.findElement(By.className(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case UIAUTOMATOR:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				element = ((AndroidDriver) driver).findElementByAndroidUIAutomator(value);
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;

		case ACCESSIBILITYID:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				element = ((IOSDriver<WebElement>) driver).findElementByAccessibilityId(value);
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;

		case UIAUTOMATION:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				element = ((IOSDriver) driver).findElementByIosUIAutomation(value);
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;

		}

		return element;

	}

	/**
	 * createWebElements method creates a webdriver elements based on their
	 * presence and visibility
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return WebElement List of web elements
	 * @author Sarath Gorantla
	 */
	public List<WebElement> createWebElements(String locator, String value) throws Exception {
		List<WebElement> elements = null;

		switch (typeOfLocator.valueOf(locator)) {
		case EVALUATEXPATH:
			if (waitForPresenceAndVisibilityOfElements(locator, value)) {
				elements = driver.findElements(By.xpath(value));
			} else {
				System.err.println("Elements are not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATECSSSELECTOR:
			if (waitForPresenceAndVisibilityOfElements(locator, value)) {
				elements = driver.findElements(By.cssSelector(value));
			} else {
				System.err.println("Elements are not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATEID:
			if (waitForPresenceAndVisibilityOfElements(locator, value)) {
				elements = driver.findElements(By.id(value));
			} else {
				System.err.println("Elements are not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATELINKTEXT:
			if (waitForPresenceAndVisibilityOfElements(locator, value)) {
				elements = driver.findElements(By.linkText(value));
			} else {
				System.err.println("Elements are not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATENAME:
			if (waitForPresenceAndVisibilityOfElements(locator, value)) {
				elements = driver.findElements(By.name(value));
			} else {
				System.err.println("Elements are not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATECLASS:
			if (waitForPresenceAndVisibilityOfElements(locator, value)) {
				elements = driver.findElements(By.className(value));
			} else {
				System.err.println("Elements are not found with locator " + locator + " value as " + value);
			}
			break;

		case UIAUTOMATOR:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				elements = ((AndroidDriver) driver).findElementsByAndroidUIAutomator(value);
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;

		case ACCESSIBILITYID:
			if (waitForPresenceAndVisibilityOfElement(locator, value)) {
				elements = ((AndroidDriver) driver).findElementsByAccessibilityId(value);
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		}

		return elements;

	}

	/**
	 * createPresenceOfWebElement method creates a webdriver element based on
	 * its presence only
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return WebElement
	 * @author Sarath Gorantla
	 */
	public WebElement createPresenceOfWebElement(String locator, String value) throws Exception {
		WebElement element = null;

		switch (typeOfLocator.valueOf(locator)) {
		case EVALUATEXPATH:
			if (waitForPresenceOfElement(locator, value)) {
				element = driver.findElement(By.xpath(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATECSSSELECTOR:
			if (waitForPresenceOfElement(locator, value)) {
				element = driver.findElement(By.cssSelector(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATEID:
			if (waitForPresenceOfElement(locator, value)) {
				element = driver.findElement(By.id(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATELINKTEXT:
			if (waitForPresenceOfElement(locator, value)) {
				element = driver.findElement(By.linkText(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATENAME:
			if (waitForPresenceOfElement(locator, value)) {
				element = driver.findElement(By.name(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		case EVALUATECLASS:
			if (waitForPresenceOfElement(locator, value)) {
				element = driver.findElement(By.className(value));
			} else {
				System.err.println("Element is not found with locator " + locator + " value as " + value);
			}
			break;
		}

		return element;

	}

	/**
	 * waitForPresenceAndVisibilityOfElement method waits for an element
	 * presence and visibility
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Sarath Gorantla
	 */
	@SuppressWarnings("finally")
	public boolean waitForPresenceAndVisibilityOfElement(String locator, String value) throws Exception {
		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.extMediumWait);
		List<WebElement> e;
		try {
			switch (typeOfLocator.valueOf(locator)) {
			case EVALUATEXPATH:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
				e = driver.findElements(By.xpath(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATECSSSELECTOR:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
				e = driver.findElements(By.cssSelector(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATEID:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
				e = driver.findElements(By.id(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATELINKTEXT:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				e = driver.findElements(By.linkText(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATENAME:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				e = driver.findElements(By.name(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATECLASS:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				e = driver.findElements(By.className(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case ACCESSIBILITYID:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ByAccessibilityId.name(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ByAccessibilityId.name(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				e = ((IOSDriver) driver).findElementsByAccessibilityId(value);
				if (e.size() == 1) {
					bStatus = true;
				}
				break;

			case UIAUTOMATOR:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ByAndroidUIAutomator.name(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ByAndroidUIAutomator.name(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				e = ((AndroidDriver) driver).findElementsByAndroidUIAutomator(value);
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			return bStatus;
		}

	}

	/**
	 * IsElementPresentAndVisible method checks whether element is displayed or
	 * not
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Sarath Gorantla
	 */
	public boolean IsElementPresentAndVisible(String locator, String value) throws Exception {
		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.extMediumWait);
		List<WebElement> e;
		switch (typeOfLocator.valueOf(locator)) {
		case EVALUATEXPATH:
			bStatus = driver.findElement(By.xpath(value)).isDisplayed();
			break;
		case EVALUATECSSSELECTOR:
			bStatus = driver.findElement(By.cssSelector(value)).isDisplayed();
			break;
		case EVALUATEID:
			bStatus = driver.findElement(By.id(value)).isDisplayed();
			break;
		case EVALUATELINKTEXT:
			bStatus = driver.findElement(By.linkText(value)).isDisplayed();
			break;
		case EVALUATENAME:
			bStatus = driver.findElement(By.linkText(value)).isDisplayed();
			break;
		case EVALUATECLASS:
			bStatus = driver.findElement(By.linkText(value)).isDisplayed();
			break;
		}
		return bStatus;
	}

	/**
	 * waitForPresenceAndVisibilityOfElements method waits for all elements
	 * presence and visibility
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Sarath Gorantla
	 */
	public boolean waitForPresenceAndVisibilityOfElements(String locator, String value) throws Exception {
		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.extMediumWait);
		List<WebElement> e;
		switch (typeOfLocator.valueOf(locator)) {
		case EVALUATEXPATH:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(value)));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(value)));
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
			e = driver.findElements(By.xpath(value));
			bStatus = true;
			break;
		case EVALUATECSSSELECTOR:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(value)));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(value)));
			// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
			e = driver.findElements(By.cssSelector(value));
			bStatus = true;
			break;
		case EVALUATEID:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(value)));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(value)));
			// wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
			e = driver.findElements(By.id(value));
			bStatus = true;
			break;
		case EVALUATELINKTEXT:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(value)));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(value)));
			// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
			e = driver.findElements(By.linkText(value));
			bStatus = true;
			break;
		case EVALUATENAME:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(value)));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(value)));
			// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
			e = driver.findElements(By.name(value));
			bStatus = true;
			break;
		case EVALUATECLASS:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(value)));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(value)));
			// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
			e = driver.findElements(By.className(value));
			bStatus = true;
			break;
		}
		return bStatus;
	}

	/**
	 * waitForPresenceOfElement method waits for an element presence
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Sarath Gorantla
	 */
	public boolean waitForPresenceOfElement(String locator, String value) throws Exception {
		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.extMediumWait);
		List<WebElement> e;
		switch (typeOfLocator.valueOf(locator)) {
		case EVALUATEXPATH:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(value)));
			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(value)));
			e = driver.findElements(By.xpath(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		case EVALUATECSSSELECTOR:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(value)));
			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(value)));
			e = driver.findElements(By.cssSelector(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		case EVALUATEID:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(value)));
			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(value)));
			e = driver.findElements(By.id(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		case EVALUATELINKTEXT:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(value)));
			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(value)));
			e = driver.findElements(By.linkText(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		case EVALUATENAME:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(value)));
			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(value)));
			e = driver.findElements(By.name(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		case EVALUATECLASS:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(value)));
			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(value)));
			e = driver.findElements(By.className(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;

		case ACCESSIBILITYID:
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ByAccessibilityId.name(value)));
			// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(value)));
			e = driver.findElements(ByAccessibilityId.name(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		}
		return bStatus;
	}

	/**
	 * VerifyPresenceOfElement method validates for an element presence
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Sarath Gorantla
	 */
	public boolean verifyPresenceOfElement(String locator, String value) throws Exception {
		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.extMediumWait);
		List<WebElement> e;
		switch (typeOfLocator.valueOf(locator)) {
		case EVALUATEXPATH:
			e = driver.findElements(By.xpath(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		case EVALUATECSSSELECTOR:
			e = driver.findElements(By.cssSelector(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		case EVALUATEID:
			e = driver.findElements(By.id(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		case EVALUATELINKTEXT:
			e = driver.findElements(By.linkText(value));
			if (e.size() == 1) {
				bStatus = true;
			}
			break;
		default:
			break;
		}
		return bStatus;
	}

	/**
	 * waitForElementToBeClickable method waits for an element to be clickable
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Sarath Gorantla
	 */
	@SuppressWarnings("finally")
	public boolean waitForElementToBeClickable(String locator, String value) throws Exception {
		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.extMediumWait);
		List<WebElement> e;
		try {
			switch (typeOfLocator.valueOf(locator)) {
			case EVALUATEXPATH:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
				e = driver.findElements(By.xpath(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATECSSSELECTOR:
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
				e = driver.findElements(By.cssSelector(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATEID:
				wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
				e = driver.findElements(By.id(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATELINKTEXT:
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				e = driver.findElements(By.linkText(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATENAME:
				wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
				e = driver.findElements(By.name(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			case EVALUATECLASS:
				wait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
				e = driver.findElements(By.className(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			return bStatus;
		}

	}

	/**
	 * LaunchApplication method Launches URL in the browser
	 * 
	 * @param m_strURL
	 *            This describes the page url to load
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean LaunchApplication(String m_strURL) throws Exception {
		boolean bStatus = true;
		try {
			//closeDriver();
			//openDriver(GlobalVariables.g_strBrowserType);
			//GlobalVariables.driver.manage().deleteAllCookies();
			driver.get(m_strURL);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " " + m_strURL,
					GlobalVariables.g_strKeywordDescription + " is successful");
			String url=driver.getCurrentUrl();
			System.out.println(url);
			System.out.println(driver.getCurrentUrl());
			if (driver.getCurrentUrl().contains("://")) {
				bStatus = true;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " " + m_strURL,
					GlobalVariables.g_strKeywordDescription + "is unsuccessful");

			s_objlog4j.info("Inside exception=" + e.getCause().toString());
		}
		return bStatus;
	}

	/**
	 * WaitPageLoad method waits maximum for 10 secs until page url matches
	 * expectedURL
	 * 
	 * @param expectedURL
	 *            This describes the page url to verify
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean WaitPageLoad(String expectedURL) throws Exception {
		boolean bStatus = false;
		for (int i = 1; i <= 5; i++) {
			if (driver.getCurrentUrl().contains(expectedURL)) {
				bStatus = true;
				break;
			} else {
				Thread.sleep(5000);
			}
		}
		return bStatus;
	}

	/**
	 * EnterText method enters text into object
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterText(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;

		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			/*
			 * Coordinates coordinates=((Locatable)textBox).getCoordinates();
			 * coordinates.inViewPort(); ((JavascriptExecutor)
			 * driver).executeScript( "arguments[0].scrollIntoView(true);",
			 * textBox); Thread.sleep(1000);
			 */
			textBox.click();
			textBox.click();
			textBox.clear();
			textBox.sendKeys(m_strText);

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " : " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterPassword method enters password into object
	 * 
	 * @param m_strText
	 *            This describes the password to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Selva
	 */
	public boolean EnterPassword(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			/*
			 * Coordinates coordinates=((Locatable)textBox).getCoordinates();
			 * coordinates.inViewPort(); ((JavascriptExecutor)
			 * driver).executeScript( "arguments[0].scrollIntoView(true);",
			 * textBox); Thread.sleep(1000);
			 */
			textBox.click();
			textBox.clear();
			textBox.sendKeys(m_strText);

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + "******",
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " : " + "******",
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTextFromGlobVar method enters text into object from stored in global
	 * variable
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterTextFromGlobVar() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			/*
			 * Coordinates coordinates=((Locatable)textBox).getCoordinates();
			 * coordinates.inViewPort(); ((JavascriptExecutor)
			 * driver).executeScript( "arguments[0].scrollIntoView(true);",
			 * textBox); Thread.sleep(1000);
			 */
			textBox.click();
			textBox.clear();
			textBox.sendKeys(GlobalVariables.UniqueValue);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTextFromGlobVar method enters text into object from stored in global
	 * variable by prepending the text passed
	 * 
	 * @param m_strCompanyCode
	 *            This describes the company code to prepend with the existing
	 *            global variable value
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterTextFromGlobVarWithCompanyCode(String m_strCompanyCode) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		String textToEnter = m_strCompanyCode + "\\" + GlobalVariables.UniqueValue;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			/*
			 * Coordinates coordinates=((Locatable)textBox).getCoordinates();
			 * coordinates.inViewPort(); ((JavascriptExecutor)
			 * driver).executeScript( "arguments[0].scrollIntoView(true);",
			 * textBox); Thread.sleep(1000);
			 */
			textBox.click();
			textBox.clear();
			textBox.sendKeys(textToEnter);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterText method does not enter any text into object
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterText() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			textBox.click();
			textBox.clear();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterText method does not enter any text into object
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterTextIfExist(String strXPath, String strValue) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			// waitForPresenceAndVisibilityOfElement("EVALUATEXPATH",strXPath);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			if (driver.findElement(By.xpath(strXPath)).isDisplayed()) {
				WebElement textBox = createWebElement("EVALUATEXPATH", strXPath);
				textBox.click();
				textBox.clear();
				textBox.sendKeys(strValue);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + strValue,
						GlobalVariables.g_strKeywordDescription + " is successful");
				bStatus = true;
			}
			else{
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + strValue,
						GlobalVariables.g_strKeywordDescription + " The Field Is Not available for This Sceanrio");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + strValue,
					GlobalVariables.g_strKeywordDescription + " is successful");
			
		}
		return true;
	}

	/**
	 * EnterTextWithoutClear method enters text into object
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterTextWithoutClear(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			/*
			 * Coordinates coordinates=((Locatable)textBox).getCoordinates();
			 * coordinates.inViewPort(); ((JavascriptExecutor)
			 * driver).executeScript( "arguments[0].scrollIntoView(true);",
			 * textBox); Thread.sleep(1000);
			 */
			//textBox.click();
			// textBox.clear();
			textBox.sendKeys(m_strText);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " : " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTextAndTAB method enters text into object and TABS
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterTextAndTAB(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			textBox.click();
			textBox.clear();
			textBox.sendKeys(m_strText);
			textBox.sendKeys(Keys.TAB);
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " +
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " : " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClearText method clears text from object
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */

public boolean ClearText() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			/*
			 * Coordinates coordinates=((Locatable)textBox).getCoordinates();
			 * coordinates.inViewPort(); Thread.sleep(1000);
			 */
			textBox.click();
			//textBox.clear();
			textBox.sendKeys(Keys.CONTROL + "a");
			textBox.sendKeys(Keys.DELETE);
			s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ContainsObjectText method validates the text from object contains
	 * expected text using getText
	 * 
	 * @param m_strText
	 *            This describes the text to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ContainsObjectText(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			s_objlog4j.info("Actual text=" + textBox.getText().replace(" ", "").toUpperCase());
			s_objlog4j.info("Expected text=" + m_strText.replace(" ", "").toUpperCase());
			if (textBox.getText().replace(" ", "").replace(",", "").toUpperCase()
					.contains(m_strText.replace(" ", "").replace(",", "").toUpperCase())) {
				bStatus = true;
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ContainsText method validates the text from object value contains
	 * expected text using getAttribute
	 * 
	 * @param m_strText
	 *            This describes the text to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ContainsText(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			s_objlog4j.info("Actual text=" + textBox.getAttribute("value").replace(" ", "").toUpperCase());
			s_objlog4j.info("Expected text=" + m_strText.replace(" ", "").toUpperCase());
			if (textBox.getAttribute("value").replace(" ", "").toUpperCase()
					.contains(m_strText.replace(" ", "").toUpperCase())) {
				bStatus = true;
				GlobalVariables.g_captureScreenShot = true;
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ContainsTextFromtextContent method validates the text from object text
	 * Content contains expected text using getAttribute
	 * 
	 * @param m_strText
	 *            This describes the text to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ContainsTextFromtextContent(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			s_objlog4j.info("Actual text=" + textBox.getAttribute("textContent").replace(" ", "").toUpperCase());
			s_objlog4j.info("Expected text=" + m_strText.replace(" ", "").toUpperCase());
			if (textBox.getAttribute("textContent").replace(" ", "").toUpperCase()
					.contains(m_strText.replace(" ", "").toUpperCase())) {
				bStatus = true;
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTextThroughJavaScript method enters text into object using java
	 * script method
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterTextThroughJavaScript(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", textBox);
			js.executeScript("arguments[0].value = '" + m_strText + "';", textBox);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " : " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	/*
	 *//**
		 * ClickIfExist method clicks on object if it is present
		 * 
		 * @param objXpath
		 *            This describes the object to click
		 * @return Boolean value True/False based on success of this function
		 * @author Sarath Gorantla
		 *//*
			 * public boolean ClickIfExist(String objXpath) throws Exception {
			 * boolean bStatus = false; try { if
			 * (driver.findElement(By.xpath(objXpath)).isDisplayed()) {
			 * driver.findElement(By.xpath(objXpath)).click(); } bStatus = true;
			 * s_childExtentTest.log(LogStatus.PASS,
			 * GlobalVariables.g_strKeywordDescription,GlobalVariables.
			 * g_strKeywordDescription + " is successful"); } catch (Exception
			 * e) { s_childExtentTest.log(LogStatus.FAIL,
			 * GlobalVariables.g_strKeywordDescription,GlobalVariables.
			 * g_strKeywordDescription + " is unsuccessful"); //
			 * e.printStackTrace(); bStatus = true; } return bStatus; }
			 */

	/**
	 * ClickIfExist method clicks on object if it is present
	 * 
	 * @param objXpath
	 *            This describes the object to click
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ClickIfExist(String objXpath1, String objXpath2) throws Exception {
		boolean bStatus = false;
		try {
			if (driver.findElement(By.xpath(objXpath1)).isDisplayed()) {
				driver.findElement(By.xpath(objXpath1)).click();
			} else {
				driver.findElement(By.xpath(objXpath2)).click();
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");

			// e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * EnterFilePath method enters file path into an input object field
	 * 
	 * @param m_strText
	 *            This describes the value of file path
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterFilePath(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			if (GlobalVariables.g_strBrowserType.contains("InternetExplorer")) {
				m_strText = m_strText.replace("\\\\", "\\");
			}
			textBox.sendKeys(m_strText);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			// searchBox.sendKeys(Keys.TAB);
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * getHrefAndLoad method gets the url of link/button and loads in the same
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean getHrefAndLoad() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement buttonOrLink = createPresenceOfWebElement(strExcelInfo[0], strExcelInfo[1]);
			String url = buttonOrLink.getAttribute("href");
			driver.get(url);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * Click method clicks button or link object in a page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean Click() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			/*
			 * Coordinates
			 * coordinates=((Locatable)buttonOrLink).getCoordinates();
			 * coordinates.inViewPort(); Thread.sleep(1000);
			 */
			buttonOrLink.click();

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean Click(String strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;

		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			/*
			 * Coordinates
			 * coordinates=((Locatable)buttonOrLink).getCoordinates();
			 * coordinates.inViewPort(); Thread.sleep(1000);
			 */
			buttonOrLink.click();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * Click method scrolls to the control and clicks it in a screen
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Kannan Dharani
	 */
	public boolean IOSClick() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			IOSElement buttonOrLink = (IOSElement) createMobileElement(strExcelInfo[0], strExcelInfo[1]);

			while (!(buttonOrLink).isDisplayed()) {
				((IOSDriver<WebElement>) driver).swipe(10, 500, 10, -150, 5000);
			}

			buttonOrLink.click();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * checkIfNotChecked method clicks button or link object in a page if it is
	 * not checked already.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean checkIfNotChecked() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			try {
				if (buttonOrLink.getAttribute("checked").toUpperCase().contains("TRUE")) {

				} else {
					buttonOrLink.click();
				}
			} catch (Exception e) {
				buttonOrLink.click();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * checkIfNotChecked method clicks button or link object in a page if it is
	 * not checked already after unchecking already checked object.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean checkIfNotChecked(String m_StrXpath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			try {
				if (buttonOrLink.getAttribute("checked").toUpperCase().contains("TRUE")) {

				} else {
					driver.findElement(By.xpath(m_StrXpath)).click();
					Thread.sleep(1000);
					buttonOrLink.click();
				}
			} catch (Exception e) {
				driver.findElement(By.xpath(m_StrXpath)).click();
				Thread.sleep(1000);
				buttonOrLink.click();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * unCheckIfChecked method clicks button or link object in a page if it is
	 * checked already.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean unCheckIfChecked() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			s_objlog4j.info("checked property=" + buttonOrLink.getAttribute("checked"));
			try {
				if (buttonOrLink.getAttribute("checked").toUpperCase().contains("FALSE")
						|| buttonOrLink.getAttribute("checked").toUpperCase().contains("NULL")) {
					s_objlog4j.info("Not clicking object");
				} else {
					s_objlog4j.info("clicking object");
					buttonOrLink.click();
				}
			} catch (Exception e) {
				s_objlog4j.info(e.getMessage());
				buttonOrLink.click();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * unCheckIfChecked method clicks button or link object in a page if it is
	 * checked already after checking already unchecked object.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean unCheckIfChecked(String m_StrXpath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			try {
				if (buttonOrLink.getAttribute("checked").toUpperCase().contains("FALSE")
						|| buttonOrLink.getAttribute("checked").toUpperCase().contains("NULL")) {

				} else {
					driver.findElement(By.xpath(m_StrXpath)).click();
					Thread.sleep(1000);
					buttonOrLink.click();
				}
			} catch (Exception e) {
				driver.findElement(By.xpath(m_StrXpath)).click();
				Thread.sleep(1000);
				buttonOrLink.click();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickUsingJS method clicks button or link object in a page using java
	 * script
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ClickUsingJS() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonOrLink);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
			GlobalVariables.g_captureScreenShot = true;
			
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * Exists method checks for an element is present and visible
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean Exists() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		String actual = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			// bStatus=waitForPresenceAndVisibilityOfElement(strExcelInfo[0],strExcelInfo[1]);
			bStatus = waitForPresenceOfElement(strExcelInfo[0], strExcelInfo[1]);
			
			if (GlobalVariables.g_strKeywordDescription.contains("Validate that the ")) {
				actual = GlobalVariables.g_strKeywordDescription.replace(
						"Validate that the ", "");
				char chr[] = actual.toCharArray();
				chr[0] = Character.toUpperCase(chr[0]);
				actual = new String(chr);
			} else if (GlobalVariables.g_strKeywordDescription.contains("Validate that ")) {
				actual = GlobalVariables.g_strKeywordDescription
						.replace("Validate that ", "");
				char chr[] = actual.toCharArray();
				chr[0] = Character.toUpperCase(chr[0]);
				actual = new String(chr);
			} else {
				actual = GlobalVariables.g_strKeywordDescription;
			}
			
			s_childExtentTest.log(LogStatus.PASS, actual,actual+ " as expected");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, actual,actual + " is not as expected");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * Exists method checks for an element is present and visible
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean Exists(String strVal) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {

			System.out.println("-Exists----strVal----------" + strVal);

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);

			// bStatus=waitForPresenceAndVisibilityOfElement(strExcelInfo[0],strExcelInfo[1]);
			bStatus = waitForPresenceOfElement(strExcelInfo[0], strExcelInfo[1]);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " as expected");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is not as expected");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * NotExists method checks for an element is not present and not visible
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean NotExists() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			// bStatus=waitForPresenceAndVisibilityOfElement(strExcelInfo[0],strExcelInfo[1]);
			// bStatus=waitForPresenceOfElement(strExcelInfo[0],strExcelInfo[1]);
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.extMediumWait);
			List<WebElement> e;
			Thread.sleep(2000);
			switch (typeOfLocator.valueOf(strExcelInfo[0])) {
			case EVALUATEXPATH:
				// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(strExcelInfo[1])));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(strExcelInfo[1])));
				e = driver.findElements(By.xpath(strExcelInfo[1]));
				if (e.size() >= 1) {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is unsuccessful");
				} else
					bStatus = true;

				break;
			case EVALUATECSSSELECTOR:
				// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(strExcelInfo[1])));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(strExcelInfo[1])));
				e = driver.findElements(By.cssSelector(strExcelInfo[1]));
				if (e.size() >= 1) {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is unsuccessful");
				} else
					bStatus = true;

				break;
			case EVALUATEID:
				// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(strExcelInfo[1])));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(strExcelInfo[1])));
				e = driver.findElements(By.id(strExcelInfo[1]));
				if (e.size() >= 1) {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is unsuccessful");
				} else
					bStatus = true;

				break;
			case EVALUATELINKTEXT:
				// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(strExcelInfo[1])));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(strExcelInfo[1])));
				e = driver.findElements(By.linkText(strExcelInfo[1]));
				if (e.size() >= 1) {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is unsuccessful");
				} else
					bStatus = true;

				break;
			case EVALUATENAME:
				// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(strExcelInfo[1])));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(strExcelInfo[1])));
				e = driver.findElements(By.linkText(strExcelInfo[1]));
				if (e.size() >= 1) {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is unsuccessful");
				} else
					bStatus = true;

				break;
			case EVALUATECLASS:
				// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(strExcelInfo[1])));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(strExcelInfo[1])));
				e = driver.findElements(By.linkText(strExcelInfo[1]));
				if (e.size() >= 1) {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is unsuccessful");
				} else
					bStatus = true;

				break;
			}
			if (bStatus) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}

			return bStatus;
		} catch (Exception e) {
			e.printStackTrace();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

			bStatus = true;
		}
		return bStatus;

	}

	/**
	 * ExistsWithoutWaiting method checks for an element is present and visible
	 * with out any wait
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ExistsWithoutWaiting() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		int intTime = 0;

		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			// bStatus=waitForPresenceAndVisibilityOfElement(strExcelInfo[0],strExcelInfo[1]);
			bStatus = IsElementPresentAndVisible(strExcelInfo[0], strExcelInfo[1]);
			while (!bStatus) {
				bStatus = IsElementPresentAndVisible(strExcelInfo[0], strExcelInfo[1]);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
				intTime = intTime + 1;
				if (intTime > 30)
					break;
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * MinWait method waits by default for 2 seconds
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean MinWait() throws Exception {
		boolean bStatus = false;
		try {
			// Thread.sleep(2000);
			Thread.sleep(Long.parseLong(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_intMinimumWait")));
			bStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * MedWait method waits by default for 5 seconds
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean MedWait() throws Exception {
		boolean bStatus = false;
		try {
			Thread.sleep(Long.parseLong(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_intMediumWait")));
			bStatus = true;
			//s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,	GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * MedWait method waits by default for 5 seconds
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean LongWait() throws Exception {
		boolean bStatus = false;
		try {
			// Thread.sleep(5000);
			Thread.sleep(Long.parseLong(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_intLongWait")));
			bStatus = true;
			//s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,	GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bStatus;
	}
	
	/**
	 * ScrollToBottom method scrolls to bottom of the page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ScrollToBottom() throws Exception {
		boolean bStatus = false;
		try {
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			Thread.sleep(1000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ScrollDown method scrolls to down the page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ScrollDown() throws Exception {
		boolean bStatus = false;
		try {
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ScrollToTop method scrolls to top of the page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ScrollToTop() throws Exception {
		boolean bStatus = false;
		try {
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
			Thread.sleep(1000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * VerifyObjectExistsInColumnNoInEachRow method verifies that the specified
	 * object xpath is present in specified column no
	 * 
	 * @param locatorValue
	 *            xpath of the object
	 * @param columnNo
	 *            Column number in the html grid
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean VerifyObjectExistsInColumnNoInEachRow(String locatorValue, String columnNo) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement webTable = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			List<WebElement> rows = webTable.findElements(By.tagName("tr"));
			for (int i = 0; i < rows.size(); i++) {
				List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
				bStatus = cols.get(Integer.parseInt(columnNo) - 1).findElement(By.xpath(locatorValue)).isDisplayed();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectAllRowsInIssueLettersTable method selects all rows in the table of
	 * Issue Letters
	 * 
	 * @param locatorValue
	 *            xpath of the object
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SelectAllRowsInIssueLettersTable(String locatorValue) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceOfElement(strExcelInfo[0], strExcelInfo[1]);
			if (IsElementPresentAndVisible(strExcelInfo[0], strExcelInfo[1])) {
				WebElement webTable = createPresenceOfWebElement(strExcelInfo[0], strExcelInfo[1]);
				List<WebElement> rows = webTable.findElements(By.xpath(locatorValue));
				if (rows.size() > 0) {
					for (int i = 0; i < rows.size(); i++) {
						rows.get(i).click();
					}
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				bStatus = true;
			} else {
				bStatus = true;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectOnlyLastRowInTable method selects only last row in the table
	 * 
	 * @param locatorValue
	 *            xpath of the object
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SelectOnlyLastRowInTable(String locatorValue) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceOfElement(strExcelInfo[0], strExcelInfo[1]);
			if (IsElementPresentAndVisible(strExcelInfo[0], strExcelInfo[1])) {
				WebElement webTable = createPresenceOfWebElement(strExcelInfo[0], strExcelInfo[1]);
				List<WebElement> rows = webTable.findElements(By.xpath(locatorValue));
				if (rows.size() > 1) {
					rows.get((rows.size()) - 1).click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				bStatus = true;
			} else {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
				bStatus = true;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickOKOnAlert method clicks OK button in the javascript confirmation
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ClickOKOnAlert() {
		boolean bStatus = false;
		try {
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * ClickCancelOnAlert method clicks Cancel button in the javascript
	 * confirmation
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ClickCancelOnAlert() {
		boolean bStatus = false;
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * ValidateTextFromAlert method verifies the text present in the javascript
	 * confirmation
	 * 
	 * @param m_strText
	 *            This is the text to verify in the alert
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ValidateTextFromAlert(String m_strText) {
		boolean bStatus = false;
		try {
			Alert alert = driver.switchTo().alert();
			// alert.accept();
			if (alert.getText().replace(" ", "").toUpperCase().contains(m_strText.replace(" ", "").toUpperCase())) {
				alert.dismiss();
				// bStatus = true;
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + alert.getText() + " is validated");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + m_strText + " is not validated");
			e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/*
	 * * ValidateTextFromAlertAndClickOK method verifies the text present in the
	 * javascript confirmation
	 * 
	 * @param m_strText This is the text to verify in the alert
	 * 
	 * @return Boolean value True/False based on success of this function
	 * 
	 * @author Sarath Gorantla
	 */
	public boolean ValidateTextFromAlertAndClickOK(String m_strText) {
		boolean bStatus = false;
		try {
			Alert alert = driver.switchTo().alert();
			// alert.accept();
			if (alert.getText().replace(" ", "").toUpperCase().contains(m_strText.replace(" ", "").toUpperCase())) {
				alert.accept();
				bStatus = true;
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + alert.getText() + " is validated");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + m_strText + " is not validated");

			e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * ClickItemFromDropDown method clicks an item from dropdown object in a
	 * page using java script
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ClickItemFromDropDown() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement DropDownItem = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", DropDownItem);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickItemBasedOnPresenceFromDropDown method clicks an item from dropdown
	 * object based on presence in a page using java script
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ClickItemBasedOnPresenceFromDropDown() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement DropDownItem = createPresenceOfWebElement(strExcelInfo[0], strExcelInfo[1]);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", DropDownItem);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * FromDropDown method selects an item from dropdown object in a page
	 * 
	 * @param Item
	 *            visible text of the item
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */

public boolean SelectItemFromDropDown(String Item, String StatusDropdown) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
		//	List<WebElement> List = element.findElements(By.tagName("option"));
			List<WebElement> List = element.findElements(By.xpath(StatusDropdown));
			for (WebElement option : List) {
				if (Item.equals(option.getText())) {
					option.click();
					bStatus = true;
					s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
					break;
				}
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	/**
	 * SwitchToFrame method switch to the frame when only one frame is available
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SwitchToFrame() throws Exception {
		boolean bStatus = false;
		try {
			driver.switchTo().frame(0);
			bStatus = true;
			GlobalVariables.g_captureScreenShot = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

			// s_childExtentTest.log(LogStatus.PASS,
			// GlobalVariables.g_strStepDescription,
			// GlobalVariables.g_strKeywordDescription);
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SwitchToFrame method switch to the frame when only one frame is available
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SwitchToSelectedFrame(int intFrame) throws Exception {
		boolean bStatus = false;
		try {
			driver.switchTo().frame(intFrame);
			bStatus = true;
			// s_childExtentTest.log(LogStatus.PASS, "SwitchToFrame",
			// GlobalVariables.g_strStepDescription);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SwitchToDefaultBrowser method switch to the default windows from frame
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SwitchToDefaultBrowser() throws Exception {
		boolean bStatus = false;
		try {
			driver.switchTo().defaultContent();

			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CalculateExcel method calculates the formula in excel sheet
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean CalculateExcel(String excelFilePath) throws Exception {
		boolean bStatus = false;
		try {
			FileInputStream fis = new FileInputStream(excelFilePath);
			XSSFWorkbook wb = new XSSFWorkbook(fis); // or new
			// XSSFWorkbook("/somepath/test.xls")
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			for (int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
				Sheet sheet = wb.getSheetAt(sheetNum);
				for (Row r : sheet) {
					for (Cell c : r) {
						if (c.getCellType() == Cell.CELL_TYPE_FORMULA) {
							evaluator.evaluateFormulaCell(c);
						}
					}
				}
			}
			Thread.sleep(2000);
			Sheet sh = wb.getSheetAt(0);
			FileOutputStream out = new FileOutputStream(excelFilePath);
			wb.write(out);
			out.close();
			s_objlog4j.info(sh.getRow(1).getCell(0).getStringCellValue());

			fis.close();
			// Runtime.getRuntime().exec("C:\\Windows\\System32\\wscript.exe
			// C:\\FEAT\\PeopleWorks\\SELENIUMFRAMEWORK\\src\\test\\resources\\TestData\\calculateExcel.vbs");

			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * cleanDownloadDirectory method deletes all the sub folder and files in
	 * them
	 * 
	 * @param downloadsDirPath
	 *            Downloads default director path
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean cleanDownloadDirectory(String downloadsDirPath) throws Exception {
		boolean bStatus = false;
		try {
			File file = new File(downloadsDirPath);
			FileUtils.cleanDirectory(file);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * checkIfFileExists method checks whether given path string is file or not
	 * 
	 * @param filePathString
	 *            path of the file
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean checkIfFileExists(String filePathString) throws Exception {
		boolean bStatus = false;
		try {
			File f = new File(filePathString);
			if (f.isFile()) {
				bStatus = true;
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * waitUntilFileDownloaded method waits until given path string is file or
	 * not and it exists
	 * 
	 * @param filePathString
	 *            path of the file
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean waitUntilFileDownloaded(String filePathString) throws Exception {
		boolean bStatus = false;
		try {
			File f = new File(filePathString);
			Thread.sleep(5000);
			for (int i = 1; i <= 15; i++) {
				if (f.isFile()) {
					bStatus = true;
					break;
				} else {
					Thread.sleep(5000);
				}
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * FileUploadUsingRobot method uploads a file using java robot method
	 * 
	 * @param m_strText
	 *            This describes the value of file path
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean FileUploadUsingRobot(String m_strText, String locator) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;

		String projectPath = System.getProperty("user.dir");
		try {
			StringSelection stringSelection = new StringSelection(projectPath + m_strText);
			System.out.println("Path: " + projectPath + m_strText);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			// Robot rb= new Robot();
			Robot robot = new Robot();

			WebElement element = driver.findElement(By.xpath(locator));
			element.click();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(2000);

			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateElementAttribute method validates the element attribute contains
	 * expected text using getAttribute * @param m_strAttribute This describes
	 * the attribute type to validate
	 * 
	 * @param m_strText
	 *            This describes the attribute value to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ValidateElementAttribute(String m_strAttribute, String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		String actual = null;
		String actualValue= null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			s_objlog4j.info("Actual text=" + textBox.getAttribute(m_strAttribute).replace(" ", "").toUpperCase());
			s_objlog4j.info("Expected text=" + m_strText.replace(" ", "").toUpperCase());
			if (GlobalVariables.g_strKeywordDescription.contains("Validate that the ")) {
				actual = GlobalVariables.g_strKeywordDescription.replace(
						"Validate that the ", "");
				char chr[] = actual.toCharArray();
				chr[0] = Character.toUpperCase(chr[0]);
				actual = new String(chr);
			} else if (GlobalVariables.g_strKeywordDescription.contains("Validate the ")) {
				actual = GlobalVariables.g_strKeywordDescription
						.replace("Validate the ", "");
				char chr[] = actual.toCharArray();
				chr[0] = Character.toUpperCase(chr[0]);
				actual = new String(chr);
			} else {
				actual = GlobalVariables.g_strKeywordDescription;
			}
			actualValue=textBox.getAttribute(m_strAttribute);
			if (m_strText.toUpperCase().equalsIgnoreCase("NULL") || textBox.getAttribute(m_strAttribute)
					.replace(" ", "").toUpperCase().contains(m_strText.replace(" ", "").toUpperCase())) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, actual, actual +" : "+ m_strText + " is validated successfully");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, actual, "Expected : " + m_strText + " And Actual : "+actualValue);
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateNonVisibleElementAttribute method validates the invisible element
	 * attribute contains expected text using getAttribute * @param
	 * m_strAttribute This describes the attribute type to validate
	 * 
	 * @param m_strText
	 *            This describes the attribute value to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ValidateNonVisibleElementAttribute(String m_strAttribute, String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			s_objlog4j.info("Actual text=" + textBox.getAttribute(m_strAttribute).replace(" ", "").toUpperCase());
			s_objlog4j.info("Expected text=" + m_strText.replace(" ", "").toUpperCase());
			if (textBox.getAttribute(m_strAttribute).replace(" ", "").toUpperCase()
					.contains(m_strText.replace(" ", "").toUpperCase())) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + m_strText + " is validated");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + m_strText + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateMail method validates mail received into gmail
	 * 
	 * @param m_strMailSubject
	 *            This describes the Mail Subject to validate
	 * @param m_strMailBody
	 *            This describes the Body of the mail content to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ValidateMail(String m_strMailSubject, String m_strMailBody) throws Exception {
		boolean bStatus = false;
		try {
			Thread.sleep(10000);
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect("imap.gmail.com", "peopleworks3@gmail.com", "Qwerty1@2");

			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);

			s_objlog4j.info("Total Message:" + folder.getMessageCount());
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");
			s_objlog4j.info("Unread Message:" + folder.getUnreadMessageCount());
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");

			Message[] messages = null;
			boolean isMailFound = false;
			Message mailFromPW = null;

			// Search for mail from PW
			for (int i = 0; i <= 5; i++) {
				messages = folder.search(new SubjectTerm(m_strMailSubject), folder.getMessages());
				// Wait for 10 seconds
				if (messages.length == 0) {
					Thread.sleep(10000);
				}
			}

			// Search for unread mail from PW
			// This is to avoid using the mail for which already received
			for (Message mail : messages) {
				if (!mail.isSet(Flags.Flag.SEEN)) {
					mailFromPW = mail;
					s_objlog4j.info("Message Count is: " + mailFromPW.getMessageNumber());
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
					isMailFound = true;
				}
			}

			// Test fails if no unread mail was found from PW
			if (!isMailFound) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
				throw new Exception("Could not find new mail from PW :-(");

				// Read the content of mail and validate
			} else {
				String line;
				StringBuffer buffer = new StringBuffer();
				BufferedReader reader = new BufferedReader(new InputStreamReader(mailFromPW.getInputStream()));
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
				s_objlog4j.info(buffer);

				// Validate the content of email received
				// String mailContent = buffer.toString().split("Subject:
				// VerificationTo:")[1];
				// s_objlog4j.info(mailContent);
				if (buffer.toString().contains(m_strMailBody)) {
					bStatus = true;
				}
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateGMail method validates mail received into gmail
	 * 
	 * @param m_strGmailID
	 *            This describes the Gmail username
	 * @param m_strGmailPASSWORD
	 *            This describes the Gmail password
	 * @param m_strMailSubject
	 *            This describes the Mail Subject to validate
	 * @param m_strMailBody
	 *            This describes the Body of the mail content to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ValidateGMail(String m_strGmailID, String m_strGmailPASSWORD, String m_strMailSubject,
			String m_strMailBody) throws Exception {
		boolean bStatus = false;
		try {
			Thread.sleep(10000);
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect("imap.gmail.com", m_strGmailID, m_strGmailPASSWORD);

			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);

			s_objlog4j.info("Total Message:" + folder.getMessageCount());
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");
			s_objlog4j.info("Unread Message:" + folder.getUnreadMessageCount());
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");

			Message[] messages = null;
			boolean isMailFound = false;
			Message mailFromPW = null;

			// Search for mail from PW
			for (int i = 0; i <= 5; i++) {
				messages = folder.search(new SubjectTerm(m_strMailSubject), folder.getMessages());
				// Wait for 10 seconds
				if (messages.length == 0) {
					Thread.sleep(10000);
				}
			}

			// Search for unread mail from PW
			// This is to avoid using the mail for which already received
			for (Message mail : messages) {
				if (!mail.isSet(Flags.Flag.SEEN)) {
					mailFromPW = mail;
					s_objlog4j.info("Message Count is: " + mailFromPW.getMessageNumber());
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
					isMailFound = true;
				}
			}

			// Test fails if no unread mail was found from PW
			if (!isMailFound) {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
				throw new Exception("Could not find new mail from PW :-(");

				// Read the content of mail and validate
			} else {
				String line;
				StringBuffer buffer = new StringBuffer();
				BufferedReader reader = new BufferedReader(new InputStreamReader(mailFromPW.getInputStream()));
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
				s_objlog4j.info(buffer);

				// Validate the content of email received
				// String mailContent = buffer.toString().split("Subject:
				// VerificationTo:")[1];
				// s_objlog4j.info(mailContent);
				if (buffer.toString().contains(m_strMailBody)) {
					bStatus = true;
				}
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + "Mail Body=" + buffer.toString());
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean enterURL() {
		driver.get("https://peopledomain.co.in/JFST/HLM/");
		return true;
	}

	/**
	 * SelectDateFromCalendar method selects the date from calendar
	 * 
	 * @param m_strText
	 *            This describes the date to select
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SelectDateFromCalendar(String m_xpathMonth, String m_xpathYear, String m_xpathDay, String m_strText)
			throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);

			WebElement year = createWebElement("EVALUATEXPATH", m_xpathYear);
			List<WebElement> List = year.findElements(By.tagName("option"));
			for (WebElement option : List) {
				if (m_strText.split("-")[2].equals(option.getText())) {
					option.click();
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
					break;
				}
			}
			WebElement month = createWebElement("EVALUATEXPATH", m_xpathMonth);
			List = month.findElements(By.tagName("option"));

			for (WebElement option : List) {
				if (m_strText.split("-")[1].equals(option.getText())) {
					option.click();
					// bStatus=true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
					break;
				}
			}

			WebElement day = createWebElement("EVALUATEXPATH", m_xpathDay + m_strText.split("-")[0] + "']");
			day.click();
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectDateFromJqueryCalendar method selects the date from Jquery calendar
	 * 
	 * @param m_strText
	 *            This describes the date to select
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SelectDateFromJqueryCalendar(String SelectDate) throws Exception {
		WebElement dateWidget;
		List<WebElement> columns;
		List<String> list = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		// Expected Date, Month and Year
		int expMonth;
		int expYear;
		String expDate = null;
		// Calendar Month and Year
		String calMonth = null;
		String calYear = null;
		boolean dateNotFound;
		dateNotFound = true;
		expMonth = Integer.parseInt(SelectDate.split("/")[1]);
		expYear = Integer.parseInt(SelectDate.split("/")[2]);
		expDate = SelectDate.split("/")[0];
		;
		while (dateNotFound) {

			calMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			calYear = driver.findElement(By.className("ui-datepicker-year")).getText();
			if (list.indexOf(calMonth) + 1 == expMonth && (expYear == Integer.parseInt(calYear))) {
				dateWidget = driver.findElement(By.id("ui-datepicker-div"));
				columns = dateWidget.findElements(By.tagName("td"));

				for (WebElement cell : columns) {
					// Selects Date
					if (cell.getText().equals(expDate)) {
						cell.findElement(By.linkText(expDate)).click();
						break;
					}
				}
				dateNotFound = false;
			} else if (list.indexOf(calMonth) + 1 < expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear > Integer.parseInt(calYear)) {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]")).click();
			} else if (list.indexOf(calMonth) + 1 > expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear < Integer.parseInt(calYear)) {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]")).click();
			}
		}
		Thread.sleep(3000);
		return true;

	}

	/**
	 * EnterTextAndStore method enters text into object and stores into variable
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterTextAndStore(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			textBox.click();
			textBox.clear();
			textBox.sendKeys(m_strText);
			GlobalVariables.UniqueValue = m_strText;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectPayStructureToMap method selects the pay structure to map with Band
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SelectPayStructureToMap() throws Exception {
		boolean bStatus = false;
		try {
			WebElement chkBox = createWebElement("EVALUATEXPATH", "//input[@value='" + GlobalVariables.UniqueValue
					+ "']/../preceding-sibling::td/input[@name='chkStrName']");
			chkBox.click();
			Thread.sleep(1000);
			WebElement defaultRadBtn = createWebElement("EVALUATEXPATH", "//input[@value='"
					+ GlobalVariables.UniqueValue + "']/../following-sibling::td/input[@name='rdDefault']");
			defaultRadBtn.click();
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is un successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterFormulaForComponent method enters the formula in Pay structures
	 * module
	 * 
	 * @param m_strComponent
	 *            This describes the component name for which we need to enter
	 *            formula
	 * @param m_strFormulaValue
	 *            This describes the formula to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean EnterFormulaForComponent(String m_strComponent, String m_strFormulaValue) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			WebElement element = createWebElement("EVALUATEXPATH", "//table[@id='gridDates']//label[contains(text(),'"
					+ m_strComponent + "')]//following::td[1]/a[contains(text(),'Click To Enter Formula')]");
			element.click();
			// element=createWebElement("EVALUATEXPATH","//tr[@id='CTCInput']//label[contains(text(),'CTCInput')]/..");
			element = createWebElement("EVALUATEXPATH", "//tr[@id='" + m_strFormulaValue.split("*")[0]
					+ "']//label[contains(text(),'" + m_strFormulaValue.split("*")[0] + "')]/..");
			Thread.sleep(1000);
			element.click();
			element = createWebElement("EVALUATEXPATH", "//table[@id='divLitrels']//label[contains(text(),'*')]/..");
			Thread.sleep(1000);
			element.click();
			if (m_strFormulaValue.split("*")[1].length() == 1) {
				element = createWebElement("EVALUATEXPATH",
						"//table[@id='divLitrels']//label[contains(text(),'0')]/..");
				Thread.sleep(1000);
				element.click();
			} else {
				element = createWebElement("EVALUATEXPATH", "//table[@id='divLitrels']//label[contains(text(),'"
						+ m_strFormulaValue.split("*")[1].substring(0, 1) + "')]/..");
				Thread.sleep(1000);
				element.click();
				element = createWebElement("EVALUATEXPATH", "//table[@id='divLitrels']//label[contains(text(),'"
						+ m_strFormulaValue.split("*")[1].substring(1) + "')]/..");
				Thread.sleep(1000);
				element.click();
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			e.printStackTrace();
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
		}
		return bStatus;
	}

	/**
	 * ValidateCellDataForSpecifiedColIndex method validates the cell data for
	 * specified column index in table
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToValidate
	 *            This describes the column index number to validate for item
	 * @param m_strCellDataToValidate
	 *            This describes the cell data to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public Boolean ValidateCellDataForSpecifiedColIndex(String TableXPath, String m_intColIndexToSearch,
			String m_strItemToSearch, String m_intColIndexToValidate, String m_strCellDataToValidate)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.xpath("td"));

				if (td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText()
						.contentEquals(m_strItemToSearch)) {
					if (td_collection.get(Integer.parseInt(m_intColIndexToValidate)).getText()
							.contentEquals(m_strCellDataToValidate)) {
						s_objlog4j.info("Texts are matching.");
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is validated");
						break;
					}
				}
				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateCellDataStoredForSpecifiedColIndex method validates the cell data
	 * for specified column index in table
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToValidate
	 *            This describes the column index number to validate for item
	 * @param m_strCellDataToValidate
	 *            This describes the cell data to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public Boolean ValidateCellDataStoredForSpecifiedColIndex(String TableXPath, String m_intColIndexToSearch,
			String m_intColIndexToValidate, String m_strCellDataToValidate) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.xpath("td"));

				if (td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText()
						.contentEquals(m_strItemToSearch)) {
					if (td_collection.get(Integer.parseInt(m_intColIndexToValidate)).getText()
							.contentEquals(m_strCellDataToValidate)) {
						s_objlog4j.info("Texts are matching.");
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is validated");
						break;
					}
				}
				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateCellDataStoredExists method validates the cell data exists
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_ShowObjXpath
	 *            This describes the Show dropdown xpath
	 * @param m_NextObjXpath
	 *            This describes the Next object xpath
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public Boolean ValidateCellDataStoredExists(String TableXPath, String m_intColIndexToSearch, String m_ShowObjXpath,
			String m_NextObjXpath) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		String Item = "50";
		try {

			do {
				WebElement element = createWebElement("EVALUATEXPATH", m_ShowObjXpath);
				List<WebElement> List = element.findElements(By.tagName("option"));
				for (WebElement option : List) {
					if (Item.equals(option.getText())) {
						option.click();
						Thread.sleep(10000);
					}
				}
				WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
				List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
				s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
				int row_num, col_num;
				row_num = 1;
				if (row_num > 1) {
					s_objlog4j.info("Clicking Next button");
					driver.findElement(By.xpath(m_NextObjXpath)).click();
					Thread.sleep(2000);
					row_num = 1;
				}
				for (WebElement trElement : tr_collection) {
					List<WebElement> td_collection = trElement.findElements(By.xpath("td"));

					if (td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText()
							.contentEquals(m_strItemToSearch)) {
						s_objlog4j.info("Texts are matching.");
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is validated");
						break;
					}
					row_num++;
				}
			} while (verifyPresenceOfElement("EVALUATEXPATH", m_NextObjXpath) && !bStatus);

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectRow method selects a row in the table
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 *//*
		 * public Boolean SelectRow(String TableXPath, String
		 * m_intColIndexToSearch, String m_strItemToSearch, String
		 * m_intColIndexToSelect) throws AWTException, InterruptedException {
		 * Boolean bStatus=false; try{ WebElement table_element =
		 * createWebElement("EVALUATEXPATH",TableXPath); List <WebElement>
		 * tr_collection=table_element.findElements(By.xpath(TableXPath+
		 * "/tbody/tr"));
		 * s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.
		 * size()); int row_num,col_num; row_num=1; for(WebElement trElement :
		 * tr_collection) { List<WebElement>
		 * td_collection=trElement.findElements(By.xpath("td"));
		 * s_objlog4j.info("No. of tds in Row No:"+row_num+" ="+td_collection
		 * .size());
		 * s_objlog4j.info("employee name ="+td_collection.get(Integer.
		 * parseInt(m_intColIndexToSearch)).getText());
		 * if(td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText
		 * ().contentEquals(m_strItemToSearch)){
		 * //s_objlog4j.info("Matched the content in row no="+row_num);
		 * if(td_collection.get(Integer.parseInt(m_intColIndexToSelect)).
		 * isDisplayed()){
		 * //s_objlog4j.info("column no selecting is "+m_intColIndexToSelect) ;
		 * td_collection.get(Integer.parseInt(m_intColIndexToSelect)).click();
		 * Thread.sleep(1000); bStatus=true;
		 * s_childExtentTest.log(LogStatus.PASS, "SelectRow",
		 * GlobalVariables.g_strStepDescription); break; } } row_num++; }
		 * }catch(Exception e){ s_childExtentTest.log(LogStatus.FAIL,
		 * "SelectRow", GlobalVariables.g_strStepDescription);
		 * e.printStackTrace(); } return bStatus; }
		 */
	/**
	 * SelectRow method selects a row in the table
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public Boolean SelectRow(String TableXPath, String m_intColIndexToSearch, String m_strItemToSearch,
			String m_intColIndexToSelect) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		try {
			if (driver.findElement(By.xpath(TableXPath)).isDisplayed()) {
				WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
				List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
				s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
				if (tr_collection.size() == 0) {
					bStatus = true;
				}
				int row_num, col_num;
				row_num = 1;
				for (WebElement trElement : tr_collection) {
					List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
					s_objlog4j.info("No. of tds in Row No:" + row_num + " =" + td_collection.size());
					s_objlog4j.info(
							"employee name =" + td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText());
					if (td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText()
							.contentEquals(m_strItemToSearch)) {
						// s_objlog4j.info("Matched the content in row
						// no="+row_num);
						if (td_collection.get(Integer.parseInt(m_intColIndexToSelect)).isDisplayed()) {
							// s_objlog4j.info("column no selecting is
							// "+m_intColIndexToSelect);
							td_collection.get(Integer.parseInt(m_intColIndexToSelect)).click();
							Thread.sleep(1000);

							// break;
						}
					}
					bStatus = true;
					row_num++;
				}
			} else {
				s_objlog4j.info("NO Row present");
				bStatus = true;
			}
		} catch (Exception e) {
			bStatus = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectRow method selects a row in the table
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public Boolean SelectRow(String TableXPath, String m_intColIndexToSearch, String m_strItemToSearch,
			String m_intColIndexToSelect, String m_ObjToSelectXPath) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		try {
			if (driver.findElement(By.xpath(TableXPath)).isDisplayed()) {
				WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
				List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
				s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
				if (tr_collection.size() == 0) {
					bStatus = true;
				}
				int row_num;
				row_num = 1;
				for (WebElement trElement : tr_collection) {
					List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
					s_objlog4j.info("No. of tds in Row No:" + row_num + " =" + td_collection.size());
					s_objlog4j.info(
							"employee name =" + td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText());
					if (td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText()
							.contentEquals(m_strItemToSearch)) {
						// s_objlog4j.info("Matched the content in row
						// no="+row_num);
						if (td_collection.get(Integer.parseInt(m_intColIndexToSelect)).isDisplayed()) {
							// s_objlog4j.info("column no selecting is
							// "+m_intColIndexToSelect);
							// driver.findElement(By.xpath(m_ObjToSelectXPath)).click();
							td_collection.get(Integer.parseInt(m_intColIndexToSelect))
									.findElement(By.xpath(m_ObjToSelectXPath)).click();
							// td_collection.get(Integer.parseInt(m_intColIndexToSelect)).click();
							Thread.sleep(1000);
							// break;
						}
					}
					bStatus = true;
					row_num++;
				}
			} else {
				s_objlog4j.info("NO Row present");
				bStatus = true;
			}
		} catch (Exception e) {
			bStatus = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectRowUsingJS method selects a row in the table using JS
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public Boolean SelectRowUsingJS(String TableXPath, String m_intColIndexToSearch, String m_strItemToSearch,
			String m_intColIndexToSelect) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
				s_objlog4j.info("No. of tds in Row No:" + row_num + " =" + td_collection.size());
				s_objlog4j
						.info("employee name =" + td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText());
				if (td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText()
						.contentEquals(m_strItemToSearch)) {
					// s_objlog4j.info("Matched the content in row
					// no="+row_num);
					if (td_collection.get(Integer.parseInt(m_intColIndexToSelect)).isDisplayed()) {
						// s_objlog4j.info("column no selecting is
						// "+m_intColIndexToSelect);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();",
								td_collection.get(Integer.parseInt(m_intColIndexToSelect)));
						// td_collection.get(Integer.parseInt(m_intColIndexToSelect)).click();
						Thread.sleep(1000);

						// break;
					}
				}
				bStatus = true;
				row_num++;
			}
		} catch (Exception e) {
			bStatus = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateCellDataExists method validates the cell data exists
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public Boolean ValidateCellDataExists(String TableXPath, String m_intColIndexToSearch, String m_strItemToSearch)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.xpath("td"));

				if (td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText()
						.contentEquals(m_strItemToSearch)) {
					s_objlog4j.info("Texts are matching.");
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
					break;
				}
				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickOnCell method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public Boolean ClickOnCell(String TableXPath, int m_intColIndexToSearch, String m_strItemToSearch,
			int m_intColIndexToSelect) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
				if (td_collection.get(m_intColIndexToSearch).getText().contentEquals(m_strItemToSearch)) {
					if (td_collection.get(m_intColIndexToSelect).isDisplayed()) {
						td_collection.get(m_intColIndexToSelect).click();
						Thread.sleep(2000);
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is successful");
						break;
					}
				}
				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * VerifyTableHeaders method validates the table headers
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_strItemToSearch
	 *            This describes the header value to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public Boolean VerifyTableHeaders(String TableXPath, String m_strItemToSearch)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/thead/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.xpath("th"));
				for (int i = 0; i < td_collection.size(); i++) {
					if (td_collection.get(i).getText().replaceAll("\\s", "").toUpperCase()
							.contentEquals(m_strItemToSearch.replaceAll("\\s", "").toUpperCase())) {
						s_objlog4j.info(td_collection.get(i).getText().replaceAll("\\s", "").toUpperCase());
						s_objlog4j.info(m_strItemToSearch.replaceAll("\\s", "").toUpperCase());
						s_objlog4j.info("Texts are matching.");
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is successful");
						break;
					}
				}
				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ShouldMatchText method validates the text from object value matches
	 * expected text using getAttribute
	 * 
	 * @param m_strText
	 *            This describes the text to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ShouldMatchText(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			s_objlog4j.info("Actual text=" + textBox.getAttribute("value").replace(" ", "").toUpperCase());
			s_objlog4j.info("Expected text=" + m_strText.replace(" ", "").toUpperCase());
			if (textBox.getAttribute("value").replace(" ", "").toUpperCase()
					.contentEquals(m_strText.replace(" ", "").toUpperCase())) {
				bStatus = true;
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is as expected");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not as expected");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * waitTillElementPresent method waits for an element presence and
	 * visibility
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Sarath Gorantla
	 */

	public boolean waitTillElementPresent(String locator, String value) throws Exception {
		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, 300);
		List<WebElement> e;
		try {
			switch (typeOfLocator.valueOf(locator)) {
			case EVALUATEXPATH:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
				e = driver.findElements(By.xpath(value));
				if (e.size() == 1) {
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				break;
			case EVALUATECSSSELECTOR:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
				e = driver.findElements(By.cssSelector(value));
				if (e.size() == 1) {
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				break;
			case EVALUATEID:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
				e = driver.findElements(By.id(value));
				if (e.size() == 1) {
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				break;
			case EVALUATELINKTEXT:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(value)));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(value)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				e = driver.findElements(By.linkText(value));
				if (e.size() == 1) {
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				break;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
		} finally {
			return bStatus;
		}

	}

	/**
	 * EnterTextAndStore method enters text into object and stores into variable
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla SQL server
	 */
	public boolean ExecuteUpdateDBQuery(String m_strSQLQuery) throws Exception {
		boolean bStatus = false;
		String strServerAddess = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBServer");
		String strDBName = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DB");
		String strDBUID = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBUserId");
		String strDBPass = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBPassword");

		String connectionUrl = "jdbc:sqlserver://" + strServerAddess + ";user=" + strDBUID + ";password=" + strDBPass
				+ ";database=" + strDBName;

		// Declare the JDBC objects.
		java.sql.Connection DBconnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			DBconnection = DriverManager.getConnection(connectionUrl);
			s_objlog4j.info("Connected to DB server.");
			// Create and execute an SQL statement that reads some data.
			stmt = DBconnection.createStatement();
			stmt.executeUpdate(m_strSQLQuery);

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (SQLException se) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			se.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		// Close the JDBC objects.
		finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
			return bStatus;
		}
	}

	/**
	 * GoBack method navigates the browser to previous page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean GoBack() throws Exception {
		boolean bStatus = false;
		// String[] strExcelInfo=null;
		try {
			// strExcelInfo=gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
			// GlobalVariables.g_strLogicalName);
			// bStatus=waitForPresenceAndVisibilityOfElement(strExcelInfo[0],strExcelInfo[1]);
			// bStatus=waitForPresenceOfElement(strExcelInfo[0],strExcelInfo[1]);
			driver.navigate().back();
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateElementColor method validates the element color using CSS value
	 * 
	 * @param m_strCSSValue
	 *            This describes the element CSS value
	 * @param m_strExpColor
	 *            This describes the element expected color
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ValidateElementColor(String m_strCSSValue, String m_strExpColor) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			String color = element.getCssValue(m_strCSSValue);
			s_objlog4j.info("Color in RGB=" + color);
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
			int hexValue1 = Integer.parseInt(hexValue[0]);
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);

			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
			s_objlog4j.info("Actual color=" + actualColor);
			if (m_strExpColor.replace("#", "").equalsIgnoreCase(actualColor.replace("#", ""))) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean ValidateMailLogs(String strColName, String strValue) {
		String strQuery = "select TOP 1 " + strColName + " from [dbo].[log_SentEmail] order by SentOn desc ";
		Boolean bStatus = false;
		try {
			String strDBResult = ExecuteDBQuery(strQuery);
			if (strDBResult.contains(strValue)) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
			} else {
				bStatus = false;
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is not validated");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * mouseOverAnElement method performs mousing hover over an element
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean mouseOverAnElement() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			Thread.sleep(1000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateTextFromExcel method verifies the text present in the excel file
	 * and column name specified
	 * 
	 * @param m_strExcelFileName
	 *            This is the excel file name with file type
	 * @param m_strColName
	 *            This is the column name in excel to verify
	 * @param m_strText
	 *            This is the text to verify
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ValidateTextFromExcel(String m_strExcelFileName, String m_strColName, String m_strText) {
		boolean bStatus = false;
		try {
			String sheetName = m_strExcelFileName.split("_Log")[0];
			String sqlQuery = null;
			if (sheetName.contains(" ")) {
				sqlQuery = "Select * from \"" + sheetName + "\"";
			} else {
				sqlQuery = "Select * from " + sheetName;
			}
			Recordset logRecordSet = GenericUtilityLibrary
					.readFromExcel(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "downloadFilepath") + "/"
							+ m_strExcelFileName, sqlQuery);
			// Recordset
			// logRecordSet=GenericUtilityLibrary.readFromExcel(m_strExcelFileName,
			// sqlQuery);
			// s_objlog4j.info("count="+logRecordSet.getCount());
			while (logRecordSet.next()) {
				s_objlog4j.info("Actual text present in excel=" + logRecordSet.getField(m_strColName));
				if (logRecordSet.getField(m_strColName).equalsIgnoreCase(m_strText)) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
					bStatus = true;
					break;
				}
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateTextFromExcel method verifies the text present in the excel file
	 * and column name specified
	 * 
	 * @param m_strExcelFileName
	 *            This is the excel file name with file type
	 * @param m_strSheetName
	 *            This is the sheet name present in excel file
	 * @param m_strColName
	 *            This is the column name in excel to verify
	 * @param m_strText
	 *            This is the text to verify
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ValidateTextFromExcelAndSheet(String m_strExcelFileName, String m_strSheetName, String m_strColName,
			String m_strText) {
		boolean bStatus = false;
		try {
			// String sheetName= m_strExcelFileName.split("_Log")[0];
			String sqlQuery = null;
			if (m_strSheetName.contains(" ")) {
				sqlQuery = "Select * from \"" + m_strSheetName + "\"";
			} else {
				sqlQuery = "Select '" + m_strColName + "' from " + m_strSheetName;
			}
			Recordset logRecordSet = GenericUtilityLibrary
					.readFromExcel(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "downloadFilepath") + "/"
							+ m_strExcelFileName, sqlQuery);
			if (logRecordSet == null) {
				if (m_strText.equalsIgnoreCase("NULL")) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
					bStatus = true;
				}
			} else {
				while (logRecordSet.next()) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
					if (m_strText.toUpperCase().equalsIgnoreCase("NULL")) {
						m_strText = "";
					}
					if (logRecordSet.getField(m_strColName).equalsIgnoreCase(m_strText)) {
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is validated");
						bStatus = true;
						break;
					}
				}
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * WriteTextIntoExcel method writes the text in the excel file and column
	 * name specified
	 * 
	 * @param m_strExcelFileName
	 *            This is the excel file name with file type
	 * @param m_strExcelSheetName
	 *            This is the sheet name in excel file specified
	 * @param m_strColName
	 *            This is the column name in excel to verify
	 * @param m_strText
	 *            This is the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean WriteTextIntoExcel(String m_strExcelFileName, String m_strExcelSheetName, String m_strColName,
			String m_strText) {
		boolean bStatus = false;
		try {
			if (!m_strText.equalsIgnoreCase("NULL")) {
				GlobalVariables.UniqueValue = m_strText;
			}
			String sqlQuery = null;
			if (m_strExcelSheetName.contains(" ")) {
				if (m_strColName.contains(" ")) {
					sqlQuery = "Update \"" + m_strExcelSheetName + "\" Set \"" + m_strColName + "\"='" + m_strText
							+ "' where Gender='Male'";
				} else {
					sqlQuery = "Update \"" + m_strExcelSheetName + "\" Set " + m_strColName + "='" + m_strText
							+ "' where Gender='Male'";
				}
			} else {
				if (m_strColName.contains(" ")) {
					sqlQuery = "Update " + m_strExcelSheetName + " Set \"" + m_strColName + "\"='" + m_strText
							+ "' where Gender='Male'";
				} else {
					sqlQuery = "Update " + m_strExcelSheetName + " Set " + m_strColName + "='" + m_strText
							+ "' where Gender='Male'";
				}
			}
			GenericUtilityLibrary
					.updateExcel(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strTestDataFilesPath")
							+ "/" + m_strExcelFileName, sqlQuery);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * WriteTextIntoExcel method writes the text in the excel file and column
	 * name specified
	 * 
	 * @param m_strFolderPath
	 *            This is the folder path where excel file is present
	 * @param m_strExcelFileName
	 *            This is the excel file name with file type
	 * @param m_strExcelSheetName
	 *            This is the sheet name in excel file specified
	 * @param m_strColName
	 *            This is the column name in excel to verify
	 * @param m_strText
	 *            This is the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean WriteTextIntoExcel(String m_strFolderPath, String m_strExcelFileName, String m_strExcelSheetName,
			String m_strColName, String m_strText) {
		boolean bStatus = false;
		try {
			if (!m_strText.equalsIgnoreCase("NULL")) {
				GlobalVariables.UniqueValue = m_strText;
			}
			String sqlQuery = null;
			if (m_strExcelSheetName.contains(" ")) {
				if (m_strColName.contains(" ")) {
					sqlQuery = "Update \"" + m_strExcelSheetName + "\" Set \"+m_strColName+\"='" + m_strText + "'";
				} else {
					sqlQuery = "Update \"" + m_strExcelSheetName + "\" Set " + m_strColName + "='" + m_strText + "'";
				}
			} else {
				if (m_strColName.contains(" ")) {
					sqlQuery = "Update " + m_strExcelSheetName + " Set \"+m_strColName+\"='" + m_strText + "'";
				} else {
					sqlQuery = "Update " + m_strExcelSheetName + " Set " + m_strColName + "='" + m_strText + "'";
				}
			}
			GenericUtilityLibrary.updateExcel(m_strFolderPath + "/" + m_strExcelFileName, sqlQuery);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * WriteTextIntoUserNameFldInExcel method writes the text into user name
	 * field in the excel file and column name specified
	 * 
	 * @param m_strExcelFileName
	 *            This is the excel file name with file type
	 * @param m_strExcelSheetName
	 *            This is the sheet name in excel file specified
	 * @param m_strColName
	 *            This is the column name in excel to write
	 * @param m_strColNameToSearch
	 *            This is the column name to search
	 * @param m_strColValueToSearch
	 *            This is the value of column name to search
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean WriteTextIntoUserNameFldInExcel(String m_strExcelFileName, String m_strExcelSheetName,
			String m_strColName, String m_strColNameToSearch, String m_strColValueToSearch) {
		boolean bStatus = false;
		try {
			String sqlQuery = null;
			// GlobalVariables.UniqueValue="hasfdghasd";
			if (m_strExcelSheetName.contains(" ")) {
				if (m_strColName.contains(" ")) {
					sqlQuery = "Update \"" + m_strExcelSheetName + "\" Set \"" + m_strColName + "\"='FEAT\\"
							+ GlobalVariables.UniqueValue + "' where " + m_strColNameToSearch + "='"
							+ m_strColValueToSearch + "'";
				} else {
					sqlQuery = "Update \"" + m_strExcelSheetName + "\" Set " + m_strColName + "='FEAT\\"
							+ GlobalVariables.UniqueValue + "' where " + m_strColNameToSearch + "='"
							+ m_strColValueToSearch + "'";
				}
			} else {
				if (m_strColName.contains(" ")) {
					sqlQuery = "Update " + m_strExcelSheetName + " Set \"" + m_strColName + "\"='FEAT\\"
							+ GlobalVariables.UniqueValue + "' where " + m_strColNameToSearch + "='"
							+ m_strColValueToSearch + "'";
				} else {
					sqlQuery = "Update " + m_strExcelSheetName + " Set " + m_strColName + "='FEAT\\"
							+ GlobalVariables.UniqueValue + "' where " + m_strColNameToSearch + "='"
							+ m_strColValueToSearch + "'";
				}
			}
			s_objlog4j.info("Excel file name="
					+ GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strTestDataFilesPath") + "/"
					+ m_strExcelFileName);
			s_objlog4j.info("SQL query=" + sqlQuery);
			GenericUtilityLibrary
					.updateExcel(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strTestDataFilesPath")
							+ m_strExcelFileName, sqlQuery);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * verifyPDFContent method verifies that the specified content in present in
	 * PDF file
	 * 
	 * @param strFilePath
	 *            This is the PDF file path
	 * @param reqTextInPDF
	 *            This is the text to validate in the above PDF file
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 * @throws Exception
	 */
	/*
	 * public boolean verifyPDFContent(String strFilePath, String reqTextInPDF)
	 * throws IOException { boolean bStatus = false; PDFParser TestPDF=null;
	 * COSDocument cosDoc=null; PDDocument pdDoc=null; try{ URL url = new
	 * URL(strFilePath); BufferedInputStream file = new
	 * BufferedInputStream(url.openStream()); PDFParser parser = new
	 * PDFParser(file); File file = new File(strFilePath); //OutputStream os=
	 * new OutputStream(); TestPDF = new PDFParser(new FileInputStream(file));
	 * TestPDF.parse();
	 * 
	 * cosDoc = TestPDF.getDocument();
	 * 
	 * PDFTextStripper pdfStripper = new PDFTextStripper(); pdDoc = new
	 * PDDocument(cosDoc);
	 * 
	 * String parsedText = pdfStripper.getText(pdDoc);
	 * s_objlog4j.info("+++++++++++++++++"); s_objlog4j.info(parsedText);
	 * s_objlog4j.info("+++++++++++++++++");
	 * 
	 * if(parsedText.contains(reqTextInPDF)) {
	 * s_childExtentTest.log(LogStatus.PASS, "verifyPDFContent",
	 * GlobalVariables.g_strStepDescription+" "+reqTextInPDF); bStatus=true; }
	 * else{ s_childExtentTest.log(LogStatus.FAIL, "verifyPDFContent",
	 * GlobalVariables.g_strStepDescription+" "+reqTextInPDF); }
	 * 
	 * }catch(Exception e){ s_childExtentTest.log(LogStatus.FAIL,
	 * "verifyPDFContent",
	 * GlobalVariables.g_strStepDescription+" "+reqTextInPDF);
	 * e.printStackTrace(); } finally{ TestPDF.clearResources(); cosDoc.close();
	 * pdDoc.close(); } return bStatus; }
	 * 
	 */
	public boolean waitForSpinner() throws Exception {
		Thread.sleep(10000);
		waitTillElementNotPresent("EVALUATEXPATH", "//*[@id='loader-image-container']/img");
		Thread.sleep(10000);

		return true;
	}

	/**
	 * waitTillElementNotPresent method waits for an element not visibile
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Sarath Gorantla
	 */
	@SuppressWarnings("finally")
	public boolean waitTillElementNotPresent(String locator, String value) throws Exception {
		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.extMediumWait);
		Thread.sleep(2000);
		try {
			switch (typeOfLocator.valueOf(locator)) {
			case EVALUATEXPATH:
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(value)));
				bStatus = true;
				break;
			case EVALUATECSSSELECTOR:
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(value)));
				bStatus = true;
				break;
			case EVALUATEID:
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(value)));
				bStatus = true;
				break;
			case EVALUATELINKTEXT:
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(value)));
				bStatus = true;
				break;
			case EVALUATENAME:
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(value)));
				bStatus = true;
				break;
			case EVALUATECLASS:
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(value)));
				bStatus = true;
				break;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			return bStatus;
		}

	}

	/**
	 * ValidateElementPropertyFromDOM method validates the element property from
	 * DOM contains expected text using JS * @param m_strPropertyName This
	 * describes the property name of object present in DOM
	 * 
	 * @param m_strPropertyValueExpected
	 *            This describes the DOM property value expected to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 *//*
		 * public boolean ValidateElementPropertyFromDOM(String
		 * m_strPropertyName, String m_strPropertyValueExpected) throws
		 * Exception { boolean bStatus = false; String[] strExcelInfo = null;
		 * try { strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.
		 * g_strObjectRepositoryFilePath, GlobalVariables.g_strLogicalName);
		 * waitForPresenceAndVisibilityOfElement(strExcelInfo[0],
		 * strExcelInfo[1]); WebElement element =
		 * createWebElement(strExcelInfo[0], strExcelInfo[1]);
		 * JavascriptExecutor js = (JavascriptExecutor) driver; Boolean
		 * propValue = (Boolean) js.executeScript("return arguments[0]." +
		 * m_strPropertyName + ";", element); s_objlog4j.info("Actual text=" +
		 * propValue.toString().toUpperCase()); s_objlog4j.info("Expected text="
		 * + m_strPropertyValueExpected.toUpperCase()); if (
		 * propValue.toString().toUpperCase().contains(
		 * m_strPropertyValueExpected.toUpperCase())) { bStatus = true;
		 * s_childExtentTest.log(LogStatus.PASS,
		 * GlobalVariables.g_strKeywordDescription,GlobalVariables.
		 * g_strKeywordDescription + m_strPropertyName +" is validated"); } }
		 * catch (Exception e) { s_childExtentTest.log(LogStatus.FAIL,
		 * GlobalVariables.g_strKeywordDescription,GlobalVariables.
		 * g_strKeywordDescription + m_strPropertyName +" is not validated");
		 * e.printStackTrace(); } return bStatus; }
		 */
	/**
	 * ValidateElementPropertyFromDOM method validates the element property from
	 * DOM contains expected text using JS * @param m_strPropertyName This
	 * describes the property name of object present in DOM
	 * 
	 * @param m_strPropertyValueExpected
	 *            This describes the DOM property value expected to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 *//*
		 * public boolean ValidateElementPropertyFromDOM(String
		 * m_strPropertyName, String m_strPropertyValueExpected) throws
		 * Exception { boolean bStatus = false; String[] strExcelInfo = null;
		 * try { strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.
		 * g_strObjectRepositoryFilePath, GlobalVariables.g_strLogicalName);
		 * waitForPresenceAndVisibilityOfElement(strExcelInfo[0],
		 * strExcelInfo[1]); WebElement element =
		 * createWebElement(strExcelInfo[0], strExcelInfo[1]);
		 * JavascriptExecutor js = (JavascriptExecutor) driver; Object propValue
		 * = js.executeScript("return arguments[0]." + m_strPropertyName + ";",
		 * element); System.out.println("Actual text=" +
		 * propValue.toString().toUpperCase());
		 * System.out.println("Expected text=" +
		 * m_strPropertyValueExpected.toUpperCase()); if
		 * (propValue.toString().toUpperCase().contains(
		 * m_strPropertyValueExpected.toUpperCase())) { bStatus = true;
		 * 
		 * } } catch (Exception e) { s_childExtentTest.log(LogStatus.FAIL,
		 * GlobalVariables.g_strKeywordDescription,
		 * GlobalVariables.g_strKeywordDescription+ " " +
		 * m_strPropertyValueExpected); e.printStackTrace(); }
		 * s_childExtentTest.log(LogStatus.PASS,
		 * GlobalVariables.g_strKeywordDescription,
		 * GlobalVariables.g_strKeywordDescription + " " +
		 * m_strPropertyValueExpected); return true; }
		 */

	/**
	 * ValidateSortinginAutoSuggest method creates list of element present in
	 * auto suggest
	 * 
	 * @param locator
	 *            This describes the value to search
	 * @return WebElement
	 * @author Shreya Gupta
	 */
	public boolean ValidateSortinginAutoSuggest(String strSortString) {
		try {
			WebElement list = driver.findElement(By.className("ac_results"));
			List<WebElement> rows = list.findElements(By.tagName("li"));
			boolean sorted = true;
			for (int i = 1; i < rows.size(); i++) {
				s_objlog4j.info("Compare1: " + rows.get(i - 1).getText().toLowerCase());
				s_objlog4j.info("Compare2: " + rows.get(i).getText().toLowerCase());
				if (rows.get(i - 1).getText().toLowerCase().replace(strSortString, "1")
						.compareTo(rows.get(i).getText().toLowerCase().replace(strSortString, "1")) > 0) {
					int intTemp = rows.get(i - 1).getText().indexOf("-");
					char strTemp = rows.get(i).getText().charAt(intTemp);
					if (intTemp > 0 && strTemp == ' ') {
						sorted = true;
					} else {
						sorted = false;
					}
				}
			}
			s_objlog4j.info("Sorting:" + sorted);
			if (sorted) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is not validated");
			}
			return sorted;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * ValidateSortingOfIDinAutoSuggest method creates list of element present
	 * in auto suggest extract the ID and validate sort on ID
	 * 
	 * @param locator
	 *            This describes the value to search
	 * @return WebElement
	 * @author Shreya Gupta
	 */
	public boolean ValidateSortingOfIDinAutoSuggest() {
		try {
			WebElement list = driver.findElement(By.className("ac_results"));
			List<WebElement> rows = list.findElements(By.tagName("li"));
			boolean sorted = true;
			for (int i = 1; i < rows.size(); i++) {

				String[] str1 = rows.get(i - 1).getText().split("-");
				String[] str2 = rows.get(i).getText().split("-");
				s_objlog4j.info("Compare1: " + str1[1].toString().toLowerCase());
				s_objlog4j.info("Compare2: " + str2[1].toString().toLowerCase());
				if (str1[1].toString().toLowerCase().compareTo(str2[1].toString().toLowerCase()) > 0) {
					sorted = false;
				}
			}
			s_objlog4j.info("Sorting:" + sorted);
			if (sorted) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is not validated");
			}
			return sorted;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
		}
		return true;
	}

	/**
	 * NavigateToDestinationPage method lands in the destination page
	 * 
	 * @param m_strSeeAllXpath
	 *            xpath of the See All link
	 * @param m_strDestLnkXpath
	 *            xpath of the destination link
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean NavigateToDestinationPage(String m_strSeeAllXpath, String m_strDestLnkXpath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			driver.get(driver.findElement(By.xpath(m_strSeeAllXpath)).getAttribute("href"));
			waitForPresenceAndVisibilityOfElement("EVALUATEXPATH", m_strDestLnkXpath);
			driver.get(driver.findElement(By.xpath(m_strDestLnkXpath)).getAttribute("href"));
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectItemFromDropDownUsingXpath method selects an item from dropdown
	 * using its xpath after clicking dropdown
	 * 
	 * @param m_strItemXpath
	 *            Dropdown item xpath to be selected
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SelectItemFromDropDownUsingXpath(String m_strItemXpath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			element.click();
			if (m_strItemXpath.endsWith("]")) {
				waitForPresenceOfElement("EVALUATEXPATH", m_strItemXpath);
				driver.findElement(By.xpath(m_strItemXpath)).click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " is selected");
			} else {
				waitForPresenceOfElement("EVALUATEXPATH", m_strItemXpath + GlobalVariables.UniqueValue + "']");
				driver.findElement(By.xpath(m_strItemXpath + GlobalVariables.UniqueValue + "']")).click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " is selected");
			}
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is not selected");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectItemFromDropDownUsingXpath method selects an item from dropdown
	 * using its xpath after clicking dropdown
	 * 
	 * @param m_strItemXpath
	 *            Dropdown item xpath to be selected
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SelectItemFromGlobVarInDropDownUsingTextContains(String m_strItemXpath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			element.click();
			waitForPresenceAndVisibilityOfElement("EVALUATEXPATH", m_strItemXpath);
			driver.findElement(By.xpath(m_strItemXpath)).click();
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is selected");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not selected");
			e.printStackTrace();
		}
		return bStatus;
	}

	// /**
	// * DownLoadPayslipAndValidateWithSalaryRegister method downloads payslip
	// of an employee and validate the values with Salary Register
	// * @param strSalRegisterFilePath This is salary register down loaded file
	// path
	// * @param strEmployeesList This is list of employees along with code
	// separated by |
	// * @return Boolean value True/False based on success of this function
	// * @author Sarath Gorantla
	// */
	// public boolean DownLoadPayslipAndValidateWithSalaryRegister(String
	// strSalRegisterFilePath, String strEmployeesList) throws Exception{
	// boolean bStatus=true;
	// String[] empArr=null;
	// try{
	// if(strEmployeesList.contains(",")){
	// empArr=strEmployeesList.split(",");
	// s_objlog4j.info("empArr length="+empArr.length);
	// }else{
	// empArr= new String[1];
	// empArr[0]=strEmployeesList;
	// }
	// for(int count=0;count<empArr.length;count++){
	// s_objlog4j.info("Employee name="+empArr[count]);
	// waitForPresenceAndVisibilityOfElement("EVALUATEID","Txt_RO");
	// WebElement element= createWebElement("EVALUATEID","Txt_RO");
	// element.clear();
	// element.sendKeys(empArr[count]);
	// waitForPresenceAndVisibilityOfElement("EVALUATEXPATH","//li[@class='ac_even
	// ac_over']");
	// element= createWebElement("EVALUATEXPATH","//li[@class='ac_even
	// ac_over']");
	// element.click();
	// waitForPresenceAndVisibilityOfElement("EVALUATEXPATH","//*[@id='empSearch']");
	// element= createWebElement("EVALUATEXPATH","//*[@id='empSearch']");
	// element.click();
	// waitForPresenceAndVisibilityOfElement("EVALUATEID","DwnLoadPDF");
	// Thread.sleep(2000);
	// element= createWebElement("EVALUATEID","DwnLoadPDF");
	// Thread.sleep(1000);
	// element.click();
	//
	// SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMM");
	// Date now = new Date();
	// String strDate = sdfDate.format(now);
	// //String
	// payslipName="Salary_Slip_"+empArr[count].split("-")[1].trim()+"_"+strDate;
	// String
	// payslipName="Salary_Slip_"+empArr[count].split("-")[1].trim()+"_201509";
	// s_objlog4j.info("Payslip name="+payslipName);
	// if(waitUntilFileDownloaded("downloads\\"+payslipName+".pdf")){
	// if(ValidatePaySlipWithSalRegister("downloads\\"+payslipName+".pdf",strSalRegisterFilePath)){
	// //bStatus=true;
	// //s_childExtentTest.log(LogStatus.PASS,
	// "DownLoadPayslipAndValidateWithSalaryRegister",
	// GlobalVariables.g_strStepDescription);
	// }else{
	// bStatus=false;
	// s_objlog4j.info("Payslip values are not matching with sal reg");
	// s_childExtentTest.log(LogStatus.FAIL,
	// "DownLoadPayslipAndValidateWithSalaryRegister",
	// GlobalVariables.g_strStepDescription);
	// //break;
	// }
	// }else{
	// bStatus=false;
	// s_objlog4j.info("File not downloaded successfully");
	// s_childExtentTest.log(LogStatus.FAIL,
	// "DownLoadPayslipAndValidateWithSalaryRegister",
	// GlobalVariables.g_strStepDescription);
	// //break;
	// }
	// driver.navigate().refresh();
	// }
	// }catch(Exception e){
	// bStatus=false;
	// s_childExtentTest.log(LogStatus.FAIL,
	// "DownLoadPayslipAndValidateWithSalaryRegister",
	// GlobalVariables.g_strStepDescription);
	// e.printStackTrace();
	// }
	// return bStatus;
	// }

	/**
	 * IsElementNotVisible method checks whether element is not Visible
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Shreya Gupta
	 */
	public boolean IsElementNotVisible(String locator, String value) throws Exception {
		boolean bStatus = false;
		try {
			switch (typeOfLocator.valueOf(locator)) {
			case EVALUATEXPATH:
				bStatus = driver.findElement(By.xpath(value)).isDisplayed();
				break;
			case EVALUATECSSSELECTOR:
				bStatus = driver.findElement(By.cssSelector(value)).isDisplayed();
				break;
			case EVALUATEID:
				bStatus = driver.findElement(By.id(value)).isDisplayed();
				break;
			case EVALUATELINKTEXT:
				bStatus = driver.findElement(By.linkText(value)).isDisplayed();
				break;
			case EVALUATENAME:
				bStatus = driver.findElement(By.linkText(value)).isDisplayed();
				break;
			case EVALUATECLASS:
				bStatus = driver.findElement(By.linkText(value)).isDisplayed();
				break;
			}
		} catch (Exception e) {
			bStatus = true;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		if (bStatus) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			return false;
		} else {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			return true;
		}

	}

	/**
	 * ScrollDownUsingXpath method scroll down the page to the particular object
	 * in a page using java script
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ScrollDownUsingXpath(String xPathString) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			// strExcelInfo=gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
			// GlobalVariables.g_strLogicalName);
			// waitForPresenceAndVisibilityOfElement(strExcelInfo[0],strExcelInfo[1]);
			// WebElement
			// xPathString=createWebElement(strExcelInfo[0],strExcelInfo[1]);
			// waitForPresenceOfElement(strExcelInfo[0],strExcelInfo[1]);
			WebElement element = driver.findElement(By.xpath(xPathString));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_UP).build().perform();
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_UP).build().perform();

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SetControlParameter method Set the control parameter as per User Entry
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SetControlParameter(String PFApplicable, String DAApplicable, String BaseApplicable,
			String EsiApplicable, String EsiMaxLimitValue, String LWFApplicable, String FoodCouponApplicable,
			String FMDApplicable, String ADApplicable, String GPApplicable, String NSRApplicable, String GRApplicable,
			String StopPayApplicable, String StopPWPApplicble, String SalRealese, String LOPAllowMonthApplicable,
			String ClaimProcessApplicable, String VouchingProcessApplicable, String strMessage,
			String strPFApplicableYESXpath, String strDAXpath, String StrBaseXpath, String strPFApplicableNoXpath,
			String strESIYesXpath, String strEsiLimitXpath, String strESINoXpath, String strLWFYesXpath,
			String strLWFNoXpath, String strFoodCouponXpath, String strFirstMonDeduXpath, String strCalanderDaysXpath,
			String strGenerationPeriodXpath, String strNegativesalaryRulePendingXpath, String StrGratuityYesXpath,
			String strGratuityNoXpath, String strStopPayYesXpath, String strStopPayWithPayXpath,
			String strSalaryReleaseXpath, String strStopPayNoXpath, String strAllowMonthLOPYesXpath,
			String strAllowMonthLOPNoXpath, String strClaimProcessXpath, String strVouchingProcessXpath,
			String strMessageXpath) throws Exception {
		Boolean bStatus = false;

		try {
			// Attendance Applicable
			Actions actions = new Actions(driver);
			WebElement We1 = createWebElement("EVALUATEXPATH", strPFApplicableYESXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We2 = createWebElement("EVALUATEXPATH", strDAXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We3 = createWebElement("EVALUATEXPATH", StrBaseXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We4 = createWebElement("EVALUATEXPATH", strPFApplicableNoXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We5 = createWebElement("EVALUATEXPATH", strESIYesXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We6 = createWebElement("EVALUATEXPATH", strEsiLimitXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strEsiLimitXpath);
			WebElement We7 = createWebElement("EVALUATEXPATH", strESINoXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We8 = createWebElement("EVALUATEXPATH", strLWFYesXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We9 = createWebElement("EVALUATEXPATH", strLWFNoXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We10 = createWebElement("EVALUATEXPATH", strFoodCouponXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We11 = createWebElement("EVALUATEXPATH", strFirstMonDeduXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We12 = createWebElement("EVALUATEXPATH", strCalanderDaysXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We13 = createWebElement("EVALUATEXPATH", strGenerationPeriodXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We14 = createWebElement("EVALUATEXPATH", strNegativesalaryRulePendingXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We15 = createWebElement("EVALUATEXPATH", StrGratuityYesXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", StrGratuityYesXpath);
			WebElement We16 = createWebElement("EVALUATEXPATH", strGratuityNoXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We17 = createWebElement("EVALUATEXPATH", strStopPayYesXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We18 = createWebElement("EVALUATEXPATH", strStopPayWithPayXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We19 = createWebElement("EVALUATEXPATH", strSalaryReleaseXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We20 = createWebElement("EVALUATEXPATH", strStopPayNoXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We21 = createWebElement("EVALUATEXPATH", strAllowMonthLOPYesXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We22 = createWebElement("EVALUATEXPATH", strAllowMonthLOPNoXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We23 = createWebElement("EVALUATEXPATH", strClaimProcessXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We24 = createWebElement("EVALUATEXPATH", strVouchingProcessXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement We25 = createWebElement("EVALUATEXPATH", strMessageXpath);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			WebElement FixedDays = createWebElement("EVALUATEXPATH", "//input[@id='FixedDAys_chk']");
			WebElement FixedDayTextbox = createWebElement("EVALUATEXPATH", "//input[@id='DayTxt_box']");
			WebElement WorkingDays = createWebElement("EVALUATEXPATH", "//input[@id='WorkingDAys_chk']");

			// PF Applicable
			if (PFApplicable.trim().equalsIgnoreCase("YES")) {
				We1.click();
				Alert alt = driver.switchTo().alert();
				alt.accept();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
				// Full Basic DA is applicable
				if (DAApplicable.trim().equalsIgnoreCase("YES")) {
					if (!We2.isEnabled() && We3.isSelected()) {
						We3.click();
						We2.click();
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription);
					} else {
						if (!We2.isSelected()) {
							We2.click();
							s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription);
						}
					}
				} else {
					if (We2.isSelected()) {
						We2.click();
					}
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				}

				// Base Value is Applicable
				if (BaseApplicable.trim().equalsIgnoreCase("YES")) {
					if (We2.isSelected() && !We3.isEnabled()) {
						We2.click();
						We3.click();
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription);
					} else {
						if (!We3.isSelected()) {
							We3.click();
							s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription);
						}
					}
				} else {
					if (We3.isSelected()) {
						We3.click();
					}
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				}
			} else {
				We4.click();
				Alert alt = driver.switchTo().alert();
				alt.accept();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			}

			// Employee State Insurance(ESI) Applicable
			if (EsiApplicable.trim().equalsIgnoreCase("YES")) {
				We5.click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
				Thread.sleep(2000);
				We6.click();
				We6.clear();
				We6.sendKeys(EsiMaxLimitValue);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			} else {
				We7.click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			}

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			// LWF Applicable
			if (LWFApplicable.trim().equalsIgnoreCase("YES")) {
				We8.click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			} else {
				We9.click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			}

			// FoodCoupon Applicable
			if (FoodCouponApplicable.trim().equalsIgnoreCase("YES")) {
				if (!We10.isSelected()) {
					We10.click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				}
			} else {
				if (We10.isSelected()) {
					We10.click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				} else {
				}
			}

			// First Month Deduction Applicable
			if (FMDApplicable.trim().equalsIgnoreCase("YES")) {
				if (We10.isSelected()) {
					if (!(We11.isSelected())) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", We11);
						// We11.click();
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription);
					} else {
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription);
					}
				} else {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", We10);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", We11);
					/*
					 * We10.click(); We11.click();
					 */
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				}
			} else {
				if (We11.isSelected()) {
					We11.click();
				}
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			}

			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();

			if (ADApplicable.trim().equalsIgnoreCase("Calendar Days")) {
				if (We12.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				} else {
					if (FixedDays.isSelected()) {
						FixedDays.click();
						We12.click();
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription);

					} else {
						if (WorkingDays.isSelected()) {
							WorkingDays.click();
							We12.click();
							s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription);
						}
					}
				}
			} else {
				if (ADApplicable.trim().equalsIgnoreCase("Fixed Days")) {
					if (FixedDays.isSelected()) {
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription);
					} else {
						if (We12.isSelected()) {
							We12.click();
							FixedDays.click();
							s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription);
							FixedDayTextbox.sendKeys("30");
							s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription);
						} else {
							if (WorkingDays.isSelected()) {
								WorkingDays.click();
								FixedDays.click();
								s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
										GlobalVariables.g_strKeywordDescription);
								FixedDayTextbox.sendKeys("30");
								s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
										GlobalVariables.g_strKeywordDescription);
							}
						}
					}
				} else {
					if (ADApplicable.trim().equalsIgnoreCase("Working Days")) {
						if (WorkingDays.isSelected()) {
							s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription);
						} else {
							if (We12.isSelected()) {
								We12.click();
								WorkingDays.click();
								s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
										GlobalVariables.g_strKeywordDescription);

							} else {
								if (FixedDays.isSelected()) {
									FixedDays.click();
									WorkingDays.click();
									s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
											GlobalVariables.g_strKeywordDescription);
								}
							}
						}

					}
				}
			}

			// Generation Period Applicable
			if (GPApplicable.trim().equalsIgnoreCase("Monthly")) {
				// We13.click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			} else {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			}

			// ScrollToTop();
			Thread.sleep(2000);
			// Negative Salary Applicable
			/*
			 * ScrollToBottom(); Thread.sleep(1000); Actions actions = new
			 * Actions(driver);
			 */
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();

			jse.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(1000);
			if (NSRApplicable.trim().equalsIgnoreCase("Pending")) {
				// We14.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", We14);

				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			}

			// Gratuity Rule Applicable
			if (GRApplicable.trim().equalsIgnoreCase("YES")) {
				// We15.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", We15);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			} else {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", We16);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			}

			// Stop Pay Applicable
			if (StopPayApplicable.trim().equalsIgnoreCase("YES")) {
				We17.click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription); // Enter
				// release
				// salary
				We19.click();
				We19.clear();
				// We19.sendKeys(SalRealese);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", We19);
				js.executeScript("arguments[0].value = '" + SalRealese + "';", We19);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			} else {
				We20.click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			}

			// stop pay with pay applicable
			if (StopPWPApplicble.trim().trim().equalsIgnoreCase("YES")) {
				We17.click();
				if (!We18.isSelected()) {
					We18.click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				} else {
				}
			} else {
				if (We18.isSelected()) {
					We18.click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				}
			}

			// LOP allow month Applicable
			if (LOPAllowMonthApplicable.trim().equalsIgnoreCase("YES")) {
				We21.click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			} else {
				We22.click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription);
			}

			// Vouching Process Applicable
			if (VouchingProcessApplicable.trim().equalsIgnoreCase("YES")) {
				if (!We24.isSelected()) {
					We24.click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				} else {
				}
			} else {
				if (We24.isSelected()) {
					We24.click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				} else {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				}
			}

			// Claim Process Applicable
			if (ClaimProcessApplicable.trim().equalsIgnoreCase("YES")) {
				if (!We23.isSelected()) {
					We23.click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				} else {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				}
			} else {
				if (We23.isSelected() && !We23.isEnabled()) {
					We24.click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				} else if (We23.isSelected()) {
					We23.click();
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				} else {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription);
				}
			}

			We25.click();
			Thread.sleep(1000);
			We25.clear();
			Thread.sleep(1000);
			// We25.sendKeys(strMessage);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", We25);
			js.executeScript("arguments[0].value = '" + strMessage + "';", We25);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateControlParameter method Validate the control parameter as per
	 * Previous Entry
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ValidateControlParameter(String PFApplicable, String DAApplicable, String BaseApplicable,
			String EsiApplicable, String EsiMaxLimitValue, String LWFApplicable, String FoodCouponApplicable,
			String FMDApplicable, String ADApplicable, String GPApplicable, String NSRApplicable, String GRApplicable,
			String StopPayApplicable, String StopPWPApplicble, String SalRealese, String LOPAllowMonthApplicable,
			String ClaimProcessApplicable, String VouchingProcessApplicable, String strMessage,
			String strPFApplicableYESXpath, String strDAXpath, String StrBaseXpath, String strPFApplicableNoXpath,
			String strESIYesXpath, String strEsiLimitXpath, String strESINoXpath, String strLWFYesXpath,
			String strLWFNoXpath, String strFoodCouponXpath, String strFirstMonDeduXpath, String strCalanderDaysXpath,
			String strGenerationPeriodXpath, String strNegativesalaryRulePendingXpath, String StrGratuityYesXpath,
			String strGratuityNoXpath, String strStopPayYesXpath, String strStopPayWithPayXpath,
			String strSalaryReleaseXpath, String strStopPayNoXpath, String strAllowMonthLOPYesXpath,
			String strAllowMonthLOPNoXpath, String strClaimProcessXpath, String strVouchingProcessXpath,
			String strMessageXpath) throws Exception {
		Boolean bStatus = false;
		Boolean bStatus1 = true;

		try {
			WebElement We1 = createWebElement("EVALUATEXPATH", strPFApplicableYESXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strPFApplicableYESXpath);
			WebElement We2 = createWebElement("EVALUATEXPATH", strDAXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strDAXpath);
			WebElement We3 = createWebElement("EVALUATEXPATH", StrBaseXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", StrBaseXpath);
			WebElement We4 = createWebElement("EVALUATEXPATH", strPFApplicableNoXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strPFApplicableNoXpath);
			WebElement We5 = createWebElement("EVALUATEXPATH", strESIYesXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strESIYesXpath);
			WebElement We6 = createWebElement("EVALUATEXPATH", strEsiLimitXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strEsiLimitXpath);
			WebElement We7 = createWebElement("EVALUATEXPATH", strESINoXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strESINoXpath);
			WebElement We8 = createWebElement("EVALUATEXPATH", strLWFYesXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strLWFYesXpath);
			WebElement We9 = createWebElement("EVALUATEXPATH", strLWFNoXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strLWFNoXpath);
			WebElement We10 = createWebElement("EVALUATEXPATH", strFoodCouponXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strFoodCouponXpath);
			WebElement We11 = createWebElement("EVALUATEXPATH", strFirstMonDeduXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strFirstMonDeduXpath);
			WebElement We12 = createWebElement("EVALUATEXPATH", strCalanderDaysXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strCalanderDaysXpath);
			WebElement We13 = createWebElement("EVALUATEXPATH", strGenerationPeriodXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strGenerationPeriodXpath);
			WebElement We14 = createWebElement("EVALUATEXPATH", strNegativesalaryRulePendingXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strNegativesalaryRulePendingXpath);
			WebElement We15 = createWebElement("EVALUATEXPATH", StrGratuityYesXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", StrGratuityYesXpath);
			WebElement We16 = createWebElement("EVALUATEXPATH", strGratuityNoXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strGratuityNoXpath);
			WebElement We17 = createWebElement("EVALUATEXPATH", strStopPayYesXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strStopPayYesXpath);
			WebElement We18 = createWebElement("EVALUATEXPATH", strStopPayWithPayXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strStopPayWithPayXpath);
			WebElement We19 = createWebElement("EVALUATEXPATH", strSalaryReleaseXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strSalaryReleaseXpath);
			WebElement We20 = createWebElement("EVALUATEXPATH", strStopPayNoXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strStopPayNoXpath);
			WebElement We21 = createWebElement("EVALUATEXPATH", strAllowMonthLOPYesXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strAllowMonthLOPYesXpath);
			WebElement We22 = createWebElement("EVALUATEXPATH", strAllowMonthLOPNoXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strAllowMonthLOPNoXpath);
			WebElement We23 = createWebElement("EVALUATEXPATH", strClaimProcessXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strClaimProcessXpath);
			WebElement We24 = createWebElement("EVALUATEXPATH", strVouchingProcessXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strVouchingProcessXpath);
			WebElement We25 = createWebElement("EVALUATEXPATH", strMessageXpath);
			s_childExtentTest.log(LogStatus.PASS, "Created web element", strMessageXpath);
			WebElement FixedDays = createWebElement("EVALUATEXPATH", "//input[@id='FixedDAys_chk']");
			WebElement FixedDayTextbox = createWebElement("EVALUATEXPATH", "//input[@id='DayTxt_box']");
			WebElement WorkingDays = createWebElement("EVALUATEXPATH", "//input[@id='WorkingDAys_chk']");

			// PF Applicable
			if (PFApplicable.trim().equalsIgnoreCase("YES")) {
				if (We1.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter", "PF appilcable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"PF Applicable expected= YES and Actual=NO");
				}
			} else {
				if (We4.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter", "PF appilcable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"PF Applicable expected= NO and Actual=YES");
				}
			}

			// PF Basic DA is Applicable
			if (DAApplicable.trim().equalsIgnoreCase("YES")) {
				if (We2.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Basic DA appilcable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Basic DA Applicable expected= YES and Actual=NO");
					// Assert.assertTrue(We2.isSelected(), "Basic DA Applicable
					// expected= YES and Actual=NO");
				}
			} else {
				if (!(We2.isSelected())) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Basic DA appilcable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Basic DA Applicable expected= NO and Actual=YES");
					// Assert.assertTrue(!(We2.isSelected()), "Basic DA
					// Applicable expected= YES and Actual=NO");
				}
			}

			// PF Base value is Applicable
			if (BaseApplicable.trim().equalsIgnoreCase("YES")) {
				if (We3.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"PF Base Value appilcable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"PF BaseValue  expected= YES and Actual=NO");
					// Assert.assertTrue(We3.isSelected(), "Basic DA Applicable
					// expected= YES and Actual=NO");
				}
			} else {
				if (!(We3.isSelected())) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"PF Base Value appilcable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"PF BaseValue  expected= NO and Actual= YES");
					// Assert.assertTrue(!(We3.isSelected()), "Basic DA
					// Applicable expected= NO and Actual=YES");
				}
			}

			// Employee State Insurance(ESI) Applicable
			if (EsiApplicable.trim().equalsIgnoreCase("YES")) {
				if (We5.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter", "ESI appilcable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"ESI Applicable expected= YES and Actual= NO");
				}
				String ActualESIMaxLimit = We6.getAttribute("value");
				if (ActualESIMaxLimit.contentEquals(EsiMaxLimitValue)) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"ESI Max limit expected and actual values are matching.");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"ESI Max Limit Actual=" + ActualESIMaxLimit + " and Expected=" + EsiMaxLimitValue);
				}
			} else {
				if (We7.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter", "ESI appilcable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"ESI Applicable expected= NO and Actual= YES");
				}
				if (!(We6.isEnabled())) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"ESI Max limit field is disabled");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"ESI Max Limit field is not disabled.");
				}
			}

			// LWF Applicable
			if (LWFApplicable.trim().equalsIgnoreCase("YES")) {
				if (We8.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter", "LWF appilcable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"LWF Applicable expected= YES and Actual=NO");
				}
			} else {
				if (We9.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter", "LWF appilcable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"LWF Applicable expected= NO and Actual=YES");
				}
			}

			// FoodCoupon Applicable
			if (FoodCouponApplicable.trim().equalsIgnoreCase("YES")) {
				if ((We10.isSelected() || !(We10.isEnabled()))) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Food Coupon appilcable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Food Coupon Applicable expected= YES and Actual=NO");
				}
			} else {
				if (!(We10.isSelected())) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Food Coupon appilcable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Food Coupon Applicable expected= NO and Actual=YES");
				}
			}

			// First Month Deduction Applicable
			if (FMDApplicable.trim().equalsIgnoreCase("YES")) {
				if ((We11.isSelected())) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"First month appilcable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"First month Applicable expected= YES and Actual=NO");
				}
			} else {
				if (!(We11.isSelected())) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"First month appilcable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"First month Applicable expected= NO and Actual=YES");
				}
			}

			// Attendance Applicable
			if (ADApplicable.trim().equalsIgnoreCase("Calendar Days")) {
				if (We12.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Attendance Applicable is set as Calender days");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Attendance Applicable is not set as Calender days");
				}
			} else {
				if (ADApplicable.trim().equalsIgnoreCase("Fixed Days")) {
					if (FixedDays.isSelected()) {
						s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
								"Attendance Applicable is set as Fixed days");
					} else {
						if (ADApplicable.trim().equalsIgnoreCase("Working Days")) {
							if (FixedDays.isSelected()) {
								s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
										"Attendance Applicable is set as Working days");
							}
						}
					}
				}
			}

			// Generation Period Applicable
			if (GPApplicable.trim().equalsIgnoreCase("Monthly")) {
				if (We13.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"generation Period is set as Monthly");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"generation Period is not set as Monthly");
				}
			}

			ScrollToTop();
			Thread.sleep(2000);
			// Negative Salary Applicable
			ScrollToBottom();
			Thread.sleep(1000);
			/*
			 * Actions actions = new Actions(driver);
			 * actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_UP).build().
			 * perform();
			 * actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_UP).build().
			 * perform(); Thread.sleep(1000);
			 */

			if (NSRApplicable.trim().equalsIgnoreCase("Pending")) {
				if (We14.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Negative Salary is set as Pending");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Negative Salary is not set as Pending");
				}
			}

			// Gratuity Rule Applicable
			if (GRApplicable.trim().equalsIgnoreCase("YES")) {
				if (We15.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Gratuity rule Applicable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Gratuity rule Applicable expected= YES and Actual=NO");
				}
			} else {
				if (We16.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Gratuity rule Applicable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Gratuity rule Applicable expected= NO and Actual=YES");
				}
			}

			// Stop Pay Applicable
			if (StopPayApplicable.trim().equalsIgnoreCase("YES")) {
				if (We17.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Stop Pay Applicable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Stop Pay Applicable expected= YES and Actual=NO");
				}
				// Enter release salary
				String ActReleasedSalary = We19.getAttribute("value");
				if (ActReleasedSalary.contentEquals(SalRealese)) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Actual released salary and expected Salary are matching");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Actual released salary=" + ActReleasedSalary + " and expected Salary=" + SalRealese);
				}
			} else {
				if (We20.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"First month Applicable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"First month Applicable expected= NO and Actual=YES");
				}
			}

			// stop pay with pay applicable
			if (StopPWPApplicble.trim().trim().equalsIgnoreCase("YES")) {
				if (We18.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Stop PayWithPay Applicable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Stop PayWithPay Applicable expected= YES and Actual=NO");
				}
			} else {
				if (!(We18.isSelected())) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Stop PayWithPay Applicable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Stop PayWithPay Applicable expected= NO and Actual=YES");
				}
			}

			// LOP allow month Applicable
			if (LOPAllowMonthApplicable.trim().equalsIgnoreCase("YES")) {
				if (We21.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"LOP Allow Month Applicable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"LOP Allow Month Applicable expected= YES and Actual=NO");
				}
			} else {
				if (We22.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"LOP Allow Month Applicable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"LOP Allow Month Applicable expected= NO and Actual=YES");
				}
			}

			// Claim Process Applicable
			if (ClaimProcessApplicable.trim().equalsIgnoreCase("YES")) {
				if (We23.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Claim Process Applicable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Claim Process Applicable expected= YES and Actual=NO");
				}
			} else {
				if (!(We23.isSelected())) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Claim Process Applicable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Claim Process Applicable expected= NO and Actual=YES");
				}
			}
			// Vouching Process Applicable
			if (VouchingProcessApplicable.trim().equalsIgnoreCase("YES")) {
				if (We24.isSelected()) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Vouching Process Applicable is set as YES");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Vouching Process Applicable expected= YES and Actual=NO");
				}
			} else {
				if (!(We24.isSelected())) {
					s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
							"Vouching Process Applicable is set as NO");
				} else {
					bStatus1 = false;
					s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
							"Vouching Process Applicable expected= NO and Actual=YES");
				}
			}

			// Message
			String Message = We25.getAttribute("value");
			if (Message.contentEquals(strMessage)) {
				s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter",
						"Actual Message and expected Message  are matching");
			} else {
				bStatus1 = false;
				s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter",
						"Actual Message and expected Message  are not matching");
			}
			s_childExtentTest.log(LogStatus.PASS, "ValidateControlParameter", GlobalVariables.g_strStepDescription);
			if (bStatus1) {
				bStatus = true;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, "ValidateControlParameter", "Failed to Validate Control Parameter ");
			e.printStackTrace();
		}
		return bStatus;
	}

	//// /**
	//// * verifyPDFContent method verifies that the specified content in
	//// present in PDF file
	//// * @param strFilePath This is the PDF file path
	//// * @param reqTextInPDF This is the text to validate in the above PDF
	//// file
	//// * @return Boolean value True/False based on success of this function
	//// * @author Sarath Gorantla
	//// */
	////
	//// public boolean ValidateNandMReportOfExcel(String
	//// strReportExcelFilePath) throws IOException {
	//// boolean bStatus = false;
	//// boolean bStatus1=true;
	//// try{
	//// s_objlog4j.info("Entered into validate excel function");
	//// /*HashMap<String,String> hm= new HashMap<String,String>();
	//// hm.put("EmployeeID", parsedText.split("Employee Code : ")[1].split("
	//// ")[0]);
	//// hm.put("EmployeeName", parsedText.split("&&Name : ")[1].split(" ")[0]);
	//// hm.put("Designation", parsedText.split("&&Designation : ")[1].split("
	//// Cities :")[0]);
	//// hm.put("Location", parsedText.split("Cities : ")[1].split("&&")[0]);
	//// hm.put("Department", parsedText.split("&&Department : ")[1].split("
	//// ")[0]);
	//// SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
	//// SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
	//// Date date = format1.parse(parsedText.split("&&Date of Joining :
	//// ")[1].split(" ")[0]);
	//// s_objlog4j.info(format2.format(date));
	//// hm.put("Date of Joining", format2.format(date));
	//// s_childExtentTest.log(LogStatus.PASS, "***********************",
	//// "Validation Start
	//// for Employee ID="+hm.get("EmployeeID"));
	////
	//// hm.put("Net Pay", hm.remove("Net Salary"));
	//// hm.put("Gross Earnings", hm.remove("Total Earning"));
	//// */
	//// String g_strSalaryRegistersql="Select * from CurrentSalaryDetails";
	//// /**Get the Recordset Object from Salary Register*/
	//// Recordset
	//// objRSSalReg=GenericUtilityLibrary.readFromExcelFromSpecRow(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL",
	//// "downloadFilepath")+"/"+"CurrentSalaryDetails.xls",
	//// g_strSalaryRegistersql,"1");
	//// s_objlog4j.info("record set length="+objRSSalReg.getCount());
	//// s_objlog4j.info(objRSSalReg.getFieldNames().get(1));
	//// s_objlog4j.info(objRSSalReg.getFieldNames().get(1));
	//// objRSSalReg.moveNext();
	////
	//// for(int i=0;i<objRSSalReg.getFieldNames().size();i++){
	//// s_objlog4j.info(i+"="+objRSSalReg.getField(objRSSalReg.getFieldNames().get(i)));
	//// }
	////
	//// /* s_objlog4j.info(hm);
	//// Set setOfKeys = hm.keySet();
	//// Iterator iterator = setOfKeys.iterator();
	////
	//// while (iterator.hasNext()) {
	//// String key = (String) iterator.next();
	//// s_objlog4j.info("Keyname="+key);
	//// s_objlog4j.info("value=="+objRSSalReg.getField(key).replace(",",
	//// ""));
	//// if(objRSSalReg.getField(key).replace(",",
	//// "").contentEquals((String)hm.get(key))){
	//// s_childExtentTest.log(LogStatus.PASS, "ValidatePaySlipWithSalRegister",
	//// key+"::
	//// PaySlip="+(String)hm.get(key)+"
	//// SalaryRegister="+objRSSalReg.getField(key).replace(",", ""));
	//// } else{
	//// bStatus1=false;
	//// s_childExtentTest.log(LogStatus.FAIL, "ValidatePaySlipWithSalRegister",
	//// key+"::
	//// PaySlip="+(String)hm.get(key)+"
	//// SalaryRegister="+objRSSalReg.getField(key).replace(",", ""));
	//// //break;
	//// }
	//// }*/
	////
	//// }catch(Exception e){
	//// bStatus1=false;
	//// s_childExtentTest.log(LogStatus.FAIL, "ValidatePaySlipWithSalRegister",
	//// GlobalVariables.g_strStepDescription);
	//// e.printStackTrace();
	//// }
	//// return bStatus1;
	// }

	/**
	 * ScrollToViewElement method enters text into object using java script
	 * method
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ScrollToViewElement() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			// waitForPresenceAndVisibilityOfElement(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", textBox);
			// js.executeScript("arguments[0].click();", textBox);
			// js.executeScript("arguments[0].value = '"+m_strText+"';",
			// textBox);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CountMappingStatusFromAllPages method counts and validates Mapped and
	 * Pending templates.
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index to be selected.
	 * @param strSearchText
	 *            This describes the text to be searched
	 * @param strTotalXpath
	 *            This describes the xpath of total templates.
	 * @param strDoneXpath
	 *            This describes the xpath of Done templates.
	 * @param strPendingXpath
	 *            This describes the xpath of Pending templates.
	 * @author Shreya Gupta
	 */
	public Boolean countMappingStatusFromAllPages(String TableXPath, String m_intColIndexToSearch, String strSearchText,
			String strTotalXpath, String strDoneXpath, String strPendingXpath)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		String m_NextXpath = "//a[text()='Next']";
		Integer intDone = 0;
		Integer intPending = 0;
		int row_num = 0;
		try {
			if (driver.findElement(By.xpath(TableXPath)).isDisplayed()) {
				while (driver.findElements(By.xpath(m_NextXpath)).size() > 0) {
					Thread.sleep(5000);
					WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
					List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
					if (tr_collection.size() == 0) {
						bStatus = true;
					}
					for (WebElement trElement : tr_collection) {
						// String m_intColIndexToSearch="8";
						List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
						if (td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText().toLowerCase()
								.contentEquals("done")) {
							intDone++;
						} else if (td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText().toLowerCase()
								.contentEquals("pending")) {
							intPending++;
						}
						bStatus = true;
						row_num++;
						s_objlog4j
								.info("Cols =" + td_collection.get(Integer.parseInt(m_intColIndexToSearch)).getText());
					}
					// ScrollToBottom();

					// Thread.sleep(2000);
					if (driver.findElements(By.xpath(m_NextXpath)).size() != 0) {
						WebElement WENextClick = driver.findElement(By.xpath(m_NextXpath));
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", WENextClick);
					}
					s_objlog4j.info(intDone);
					s_objlog4j.info(intPending);
				}
			} else {
				s_objlog4j.info("NO Row present");
				bStatus = true;
			}
		} catch (Exception e) {
			bStatus = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		Integer intTotal = intDone + intPending;
		s_objlog4j.info("Total: " + row_num);

		if (strSearchText.toLowerCase().contains("all")) {
			if (driver.findElement(By.xpath(strTotalXpath)).getText().contains(intTotal.toString())) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated.");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + "Total Templates mismatched. Expected: " + intTotal
								+ "; Actual: " + driver.findElement(By.xpath(strTotalXpath)).getText());
			}

			if (driver.findElement(By.xpath(strDoneXpath)).getText().contains(intDone.toString())) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " Total Mapped Templates count is validated.");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + "Total Mapped Templates mismatched. Expected: "
								+ intDone + "; Actual: " + driver.findElement(By.xpath(strDoneXpath)).getText());
			}

			if (driver.findElement(By.xpath(strPendingXpath)).getText().contains(intPending.toString())) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " Total Pending Templates count is validated.");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " Total Pending Templates mismatched. Expected: "
								+ intPending + "; Actual: " + driver.findElement(By.xpath(strPendingXpath)).getText());
			}
		} else if (strSearchText.toLowerCase().contains("done")) {
			if (intPending > 0 && driver.findElement(By.xpath(strDoneXpath)).getText().contains(intDone.toString())) {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription
								+ "The count of Pending is greater than 0, which is ex ecepted to be 0");
			} else {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " Validated Done tempates count");
			}
		} else if (strSearchText.toLowerCase().contains("pending")) {
			if (intDone > 0
					&& driver.findElement(By.xpath(strPendingXpath)).getText().contains(intPending.toString())) {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription
								+ " The count of Done Templates is greater than 0, which is ex ecepted to be 0");
			} else {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " Validated Pending tempates count");
			}
		}
		return true;
	}

	/**
	 * validateSortingOfColumn method validates if the columns are in sorted
	 * order or not.
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndex
	 *            This describes the column xpath
	 * @param strSortingType
	 *            This describes the sorting type-Ascending or Descending
	 * @author Shreya Gupta
	 */
	public Boolean validateSortingOfColumn(String TableXPath, String m_intColIndex, String strSortingType)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		boolean sorted = true;
		int row_num = 1;
		try {
			if (driver.findElement(By.xpath(TableXPath)).isDisplayed()) {
				Thread.sleep(5000);
				WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
				List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
				if (tr_collection.size() == 0) {
					bStatus = true;
				}
				List list = new ArrayList();
				List list_sort = new ArrayList();

				for (int i = 0; i < tr_collection.size() - 1; i++) {
					String strElement = tr_collection.get(i).findElements(By.xpath("td"))
							.get(Integer.parseInt(m_intColIndex)).getText().toLowerCase();
					list.add(strElement);
					list_sort.add(strElement);
				}
				Collections.sort(list_sort);
				;

				if (strSortingType.equalsIgnoreCase("descending")) {
					Collections.reverse(list_sort);
				}

				if (list.equals(list_sort)) {
					sorted = true;
				} else {
					sorted = false;
				}
			}
			if (!sorted) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
			} else {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
			}

		} catch (Exception e) {
			bStatus = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * validatePagination method validates the pagination elements.
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intNoOfRecords
	 *            This describes the number of records selected in pagination
	 * @author Shreya Gupta
	 */
	public Boolean validatePagination(String TableXPath, String m_intNoOfRecords)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		String m_NextXpath = "//a[text()='Next']";
		String m_LastXpath = "//a[text()='Last']";
		try {
			if (driver.findElement(By.xpath(TableXPath)).isDisplayed()) {
				if (driver.findElements(By.xpath(m_NextXpath)).size() > 0) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
				} else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is not validated");
				}

				if (driver.findElements(By.xpath(m_LastXpath)).size() > 0) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
				} else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is not validated");
				}

				Thread.sleep(5000);
				WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
				List<WebElement> tr_collection = table_element.findElements(By.xpath(TableXPath + "/tbody/tr"));
				Integer m_size = tr_collection.size();
				if (m_size.toString().equals(m_intNoOfRecords)) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
					s_objlog4j.info("Pass");
				} else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is not validated");
				}
			}
		} catch (Exception e) {
			bStatus = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return true;

	}

	/**
	 * Exists method checks for an element is present and visible
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Shreya Gupta
	 */
	public boolean Exists(String strXpath, String strMessage) throws Exception {
		boolean bStatus = false;
		try {
			if (strXpath.contains("|")) {
				String[] arrXpath = strXpath.split("\\|");
				String[] arrMessage = strMessage.split("\\|");
				Integer intI = 0;
				for (String strXpath1 : arrXpath) {

					if (waitForPresenceAndVisibilityOfElement("EVALUATEXPATH", strXpath1)) {
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is validated");
						bStatus = true;
					} else {
						s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is not validated");
					}
					intI++;
				}
			} else {
				if (waitForPresenceAndVisibilityOfElement("EVALUATEXPATH", strXpath)) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
					bStatus = true;
				} else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is not validated");
				}
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTextAndStore method enters text into object and stores into variable
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla SQL server
	 */
	public String ExecuteDBQuery(String m_strSQLQuery) throws Exception {
		String strServerAddess = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBServer");
		String strDBName = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DB");
		String strDBUID = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBUserId");
		String strDBPass = GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_DBPassword");

		String connectionUrl = "jdbc:sqlserver://" + strServerAddess + ";user=" + strDBUID + ";password=" + strDBPass
				+ ";database=" + strDBName;

		// Declare the JDBC objects.
		java.sql.Connection DBconnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			DBconnection = DriverManager.getConnection(connectionUrl);
			s_objlog4j.info("Connected to DB server.");
			// Create and execute an SQL statement that reads some data.
			stmt = DBconnection.createStatement();
			rs = stmt.executeQuery(m_strSQLQuery);
			boolean val = rs.next();
			// rs.getString("unique");
			if (val == false) {
				return "null";
			} else {
				// rs.next();
				s_objlog4j.info(rs.getObject(1));
				s_objlog4j.info("Output is" + rs.getString(1));
				return rs.getString(1);
			}

		} catch (SQLException se) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			se.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		// Close the JDBC objects.
		finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		return rs.getString(1);
	}

	/**
	 * validateFromDB method writes unique text in the excel file and column
	 * name specified
	 * 
	 * @param strQuery
	 *            This is the excel file name with file type
	 * @param strValueToCompare
	 *            This is the sheet name in excel file specified
	 * @return Boolean value True/False based on success of this function
	 * @author Shreya Gupta
	 */
	public boolean validateFromDB(String strQuery, String strValueToCompare) {
		String strResult = null;
		Boolean status = false;
		try {
			strResult = ExecuteDBQuery(strQuery);
			if (strResult.trim().toString().equalsIgnoreCase(strValueToCompare.toString().trim())) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
				status = true;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated" + "Expected: " + strResult
							+ "; Actual: " + strValueToCompare);
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			status = false;
		}
		return status;
	}

	/**
	 * readFromExcelUsingRC method reads a cell from excel based on row and
	 * column
	 * 
	 * @param strFilePath
	 *            will have the path of excel.
	 * @param intRowIndex
	 *            will have the cell Row to be read
	 * @param intColIndex
	 *            will have the cell Col to be read
	 * @param strToCompare
	 *            will have String to be compared.
	 * @return Boolean value True/False based on success of this function
	 * @author Shreya Gupta
	 * @throws InvalidFormatException
	 * @throws InterruptedException
	 */
	public boolean readFromExcelUsingRC(String strFilePath, String intRowIndex, String intColIndex, String strToCompare)
			throws IOException, InvalidFormatException, InterruptedException {
		File file = new File("C:\\FEAT\\PeopleWorks\\PWLite\\src\\test\\resources\\TestData\\result.txt");

		try {
			file.delete();
		} catch (Exception e) {
		}

		String strScrptExec = "cscript.exe C:\\FEAT\\PeopleWorks\\PWLite\\src\\test\\resources\\TestData\\ReadExcel.vbs "
				+ " " + strFilePath + " " + intRowIndex + " " + intColIndex + " \"" + strToCompare + "\"";
		Process process = Runtime.getRuntime().exec(strScrptExec);

		Thread.sleep(10000);
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\FEAT\\PeopleWorks\\PWLite\\src\\test\\resources\\TestData\\result.txt"));

		String strResult = br.readLine();
		s_objlog4j.info("output: " + strResult);
		if (strResult.trim().equalsIgnoreCase("true")) {
			s_childExtentTest.log(LogStatus.PASS, "readFromExcelUsingRC", "Validated value from Excel Passed");

			return true;
		} else {
			s_childExtentTest.log(LogStatus.FAIL, "readFromExcelUsingRC",
					"Validated value from Excel Failed, Expected: " + strToCompare);
			return false;
		}
	}

	/**
	 * WriteUniqueValueIntoExcel method writes unique text in the excel file and
	 * column name specified
	 * 
	 * @param m_strExcelFileName
	 *            This is the excel file name with file type
	 * @param m_strExcelSheetName
	 *            This is the sheet name in excel file specified
	 * @param m_strColName
	 *            This is the column name in excel to write
	 * @param m_varName
	 *            This is the text to specify in which row to enter text
	 * @return Boolean value True/False based on success of this function
	 * @author Shreya Gupta
	 */
	public boolean WriteUniqueValueIntoExcel(String m_strExcelFileName, String m_strExcelSheetName, String m_strColName,
			String m_varName) {
		boolean bStatus = false;
		String m_strText = null;
		try {
			String sqlQuery = null;
			String m_strText_Query = "Select 'EN'+CONVERT(varchar,DATEPART(yy,getdate()))+ CONVERT(varchar,datepart(mm,getdate())) + CONVERT(varchar,datepart(dd,getdate()))+ CONVERT(varchar,datepart(HH,getdate()))+ CONVERT(varchar,datepart(MI,getdate()))+ CONVERT(varchar,datepart(SS,getdate()))+ CONVERT(varchar,datepart(MS,getdate())) as 'unique'";
			m_strText = ExecuteDBQuery(m_strText_Query);
			sqlQuery = "Update " + m_strExcelSheetName + " Set " + m_strColName + "='" + m_strText + "' where ID='"
					+ m_varName + "'";
			s_objlog4j.info(sqlQuery);
			GenericUtilityLibrary
					.updateExcel(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strTestDataFilesPath")
							+ "/" + m_strExcelFileName, sqlQuery);
			// s_childExtentTest.log(LogStatus.PASS,
			// "WriteUniqueValueIntoExcel",
			// GlobalVariables.g_strStepDescription+" "+m_strText);
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/*
	 * clearCache method clears cookies
	 * 
	 * @return Boolean value True/False based on success of this function
	 * 
	 * @author Shreya Gupta
	 */
	public boolean clearCache() {
		driver.manage().deleteAllCookies();
		return true;
	}

	/*
	 * SelectRowFromMultiPage method selects a row in the table using JS
	 * 
	 * @param TableXPath This describes the table xpath
	 * 
	 * @param m_intColIndexToSearch This describes the column index number to
	 * search for item
	 * 
	 * @param m_strItemToSearch This describes the item to search
	 * 
	 * @param m_intColIndexToSelect This describes the column index number to
	 * select
	 * 
	 * @return Boolean value True/False based on success of this function
	 * 
	 * @author Shreya Gupta
	 */
	public Boolean SelectRowFromMultiPage(String TableXPath, String m_intColIndexToSearch, String m_strItemToSearch,
			String m_intColIndexToSelect, String m_ObjToSelectXPath) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		try {
			String m_NextXpath = "//a[contains(.,'Next')]";
			while (driver.findElements(By.xpath(m_NextXpath)).size() > 0) {
				WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);

				// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
				// s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE =
				// "+tr_collection.size());
				int row_num;
				row_num = 1;
				for (WebElement trElement : table_element.findElements(By.xpath(TableXPath + "/tbody/tr"))) {
					List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
					s_objlog4j.info(
							"No. of tds in Row No:" + row_num + " =" + trElement.findElements(By.xpath("td")).size());
					s_objlog4j.info("employee name =" + trElement.findElements(By.xpath("td"))
							.get(Integer.parseInt(m_intColIndexToSearch)).getText());
					if (trElement.findElements(By.xpath("td")).get(Integer.parseInt(m_intColIndexToSearch)).getText()
							.contentEquals(m_strItemToSearch)) {
						if (trElement.findElements(By.xpath("td")).get(Integer.parseInt(m_intColIndexToSelect))
								.isDisplayed()) {
							((JavascriptExecutor) driver).executeScript("arguments[0].click();",
									trElement.findElements(By.xpath("td")).get(Integer.parseInt(m_intColIndexToSelect))
											.findElement(By.xpath(m_ObjToSelectXPath)));
							// ((JavascriptExecutor)
							// driver).executeScript("arguments[0].click();",
							// td_collection.get(Integer.parseInt(m_intColIndexToSelect)));

							Thread.sleep(1000);
							bStatus = true;
							break;
						}
					}
					row_num++;
				}
				// tr_collection.clear();

				if (bStatus)
					break;
				Thread.sleep(2000);
				WebElement WENextClick = driver.findElement(By.xpath(m_NextXpath));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", WENextClick);
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			bStatus = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not selected");
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * WriteTextIntoExcel method writes the text in the excel file and column
	 * name specified
	 * 
	 * @param m_strExcelFileName
	 *            This is the excel file name with file type
	 * @param m_strExcelSheetName
	 *            This is the sheet name in excel file specified
	 * @param m_strColName
	 *            This is the column name in excel to verify
	 * @param m_strText
	 *            This is the text to enter
	 * @param m_ColNameToQuery
	 *            This will have column name in excel which will be queried.
	 * @param m_ColNameToQueryVal
	 *            This will have column value in excel which will be queried.
	 * @return Boolean value True/False based on success of this function
	 * 
	 * @author Shreya gupta
	 */
	public boolean WriteTextIntoExcel(String m_strExcelFileName, String m_strExcelSheetName, String m_strColName,
			String m_strText, String m_ColNameToQuery, String m_ColNameToQueryVal) {
		boolean bStatus = false;
		try {
			if (!m_strText.equalsIgnoreCase("NULL")) {
				GlobalVariables.UniqueValue = m_strText;
			}
			String sqlQuery = null;
			if (m_strExcelSheetName.contains(" ")) {
				if (m_strColName.contains(" ")) {
					sqlQuery = "Update \"" + m_strExcelSheetName + "\"" + " Set \"" + m_strColName + "\"='" + m_strText
							+ "' where \"" + m_ColNameToQuery + "\"='" + m_ColNameToQueryVal + "'";
				} else {
					sqlQuery = "Update \"" + m_strExcelSheetName + "\" Set " + m_strColName + "='" + m_strText
							+ "' where " + m_ColNameToQuery + "='" + m_ColNameToQueryVal + "'";
				}
			} else {
				if (m_strColName.contains(" ")) {
					sqlQuery = "Update " + m_strExcelSheetName + " Set \"" + m_strColName + "\"='" + m_strText
							+ "' where " + m_ColNameToQuery + "='" + m_ColNameToQueryVal + "'";
				} else {
					sqlQuery = "Update " + m_strExcelSheetName + " Set " + m_strColName + "='" + m_strText + "' where "
							+ m_ColNameToQuery + "='" + m_ColNameToQueryVal + "'";
				}
			}
			GenericUtilityLibrary
					.updateExcel(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_strTestDataFilesPath")
							+ "/" + m_strExcelFileName, sqlQuery);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/*
	 * SelectRowFromMultiPage method selects a row in the table using JS
	 * 
	 * @param TableXPath This describes the table xpath
	 * 
	 * @param m_intColIndexToSearch This describes the column index number to
	 * search for item
	 * 
	 * @param m_strItemToSearch This describes the item to search
	 * 
	 * @param m_intColIndexToSelect This describes the column index number to
	 * select
	 * 
	 * @return Boolean value True/False based on success of this function
	 * 
	 * @author Shreya Gupta
	 */
	public Boolean SelectRowFromMultiPage(String TableXPath, String m_intColIndexToSearch, String m_strItemToSearch,
			String m_intColIndexToSelect, String m_ObjToSelectXPath, String m_ObjNextButton)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		try {
			// String m_NextXpath ="//a[contains(.,'Next')]";
			do {
				WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);

				// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
				// s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE =
				// "+tr_collection.size());
				int row_num;
				row_num = 1;
				for (WebElement trElement : table_element.findElements(By.xpath(TableXPath + "/tbody/tr"))) {
					List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
					s_objlog4j.info(
							"No. of tds in Row No:" + row_num + " =" + trElement.findElements(By.xpath("td")).size());
					s_objlog4j.info("employee name =" + trElement.findElements(By.xpath("td"))
							.get(Integer.parseInt(m_intColIndexToSearch)).getText());
					if (trElement.findElements(By.xpath("td")).get(Integer.parseInt(m_intColIndexToSearch)).getText()
							.contentEquals(m_strItemToSearch)) {
						if (trElement.findElements(By.xpath("td")).get(Integer.parseInt(m_intColIndexToSelect))
								.isDisplayed()) {
							((JavascriptExecutor) driver).executeScript("arguments[0].click();",
									trElement.findElements(By.xpath("td")).get(Integer.parseInt(m_intColIndexToSelect))
											.findElement(By.xpath(m_ObjToSelectXPath)));
							// ((JavascriptExecutor)
							// driver).executeScript("arguments[0].click();",
							// td_collection.get(Integer.parseInt(m_intColIndexToSelect)));

							Thread.sleep(1000);
							bStatus = true;
							break;
						}
					}
					row_num++;
				}
				// tr_collection.clear();

				if (bStatus)
					break;
				Thread.sleep(2000);
				WebElement WENextClick = driver.findElement(By.xpath(m_ObjNextButton));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", WENextClick);
				Thread.sleep(5000);
			} while (driver.findElements(By.xpath(m_ObjNextButton)).size() > 0);

		} catch (Exception e) {
			bStatus = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is not selected");
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * ClickUsingJS method clicks button or link object in a page using java
	 * script
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ClickUsingJS(String xPathToClick) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement("EVALUATEXPATH", xPathToClick);
			WebElement buttonOrLink = createWebElement("EVALUATEXPATH", xPathToClick);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonOrLink);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * WriteTextIntoExcel method writes the text in the excel file and column
	 * name specified
	 * 
	 * @param m_strExcelFileName
	 *            This is the excel file name with file type
	 * @param m_strExcelSheetName
	 *            This is the sheet name in excel file specified
	 * @param m_strColName
	 *            This is the column name in excel to verify
	 * @param m_strText
	 *            This is the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean InsertTextIntoExcel(String m_strExcelFileName, String m_strExcelSheetName, String m_strColName,
			String m_strText) {
		boolean bStatus = false;
		try {
			if (!m_strText.equalsIgnoreCase("NULL")) {
				GlobalVariables.UniqueValue = m_strText;
			}
			String sqlQuery = null;
			if (m_strExcelSheetName.contains(" ")) {
				if (m_strColName.contains(" ")) {
					sqlQuery = "INSERT INTO \"" + m_strExcelSheetName + "\" ( \"" + m_strColName + "\") Values('"
							+ m_strText + "')";
				} else {
					sqlQuery = "INSERT INTO \"" + m_strExcelSheetName + "\" ( " + m_strColName + ") Values('"
							+ m_strText + "')";
				}
			} else {
				if (m_strColName.contains(" ")) {
					sqlQuery = "INSERT INTO " + m_strExcelSheetName + " ( \"" + m_strColName + "\") Values('"
							+ m_strText + "')";
				} else {
					sqlQuery = "INSERT INTO " + m_strExcelSheetName + " ( " + m_strColName + ") Values('" + m_strText
							+ "')";
				}
			}
			GenericUtilityLibrary.updateExcel(m_strExcelFileName, sqlQuery);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * executeQuery method executes the Sql query
	 * 
	 * @param FilePath
	 *            This is the file path of the Excel Sheet
	 * @param strQuery
	 *            This is the Sql query
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */

	public boolean executeQuery(String FilePath, String strQuery) throws FilloException {
		Fillo fillo = new Fillo();
		try {
			fillo.getConnection(FilePath).executeQuery(strQuery).close();
			return true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strStepDescription + " is successful");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Refresh method refresh the web page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */

	public Boolean Refresh() {
		boolean bstatus = false;
		try {
			Thread.sleep(1000);
			driver.navigate().refresh();
			bstatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			e.printStackTrace();

		}
		return bstatus;
	}

	/**
	 * SwitchToSelectedFrame method switch to the frame when multiple frames are
	 * available by their name
	 * 
	 * @param m_strFrameName
	 *            This is the Frame name to which you want to switch
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SwitchToSelectedFrame(String m_strFrameName) throws Exception {
		boolean bStatus = false;
		try {
			driver.switchTo().frame(m_strFrameName);
			bStatus = true;
			// s_childExtentTest.log(LogStatus.PASS, "SwitchToSelectedFrame",
			// GlobalVariables.g_strStepDescription);
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean validateMatchingFileName(String strFilePath, String strNameToValidate) {
		boolean bStatus = false;
		File folder = new File(strFilePath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().contains(strNameToValidate)) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
					bStatus = true;
				} else {
					bStatus = false;
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is not validated");
				}
			} else if (listOfFiles[i].isDirectory()) {
				s_objlog4j.info("Directory " + listOfFiles[i].getName());
			}
		}

		return bStatus;
	}

	public boolean strStoreSalaryInGlobalVariable() {
		GlobalVariables.UniqueValue = (driver.findElement(By.xpath("(//*[@class='othcurr'])[2]")).getText()).trim()
				.substring(3).replace(",", "");
		return true;
	}

	public boolean validateSalaryAfterTransfer(String AmountTransfered) {
		String strNewSalary = (driver.findElement(By.xpath("(//*[@class='othcurr'])[2]")).getText().trim().substring(3)
				.replace(",", "")).trim();
		double intSal = Double.parseDouble(strNewSalary.toString());
		double intOldSal = Double.parseDouble(GlobalVariables.UniqueValue);
		double dblAmtToBeTransfered = Double.parseDouble(AmountTransfered);
		s_objlog4j.info(intSal);
		s_objlog4j.info(intOldSal);

		boolean bStatus = false;
		if ((intOldSal - dblAmtToBeTransfered) == intSal) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is validated");
			bStatus = true;
		} else {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is not validated");
			bStatus = false;

		}
		return bStatus;
	}

	public String SimpleMD5() {
		String passwordToHash = "Passw0rd123";
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		s_objlog4j.info(generatedPassword);
		return generatedPassword;
	}

	public boolean captureScreenshot() throws Exception {
		String actionName = GlobalVariables.g_strLogicalName;
		String testCaseId = "";
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMMddHHmms");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("screenshots\\" + testCaseId + strDate + ".png");
		FileUtils.copyFile(scrFile, destFile);
		s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
				GlobalVariables.g_strKeywordDescription + " is successful");
		return true;
	}

	public boolean saveToGlobal(String strObjectID) {
		boolean bStatus = false;
		GlobalVariables.UniqueValue = driver.findElement(By.xpath(strObjectID)).getAttribute("text");
		s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
				GlobalVariables.g_strKeywordDescription + " is successful");
		return true;

	}

	public boolean ValidateMoneyTransfered(String strObjectID, String strMoney) {
		boolean bStatus = false;

		String strBalanceAmount = driver.findElement(By.id(strObjectID)).getAttribute("text").replace(",", "");
		if (Double.parseDouble(GlobalVariables.UniqueValue.replace(",", "")) - Double.parseDouble(strMoney) == Double
				.parseDouble(strBalanceAmount)) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} else {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			bStatus = false;
		}
		return bStatus;
	}

	/**
	 * CloseBrowser method Press Enter On keyboard
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	public boolean CloseBrowser() throws Exception {
		boolean bStatus = false;
		try {
			driver.close();
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SwitchToWindow method Switch to 2nd tab
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	public boolean SwitchToWindow() throws Exception {
		boolean bStatus = false;
		try {
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle); // switch focus of
				// WebDriver to the next
				// found window handle
				// (that's your newly
				// opened window)
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SwitchToParentWindow method switch to parent Window
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	public boolean SwitchToParentWindow() throws Exception {
		boolean bStatus = false;
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

			// Switch to new window
			driver.switchTo().window(tabs.get(0));

			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * NavigateAndsearchlink method clicks on object if it is present
	 * 
	 * @param objXpath
	 *            This describes the object to click
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep kumar Swain
	 */
	public boolean NavigateAndsearchlink(String objXpath) throws Exception {
		boolean bStatus = false;
		String lastPage = driver
				.findElement(By.xpath("//div[@class='slick-arrow-container']/span[@class='slick-position-text']"))
				.getText();
		String[] pageNum = lastPage.split("/");
		int num = Integer.valueOf(pageNum[pageNum.length - 1]);
		try {
			for (int i = 1; i <= num; i++) {
				if (driver.findElement(By.xpath(objXpath)).isDisplayed()) {
					driver.findElement(By.xpath(objXpath)).click();
					break;
				} else {
					driver.findElement(By.xpath("//a[text()='Next']")).click();
				}
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful"); // e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * ClickOnLinkIntable method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Murali
	 */
	public Boolean ClickOnLinkIntable(String TableXPath, String intColIndexToSearch, String intColIndexToSelect)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		int m_intColIndexToSearch = Integer.parseInt(intColIndexToSearch);
		int m_intColIndexToSelect = Integer.parseInt(intColIndexToSelect);
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
			// List <WebElement>
			// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.tagName("a"));
				// s_objlog4j.info("NUMBER OF Links IN THIS TABLE =
				// "+td_collection.size());
				for (WebElement trElementlink : td_collection) {
					// if(td_collection.get(m_intColIndexToSearch).getText().contentEquals(m_strItemToSearch)){
					// if(td_collection.get(m_intColIndexToSelect).isDisplayed()){
					// td_collection.get(m_intColIndexToSelect).click();
					// s_objlog4j.info("NUMBER OF Links name =
					// "+trElementlink.getText());

					trElementlink.click();

					Thread.sleep(2000);
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
					break;

					// }
				}

				if (bStatus == true) {
					break;
				}

				// row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickOnDynamicLinkIntable method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Murali
	 */
	public Boolean ClickOnDynamicLinkIntable(String TableXPath, String intColIndexToSearch, String intColIndexToSelect)
			throws AWTException, InterruptedException {
		Thread.sleep(2000);
		Boolean bStatus = false;
		int m_intColIndexToSearch = Integer.parseInt(intColIndexToSearch);
		int m_intColIndexToSelect = Integer.parseInt(intColIndexToSelect);
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
			// List <WebElement>
			// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.tagName("a"));
				// s_objlog4j.info("NUMBER OF Links IN THIS TABLE =
				// "+td_collection.size());
				for (WebElement trElementlink : td_collection) {
					// if(td_collection.get(m_intColIndexToSearch).getText().contentEquals(m_strItemToSearch)){
					// if(td_collection.get(m_intColIndexToSelect).isDisplayed()){
					// td_collection.get(m_intColIndexToSelect).click();
					s_objlog4j.info("NUMBER OF Links  name = " + trElementlink.getText());
					if (trElementlink.getText().contains("name")) {
						trElementlink.click();
						Thread.sleep(2000);
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is successful");
						break;
					}
					// }
				}

				if (bStatus) {
					break;
				}
				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * VerifyLinkValueInTable method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Murali
	 */
	public Boolean VerifyLinkValueInTable(String TableXPath, String intColIndexToSearch, String intColIndexToSelect)
			throws AWTException, InterruptedException {
		Thread.sleep(2000);
		Boolean bStatus = false;
		int m_intColIndexToSearch = Integer.parseInt(intColIndexToSearch);
		int m_intColIndexToSelect = Integer.parseInt(intColIndexToSelect);
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
			// List <WebElement>
			// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.tagName("a"));
				// s_objlog4j.info("NUMBER OF Links IN THIS TABLE =
				// "+td_collection.size());
				for (WebElement trElementlink : td_collection) {
					// if(td_collection.get(m_intColIndexToSearch).getText().contentEquals(m_strItemToSearch)){
					// if(td_collection.get(m_intColIndexToSelect).isDisplayed()){
					// td_collection.get(m_intColIndexToSelect).click();
					// s_objlog4j.info("NUMBER OF Links name =
					// "+trElementlink.getText());
					if (trElementlink.getText().contains("name")) {
						// trElementlink.click();
						Thread.sleep(2000);
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is successful");
						break;
					}
					// }

				}

				if (bStatus) {
					break;
				}

				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * DragAndDrops method selects an item from dropdown using its xpath after
	 * clicking dropdown
	 * 
	 * @param m_strItemXpath
	 *            Dropdown item xpath to be selected
	 * @return Boolean value True/False based on success of this function
	 * @author Murali S
	 */

	public boolean DragAndDrops(String TableXPath) throws Exception {
		boolean bStatus = false;
		try {

			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			// Create object of actions class
			Actions act = new Actions(driver);

			// find element which we need to drag
			WebElement drag = driver.findElement(By.xpath(TableXPath));

			// find element which we need to drop
			WebElement drop = driver.findElement(By.xpath(TableXPath));

			// this will drag element to destination
			act.dragAndDrop(drag, drop).build().perform();

			bStatus = true;

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickOnDeleteLinkIntable method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Murali
	 */
	public Boolean ClickOnDeleteLinkIntable(String TableXPath, String intColIndexToSearch, String intColIndexToSelect)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		int m_intColIndexToSearch = Integer.parseInt(intColIndexToSearch);
		int m_intColIndexToSelect = Integer.parseInt(intColIndexToSelect);
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
			// List <WebElement>
			// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 1;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.tagName("a"));
				// s_objlog4j.info("NUMBER OF Links IN THIS TABLE =
				// "+td_collection.size());
				for (WebElement trElementlink : td_collection) {
					// if(td_collection.get(m_intColIndexToSearch).getText().contentEquals(m_strItemToSearch)){
					// if(td_collection.get(m_intColIndexToSelect).isDisplayed()){
					// td_collection.get(m_intColIndexToSelect).click();
					s_objlog4j.info("NUMBER OF Links  name = " + trElementlink.getText());
					if (trElementlink.getText().contains("name")) {
						// trElementlink.click();
						List<WebElement> deleteLinks = (List<WebElement>) trElement
								.findElements(By.xpath("//*[@id='btn-delete-portal-journey']"));
						deleteLinks.get(1).click();
						Thread.sleep(2000);
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is successful");
						break;
					}
					// }
				}

				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * VerifyLastRowValueInTable method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Murali
	 */
	public Boolean VerifyLastRowValueInTable(String TableXPath, String intColIndexToSearch, String intColIndexToSelect)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		int m_intColIndexToSearch = Integer.parseInt(intColIndexToSearch);
		int m_intColIndexToSelect = Integer.parseInt(intColIndexToSelect);
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
			// List <WebElement>
			// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());

			int linksCount = tr_collection.size() - 1;
			if (tr_collection.get(linksCount).findElement(By.tagName("a")).getText().contains("name")) {
				s_objlog4j.info(
						"LastRowValue = " + (tr_collection.get(linksCount).findElement(By.tagName("a")).getText()));
				// tr_collection.get(linksCount).findElement(By.tagName("a")).click();
				Thread.sleep(2000);
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickOnDynamicLinkIntableByVal method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Murali
	 */
	public Boolean ClickOnDynamicLinkIntableByVal(String TableXPath, String intColIndexToSearch,
			String intColIndexToSelect) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		int m_intColIndexToSearch = Integer.parseInt(intColIndexToSearch);
		int m_intColIndexToSelect = Integer.parseInt(intColIndexToSelect);
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		Thread.sleep(5000);
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
			// List <WebElement>
			// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 0;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.tagName("a"));
				int RS = td_collection.size();
				// s_objlog4j.info("NUMBER OF Links IN THIS TABLE =
				// "+td_collection.size());
				// for(WebElement trElementlink : td_collection){
				int RSS;
				for (RSS = 0; RSS < RS - 1; RSS++) {
					// s_objlog4j.info("NUMBER OF Links name =
					// "+trElementlink.getText());

					// if (trElementlink.getText().contains("aname"))
					if (td_collection.get(RSS).getText().contains("aname")) {
						// trElementlink.click();

						s_objlog4j.info("Rows = " + RSS);
						td_collection.get(0).click();
						Thread.sleep(5000);
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, "ClickOnDynamicLinkIntableByVal",
								GlobalVariables.g_strStepDescription + " is successful");
						break;
					}
					// }
				}

				if (bStatus) {
					break;
				}
				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectingCheckBoxIntableByVal method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Murali
	 */
	public Boolean SelectingCheckBoxIntableByVal(String TableXPath, String intColIndexToSearch,
			String intColIndexToSelect) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		int m_intColIndexToSearch = Integer.parseInt(intColIndexToSearch);
		int m_intColIndexToSelect = Integer.parseInt(intColIndexToSelect);
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		Thread.sleep(5000);
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
			// List <WebElement>
			// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 0;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.tagName("td"));
				int RS = td_collection.size();
				// s_objlog4j.info("NUMBER OF Links IN THIS TABLE =
				// "+td_collection.size());
				// for(WebElement trElementlink : td_collection){
				int RSS;
				for (RSS = 0; RSS < RS - 1; RSS++) {
					// s_objlog4j.info("NUMBER OF Links name =
					// "+trElementlink.getText());

					// if (trElementlink.getText().contains("aname"))
					if (td_collection.get(RSS).getText().contains("ASTCON001")) {
						// trElementlink.click();

						s_objlog4j.info("Rows = " + RSS);
						td_collection.get(0).click();
						Thread.sleep(5000);
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is successful");
						break;
					}
					// }
				}

				if (bStatus) {
					break;
				}
				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * VerifyLastLinkIntableByVal method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Murali
	 */
	public Boolean VerifyLastLinkIntableByVal(String TableXPath, String intColIndexToSearch, String intColIndexToSelect)
			throws AWTException, InterruptedException {
		Boolean bStatus = false;
		int m_intColIndexToSearch = Integer.parseInt(intColIndexToSearch);
		int m_intColIndexToSelect = Integer.parseInt(intColIndexToSelect);
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		Thread.sleep(5000);
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
			// List <WebElement>
			// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int rows_count = tr_collection.size();

			for (int row = 0; row < rows_count; row++) {

				// To locate columns(cells) of that specific row.
				List<WebElement> td_collection = tr_collection.get(row).findElements(By.tagName("td"));

				// To calculate no of columns(cells) In that specific row.
				int columns_count = td_collection.size();
				// for( RSS=0;RSS<RS-1;RSS++)
				// Loop will execute till the last cell of that specific row.
				for (int column = 0; column < columns_count; column++) {
					{
						// s_objlog4j.info("NUMBER OF Links name =
						// "+trElementlink.getText());

						// if (trElementlink.getText().contains("aname"))
						if (td_collection.get(column).getText().contains("name")) {

							s_objlog4j.info("Links  name = " + td_collection.get(column).getText());
							td_collection.get(column).findElement(By.tagName("a")).click();
							Thread.sleep(5000);
							bStatus = true;
							s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription + " is successful");
							break;
						}
						// }
					}

					if (bStatus) {
						break;
					}
					// row_num++;
				}
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickOnDynamicLinkIntableByVal method clicks on specific cell data
	 * 
	 * @param TableXPath
	 *            This describes the table xpath
	 * @param m_intColIndexToSearch
	 *            This describes the column index number to search for item
	 * @param m_strItemToSearch
	 *            This describes the item to search
	 * @param m_intColIndexToSelect
	 *            This describes the column index number to select
	 * @return Boolean value True/False based on success of this function
	 * @author Murali
	 */
	public Boolean ClickOnDynamicLinkIntableByValTwo(String TableXPath, String intColIndexToSearch,
			String intColIndexToSelect) throws AWTException, InterruptedException {
		Boolean bStatus = false;
		int m_intColIndexToSearch = Integer.parseInt(intColIndexToSearch);
		int m_intColIndexToSelect = Integer.parseInt(intColIndexToSelect);
		String m_strItemToSearch = GlobalVariables.UniqueValue;
		Thread.sleep(5000);
		try {
			WebElement table_element = createWebElement("EVALUATEXPATH", TableXPath);
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));
			// List <WebElement>
			// tr_collection=table_element.findElements(By.xpath(TableXPath+"/tbody/tr"));
			s_objlog4j.info("NUMBER OF ROWS IN THIS TABLE = " + tr_collection.size());
			int row_num, col_num;
			row_num = 0;
			for (WebElement trElement : tr_collection) {
				List<WebElement> td_collection = trElement.findElements(By.tagName("a"));
				int RS = td_collection.size();
				// s_objlog4j.info("NUMBER OF Links IN THIS TABLE =
				// "+td_collection.size());
				// for(WebElement trElementlink : td_collection){
				int RSS;
				for (RSS = 0; RSS < RS - 1; RSS++) {
					// s_objlog4j.info("NUMBER OF Links name =
					// "+trElementlink.getText());

					// if (trElementlink.getText().contains("aname"))
					if (td_collection.get(RSS).getText().contains("aname")) {
						// trElementlink.click();

						s_objlog4j.info("Rows = " + RSS);
						td_collection.get(0).click();
						Thread.sleep(5000);
						bStatus = true;
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is successful");
						break;
					}
					// }
				}

				if (bStatus) {
					break;
				}
				row_num++;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * PressTab method Press Tab On keyboard
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Nishitha
	 */
	public boolean PressTab() throws Exception {
		boolean bStatus = false;
		try {
			Actions actions = new Actions(driver);
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.ENTER).build().perform();
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean waitForLoadingImageDisappear() {

		boolean bStatus = false;

		try {

			if (driver.findElement(By.xpath("//*[contains(text(),'Loading...Please wait')]")).isDisplayed()) {
				WebDriverWait wait = new WebDriverWait(driver, 90);
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Loading...Please wait')]")));
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
				bStatus = true;
			}

		} catch (Exception e) {
			System.err.format("Exception thrown in waitForLoadingImageDisappear: " + e);
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not successful");
		}
		return bStatus;
	}

	/**
	 * ClickIfExist method clicks on object if it is present
	 * 
	 * @param objXpath
	 *            This describes the object to click
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep kumar swain
	 *//*
		 * public boolean ClickIfExist() throws Exception { boolean bStatus =
		 * false; try { if (driver.findElement(By.
		 * xpath("//a[contains(text(),'receive text message alerts')]")).
		 * isDisplayed()) { driver.findElement(By.
		 * xpath("//a[contains(text(),'receive text message alerts')]")).click()
		 * ; } bStatus = true; s_childExtentTest.log(LogStatus.PASS,
		 * GlobalVariables.g_strKeywordDescription,
		 * GlobalVariables.g_strKeywordDescription + " is successful"); } catch
		 * (Exception e) { s_childExtentTest.log(LogStatus.FAIL,
		 * GlobalVariables.g_strStepDescription,
		 * GlobalVariables.g_strKeywordDescription + " is Unsuccessful"); //
		 * e.printStackTrace(); bStatus = true; } return bStatus; }
		 */

	/**
	 * PressEnter method Press Enter On keyboard
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean PressEnter() throws Exception {
		boolean bStatus = false;
		try {
			Actions actions = new Actions(driver);
			// actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).build().perform();
			// actions.keyDown(Keys.ENTER).build().perform();
			actions.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	

	/**
	 * setBaseURI method sets base URI for Rest / Soap services
	 * 
	 * @return void
	 * @author Kannan Dharani
	 */
	/*public void setBaseURI(String type) {
		if (type.equals("REST"))
			baseURI = GlobalVariables.g_strRestBaseURI;
		else
			baseURI = GlobalVariables.g_strSoapBaseURI;

	}
*/
	/**
	 * setRequestParam method constructs request for Rest / Soap services
	 * 
	 * @return HashMap <String, String>
	 * @author Kannan Dharani
	 */
	public HashMap<String, String> constructRequestParam(String request) {
		String[] requestParam = request.split(";");
		HashMap<String, String> requestParams = new HashMap<String, String>();

		for (String param : requestParam) {

			String[] keyVal = param.split("=");
			requestParams.put(keyVal[0], keyVal[1]);
		}

		return requestParams;

	}

	/**
	 * setRequestParam method constructs request for Rest / Soap services
	 * 
	 * @return HashMap <String, String>
	 * @author Kannan Dharani
	 */
	public HashMap<String, String> constructHeader() {
		String header = null;

		/*
		 * header = X_IBM_CLIENT_ID + GlobalVariables.g_strClientId + ";" +
		 * "Authorization= Bearer " + GlobalVariables.g_strAccessToken;
		 * s_objlog4j.info(header);
		 * 
		 * String[] requestParam = header.split(";");
		 */
		HashMap<String, String> requestHeader = new HashMap<String, String>();

		requestHeader.put(X_IBM_CLIENT_ID, GlobalVariables.g_strClientId);
		requestHeader.put(AUTHORIZATION, BEARER + " " + GlobalVariables.g_strAccessToken);

		/*
		 * for (String param : requestParam) {
		 * 
		 * String[] keyVal = param.split("="); requestHeader.put(keyVal[0],
		 * keyVal[1]); }
		 */

		return requestHeader;

	}

	/**
	 * setRequestParam method constructs response for Rest / Soap services
	 * 
	 * @return Hashtable <String, String>
	 * @author Kannan Dharani
	 */

	public Hashtable<String, String> constructResponseParam(String response) {
		String[] responseParam = response.split(";");
		Hashtable<String, String> responseParams = new Hashtable<String, String>();

		for (String param : responseParam) {
			String[] keyVal = param.split("=");
			responseParams.put(keyVal[0], keyVal[1]);
		}

		return responseParams;
	}

	/**
	 * sendReceiveRestRequest method can send GET/POST/DELETE/UPDATE rest
	 * request and validates the response
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Kannan Dharani
	 */

	public boolean sendReceiveRestRequest(String resourcePath, String request, String response, String access_token) {
		boolean bStatus = false;
		String header = null;
		HashMap<String, String> headers = null;
		String json;

		try {

			

			// Construct request parameters
			HashMap<String, String> requestParams = constructRequestParam(request);

			// Construct response parameters
			Hashtable<String, String> responseParams = constructResponseParam(response);

			// Construct response specification
			// responseSpecification = new
			// ResponseSpecBuilder().expectStatusCode(200).build();

			if (access_token.equalsIgnoreCase("YES")) {

				// Construct request specification
				headers = constructHeader();
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .addHeaders(headers).build();
				 */

				if (given().headers(headers).queryParameters(requestParams).get(resourcePath)
						.getStatusCode() == HTTP_UNAUTHORIZED) {
					getAccessToken();
				}

				// Construct request specification
				headers = constructHeader();
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .addHeaders(headers).build();
				 */
				json = given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();
			} else {
				// Construct request specification
				// headers = constructRequestParam(header);
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .build();
				 */
				json = given().queryParameters(requestParams).get(resourcePath).asString();
			}

			/**
			 * Send Rest request and get response as json string
			 */

			// String json =
			// given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();
			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is successful" + json);

			/**
			 * Validate the response and log into report
			 */
			for (String key : responseParams.keySet()) {

				String expected = jsPath.get(key).toString();
				String actual = responseParams.get(key);
				if (expected.equalsIgnoreCase(actual)) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " lis successful" + "Expectation Pass :"
									+ "<p>Expected : " + responseParams.get(key) + "<br> Actual : " + jsPath.get(key)
									+ "</p>");
					bStatus = true;
				} else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + "Expectation Fail :" + "<p>Expected : "
									+ responseParams.get(key) + "<br> Actual : " + "<b style=\"color:red;\">"
									+ jsPath.get(key) + "</b></p>");
					bStatus = false;
				}
			}

			//requestSpecification = null;
			//responseSpecification = null;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * executeDBQueryOracle method can execute given query on oracle db and
	 * returns result set
	 * 
	 * @return ResultSet based on success of this function
	 * @author Kannan Dharani
	 */

	public ResultSet ExecuteDBQueryoracle(String query) throws Exception {

		// Declare the JDBC objects.
		GlobalVariables.g_objConnection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(ORACLE_JDBC_DRIVER);
			GlobalVariables.g_objConnection = DriverManager.getConnection(
					CONNECTION_STRING + GlobalVariables.g_strODBQAConnectionString, GlobalVariables.g_strODSQAUserID,
					GlobalVariables.g_strODSQAPwd);

			s_objlog4j.info("Connected to DB server.");

			// Create and execute an SQL statement that reads some data.
			statement = GlobalVariables.g_objConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery(query);

			resultSet.last();
			GlobalVariables.g_intTotalRecords = resultSet.getRow();
			resultSet.first();
			GlobalVariables.g_intTotalColumns = resultSet.getMetaData().getColumnCount();

		} catch (SQLException e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		// Close the JDBC objects.
		// statement.close();
		// connection.close();

		return resultSet;
	}

	/**
	 * getAccessToken method is helps to access token from remote authorization
	 * server returns String access token
	 * 
	 * @return String value based on success of this function
	 * @author Kannan Dharani
	 */

	public static void getAccessToken() {
		String accessToken = null;
		String encodedValue = null;
		@SuppressWarnings("deprecation")
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(GlobalVariables.g_strAuthTokenUrl);
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair(GRANT_TYPE, GRANT_TYPE_CLIENT_CREDENTIALS));
			nameValuePairs.add(new BasicNameValuePair(SCOPE, SCOPE_APP_SCOPE));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

			String cred = GlobalVariables.g_strClientId + ":" + GlobalVariables.g_strClientSecret;
			byte[] encodedBytes = Base64.encodeBase64(cred.getBytes(StandardCharsets.US_ASCII));
			encodedValue = new String(encodedBytes);
			post.setHeader(AUTHORIZATION, BASIC + " " + encodedValue);

			org.apache.http.HttpResponse response = client.execute(post);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer buffer = new StringBuffer();
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				buffer.append(line);
			}

			JSONObject json = new JSONObject(buffer.toString());
			s_objlog4j.info(json);
			GlobalVariables.g_strAccessToken = json.getString(ACCESS_TOKEN);

			// return accessToken;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String readValueFromIniFile(String sectionName, String keyName) throws Exception {
		Wini ini = new Wini(new File("src/test/java/com/org/proj/application/Files/soaptemplate_ods.ini"));
		String value = (String) ini.get(sectionName, keyName, String.class);
		return value;
	}

	/**
	 * createMobileElement method creates a webdriver element based on its
	 * presence and visibility
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return WebElement
	 * @author Pradeep Kumar Swain
	 */
	public MobileElement createMobileElement(String locator, String value) throws Exception {
		MobileElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.MobileWait);

		switch (typeOfLocator.valueOf(locator)) {
		case EVALUATEXPATH:

			element = (MobileElement) driver.findElement(By.xpath(value));
			break;

		case EVALUATEID:
			element = (MobileElement) driver.findElement(By.id(value));
			break;

		case EVALUATENAME:
			element = (MobileElement) driver.findElement(By.name(value));
			break;

		case ACCESSIBILITYID:

			element = (MobileElement) ((IOSDriver) driver).findElementByAccessibilityId(value);
			break;

		case UIAUTOMATION:

			element = (MobileElement) ((IOSDriver) driver).findElementByIosUIAutomation(value);

			break;

		}

		return element;

	}

	/**
	 * waitForPresenceAndVisibilityOfElement method waits for an element
	 * presence and visibility
	 * 
	 * @param locator
	 *            This describes the name of locator
	 * @param value
	 *            This describes the value of locator
	 * @return Boolean value True/False
	 * @author Pradeep Kumar Swain
	 */
	@SuppressWarnings("finally")
	public boolean waitForPresenceAndVisibilityOfMElement(String locator, String value) throws Exception {
		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.smallWait);
		List<WebElement> e;
		try {
			switch (typeOfLocator.valueOf(locator)) {

			case EVALUATEXPATH:
				// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(value)));
				// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(value)));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
				e = driver.findElements(By.xpath(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;

			case EVALUATEID:
				// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(value)));
				// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(value)));
				wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
				e = driver.findElements(By.id(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;

			case EVALUATENAME:
				// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(value)));
				// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(value)));
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				e = driver.findElements(By.name(value));
				if (e.size() == 1) {
					bStatus = true;
				}
				break;

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			return bStatus;
		}

	}

	/**
	 * EnterTextUsingADB method enters text into object
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep kumar Swain
	 */
	public boolean EnterTextUsingADB(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		if (GlobalVariables.variables.containsKey(m_strText))
			m_strText = (String) GlobalVariables.variables.get(m_strText);
		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			textBox.click();
			// String [] args = {"cmd", "start", "C:\\Program
			// Files\\Android\\android-sdk\\platform-tools\\adb", "-s",
			// "CUTO5SM7MVY5D6Z5", "shell", "input", "text", m_strText};

			String command = GlobalVariables.g_strAndroidSdkPath + " " + "-s" + " "
					+ GlobalVariables.g_strAndroidDeviceName + " shell input text " + m_strText;

			Runtime runtime = Runtime.getRuntime();
			runtime.exec(command);
			// ((AndroidDriver<WebElement>) driver).hideKeyboard();
			s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strKeywordDescription + "   :- " + m_strText,
					GlobalVariables.g_strKeywordDescription + " .......is Successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, GlobalVariables.g_strKeywordDescription + "   :- " + m_strText,
					GlobalVariables.g_strKeywordDescription + " ....... is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ScrollTo method scrolls to down the page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */

	@SuppressWarnings("unchecked")
	public boolean ScrollTo(String m_ElementText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			Thread.sleep(5000);
			((AndroidDriver<WebElement>) driver).scrollTo(m_ElementText).click();
			
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is done successfully");
			bStatus = true;
			Thread.sleep(1000);
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is failed due to exception thrown");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ScrollToExact method scrolls to down the page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */

	@SuppressWarnings("unchecked")
	public boolean ScrollToExact(String m_ElementText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {

			((AndroidDriver<WebElement>) driver).scrollToExact(m_ElementText);
			bStatus = true;
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is done successfully");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is failed due to exception thrown");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * Clickenterandroidkeyboad method click android enter button
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep kumar Swain
	 */
	@SuppressWarnings("unchecked")
	public boolean Clickenterandroidkeyboad() throws Exception {
		boolean bStatus = false;
		try {
			((AndroidDriver<WebElement>) driver).pressKeyCode(66);
			bStatus = true;
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickBackbuttonAndroid method click Back button on android
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep kumar Swain
	 */
	@SuppressWarnings("unchecked")
	public boolean ClickBackbuttonAndroid() throws Exception {
		boolean bStatus = false;
		try {
			((AndroidDriver<WebElement>) driver).pressKeyCode(4);
			bStatus = true;
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + "---- Successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + "---- UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * IOSEnterText method enters text into object
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	public boolean MEnterText(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);

			MobileElement textBox = createMobileElement(strExcelInfo[0], strExcelInfo[1]);

			textBox.click();
			textBox.clear();
			textBox.sendKeys(m_strText);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + "  =" + m_strText,
					GlobalVariables.g_strKeywordDescription + " is Successful");

			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + "  =" + m_strText,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * IOSClick method clicks button or link object in a page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	public boolean MClick() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);

			MobileElement buttonOrLink = createMobileElement(strExcelInfo[0], strExcelInfo[1]);

			buttonOrLink.click();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is Successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * MExists method checks for an element is present and visible
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	public boolean MExists() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			bStatus = waitForPresenceAndVisibilityOfMElement(strExcelInfo[0], strExcelInfo[1]);
			// bStatus = waitForPresenceOfElement(strExcelInfo[0],
			// strExcelInfo[1]);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " as Excepted");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " as UnExcepted");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ScrollToElement1 method scrolls to down the page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	@SuppressWarnings("unchecked")
	public boolean ScrollToElement() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {

			((AndroidDriver<WebElement>) driver).scrollToExact("Need Help");
			Thread.sleep(1000);
			for (int i = 1; i <= 1; i++) {

				((AndroidDriver<WebElement>) driver).findElement(By.id("com.:id/textView2")).click();
				Dimension dimensions = ((AndroidDriver<WebElement>) driver)
						.findElement(By.id("com.:id/textView2")).getSize();
				System.out.println("Size of Window= " + dimensions);
				int scrollStart = (int) (dimensions.getHeight() * 0);
				System.out.println("Size of scrollStart= " + scrollStart);
				int scrollEnd = (int) (dimensions.getHeight() * 1.5);
				System.out.println("Size of cscrollEnd= " + scrollEnd);

				// ((AndroidDriver<WebElement>)
				// driver).swipe(0,scrollStart,0,scrollEnd,1000);
				System.out.println("Screen Swiped ");
				Boolean Flag;
				Flag = false;
				while (!Flag) {
					((AndroidDriver<WebElement>) driver).swipe(0, scrollStart, 0, scrollEnd, 1000);
					System.out.println("Screen Swiped ");
					Flag = ((AndroidDriver<WebElement>) driver)
							.findElement(By.id("com.:id/act_user_registration_step3_checkbox_terms"))
							.isEnabled();

				}
			}
			bStatus = true;
			Thread.sleep(2000);
		} catch (Exception e) {
			// e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * ScrollToElement1 method scrolls to down the page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	@SuppressWarnings("unchecked")
	public boolean ScrollToElement1() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			((AndroidDriver<WebElement>) driver).hideKeyboard();
			((AndroidDriver<WebElement>) driver).scrollToExact("Need Help");
			Thread.sleep(3000);
			Dimension dimensions = ((AndroidDriver<WebElement>) driver)
					.findElement(By.id("com.:id/textView2")).getSize();
			int TextviewX = ((AndroidDriver<WebElement>) driver).findElement(By.id("com.:id/textView2"))
					.getLocation().getX();
			int TextviewY = ((AndroidDriver<WebElement>) driver).findElement(By.id("com.:id/textView2"))
					.getLocation().getY();
			String coords = ((AndroidDriver<WebElement>) driver).findElement(By.id("com.:id/textView2"))
					.getLocation().toString();
			int EHieght = TextviewY + dimensions.getHeight() - 200;
			int SHieght = TextviewY + 100;
			int SPoint = TextviewX + 200;
			int EPoint = TextviewX + 300;

			System.out.println("X and Y= " + dimensions);
			System.out.println("Hieght = " + EHieght + " " + SHieght + " " + SPoint + " " + EPoint);
			System.out.println("Size of Window= " + TextviewX + "  " + TextviewY + "  " + coords);
			Boolean Flag;
			Flag = false;
			while (!Flag) {
				((AndroidDriver<WebElement>) driver).swipe(SPoint, EHieght, EPoint, SHieght, 1000);
				System.out.println("Screen Swiped ");
				Flag = ((AndroidDriver<WebElement>) driver)
						.findElement(By.id("com.:id/act_user_registration_step3_checkbox_terms"))
						.isEnabled();

			}
			bStatus = true;
			Thread.sleep(2000);
		} catch (Exception e) {
			// e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * EnterTextUsingSetValue method scrolls to the control and enters text into
	 * a text box and hides the keyboard
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Kannan
	 */
	public boolean EnterTextUsingSetValue(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			IOSElement textBox = (IOSElement) createWebElement(strExcelInfo[0], strExcelInfo[1]);
			while (!(textBox).isDisplayed()) {
				((IOSDriver<WebElement>) driver).swipe(10, 500, 10, -150, 5000);
			}
			textBox.click();
			textBox.clear();
			textBox.setValue(m_strText);
			createWebElement("ACCESSIBILITYID", "Done").click();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " " + "is Successful");

			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " " + "is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * IOSSelectOption method select an option from a drop down. It takes
	 * accessibility id as an argument
	 * 
	 * @param m_strText
	 *            This describes option to select
	 * @return Boolean value True/False based on success of this function
	 * @author Kannan Dharani
	 */
	public boolean IOSSelectOption(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			/*
			 * strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.
			 * g_strObjectRepositoryFilePath, GlobalVariables.g_strLogicalName);
			 */
			IOSElement textBox = (IOSElement) createMobileElement("ACCESSIBILITYID", m_strText);
			textBox.click();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " " + "is Successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " " + "is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * AndroidcloseApp method kill App on android
	 * 
	 * @author Pradeep kumar Swain
	 */
	@SuppressWarnings("unchecked")
	public boolean AndroidcloseApp() throws Exception {
		boolean bStatus = false;
		try {
			((AndroidDriver<WebElement>) driver).closeApp();
			bStatus = true;
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " App Closed Successfully");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " App Not Closed");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * App method kill App on android
	 * 
	 * @author Pradeep kumar Swain
	 */
	@SuppressWarnings("unchecked")
	public boolean AndroidlaunchApp() throws Exception {
		boolean bStatus = false;
		try {
			/*((AndroidDriver<WebElement>) driver).launchApp();*/
			classpathRoot = new File(System.getProperty("user.dir"));
			appDir = new File(classpathRoot, "src/test/resources/Apps/");
			app = new File(appDir, GlobalVariables.g_strAndroidAppName);
		//	capabilities.setCapability(CapabilityType.BROWSER_NAME, GlobalVariables.g_strAndroidBrowserName);
			capabilities.setCapability("platformVersion", GlobalVariables.g_strAndroidPlatformVersion);
			capabilities.setCapability("deviceName", GlobalVariables.g_strAndroidDeviceName);
			capabilities.setCapability("platformName", GlobalVariables.g_strAndroidPlatformName);
			capabilities.setCapability(MobileCapabilityType.UDID, GlobalVariables.g_strAndroidUDID);
			// capabilities.setCapability("fullReset",true);
			//capabilities.setCapability("newCommandTimeout", 50000);
			capabilities.setCapability("unicodeKeyboard", true);
			capabilities.setCapability("resetKeyboard", true);
			capabilities.setCapability("automationName", "uiautomator2");
			capabilities.setCapability("app", app.getAbsolutePath());
			
			mobileDriver = new AndroidDriver(gVar.g_strAppiumServerURL, capabilities);
			bStatus = true;
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " App Launched Successfully");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " App not Launched");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * AndroidClickIfExist method clicks on object if it is present
	 * 
	 * @param objid
	 *            This describes the object to click
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep kumar Swain
	 */
	public boolean AndroidClickIfExist() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			Thread.sleep(2000);
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(gVar.g_strObjectRepositoryFilePath, gVar.g_strLogicalName);
			MobileElement clickableObject = (MobileElement) createMobileElement(strExcelInfo[0], strExcelInfo[1]);
					
			if (clickableObject.isDisplayed()) {
				clickableObject.click();
			}
			
			
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + "is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + "is Unsuccessful");

			 e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	public boolean AndroidValidateElementText(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			Thread.sleep(5000);
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(gVar.g_strObjectRepositoryFilePath, gVar.g_strLogicalName);
			MobileElement elementText = (MobileElement) createMobileElement(strExcelInfo[0], strExcelInfo[1]);
			
			System.out.println("Actual text=" + elementText.getText().replace(" ", "").toUpperCase());
			System.out.println("Expected text=" + m_strText.replace(" ", "").toUpperCase());
			if (m_strText.toUpperCase().equalsIgnoreCase("NULL") || elementText.getText().replace(" ", "").toUpperCase()
					.contains(m_strText.replace(" ", "").toUpperCase())) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + m_strText + " is validated");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + m_strText + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	/**
	 * EnterText method does not enter any text into object
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean AndrioidEnterText(String strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			Thread.sleep(5000);
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(gVar.g_strObjectRepositoryFilePath, gVar.g_strLogicalName);
			MobileElement textfield = (MobileElement) createMobileElement(strExcelInfo[0], strExcelInfo[1]);			
			textfield.click();
	
			textfield.sendKeys(strText+"\n");
			
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	
	
	/**
	 * AndroidresetApp method Reset App on android
	 * 
	 * @author Pradeep kumar Swain
	 */
	@SuppressWarnings("unchecked")
	public boolean AndroidresetApp() throws Exception {
		boolean bStatus = false;
		try {
			((AndroidDriver<WebElement>) driver).resetApp();
			;
			bStatus = true;
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " App Reset Successfully");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " App Reset UnSuccessfully");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * checkIfNotChecked method clicks button or link object in a page if it is
	 * not checked already.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Kannan Dharani
	 */
	public boolean IOS_AcceptTermsConditions() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			IOSElement checkbox = (IOSElement) createMobileElement(strExcelInfo[0], strExcelInfo[1]);
			IOSElement textArea = (IOSElement) createMobileElement("EVALUATEXPATH",
					"//XCUIElementTypeButton[@name='isRememberMeUnChecked']/preceding::XCUIElementTypeTextView[1]");

			while (!(checkbox).isDisplayed()) {
				((IOSDriver<WebElement>) driver).swipe(10, 500, 10, -150, 5000);
			}

			while (!checkbox.isEnabled()) {
				int topY = textArea.getLocation().getY();
				int bottomY = topY + textArea.getSize().getHeight();
				int centerX = textArea.getLocation().getX() + 10;
				TouchAction myAction = new TouchAction((IOSDriver) driver);
				myAction.press(centerX, bottomY - 5).moveTo(centerX, -250).release().perform();

			}
			checkbox.click();
			bStatus = true;

			s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ScrollToElement method scrolls to down the page in mobile context
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Kannan Dharani
	 */

	@SuppressWarnings("unchecked")
	public boolean IOSScrollToElement() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);

			while (!(createMobileElement(strExcelInfo[0], strExcelInfo[1]).isDisplayed())) {
				((IOSDriver<WebElement>) driver).swipe(10, 500, 10, -150, 5000);
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ScrollToElement method scrolls to top of the page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Kannan Dharani
	 */
	public boolean IOSScrollUp() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			// ((IOSDriver<WebElement>) driver).swipe(200, 500, 100, -1000,
			// 5000);
			((IOSDriver<WebElement>) driver).swipe(10, 500, 10, -150, 5000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * triggerMemberCreation method Create new member in ODS
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	public static boolean triggerMemberCreation(String path) throws Exception {
		boolean bStatus = false;
		try {

			String temporaryBatchFile = "temp.bat";
			String location = path.substring(0, path.lastIndexOf(File.separator));
			String batchFile = path.substring(path.lastIndexOf(File.separator) + 1, path.length());

			File tempFile = new File("./src/test/resources/" + temporaryBatchFile);
			if (tempFile.exists())
				tempFile.delete();
			boolean createFile = tempFile.createNewFile();

			if (createFile) {
				PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
				pw.write("cd /d " + location);
				pw.println("\n");
				pw.println(" call " + batchFile);
				pw.println("\n");
				pw.println("timeout /t 5");
				pw.println("\n");
				pw.println("EXIT");
				pw.close();
				bStatus = true;
			}
			if (bStatus) {

				java.lang.Runtime rt = java.lang.Runtime.getRuntime();
				String runCmd = "cmd.exe /c start /wait " + tempFile.getAbsolutePath();

				Process proc = rt.exec(runCmd);
				final int exitVal = proc.waitFor();
				if (exitVal == 0) {
					bStatus = true;
				}

			}
			bStatus = true;
			// s_childExtentTest.log(LogStatus.PASS,
			// GlobalVariables.g_strStepDescription,
			// GlobalVariables.g_strKeywordDescription);

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * readContentsFromFile method data read from text file
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */

	public static boolean readContentsFromFile(String fileName, String data) {

		boolean bstatus = false;

		File file = new File(fileName);
		String lastLine = "";

		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				String line = "";
				while ((line = br.readLine()) != null) {
					lastLine = line;
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!lastLine.trim().equals("")) {
				TreeMap<Integer, String> info = new TreeMap<Integer, String>();
				if (data.contains(",")) {
					StringTokenizer dataStr = new StringTokenizer(data, ",");

					while (dataStr.hasMoreTokens()) {
						String token = dataStr.nextToken().trim();
						info.put(info.size() + 1, token);
					}
				} else
					info.put(info.size() + 1, data.trim());
				int count = 0;
				if (lastLine.contains(";")) {
					StringTokenizer str = new StringTokenizer(lastLine, ";");
					while (str.hasMoreTokens()) {
						String token = str.nextToken().trim();
						count = count + 1;
						if (info.containsKey(count))
							GlobalVariables.variables.put(info.get(count), token);
					}
				}
			}
			bstatus = true;
		}

		// s_childExtentTest.log(LogStatus.PASS,
		// GlobalVariables.g_strStepDescription,
		// GlobalVariables.g_strKeywordDescription);

		return bstatus;
	}

	public static boolean triggerAppiumLauncher() throws Exception {

		boolean bStatus = false;
		String temporaryBatchFile = "appiumLauncher.bat";
		File tempFile = new File("./src/test/resources/" + temporaryBatchFile);
		if (tempFile.exists())
			tempFile.delete();
		boolean createFile = tempFile.createNewFile();

		if (createFile) {
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			pw.println("appium");
			pw.println("\n");
			pw.close();
			bStatus = true;
		}
		if (bStatus) {

			java.lang.Runtime rt = java.lang.Runtime.getRuntime();
			String runCmd = "cmd.exe /c start /wait " + tempFile.getAbsolutePath();

			Process proc = rt.exec(runCmd);

			Thread.sleep(10000);
			bStatus = true;

		}
		// s_childExtentTest.log(LogStatus.PASS,
		// GlobalVariables.g_strStepDescription,
		// GlobalVariables.g_strKeywordDescription);

		return bStatus;
	}

	public static boolean killCommandLine() {

		boolean bStatus = false;
		try {
			String line;
			Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\tasklist.exe");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				if (line.startsWith("cmd.exe")) {
					line = line.replace("cmd.exe", "").trim();
					System.out.println(line);
					String cmd = "taskkill /F /PID " + line.substring(0, line.indexOf(" ")).trim();
					Runtime.getRuntime().exec(cmd);
				}
			}
			input.close();
			bStatus = true;

		} catch (Exception err) {
			err.printStackTrace();
		}
		return bStatus;
	}

	// -======================================================================================

	/**
	 * sendReceiveSoapRequestEnvelope method can send GET/POST Soap request and
	 * validates the response
	 * 
	 * @param resourcePath
	 *            This describes End point URL
	 * @param envelope
	 *            This describes XML request
	 * @param request
	 *            This describes Data
	 * @param strStatusDesc
	 *            This describes validate response data
	 * @return Boolean value True/False based on success of this function
	 * @author Raghavendra Banavalikar
	 */

	/* ESB */
	public boolean sendReceiveSoapRequestEnvelope(String resourcePath, String envelope, String request,
			String strStatusDesc) throws Exception {
		boolean bStatus = false;
		String strExpected_statuscode = "", strExpected_statusDesc = "";

		try {

			
			// Construct request envelope
			String requestEnv = readValueFromIniFile(envelope, "soapRequest");
			if (!request.isEmpty()) {
				// Construct request parameters
				HashMap<String, String> input = constructRequestParam(request);
				for (String key : input.keySet()) {

					requestEnv = requestEnv.replace(key, input.get(key));
				}
			}

			/**
			 * Send soap request and get response as xml string
			 */

			s_objlog4j.info(requestEnv);
			String xmlResponse = given().body(requestEnv).when().post(resourcePath).andReturn().body().asString();
			xmlResponse = xmlResponse.replace(
					xmlResponse.substring(xmlResponse.indexOf("Envelope>"), xmlResponse.lastIndexOf("")), "Envelope>");
			xmlResponse = xmlResponse.replace(xmlResponse.substring(0, xmlResponse.lastIndexOf("<soap:Envelope")), "");
			s_objlog4j.info(xmlResponse);

			String projectPath = System.getProperty("user.dir");

			projectPath = projectPath.replace("\\", "/");
			FileWriter requestFile = new FileWriter(new File(projectPath + "/webservice/" + envelope + "Request.xml"));

			requestFile.write(readValueFromIniFile(envelope, "soapRequest"));
			requestFile.flush();
			requestFile.close();

			FileWriter responseFile = new FileWriter(
					new File(projectPath + "/webservice/" + envelope + "Response.xml"));
			responseFile.write(xmlResponse);
			responseFile.flush();
			responseFile.close();

			s_childExtentTest.log(LogStatus.INFO, "Web Service Request :",
					"<p style=\"white-space:pre\">" + "<a href=\"" + projectPath + "/webservice/" + envelope
							+ "Request.xml" + "\">" + envelope + " Request" + "</a>");

			s_childExtentTest.log(LogStatus.INFO, "Web Service Response :",
					"<p style=\"white-space:pre\">" + "<a href=\"" + projectPath + "/webservice/" + envelope
							+ "Response.xml" + "\">" + envelope + " Response" + "</a>");

			String[] status = strStatusDesc.split(":");
			strExpected_statuscode = status[0];
			strExpected_statusDesc = status[1];
			System.out.println("expected_statuscode = " + strExpected_statuscode + "expected_statusDesc = "
					+ strExpected_statusDesc);

			XmlPath statusPath = new XmlPath(xmlResponse).setRoot(readValueFromIniFile(envelope, "statusRoot"));
			String strActual_statusCode = statusPath.getString("status");
			String strActual_statusDesc = statusPath.getString("status_desc");

			if ((strActual_statusCode.equals(strExpected_statuscode)
					&& (strActual_statusDesc.contains(strExpected_statusDesc)))
					|| (strExpected_statuscode.equals("Not 10000") && strExpected_statusDesc.contains("Exception"))) {
				s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :", "<p>Expected Status Code : "
						+ strExpected_statuscode + "<br> Actual Status Code" + " : " + strActual_statusCode + "</p>");

				s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :",
						"<p>Expected Status Description : " + strExpected_statusDesc + "<br> Actual Status Description"
								+ " : " + strActual_statusDesc + "</p>");

				bStatus = true;
			} else {
				s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail :", "<p>Expected Status Code : "
						+ strExpected_statuscode + "<br> Actual Status Code" + " : " + strActual_statusCode + "</p>");

				s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail :",
						"<p>Expected Status Description : " + strExpected_statusDesc + "<br> Actual Status Description"
								+ " : " + strActual_statusDesc + "</p>");

			}
			/**
			 * Validate the response and log into report
			 */

			XmlPath xml = new XmlPath(xmlResponse).setRoot(readValueFromIniFile(envelope, "responseRoot"));

			XmlPath payload = new XmlPath(xml.getString("payload"))
					.setRoot(readValueFromIniFile(envelope, "payloadRoot"));

			String strPayload = payload.prettify().replaceAll("\\<.*?\\>", "").trim();

			String strNodeName = "returnCode";
			String payloadResponse = xml.getString("payload");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(payloadResponse)));
			NodeList nodes = document.getElementsByTagName("ReturnCode");

			for (int i = 0; i < nodes.getLength();) {
				org.w3c.dom.Node renameNode = document.renameNode(nodes.item(i), "", "returnCode");
				strNodeName = renameNode.getNodeName();

			}

			if ((!payload.setRoot(strNodeName).getString(strNodeName).isEmpty())
					&& (payload.getString(strNodeName).equals("10000"))) {
				String strReturnCode = payload.getString("returnCode");
				s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :", "<p>Expected Return Code : " + strReturnCode
						+ "<br> Actual Return Code" + " : " + strReturnCode + "</p>");
			} else if ((!payload.setRoot(strNodeName).getString(strNodeName).isEmpty())
					&& (!payload.getString(strNodeName).equals("10000"))) {
				String strReturnCode = payload.getString("returnCode");
				s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail :", "<p>Expected Return Code : " + "10000"
						+ "<br> Actual Return Code" + " : " + strReturnCode + "</p>");
			}

			else if (!payload.setRoot("totalCount").getString("totalCount").isEmpty()) {
				if (Integer.parseInt(payload.getString("totalCount")) > 0) {
					String strTotalCount = payload.getString("totalCount");
					s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :",
							"<p>Expected total Count > 0  :  " + strTotalCount + "</p>");
				} else {
					String strTotalCount = payload.getString("totalCount");
					s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail :",
							"<p>Actual total Count  :  " + strTotalCount + "</p>");
				}

			}

			else if (!strPayload.isEmpty()) {

				s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :",
						"<p style=\"white-space:pre\">" + "<a href=\"" + projectPath + "/webservice/" + envelope
								+ "Response.xml" + "\">" + envelope + " Response" + "</a>");
			}

			else {

				s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail", "Failed to get Valid Response");
			}

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveSoapRequest", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveSoapRequest", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String[] strException = sw.toString().split("\n");
			for (int i = 0; i < strException.length; i++) {
				s_childExtentTest.log(LogStatus.ERROR, "sendReceiveSoapRequest Exception", strException[i]);
				if (i >= 2)
					break;
			}
		} finally {
		}
		return bStatus;
	}

	/**
	 * sendReceiveSoapRequest method can send GET/POST soap request and
	 * validates the response
	 * 
	 * @param resourcePath
	 *            This describes End point URL
	 * @param envelope
	 *            This describes XML request
	 * @param request
	 *            This describes Data
	 * @param query
	 *            This describes validate response data with DB
	 * @return Boolean value True/False based on success of this function
	 * @author Kannan Dharani
	 */

	public boolean sendReceiveSoapRequest(String resourcePath, String envelope, String request, String query)
			throws Exception {
		boolean bStatus = false;
		try {

			
			// Set Base URI
			// setBaseURI("SOAP");

			// Query DB
			// s_objlog4j.info(readValueFromIniFile(envelope, query));

			/* Change date format to validate with DB value */
			DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");

			DateFormat expectedFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			// Construct request envelope
			String requestEnv = readValueFromIniFile(envelope, "soapRequest");
			if (!request.isEmpty()) {
				// Construct request parameters

				HashMap<String, String> input = constructRequestParam(request);
				for (String key : input.keySet()) {
					requestEnv = requestEnv.replace(key, input.get(key));
				}
			}
			// requestSpecification = new
			// RequestSpecBuilder().addParams(requestParams).build();

			/**
			 * Construct response specification
			 */
			// responseSpecification = new
			// ResponseSpecBuilder().expectStatusCode(200).build();

			/**
			 * Send soap request and get response as xml string
			 */

			s_objlog4j.info(requestEnv);
			String xmlResponse = given().body(requestEnv).when().post(resourcePath).andReturn().body().asString();
			s_objlog4j.info(xmlResponse);

			/**
			 * Validate the response and log into report
			 */

			String[] strQueries = query.split(";");
			/* sending each query to validate particular data with response. */
			for (int Iquery = 0; Iquery < strQueries.length; Iquery++) {

				/* fetching data from DB to validate with WS Response */
				ResultSet dbResult = ExecuteDBQueryoracle(strQueries[Iquery]);

				/**
				 * Construct xml object to parse the response
				 */
				XmlPath xml = new XmlPath(xmlResponse).setRoot(readValueFromIniFile(envelope, "responseRoot"));
				// s_objlog4j.info(xml.prettify());

				if (Iquery == 0)
					s_childExtentTest.log(LogStatus.INFO, "sendReceiveSoapRequest", xml.prettify());

				XmlPath payload = new XmlPath(xml.getString("payload"))
						.setRoot(readValueFromIniFile(envelope, "payloadRoot"));

				String payloadResponse = xml.getString("payload");
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.parse(new InputSource(new StringReader(payloadResponse)));

				/* checking actual data in other rows in */
				/*
				 * boolean rowCount = dbResult.next(); traverse multiple rows
				 * from table
				 * 
				 * int iCount = 0; while ((dbResult.next() == true) ||
				 * (dbResult.first() == true)) { iCount++;
				 * System.out.println(dbResult.getString(iCount)); if
				 * (payloadResponse.contains(dbResult.getString(2))) {
				 */
				/*****************************/
				for (int i = 1; i <= GlobalVariables.g_intTotalColumns; i++) {

					String expected = dbResult.getString(i);
					// s_objlog4j.info(dbResult.getMetaData().getColumnName(i));
					// s_objlog4j.info(expected);

					if (expected == null)
						expected = "No Data";

					String strTagName = dbResult.getMetaData().getColumnName(i);

					NodeList nodeList = document.getElementsByTagName(strTagName);

					// System.out.println("status
					// ="+payload.setRoot(strTagName).getString(strTagName));
					// System.out.println("strTagName = " + strTagName);

					if (!payload.setRoot(strTagName).getString(strTagName).isEmpty()) {
						String actual = payload.get(strTagName);

						if ((strTagName.contains("Date")) && (!expected.equalsIgnoreCase("no data"))) {
							actual = actual.substring(0, actual.indexOf("T")).trim();
							Date date = originalFormat.parse(actual);
							actual = targetFormat.format(date);
							Date expectedDate = expectedFormat.parse(expected);
							expected = targetFormat.format(expectedDate);
						}

						if (expected.equalsIgnoreCase(actual)) {
							s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :",
									"<p>Expected " + dbResult.getMetaData().getColumnName(i) + " : " + expected
											+ "<br> Actual " + dbResult.getMetaData().getColumnName(i) + " : " + actual
											+ "</p>");
							bStatus = true;
						} else {

							s_childExtentTest.log(LogStatus.ERROR, "Expectation Pass :",
									"<p>Expected " + dbResult.getMetaData().getColumnName(i) + " : " + expected
											+ "<br> Actual " + dbResult.getMetaData().getColumnName(i) + " : "
											+ "<b style=\"color:red;\">" + actual + "</b></p>");
							bStatus = true;
						}

					}
					// traversing child nodes
					else if (readValueFromIniFile(envelope, "ChildNodeRoot") != null) {

						String strActual = null;

						/* Reading Child node ProblemList */

						String childNodeRoot = readValueFromIniFile(envelope, "ChildNodeRoot");
						String[] strNodes = childNodeRoot.split(";");

						for (int b = 0; b < strNodes.length; b++) {
							// NodeList childNodeList =
							// document.getElementsByTagName(childNodeRoot);

							NodeList childNodeList = document.getElementsByTagName(strNodes[b]);

							for (int k = 0; k < childNodeList.getLength(); k++) {

								boolean bFlag = false;

								NodeList firstChildList = childNodeList.item(k).getChildNodes();

								for (int j = 0; j < firstChildList.getLength(); j++) {

									NodeList secondChildList = firstChildList.item(j).getChildNodes();

									String strNode = firstChildList.item(j).getNodeName();

									strActual = firstChildList.item(j).getTextContent();

									String secondChildNodeRoot = readValueFromIniFile(envelope, "ChildNodeRoot2");

									if ((secondChildNodeRoot != null) && (secondChildNodeRoot.equals(strNode))) {

										NodeList secondChildNodeList = document
												.getElementsByTagName(secondChildNodeRoot);

										for (int m = 0; m < secondChildNodeList.getLength(); m++) {
											NodeList thirdChildList = secondChildNodeList.item(m).getChildNodes();

											for (int n = 0; n < thirdChildList.getLength(); n++) {

												strNode = thirdChildList.item(n).getNodeName();
												strActual = thirdChildList.item(n).getTextContent();

												if (expected.equals(strActual) || strNode.contains("Date"))
													break;
											}
										}
									}

									if (strNode.contains("Date")) {

										strActual = strActual.substring(0, strActual.indexOf("T")).trim();
										Date date = originalFormat.parse(strActual);
										strActual = targetFormat.format(date);
										if ((strTagName.contains("Date")) && (!expected.equalsIgnoreCase("no data"))) {
											if (expected.contains("T")) {
												expected = expected.substring(0, expected.indexOf("T")).trim();
												Date date1 = originalFormat.parse(expected);
												expected = targetFormat.format(date1);
											} else {
												Date expectedDate = expectedFormat.parse(expected);
												expected = targetFormat.format(expectedDate);
											}
										}
									}

									if (expected.equalsIgnoreCase(strActual)) {
										s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :",
												"<p>Expected " + dbResult.getMetaData().getColumnName(i) + " : "
														+ expected + "<br> Actual "
														+ dbResult.getMetaData().getColumnName(i) + " : " + strActual
														+ "</p>");
										bStatus = true;
										bFlag = true;
										break;
									}
								}
								/*
								 * Checking for duplicates and discarding
								 */
								if (bFlag == true)
									break;
							}
						}
						if (bStatus != true) {

							s_childExtentTest.log(LogStatus.ERROR, "Expectation Pass :",
									"<p>Expected " + dbResult.getMetaData().getColumnName(i) + " : " + expected
											+ "<br> Actual " + dbResult.getMetaData().getColumnName(i) + " : "
											+ "<b style=\"color:red;\">" + strActual + "</b></p>");
							bStatus = true;
						}
					}

				}
				/* checking actual data in other rows in */
				/*
				 * } else { break; } if(bStatus == true){ break; } }
				 */
				/****************/
			}

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		} finally {
			if (GlobalVariables.g_objConnection != null)
				GlobalVariables.g_objConnection.close();
			s_objlog4j.info("DB connection closed");
		}

		return bStatus;
	}

	/**
	 * sendGetRestRequest method can send GET Rest request and validates the
	 * response
	 * 
	 * @param resourcePath
	 *            This describes End point URL
	 * @param request
	 *            This describes Data
	 * @param response
	 *            This describes validate response data
	 * @param access_token
	 *            describes Authorization Key
	 * @param header
	 *            This describes Request Data
	 * @return Boolean value True/False based on success of this function
	 * @author Raghavendra Banavalikar
	 */

	public boolean sendGetRestRequest(String resourcePath, String request, String response, String access_token,
			String header) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = null;
		String json;

		try {

		
			// Set Base URI
			// setBaseURI("REST");

			// Construct request parameters
			HashMap<String, String> requestParams = new HashMap<String, String>();

			if (!request.startsWith("{"))
				requestParams = constructRequestParam(request);

			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();
			if (!response.isEmpty()) {
				responseParams = constructResponseParam(response);
			}

			// Construct response specification
			// responseSpecification = new
			// ResponseSpecBuilder().expectStatusCode(200).build();

			if (access_token.equalsIgnoreCase("YES")) {

				// Construct request specification

				headers = constructHeader(header);

				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .addHeaders(headers).build();
				 */

				if (!(given().headers(headers).queryParameters(requestParams).get(resourcePath)
						.getStatusCode() == HTTP_OK)) {

					// getAccessToken();
				}

				// Construct request specification

				headers = constructHeader(header);
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .addHeaders(headers).build();
				 */
				if (request.startsWith("{")) {
					json = given().headers(headers).body(request).get(resourcePath).asString();
				} else
					json = given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();
			} else {
				// Construct request specification
				// headers = constructRequestParam(header);
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .build();
				 */
				json = given().queryParameters(requestParams).get(resourcePath).asString();
			}

			/**
			 * Send Rest request and get response as json string
			 */

			// String json =
			// given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();
			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.INFO, "sendReceiveRestRequest", json);

			/**
			 * Validate the response and log into report
			 */
			for (String key : responseParams.keySet()) {

				String expected = jsPath.get(key).toString();
				String actual = responseParams.get(key);
				if (expected.equalsIgnoreCase(actual)) {
					s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :",
							"<p>Expected : " + responseParams.get(key) + "<br> Actual : " + jsPath.get(key) + "</p>");
					bStatus = true;
				} else {
					s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail :",
							"<p>Expected : " + responseParams.get(key) + "<br> Actual : " + "<b style=\"color:red;\">"
									+ jsPath.get(key) + "</b></p>");
					bStatus = false;
				}
			}

		//	requestSpecification = null;
			//responseSpecification = null;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * setRequestParam method constructs request for Rest / Soap services
	 * 
	 * @return HashMap <String, String>
	 * @author Kannan Dharani
	 */
	public HashMap<String, String> constructHeader(String headerParam) {
		String header = null;

		/*
		 * header = X_IBM_CLIENT_ID + GlobalVariables.g_strClientId + ";" +
		 * "Authorization= Bearer " + GlobalVariables.g_strAccessToken;
		 * s_objlog4j.info(header);
		 * 
		 * String[] requestParam = header.split(";");
		 */
		HashMap<String, String> requestHeader = new HashMap<String, String>();

		requestHeader.put(X_IBM_CLIENT_ID, GlobalVariables.g_strMobileClientId);

		// GlobalVariables.g_strMobileAuthToken =
		// "AAEkNzFmZTRkNmEtZjU4NS00ZDUxLTk4NzktMWRhY2IxMDNhYjdhjC6ezTst8IPqytir9XEe7AaLhk_Uko8qBxNNag2XJw0ksVz9ll21QhTEdLnzBAEhDWewEPhRLk2iTrP3HLNLYqYFhLY9hnbHQcwmbVici73J2RFiyw4tHkyQfaSHQkpm";

		requestHeader.put(AUTHORIZATION, BEARER + " " + GlobalVariables.g_strMobileAuthToken);

		String[] requestParam = headerParam.split(";");

		if (requestParam.length > 0) {
			for (String param : requestParam) {

				// String[] keyVal = param.split("===");

				String[] keyVal = param.split(":");

				requestHeader.put(keyVal[0], keyVal[1]);
			}
		}

		return requestHeader;

	}

	/**
	 * sendPostRestRequest method can send POST Rest request and validates the
	 * response
	 * 
	 * @param resourcePath
	 *            This describes End point URL
	 * @param request
	 *            This describes Data
	 * @param response
	 *            This describes validate response data
	 * @param access_token
	 *            describes Authorization Key
	 * @param header
	 *            This describes Request Data
	 * @return Boolean value True/False based on success of this function
	 * @author Raghavendra Banavalikar
	 */

	public boolean sendPostRestRequest(String resourcePath, String request, String response, String access_token,
			String header) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = null;
		String json;

		try {

			
			System.setProperty("http.proxyHost","");

			System.setProperty("http.proxyPort", "");

			// Set Base URI
			// setBaseURI("REST");

			// Construct request parameters

			HashMap<String, String> requestParams = new HashMap<String, String>();

			if (!request.startsWith("{"))
				requestParams = constructRequestParam(request);

			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();

			if (!response.isEmpty()) {
				responseParams = constructResponseParam(response);
			}

			// Construct response specification
			// responseSpecification = new
			// ResponseSpecBuilder().expectStatusCode(200).build();

			if (access_token.equalsIgnoreCase("YES")) {

				// Construct request specification

				headers = constructHeader(header);
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .addHeaders(headers).build();
				 */

				if (!(given().headers(headers).queryParameters(requestParams).post(resourcePath)
						.getStatusCode() == HTTP_OK)) {

					getAccessToken();

					/*
					 * do{ getAccessToken(); System.out.
					 * println("GlobalVariables.g_strMobileAuthToken = "
					 * +GlobalVariables.g_strMobileAuthToken); }
					 * while(GlobalVariables.g_strMobileAuthToken == null);
					 */

				}

				// Construct request specification

				headers = constructHeader(header);
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .addHeaders(headers).build();
				 */

				if (request.startsWith("{")) {
					json = given().headers(headers).body(request).post(resourcePath).asString();
				} else
					json = given().headers(headers).queryParameters(requestParams).post(resourcePath).asString();

			} else {
				// Construct request specification
				// headers = constructRequestParam(header);
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .build();
				 */
				json = given().queryParameters(requestParams).post(resourcePath).asString();
			}

			/**
			 * Send Rest request and get response as json string
			 */

			// String json =
			// given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();
			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.INFO, "sendReceiveRestRequest", json);

			/**
			 * Validate the response and log into report
			 */
			for (String key : responseParams.keySet()) {

				String expected = jsPath.get(key).toString().trim();
				String actual = responseParams.get(key).trim();
				if (expected.equalsIgnoreCase(actual)) {
					s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :",
							"<p>Expected : " + responseParams.get(key) + "<br> Actual : " + jsPath.get(key) + "</p>");
					bStatus = true;
				} else {
					s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail :",
							"<p>Expected : " + responseParams.get(key) + "<br> Actual : " + "<b style=\"color:red;\">"
									+ jsPath.get(key) + "</b></p>");
					bStatus = false;
				}
			}

		//	requestSpecification = null;
			//responseSpecification = null;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;
	}

	
	public boolean getTitle(String StrText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {

			System.out.println(driver.getTitle() + "---------StrText---------" + StrText);

			if (driver.getTitle().equals(StrText) || driver.getTitle().contains(StrText)) {
				bStatus = true;
				GlobalVariables.g_captureScreenShot = true;
						
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			} else
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is unsuccessful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
			// return true;
		}
		return bStatus;
	}

	/**
	 * verifyTextonPage Verify text on the page
	 * 
	 * @param StrText
	 *            is the text to be verified on the page
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean verifyTextonPage(String StrText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			String temp = buttonOrLink.getText();

			System.out.println(StrText + "+++++++++++++++++++++++++++" + temp);

			System.out.println(temp.equals(StrText));

			if (temp.equals(StrText) || temp.contains(StrText)) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
				bStatus = true;

			}

			else {
				// s_childExtentTest.log(LogStatus.ERROR, "verifyTextonPage",
				// GlobalVariables.g_strStepDescription);
				throw new Exception();
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * verifylinksonPage Verified links on the page
	 * 
	 * @param String
	 *            containing all the link text as a single sentence
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean verifylinksonPage(String StrText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			List<WebElement> links = createWebElements(strExcelInfo[0], strExcelInfo[1]);

			for (WebElement temp : links) {
				if (StrText.contains(temp.getText()))
					bStatus = false;
				else {

					bStatus = true;
					break;
				}

			}

			if (bStatus == true) {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");

			}

			else {
				// s_childExtentTest.log(LogStatus.ERROR, "verifyTextonPage",
				// GlobalVariables.g_strStepDescription);
				throw new Exception();
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * VerifyBrokenLinksOnPage Verify links are broken by checking the status of
	 * the URL response
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */

	public boolean VerifyBrokenLinksOnPage() throws Throwable {
		List<WebElement> elementList = new ArrayList<WebElement>();
		elementList = driver.findElements(By.tagName("a"));

		boolean bStatus = false;
		for (int i = 0; i < elementList.size(); i++) {
			WebElement element = elementList.get(i);
			if (element.getAttribute("title").equals("Click to view Report")) {

				HttpURLConnection connection = (HttpURLConnection) new URL(element.getAttribute("href"))
						.openConnection();
				connection.connect();
				String response = connection.getResponseMessage();
				connection.disconnect();

				System.out.println(response + "------------------" + element.getAttribute("href"));

				if (response.equals("OK"))
					bStatus = true;
				else {
					bStatus = false;
					break;

				}

			}

		}

		if (bStatus == true)
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		else
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");

		return bStatus;

	}

	/**
	 * PressTab Simulate pressing the TAB key using Robot class
	 * 
	 * @param count
	 *            is number of time tab is to be press
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean pressTab(String count) throws Exception {
		boolean bStatus = false;

		Robot robot = new Robot();
		try {
			for (int i = 0; i < Integer.parseInt(count); i++) {
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * getAllValuesFromDropdownList Retrieve all the options inside a Drop down
	 * list as text
	 * 
	 * @param DdlOptions
	 *            containing all the values of the drop down list with each
	 *            option in a new line
	 * @return Boolean value True/False based on success of this function
	 * @author Hemanth S M
	 */
	public boolean getAllValuesFromDropdownList(String DdlOptions) throws Exception {
		boolean bStatus = false;
		boolean isMatch = false;
		String[] strExcelInfo = null;
		String DDLOption = null;
		int i = 0;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			List<WebElement> List = element.findElements(By.tagName("option"));
			for (WebElement option : List) {
				DDLOption = option.getText();
				String[] a = DdlOptions.split("[\\r\\n]+");

				if (i >= a.length)
					break;

				System.out.println("Value passed as parameter: " + a[i]);
				System.out.println("Value retrieved from the drop down list: " + DDLOption);
				if (DDLOption.equals(a[i])) {
					System.out.println("Match");
					isMatch = true;
					i++;
				} else {
					System.out.println("Mismatch... Exiting");
					isMatch = false;
					break;
				}

				if (isMatch)
					bStatus = isMatch;
			}

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * isDisplayed Check for Element is displayed on the page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean isDisplayed() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			bStatus = buttonOrLink.isDisplayed();
			if (bStatus == false) {
				throw new Exception();
			} else {
				GlobalVariables.g_captureScreenShot = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();

		}
		return bStatus;
	}

	/**
	 * isEnabled Check for Element is enabled
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */

	public boolean isEnabled() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			bStatus = buttonOrLink.isEnabled();
			if (bStatus == false) {
				throw new Exception();
			} else {
				GlobalVariables.g_captureScreenShot = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * verifyAttributeNotExists Check for Element attribute notexists on the
	 * page
	 * 
	 * @param attribute
	 *            name to be varify
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean verifyAttributeNotExists(String attribute) throws Throwable {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
				GlobalVariables.g_strLogicalName);
		WebElement component = createWebElement(strExcelInfo[0], strExcelInfo[1]);
		String value = component.getAttribute(attribute);
		if (value == null || value.equals("")) {
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");
		} else {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
		}
		return bStatus;
	}

	/**
	 * VerifyToolTipText verify content of the tool tip text
	 * 
	 * @param TextToCompare
	 *            Attribute to be varify
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean VerifyToolTipText(String TextToCompare) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			// System.out.println(TextToCompare+element.getAttribute("title"));

			if (TextToCompare.equals(element.getAttribute("title"))
					|| element.getAttribute("title").contains(TextToCompare)) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + TextToCompare + "is validated");

			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + TextToCompare + "is not validated");

			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTextForAutoComplete method enters text into object using robot class
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean EnterTextForAutoComplete(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			element.click();
			Robot robot = new Robot();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(m_strText);
			clipboard.setContents(stringSelection, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + m_strText + " is entered");
			bStatus = true;
		} catch (Exception e) {
			bStatus = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + m_strText + " is not entered");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * verifyValuePresentFromDropdownList method verify all options in the
	 * dropdown
	 * 
	 * @param DdlOptions
	 *            is the list of options of the drop down
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean verifyValuePresentFromDropdownList(String DdlOptions) throws Exception {
		boolean bStatus = false;
		boolean isMatch = false;
		String[] strExcelInfo = null;
		String DDLOption = null;
		int i = 0;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			List<WebElement> List = element.findElements(By.tagName("option"));
			for (WebElement option : List) {
				DDLOption = option.getText();
				String a = DdlOptions;

				System.out.println("Value passed as parameter: " + a);
				System.out.println("Value retrieved from the drop down list: " + DDLOption);
				if (DDLOption.equals(a)) {
					System.out.println("Match");
					bStatus = true;
					break;
				}

			}

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * verifyValueNotPresentFromDropdownList method verify options not present
	 * in the dropdown
	 * 
	 * @param DdlOptions
	 *            is the list of options of the drop down
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean verifyValueNotPresentFromDropdownList(String DdlOptions) throws Exception {
		boolean bStatus = false;
		boolean isMatch = false;
		String[] strExcelInfo = null;
		String DDLOption = null;
		int i = 0;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			List<WebElement> List = element.findElements(By.tagName("option"));
			for (WebElement option : List) {
				DDLOption = option.getText();
				String a = DdlOptions;
				System.out.println("Value passed as parameter: " + a);
				System.out.println("Value retrieved from the drop down list: " + DDLOption);
				if (DDLOption.equals(a)) {
					System.out.println("Match");
					bStatus = false;
					break;
				}
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTextAndStoreSplitByHyphen method removes hyphen between string
	 * 
	 * @param m_strText
	 *            is text of where hyphen should be removed
	 * @return Boolean value True/False based on success of this function
	 * @author Sandeep K
	 */
	public boolean EnterTextAndStoreSplitByHyphen(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			textBox.click();
			textBox.clear();
			textBox.sendKeys(m_strText);
			String[] parts = m_strText.split("-");
			System.out.println("value in parts" + parts[0] + "====" + parts[1]);
			gVar.UniqueValue = parts[0] + parts[1];
			System.out.println("value in global variable is" + gVar.UniqueValue);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + m_strText + " is entered");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + m_strText + " is not entered");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 */
	private boolean isItemPresent(String xpath1) {
		List<WebElement> element = driver.findElements(By.xpath(xpath1));

		if (element.size() > 0)
			return true;
		else
			return false;
	}

	/**
	 */
	public static void scrollDownPage() throws Throwable {
		WebElement scroll = driver.findElement(By.xpath("//*[@id='mCSB_3_scrollbar_vertical']/a[2]"));

		int i = 1;

		while (i < 60) {
			scroll.click();
			i++;

		}
	}

	/**
	 * VerifyTreeStructure Verify elements of Tree
	 * 
	 * @author Sandeep K
	 * @return
	 */
	public boolean VerifyTreeStructure(String a) throws Throwable {
		boolean bStatus = false;
		String Xpath1 = "(//*[@id='mCSB_5_container']/div/ul/li/ul/li)[";
		String Xpath2 = "]";
		int I = 1, J = 1, K = 1, count = 0;
		String Xpath3 = "/label/following-sibling::ul/li[";
		String Xpath = Xpath1 + I + Xpath2;
		String prevXpath = null;
		while (isItemPresent(Xpath)) {
			if (isItemPresent(Xpath + "/label")) {
				WebElement element = driver.findElement(By.xpath(Xpath + "/label"));
				try {
					element.click();
					System.out.println(element.getText());
					prevXpath = Xpath;
					Xpath = Xpath + Xpath3 + J + "]";
					if (!isItemPresent(Xpath + "/label") && !isItemPresent(Xpath + "/a")) {
						String words[] = prevXpath.split("following");
						for (int i = 0; i < words.length; i++) {
							if (words[i].equals("-sibling::ul/li[1]"))
								;
							count++;
						}

						String newXpath = Xpath1 + I + Xpath2;
						J = J + 1;
						for (int i = 1; i < count; i++) {
							newXpath += Xpath3 + J + "]";
						}
						Xpath = newXpath;
						if (isItemPresent(prevXpath + "/label")) {
							J++;
							prevXpath = Xpath1 + I + Xpath2 + Xpath3 + J + "]";
							WebElement el = driver.findElement(By.xpath(prevXpath + "/label"));
							el.click();
						} else if (isItemPresent(prevXpath + "/a")) {
							J++;
							prevXpath = Xpath1 + I + Xpath2 + Xpath3 + J + "]";
							WebElement el = driver.findElement(By.xpath(prevXpath + "/a"));
						}
					}
				} catch (Exception e) {
					scrollDownPage();
				}
			} else if (isItemPresent(Xpath + "/a")) {
				WebElement element = driver.findElement(By.xpath(Xpath + "/a"));
				System.out.println(element.getText());
				I = I + 1;
				Xpath = Xpath1 + I + Xpath2;
				bStatus = true;
			}
			// System.out.println(Xpath);
		}
		s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
				GlobalVariables.g_strKeywordDescription + " is successful");
		return bStatus;
	}

	/**
	 * MouseOverAndClickUsingJS method performs mousing hover over an element
	 * and clicks on the sub element
	 * 
	 * @param clickXpath
	 *            This describes the xpath of the element to click
	 * @return Boolean value True/False based on success of this function
	 * @author Guru
	 */
	public boolean MouseOverAndClickUsingJS(String clickXpath) {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement mouseHoverEle = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement ClickElement = driver.findElement(By.xpath(clickXpath));

			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) driver).executeScript(mouseOverScript, mouseHoverEle);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript(mouseOverScript, ClickElement);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ClickElement);
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strStepDescription + "is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strStepDescription + "is unsuccessful");
			e.printStackTrace();
			bStatus = false;
		}
		return bStatus;
	}

	/**
	 * MouseOverAndClickUsingJS method performs mousing hover over an element
	 * and clicks on the sub element
	 * 
	 * @param clickXpath1
	 *            This describes the xpath of the element of sub link to Mouse
	 *            Over
	 * @param clickXpath2
	 *            This describes the xpath of the element of sub link of sub
	 *            link to click
	 * @return Boolean value True/False based on success of this function
	 * @author Guru
	 */

	public boolean MouseOverAndClickUsingJS(String clickXpath1, String clickXpath2) {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement mouseHoverEle = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement ClickElement1 = driver.findElement(By.xpath(clickXpath1));
			WebElement ClickElement2 = driver.findElement(By.xpath(clickXpath2));

			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) driver).executeScript(mouseOverScript, mouseHoverEle);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript(mouseOverScript, ClickElement1);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript(mouseOverScript, ClickElement2);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ClickElement2);
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strStepDescription + "is successful");
			bStatus = true;

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strStepDescription + "is unsuccessful");
			e.printStackTrace();
			bStatus = false;
		}
		return bStatus;
	}

	/**
	 * ValidateNotificationCount method Validates text into object from stored
	 * in global variable
	 * 
	 * @Para Give the Parameter according to your expectation, should be INC or
	 *       DEC And
	 * @return Boolean value True/False based on success of this function
	 * @author Guru
	 */
	public boolean ValidateNotificationCount(String Count) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			String getTextValue = createWebElement(strExcelInfo[0], strExcelInfo[1]).getText();

			int getTextCount = Integer.parseInt(getTextValue);
			int storedCount = Integer.parseInt(GlobalVariables.UniqueValue);

			if (getTextCount == storedCount) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + Count + " is validated");
				bStatus = true;
			} else if (getTextCount > storedCount && Count.equals("INC")) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + Count + " is validated");
				bStatus = true;
			}

			else if (getTextCount < storedCount && Count.equals("DEC")) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + Count + " is validated");
				bStatus = true;
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + Count + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * storeAndValidateTextOfTwoObjects method verifies text from two Objects
	 * 
	 * @param1 xpathOfGetTextObject This describes Xpath of One Object
	 * @param2 xpathOfValidateTextObject This describes Xpath of Anther Object
	 * @return Boolean value True/False based on success of this function
	 * @author Guru
	 */
	public boolean storeAndValidateTextOfTwoObjects(String xpathOfGetTextObject, String xpathOfValidateTextObject) {
		boolean bStatus = false;
		String valueStoringText = null;
		String valueValidatingText = null;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);

			WebElement getTextObject = driver.findElement(By.xpath(xpathOfGetTextObject));
			valueStoringText = getTextObject.getText().trim();

			WebElement validatingTextObject = driver.findElement(By.xpath(xpathOfValidateTextObject));
			valueValidatingText = validatingTextObject.getText().trim();

			if (valueValidatingText.contains(valueStoringText)) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + valueStoringText + " is validated");
				return true;
			}
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + valueStoringText + " is not validated");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + valueStoringText + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * clickAll method click on all object in a page
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Nains Jain
	 */
	public boolean clickAll() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			List<WebElement> checkBoxs = createWebElements(strExcelInfo[0], strExcelInfo[1]);
			Iterator<WebElement> itr = checkBoxs.iterator();
			while (itr.hasNext()) {
				itr.next().click();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * validateAllCheckBoxSelected method Validate all checkbox has selected
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Nains Jain
	 */
	public boolean validateAllCheckBoxSelected() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			List<WebElement> checkBoxs = createWebElements(strExcelInfo[0], strExcelInfo[1]);
			for (WebElement checkbox : checkBoxs) {
				checkbox.isSelected();
			}
			/*
			 * Iterator<WebElement> itr = checkBoxs.iterator();
			 * while(itr.hasNext()) { itr.next().isSelected(); }
			 */

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}
	/**
	 * EnterTextAtRuntimeValue method enters text which has stored into runtime
	 * variable
	 * 
	 * @param runtimeVariable
	 *            describes the variable which has stored as Key in HashMap
	 * @return Boolean value True/False based on success of this function
	 * @author Nains
	 */
	/*
	 * public boolean EnterTextAtRuntimeValue( String runtimeVariable) throws
	 * Exception { boolean bStatus = false; String[] strExcelInfo = null; try {
	 * strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.
	 * g_strObjectRepositoryFilePath, GlobalVariables.g_strLogicalName);
	 * waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
	 * // waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
	 * WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
	 * textBox.click(); textBox.clear();
	 * if(gVar.runtimeVariables.containsKey(runtimeVariable)){
	 * textBox.sendKeys(gVar.runtimeVariables.get(runtimeVariable).toString());
	 * s_childExtentTest.log(LogStatus.INFO, "EnterTextAtRuntimeValue",
	 * GlobalVariables.g_strStepDescription + " " +
	 * gVar.runtimeVariables.get(runtimeVariable).toString()); bStatus = true;
	 * }}catch (Exception e) { s_childExtentTest.log(LogStatus.ERROR,
	 * "EnterTextAtRuntimeValue", GlobalVariables.g_strStepDescription + " " +
	 * runtimeVariable); e.printStackTrace(); } return bStatus; }
	 */
	/**
	 * getTextAndStoreInVariable method gets the displayed text and stores into
	 * a variable
	 * 
	 * @param m_runtimeVariable
	 *            describes the variable to which it needs to be stored
	 * @return Boolean value True/False based on success of this function
	 * @author Nains
	 */

	/*
	 * public boolean getTextByIndexAndStoreInVariable(String runtimeVariable,
	 * String index) throws Exception { boolean bStatus = false; String[]
	 * strExcelInfo = null; try { strExcelInfo =
	 * gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.
	 * g_strObjectRepositoryFilePath, GlobalVariables.g_strLogicalName);
	 * waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
	 * WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
	 * String strVal = textBox.getText(); String newStrVal =
	 * strVal.split(" ")[Integer.valueOf(index)]; System.out.println(newStrVal);
	 * gVar.runtimeVariables.put(runtimeVariable.trim(), newStrVal);
	 * s_childExtentTest.log(LogStatus.INFO, "getTextAndStoreInVariable",
	 * GlobalVariables.g_strStepDescription + " " + newStrVal); bStatus = true;
	 * } catch (Exception e) { s_childExtentTest.log(LogStatus.ERROR,
	 * "getTextAndStoreInVariable", GlobalVariables.g_strStepDescription + " " +
	 * runtimeVariable); e.printStackTrace(); } return bStatus; }
	 */
	/**
	 * validateDescendingDateSorting method verifies Dates are sorted in
	 * Descending order or not
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Nains
	 */
	public boolean validateDescendingDateSorting(String m_locatorValue) {
		boolean sorted = true;
		try {
			List<WebElement> webElements = driver.findElements(By.xpath(m_locatorValue));
			for (int i = 1; i < webElements.size(); i++) {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String str1 = webElements.get(i - 1).getText();
				String str2 = webElements.get(i).getText();
				Date date1 = new Date();
				date1 = df.parse(str1);
				Date date2 = new Date();
				date2 = df.parse(str2);
				if (date1.compareTo(date2) < 0)
					sorted = false;
			}
			if (sorted) {
				s_childExtentTest.log(LogStatus.INFO, "validateDescendingDateSorting.",
						gVar.g_strStepDescription + " is successful");
			} else {
				s_childExtentTest.log(LogStatus.ERROR, "validateDescendingDateSorting",
						gVar.g_strStepDescription + " is failed");
			}
		} catch (Exception e) {
			sorted = false;
			s_childExtentTest.log(LogStatus.ERROR, "validateDescendingDateSorting",
					gVar.g_strStepDescription + " is failed due to exception thrown");
			e.printStackTrace();
		}
		return sorted;
	}

	/**
	 * validateAscDateSorting method verifies Dates are sorted in order or not
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Nains Jain
	 */
	public boolean validateAscSortingDate(String m_locatorValue) {
		boolean sorted = true;
		try {
			List<WebElement> webElements = driver.findElements(By.xpath(m_locatorValue));
			for (int i = 1; i < webElements.size(); i++) {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				String str1 = webElements.get(i - 1).getText();
				String str2 = webElements.get(i).getText();
				Date date1 = new Date();
				date1 = df.parse(str1);
				Date date2 = new Date();
				date2 = df.parse(str2);
				if (date1.compareTo(date2) > 0) {
					sorted = false;
				}
			}
			if (sorted) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			}
		} catch (Exception e) {
			sorted = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return sorted;
	}

	/**
	 * validateAscSorting method verifies elements text is sorted in Ascending
	 * order or not
	 * 
	 * @param m_locatorValue
	 *            This describes the xpath locator value to return all elements
	 *            to verify sorting
	 * @return Boolean value True/False based on success of this function
	 * @author Nains Jain
	 */
	public boolean validateAscSorting(String m_locatorValue) {
		boolean sorted = true;
		try {
			List<WebElement> webElements = driver.findElements(By.xpath(m_locatorValue));
			for (int i = 1; i < webElements.size(); i++) {
				String str1 = webElements.get(i - 1).getText();
				String str2 = webElements.get(i).getText();
				if (str1.compareTo(str2) > 0) {
					sorted = false;
				}
			}
			if (sorted) {
				s_childExtentTest.log(LogStatus.PASS, gVar.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, gVar.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is failed");
			}
		} catch (Exception e) {
			sorted = false;
			s_childExtentTest.log(LogStatus.FAIL, gVar.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is failed due to exception thrown");
			e.printStackTrace();
		}
		return sorted;
	}

	/**
	 * validateDesSorting method verifies values are sorted in Descending order
	 * or not
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Nains Jain
	 */
	public boolean validateDesSorting(String m_locatorValue) {
		boolean sorted = true;
		try {
			List<WebElement> webElements = driver.findElements(By.xpath(m_locatorValue));

			for (int i = 3; i < webElements.size(); i++) {
				String str1 = webElements.get(i - 1).getText();
				String str2 = webElements.get(i).getText();

				if (str1.compareTo(str2) < 0) {
					sorted = false;
				}
			}
			if (sorted) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			}
		} catch (Exception e) {
			sorted = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return sorted;
	}

	/**
	 * switchToTab method will used to switch to new tab
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Nayab Younus / Nains
	 */
	public boolean switchToTab() {
		boolean bStatus = false;
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			// Switch to new window
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(1000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * closeSwitchToTab method will used to closed the new tab and return to
	 * parent Tab
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Nayab Younus / Nains
	 */

	public boolean closeSwitchToTab() {
		boolean bStatus = false;
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			// Switch to new window
			driver.switchTo().window(tabs.get(1));
			// Closed the new window
			driver.close();
			Thread.sleep(1000);
			// Switch to main/parent window
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(1000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateTextFieldIsEmpty verify the text field is empty
	 * 
	 * @returnBoolean value True/False based on success of this function
	 * @author Raju velpula
	 */
	public boolean ValidateTextFieldIsEmpty() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);

			WebElement inputBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			String textInsideInputBox = inputBox.getAttribute("value");
			if (textInsideInputBox.isEmpty()) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * enterRandomText method enters random text as input
	 * 
	 * @param text-
	 *            This describes the name of locator
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */
	/*public boolean enterRandomText(String text) throws Exception {
		boolean bStatus = false;
		Random rand = new Random();
		String retString = text.concat(Integer.toString(rand.nextInt()));
		System.out.println("Random String is " + retString);

		GenericWebObjectLibrary gw = new GenericWebObjectLibrary(driver, con);

		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			textBox.clear();
			textBox.sendKeys(retString);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}*/

	/**
	 * enterDate method enters Date value based on the given time difference
	 * value
	 * 
	 * @param dateDiff-
	 *            This describes the differnce of the date from the current date
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */
	/*public static boolean enterDate(String dateDiff) throws Exception {
		boolean bstatus = false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Calendar c = Calendar.getInstance();

			String timeStamp = sdf.format(c.getTime());
			System.out.println("time stamp is" + timeStamp);

			c.setTime(sdf.parse(timeStamp));
			c.add(Calendar.DATE, Integer.parseInt(dateDiff)); // number of days
																// to
			// add
			timeStamp = sdf.format(c.getTime()); // timeStamp is now the new
													// date

			GenericWebObjectLibrary gw = new GenericWebObjectLibrary(driver, con);
			bstatus = gw.EnterTextThroughJavaScript(timeStamp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bstatus;
	}*/

	/**
	 * launchAlfresco method Launches the Alfresco application in IE browser and
	 * enters valid credentials
	 * 
	 * @param URL-
	 *            URL of the Alfresco QA Application
	 * @param UserName-User
	 *            name of the Alfresco QA Application
	 * @param pwd-Password
	 *            of the Alfresco QA Application
	 * @return Boolean value True/False based on success of this function
	 * @author Charan
	 */
	public boolean launchAlfresco(String URL, String UserName, String pwd) throws InterruptedException, AWTException {
		boolean bStatus = false;
		System.setProperty("webdriver.ie.driver",
				"C:\\framework\\src\\test\\resources\\drivers\\IEDriverServer.exe");
		InternetExplorerDriver d = new InternetExplorerDriver();
		d.get(URL);

		try {
			StringSelection Username = new StringSelection(UserName);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Username, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			StringSelection Password = new StringSelection(pwd);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Password, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			bStatus = true;
			d.manage().window().maximize();
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			e.printStackTrace();
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
		}
		return bStatus;
	}

	/**
	 * killIE method enters Kills all the active Iexplorer.exe processes
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Charan
	 */
	public boolean killIE() {
		boolean bStatus = false;
		try {
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			System.out.println("Killed IEdriver and closed ie browser");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bStatus;

	}

	/**
	 * getColumnDataFromDBAndStoreInGlobalVariable method to read the data from
	 * SQL Query output and stores the results in Global variable
	 * 
	 * @param strQuery-
	 *            SQL Query that has to be executed with replace text that will
	 *            be replaced by the Global variable while execution
	 * @param columnName-Column
	 *            name of the result set for which the value has to be moved to
	 *            Global variable
	 * @param sid-
	 *            This describes the schema ID
	 * @param dbUsername-
	 *            This describes the schema DB user name
	 * @param dbPassword-
	 *            This describes the schema DB password
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */

	public boolean getColumnDataFromDBAndStoreInGlobalVariable(String strQuery, String columnName, String sid,
			String dbUsername, String dbPassword) throws SQLException {

		ResultSet result = null;
		Boolean status = false;

		// forming the query for the newly created campaign name
		if (strQuery.contains("{replaceText}"))
			strQuery = strQuery.replace("{replaceText}", gVar.c_elementText);
		String str1 = null;
		try {

			result = executeDBQueryAndGetResultset(strQuery, sid, dbUsername, dbPassword);
			if (result.next()) {
				str1 = result.getObject(columnName).toString();
			}
			gVar.c_elementText = str1;
			System.out.println(gVar.c_elementText);
			status = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		} finally {
			result.close();
			con.close();
		}
		return status;
	}

	/**
	 * executeDBQueryAndGetResultset method executes the SQL Query passed and
	 * returns the resultset
	 * 
	 * @param strQuery-
	 *            This describes the Query that has to be executed in Oracle Db
	 * @param sid-
	 *            This describes the schema ID
	 * @param dbUsername-
	 *            This describes the schema DB user name
	 * @param dbPassword-
	 *            This describes the schema DB password
	 * @return rs- returns the result set
	 * @author Jagadeesh
	 */
	private ResultSet executeDBQueryAndGetResultset(String strQuery, String sid, String dbUsername, String dbPassword) {
		ResultSet rs = null;
		java.sql.Connection DBconnection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Oracle JDBC driver loaded ok.");
			
			DBconnection = DriverManager.getConnection(sid, dbUsername, dbPassword);
			// declaring statement
			Statement stmt = DBconnection.createStatement();
			rs = stmt.getResultSet();
			rs = stmt.executeQuery(strQuery);

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * validateMultipleColoumnsFromDB method validates the multiple column
	 * values from DB
	 * 
	 * @param strQuery-
	 *            SQL Query that has to be executed with replace text that will
	 *            be replaced by the Global variable while execution
	 * @param strValueToCompare-
	 *            This describes the expected data for the table columns
	 * @param sid-
	 *            This describes the schema ID
	 * @param dbUsername-
	 *            This describes the schema DB user name
	 * @param dbPassword-
	 *            This describes the schema DB password
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */

	public boolean validateMultipleColoumnsFromDB(String strQuery, String strValueToCompare, String sid,
			String dbUsername, String dbPassword) {
		// String strResult = null;
		ResultSet result = null;
		Boolean status = false;
		// strQuery="Select * from CM.campaign where
		// CAMPAIGNNM='TestCampaign_Auto11-432021241'";

		String[] strVal = strValueToCompare.split(",");

		// forming the query for the newly created campaign name
		strQuery = strQuery.replace("{replaceText}", gVar.UniqueValue);

		try {
			// strQuery=strQuery.replace("{replaceText}",gVar.UniqueValue);
			result = executeDBQueryAndGetResultset(strQuery, sid, dbUsername, dbPassword);

			for (String str : strVal) {
				String[] subString = str.split("=");
				if (result.next()) {
					String str1 = result.getObject(subString[0]).toString();
					if (str1.equalsIgnoreCase(subString[1])) {
						System.out.println("validation passed for " + str1 + " is equal to " + subString[1]);
						status = true;
					}
				}
			}
			// status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * WaitForPresenceOfAnElement method to wait for the presence of the element
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */

	public boolean WaitForPresenceOfAnElement() throws Exception {

		boolean bStatus = false;

		String[] strExcelInfo = null;

		WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.extMediumWait);

		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,

					GlobalVariables.g_strLogicalName);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strExcelInfo[1])));

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

			bStatus = true;

		} catch (Exception e) {

			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");

			e.printStackTrace();

		}

		return bStatus;

	}

	/**
	 * validateElementTextFromGlobalVar method get text of an element and
	 * validate with global variable value
	 * 
	 * @param elementXpath
	 *            this describes the xpath of the target element
	 * @param attribute
	 *            this describes the attribute of the target element
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */
	public boolean validateElementTextFromGlobalVar(String elementXpath, String attribute) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		String elementText = "";
		try {

			WebElement element = driver.findElement(By.xpath(elementXpath));

			// Storing the element value to global variable based on the
			// attribute given
			if (attribute.trim().equalsIgnoreCase("text")) {
				elementText = element.getText();
			} else {
				elementText = element.getAttribute(attribute.trim());
			}

			if (elementText.trim().contains(gVar.c_elementText.trim()))
				bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is validated");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * validateElementTextFromTree method get text of an element and validate
	 * with global variable in a tree
	 * 
	 * @param elementXpath
	 *            this describes the xpath of the target element
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */
	public boolean validateElementTextFromTree(String elementXpath) throws Exception {

		boolean bStatus = false;
		int i;

		try {

			List<WebElement> allLinks = driver.findElements(By.xpath(elementXpath));
			for (i = 0; i < allLinks.size(); i++) {

				String s1 = allLinks.get(i).getText();
				String s2 = gVar.UniqueValue;

				if (s1.contains(s2)) {
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
					break;
				}

			}

			if (i >= allLinks.size()) {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is unsuccessful");
				throw new Exception();
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();

		}

		return bStatus;
	}

	/**
	 * getElementTextAndStoreInGlobalVar method get text of an element and
	 * stores into variable
	 * 
	 * @param elementXpath
	 *            this describes the xpath of the target element
	 * @param attribute
	 *            this describes the attribute of the target element
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */
	public boolean getElementAttributeAndStoreInGlobalVar(String elementXpath, String attribute) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			WebElement element = driver.findElement(By.xpath(elementXpath));

			// Storing the element value to global variable based on the
			// attrubite given
			if (attribute.equalsIgnoreCase("text")) {
				gVar.c_elementText = element.getText();
			} else {
				gVar.c_elementText = element.getAttribute(attribute);
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * validateMultipleElementsPresence method validate the presence of multiple
	 * elements
	 * 
	 * @param m_strText
	 *            This describes the elements to be validated with comma
	 *            separated
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */
	public boolean validateMultipleElementsPresence(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		String[] multipleElements = m_strText.split(",");
		// iterating through all elements and checking for presence
		for (int i = 0; i < multipleElements.length; i++) {
			try {
				strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
						multipleElements[i]);
				bStatus = waitForPresenceOfElement(strExcelInfo[0], strExcelInfo[1]);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + multipleElements[i] + "is validated");
			} catch (Exception e) {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + multipleElements[i] + "is not validated");
				e.printStackTrace();
			}

		} // loop ends here
		return bStatus;
	}

	/**
	 * AcceptWarningIfExists method accepts the warning if it exists or else it
	 * ignores
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Charan
	 */

	public boolean AcceptWarningIfExists() throws Exception {

		boolean bStatus = false;

		String[] strExcelInfo = null;

		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);

			// waitForPresenceAndVisibilityOfElement(strExcelInfo[0],
			// strExcelInfo[1]);

			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			element.click();

			bStatus = true;
		} catch (Exception e) {
			bStatus = true;
		}

		return bStatus;

	}

	/**
	 * verifyIfElementIsEnabled method verify if the element is enabled
	 * 
	 * @param text-
	 *            This describes the name of locator
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */
	public boolean verifyIfElementIsEnabled() throws Exception {

		boolean bStatus = false;

		String[] strExcelInfo = null;

		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);

			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			if (element.isEnabled())
				bStatus = true;

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is successful");
		}

		return bStatus;

	}

	/**
	 * verifyIfElementIsNotPresent method verify if the element is not present
	 * 
	 * @param text-
	 *            This describes the name of locator
	 * @return Boolean value True/False based on success of this function
	 * @author Jagadeesh
	 */
	public boolean verifyIfElementIsNotPresent() throws Exception {

		boolean bStatus = false;

		String[] strExcelInfo = null;

		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);

			// waitForPresenceAndVisibilityOfElement(strExcelInfo[0],
			// strExcelInfo[1]);

			WebElement element = driver.findElement(By.xpath(strExcelInfo[1]));
			// element.click();

			if (!element.isDisplayed())
				bStatus = true;

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "is unsuccessful");
		}

		return bStatus;

	}

	/**
	 * ValidateElementText method validates the element text contains expected
	 * text using getText
	 * 
	 * @param m_strText
	 *            This describes the text value to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Charan
	 */
	public boolean ValidateElementText(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			System.out.println("Actual text=" + textBox.getText().replace(" ", "").toUpperCase());
			System.out.println("Expected text=" + m_strText.replace(" ", "").toUpperCase());
			if (m_strText.toUpperCase().equalsIgnoreCase("NULL") || textBox.getText().replace(" ", "").toUpperCase()
					.contains(m_strText.replace(" ", "").toUpperCase())) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + m_strText + " is validated");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + m_strText + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CE_VerifyToolTipNEnterText method performs text assertion and entry on a
	 * field
	 * 
	 * @param value
	 *            This holds the string value of the run from test data
	 * @param srchfldXpath
	 *            This holds the xpath for search box
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_VerifyToolTipNEnterText(String Value, String srchfldXpath) throws Exception {
		boolean bStatus = false;
		try {
			Thread.sleep(3000);

			Boolean Flag = waitForPresenceAndVisibilityOfElement("EVALUATEXPATH",
					"//div[contains(@onmouseover,'" + Value + "')]");
			if (Flag) {
				System.out.println("Tooltip value is:---" + Value);

				WebElement elID = createWebElement("EVALUATEXPATH", "//div[contains(@onmouseover,'" + Value
						+ "')]/ancestor::div[1]/preceding-sibling::div/ancestor::div[1]");
				GlobalVariables.strRunID = elID.getAttribute("id");
				System.out.println("ID displayed is :---" + GlobalVariables.strRunID);
				WebElement elSearchBox = createWebElement("EVALUATEXPATH", srchfldXpath);

				if (elSearchBox.isDisplayed()) {
					elSearchBox.sendKeys(GlobalVariables.strRunID);
				}
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is validated");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CE_PollAndVerifyStatus method performs polling for a status check on grid
	 * 
	 * @param request
	 *            This holds the string request from Test Data
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_PollAndVerifyStatus(String request) throws Exception {

		boolean bStatus = false;
		String StrStatus = null;
		WebElement StatusElement;
		WebElement element;
		WebElement SearchBtn;
		HashMap<String, String> requestParam = CE_constructRequestParam(request);
		try {
			Thread.sleep(3000);

			if (requestParam.containsKey("STATUS")) {
				element = createWebElement("EVALUATEXPATH", "//div[contains(@onmouseover,'" + requestParam.get("STATUS")
						+ "')]/ancestor::div[1]/following-sibling::div[4]/span");
				StrStatus = element.getText();

				if (StrStatus.contains("Complete")) {
					System.out.println("Status found :--" + StrStatus);
					bStatus = true;

				} else if (StrStatus.contains("Error")) {
					System.out.println("Status found :--" + StrStatus);
					bStatus = false;
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + StrStatus + " is found");
				}

			} else if (requestParam.containsKey("ID")) {
				WebElement ID = createWebElement("EVALUATEXPATH",
						"//span[@class='fieldLabel_nobold' and contains(text() ,'InProgress')]/ancestor::div[2]");

				if (ID != null) {
					GlobalVariables.strRunID = ID.getAttribute("id");
					StatusElement = createWebElement("EVALUATEXPATH",
							"//div[@id='" + GlobalVariables.strRunID + "']/div[6]/span[@class='fieldLabel_nobold']");
					StrStatus = StatusElement.getText();

					if (StrStatus.contains("Complete")) {
						System.out.println("Status found :--" + StrStatus);
						bStatus = true;

					} else if (StrStatus.contains("Error")) {
						System.out.println("Status found :--" + StrStatus);
						bStatus = false;
						s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + StrStatus + " is found");
					}

					WebElement txtBox = createWebElement("EVALUATEID", "runId");
					txtBox.sendKeys(GlobalVariables.strRunID);
					SearchBtn = createWebElement("EVALUATEXPATH",
							"//input[@class='button-search' and @value='Search']");
					SearchBtn.click();

				} else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + "WebElement is not found");
				}
			}
			while (!StrStatus.contains("Complete") && bStatus == false) {

				Thread.sleep(10000);
				SearchBtn = createWebElement("EVALUATEXPATH", "//input[@class='button-search' and @value='Search']");
				SearchBtn.click();
				Thread.sleep(3000);

				if (requestParam.containsKey("STATUS")) {
					element = createWebElement("EVALUATEXPATH", "//div[contains(@onmouseover,'"
							+ requestParam.get("STATUS") + "')]/ancestor::div[1]/following-sibling::div[4]/span");
					StrStatus = element.getText();

					if (StrStatus.contains("Complete")) {
						System.out.println("Status found :--" + StrStatus);
						bStatus = true;

					} else if (StrStatus.contains("Error")) {
						System.out.println("Status found :--" + StrStatus);
						bStatus = false;
						s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + StrStatus + " is found");
						break;
					}

				} else if (requestParam.containsKey("ID")) {
					element = createWebElement("EVALUATEXPATH",
							"//div[@id='" + GlobalVariables.strRunID + "']/div[6]/span[@class='fieldLabel_nobold']");

					if (element != null) {
						StrStatus = element.getText();
						if (StrStatus.contains("Complete")) {
							System.out.println("Status found :--" + StrStatus);
							bStatus = true;

						} else if (StrStatus.contains("Error")) {
							System.out.println("Status found :--" + StrStatus);
							bStatus = false;
							s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription + StrStatus + " is found");
							break;
						}
					} else {
						s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + "WebElement is not found");
					}
				} else if (driver
						.findElement(By.xpath("//div[contains(@class,'span-4')]/span[contains(text(),'Error')]"))
						.isDisplayed()) {
					s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + "Error found on status");
				}
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + StrStatus + " is validated");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "Completed status is validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CE_PollAndVerifyMultipleRunStatus method performs polling for a status
	 * check on grid
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_PollAndVerifyMultipleRunStatus() throws Exception {
		boolean bStatus = false;
		int intRunLen = 0;
		List<WebElement> Run;
		try {
			Thread.sleep(2000);
			Run = driver.findElements(By.xpath(
					"//div[contains(@class,'span-4')]/span[contains(text(),'Progress') or contains(text(),'Pending')]"));
			intRunLen = Run.size();

			while (intRunLen > 0) {
				Thread.sleep(10000);
				WebElement SearchBtn = createWebElement("EVALUATEXPATH",
						"//input[@class='button-search' and @value='Search']");
				SearchBtn.click();
				Run = driver.findElements(By.xpath(
						"//div[contains(@class,'span-4')]/span[contains(text(),'Progress') or contains(text(),'Pending')]"));
				intRunLen = Run.size();
				System.out.println(
						"Run creation on Hold due to " + intRunLen + "Run(s) available in Pending / In Progress State");
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + +intRunLen
							+ "Run(s) available in Pending / In Progress State");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CE_TriggerBatFile method triggers the .bat file at mentioned path
	 * 
	 * @param path
	 *            .bat file path
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_TriggerBatFile(String path) throws Exception {
		boolean bStatus = false;
		try {
			System.out.println("Executing file at:-" + path);
			Runtime.getRuntime().exec("cmd /c start " + path);
			bStatus = true;
			s_childExtentTest.log(LogStatus.INFO, "CE_TriggerBatFile", GlobalVariables.g_strStepDescription);
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "CE_TriggerBatFile", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * setRequestParam method constructs request for DB
	 * 
	 * @param request
	 *            It holds the string value passed from test data sheet to be
	 *            formatted into <k,V> pair
	 * @return HashMap <String, String>
	 * @author Kannan Dharani
	 */
	public static HashMap<String, String> CE_constructRequestParam(String request) {
		String[] reqParam = request.split(";");
		HashMap<String, String> requestParams = new HashMap<String, String>();

		for (String param : reqParam) {

			String[] keyVal = param.split(":");
			requestParams.put(keyVal[0], keyVal[1]);
		}
		return requestParams;
	}

	/**
	 * CE_ValidateColmnDataFrmODB method takes the HashmapObject in string
	 * format , triggers query to match the column values
	 * 
	 * @param request
	 *            This is a String value containing key value pair in format -
	 *            k:v separated with colon
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_ValidateColmnDataFrmODB(String request) throws ClassNotFoundException {

		HashMap<String, String> requestParam = CE_constructRequestParam(request);
		int intMapSize = requestParam.size() - 2;
		int intComputedSize = intMapSize / 2;
		String arr[] = new String[intComputedSize];

		Statement statement = null;
		ResultSet rs = null;
		java.sql.Connection DBconnection = null;
		boolean bStatus = false;
		try {
			s_objlog4j.info("Initiating Oracle JDBC Connection..");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBconnection = DriverManager.getConnection(
						"jdbc:oracle:thin:@" + GlobalVariables.g_strODBQAConnectionString,
						GlobalVariables.g_strODSQAUserID, GlobalVariables.g_strODSQAPwd);
				statement = DBconnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				s_objlog4j.info("Connected to DB server and requesting data..");
				if (requestParam.containsKey("query")) {
					rs = statement.executeQuery(requestParam.get("query"));

					if (rs != null && rs.next()) {
						do {
							for (int i = 0; i <= (intComputedSize - 1); i++) {
								arr[i] = rs.getString(requestParam.get("col" + i));
								if (arr[i].equalsIgnoreCase(requestParam.get("val" + i))) {

									bStatus = true;
									System.out.println("Validated value from DB :-" + arr[i].toString()
											+ requestParam.get("type"));
									s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
											GlobalVariables.g_strKeywordDescription + " is validated for "
													+ arr[i].toString() + " for type :-" + requestParam.get("type"));
								}
							}
						} while (rs.next() && bStatus == false);
					} else {
						s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is not validated");
					}
				}
			} catch (SQLException e) {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is not validated");
				e.printStackTrace();
				s_objlog4j.info(e.getMessage());
			}
			if (DBconnection != null) {
				try {
					DBconnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			s_objlog4j.info(e.getMessage());
		}
		return bStatus;
	}

	/**
	 * CE_ValidateIfRecordExistsFrmODB method verifies if recordset exists and
	 * provides the count of the same
	 * 
	 * @param query
	 *            This is the query to be passed
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_ValidateRecordCountFrmODB(String query) throws ClassNotFoundException {
		Statement statement = null;
		ResultSet rs = null;
		java.sql.Connection DBconnection = null;
		boolean bStatus = false;
		try {
			s_objlog4j.info("Initiating Oracle JDBC Connection..");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBconnection = DriverManager.getConnection(
						"jdbc:oracle:thin:@" + GlobalVariables.g_strODBQAConnectionString,
						GlobalVariables.g_strODSQAUserID, GlobalVariables.g_strODSQAPwd);
				statement = DBconnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				s_objlog4j.info("Connected to DB server and requesting data..");
				rs = statement.executeQuery(query);

				if (rs != null && rs.getFetchSize() > 0) {
					do {
						s_objlog4j.info("Resultset contains :-" + rs.getFetchSize());
						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + rs.getFetchSize() + " count is validated");
						bStatus = true;
					} while (rs.next() && bStatus == false);
				} else {

					s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is not validated");
				}
			} catch (SQLException e) {
				System.out.println("Connection Failed!");
				e.printStackTrace();
			}
			if (DBconnection != null) {
				try {
					DBconnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CE_ValidateErrorMsg method verifies the presence of any error message and
	 * prints the message dispalyed
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_ValidateMsg() throws ClassNotFoundException {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		WebElement Msg;
		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			Msg = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			if (Msg.isDisplayed()) {

				if (Msg.getText().contains("failed")) {

					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + Msg.getText() + " is validated");
				} else {
					bStatus = true;
				}
			} else {

				bStatus = true;
				s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is not validated");
			}
		} catch (Exception e) {
			bStatus = true;
			s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CE_ValidateMemberCount method Asserts the count of member from UI and DB
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */

	public boolean CE_ValidateMemberCount(String ProdType) {
		boolean bStatus = false;
		try {
			Thread.sleep(4000);
			System.out.println("Run ID displayed is :---" + GlobalVariables.strRunID);
			Boolean Flag = waitForPresenceAndVisibilityOfElement("EVALUATEXPATH",
					"//div[@id='" + GlobalVariables.strRunID + "']");
			WebElement RunRow = createWebElement("EVALUATEXPATH", "//div[@id='" + GlobalVariables.strRunID + "']");

			if (Flag) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", RunRow);
				Thread.sleep(23000);

				List<WebElement> GenSettingsList = createWebElements("EVALUATEXPATH",
						"//div[@id='" + GlobalVariables.strRunID + "']//span[contains(@class,'span-5')]");
				if (GenSettingsList.size() > 0) {
					for (WebElement webElement : GenSettingsList) {
						String Val = webElement.getText();
						if (Val.contains("-")) {
							String[] arrSplitItem = Val.split("-");
							Integer.parseInt(arrSplitItem[1]);
						} else {
							int count = Integer.parseInt(Val);
							System.out.println(count);
							Thread.sleep(20000);
							boolean strAck = AssertRecordCountFrmODB(count, ProdType, GlobalVariables.strRunID);
							if (strAck) {
								bStatus = true;
								s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
										GlobalVariables.g_strKeywordDescription + " is validated");
							}
						}
					}
				} else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is not validated");
				}
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * AssertRecordCountFrmODB method Asserts the count of member from UI and DB
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean AssertRecordCountFrmODB(int count, String ProdType, String RunID) throws ClassNotFoundException {
		Statement statement = null;
		ResultSet rs = null;
		java.sql.Connection DBconnection = null;
		boolean bStatus = false;
		try {
			s_objlog4j.info("Initiating Oracle JDBC Connection..");
			try {
				String query = "select cerma.PRODUCTMNEMONICCD, count(cerma.CAREENGINERUNACTIONTRACKINGID) As Total"
						+ " from csid.MEMBERRECOMMENDRUN mrr, csid.CAREENGINERUNMEMBERACTION cerma where mrr.CAREENGINERUNSCHEDULEID = "
						+ RunID + " and mrr.MEMBERRECOMMENDRUNID = cerma.MEMBERRECOMMENDRUNID"
						+ " and cerma.productmnemoniccd in ('" + ProdType + "')" + " group by cerma.PRODUCTMNEMONICCD"
						+ " order by cerma.PRODUCTMNEMONICCD";

				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBconnection = DriverManager.getConnection(
						"jdbc:oracle:thin:@" + GlobalVariables.g_strODBQAConnectionString,
						GlobalVariables.g_strODSQAUserID, GlobalVariables.g_strODSQAPwd);
				statement = DBconnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				s_objlog4j.info("Connected to DB server and requesting data..");
				rs = statement.executeQuery(query);

				if (rs != null && rs.getFetchSize() > 0) {
					while (rs.next()) {
						if (rs.getInt("Total") == count) {

							bStatus = true;
							s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription + " is validated for - " + ProdType + ":-"
											+ rs.getInt("Total"));
						} else {
							s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription + " is not validated");
						}
					}
				} else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is not validated");
				}
			} catch (SQLException e) {
				System.out.println("Connection Failed!");
				e.printStackTrace();
			}
			if (DBconnection != null) {
				try {
					DBconnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CE_ValidateScoreDetailsFrmODB method validates score details from DB
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_ValidateScoreDetailsFrmODB(String ComplianceType) {
		Statement statement = null;
		ResultSet rs = null;
		java.sql.Connection DBconnection = null;
		// String strRunID = "1579";
		boolean bStatus = false;
		try {
			s_objlog4j.info("Initiating Oracle JDBC Connection..");
			try {
				String query = "select * from CAR.MEMBERRECCOMPLIANCE where MEMBERID in (100806786) and MEMBERRECCOMPLIANCESKEY in"
						+ " (SELECT MEMBERRECCOMPLIANCESKEY FROM CAR.CARRUNSCHEDULEOUTPUTXREF WHERE RUNSCHEDULEID="
						+ GlobalVariables.strRunID + ") AND STATECOMPONENTID IN(281)";

				/*
				 * String query =
				 * "select * from CAR.MEMBERRECCOMPLIANCE where MEMBERID in (100806786) and MEMBERRECCOMPLIANCESKEY in"
				 * +
				 * " (SELECT MEMBERRECCOMPLIANCESKEY FROM CAR.CARRUNSCHEDULEOUTPUTXREF WHERE RUNSCHEDULEID="
				 * + strRunID + ") AND STATECOMPONENTID IN(281)";
				 */

				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBconnection = DriverManager.getConnection(
						"jdbc:oracle:thin:@" + GlobalVariables.g_strODBQAConnectionString,
						GlobalVariables.g_strODSQAUserID, GlobalVariables.g_strODSQAPwd);

				statement = DBconnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				s_objlog4j.info("Connected to DB server and requesting data..");
				rs = statement.executeQuery(query);

				if (rs != null && rs.getFetchSize() > 0) {
					while (rs.next() && bStatus == false) {

						if (ComplianceType.equalsIgnoreCase("NonCompliance")) {
							if (rs.getString("COMPLIANCEFLG").equalsIgnoreCase("N")
									&& rs.getString("COMPLIANCEDT").isEmpty()
									&& rs.getString("DENOMINATORFLG").equalsIgnoreCase("Y")) {

								bStatus = true;
								s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
										GlobalVariables.g_strKeywordDescription + " is validated for - "
												+ rs.getString("COMPLIANCEFLG") + "," + "COMPLIANCEDT - "
												+ rs.getString("COMPLIANCEDT") + "," + "DENOMINATORFLG -"
												+ rs.getString("DENOMINATORFLG"));

							} else {

								s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
										GlobalVariables.g_strKeywordDescription + " No data found");
							}

						} else {

							if (rs.getString("COMPLIANCEFLG").equalsIgnoreCase("Y")
									&& rs.getString("COMPLIANCEDT").contains("")
									&& rs.getString("DENOMINATORFLG").equalsIgnoreCase("Y")) {

								bStatus = true;
								s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
										GlobalVariables.g_strKeywordDescription + " is validated for "
												+ rs.getString("COMPLIANCEFLG") + "," + "COMPLIANCEDT - "
												+ rs.getString("COMPLIANCEDT") + "," + "DENOMINATORFLG -"
												+ rs.getString("DENOMINATORFLG"));
							} else {

								s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
										GlobalVariables.g_strKeywordDescription + " is not validated");
							}
						}

					}
				} else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " No data found");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is not validated");
			}
			if (DBconnection != null) {
				try {
					DBconnection.close();
				} catch (SQLException e) {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is not validated");
				}
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
		}
		return bStatus;
	}

	/**
	 * ResizePopUP method is to resise the pop up
	 * 
	 * @param offset
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */

	public boolean ResizePopUP(String offset) {

		boolean bStatus = false;
		int intOffset = Integer.parseInt(offset);

		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			bStatus = waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			WebElement resizeable = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			if (bStatus) {
				Actions actions = new Actions(driver);
				Action resize = actions.clickAndHold(resizeable).moveByOffset(intOffset, intOffset).release().build();
				resize.perform();
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + "Resizing popup to offset X:" + intOffset + ", Y:"
								+ intOffset);
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + "Pop up not found");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
		}
		return bStatus;
	}

	/**
	 * ScrollToElementAndClick method scrolls to down till the element Display
	 * and click the element
	 * 
	 * @param m_ElementXpath
	 *            This describes the xpath of element
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep Kumar Swain
	 */
	public boolean ScrollToElementAndClick(String m_ElementXpath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			WebElement element = driver.findElement(By.xpath(m_ElementXpath));
			// ((JavascriptExecutor) driver).scrollToExact(m_ElementXpath);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			element.click();
			bStatus = true;
			Thread.sleep(1000);
			s_childExtentTest.log(LogStatus.INFO, "ScrollToElementAndClick", GlobalVariables.g_strStepDescription);
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "ScrollToElementAndClick", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * verifyDisabledState method is to verify if any webelement is in disabled
	 * state
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean verifyDisabledState() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement CheckBoxOrBtn = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			if (CheckBoxOrBtn.getAttribute("disabled") != null) {
				if (CheckBoxOrBtn.getAttribute("disabled").contains("true")
						|| CheckBoxOrBtn.getAttribute("disabled").contains("disabled")) {
					s_childExtentTest.log(LogStatus.PASS, "verifyDisabledState",
							"CheckBox/Button is in Disabled state!!");
					bStatus = true;
					GlobalVariables.g_captureScreenShot = true;
				}
			} else {
				// bStatus = true;
				s_childExtentTest.log(LogStatus.ERROR, "verifyDisabledState", GlobalVariables.g_strStepDescription);
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "verifyDisabledState", "Error in method");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CE_PublishTextFrmElement method is to publish text from a WebElement
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_PublishTextFrmElement() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + element.getText() + "is validated");
			bStatus = true;

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CE_ValidateTextFrmExl method is to validate text from Excel
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean CE_ValidateTextFrmExl(String strSheetName) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		Recordset recordset = null;

		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			String strQuery = "Select * from " + strSheetName;
			recordset = gUtilLib.readFromExcel(GlobalVariables.g_strTestDataFilePath, strQuery);

			List<WebElement> list = driver.findElements(By.xpath(strExcelInfo[1]));
			for (WebElement webElement : list) {

				webElement.click();
				bStatus = false;
				while (recordset.next() && bStatus == false) {
					if (webElement.getText().contains(recordset.getField("SUBOPTION_DESCRIPTION"))) {

						s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
								GlobalVariables.g_strKeywordDescription + " is validated for :" + webElement.getText()
										+ " at Row- " + recordset.getField("SUBOPTION"));
						bStatus = true;
					}
				}
			}
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
		}
		return bStatus;
	}
	
	public boolean click10Times() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			int i;
			for(i=1;i<=10;i++) {
				buttonOrLink.click();
				Thread.sleep(2000);
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			// e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	public boolean ValidateSelectedDefaultValueByExpected(String Item) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement dropdown = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			Select select = new Select(dropdown);
			WebElement getSelectedValue=select.getFirstSelectedOption();
			String getSelectedValueText=getSelectedValue.getText();
			if(getSelectedValueText.equalsIgnoreCase(Item)){
			       bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is selected");
			}} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not selected");
			e.printStackTrace();
		}
		return bStatus;
	}
	

	/**
	 * ClickOKOnAlertIfExist method checks on object if it is present
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep kumar Swain
	 */
	public boolean acceptAlertIfExist() {
		boolean bStatus = false;
		try {
			Thread.sleep(2000);
			if (isAlertPresent()) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			// e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * sendReceiveRestRequest method can send GET/POST/DELETE/UPDATE rest
	 * request and validates the response
	 * 
	 * @param resourcePath
	 *            This describes End point URL
	 * @param request
	 *            This describes Data
	 * @param access_token
	 *            describes Authorization Key
	 * @param header
	 *            This describes Request Data
	 * @return Boolean value True/False based on success of this function
	 * @author Saurav
	 */

	public boolean sendPostRestRequest(String resourcePath, String request, String access_token, String header) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = null;
		String json;

		try {

			
			System.setProperty("http.proxyHost", "");

			System.setProperty("http.proxyPort", "");

			// Set Base URI
			// setBaseURI("REST");

			// Construct request parameters

			HashMap<String, String> requestParams = new HashMap<String, String>();

			if (!request.startsWith("{"))
				requestParams = constructRequestParam(request);

			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();

			// Construct response specification
			// responseSpecification = new
			// ResponseSpecBuilder().expectStatusCode(200).build();

			if (access_token.equalsIgnoreCase("YES")) {

				// Construct request specification

				headers = constructHeader(header);
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .addHeaders(headers).build();
				 */

				if (request.startsWith("{")) {
					json = given().headers(headers).body(request).post(resourcePath).asString();
				} else
					json = given().headers(headers).queryParameters(requestParams).post(resourcePath).asString();

			} else {
				// Construct request specification
				// headers = constructRequestParam(header);
				/*
				 * requestSpecification = new
				 * RequestSpecBuilder().addParams(requestParams).setContentType(
				 * "application/json") .build();
				 */
				json = given().queryParameters(requestParams).post(resourcePath).asString();
			}

			/**
			 * Send Rest request and get response as json string
			 */

			// String json =
			// given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();
			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.PASS, "sendReceiveRestRequest", json);

			//requestSpecification = null;
			//responseSpecification = null;
			bStatus = true;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * sendGetOnlyRestRequest method can send GET REST request
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Saurav Singh Sikarwar
	 */
	public boolean sendOnlyGetRestRequest(String resourcePath) {
		boolean bStatus = false;
		HashMap<String, String> headers = null;
		String json;

		try {
			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();

			json = given().baseUri(resourcePath).get().asString();
			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			s_childExtentTest.log(LogStatus.PASS, "sendOnlyGetRestRequest", json);
			bStatus = true;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendOnlyGetRestRequest", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendOnlyGetRestRequest", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}

	public boolean sendGetRestRequest(String resourcePath, String response) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = null;
		String json;

		try {
			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();
			if (!response.isEmpty()) {
				responseParams = constructResponseParam(response);
			}

			json = given().baseUri(resourcePath).get().asString();

			// String json =
			// given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();
			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.INFO, "sendReceiveRestRequest", json);

			/**
			 * Validate the response and log into report
			 */
			for (String key : responseParams.keySet()) {

				boolean bFlag = false;
				String strExpected[] = jsPath.get(key).toString().split(",");

				String expected = "";

				String actual = responseParams.get(key);
				for (int i = 0; i < strExpected.length; i++) {
					expected = strExpected[i];
					expected = expected.replace("[", "").trim();
					expected = expected.replace("]", "").trim();
					if (expected.equalsIgnoreCase(actual)) {
						s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :",
								"<p>Expected : " + expected + "<br> Actual : " + actual + "</p>");
						bStatus = true;
						bFlag = true;
						break;
					}
				}
				if (bFlag == false) {
					s_childExtentTest.log(LogStatus.FAIL, "Expectation Fail :", "<p>Expected : " + expected
							+ "<br> Actual : " + "<b style=\"color:red;\">" + actual + "</b></p>");
					bStatus = false;
				}
			}

			//requestSpecification = null;
		//	responseSpecification = null;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}
	/**
	 * getDate method returns result set
	 * 
	 * @return ResultSet based on success of this function
	 */
	/*
	 * public void getDate(String Date, String locator)
	 * 
	 * { List<WebElement> allDates=driver.findElements(By.xpath(locator));
	 * 
	 * for(WebElement ele:allDates) { ele.click(); String element=ele.getText();
	 * 
	 * if(Date.equalsIgnoreCase(element)) { ele.click(); break; }
	 * 
	 * } }
	 */
	/**
	 * Delete method returns result set
	 * 
	 * @return ResultSet based on success of this function
	 */
	/*
	 * public boolean Delete(String str_xpath) throws Exception { boolean
	 * bStatus = false; try {
	 * 
	 * WebElement webElement = driver.findElement(By.xpath(str_xpath));
	 * 
	 * 
	 * //Actions action = new Actions(driver); webElement.sendKeys(Keys.DELETE);
	 * //action.sendKeys(webElement).build().perform(); Thread.sleep(1000);
	 * bStatus = true; s_childExtentTest.log(LogStatus.INFO, "DELETE",
	 * GlobalVariables.g_strStepDescription); } catch (Exception e) {
	 * s_childExtentTest.log(LogStatus.FAIL, "DELETE",
	 * GlobalVariables.g_strStepDescription); e.printStackTrace(); } return
	 * bStatus; }
	 */
	/**
	 * VerifyGraphComponents method returns result set
	 * 
	 * @return ResultSet based on success of this function
	 */

	/*
	 * public boolean VerifyGraphComponents( String strDateLocator, String
	 * strValueLocator, String strEnterDate, String strEnterGraphValue, String
	 * strInputDateValue, String strAddButton) throws Exception { String
	 * strActualResult = ""; boolean bStatus = false;
	 * 
	 * try {
	 * 
	 * String[] strInputs = strInputDateValue.split(":");
	 * System.out.println("inputs button = " + strInputs[0] + " length = " +
	 * strInputs[1]);
	 * 
	 * waitForPresenceAndVisibilityOfElement("EVALUATEXPATH", strEnterDate);
	 * MedWait(); WebElement dateBox = createWebElement("EVALUATEXPATH",
	 * strEnterDate);
	 * 
	 * dateBox.click(); // dateBox.clear(); dateBox.sendKeys(strInputs[0]);
	 * 
	 * 
	 * MedWait();
	 * 
	 * WebElement valueBox = createWebElement("EVALUATEXPATH",
	 * strEnterGraphValue);
	 * 
	 * valueBox.click(); valueBox.clear(); valueBox.sendKeys(strInputs[1]);
	 * 
	 * waitForPresenceAndVisibilityOfElement("EVALUATEXPATH", strAddButton);
	 * MedWait(); WebElement AddButton = createWebElement("EVALUATEXPATH",
	 * strEnterGraphValue); AddButton.click();
	 * driver.findElement(By.xpath(strAddButton)).click();
	 * waitForPresenceAndVisibilityOfElement("EVALUATEXPATH", strDateLocator);
	 * int length = strDateLocator.length(); for(int i=1; i<length-1; i++){
	 * strDateLocator = strDateLocator.replace("@value", i+""); strValueLocator
	 * = strValueLocator.replace("@value", i+""); String strExpectedDateResult =
	 * driver.findElement(By.id(strDateLocator)).getText().trim(); String
	 * strExpectedValueResult =
	 * driver.findElement(By.id(strValueLocator)).getText().trim(); if
	 * (strInputs[0].equals(strExpectedDateResult)) {
	 * 
	 * bStatus = true; s_childExtentTest.log(LogStatus.INFO, "Exists",
	 * GlobalVariables.g_strStepDescription); } else { bStatus = false;
	 * s_childExtentTest.log(LogStatus.FAIL, "Exists",
	 * GlobalVariables.g_strStepDescription); } } }
	 * 
	 * catch (Exception e) { s_childExtentTest.log(LogStatus.FAIL, "Exists",
	 * GlobalVariables.g_strStepDescription); e.printStackTrace(); } return
	 * bStatus;
	 * 
	 * }
	 */
	/**
	 * VerifyGraph method verify tracer graph value and date
	 * 
	 * @param strDateLocator
	 *            xpath of tracker graph date
	 * @param strBarLocator
	 *            xpath of graph bar
	 * @param strInputDateValue
	 *            input graph date and value
	 * @return ResultSet based on success of this function
	 */
	public boolean VerifyGraph(String strDateLocator, String strBarLocator, String strInputDateValue) throws Exception {
		String strActualResult = "";
		boolean bStatus = false;

		try {

			String[] strInputs = strInputDateValue.split(":");
			System.out.println("inputs button = " + strInputs[0] + " length = " + strInputs[1]);
			MedWait();
			String strActualDate = strInputs[0];
			String strActualValue = strInputs[1];
			String strDateLocatorXpath = strDateLocator.replace("@value", "");

			List<WebElement> dateLocatorCount = driver.findElements(By.xpath(strDateLocatorXpath));

			int count = 0;
			for (int i = 0; i < dateLocatorCount.size(); i++) {
				count++;
				System.out.println("count = " + count);
				strDateLocatorXpath = strDateLocator.replace("@value", count + "");

				String strBarLocatorXpath = strBarLocator.replace("@value", count + "");
				strBarLocatorXpath = strBarLocatorXpath.replace("$data", strActualValue);

				List<WebElement> valuesElement = driver.findElements(By.xpath(strBarLocatorXpath));
				List<WebElement> datesElement = driver.findElements(By.xpath(strDateLocatorXpath));

				if (valuesElement.size() != 0) {
					for (int k = 0; k < valuesElement.size(); k++) {

						// System.out.println("valuesElement =
						// "+valuesElement.size()+ valuesElement.get(k) );

						String strExpectedValueResult = valuesElement.get(k).getAttribute("data-value").trim();

						String strExpectedDateResult = datesElement.get(k).getText().trim();

						strExpectedDateResult = strExpectedDateResult.replace("00:00", "").trim();
						System.out.println("expected1  = " + strExpectedDateResult);

						System.out.println("expected2  = " + strExpectedValueResult);

						if (strActualDate.equals(strExpectedDateResult)
								&& strActualValue.equals(strExpectedValueResult)) {

							bStatus = true;
							s_childExtentTest.log(LogStatus.INFO, "Exists", GlobalVariables.g_strStepDescription);
							s_childExtentTest.log(LogStatus.INFO, "Graph Date and Value", strInputDateValue);
							System.out.println("if true strExpectedDateResult " + strExpectedDateResult
									+ " strExpectedValueResult " + strExpectedValueResult);
						}
					}
				}
			}
			if (bStatus != true) {
				bStatus = false;
				s_childExtentTest.log(LogStatus.FAIL, "Exists", GlobalVariables.g_strStepDescription);
				System.out.println("if false strExpectedDateResult " + " strExpectedValueResult ");
			}

		}

		catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, "Exists", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}
		return bStatus;

	}

	/**
	 * VerifyMouseOverValue methods validated tracker graph mouseovervalue
	 * 
	 * @param mouseover
	 *            value
	 * @return Boolean value True/False based on success of this function
	 * @author Saurav
	 */
	public boolean VerifyMouseOverValue(String strInputDateValue) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		String[] strInputs = strInputDateValue.split(":");

		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			// bStatus=waitForPresenceAndVisibilityOfElement(strExcelInfo[0],strExcelInfo[1]);
			bStatus = waitForPresenceOfElement(strExcelInfo[0], strExcelInfo[1]);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * Validate sort in ascending order
	 * 
	 * @param m_locatorValue
	 *            xpath of dropwon
	 * @return Boolean value True/False based on success of this function
	 * @author Amarnath V
	 */

	public boolean validateSorting(String m_locatorValue) {
		boolean sorted = true;
		try {
			List<WebElement> webElements = driver.findElements(By.xpath(m_locatorValue));
			for (int i = 1; i < webElements.size(); i++) {
				String str1 = webElements.get(i - 1).getText();
				String str2 = webElements.get(i).getText();

				if (str1.compareTo(str2) > 0) {
					sorted = false;
				}
			}

			if (sorted) {
				GlobalVariables.g_captureScreenShot = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			}
		} catch (Exception e) {
			sorted = false;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");

			e.printStackTrace();
		}
		return sorted;
	}

	/**
	 * ValidateCount verify page content base on given parameter
	 * 
	 * @param Expected
	 *            is number of count
	 * @return Boolean value True/False based on success of this function
	 * @author pswain Amarnath V & Nains Jain
	 */
	public boolean ValidateCount(String Expected) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);

			List<WebElement> buttonOrLink = createWebElements(strExcelInfo[0], strExcelInfo[1]);
			int Actual = buttonOrLink.size();
			int Ex = (int) Integer.parseInt(Expected);
			if (Actual == Ex) {
				bStatus = true;

				GlobalVariables.g_captureScreenShot = true;

				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateDataFrmSQL compares the data present in DB column and the text
	 * present in UI request takes a hash map e.g
	 * query:
	 * 
	 * @return Boolean value True/False based on success of this function
	 *         Sudhanshu & Dinesh
	 */

	public Boolean ValidateDataFrmSQL(String request) {

		boolean bStatus = false;
		java.sql.Connection DBconnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			HashMap<String, String> requestParam = CE_constructRequestParam(request);
			String connectionUrl = GlobalVariables.g_SQLConnectionURL;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			DBconnection = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected to DB server.");

			stmt = DBconnection.createStatement();
			// UIDBSELECT to be used to validate the content in DB table is
			// present in UI
			if (requestParam.get("Type").contains("UIDBSELECT")) {
				rs = stmt.executeQuery(requestParam.get("query"));
				List<WebElement> list = driver.findElements(By.xpath(requestParam.get("Xpath")));

				while (rs.next() && rs != null) {
					bStatus = false;
					for (WebElement webElement : list) {

						if (bStatus == false) {
							String UIText = webElement.getAttribute("innerText");

							if (UIText.contains(rs.getString(requestParam.get("ColName")))) {

								bStatus = true;
								System.out.println("Match Found at DB- " + rs.getString(requestParam.get("ColName"))
										+ " , text at UI - " + UIText);
								s_childExtentTest.log(LogStatus.PASS, "ValidateDataFrmSQL", "Match Found at DB- "
										+ rs.getString(requestParam.get("ColName")) + " , text at UI - " + UIText);
							}
							// else{
							//
							// s_childExtentTest.log(LogStatus.INFO,
							// "ValidateDataFrmSQL",
							// "NO match Found !!");
							// }
						}
					}
				}
			}
			// DBSELECT to be used to execute the query and display the specific
			// column value
			else if (requestParam.get("Type").contains("DBSELECT")) {
				rs = stmt.executeQuery(requestParam.get("query"));

				String Exp = requestParam.get("ExpectedVal");

				while (rs.next() && rs != null) {

					if (Exp.contains("_")) {
						Exp = Exp.replace("_", ":");
					}

					if (requestParam.get("ExpectedVal").contains(rs.getString(requestParam.get("ColName")))
							|| rs.getString(requestParam.get("ColName")).contains(Exp)) {
						bStatus = true;
						System.out.println("Match Found at DB- " + rs.getString(requestParam.get("ColName")));
						s_childExtentTest.log(LogStatus.PASS, "ValidateDataFrmSQL",
								"Match Found at DB- " + rs.getString(requestParam.get("ColName")));
						break;
					} else {

						s_childExtentTest.log(LogStatus.FAIL, "ValidateDataFrmSQL", "NO match Found !!");
					}
				}
			}
			// DBUPDATE to be used to execute the update query
			else if (requestParam.get("Type").contains("DBUPDATE")) {
				int rs1 = stmt.executeUpdate(requestParam.get("query"));
				if (rs1 > 0) {
					bStatus = true;
					System.out.println("Executed Update for - " + requestParam.get("query"));
					s_childExtentTest.log(LogStatus.PASS, "ValidateDataFrmSQL",
							"Executed Update for - " + requestParam.get("query"));
				}
			}
			// DBEXECUTE to be used to execute a query
			else if (requestParam.get("Type").contains("DBEXECUTE")) {
				stmt.executeQuery(requestParam.get("query"));
				bStatus = true;
				System.out.println("Query Executed..");
				s_childExtentTest.log(LogStatus.PASS, "ValidateDataFrmSQL",
						"Query Executed.." + requestParam.get("query"));
			}

			// DBBEGIN/ROLLBACK to be used to execute without resultset

			else if (requestParam.get("Type").contains("DBBEGIN/ROLLBACK")) {

				stmt.execute(requestParam.get("query"));

				bStatus = true;

				System.out.println("DB Transaction..");

				s_childExtentTest.log(LogStatus.PASS, "ValidateDataFrmSQL",
						"DB Transaction.." + requestParam.get("query"));

			}

			// DBDISPLAY to be used to execute the query and display the result
			// from DB
			else if (requestParam.get("Type").contains("DBDISPLAY")) {
				rs = stmt.executeQuery(requestParam.get("query"));

				while (rs.next() && rs != null) {
					String ResultRecieved = rs.getString(requestParam.get("ColName"));
					bStatus = true;
					System.out.println("Result in DB: " + ResultRecieved);
					s_childExtentTest.log(LogStatus.PASS, "Result from DB:" + ResultRecieved);
				}
			}

			// DBNORECORDS to be used to execute the query which returns no
			// records
			else if (requestParam.get("Type").contains("DBNORECORDS")) {
				rs = stmt.executeQuery(requestParam.get("query"));
				boolean hasRows = false;

				while (rs.next()) {
					hasRows = true;
				}
				if (!hasRows) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
							"No Records to Display");
					bStatus = true;
				}
			} else if (requestParam.get("Type").contains("DBSPLIT")) {
				rs = stmt.executeQuery(requestParam.get("query"));
				while (rs.next() && rs != null) {
					String ResultRecieved = rs.getString(requestParam.get("ColName"));
					// String var=
					// rs.getString(requestParam.get("IndexOfString"));
					int val = Integer.parseInt(requestParam.get("PositionToSplit"));
					String ab[] = ResultRecieved.split(":");
					bStatus = true;
					System.out.println("Result in DB: " + ab[val]);
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
							"Prefix from DB: " + ab[val]);
				}
			}
			bStatus = true;

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, "ValidateDataFrmSQL",
					GlobalVariables.g_strStepDescription + "NO match Found !!");
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
					s_childExtentTest.log(LogStatus.FAIL, "ValidateDataFrmSQL", GlobalVariables.g_strStepDescription);
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
					s_childExtentTest.log(LogStatus.FAIL, "ValidateDataFrmSQL", GlobalVariables.g_strStepDescription);
				}
		}
		return bStatus;
	}

	/**
	 * CountTableEntries will count the number of entries in column and whether
	 * it 20 and the Next button is enabled
	 * 
	 * @param XpathTableEntry
	 *            xpath of list grid table
	 * @param XpathNextButton
	 *            xpath of next button
	 * @author Dinesh
	 */

	public boolean CountTableEntries(String XpathTableEntry, String XpathNextButton) {
		boolean bStatus = false;
		// String
		
		try {
			List<WebElement> tableEntries = driver.findElements(By.xpath(XpathTableEntry));
			int Rowcount = tableEntries.size();
			Boolean NextButtonPresence = driver.findElement(By.xpath(XpathNextButton)).isEnabled();
			if (Rowcount == 20 && NextButtonPresence.equals(true)) {
				bStatus = true;
				System.out.println("PASS" + Rowcount);
				s_childExtentTest.log(LogStatus.INFO, "Number of rows in the table:" + Rowcount);
			}
		} catch (Exception e) {
		}
		return bStatus;

	}

	/**
	 * waitTillElementPresent method waits for an element presence and
	 * visibility
	 * 
	 * @return Boolean value True/False
	 * @author Sarath Gorantla
	 */
	public boolean waitTillElementPresent() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		WebDriverWait wait = new WebDriverWait(driver, 300);
		List<WebElement> e;

		strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
				GlobalVariables.g_strLogicalName);
		String value = strExcelInfo[1];
		// waitForPresenceAndVisibilityOfElement(strExcelInfo[0],
		// strExcelInfo[1]);
		// waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
		// WebElement buttonOrLink = createWebElement(strExcelInfo[0],
		// strExcelInfo[1]);

		// s_childExtentTest.log(strExcelInfo[1],strExcelInfo[1],strExcelInfo[1]);

		try {
			switch (typeOfLocator.valueOf(strExcelInfo[0])) {
			case EVALUATEXPATH:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(strExcelInfo[1])));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(strExcelInfo[1])));
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
				e = driver.findElements(By.xpath(strExcelInfo[1]));
				if (e.size() == 1) {
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				break;
			case EVALUATECSSSELECTOR:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(strExcelInfo[1])));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(strExcelInfo[1])));
				// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
				e = driver.findElements(By.cssSelector(strExcelInfo[1]));
				if (e.size() == 1) {
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				break;
			case EVALUATEID:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(strExcelInfo[1])));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(strExcelInfo[1])));
				// wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
				e = driver.findElements(By.id(strExcelInfo[1]));
				if (e.size() == 1) {
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				break;
			case EVALUATELINKTEXT:
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(strExcelInfo[1])));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(strExcelInfo[1])));
				// wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
				e = driver.findElements(By.linkText(strExcelInfo[1]));
				if (e.size() == 1) {
					bStatus = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
				}
				break;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
		} finally {
			return bStatus;
		}

	}

	/**
	 */
	public static HashMap<String, String> MAHP_constructRequestParam(String request) {
		String[] reqParam = request.split(";");
		HashMap<String, String> requestParams = new HashMap<String, String>();

		for (String param : reqParam) {
			String[] keyVal = param.split(":");
			requestParams.put(keyVal[0], keyVal[1]);
		}
		return requestParams;
	}

	/**
	 * ValidateColmnDataFrmODS method takes the HashmapObject in string format ,
	 * triggers query to match the column values
	 * 
	 * @param request
	 *            This is a String value containing key value pair in format -
	 *            k:v separated with colon
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu C
	 */
	public boolean ValidateColmnDataFrmODS(String request) throws ClassNotFoundException {

		HashMap<String, String> requestParam = MAHP_constructRequestParam(request);
		int intMapSize = requestParam.size() - 2;
		int intComputedSize = intMapSize / 2;
		String arr[] = new String[intComputedSize];

		Statement statement = null;
		ResultSet rs = null;
		Boolean rs1 = null;
		boolean rs2;
		java.sql.Connection DBconnection = null;
		boolean bStatus = false;
		try {
			// logger.info("Initiating Oracle JDBC Connection..");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBconnection = DriverManager.getConnection(
						"jdbc:oracle:thin:@" + GlobalVariables.g_strODBQAConnectionString,
						GlobalVariables.g_strODSQAUserID, GlobalVariables.g_strODSQAPwd);
				statement = DBconnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				if (requestParam.containsKey("query1") && requestParam.get("Type").contains("SELECT")) {
					rs = statement.executeQuery(requestParam.get("query"));

					if (rs != null && rs.next()) {
						do {
							for (int i = 0; i <= (intComputedSize - 1); i++) {
								arr[i] = rs.getString(requestParam.get("col" + i));
								if (arr[i].equalsIgnoreCase(requestParam.get("val" + i))) {

									bStatus = true;
									System.out.println("Validated value from DB :-" + arr[i].toString()
											+ requestParam.get("type"));
									s_childExtentTest.log(LogStatus.INFO, "CE_ValidateColmnDataFrmODB",
											"Validated value from DB :-" + arr[i].toString() + " for type :-"
													+ requestParam.get("type"));
								}
							}
						} while (rs.next() && bStatus == false);
					} else {
						s_childExtentTest.log(LogStatus.ERROR, "CE_ValidateColmnDataFrmODB", "No Data Found!!");
					}

				}
				if (requestParam.get("Type").contains("UPDATE")) {

					rs2 = statement.execute(requestParam.get("query"));
					s_childExtentTest.log(LogStatus.INFO, "CE_ValidateColmnDataFrmODB", "UPDATE EXECUTED..");
					bStatus = true;
				}

				if (requestParam.get("Type").contains("ROLLBCK")) {
					rs2 = statement.execute(requestParam.get("query"));
					s_childExtentTest.log(LogStatus.INFO, "CE_ValidateColmnDataFrmODB", "ROLLBACK FIRED!!");
					bStatus = true;
				}

				else if (requestParam.get("Type").contains("DBDISPLAY")) {
					rs = statement.executeQuery(requestParam.get("query"));

					while (rs.next() && rs != null) {
						String ResultRecieved = rs.getString(requestParam.get("ColName"));
						bStatus = true;
						System.out.println("Result in DB: " + ResultRecieved);
						s_childExtentTest.log(LogStatus.INFO, "Query Executed:" + requestParam.get("query"));
						s_childExtentTest.log(LogStatus.INFO, "Result from DB:" + ResultRecieved);
						bStatus = true;
					}
				}

			} catch (SQLException e) {
				s_childExtentTest.log(LogStatus.ERROR, "CE_ValidateColmnDataFrmODB", "Connection Failed!");
				e.printStackTrace();
				s_childExtentTest.log(LogStatus.ERROR, "CE_ValidateColmnDataFrmODB",
						GlobalVariables.g_strKeywordDescription);

				// s_objlog4j.info(e.getMessage());
			}
			if (DBconnection != null) {
				try {
					DBconnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			s_childExtentTest.log(LogStatus.ERROR, "CE_ValidateColmnDataFrmODB",
					GlobalVariables.g_strKeywordDescription);
		}
		return bStatus;

	}

	/*
	 * public boolean openBrowser(String browserName){
	 * 
	 * boolean bStatus = false; if(driver != null) driver.close();
	 * openDriver(browserName); if(GlobalVariables.driver != null) this.driver =
	 * GlobalVariables.driver; bStatus = true; return bStatus;
	 * 
	 * }
	 */
	/**
	 * getTheValue displays the text value/Css value/tagname or attibute value
	 * request takes a hashmap depending on the requirement
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Dinesh
	 */

	public boolean getTheValue(String request) {
		boolean bStatus = false;
		try {
			HashMap<String, String> requestParam = CE_constructRequestParam(request);
			if (requestParam.get("Type").contains("getText")) {
				String ValuePresent = driver.findElement(By.xpath(requestParam.get("Xpath"))).getText();
				System.out.println(ValuePresent);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is Present");
			}
			if (requestParam.get("Type").contains("getAttribute")) {
				WebElement Value = driver.findElement(By.xpath((requestParam.get("Xpath"))));
				String ValuePresent = Value.getAttribute(requestParam.get("Attribute"));
				System.out.println(ValuePresent);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is Present");
			}
			if (requestParam.get("Type").contains("getTagName")) {
				String ValuePresent = driver.findElement(By.xpath((requestParam.get("Xpath")))).getTagName();
				System.out.println(ValuePresent);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is Present");
			}
			if (requestParam.get("Type").contains("getCssValue")) {
				WebElement Value = driver.findElement(By.xpath(requestParam.get("Xpath")));
				String ValuePresent = Value.getCssValue(requestParam.get("Attribute"));
				System.out.println(ValuePresent);
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is Present");
			}
			if (requestParam.get("Type").contains("isSelected")) {
				boolean ValuePresent = driver.findElement(By.xpath(requestParam.get("Xpath"))).isSelected();
				System.out.println(ValuePresent + "Element is Selected");
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is selected");
			}
			if (requestParam.get("Type").contains("isDisplayed")) {
				boolean ValuePresent = driver.findElement(By.xpath(requestParam.get("Xpath"))).isDisplayed();
				System.out.println(ValuePresent + "Element is Displayed");
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is displayed");
			}
			if (requestParam.get("Type").contains("isEnabled")) {
				boolean ValuePresent = driver.findElement(By.xpath(requestParam.get("Xpath"))).isEnabled();
				System.out.println(ValuePresent + "Element is Enabled");
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is enabled");
			}
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not Present");
			e.printStackTrace();
		}
		return bStatus;

	}

	/**
	 * VerifyGraphWithHistoryTable displays the text value/Css value/tagname or
	 * attibute value request takes a hashmap depending on the requirement
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Dinesh
	 */
	public boolean VerifyGraphWithHistoryTable(String XpathGraphFooterValues, String XpathTableEntryValues) {
		// String XpathGraphFooterValues=
		// "//div[@id='ctl00_Content_lstTrackers_ctl00_HE_ctl00_ctl00_ctl00_barGraphValues']/div/span";
		// String XpathTableEntryValues=
		// "//div[@id='updateTrackerContainer']/table/tbody/tr/th";

		List<WebElement> GraphFooterEntries = driver.findElements(By.xpath(XpathGraphFooterValues));
		List<WebElement> TableEntries = driver.findElements(By.xpath(XpathTableEntryValues));
		String XpathFirstColumInGraphColumn = "//div[@id='ctl00_Content_lstTrackers_ctl00_HE_ctl00_ctl00_ctl00_barGraphValues']/div[1]/span";
		String finalXpathGraphFooter = " ";
		String XpathNextbutton = "//a[@id='btnTrackerNext']";
		// String finalXpathTableEntries=" ";
		int TableRowCount = 0;
		boolean bStatus = false;
		boolean nStatus;
		try {
			bStatus = driver.findElement(By.xpath(XpathFirstColumInGraphColumn)).isDisplayed();
			if (bStatus) {
				for (int i = 1; i <= GraphFooterEntries.size(); i++) {
					// String GraphEntryValues=
					// GraphFooterEntries.get(i).getText();
					String firstPartXpathGraphFooter = "//div[@id='ctl00_Content_lstTrackers_ctl00_HE_ctl00_ctl00_ctl00_barGraphValues']/div[";
					String lastPartXpathGraphFooter = "]/span";
					finalXpathGraphFooter = firstPartXpathGraphFooter + i + lastPartXpathGraphFooter;
					String GraphEntryValues = driver.findElement(By.xpath(finalXpathGraphFooter)).getText();
					System.out.println(GraphEntryValues);
					TableRowCount = TableEntries.size();
					if (TableRowCount == 10) {
						// Assert.assertEquals(10, TableRowCount);
						driver.findElement(By.xpath(XpathNextbutton)).isEnabled();
						;
						s_childExtentTest.log(LogStatus.INFO, "VerifyGraphWithHistoryTable: Row count in history table",
								"<br> Number of entries in Table is 10");
						System.out.println(TableRowCount);
					}
					for (int j = 1; j <= TableEntries.size(); j++) {
						// String
						// firstPartXpathTableEntries="//div[@id='updateTrackerContainer']/table/tbody/tr[";
						// String lastPartXpathTableEntries="]/th/span";

						String TableEntryValues = TableEntries.get(j).getText();
						// finalXpathTableEntries= firstPartXpathTableEntries+j+
						// lastPartXpathTableEntries;
						// String TableEntryValues=
						// driver.findElement(By.xpath(finalXpathTableEntries)).getText();
						System.out.println("----------------");
						System.out.println(TableEntryValues);

						if (GraphEntryValues.equals(TableEntryValues)) {
							// Assert.assertEquals(true, true);
							s_childExtentTest.log(LogStatus.INFO, "VerifyGraphWithHistoryTable:",
									"<br> Table entries present in the graph");
						}

					}
				}
			}
		} catch (Exception e) {
		}
		return bStatus;

	}

	/**
	 * MAH_ValidateElementColor method validates the element color using CSS
	 * value
	 * 
	 * @param m_strCSSValue
	 *            This describes the element CSS value
	 * @param m_strExpColor
	 *            This describes the element expected color
	 * @return Boolean value True/False based on success of this function
	 */
	public boolean MAH_ValidateElementColor(String m_strCSSValue, String m_strExpColor) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			String color = element.getCssValue(m_strCSSValue);
			System.out.println("Color in RGB=" + color);
			color = color.substring(color.indexOf("(") + 1, color.indexOf(")"));
			String[] hexValue = color.split(",");

			int hexValue1 = Integer.parseInt(hexValue[0].trim());
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);

			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
			System.out.println("Actual color=" + actualColor);
			if (m_strExpColor.replace("#", "").equalsIgnoreCase(actualColor.replace("#", ""))) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + m_strExpColor,
						GlobalVariables.g_strKeywordDescription + " is successful");

			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + m_strExpColor,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectDateFromJqueryCalendarPopUp method selects the date from calendar
	 * popup
	 * 
	 * @param SelectDate,
	 *            used to pass the date format in data sheet
	 * @return Boolean value True/False based on success of this function
	 * @author sudhanshu
	 */
	public boolean SelectDateFromJqueryCalendarPopUp(String SelectDate) throws Exception {
		WebElement dateWidget;
		List<WebElement> columns;
		List<String> list = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");
		// Expected Date, Month and Year
		int expMonth;
		int expYear;
		String expDate = null;
		// Calendar Month and Year
		String calMonth = null;
		String calYear = null;
		boolean dateNotFound;
		dateNotFound = true;
		expMonth = Integer.parseInt(SelectDate.split("/")[0]);
		expYear = Integer.parseInt(SelectDate.split("/")[2]);
		expDate = SelectDate.split("/")[1];
		;
		while (dateNotFound) {

			calMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			calYear = driver.findElement(By.className("ui-datepicker-year")).getText();
			if (list.indexOf(calMonth) + 1 == expMonth && (expYear == Integer.parseInt(calYear))) {
				dateWidget = driver.findElement(By.id("ui-datepicker-div"));
				columns = dateWidget.findElements(By.tagName("td"));

				for (WebElement cell : columns) {
					// Selects Date
					if (cell.getText().equals(expDate)) {
						cell.findElement(By.linkText(expDate)).click();
						break;
					}
				}
				dateNotFound = false;
			} else if (list.indexOf(calMonth) + 1 < expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear > Integer.parseInt(calYear)) {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]")).click();
			} else if (list.indexOf(calMonth) + 1 > expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear < Integer.parseInt(calYear)) {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]")).click();
			}
		}
		Thread.sleep(3000);
		return true;

	}

	/**
	 * ValidateColmnDataFrmODB method used to validate column data from data
	 * base
	 * 
	 * @param request,
	 *            pass the query to retain the value
	 * @return Boolean value True/False based on success of this function
	 * @author sudhanshu
	 */
	public boolean ValidateColmnDataFrmODB(String request) throws ClassNotFoundException {

		HashMap<String, String> requestParam = CE_constructRequestParam(request);
		int mapSize = requestParam.size() - 2;
		int computedSize = mapSize / 2;
		String arr[] = new String[computedSize];

		Statement statement = null;
		ResultSet rs = null;
		java.sql.Connection DBconnection = null;
		boolean bStatus = false;
		try {
			s_objlog4j.info("Initiating Oracle JDBC Connection..");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBconnection = DriverManager.getConnection("jdbc:oracle:thin:@" + GlobalVariables.g_ODSDBODBCDataSource,
						GlobalVariables.g_ODSDBUserID, GlobalVariables.g_ODSDBPassword);

				
				statement = DBconnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				s_objlog4j.info("Connected to DB server and requesting data..");
				if (requestParam.containsKey("query")) {
					rs = statement.executeQuery(requestParam.get("query"));

					if (rs != null && rs.next()) {
						do {
							for (int i = 0; i <= (computedSize - 1); i++) {
								arr[i] = rs.getString(requestParam.get("col" + i));
								if (arr[i].equalsIgnoreCase(requestParam.get("val" + i))) {

									System.out.println("Validated value from DB :-" + arr[i].toString()
											+ requestParam.get("type"));
									s_childExtentTest.log(LogStatus.INFO, "AS_ValidateColmnDataFrmODB",
											"Validated value from DB :-" + arr[i].toString() + " for type :-"
													+ requestParam.get("type"));
								}
								bStatus = true;
							}
						} while (rs.next() && bStatus == false);
					} else {
						s_childExtentTest.log(LogStatus.ERROR, "AS_ValidateColmnDataFrmODB", "No Data Found!!");
						System.out.println("NO Data!");
					}
				}
			} catch (SQLException e) {
				s_childExtentTest.log(LogStatus.ERROR, "AS_ValidateColmnDataFrmODB", "Connection Failed!");
				e.printStackTrace();
				s_objlog4j.info(e.getMessage());
				System.out.println(e.getMessage());
			}
			if (DBconnection != null) {
				try {
					DBconnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			s_objlog4j.info(e.getMessage());
		}
		return bStatus;
	}

	/**
	 * FileUpload method used for uploading files
	 * 
	 * @param m_strFilePath
	 *            path of location of file
	 * @param xpath
	 *            of uploaded locator
	 * @return Boolean value True/False based on success of this function
	 * @author Sudhanshu
	 */
	public boolean FileUpload(String m_strFilePath, String xpath) throws Exception {
		boolean bStatus = false;
		String projectPath = System.getProperty("user.dir");
		try {

			WebElement browseBox = driver.findElement(By.xpath(xpath));
			browseBox.sendKeys(projectPath + m_strFilePath);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ReplaceUrlWithStoredData method generates a runtime data and stores into
	 * a variable
	 * 
	 * @param m_strText
	 *            This describes runtime variable
	 * @return Boolean value True/False based on success of this function
	 * @author Selva
	 */
	public boolean ReplaceUrlWithStoredData(String url, String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			if (gVar.variables.containsKey(m_strText)) {
				String value = gVar.variables.get(m_strText).toString();
				if (url.contains(m_strText)) {

					url = url.replace(m_strText, value);

					textBox.click();
					textBox.clear();
					textBox.sendKeys(url);

					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + m_strText,
							GlobalVariables.g_strKeywordDescription + " is successful");
					return true;
				}
			}

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * This method generates random numbers
	 * 
	 * @return int
	 */
	private int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1)
			return randomInt;
		else
			return randomInt - 1;

	}

	/**
	 * This method generates random String
	 * 
	 * @return String
	 */

	public String generateRandomString() {

		StringBuffer randStr = new StringBuffer();
		randStr.append("auto_");
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	
	
	/**
	 * EnterTextRuntimeAndStore method generates a runtime data and stores into
	 * a variable
	 * 
	 * @param m_strText
	 *            This describes runtime variable
	 * @return Boolean value True/False based on success of this function
	 * @author Selva
	 */
	public boolean EnterTextRuntimeAndStore(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			String strVal = generateRandomString();
			textBox.click();
			textBox.clear();
			textBox.sendKeys(strVal);
			m_strText = m_strText.trim();
			gVar.variables.put(m_strText, strVal);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * GenerateNumberAndStore method generate random number and store same in a
	 * string
	 * 
	 * @param m_strText
	 *            This describes runtime variable
	 * @return Boolean value True/False based on success of this function
	 * @author Selva
	 */
	public boolean GenerateNumberAndStore(String m_strText) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			String strVal = String.valueOf(getRandomNumber());
			gVar.variables.put(m_strText, strVal);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + m_strText,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * doubleClickOnElement method used to perform double click on Particular
	 * Object.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Anil_Kumar_M
	 */
	public boolean doubleClickOnElement() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			Actions actions = new Actions(driver);

			actions.moveToElement(element).doubleClick().build().perform();

			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * clickUsingWhiteColorCode method used to perform click operation on a
	 * Particular Object in TT based on color code.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Subhankar Das
	 */
	public boolean clickUsingWhiteColorCode() {
		boolean bStatus = false;
		try {
			String tbodyXpath = "//table[@class='f10n']/tbody";
			List<WebElement> listOfRows = driver.findElements(By.xpath(tbodyXpath));
			String flag = "false";
			for (WebElement singleRow : listOfRows) {
				List<WebElement> listOfCellsForRow = driver.findElements(By.xpath(tbodyXpath + "/tr"));
				for (WebElement singleCell : listOfCellsForRow) {
					String colorCode = singleCell.getAttribute("bgColor");
					if (colorCode.contains("#ffffff")) {
						flag = "true";
						driver.findElement(By.xpath(colorCode)).click();
						break;
					}
				}
				if (flag.equals("true")) {
					break;
				}

			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;

	}


	public boolean clickMultipleTimes() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			while (buttonOrLink.isEnabled()) {
				buttonOrLink.click();
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			// e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * VerifyTextFieldIsEditable method used to check Text box is in editable
	 * mode or not.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pravallika Akula
	 */

	public boolean VerifyTextFieldIsEditable(String TextBoxXpath) {
		boolean bStatus = false;
		try {
			WebElement TextBox = driver.findElement(By.xpath(TextBoxXpath));
			if (TextBox.getAttribute("class") == null) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is editable");
			} else
				bStatus = true;
		//	GlobalVariables.g_captureScreenShot = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is editable");

		} catch (Exception e) {

			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not editable");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * getToolTipTextOnMouseOver method used to get text from ToolTip.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @param TextboxXpath:
	 *            pass Textbox xpath as a parameter
	 * @author Pravallika Akula
	 */
	public boolean getToolTipTextOnMouseOver(String TextboxXpath) {
		boolean bStatus = false;
		try {
			Actions Tooltip1 = new Actions(driver);
			WebElement Element = driver.findElement(By.xpath(TextboxXpath));

			Tooltip1.clickAndHold(Element).perform();
			String ToolTipText = Element.getAttribute("title");
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + ToolTipText,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is  Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * getTextFromTextBox method used to get text from Textbox.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @param TextboxXpath:
	 *            Pass textbox xpath as a parameter.
	 * @author Pravallika Akula
	 */

	public boolean getTextFromTextBox(String TextboxXpath) {
		boolean bStatus = false;
		try {

			WebElement Element = driver.findElement(By.xpath(TextboxXpath));
			String Text = Element.getAttribute("value");
			bStatus = true;

			if (Text == null) {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + Text,
						GlobalVariables.g_strKeywordDescription + " is successful");

			} else
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + Text,
						GlobalVariables.g_strKeywordDescription + " is successful");

		}

		catch (Exception e) {

			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * unCheckIfChecked1 method used to uncheck the checkbox.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pravallika Akula
	 */
	public boolean unCheckIfChecked1() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			String val = buttonOrLink.getAttribute("CHECKED");
			if (val == null) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is checked");
			} else if (val.contains("checked") || val.contains("true")) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonOrLink);
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is checked");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not checked");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * checkIfNotChecked1 method used to check the checkbox.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pravallika Akula
	 */
	public boolean checkIfNotChecked1() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			String val = buttonOrLink.getAttribute("CHECKED");
			if (val == null) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonOrLink);
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is checked");
			}

			else if (val.contains("checked") || val.contains("true")) {

				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is checked");
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is  not checked");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateObjectAttribute method to validate the attribute of Web Element
	 * is available or not.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @param strAttribute:
	 *            Pass Web Element attribute as a parameter.
	 * @author Pravallika Akula
	 */

	public boolean ValidateObjectAttribute(String strAttribute) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			String val = buttonOrLink.getAttribute(strAttribute);
			if (val == null) {

				bStatus = true;
				GlobalVariables.g_captureScreenShot = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + strAttribute + " is validated");
			}

			else {

				bStatus = true;
				GlobalVariables.g_captureScreenShot = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + strAttribute + " is validated");
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + strAttribute + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * selectByValueFromDropdown method used to select the item from Dropdown
	 * based on value.
	 * 
	 * @return :Boolean value True/False based on success of this function
	 * @param value
	 *            : pass value of the option as a parameter.
	 * @param Xpath
	 *            : pass xpath of the Drop down.
	 * @author AnilKumar_M
	 */

	public boolean selectByValueFromDropdown(String value, String Xpath) throws Exception {

		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement dropdownObject = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			new Select(dropdownObject).selectByValue(value);

			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, Xpath + GlobalVariables.g_strStepDescription + " " + value,
					GlobalVariables.g_strKeywordDescription + " is selected");

		}

		catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, Xpath + GlobalVariables.g_strStepDescription + " " + value,
					GlobalVariables.g_strKeywordDescription + " is not selected");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectbyVisibleText method used to select an option from dropdown using
	 * visible text.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @param Item:
	 *            pass visible text of the option as a parameter
	 * @author Pravallika Akula
	 */
	public boolean SelectbyVisibleText(String Item) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement dropdown = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			Select select = new Select(dropdown);
			select.selectByVisibleText(Item);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is selected");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not selected");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateListItems method used to validate one particular item of a list.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @param Item:
	 *            pass required item as a parameter
	 * @param Xpath:
	 *            pass xpath of list web element as a parameter
	 * @author Pravallika Akula
	 */

	public boolean ValidateListItems(String Item, String Xpath) throws Exception {
		boolean bStatus = false;

		try {

			List<WebElement> list = driver.findElements(By.xpath(Xpath));
			for (WebElement webElement : list) {
				String val = webElement.getText();

				if (val.contains(Item)) {
					bStatus = true;
					GlobalVariables.g_captureScreenShot = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + " is validated");
				}
			}
		}

		catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not validated");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * SelectbyIndex method used to select an option from dropdown using option
	 * index.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @param index:
	 *            pass index of the option as a parameter
	 * @author Subhankar Das
	 */
	public boolean SelectbyIndex(String index) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement dropdown = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			new Select(dropdown).selectByIndex(Integer.parseInt(index));
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * PasteIntoTextField method used to cut and Paste the content in Text box.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @param SrcXpath:
	 *            pass xpath of source textbox as a parameter
	 * @param DstnXpath:
	 *            pass xpath of destination textbox as a parameter
	 * @author Pravallika Akula
	 *
	 */
	public boolean PasteIntoTextField(String SrcXpath, String DstnXpath) {
		boolean bStatus = false;
		try {
			// code to cut from source
			WebElement textbxSource = driver.findElement(By.xpath(SrcXpath));
			textbxSource.sendKeys(Keys.chord(Keys.CONTROL, "k"));
			// code to paste to any destination
			WebElement textbxDstn = driver.findElement(By.xpath(DstnXpath));
			textbxDstn.sendKeys(Keys.chord(Keys.CONTROL, "v"));
			String val = textbxDstn.getAttribute("text");
			if (val == null) {

				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}

		} catch (Exception e) {

			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	/**
	 * ClickBySikuli method used to click an object based on its image by using
	 * sikuli.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @param imagePath:
	 *            pass path of image as a parameter
	 * @author Subhankar Das
	 */

	/*
	 * public boolean ClickBySikuli(String imagePath) throws Exception { boolean
	 * bStatus = false; try { Screen s = new Screen(); Thread.sleep(3000);
	 * s.find(imagePath); s.click(imagePath); bStatus=true;
	 * s_childExtentTest.log(LogStatus.PASS,
	 * GlobalVariables.g_strStepDescription,
	 * GlobalVariables.g_strKeywordDescription + " is successful"); } catch
	 * (Exception e) { s_childExtentTest.log(LogStatus.FAIL,
	 * GlobalVariables.g_strStepDescription,
	 * GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
	 * e.printStackTrace(); } return bStatus; }
	 */

	/**
	 * hitEscape method used to press escape button from keyboard.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Subhankar Das
	 */

	public boolean hitEscape() throws Exception {
		boolean bStatus = false;
		try {
			Robot rb = new Robot();
			Thread.sleep(5000);
			rb.keyPress(KeyEvent.VK_ESCAPE);
			rb.keyRelease(KeyEvent.VK_ESCAPE);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateDataFrmSQL compares the data present in DB column and the text
	 * present in UI request takes a hash map e.g
	 * query:
	 * 
	 * @return Boolean value True/False based on success of this function
	 *         Sudhanshu & Dinesh
	 */

	// Create request param hash map obj

	public Boolean DeletefromDB(String request) throws SQLException {

		Connection Exclconnection = null;
		Recordset Exclrecordset = null;
		Statement DBstatement = null;
		// int DBresultset = 0;
		java.sql.Connection DBconnection = null;
		boolean bStatus = false;
		String strQuery = null;

		try {

			HashMap<String, String> requestParam = CE_constructRequestParam(request);
			String connectionUrl = GlobalVariables.g_SQLConnectionURL;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			DBconnection = DriverManager.getConnection(
					connectionUrl + "databaseName=" + requestParam.get("DBNAME") + ";integratedSecurity=true");
			System.out.println("Connected to DB server.");
			DBstatement = DBconnection.createStatement();

			DBstatement = DBconnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			s_objlog4j.info("Connected to DB server and requesting data..");

			Fillo fillo = new Fillo();
			Exclconnection = fillo.getConnection(GlobalVariables.g_strTestDataFilePath);
			strQuery = "Select * from " + requestParam.get("SheetName") + " where Run='YES' and Type ='"
					+ requestParam.get("Type") + "'";

			Exclrecordset = Exclconnection.executeQuery(strQuery);

			while (Exclrecordset.next()) {
				if (Exclrecordset.getCount() > 0) {
					System.out.println(Exclrecordset.getField("Query"));
					DBstatement.executeUpdate(Exclrecordset.getField("Query"));
					bStatus = true;
					s_childExtentTest.log(LogStatus.INFO, "DeletefromDB", "QueryExecuted..");
				} else {
					bStatus = false;
					s_childExtentTest.log(LogStatus.ERROR, "DeletefromDB", "No Data found!!");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			s_childExtentTest.log(LogStatus.ERROR, "DeletefromDB", e.getMessage());
		}

		finally {
			Exclrecordset.close();
			Exclconnection.close();
			DBconnection.close();
		}
		return bStatus;
	}

	/**
	 * ClickBySikuli is a method to click an object based on its image by using
	 * sikuli.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Subhankar Das
	 * 
	 * 
	 *         public boolean ClickBySikuli() throws Exception { boolean bStatus
	 *         = false; try { Screen s = new Screen(); Thread.sleep(3000);
	 *         s.find("okbutton.png"); s.click("okbutton.png"); bStatus = true;
	 *         } catch (Exception e) { e.printStackTrace(); } return bStatus; }
	 */

	/**
	 * switchDB is a method used to switch database in AA.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @param dbName:
	 *            pass db name e.g; PROD,AETCON,Advocate as a parameter
	 * @author Subhankar Das
	 */

	public boolean switchDB(String dbName) throws Exception {
		boolean bStatus = false;
		try {
			driver.findElement(By.xpath("//span[@id='sso']/a")).click();
			Thread.sleep(2000);

			WebElement dbWebElement = driver.findElement(By.xpath("//a[text()='" + dbName + "']"));

			if (dbWebElement.isDisplayed()) {

				dbWebElement.click();
				bStatus = true;
				s_childExtentTest.log(LogStatus.INFO, "switchDB", "db changed to - " + dbName);

			}

		} catch (Exception e) {

			bStatus = true;
			s_childExtentTest.log(LogStatus.INFO, "switchDB", dbName + "  -db is already set by default");
		}
		return bStatus;
	}

	/**
	 * AA_constructRequestParam is a method used to return request parameters
	 * like db name,sheet name etc.
	 * 
	 * @return HashMap
	 * @author Sudhansu
	 */

	public static HashMap<String, String> AA_constructRequestParam(String request) {

		String[] reqParam = request.split(";");

		HashMap<String, String> requestParams = new HashMap<String, String>();

		for (String param : reqParam) {

			String[] keyVal = param.split(":");

			requestParams.put(keyVal[0], keyVal[1]);

		}

		return requestParams;

	}

	/**
	 * clinicalSummarySettings is a method used to set default clinical summary
	 * setting in AA.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Subhankar Das
	 */

	public boolean clinicalSummarySettings() throws Exception {
		boolean bStatus = false;
		try {
			String repo[] = { "Allergies", "Measurements", "Medications", "Notes" };
			List<WebElement> rightBoxList = driver.findElements(
					By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ClinicalSummaryPanels_lstBoxRight']/option"));
			WebElement saveSettingsBtn = driver
					.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnSaveData']"));

			if (rightBoxList.size() > 0) {
				for (WebElement web : rightBoxList) {
					String option = web.getText();

					for (String val : repo) {

						if (option.contains(val)) {

							driver.findElement(By
									.xpath("//select[@id='ctl00_ContentPlaceHolder1_ClinicalSummaryPanels_lstBoxRight']/option[text()='"
											+ option + "']"))
									.click();
							Thread.sleep(2000);
							driver.findElement(By.xpath(".//*[contains(@id,'ClinicalSummaryPanels_btnMoveLeft')]"))
									.click();
							bStatus = true;
							s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
									GlobalVariables.g_strKeywordDescription + " is successful");

						}
					}
				}
				bStatus = true;
				saveSettingsBtn.click();
				Thread.sleep(2000);
			} else {
				bStatus = true;
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is Unsuccessful");

			}

		} catch (Exception e) {

			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * CancelAlertIfExist method checks on Alert if it is present than Dissmiss
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep kumar Swain
	 */
	public boolean CancelAlertIfExist() {
		boolean bStatus = false;
		try {
			// Thread.sleep(2000);
			if (isAlertPresent()) {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * EnterTextAndStore method enters text into object and stores into a
	 * variable
	 * 
	 * @param m_strText
	 *            This describes the text to enter
	 * @param m_runtimeVariable
	 *            describes the variable to which it needs to be stored
	 * @return Boolean value True/False based on success of this function
	 * @author Selva
	 */
	public boolean EnterTextAndStore(String strText, String runtimeVariable) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			textBox.click();
			textBox.clear();
			textBox.sendKeys(strText);
			gVar.runtimeVariable1.put(runtimeVariable.trim(), strText.toString());
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + strText,
					GlobalVariables.g_strKeywordDescription + " is Successful");

			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + strText,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * IncrementAndValidateStoredVariable method gets the displayed text and
	 * stores into a variable
	 * 
	 * @param m_runtimeVariable
	 *            describes the variable to which it needs to be stored
	 * @param incrementalCount
	 *            describes the variable to increase how many count
	 * @return Boolean value True/False based on success of this function
	 * @author Selva
	 */
	public boolean IncrementAndValidateStoredVariable(String runtimeVariable, String incrementalCount)
			throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			// Getting the text value
			int strVal = Integer.valueOf(element.getText());
			runtimeVariable = runtimeVariable.trim();
			if (gVar.runtimeVariable1.containsKey(runtimeVariable)) {
				// int value = ((Integer)
				// gVar.runtimeVariables.get(runtimeVariable) +
				// Integer.valueOf(incrementalCount));
				// Getting the key-value from stored HashMap
				String value = String.valueOf(gVar.runtimeVariable1.get(runtimeVariable));
				int Value = Integer.valueOf(value); // Converting Integer into
													// int
				int Count = Integer.valueOf(incrementalCount); // Converting
																// Integer into
																// int
				Count += Value;
				System.out.println(value);
				if (strVal == Count) {
					GlobalVariables.g_captureScreenShot = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + strVal,
							GlobalVariables.g_strKeywordDescription + " is Successful");

					return true;
				}
			}
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + strVal,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + runtimeVariable,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ValidateTextAgainstStoredVariable method validates the element attribute
	 * value against stored value
	 * 
	 * @param m_strAttribute
	 *            This describes the attribute type to validate
	 * @param m_stroredVariable
	 *            This describes the attribute value to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Selva
	 */
	public boolean ValidateTextAgainstStoredVariable(String m_stroredVariable) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			m_stroredVariable = m_stroredVariable.trim();
			String value = textBox.getText().trim().toString();
			if (gVar.runtimeVariable1.containsKey(m_stroredVariable)) {
				String referenceText = gVar.runtimeVariable1.get(m_stroredVariable).toString();
				System.out.println(referenceText + "  " + m_stroredVariable + " Value" + value);
				if (referenceText.contains(value)) {
					bStatus = true;

					GlobalVariables.g_captureScreenShot = true;
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + value,
							GlobalVariables.g_strKeywordDescription + " is Successful");

				}
			} else

				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + value,
						GlobalVariables.g_strKeywordDescription + " is UnSuccessful");

		} catch (Exception e) {

			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + m_stroredVariable,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * mouseOverAnElementAndClick method performs mousing hover over an element
	 * and clicks on the sub element
	 * 
	 * @param xpath
	 *            This describes the xpath of the element to click
	 * @return Boolean value True/False based on success of this function
	 * @author Selva
	 */
	public boolean mouseOverAnElementAndClick(String xpath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			Thread.sleep(5000);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			Thread.sleep(5000);
			actions.moveToElement(driver.findElement(By.xpath(xpath.trim()))).click().perform();
			Thread.sleep(1000);
			bStatus = true;

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTextAtRuntimeValue method enters text which has stored into runtime
	 * variable
	 * 
	 * @param runtimeVariable
	 *            describes the variable which has stored as Key in HashMap
	 * @return Boolean value True/False based on success of this function
	 * @author Nains
	 */
	public boolean EnterTextAtRuntimeValue(String runtimeVariable) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			textBox.click();
			textBox.clear();
			if (gVar.runtimeVariable1.containsKey(runtimeVariable)) {
				textBox.sendKeys(gVar.runtimeVariable1.get(runtimeVariable).toString());
				s_childExtentTest.log(LogStatus.PASS,
						GlobalVariables.g_strStepDescription + " "
								+ gVar.runtimeVariable1.get(runtimeVariable).toString(),
						GlobalVariables.g_strKeywordDescription + " is Successful");
				bStatus = true;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL,
					GlobalVariables.g_strStepDescription + " " + gVar.runtimeVariable1.get(runtimeVariable).toString(),
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * getTextAndStoreInVariable method gets the displayed text and stores into
	 * a variable
	 * 
	 * @param m_runtimeVariable
	 *            describes the variable to which it needs to be stored
	 * @return Boolean value True/False based on success of this function
	 * @author Nains
	 */
	public boolean getTextByIndexAndStoreInVariable(String runtimeVariable, String index) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			String strVal = textBox.getText();
			String newStrVal = strVal.split(" ")[Integer.valueOf(index)];
			System.out.println(newStrVal);
			gVar.runtimeVariable1.put(runtimeVariable.trim(), newStrVal);
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription + " " + newStrVal,
					GlobalVariables.g_strKeywordDescription + " is Successful");
			bStatus = true;
		} catch (Exception e) {

			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription + " " + runtimeVariable,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");

		}
		return bStatus;

	}

	/**
	 * ValidateTextFromAlertAndClickOK method verifies the text present in the
	 * javascript confirmation
	 * 
	 * @param m_strText
	 *            This is the text to verify in the alert
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	/*
	 * public boolean ValidateTextFromAlertAndClickOK(String m_strText) {
	 * boolean bStatus = false; try { Alert alert = driver.switchTo().alert();
	 * // alert.accept(); if (alert.getText().replace(" ",
	 * "").toUpperCase().contains(m_strText.replace(" ", "").toUpperCase())) {
	 * Thread.sleep(2000); alert.accept(); Thread.sleep(2000); bStatus = true;
	 * GlobalVariables.g_captureScreenShot = true; }
	 * s_childExtentTest.log(LogStatus.PASS,
	 * GlobalVariables.g_strKeywordDescription,
	 * GlobalVariables.g_strKeywordDescription + " " + m_strText);
	 * 
	 * } catch (Exception e) { s_childExtentTest.log(LogStatus.PASS,
	 * GlobalVariables.g_strKeywordDescription,
	 * GlobalVariables.g_strKeywordDescription + " " + m_strText);
	 * e.printStackTrace(); bStatus = true; } return bStatus; }
	 *//**
		 * validatePartialText method validates the text from object contains
		 * expected text using getText
		 * 
		 * @param m_strText
		 *            This describes the text to validate
		 * @return Boolean value True/False based on success of this function
		 * @author Sarath Gorantla
		 */
	public boolean ValidateText(String m_expectedText) {
		boolean bstatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(gVar.g_strObjectRepositoryFilePath, gVar.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			String actualText = textBox.getText();
			if (actualText.equals(m_expectedText)) {
				Assert.assertEquals(actualText, m_expectedText);
				bstatus = true;
				
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription+" "+ "is matching successfully"+ " " 
								+ "Actual Text is -  "+"< -"+ actualText +"->"+" "+  "Expected Text is -  "+"<-" +m_expectedText+" ->");
				GlobalVariables.g_captureScreenShot = true;
			} else {
				/*s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription
								+ " has been failed as expected and actual values are not matching");*/
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription+" "+ "is Not matching successfully"+ " " 
								+ "Actual Text is -  "+"< -"+ actualText +"->"+" "+  "Expected Text is -  "+"<-" +m_expectedText+" ->");
				
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " has been failed due to exception thrown");
		}
		return bstatus;
	}

	/**
	 * ClickIfExist method clicks on object if it is present
	 * 
	 * @param objXpath
	 *            This describes the object to click
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */

	public boolean ClickIfExist1(String objXpath) throws Exception {

		try {
			/*if (driver.findElement(By.xpath(objXpath)).isDisplayed()) {
				driver.findElement(By.xpath(objXpath)).click();*/
			driver.findElement(By.xpath(objXpath)).click();
			//}
		} catch (Exception e) {
		}
		s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
				GlobalVariables.g_strKeywordDescription + " is successful");
		System.out.println("Nains");
		return true;

	}

	/**
	 * ClickIfExist method clicks on object if it is present
	 * 
	 * @param objXpath
	 *            This describes the object to click
	 * @return Boolean value True/False based on success of this function
	 * @author Pradeep kumar swain
	 */
	public boolean ClickIfExist() throws Exception {
		boolean bStatus = false;
		try {
			if (driver.findElement(By.xpath("//a[contains(text(),'receive text message alerts')]")).isDisplayed()) {
				driver.findElement(By.xpath("//a[contains(text(),'receive text message alerts')]")).click();
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful"); // e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * ClickIfExist method clicks on object if it is present
	 * 
	 * @param objXpath
	 *            This describes the object to click
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean ClickIfExist(String objXpath) throws Exception {
		System.out.println("ClickIfExist-------------------------");
		boolean bStatus = false;
		try {
			if (

			driver.findElement(By.xpath(objXpath)).isDisplayed()) {
				waitForElementToBeClickable("EVALUATEXPATH", objXpath);
				driver.findElement(By.xpath(objXpath)).click();
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			// e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/**
	 * validateElementPropertyFromDOM method validates the element property from
	 * DOM contains expected text using JS
	 * 
	 * @param m_strPropertyName
	 *            This describes the property name of object present in DOM
	 * @param m_strPropertyValueExpected
	 *            This describes the DOM property value expected to validate
	 * @return Boolean value True/False based on success of this function
	 * @author Serath Gorantla
	 */
	public boolean ValidateElementPropertyFromDOM(String m_strPropertyName, String m_strPropertyValueExpected)
			throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		String propValue = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(gVar.g_strObjectRepositoryFilePath, gVar.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (m_strPropertyValueExpected.equalsIgnoreCase("null")) {
				m_strPropertyValueExpected = "";
			}
			if (m_strPropertyValueExpected.equalsIgnoreCase("true")
					|| m_strPropertyValueExpected.equalsIgnoreCase("false")) {
				Boolean propValue1 = (Boolean) js.executeScript("return arguments[0]." + m_strPropertyName + ";",
						element);
				propValue = propValue1.toString().toUpperCase();
			} else {
				propValue = (String) js.executeScript("return arguments[0]." + m_strPropertyName + ";", element);
			}
			s_objlog4j.info("Actual text=" + propValue);
			s_objlog4j.info("Expected text=" + m_strPropertyValueExpected.toUpperCase());
			if (m_strPropertyValueExpected.toUpperCase().equalsIgnoreCase("NULL")
					|| propValue.toUpperCase().contains(m_strPropertyValueExpected.toUpperCase())) {
				bStatus = true;
				GlobalVariables.g_captureScreenShot = true;
				s_childExtentTest.log(LogStatus.PASS,
						"Expected=" + m_strPropertyValueExpected.toUpperCase() + " and Actual="
								+ propValue.toUpperCase(),
						gVar.g_strStepDescription + " has been passed as expected and actual values are matching");
			} else {
				s_childExtentTest.log(LogStatus.FAIL,
						"Expected=" + m_strPropertyValueExpected.toUpperCase() + " and Actual="
								+ propValue.toUpperCase(),
						gVar.g_strStepDescription + " has been failed as expected and actual values are not matching");
			}
		} catch (Exception e) {
			s_objlog4j.error("Exception Thrown", e);
			s_childExtentTest.log(LogStatus.FAIL,
					gVar.g_strStepDescription + "=" + m_strPropertyValueExpected.toUpperCase(),
					gVar.g_strStepDescription + " has been failed due to exception thrown");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * ClickElemtentIfExist method clicks on object if it is present
	 * 
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author RAJU VELPULA
	 */
	public boolean ClickElementIfExist() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);

			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			if (buttonOrLink.isDisplayed()) {
				waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
				waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
				buttonOrLink.click();
				bStatus = true;
			}
			s_childExtentTest.log(LogStatus.PASS, "ClickElementIfExist", GlobalVariables.g_strStepDescription);
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, "ClickElementIfExist", GlobalVariables.g_strStepDescription);
			// e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}

	/* MAHP Services */
	public boolean sendReceiveSoapRequestMAHP(String resourcePath, String envelope, String request, String strTestdata)
			throws Exception {
		boolean bStatus = false;

		String strXmlData[] = null;
		String strTagName;
		String expected;

		try {

			

			// Construct request envelope
			String requestEnv = readValueFromIniFile(envelope, "soapRequest");
			if (!request.isEmpty()) {

				// Construct request parameters

				HashMap<String, String> input = constructRequestParam(request);
				for (String key : input.keySet()) {
					requestEnv = requestEnv.replace(key, input.get(key));
				}
			}
			s_objlog4j.info(requestEnv);
			String xmlResponse = given().body(requestEnv).when().post(resourcePath).andReturn().body().asString();
			s_objlog4j.info(xmlResponse);

			/**
			 * Construct xml object to parse the response
			 */
			XmlPath xml = new XmlPath(xmlResponse).setRoot(readValueFromIniFile(envelope, "responseRoot"));
			// s_objlog4j.info(xml.prettify());

			XmlPath payload = new XmlPath(xml.getString("payload"))
					.setRoot(readValueFromIniFile(envelope, "payloadRoot"));

			String payloadResponse = xml.getString("payload");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(payloadResponse)));

			if (strTestdata.contains("Date")) {

				strXmlData = strTestdata.split(";");
				strTagName = strXmlData[0];
				expected = strXmlData[1];

			} else {

				strXmlData = strTestdata.split(":");
				strTagName = strXmlData[0];
				expected = strXmlData[1];
			}

			NodeList nodeList = document.getElementsByTagName(strTagName);

			if (!payload.setRoot(strTagName).getString(strTagName).isEmpty()) {
				String actual = payload.get(strTagName);

				if (expected.equalsIgnoreCase(actual)) {
					s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :",
							"<p>Expected  : " + expected + "<br> Actual  : " + actual + "</p>");
					bStatus = true;
				} else {

					s_childExtentTest.log(LogStatus.ERROR, "Expectation Pass :", "<p>Expected  : " + expected
							+ "<br> Actual  : " + "<b style=\"color:red;\">" + actual + "</b></p>");
					bStatus = true;
				}

			}
			// traversing child nodes
			else if (readValueFromIniFile(envelope, "ChildNodeRoot") != null) {

				String strActual = null;

				/* Reading Child node ProblemList */

				String childNodeRoot = readValueFromIniFile(envelope, "ChildNodeRoot");
				String[] strNodes = childNodeRoot.split(";");

				for (int b = 0; b < strNodes.length; b++) {

					NodeList childNodeList = document.getElementsByTagName(strNodes[b]);

					for (int k = 0; k < childNodeList.getLength(); k++) {

						boolean bFlag = false;

						NodeList firstChildList = childNodeList.item(k).getChildNodes();

						for (int j = 0; j < firstChildList.getLength(); j++) {

							NodeList secondChildList = firstChildList.item(j).getChildNodes();

							String strNode = firstChildList.item(j).getNodeName();

							strActual = firstChildList.item(j).getTextContent();

							String secondChildNodeRoot = readValueFromIniFile(envelope, "ChildNodeRoot2");

							if ((secondChildNodeRoot != null) && (secondChildNodeRoot.equals(strNode))) {

								NodeList secondChildNodeList = document.getElementsByTagName(secondChildNodeRoot);

								for (int m = 0; m < secondChildNodeList.getLength(); m++) {
									NodeList thirdChildList = secondChildNodeList.item(m).getChildNodes();

									for (int n = 0; n < thirdChildList.getLength(); n++) {

										strNode = thirdChildList.item(n).getNodeName();
										strActual = thirdChildList.item(n).getTextContent();

										if (expected.equals(strActual) || strNode.contains("Date"))
											break;
									}
								}
							}

							if (expected.equalsIgnoreCase(strActual)) {
								/*
								 * s_objextendTest.log(LogStatus.INFO,
								 * "Expectation Pass :", "<p>Expected  : " +
								 * expected + "<br> Actual : " + strActual +
								 * "</p>");
								 */
								s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :",
										GlobalVariables.g_strKeywordDescription + "<p>Expected  : " + expected
												+ "<br> Actual : " + strActual + "</p>");
								bStatus = true;
								bFlag = true;
								break;
							}
						}
						/* Checking for duplicates and discarding */
						if (bFlag == true)
							break;
					}
				}
				if (bStatus != true) {
					s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail :", "<p>Expected  : " + expected
							+ "<br> Actual  : " + "<b style=\"color:red;\">" + strActual + "</b></p>");
					bStatus = true;
				}
			}

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveSoapRequest", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveSoapRequest", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;

	}

	public boolean sendGetRestRequestWithURLParameters(String resourcePath, String response) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = null;
		String json;

		try {
			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();
			if (!response.isEmpty()) {
				responseParams = constructResponseParam(response);
			}

			json = given().get(resourcePath).asString();

			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.PASS, "sendReceiveRestRequest", json);

			/**
			 * Validate the response and log into report
			 */
			for (String key : responseParams.keySet()) {

				boolean bFlag = false;
				String strExpected[] = jsPath.get(key).toString().split(",");

				String expected = "";

				String actual = responseParams.get(key);
				for (int i = 0; i < strExpected.length; i++) {
					expected = strExpected[i];
					expected = expected.replace("[", "").trim();
					expected = expected.replace("]", "").trim();
					if (expected.equalsIgnoreCase(actual)) {
						s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :",
								"<p>Expected : " + expected + "<br> Actual : " + actual + "</p>");
						bStatus = true;
						bFlag = true;
						break;
					}
				}
				if (bFlag == false) {
					s_childExtentTest.log(LogStatus.FAIL, "Expectation Fail :", "<p>Expected : " + expected
							+ "<br> Actual : " + "<b style=\"color:red;\">" + actual + "</b></p>");
					bStatus = false;
				}
			}

		//	requestSpecification = null;
			//responseSpecification = null;

		} catch (AssertionError e) {
			s_objextendTest.log(LogStatus.ERROR, "sendReceiveRestRequest", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_objextendTest.log(LogStatus.ERROR, "sendReceiveRestRequest", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * ValidateTodaysDate method Will Get The Todays System Date
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Abhijeet
	 */
	public boolean ValidateTodaysDate() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String todayDate = dateFormat.format(date);
			System.out.println("Todays Date Is " + todayDate);

			bStatus = ValidateElementAttribute("value", todayDate);

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * unCheckIfSelected method clicks button or link object in a page if it is
	 * checked already.
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Abhijeet
	 */
	public boolean unCheckIfSelected() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			// s_objlog4j.info("checked property=" +
			// buttonOrLink.getAttribute("checked"));
			try {
				Thread.sleep(2000);
				if (buttonOrLink.isSelected()) {
					buttonOrLink.click();
					s_objlog4j.info("clicking object");
				} else {
					s_objlog4j.info("Not clicking object");

				}
			} catch (Exception e) {
				s_objlog4j.info(e.getMessage());
				buttonOrLink.click();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTodaysDate method enters Todays Date Into text into object
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Abhijeet
	 */
	public boolean SelectTodaysDate() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {

			DateFormat dateFormat = new SimpleDateFormat("d");
			Date date = new Date();
			String todayDate = dateFormat.format(date);

			String xpath = "//div[@id='ui-datepicker-div']/table/tbody/tr//a[text()='" + todayDate + "']";
			WebElement Todaysdate = driver.findElement(By.xpath(xpath));

			// WebElement textBox = createWebElement(strExcelInfo[0],
			// "//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[text()='"+todayDate+"']");
			Todaysdate.click();

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * EnterTomorrowsDate method enters Tomorrows Date Into text into object
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Abhijeet
	 */
	public boolean SelectTomorrowsDate() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);

			// WebElement textBox = createWebElement(strExcelInfo[0],
			// strExcelInfo[1]);
			DateFormat dateFormat = new SimpleDateFormat("d");
			Date today = new Date();
			String tomorrow = dateFormat.format(today.getTime() + (1000 * 60 * 60 * 24));

			WebElement tomorrowDate = driver.findElement(
					By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr//a[text()='" + tomorrow + "']"));

			tomorrowDate.click();

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * sendPostRestRequestAndValidate method can send POST Rest request and
	 * validates the response
	 * 
	 * @param resourcePath
	 *            This describes End point URL
	 * @param request
	 *            This describes Data
	 * @param response
	 *            This describes validate response data
	 * @param header
	 *            This describes Request Data
	 * @return Boolean value True/False based on success of this function
	 * @author Raghavendra Banavalikar
	 */

/*	public boolean sendPostRestRequestAndValidate(String resourcePath, String request, String header,
			String strResponse) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = null;
		String json;

		try {

			
			System.setProperty("http.proxyHost", "");

			System.setProperty("http.proxyPort", "");
			// Set Base URI
			// setBaseURI("REST");

			// Construct request parameters

			HashMap<String, String> requestParams = new HashMap<String, String>();

			if (!request.startsWith("{"))
				requestParams = constructRequestParam(request);

			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();

			// Construct request specification
			responseParams = constructResponseParam(strResponse);

			headers = constructHeader(header);
			
			 * requestSpecification = new
			 * RequestSpecBuilder().addParams(requestParams).setContentType(
			 * "application/json") .addHeaders(headers).build();
			 

			if (request.startsWith("{")) {
				json = given().headers(headers).body(request).post(resourcePath).asString();
			} else
				json = given().headers(headers).queryParameters(requestParams).post(resourcePath).asString();

			*//**
			 * Send Rest request and get response as json string
			 *//*

			// String json =
			// given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();
			s_objlog4j.info(json);

			*//**
			 * Construct json object to parse the response
			 *//*
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.INFO, "sendReceiveRestRequest", json);

			*//**
			 * Validate the response and log into report
			 *//*

			for (String key : responseParams.keySet()) {

				String expected = jsPath.get(key).toString().trim();
				String actual = responseParams.get(key).trim();
				if (expected.equalsIgnoreCase(actual)) {
					s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :",
							"<p>Expected : " + responseParams.get(key) + "<br> Actual : " + jsPath.get(key) + "</p>");
					bStatus = true;
				} else {
					s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail :",
							"<p>Expected : " + responseParams.get(key) + "<br> Actual : " + "<b style=\"color:red;\">"
									+ jsPath.get(key) + "</b></p>");
					bStatus = false;
				}
			}

			requestSpecification = null;
			responseSpecification = null;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;
	}
*/
	/**
	 * sendGetRestRequestAndvalidateStatusCode method Validate Status Code of
	 * rest services
	 * 
	 * @param resourcePath
	 *            is End Point URL
	 * @param response
	 *            is expected status code
	 * @return ResultSet based on success of this function
	 * 
	 * @author Abhijeet
	 */

	public boolean sendGetRestRequestAndvalidateStatusCode(String resourcePath, String response) {
		boolean bStatus = false;

		int json = 0;

		try {

			int a = Integer.parseInt(response);
			System.out.println(a);
			json = given().get(resourcePath).getStatusCode();
			System.out.println(json);
			if (json == a) {
				s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strKeywordDescription,
						"<p>Expected : " + response + "<br> Actual : " + json + "</p>");
				bStatus = true;

			}

			else {

			}

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, GlobalVariables.g_strKeywordDescription,
					"<p>Expected : " + response + "<br> Actual : " + "<b style=\"color:red;\">" + json + "</b></p>");
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * sendGetRestRequestAndvalidateNullResponse method Validate Null Response
	 * of rest services
	 * 
	 * @param resourcePath
	 *            is End Point URL
	 * @return ResultSet based on success of this function
	 * 
	 * @author Abhijeet
	 */

	public boolean sendGetRestRequestAndvalidateNullResponse(String resourcePath) {
		boolean bStatus = false;

		String json;

		try {

			json = given().baseUri(resourcePath).get().asString();

			if (json.equals("[]")) {

			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					resourcePath + " <p> " + GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					resourcePath + " <p> " + GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * ValidateNumberOfLink method Validate Number Of Link Displayed On UI
	 * 
	 * @param Str_Xpath
	 *            is Xpath need to validate link
	 * @param int_count
	 *            is number of expected link count
	 * @return ResultSet based on success of this function
	 * 
	 * @author Abhijeet
	 */

	public boolean ValidateNumberOfLink(String Str_Xpath, String int_count) {
		boolean bStatus = false;

		try {

			int expCount = Integer.parseInt(int_count);

			int actualCount = driver.findElements(By.xpath(Str_Xpath)).size();

			if (actualCount == expCount) {

				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * ValidateCurrentURL method Validate Current URL With Expected URL
	 * 
	 * @param str_expectedURL
	 *            is Expected URL
	 * 
	 * @return ResultSet based on success of this function
	 * 
	 * @author Abhijeet
	 */

	public boolean ValidateCurrentURL(String str_expectedURL) {
		boolean bStatus = false;

		String actualURL = null;
		try {

			actualURL = driver.getCurrentUrl();

			if (actualURL.equals(str_expectedURL)) {

				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						"<p>Expected : " + str_expectedURL + "<br> Actual : " + actualURL + "</p>");
			}
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					"<p>Expected : " + str_expectedURL + "<br> Actual : " + actualURL + "</p>");
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * checkIfNotSelected method Select button or link object in a page if it is
	 * unchecked
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Abhijeet
	 */
	public boolean checkIfNotSelected() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			// waitForElementToBeClickable(strExcelInfo[0],strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			// s_objlog4j.info("checked property=" +
			// buttonOrLink.getAttribute("checked"));
			try {
				Thread.sleep(2000);
				if (buttonOrLink.isSelected()) {
					s_objlog4j.info("Not clicking object");

				} else {
					buttonOrLink.click();
					s_objlog4j.info("clicking object");

				}
			} catch (Exception e) {
				s_objlog4j.info(e.getMessage());
				buttonOrLink.click();
			}
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	/**
	 * sendPostRestRequestWithStatus method Validate only Status Code with post
	 * rest services
	 * 
	 * @param resourcePath
	 *            is End Point URL
	 * @param status
	 *            is expected status code
	 * 
	 * @param request
	 *            is post data entry by user
	 * @return ResultSet based on success of this function
	 * 
	 * @author Saurav Singh Sikarwar
	 */

	public boolean sendPostRestRequestOnlyStatusValidation(String resourcePath, String request, String access_token,
			String header, String status) {
		boolean bStatus = false;
		HashMap<String, String> headers = null;
		String json;

		int js = 0;

		try {

			if (access_token.equalsIgnoreCase("YES")) {

				headers = constructHeader(header);
				int a = Integer.parseInt(status);
				js = given().headers(headers).body(request).post(resourcePath).getStatusCode();
				if (js == a) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
							"<p>Expected : " + status + "<br> Actual : " + js + "</p>");

				}

			}
			bStatus = true;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendPostRestRequestOnlyStatusValidation", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendPostRestRequestOnlyStatusValidation",
					GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * sendPostRestRequestWithStatus method Validate Status Code and services
	 * Response with post rest services
	 * 
	 * @param resourcePath
	 *            is End Point URL
	 * @param status
	 *            is expected status code
	 * 
	 * @param request
	 *            is post data entry by user
	 * @return ResultSet based on success of this function
	 * 
	 * @author Saurav Singh Sikarwar
	 */

	public boolean sendPostRestRequestStatusAndResponseValidation(String resourcePath, String request,
			String access_token, String header, String status) {
		boolean bStatus = false;
		HashMap<String, String> headers = null;
		String json;

		int js = 0;

		try {

			if (access_token.equalsIgnoreCase("YES")) {

				headers = constructHeader(header);
				int a = Integer.parseInt(status);
				js = given().headers(headers).body(request).post(resourcePath).getStatusCode();
				if (js == a) {
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
							"<p>Expected : " + status + "<br> Actual : " + js + "</p>");

				}

			}

		
			// Construct request parameters

			HashMap<String, String> requestParams = new HashMap<String, String>();

			if (!request.startsWith("{"))
				requestParams = constructRequestParam(request);

			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();

			if (access_token.equalsIgnoreCase("YES")) {

				// Construct request specification

				headers = constructHeader(header);

				if (request.startsWith("{")) {
					json = given().headers(headers).body(request).post(resourcePath).asString();
				} else
					json = given().headers(headers).queryParameters(requestParams).post(resourcePath).asString();

			} else {

				json = given().queryParameters(requestParams).post(resourcePath).asString();
			}

			s_objlog4j.info(json);

			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.PASS, "sendPostRestRequestStatusAndResponseValidation", json);

			//requestSpecification = null;
			//responseSpecification = null;

			bStatus = true;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendPostRestRequestStatusAndResponseValidation",
					e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendPostRestRequestStatusAndResponseValidation",
					GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * sendGetRestRequestWithToken method can send Get Rest request and
	 * validates the response
	 * 
	 * @param resourcePath
	 *            This describes End point URL
	 * @param response
	 *            This describes validate response data
	 * @return Boolean value True/False based on success of this function
	 * @author Raghavendra Banavalikar
	 */
	public boolean sendGetRestRequestWithToken(String resourcePath, String response) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = new HashMap<String, String>();
		String json;

		try {
			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();
			if (!response.isEmpty()) {
				responseParams = constructResponseParam(response);
			}
			headers.put(AUTHORIZATION, BEARER + " " + GlobalVariables.g_strAccessToken);
			headers.put(X_IBM_CLIENT_ID, GlobalVariables.g_strClientId);

			json = given().headers(headers).get(resourcePath).asString();

			// String json =
			// given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();
			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.INFO, "sendReceiveRestRequest", json);

			/**
			 * Validate the response and log into report
			 */
			for (String key : responseParams.keySet()) {
				boolean bFlag = false;
				String strExpected = jsPath.get(key);

				String actual = responseParams.get(key);

				if (strExpected.equalsIgnoreCase(actual)) {
					s_childExtentTest.log(LogStatus.INFO, "Expectation Pass :",
							"<p>Expected : " + strExpected + "<br> Actual : " + actual + "</p>");
					bStatus = true;

				} else {
					s_childExtentTest.log(LogStatus.ERROR, "Expectation Fail :", "<p>Expected : " + strExpected
							+ "<br> Actual : " + "<b style=\"color:red;\">" + actual + "</b></p>");
					bStatus = false;
				}
			}

			//requestSpecification = null;
			//responseSpecification = null;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * sendGetRestRequestWithTokenAuthentication method can send Get Rest
	 * request and validates the response
	 * 
	 * @param resourcePath
	 *            This describes End point URL
	 * @param response
	 *            This describes validate response data
	 * @return Boolean value True/False based on success of this function
	 * @author Saurav Singh Sikarwar
	 */

	public boolean sendGetRestRequestWithTokenAuthentication(String resourcePath, String response) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = new HashMap<String, String>();
		String json;

		try {
			// Construct response parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();
			if (!response.isEmpty()) {
				responseParams = constructResponseParam(response);
			}

			headers.put(AUTHORIZATION, BEARER + " " + GlobalVariables.g_strAccessToken);
			headers.put(X_IBM_CLIENT_ID, GlobalVariables.g_strClientId);

			json = given().headers(headers).get(resourcePath).asString();
			int statuscode = given().headers(headers).get(resourcePath).getStatusCode();

			// if(statuscode==401 || statuscode==402 || statuscode==403 ||
			// statuscode==404){
			//
			// s_objextendTest.log(LogStatus.ERROR,
			// "sendGetRestRequestWithTokenAuthentication", "Unable to proceed
			// as status code found ::"+statuscode);
			// }
			// else
			// {

			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.PASS, "sendGetRestRequestWithTokenAuthentication", json);

			/**
			 * Validate the response and log into report
			 */
			for (String key : responseParams.keySet()) {

				boolean bFlag = false;
				String strExpected[] = jsPath.get(key).toString().split(",");

				String expected = "";

				String actual = responseParams.get(key);
				for (int i = 0; i < strExpected.length; i++) {
					expected = strExpected[i];
					expected = expected.replace("[", "").trim();
					expected = expected.replace("]", "").trim();
					if (expected.equalsIgnoreCase(actual)) {
						s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :",
								"<p>Expected : " + expected + "<br> Actual : " + actual + "</p>");
						bStatus = true;
						bFlag = true;
						break;
					}
				}
				if (bFlag == false) {
					s_childExtentTest.log(LogStatus.FAIL, "Expectation Fail :", "<p>Expected : " + expected
							+ "<br> Actual : " + "<b style=\"color:red;\">" + actual + "</b></p>");
					bStatus = false;
				}

			}
			// }

			//requestSpecification = null;
			//responseSpecification = null;

		} catch (AssertionError e) {
			s_objextendTest.log(LogStatus.ERROR, "sendGetRestRequestWithTokenAuthentication", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_objextendTest.log(LogStatus.ERROR, "sendGetRestRequestWithTokenAuthentication",
					GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * sendPostRestRequestWithTokenAuthentication method can send Post Rest
	 * request and validates the response
	 * 
	 * @param resourcePath
	 *            This describes End point URL
	 * @param response
	 *            This describes validate response data
	 * @return Boolean value True/False based on success of this function
	 * @author Saurav Singh Sikarwar
	 */

	public boolean sendPostRestRequestWithTokenAuthentication(String resourcePath, String response) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = new HashMap<String, String>();
		String json;

		try {

			
			System.setProperty("http.proxyHost","");

			System.setProperty("http.proxyPort", "");

			Hashtable<String, String> responseParams = new Hashtable<String, String>();
			if (!response.isEmpty()) {
				responseParams = constructResponseParam(response);
			}

			headers.put(AUTHORIZATION, BEARER + " " + GlobalVariables.g_strAccessToken);
			headers.put(X_IBM_CLIENT_ID, GlobalVariables.g_strClientId);

			json = given().headers(headers).post(resourcePath).asString();

			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			s_childExtentTest.log(LogStatus.PASS, "sendPostRestRequestWithTokenAuthentication", json);

			/**
			 * Validate the response and log into report
			 */
			for (String key : responseParams.keySet()) {

				boolean bFlag = false;
				String strExpected[] = jsPath.get(key).toString().split(",");

				String expected = "";

				String actual = responseParams.get(key);
				for (int i = 0; i < strExpected.length; i++) {
					expected = strExpected[i];
					expected = expected.replace("[", "").trim();
					expected = expected.replace("]", "").trim();
					if (expected.equalsIgnoreCase(actual)) {
						s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :",
								"<p>Expected : " + expected + "<br> Actual : " + actual + "</p>");
						bStatus = true;
						bFlag = true;
						break;
					}
				}
				if (bFlag == false) {
					s_childExtentTest.log(LogStatus.FAIL, "Expectation Fail :", "<p>Expected : " + expected
							+ "<br> Actual : " + "<b style=\"color:red;\">" + actual + "</b></p>");
					bStatus = false;
				}
			}

		//	requestSpecification = null;
			//responseSpecification = null;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * sendReceiveSoapRequest method can send GET/POST Rest request and
	 * validates the response {resourcePath=URI, Request parmeters, header means
	 * o/p type, result validation }
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Charan
	 */

	public boolean sendGetRestRequestWithValidateStatusCodeResponse(String resourcePath, String request, String header,
			String inputKey, String StatusCode) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = null;
		String json;
		int ActualCode;
		try {

		
			// Construct request parameters
			HashMap<String, String> requestParams = new HashMap<String, String>();
			if (request.startsWith("{"))
				requestParams = constructRequestParam(request);

			// Construct request parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();
			responseParams = constructResponseParam(inputKey);

			headers = constructHeader(header);
			if (request.startsWith("{")) {
				json = given().headers(headers).body(request).get(resourcePath).asString();
			} else
				json = given().headers(headers).queryParameters(requestParams).get(resourcePath).asString();

			json = "{\"RootElement\":" + json + "}";

			ActualCode = given().headers(headers).queryParameters(requestParams).get(resourcePath).getStatusCode();

			int IstatusCode = Integer.parseInt(StatusCode);

			System.out.println("ActualCode" + ActualCode);
			if (ActualCode == IstatusCode) {
				s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :",
						"<p>Expected Status Code: " + IstatusCode + "<br> Actual Status Code: " + ActualCode + "</p>");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, "Expectation Fail :",
						"<p>Expected Status Code: " + IstatusCode + "<br> Actual Status Code: " + ActualCode + "</p>");
			}

			/**
			 * Send Rest request and get response as json string
			 */

			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			// JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			// s_objextendTest.log(LogStatus.INFO, "sendRestRequest", json);
			JSONObject jsPath = new JSONObject(json);
			String xml = XML.toString(jsPath);
			s_childExtentTest.log(LogStatus.INFO, "ReceiveRestResponse", json);
			System.out.println("XML is:" + xml);

			DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dfactory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xml)));
			for (Map.Entry<String, String> entry : responseParams.entrySet()) {
				XPathExpression xpathExpression = XPathFactory.newInstance().newXPath().compile("//" + entry.getKey());
				String status = xpathExpression.evaluate(doc).toString();
				System.out.println(status);
				if (entry.getValue().trim().toString().contains(status.trim())) {
					s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :", "<p>" + entry.getKey() + ": "
							+ entry.getValue().trim().toString() + "<br>" + entry.getKey() + ": " + status + "</p>");
					bStatus = true;
				} else {
					s_childExtentTest.log(LogStatus.FAIL, "Expectation Fail :",
							"<p>" + entry.getKey() + ": " + entry.getValue().trim().toString() + "<br>" + entry.getKey()
									+ ": " + "<b style=\"color:red;\">" + status + "</b></p>");
					bStatus = false;
				}
			}
		//	requestSpecification = null;
		//	responseSpecification = null;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * sendPostRestRequest method can send GET/POST Rest request and validates
	 * the response with multiple inputs
	 * 
	 * @return Boolean value True/False based on success of this function
	 * @author Nains
	 */

	public boolean sendPostRestRequestWithValidateStatusCodeResponse(String resourcePath, String request, String header,
			String inputKey, String StatusCode) {
		boolean bStatus = false;
		// String header = null;
		HashMap<String, String> headers = null;
		String json;
		int ActualCode;
		try {

			

			// Construct request parameters
			HashMap<String, String> requestParams = new HashMap<String, String>();
			if (request.startsWith("{"))
				requestParams = constructRequestParam(request);

			// Construct request parameters
			Hashtable<String, String> responseParams = new Hashtable<String, String>();
			responseParams = constructResponseParam(inputKey);

			headers = constructHeader(header);
			if (request.startsWith("{")) {
				json = given().headers(headers).body(request).post(resourcePath).asString();
			} else
				json = given().headers(headers).queryParameters(requestParams).post(resourcePath).asString();

			json = "{\"RootElement\":" + json + "}";

			ActualCode = given().headers(headers).queryParameters(requestParams).post(resourcePath).getStatusCode();

			int IstatusCode = Integer.parseInt(StatusCode);

			System.out.println("ActualCode" + ActualCode);
			if (ActualCode == IstatusCode) {
				s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :",
						"<p>Expected Status Code: " + IstatusCode + "<br> Actual Status Code: " + ActualCode + "</p>");
			} else {
				s_childExtentTest.log(LogStatus.FAIL, "Expectation Fail :",
						"<p>Expected Status Code: " + IstatusCode + "<br> Actual Status Code: " + ActualCode + "</p>");
			}

			/**
			 * Send Rest request and post response as json string
			 */

			s_objlog4j.info(json);

			/**
			 * Construct json object to parse the response
			 */
			// JsonPath jsPath = new JsonPath(json);
			// XmlPath jsPath = new XmlPath(json);
			// s_objextendTest.log(LogStatus.INFO, "sendRestRequest", json);
			JSONObject jsPath = new JSONObject(json);
			String xml = XML.toString(jsPath);
			s_childExtentTest.log(LogStatus.INFO, "ReceiveRestResponse", json);
			System.out.println("XML is:" + xml);

			DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dfactory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xml)));
			for (Map.Entry<String, String> entry : responseParams.entrySet()) {
				XPathExpression xpathExpression = XPathFactory.newInstance().newXPath().compile("//" + entry.getKey());
				String status = xpathExpression.evaluate(doc).toString();
				System.out.println(status);
				if (entry.getValue().trim().toString().contains(status.trim())) {
					s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :", "<p>" + entry.getKey() + ": "
							+ entry.getValue().trim().toString() + "<br>" + entry.getKey() + ": " + status + "</p>");
					bStatus = true;
				} else {
					s_childExtentTest.log(LogStatus.FAIL, "Expectation Fail :",
							"<p>" + entry.getKey() + ": " + entry.getValue().trim().toString() + "<br>" + entry.getKey()
									+ ": " + "<b style=\"color:red;\">" + status + "</b></p>");
					bStatus = false;
				}
			}
			//requestSpecification = null;
		//	responseSpecification = null;

		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", e.getLocalizedMessage());
			e.printStackTrace();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "sendReceiveRestRequest", GlobalVariables.g_strStepDescription);
			e.printStackTrace();
		}

		return bStatus;
	}

	/**
	 * validateUserFromTextFile method verifies text from two Objects
	 * 
	 * @param1 userRecordxpath This describes Xpath of One user profile value
	 *
	 * @return Boolean value True/False based on success of this function
	 * @author Guru
	 */

	public boolean validateUserFromTextFile(String userRecordxpath, String validatingValue) {

		boolean bStatus = false;
		String sFilePath = null;
		FileReader fr = null;
		BufferedReader txtReader = null;
		String files;
		String strUserRocord = null;
		String currentDate = new SimpleDateFormat("MM-dd-YYYY").format(Calendar.getInstance().getTime());

		File folder = new File(GlobalVariables.g_strDownloadFilePath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(currentDate + ",.txt")) {
					sFilePath = GlobalVariables.g_strDownloadFilePath + files;
					break;
				}
			}
		}
		strUserRocord = driver.findElement(By.xpath(userRecordxpath)).getText().trim();
		try {
			String sCurrentLine;
			fr = new FileReader(sFilePath);
			txtReader = new BufferedReader(fr);

			while ((sCurrentLine = txtReader.readLine()) != null) {
				System.out.println(sCurrentLine);

				if (sCurrentLine.contains(strUserRocord)) {
					bStatus = true;
					break;
				}
				/*
				 * else bStatus = false;
				 */
			}
			if (bStatus = true)
				s_childExtentTest.log(LogStatus.PASS, "Verify " + validatingValue + " : ",
						strUserRocord + " " + " is validated");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " " + " is not validated");
			e.printStackTrace();
		} finally {
			try {
				if (txtReader != null)
					txtReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return bStatus;
	}

	/**
	 * validateRecordsFromTextFiles method verifies text from two Objects
	 * 
	 * @param1 recordsHeder This describes Header of section
	 * @param2 recordsOption This describes Option Value
	 * @param3 strFromDate This describes from Date
	 * @return Boolean value True/False based on success of this function
	 * @author Guru
	 */

	public boolean validateRecordsFromTextFiles(String recordsHeder, String recordsOption, String strFromDate) {
		boolean bStatus = false;
		String sFilePath = null;
		FileReader fr = null;
		BufferedReader txtReader = null;
		String files;
		String fromDate = null;
		String currentDate = new SimpleDateFormat("MM-dd-YYYY").format(Calendar.getInstance().getTime());
		File folder = new File(GlobalVariables.g_strDownloadFilePath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(currentDate + ",.txt")) {
					sFilePath = GlobalVariables.g_strDownloadFilePath + files;
					break;
				}
			}
		}
		File file = new File(sFilePath);
		try {
			String sCurrentLine;
			fr = new FileReader(sFilePath);
			txtReader = new BufferedReader(fr);
			while ((sCurrentLine = txtReader.readLine()) != null) {
				if (sCurrentLine.contains(recordsHeder)) {
					sCurrentLine = txtReader.readLine();
					sCurrentLine = txtReader.readLine();
					sCurrentLine = txtReader.readLine();
					sCurrentLine = txtReader.readLine();
					fromDate = sCurrentLine.substring(62, 72);
					System.out.println(fromDate);
					if (strFromDate.compareTo(fromDate) <= 0 && sCurrentLine.contains(recordsOption)) {
						bStatus = true;
						break;
					}
					/*
					 * else bStatus=false;
					 */
				}
				/*
				 * else bStatus=false;
				 */
			}
			if (bStatus = true)
				s_childExtentTest.log(LogStatus.PASS, "Verify First Record : ",
						recordsOption + " and " + fromDate + " " + " are validated");
			file.deleteOnExit();
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " " + " is not validated");
			e.printStackTrace();
		} finally {
			try {
				if (txtReader != null)
					txtReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return bStatus;
	}

	/**
	 * SelectItemFromDropDownUsingXpath method selects an item from dropdown
	 * using its xpath after clicking dropdown
	 * 
	 * @param m_strItemXpath
	 *            Dropdown item xpath to be selected
	 * @return Boolean value True/False based on success of this function
	 * @author Sarath Gorantla
	 */
	public boolean SelectItemFromDropDownlistUsingXpath(String m_strItemXpath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			// element.click();
			if (m_strItemXpath.endsWith("]")) {
				waitForPresenceOfElement("EVALUATEXPATH", m_strItemXpath);
				driver.findElement(By.xpath(m_strItemXpath)).click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is selected");
			} else {
				waitForPresenceOfElement("EVALUATEXPATH", m_strItemXpath + GlobalVariables.UniqueValue + "']");
				driver.findElement(By.xpath(m_strItemXpath + GlobalVariables.UniqueValue + "']")).click();
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is selected");
			}
			bStatus = true;
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not selected");
			e.printStackTrace();
		}
		return bStatus;

	}

	public boolean sendGetReststatuscode(String resourcePath, String response) {
		boolean bStatus = false;
		try {

			

			// System.out.println("code:"+given().get(resourcePath).getStatusCode());
			if (given().get(resourcePath).getStatusCode() == HTTP_OK) {
				s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :", "<p>Expected : " + HTTP_OK
						+ "<br> Actual : " + given().get(resourcePath).getStatusCode() + "</p>");

			}

			else if (given().get(resourcePath).getStatusCode() == HTTP_servererror) {
				s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :", "<p>Expected : " + HTTP_servererror
						+ "<br> Actual : " + given().get(resourcePath).getStatusCode() + "</b></p>");
				bStatus = false;
			} else if (given().get(resourcePath).getStatusCode() == HTTP_servererror1) {
				s_childExtentTest.log(LogStatus.PASS, "Expectation Pass :", "<p>Expected : " + HTTP_servererror1
						+ "<br> Actual : " + given().get(resourcePath).getStatusCode() + "</b></p>");
				bStatus = false;
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is unsuccessful");

			}
		} catch (AssertionError e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}

		return bStatus;

	}

	//// New Functions

	public boolean verifyDate(String text) { // MM-dd-yyyy##0##value

		String[] strExcelInfo = null;
		boolean bStatus = false;

		String strText = String.valueOf("");
		int noOfDays = 0;
		String strDate = String.valueOf("");
		List<String> inputlist = new ArrayList<String>();

		for (String retval : text.split(";")) {
			inputlist.add(retval);
		}
		try {
			SimpleDateFormat pattern = new SimpleDateFormat(inputlist.get(0));
			Calendar calender = Calendar.getInstance();
			calender.setTime(new Date());
			noOfDays = Integer.parseInt(inputlist.get(1));
			calender.add(Calendar.DATE, noOfDays);
			strDate = pattern.format(calender.getTime());

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			if (inputlist.size() == 2) {
				strText = element.getText();
			} else {
				strText = element.getAttribute(inputlist.get(2));
			}
			String strLogTxt = " Expected: " + strDate + ", Actual: " + strText;
			System.out.println(strLogTxt);

			if (strDate.equals(strText)) { //
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + strLogTxt);
			} else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + strLogTxt);
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " is NOT Successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean verifyFieldTxt(String request) {
		String[] strExcelInfo = null;
		boolean bStatus = false;

		try {

			String[] reqParam = request.split(";");
			HashMap<String, String> requestParams = new HashMap<String, String>();

			for (String param : reqParam) {
				String[] keyVal = param.split(":");
				requestParams.put(keyVal[0], keyVal[1]);
			}

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			if (requestParams.get("value").equalsIgnoreCase(element.getText())) {
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS,
						GlobalVariables.g_strKeywordDescription + " Expected value at " + requestParams.get("name")
								+ " is - " + requestParams.get("value") + " :: " + " Actual value at "
								+ requestParams.get("name") + " is - " + element.getText());

			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription + " is NOT Successful");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean getText() {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {

			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textBox = createWebElement(strExcelInfo[0], strExcelInfo[1]);

			String Text = textBox.getText();
			bStatus = true;

			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " , Captured Text :: " + Text);

		}

		catch (Exception e) {

			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	
    public boolean Given() {
        s_childExtentTest.log(LogStatus.PASS, " ");
        return true;
    }
    
    public boolean switchToWebview() throws Exception {
        boolean bStatus = false;
        Set<String> contexts = ((AppiumDriver) GlobalVariables.driver).getContextHandles();
        for (String context : contexts) {
            s_objlog4j.info(context);
            if (context.indexOf("WEBVIEW") != -1) {
                ((AppiumDriver) GlobalVariables.driver).context(context);
                s_objlog4j.info("Switched to webview context");
                MedWait();
                bStatus = true;
                break;
            }
        }
        return bStatus;

    }

public boolean CalculationOnHazardField(String controlValue, String hazardValue) throws Exception {
		boolean bStatus = true;
		String[] strExcelInfo = null;
		strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
				GlobalVariables.g_strLogicalName);
		waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
		WebElement obj = createWebElement(strExcelInfo[0], strExcelInfo[1]);
		String getValue = obj.getAttribute("value");
		int parse1 = Integer.parseInt(controlValue);
		int parse2 = Integer.parseInt(hazardValue);
		int division = parse1 / parse2;
		String parseToString = Integer.toString(division);
		if (parseToString.equals(getValue)) {
			s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} else {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
		}
		return bStatus;
	}

public boolean verifyThePositionOfCommaOnTextField(String NumberSize) throws Exception {
		boolean bStatus = true;
		String[] strExcelInfo = null;
		int commaPosition = 0;
		strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
				GlobalVariables.g_strLogicalName);
		waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
		WebElement obj = createWebElement(strExcelInfo[0], strExcelInfo[1]);
		String getValue = obj.getAttribute("value");
		String replaceDollar = getValue.replace("$", "");
		char lengthOfText[] = replaceDollar.toCharArray();
		int numberSize=Integer.parseInt(NumberSize);
		for (int i = 0; i <= lengthOfText.length - 1; i++) {
			if (lengthOfText[i] == ',') {
				commaPosition = i;
				if (lengthOfText.length == numberSize) {
					int loc1 = 3;
					if (commaPosition == loc1) {
                                           System.out.println(", found at location " + commaPosition);
						s_childExtentTest.log(LogStatus.INFO, "GlobalVariables.g_strStepDescription.",
								gVar.g_strStepDescription + "Comma Found at Position" + commaPosition);
					}
				}
				else if (lengthOfText.length == numberSize) {
					int loc1 = 3, loc2 = 7;
					if (commaPosition == loc1 || commaPosition == loc2) {
						System.out.println(", found at location " + commaPosition);
						s_childExtentTest.log(LogStatus.INFO, "GlobalVariables.g_strStepDescription.",
								gVar.g_strStepDescription + "Comma Found at Position" + commaPosition);
					}
				}
				else if (lengthOfText.length == numberSize) {
					int loc1 = 1, loc2 = 5;
					if (commaPosition == loc1 || commaPosition == loc2) {
						System.out.println(", found at location " + commaPosition);
						s_childExtentTest.log(LogStatus.INFO, "GlobalVariables.g_strStepDescription.",
								gVar.g_strStepDescription + "Comma Found at Position" + commaPosition);
					}
				}
				
				else {
					s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is unsuccessful");
				}
			}
			
		}
		return bStatus;
	}
	public boolean SelectItemThroughGlobalVariable(String m_locatorValue) throws Exception {
		boolean bStatus = false;
		try {
			List<WebElement> List =driver.findElements(By.xpath(m_locatorValue));
			for (WebElement option : List) {
				if (option.getText().equalsIgnoreCase(GlobalVariables.UniqueValue)) {
					option.click();
					bStatus = true;
					s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
					break;
				}
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}	
	
	public boolean saveToGlobalThroughFieldValue(String strObjectID) {
		boolean bStatus = false;
		GlobalVariables.UniqueValue = driver.findElement(By.xpath(strObjectID)).getAttribute("value");
		s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
				GlobalVariables.g_strKeywordDescription + " is successful");
		return true;
	}

	public boolean ValidateSelectedDropdownDefaultValue(String Item) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement dropdown = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			Select select = new Select(dropdown);
			WebElement getSelectedValue=select.getFirstSelectedOption();
			String getSelectedValueText=getSelectedValue.getText();
			if(getSelectedValueText.equalsIgnoreCase(Item)){
			       bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is selected");
			}} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not selected");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean ValidateTextThroughGlobalVaribale() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textbox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			String text=textbox.getText();
			if(text.equals(GlobalVariables.UniqueValue)){
			       bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " Is Matched");
			}} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is not Matched");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean mouseOverThroughJS() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";
			((JavascriptExecutor) driver).executeScript(strJavaScript, element);
			bStatus = true;

			s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is UnSuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean validateDescendingDateSortingUsingFormat(String m_locatorValue) {
		boolean sorted = true;
		try {
			List<WebElement> webElements = driver.findElements(By.xpath(m_locatorValue));
			for (int i = 1; i < webElements.size()-1; i++) {
				SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
				SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
				String str1 = webElements.get(i - 1).getText().toString();
				String str2 = webElements.get(i).getText().toString();
				Date date1 = new Date();
				date1 = inputFormat.parse(str1);
				String outPutFormat1 = outputFormat.format(date1);
				Date date2 = new Date();
				date2 = inputFormat.parse(str2);
				String outPutFormat2 = outputFormat.format(date2);
				if (outPutFormat1.compareTo(outPutFormat2) < 0)
					sorted = false;
			}
			if (sorted) {
				s_childExtentTest.log(LogStatus.INFO, "validateDescendingDateSorting.",
						gVar.g_strStepDescription + " is successful");
			} else {
				s_childExtentTest.log(LogStatus.ERROR, "validateDescendingDateSorting",
						gVar.g_strStepDescription + " is failed");
			}
		} catch (Exception e) {
			sorted = false;
			s_childExtentTest.log(LogStatus.ERROR, "validateDescendingDateSorting",
					gVar.g_strStepDescription + " is failed due to exception thrown");
			e.printStackTrace();
		}
		return sorted;
	}
	
	public boolean ValidateEficacyTable(String xpath, String value) throws Exception {
		boolean bStatus = false;
		String getText;
		int a = 1;
		try {
			List<WebElement> List = driver.findElements(By.xpath(xpath));
			for (int i = 0; i <= List.size() - 1; i++) {

				if (List.get(i).getText().toString() != null
						&& List.get(i).getText().toString() !="Computed") {
					bStatus = true;
					MinWait();
				}
				if (i == a) {
					getText = List.get(i).getText();
					Assert.assertEquals(getText, value);
					s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + "Validated Tabel Successfully ");
				}
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.ERROR, "validateDescendingDateSorting",
					gVar.g_strStepDescription + " is failed due to exception thrown");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean VerifyEntireColoumnText(String locatorValue, String CellValue) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			List<WebElement> List = driver.findElements(By.xpath(locatorValue));
			for (WebElement lis : List) {
				if (lis.getText().equalsIgnoreCase(CellValue)) {
					bStatus = true;
					MinWait();
					Assert.assertEquals(lis.getText(), CellValue);
					s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
							GlobalVariables.g_strKeywordDescription + lis.getText());
				}
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "Value Not Matched");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean VerifyStatusColumn(String RowPosition, String DropdownLocator, String CurrentStatus,
			String ThirdDropdownValue) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		int rowSize = 2;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement ViewAsCompleteStatus = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement row = driver.findElement(By.xpath(RowPosition));
			WebElement ViewAsReviewStatus = driver.findElement(By.xpath(CurrentStatus));
			if (row.isDisplayed()) {
				row.click();
				row.click();
				MinWait();
			} else {
				s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription + "Row Not Found"
						+ GlobalVariables.g_strKeywordDescription + " is Un Successful");
			}
			for (int i = 1; i <= rowSize; i++) {
				if (i == 2) {
					row.click();
					row.click();
					MinWait();
					driver.findElement(By.xpath(ThirdDropdownValue)).click();
					MedWait();
					ViewAsCompleteStatus.isDisplayed();
					break;
				}
				List<WebElement> dropdownvalues = driver.findElements(By.xpath(DropdownLocator));
				for (WebElement Values : dropdownvalues) {
					String statusDropDownvalues = Values.getText();
					if (statusDropDownvalues.equals("In Progress") || statusDropDownvalues.equals("In Review")
							|| statusDropDownvalues.equals("Complete")) {
						if (Values.getText().toString().equals("In Review")) {
							MedWait();
							Values.click();
							ViewAsReviewStatus.isDisplayed();
							break;
						} else if (Values.getText().toString().equals("Completed")) {
							MinWait();
							Values.click();
							ViewAsReviewStatus.isDisplayed();
							break;
						}
						s_childExtentTest.log(LogStatus.INFO,
								GlobalVariables.g_strStepDescription
										+ "Drop Down Values Validations and updating  the status",
								GlobalVariables.g_strKeywordDescription + " is successful");
					} else {
						s_childExtentTest.log(LogStatus.INFO,
								GlobalVariables.g_strStepDescription + "Drop Down Values not matched"
										+ GlobalVariables.g_strKeywordDescription + " Un successful");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean ValidateLengthOfTheTextbox(String SizeNumber) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement textbox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			int numberSize=Integer.parseInt(SizeNumber);
			String text=textbox.getAttribute("value");
			int getsize=text.length();
			if(getsize == numberSize ){
			       bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "Length Size Is" +getsize);
			}} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription);
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean clickAndHold() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			WebElement element = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			actions.clickAndHold(element);
			bStatus = true;
			s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is Unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean validateAscendingDateSortingUsingFormat(String m_locatorValue) {
		boolean sorted = true;
		try {
			List<WebElement> webElements = driver.findElements(By.xpath(m_locatorValue));
			for (int i = 1; i < webElements.size()-1; i++) {
				SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
				SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
				/*Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DATE, -1);*/
				String str1 = webElements.get(i - 1).getText().toString();
				String str2 = webElements.get(i).getText().toString();
				Date date1 = new Date();
				date1 = inputFormat.parse(str1);
				String outPutFormat1 = outputFormat.format(date1);
				Date date2 = new Date();
				date2 = inputFormat.parse(str2);
				String outPutFormat2 = outputFormat.format(date2);
				if (outPutFormat1.compareTo(outPutFormat2) > 0)
					sorted = false;
			}
			if (sorted) {
				s_childExtentTest.log(LogStatus.INFO, "validateAscendingSorting.",
						gVar.g_strStepDescription + " is successful");
			} else {
				s_childExtentTest.log(LogStatus.ERROR, "validateAscendingSorting",
						gVar.g_strStepDescription + " is failed");
			}
		} catch (Exception e) {
			sorted = false;
			s_childExtentTest.log(LogStatus.FAIL, "validateAscendingSorting",
					gVar.g_strStepDescription + " is failed due to exception thrown");
			e.printStackTrace();
		}
		return sorted;
	}

	
	public boolean scrollDown(String locatorValue) throws Exception {
		boolean bStatus = true;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			List<WebElement> List = driver.findElements(By.xpath(locatorValue));
			int size = List.size();
			if (size > 9) {
				WebElement scrollClick = createWebElement(strExcelInfo[0], strExcelInfo[1]);
				int i = 1;
				while (i < 10) {
					scrollClick.click();
					i++;
				}
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + "Scroll Down is Successfully");
			} else {
				s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + "Scroll Bar Not Available");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "Failed due to Exception Thrown");
			e.printStackTrace();
		}
		return bStatus;
	}
	public boolean waitForCSV(String xpath) throws Exception {
		boolean bStatus = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			/*driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			 driver.manage().timeouts().setScriptTimeout(5,TimeUnit.MINUTES);
			 driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);*/
			Refresh();
			if(driver.findElement(By.xpath(xpath)).isDisplayed()){
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + "CSV Export Button is Enabled");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + "CSV File is Not Generating after 5 minutes also");
			e.printStackTrace();
		}
		return bStatus;
	
}
	
	public boolean MedWaitGlobally() throws Exception {
		boolean bStatus = false;
		try {
			Thread.sleep(Long.parseLong(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_intLongWait")));
			bStatus = true;
			//s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,	GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean MedWaitGlobally2() throws Exception {
		boolean bStatus = false;
		try {
			Thread.sleep(Long.parseLong(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_intLongWait")));
			bStatus = true;
			//s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,	GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean isCSVGenerating(String strXPath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			if (driver.findElement(By.xpath(strXPath)).isDisplayed()) {
				WebElement button = createWebElement("EVALUATEXPATH", strXPath);
				button.click();
				MedWait();
				bStatus = true;
				GlobalVariables.g_captureScreenShot = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}
		} catch (Exception e) {
			GlobalVariables.g_captureScreenShot = true;
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful after 5 Minutes Also");
		}
		return true;
	}
	
	public boolean SelectItemFromOptions(String Item, String xpath) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			List<WebElement> List = driver.findElements(By.xpath(xpath));
			for (WebElement option : List) {
				if (Item.equals(option.getText())) {
					option.click();
					bStatus = true;
					s_childExtentTest.log(LogStatus.INFO, GlobalVariables.g_strKeywordDescription,
							GlobalVariables.g_strKeywordDescription + " is successful");
					break;
				}
			}

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean isSelected() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			bStatus = buttonOrLink.isSelected();
			if (bStatus == false) {
				throw new Exception();
			} else {
				GlobalVariables.g_captureScreenShot = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();

		}
		return bStatus;
	}

	
	
	public boolean BackSpace() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.BACK_SPACE).build().perform();
			Thread.sleep(1000);
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean DeleteMultipleTimes(String locator) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
			waitForElementToBeClickable(strExcelInfo[0], strExcelInfo[1]);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			

			while (buttonOrLink.isDisplayed()) {
				buttonOrLink.click();
				driver.findElement(By.xpath(locator)).click();
				MinWait();
			}
			bStatus = true;
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");

		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
			// e.printStackTrace();
			bStatus = true;
		}
		return bStatus;
	}
	
	
	public boolean SplitString() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			  strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
	                    GlobalVariables.g_strLogicalName);
	            waitForPresenceAndVisibilityOfElement(strExcelInfo[0], strExcelInfo[1]);
	            WebElement textbox = createWebElement(strExcelInfo[0], strExcelInfo[1]);
	            String ValueOne=textbox.getText();  
	            String split[]=ValueOne.split(" ");
	            GlobalVariables.g_CreditScore=split[0];
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is successful");
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean SelectValueIfDropdownExist(String strXPath, String dropdownValue) throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			if (driver.findElement(By.xpath(strXPath)).isDisplayed()) {
				WebElement element=driver.findElement(By.xpath(strXPath));
				Select select = new Select(element);
				select.selectByVisibleText(dropdownValue);
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + dropdownValue,
						GlobalVariables.g_strKeywordDescription + " is successful");
				bStatus = true;
			}
			else{
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + dropdownValue,
						GlobalVariables.g_strKeywordDescription + " The Field Is Not available for This Sceanrio");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription + " : " + dropdownValue,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			
		}
		return true;
	}
	public boolean isNotSelected() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			bStatus = buttonOrLink.isSelected();
			if (bStatus == true) {
				throw new Exception();
			} else {
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
				bStatus = true;
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();
		}
		return bStatus;
	}
	
	public boolean CssValidations(String attributeName, String expectedValue) throws Exception {
		boolean bStatus = false;
		String getCSSValue;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			WebElement TextField = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			if (attributeName.equalsIgnoreCase("Color")) {
				getCSSValue = TextField.getCssValue("color");
				String hexcolor = Color.fromString(getCSSValue).asHex();
				hexcolor = hexcolor.substring(1);
				Assert.assertEquals(hexcolor, expectedValue);
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " " + "is matching successfully" + " "
								+ "Actual Text is -  " + "< -" + hexcolor + "->" + " " + "Expected Text is -  " + "<-"
								+ expectedValue + " ->");
			} else if (attributeName.equalsIgnoreCase("width")) {
				getCSSValue = TextField.getCssValue("border-bottom-width");
				Assert.assertEquals(getCSSValue, expectedValue);
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " " + "is matching successfully" + " "
								+ "Actual Text is -  " + "< -" + getCSSValue + "->" + " " + "Expected Text is -  "
								+ "<-" + expectedValue + " ->");
			} else if (attributeName.equalsIgnoreCase("height")) {
				Dimension dim = TextField.getSize();
				String heightWidth = dim.toString();
				String dimension[] = heightWidth.split(",");
				int size = dim.height;
				String Height = String.valueOf(size);
				Assert.assertEquals(Height, expectedValue);
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " " + "is matching successfully" + " "
								+ "Actual Text is -  " + "< -" + Height + "->" + " " + "Expected Text is -  "
								+ "<-" + expectedValue + " ->");
			} else if (attributeName.equalsIgnoreCase("fontsize")) {
				getCSSValue = TextField.getCssValue("font-size");
				Assert.assertEquals(getCSSValue, expectedValue);
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " " + "is matching successfully" + " "
								+ "Actual Text is -  " + "< -" + getCSSValue + "->" + " " + "Expected Text is -  "
								+ "<-" + expectedValue + " ->");
			} else if (attributeName.equalsIgnoreCase("bordersize")) {
				getCSSValue = TextField.getCssValue("border-bottom-width");
				Assert.assertEquals(getCSSValue, expectedValue);
				bStatus = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " " + "is matching successfully" + " "
								+ "Actual Text is -  " + "< -" + getCSSValue + "->" + " " + "Expected Text is -  "
								+ "<-" + expectedValue + " ->");
			}

			else {
				s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strStepDescription,
						GlobalVariables.g_strKeywordDescription + " is unsuccessful" + "");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL.ERROR, GlobalVariables.g_strStepDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful due to" + e.getMessage() + "Exception");
			e.printStackTrace();
		}
		return bStatus;
	}

	public boolean CertainWait() throws Exception {
        boolean bStatus = false;
        try {
            Thread.sleep(Long.parseLong(GenericUtilityLibrary.getValueFromIniFile("START_GLOBAL", "g_intCertainWait")));
            bStatus = true;
            //s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strStepDescription,    GlobalVariables.g_strKeywordDescription + " is successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bStatus;
}
	
	public boolean isDisplayedPreasent() throws Exception {
		boolean bStatus = false;
		String[] strExcelInfo = null;
		try {
			strExcelInfo = gUtilLib.arrGetObjInfoFromExcel(GlobalVariables.g_strObjectRepositoryFilePath,
					GlobalVariables.g_strLogicalName);
			WebElement buttonOrLink = createWebElement(strExcelInfo[0], strExcelInfo[1]);
			bStatus = buttonOrLink.isDisplayed();
			if (bStatus == false) {
				throw new Exception();
			} else {
				GlobalVariables.g_captureScreenShot = true;
				s_childExtentTest.log(LogStatus.PASS, GlobalVariables.g_strKeywordDescription,
						GlobalVariables.g_strKeywordDescription + " is successful");
			}
		} catch (Exception e) {
			s_childExtentTest.log(LogStatus.FAIL, GlobalVariables.g_strKeywordDescription,
					GlobalVariables.g_strKeywordDescription + " is unsuccessful");
			e.printStackTrace();

		}
		return bStatus;
	}
}
