/**
 * 
 */
package tasks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;
import tasks.TasksObject;

public class ClickButton extends VRSuperClass {
	public void clickButton() throws Exception{
		
		try{
		
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("fetched objectid" +object );
		String input = stepsObject.getInputData();
		System.out.println("fetched input data" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(object);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		
//		if (screenName.equalsIgnoreCase("BA"))
//		System.out.println("reached page 6");
		//logger.log(LogStatus.INFO, "dropdown selected");
		WebElement element = AppObjects.getUIObject(object, screenName, "id");		
		performAction(element, ActionEnum.CLICK_BUTTON,input);
	//	logger.log(LogStatus.PASS, "clicked button - " + input);
		test.pass("clicked button" + input);
		}
		
		catch (Exception e)
		{
			try{
				System.out.println(e.toString());
				ClosePopUp closeall = new ClosePopUp();
				closeall.CloseallPopUp();
	    		clickButton();      	         		
        	}
		catch (Exception e1)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"exception"); 
			e.printStackTrace();
			test.fail("exception",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e1;

		}
			
		}
	}
}

