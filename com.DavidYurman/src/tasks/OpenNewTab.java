package tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import appObjects.AppObjects;

public class OpenNewTab extends VRSuperClass {
	public void opennewtab() throws IOException, InterruptedException{
		System.out.println("OpenNewTab");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("OpenNewTab" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("OpenNewTab" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );	
		
		
		
		performAction(element, ActionEnum.OPEN_NEW_TAB,input);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		

}
}