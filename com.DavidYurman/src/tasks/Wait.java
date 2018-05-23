package tasks;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import appObjects.AppObjects;

public class Wait extends VRSuperClass {

	public void waitMethod() throws IOException, InterruptedException {
		System.out.println("entered waitMethod");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetched object id" + objectID);
		String input = stepsObject.getInputData();
		System.out.println("Fetched inputData" + input);
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName" + screenName);
		Boolean Flag = AppObjects.waitForElement(objectID, screenName, "xpath");
		if (Flag == true) {
			System.out.println("Could find the element");
		} else {
			System.out.println("couldnot find the element");
		}
		// performAction(ActionEnum.WAIT);

		// WebElement element = (new WebDriverWait(driver,
		// 50)).until(ExpectedConditions.elementToBeClickable(locator)));

		/*
		 * if ((input)!= null) { int a =Integer.parseInt(input); WebDriverWait
		 * waitvar = new WebDriverWait(driver,a);
		 * 
		 * waitvar.until(ExpectedConditions.visibilityOf(element));
		 * 
		 * //wait1.until(ExpectedConditions.visibilityOf(element));
		 * //driver.manage().timeouts().pageLoadTimeout(a, TimeUnit.SECONDS);
		 * System.out.println(" Explicit Waiting for " + input + " seconds");
		 * Thread.sleep(a);
		 * 
		 * } else{ System.out.println("not able to reach wait block"); }
		 */

	}
}
