package tasks;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;

public class SelectCheckBox extends VRSuperClass{
		
		public void selectcheckbox() throws IOException, InterruptedException{
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
			performAction(element, ActionEnum.SELECT_CHECKBOX_BUTTON,input);
			
			//logger.log(LogStatus.PASS, "Selected checkbox - " + input);
			test.pass("Selected checkbox - " + input);
			}
			
			catch (Exception e)
			{
				  
				 CaptureScreenshot sc = new CaptureScreenshot();
				screenshotPath = sc.getScreen(driver,"Select_Checkbox_Failed"); 
				
				test.fail("Select_Checkbox_Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
				
				throw e;

			}
			
		}

	}


