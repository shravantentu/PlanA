package tasks;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import appObjects.AppObjects;

public class Logout extends VRSuperClass{
	
	public void logout() throws IOException, InterruptedException{
		
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		
		String input = stepsObject.getInputData();
		
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		performAction(element, ActionEnum.CLICK_LINK,input);
		connection = false;
		driver.quit();
	}

}

