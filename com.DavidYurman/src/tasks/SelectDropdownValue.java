package tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;

//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;
import library.GetDataFromExcel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tasks.*;


import appObjects.AppObjects;

public class SelectDropdownValue extends VRSuperClass {

	public void selectDropDownValue() throws IOException, InterruptedException {
		try{
		System.out.println("Am in Select Drop Down Task");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("fetched object id" + object);
		String input = stepsObject.getInputData();
		System.out.println("fetched inputdata" + input);
		ObjectProperty obj = AppObjects.getObjectLocator(object);
		String screenNameFull = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName" + screenName);
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		
				
		List<WebElement> element = AppObjects.getUIObjects(object, screenName, "id");
		
		for(WebElement ele:element)
		{
			//System.out.println(ele.getAttribute("textContent"));
			
			if(ele.getAttribute("textContent").contains(input.toString()))
			{	
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				//System.out.println(ele.getAttribute("textContent"));
				
				ele.click();
				break;
				
			}	
			else {
				System.out.println("Value not present in the size dropdown:" + ele.getAttribute("textContent"));
			}
			
		}
		
		

		test.pass("Selected dropdown value - " + input);
		}
		
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Select_Dropdown_Failed"); 
		
			test.fail("Select_Dropdown_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;

		}
	}
	
	
	
	public void selectDropDownValueConfig() throws IOException, InterruptedException {
		try{
			String testdatavalue = "";
		System.out.println("Am in Select Drop Down Task");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("fetched object id" + object);
		TestDataEnum input = TestDataEnum.getTestDataEnum(stepsObject.getInputData()); 
		System.out.println("fetched inputdata" + input);
		ObjectProperty obj = AppObjects.getObjectLocator(object);
		String screenNameFull = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName" + screenName);
		
		WebElement element = AppObjects.getUIObject(object, screenName, "xpath");
		
switch(input){
		
		case COAbirthmonth:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("COAbirthmonth");
			Select sel = new Select(element);
			sel.selectByVisibleText(testdatavalue);
			break;
		}
		case COAPaddress:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("COAPaddress");
			WebElement select = driver.findElement(By.name("ph_pagebody_0$phthreecolumnmaincontent_0$panel$lstAddress"));
			List<WebElement> options = select.findElements(By.tagName("option"));
			for(WebElement option : options){
			    if(option.getText().equals(testdatavalue))
			    		{
			        option.click();
			        break;
			    }
			}
			
			
		}
}


		//logger.log(LogStatus.PASS, "Selected dropdown value - " + input);
		test.pass("Selected dropdown value - " + testdatavalue);
		}
		
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Select_Dropdown_Failed"); 
			
			test.fail("Select_Dropdown_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;

		}
	}
	
	
	
}
