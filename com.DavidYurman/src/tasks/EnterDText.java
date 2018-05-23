/**
 * 
 */
package tasks;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.LogStatus;

import library.CaptureScreenshot;
import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class EnterDText extends VRSuperClass {

	public static void enterdynamictext() throws IOException, InterruptedException{
	
	try{
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched object id" +objectID );
		//driver.findElement("locator").clear();. 
		String input = stepsObject.getInputData();
		System.out.println("fetched input" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		String dynamictext="";
		if (input.equalsIgnoreCase("outputtxt")){
			 dynamictext = outputtext;
					}
					
		System.out.println("screenName"+screenName);
		List<WebElement> elements = AppObjects.getUIObjects(objectID, screenName,"id" );
		System.out.println("entertextbefore");
		for(WebElement e:elements)
		{
			System.out.println("enteredforloop");
			if(e.isDisplayed() && e.isEnabled())
			{
				System.out.println("enteredifloop");
				performAction(e, ActionEnum.TEXT_BOX,dynamictext);
				System.out.println("entertextafter");
				//logger.log(LogStatus.PASS, "Entered text - " + dynamictext);
				test.pass("Entered text - " + dynamictext);
				break;
			}
		
			else
				continue;
		}
		
		
	}
	
	catch (Exception e)
	{
		  
		 CaptureScreenshot sc = new CaptureScreenshot();
		screenshotPath = sc.getScreen(driver,"Enter_DText_Failed"); 
		
		test.fail("Enter_DText_Failed",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
		throw e;
		

	}
	}

}
