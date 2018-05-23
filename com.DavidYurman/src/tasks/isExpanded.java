package tasks;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import appObjects.AppObjects;

public class isExpanded extends VRSuperClass {
	
	public void isExpanded() throws IOException, InterruptedException{
		System.out.println("isExpanded");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("isExpanded" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("isExpanded" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );		
		performAction(element, ActionEnum.IS_EXPANDED,input);
	}

}
