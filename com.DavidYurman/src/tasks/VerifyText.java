/**
 * 
 */
package tasks;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import library.CaptureScreenshot;

//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class VerifyText extends VRSuperClass {

	public void verifyText() throws IOException, InterruptedException{
		try{
		System.out.println("I'm in Verify Text");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetching objectid: " +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetching inputData: " +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		//logger.log(LogStatus.INFO, " User logs into HMC");
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		//String objecttype= screenNameFull.split("_")[2];
		
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );	
		
		//performAction(element, ActionEnum.VERIFY_TEXT,input);
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(element));
		
	System.out.println("printing element text: "+element.getAttribute("textContent").trim().toString());

	//Assert.assertEquals(element.getText().trim(), input);
//	System.out.println(element.getAttribute("textContent"));
	
		if (element.getAttribute("textContent").trim().contains(input.trim())) {
			System.out.println(input + '\n' + " is present");
			test.pass("successfully verified text");
			//logger.log(LogStatus.PASS, "successfully verified text");
			
		} else{
			/*if(element.getText().contains(input)){
				System.out.println(input + " was partial text");
			}*/
			
			System.out.println(input + '\n' + " is not present");
			test.fail("Text not found " + element.getAttribute("textContent").trim());
			//logger.log(LogStatus.FAIL, "not able to verify text");
		}
		
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,250)", "");
		//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)","");
		//jse.executeScript("arguments[0].scrollIntoView(true);",element);
	     CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,screenName); 
			
			test.pass("finished verifying text",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	     
	     
	    // String screenCapture = logger.addScreenCapture(library.CaptureScreenshot.getScreen(driver,screenName));
		//logger.log(LogStatus.PASS, "finished verifying text", screenCapture); 
		
	}
		
		catch (Exception e)
		{
			  
			CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"VerifyText_Failed"); 
			
			test.fail("VerifyText_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			
			throw e;
			

		}
	}
	
	public void verifyTextformlist() throws IOException, InterruptedException{
		
		try{
			
		System.out.println("Am in Verify Text");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetching objectid " +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetching inputData " +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
	
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		
		System.out.println("screenName"+screenName);
		List<WebElement> element = AppObjects.getUIObjects(objectID, screenName,"id" );		
		//performAction(element, ActionEnum.VERIFY_TEXT,input);
		
		for(WebElement temptele:element){
		//System.out.println("am printing element.getText().trim() " + '\n' + element.getText().trim());
		
		if (temptele.getText().trim().contains(input)) {
			System.out.println(input + '\n' + " is present");			
		} else
			
			System.out.println(input + '\n' + " is not present");
			test.fail("Incorrect URL - " + temptele.getText().trim());
		}
	}
		
		catch (Exception e)
		{
			  
			CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"VerifyText_Failed"); 
			
			test.fail("VerifyText_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			
			throw e;
			

		}		
		
	}

}
