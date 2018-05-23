package tasks;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.*;

import appObjects.AppObjects;
import library.CaptureScreenshot;


public class Sleep extends VRSuperClass {

	public void sleepMethod() throws IOException, InterruptedException {
		try{
		System.out.println("entered SleepMethod");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		String input = stepsObject.getInputData();
		System.out.println("Fetched inputData" + input);
		
		int a = Integer.parseInt(input);		
		Thread.sleep(a/5);
		// driver.manage().timeouts().setScriptTimeout(a,TimeUnit.MILLISECONDS);
		 
		//logger.log(LogStatus.PASS, "Sleep for " + input + " milliseconds");
		//test.pass("Sleep for " + input + " milliseconds");
			
		}
		
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Sleep_Failed"); 
			
			test.fail("Sleep_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;

		}
	}
	
}
