package tasks;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;

import appObjects.AppObjects;
import library.CaptureScreenshot;

public class Scroll extends VRSuperClass {

	public void scroll() throws IOException, InterruptedException{
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched object" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetched input" +input );
		
		String activewindow = driver.getWindowHandle();
		
////		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
//		String screenNameFull  = obj.getObjectId();
//		String screenName = screenNameFull.split("_")[0];
//		System.out.println("screenName"+screenName);
		
//		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );		
//		performAction(element, ActionEnum.ENTER,input);
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,500)", "");
		System.out.println("git commit for master");
		
		
		CaptureScreenshot sc = new CaptureScreenshot();
		screenshotPath = sc.getScreen(driver,"Scroll"); 
		test.pass("finished scroll",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		
		driver.switchTo().window(activewindow);
//		
	}
}
