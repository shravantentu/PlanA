package tasks;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;
import tasks.TasksObject;

public class ClickIcon extends VRSuperClass {
	AppObjects appObjects = new AppObjects();
	public void clickIcon() throws Exception{
		
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
		WebElement element = AppObjects.getUIObject(object, screenName, "xpath" );

		Actions mouseActions = new Actions(driver);
		mouseActions.moveToElement(element).click().build().perform();	
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	
		test.pass("clicked link with partial text - " + input);
		}
		
		catch (Exception e)
		{  
			
			StepObject stepsObject = TaskSteps.get(new Integer(0));
			String object = stepsObject.getObjectId();
			System.out.println("fetched object" +object );
			String input = stepsObject.getInputData();
			System.out.println("fetched input" +input );
			ObjectProperty obj = AppObjects.getObjectLocator(object);
			String screenNameFull  = obj.getObjectId();
			String screenName = screenNameFull.split("_")[0];
			System.out.println("screenName"+screenName);
			
			if(object.equalsIgnoreCase("Checkout_Address_Next")){
				WebElement element = driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div[2]/section/h2/a"));
				element.click();
				clickIcon();
			}
			else{			
			try{
					System.out.println(e.toString());    		
					ClosePopUp closepopup = new ClosePopUp();
					closepopup.CloseallPopUp();
		    		clickIcon();	        	         		
	        	}
			
			catch (Exception e1)
			{
				 CaptureScreenshot sc = new CaptureScreenshot();
				screenshotPath = sc.getScreen(driver,"exception"); 
				e1.printStackTrace();
				test.fail("exception",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
				throw e1;

			}	

		}
	}
}
}