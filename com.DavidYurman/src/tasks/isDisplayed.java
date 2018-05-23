/**
 * 
 */
package tasks;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class isDisplayed extends VRSuperClass {

	public void isDisplayed() throws IOException, InterruptedException{
		System.out.println("isDisplayed");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("isDisplayed" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("isDisplayed" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		if (obj == null) {
			System.out.println(objectID + " not found");
		}
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );		
		performAction(element, ActionEnum.IS_DISPLAYED,input);
	}
	
	

}
