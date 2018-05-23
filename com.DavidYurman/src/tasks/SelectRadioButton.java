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

import appObjects.AppObjects;
import library.CaptureScreenshot;
import tasks.TasksObject;

public class SelectRadioButton extends VRSuperClass{
	
	public void selectRadioBtn() throws IOException, InterruptedException{
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
		performAction(element, ActionEnum.SELECT_RADIO_BUTTON,input);
		
		//logger.log(LogStatus.PASS, "Selected radio button - " + input);
		test.pass("Selected radio button - " + input);
		//String screenCapture = logger.addScreenCapture(library.CaptureScreenshot.getScreen(driver,"Checkout Initial Page"));
		//logger.log(LogStatus.PASS, "clicked on radio button", screenCapture);
	}
		
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Select_Radiobutton_Failed"); 
			
			test.fail("Select_Radiobutton_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;

		}
	}
	
	
	public void SelectManageuserradiobutton() throws IOException, InterruptedException{
				
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
		if (input.equalsIgnoreCase("autoamtionth"))
			System.out.println("reached page 6");
		//logger.log(LogStatus.PASS, "Selected radio button - " + input);
		System.out.println("screenName"+screenName);
		//List<WebElement> elements = AppObjects.getUIObjects(objectID, screenName,"id" );
		WebElement element = AppObjects.getUIObject(objectID, screenName, "xpath");	
		performAction(element, ActionEnum.SELECT_RADIO_BUTTON,input);
		//logger.log(LogStatus.PASS, "Selected radio button - " + input);
		test.pass("Selected radio button - " + input);
		//System.out.println(elements);
		//System.out.println("entertextbefore");
		//for(WebElement e:elements)
		//{
			//System.out.println("enteredforloop");
			//if(e.isDisplayed() && e.isEnabled())
			//{
				//System.out.println("enteredifloop");
				//performAction(e, ActionEnum.SELECT_RADIO_BUTTON,input);
				//System.out.println("entertextafter");
				//logger.log(LogStatus.PASS, "multiple text got entered");
				//break;
			//}
		
			//else
				//continue;
		//}
		}
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Select_Radiobutton_Failed"); 
			
			test.fail("Select_Radiobutton_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;

		}
	}
}
