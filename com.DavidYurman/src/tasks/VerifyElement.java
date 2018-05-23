/**
 * 
 */
package tasks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appObjects.AppObjects;
import tasks.TasksObject;


public class VerifyElement extends VRSuperClass {
	public void verifyBtnMethod() throws Exception{
		
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
		//performAction(element, ActionEnum.VERIFY_BUTTON,input);
		
		if(element.isDisplayed() && element.isEnabled())
		{
			System.out.println("Verified the element " + input + "It exists and is enabled");
		}
		else
		{
			System.out.println(input + " Element is not present");
		}
		
		}catch (Exception e)
		{
			try{
				System.out.println(e.toString());
				ClosePopUp closepopup = new ClosePopUp();
				closepopup.CloseallPopUp();
	    		
	    		verifyBtnMethod();

		
	}finally {
		System.out.println("NO pop up to handel");
	}
		}
	}
}

