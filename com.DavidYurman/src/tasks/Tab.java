package tasks;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import appObjects.AppObjects;

public class Tab extends VRSuperClass {

	public void TAB() throws IOException, InterruptedException{
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched object ID" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetched input" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );		
		performAction(element, ActionEnum.TAB,input);
	}
}
