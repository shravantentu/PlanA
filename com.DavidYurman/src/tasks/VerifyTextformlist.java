package tasks;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import appObjects.AppObjects;
import library.CaptureScreenshot;

public class VerifyTextformlist extends VRSuperClass {
	
public void verifyTextformlist() throws Exception{
		
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
		List<WebElement> elements = AppObjects.getUIObjects(objectID, screenName,"id" );		
		//performAction(element, ActionEnum.VERIFY_TEXT,input);
		boolean flag =  false;
		
		for(WebElement tempele:elements){
		System.out.println("am printing element.getText().trim() " + '\n' + tempele.getText().trim());
		
		if (tempele.getText().contains(input)) {
			System.out.println(input + '\n' + " is present");
			flag = true;
			break;
		}else
			flag = false;
			//System.out.println(input + '\n' + " is not present");
			//test.fail("Text not found- " + temptele.getText().trim());
		}
		
		if(!flag){
			System.out.println(input + '\n' + " is not present");
			test.fail("Text not found- " + input);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
		     jse.executeScript("window.scrollBy(0,250)", "");
		     CaptureScreenshot sc = new CaptureScreenshot();
				screenshotPath = sc.getScreen(driver,screenName); 
				
				test.fail("finished verifying text",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
			}
		else{
			System.out.println(input + '\n' + " is present");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
		     jse.executeScript("window.scrollBy(0,250)", "");
			//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)","");
			//jse.executeScript("arguments[0].scrollIntoView(true);",element);
		     CaptureScreenshot sc = new CaptureScreenshot();
				screenshotPath = sc.getScreen(driver,screenName); 
				
				test.pass("finished verifying text",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}		
	}
		
		catch (Exception e)
		{
			  			
			try{
				System.out.println(e.toString());
					ClosePopUp closepopup = new ClosePopUp();
					closepopup.CloseallPopUp();
		    		verifyTextformlist();     	         		
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
