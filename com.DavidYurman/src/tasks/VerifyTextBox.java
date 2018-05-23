/**
 * 
 */
package tasks;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import appObjects.AppObjects;
import tasks.TasksObject;


public class VerifyTextBox extends VRSuperClass {
	public void verifyTextBoxMethod() throws IOException, InterruptedException{
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
		 
		 System.out.println("Verified  " + input + ". It exists and is enabled for entering data");
		 
		}
		else
		{
			System.out.println(input + " TextBox is not present");
		}
		
	}
	
	
		
		
	
}
