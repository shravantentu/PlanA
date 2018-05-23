/**
 * 
 */
package tasks;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import library.CaptureScreenshot;

//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class VerifyURL extends VRSuperClass {

	public void verifyURL() throws IOException, InterruptedException{
		try{
		System.out.println("Entered navigateTo method");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetched object id" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("Fetched inputData " +input );
		String aut = GetDataFromExcel.ReadConfig("aut");
		String expectedURL = aut + input;
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)){
			System.out.println("URL is correct " + actualURL);
			//logger.log(LogStatus.PASS, "Verified URL - " + actualURL);
			test.pass("Verified URL - " + actualURL);
		}else{
			System.out.println("URL is not correct " + actualURL);
			//logger.log(LogStatus.FAIL, "Incorrect URL - " + actualURL);
			test.fail("Incorrect URL - " + actualURL);
		}
		}
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"VerifyURL_Failed"); 
			
			test.fail("VerifyURL_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;
			

		}
		
	}
public void verifyURLforcontainedtext() throws IOException, InterruptedException{
		System.out.println("Entered navigateTo method");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetched object id" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("Fetched inputData " +input );
		String actualURL = driver.getCurrentUrl();
		if(actualURL.contains(input)){
			System.out.println("URL is correct");
		}else{
			System.out.println("URL is not correct");
		}
		
		
	}





}
