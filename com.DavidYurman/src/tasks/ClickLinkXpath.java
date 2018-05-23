package tasks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;

//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;


public class ClickLinkXpath extends VRSuperClass {
	public void clickLinkXpath() throws Exception{
		
		try{
	StepObject stepsObject = TaskSteps.get(new Integer(0));
	String object = stepsObject.getObjectId();
	System.out.println("fetched object" +object );
	String input = stepsObject.getInputData();
	System.out.println("fetched input" +input );
	ObjectProperty obj = AppObjects.getObjectLocator(object);
	String screenNameFull  = obj.getObjectId();
	String screenName = screenNameFull.split("_")[0];
	System.out.println("screenName"+screenName);
	WebElement element = AppObjects.getUIObject(object, screenName, "xpath");		
	performAction(element, ActionEnum.CLICK_LINK,input);
	//logger.log(LogStatus.PASS, "clicked link - " + input);
	//System.out.println("Pop up closed");
	test.pass("clicked link - " + input);
}
		catch (Exception e)
		{
			
	try{
		System.out.println(e.toString());
		ClosePopUp closepopup = new ClosePopUp();
		closepopup.CloseallPopUp();
		clickLinkXpath();
	
	        	}
			catch (Exception e1)
			{
				  
				 CaptureScreenshot sc = new CaptureScreenshot();
				screenshotPath = sc.getScreen(driver,"exception"); 
				e1.printStackTrace();
				test.fail("exception",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
				throw e1;

			}
			

		}	
	}
}
