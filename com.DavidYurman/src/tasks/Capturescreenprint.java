/**
 * 
 */
package tasks;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

//import com.relevantcodes.extentreports.LogStatus;

import library.CaptureScreenshot;
import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class Capturescreenprint extends VRSuperClass {

	public void capturescreenprint() throws IOException, InterruptedException{
		
		try{
		System.out.println("Am in Verify Text");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetching objectid " +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetching inputData " +input );
		
		
		
		
		String screenNameFull  =objectID ;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,0)", "");
	     
	     
	     CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,screenNameFull);
		//String screenCapture = logger.addScreenCapture(library.CaptureScreenshot.getScreen(driver,screenNameFull));
		
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,500)", "");
		
		CaptureScreenshot sc1 = new CaptureScreenshot();
			screenshotPath = sc1.getScreen(driver,screenNameFull);
		//String screenCapture1 = logger.addScreenCapture(library.CaptureScreenshot.getScreen(driver,screenNameFull));
	
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,750)", "");
		CaptureScreenshot sc2 = new CaptureScreenshot();
		screenshotPath = sc2.getScreen(driver,screenNameFull);
		//String screenCapture2 = logger.addScreenCapture(library.CaptureScreenshot.getScreen(driver,screenNameFull));
	
		//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)","");
		//jse.executeScript("arguments[0].scrollIntoView(true);",element);
		
		//logger.log(LogStatus.PASS, "finished capturing screenshot", screenCapture); 
		
		
		
		}
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Capture_Screenprint_Failed"); 
			
			test.fail("Capture_Screenprint_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			
			throw e;
			

		}	
	}
}
	
	
