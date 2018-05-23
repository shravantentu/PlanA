package tasks;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import appObjects.AppObjects;
import library.CaptureScreenshot;

public class Enternumber extends VRSuperClass{
	public void enternumber() throws IOException,InterruptedException{
	
	try{
		
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched object id" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetched input" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );	
//		int tonumber = (int)Integer.parseInt(input)
		 
		performAction(element, ActionEnum.CLICK_BUTTON,input);
		//performAction(element, ActionEnum.TEXT_BOX,Integer.parseInt(input));
		//logger.log(LogStatus.PASS, "Entered text - " + input);
	//	element.sendKeys(Integer.parseInt(input));
		test.pass("Entered text - " + (int)Integer.parseInt(input));
	}
	catch(Exception e){
		 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Enter_Text_Failed"); 
			e.printStackTrace();
			test.fail("Test Case Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;

	}
	
}
}
