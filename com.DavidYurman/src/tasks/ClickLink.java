package tasks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;


public class ClickLink extends VRSuperClass {
	public void clickLink() throws Exception{
		
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
	WebElement element = AppObjects.getUIObject(object, screenName, "id");		
	performAction(element, ActionEnum.CLICK_LINK,input);
	//logger.log(LogStatus.PASS, "clicked link - " + input);
	test.pass("clicked link - " + input);
}
		
		catch (Exception e)
		{
			  			
			try{
				//System.out.println(e.getStackTrace());
				System.out.println(e.toString());
				ClosePopUp closepopup = new ClosePopUp();
				closepopup.CloseallPopUp();	
				
				clickLink();
       	         		
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
	public void clickLinkviaxpath() throws IOException, InterruptedException{
		try{
        System.out.println("msn");
        StepObject stepsObject = TaskSteps.get(new Integer(0));
        String object = stepsObject.getObjectId();
        System.out.println("msn" +object );
        String input = stepsObject.getInputData();
        System.out.println("msn" +input );
        ObjectProperty obj = AppObjects.getObjectLocator(object);
        String screenNameFull  = obj.getObjectId();
        String screenName = screenNameFull.split("_")[0];
        System.out.println("screenName"+screenName);
        WebElement element = AppObjects.getUIObject(object, screenName, "xpath");         
        performAction(element, ActionEnum.CLICK_LINK,input);
       // logger.log(LogStatus.PASS, "clicked link - " + input);
        test.pass("clicked link - " + input);
 }
	
	catch (Exception e)
	{
		  
		 CaptureScreenshot sc = new CaptureScreenshot();
		screenshotPath = sc.getScreen(driver,"Click_link_failed"); 
		e.printStackTrace();
		test.fail("Click_link_failed",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
		throw e;

	}
	}	
	
}
