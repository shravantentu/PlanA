package tasks;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import appObjects.AppObjects;
import library.CaptureScreenshot;
import tasks.TasksObject;


public class VerifyProductcount extends VRSuperClass {
	public void verifyProductcount() throws IOException, InterruptedException{
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
		List<WebElement> element = AppObjects.getUIObjects(object, screenName, "id");		
		//performAction(element, ActionEnum.VERIFY_BUTTON,input);
		
		if(input.trim().equalsIgnoreCase("first Search")){
			if(element.size()>= 1){
				System.out.println("Atleast one product is present and Search is working");
			
			CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,screenName); 
			
			test.pass("finished verifying Product",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());}
			else{
				System.out.println("Search not working, Atleast one product not retrived for search");
				
				CaptureScreenshot sc = new CaptureScreenshot();
				screenshotPath = sc.getScreen(driver,screenName); 
				
				test.fail("finished verifying Product",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				
			}
		}
		else if(input.trim().equalsIgnoreCase("first scroll")){
				if(element.size()>= 40){
			
				System.out.println("Infinite Scroll is working");
			
			CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,screenName); 
			
			test.pass("finished verifying scroll",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());}
		else{
			System.out.println("scroll not working");
			
			CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,screenName); 
			
			test.fail("finished verifying scroll",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
		}
			
		}
		else{
			System.out.println("Search not working or search parameter not passed as required");		
		}
		
		
	}
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"VerifyProductcount_Failed"); 
			
			test.fail("VerifyProductcount",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			
			throw e;
			

		}
		
}
}
