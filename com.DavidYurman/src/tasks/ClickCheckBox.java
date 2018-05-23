/**
 * 
 */
package tasks;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;
import tasks.TasksObject;


public class ClickCheckBox extends VRSuperClass {
	public void clickcheckbox() throws IOException, InterruptedException{
		
		try{
		//System.out.println("rediff");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("fetched objectid" +object );
		String input = stepsObject.getInputData();
		System.out.println("fetched input" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(object);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(object, screenName, "id");		
		performAction(element, ActionEnum.CLICK_CHECK_BOX,input);
		//logger.log(LogStatus.PASS, "clicked checkbox - " + input);
		test.pass("clicked checkbox - " + input);
		}
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Click_Checkbox_Failed"); 
			e.printStackTrace();
			test.fail("Click_Checkbox_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;
			

		}
	}
}
