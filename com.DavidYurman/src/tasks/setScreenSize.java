/**
 * 
 */
package tasks;

import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import appObjects.AppObjects;
import tasks.TasksObject;

public class setScreenSize extends VRSuperClass {
	public void setDimensions() throws IOException, InterruptedException{
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("fetched object" +object );
		String input = stepsObject.getInputData();
		System.out.println("fetched input" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(object);
	//	String screenNameFull  = obj.getObjectId();
	//	String screenName = screenNameFull.split("_")[0];
	//	System.out.println("screenName"+screenName);
	//	WebElement element = AppObjects.getUIObject(object, screenName, "xpath");		
		//performAction(element, ActionEnum.CLICK_BUTTON,input);
		
		String[] values = input.split(",");
		int a = Integer.parseInt(values[0]);
		int b = Integer.parseInt(values[1]);

		Dimension d = new Dimension(a, b);
		driver.manage().window().setSize(d);
	}
}
