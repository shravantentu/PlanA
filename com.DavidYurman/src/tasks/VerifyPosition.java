/**
 * 
 */
package tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.examples.SplitAndFreezePanes;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import appObjects.AppObjects;

import tasks.TasksObject;


public class VerifyPosition extends VRSuperClass {
	public void verifyPosition() throws IOException, InterruptedException {
		System.out.println("in Verify Postion Task");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("fetched object " + object);
		String input = stepsObject.getInputData();
		System.out.println("fetched input" + input);
		ObjectProperty obj = AppObjects.getObjectLocator(object);
		String screenNameFull = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
	//	System.out.println("screenName" + screenName);
	//	WebElement element = AppObjects.getUIObject(object, screenName, "xpath");
		// performAction(element, ActionEnum.CLICK_BUTTON,input);

		WebElement element = driver.findElement(By.xpath(objectPropertyMap.get(object).getXpathValue()));
		String[] values = input.split(",");
		int a = Integer.parseInt(values[0]);
		int b = Integer.parseInt(values[1]);
		
		System.out.println(element.getLocation().getX());
		System.out.println(element.getLocation().getY());
		
		Assert.assertEquals(a, element.getLocation().getX());
		Assert.assertEquals(b, element.getLocation().getY());
		
	}
}
