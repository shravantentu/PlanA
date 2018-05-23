package tasks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import appObjects.AppObjects;
import library.CaptureScreenshot;

public class MouseHover extends VRSuperClass {
public void Mousehover() throws IOException, InterruptedException{
		try{
			StepObject stepsObject = TaskSteps.get(new Integer(0));
			String objectID = stepsObject.getObjectId();
			String input = stepsObject.getInputData();
			ObjectProperty obj = AppObjects.getObjectLocator(objectID);
			String screenNameFull  = obj.getObjectId();
			String screenName = screenNameFull.split("_")[0];	
			WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );	
			performAction(element, ActionEnum.HOVER_MENU_ITEM,input);
		}
		
		catch(Exception e){
			try{
					ClosePopUp closepopup = new ClosePopUp();
					closepopup.CloseallPopUp();
					
		    		Mousehover();
						
			}
			catch(Exception e1){			
			
			CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Get_Text_Failed"); 
			e1.printStackTrace();
			test.fail("Get_Text_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;
			}
		}		
}
}


