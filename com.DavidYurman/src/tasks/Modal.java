/**
 * 
 */
package tasks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;
import tasks.TasksObject;


public class Modal extends VRSuperClass {
	public void modal() throws IOException, InterruptedException{
		try{
			
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("Fetched object id" +object );
		String input = stepsObject.getInputData();
		System.out.println("Fetched inputData" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(object);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		if (input.equalsIgnoreCase("Delete"))
			System.out.println("reached page 6");
		   // logger.log(LogStatus.PASS, "modal accessed");
		test.pass("modal accessed");
		driver.switchTo().activeElement();
		//Thread.sleep(5000);
		    //driver.switchTo().frame(0);
		    //driver.switchTo().frame(1);
		WebElement element = AppObjects.getUIObject(object, screenName, "xpath");		
		element.click();
		}
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Modal_Failed"); 
			
			test.fail("Modal_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			
			throw e;
		}
	    
	    		    		}

}