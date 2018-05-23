package tasks;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;

public class ClearText extends VRSuperClass {

	public void clearText() throws IOException, InterruptedException{
		
		try{
		System.out.println("CLEAR TAsk");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched objectID" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetched input data" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );		
		//performAction(element, ActionEnum.CLEAR_TEXT,input);
                element.clear();
        //logger.log(LogStatus.PASS, "cleared text from text box");
        test.pass("cleared text from text box");        
                
		}
		
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Clear_Text_Failed"); 
			
			test.fail("Clear_Text_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			
			throw e;
		}	
	}
}
