package testCases;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import tasks.TestCasesObject;
import tasks.VRSuperClass;
import tasks.ECOMSuperClass;
import tasks.TasksEnum;
import tasks.TasksObject;

import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import com.relevantcodes.extentreports.ExtentReports;

import library.GetDataFromExcel;


public class DriverScript extends VRSuperClass {
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
	//	setUp();
		library.Output.outputFolder();
		DOMConfigurator.configure("Config\\extent-config.xml");
		DOMConfigurator.configure("Config\\log4jconfig.xml");
        Logger logger = Logger.getLogger("");
      
		String orPath = System.getProperty("user.dir") + "\\src\\uiLocators\\uiLocators.properties";
		//C:\ALCON\workspace\RegAlconFwk\src\\uiLocators//
		HashMap<String, String> data = (HashMap<String, String>) GetDataFromExcel.readToList(orPath);
		ObjectTypeMap = GetDataFromExcel.getObjectProperties(data);

//		try{
	// Reading the config excel and getting the module list
		ArrayList<String> TestRunNames = library.GetDataFromExcel.readTestCaseNamesList();
		for (Iterator<String> testSuiteIterator = TestRunNames.iterator(); testSuiteIterator.hasNext();) {
			String runName = testSuiteIterator.next();
			System.out.println("Test Case Name" + runName);
			String TestSuiteName = System.getProperty("user.dir") + "\\TestData\\DataSheets\\"+runName+".xlsx";
			//C:\ALCON\workspace\RegAlconFwk\TestData\DataSheets
			System.out.println(TestSuiteName);
			//reading the module excel
			List<List<String>> data2 = library.GetDataFromExcel.readTestSuiteToList(TestSuiteName);
			//creating a map with tcid,test desc,test case
			Map<Integer, TestCasesObject> testCasesMap = library.GetDataFromExcel.getTestCasesToExec(data2);
			
			for (Iterator<Integer> iterator = testCasesMap.keySet().iterator(); iterator.hasNext();) {
				Integer integer = iterator.next();
				TestCasesObject testCasesObject = testCasesMap.get(integer);
				 TestScenarioId =  testCasesObject.getTestScenarioId();
				System.out.println("Test Case Map" + TestScenarioId);
				String TestCaseModule = testCasesObject.getTestCaseModule();
				System.out.println("Test Case Map" + TestCaseModule);
				testCasesObject.setTestCaseModule(TestCaseModule);
				taskName = TasksEnum.LOGIN.toString();	
				String testCaseIDSheet[][] = null;
				//navigating to tcid sheet
				testCaseIDSheet = library.GetDataFromExcel.ReadSheet(TestSuiteName,TestScenarioId);
				//creating map
				TaskList = library.GetDataFromExcel.getTasksToExec(testCaseIDSheet, "Step Number");
			    TestCaseModule = TestCaseModule.replace(" ", "");
			    //calling the test case
			    Class noparams[] = {};
                Class cls = Class.forName("testCases."+TestCaseModule);
                Object obj = cls.newInstance();
                Method[] method = cls.getDeclaredMethods();
                //Method method = cls.getDeclaredMethod("execute", noparams);              
                //SWITCH_TABLE
                if (method[0].getName().contains("SWITCH_TABLE")) {
					method[1].invoke(obj, null);
                } else {
                    method[0].invoke(obj, null);
                }

		}
		  
	}
//		}
//		catch(Exception e){
//			driver.quit();
//		}
	
	}

//	private static void setUp() throws IOException {
//
//		library.Output.outputFolder();
//
//		//report = new ExtentReports();
//	    //logger1 = report.createTest("QAVsite", "Verify HomePage");
//		// TODO Auto-generated method stub
//		
//	}

	//private static void //setUp() {
		// TODO Auto-generated method stub
		
	//}
	}
	