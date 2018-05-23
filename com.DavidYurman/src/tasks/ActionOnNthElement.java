package tasks;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;

//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;


public class ActionOnNthElement extends VRSuperClass {
	public void actionOnNthElement() throws IOException, InterruptedException{
		
		try{
	StepObject stepsObject = TaskSteps.get(new Integer(0));
	String object = stepsObject.getObjectId();
	System.out.println("fetched object" +object);
	String action = object.split("-")[0];
	String element = object.split("-")[1];			
	String input = stepsObject.getInputData();
//	System.out.println("fetched input" +input );
//	ObjectProperty obj = AppObjects.getObjectLocator(element);
//	String screenNameFull  = obj.getObjectId();
	String screenName = element.split("_")[0];
//	System.out.println("screenName"+screenName);
	List<WebElement> elements = AppObjects.getUIObjects(element, screenName, "id");		
	
	switch(action){
	case "click":{
		int temp = 0;
	//	int comp = (int) Double.parseDouble(input);
		for(WebElement elementemp:elements){
		//	temp++;			
			if(elementemp.isDisplayed()){
				elementemp.click();
				test.pass("clicked link - " + input+"th element");
				break;
			}
//			else{
//				System.out.println("No of Elements are less than the input");
//				test.fail("Element not found" + input);
//			}
		}
		break;
	}
	case "MouseHover":{
		int temp = 0;
		for(WebElement elementemp:elements){
			temp++;
			if(temp == (int) Double.parseDouble(input)){
				Actions actionfor = new Actions(driver);
				actionfor.moveToElement(elementemp).perform();
				test.pass("clicked link - " + input+ "th element");
				break;
			}
					
		}break;
		
	}
	}
	
}
		catch (Exception e)
		{
			  			
			try{
				
				WebElement element  = driver.findElement(By.cssSelector("#dy-insider-subscribe-form[novalidate='novalidate']"));
				if(element.isDisplayed())
	        	{ 
					
					driver.findElement(By.cssSelector(".mfp-close")).click(); 
		    		System.out.println("Pop up closed");
		    		//Thread.sleep(2000);
		    		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		    		
		    		StepObject stepsObject = TaskSteps.get(new Integer(0));
		    		String object = stepsObject.getObjectId();
		    		System.out.println("fetched object" +object );
		    		String input = stepsObject.getInputData();
		    		System.out.println("fetched input" +input );
		    		ObjectProperty obj = AppObjects.getObjectLocator(object);
		    		String screenNameFull  = obj.getObjectId();
		    		String screenName = screenNameFull.split("_")[0];
		    		System.out.println("screenName"+screenName);
		    		List<WebElement> elements = AppObjects.getUIObjects(object, screenName, "id");		
		    		
		    		int temp = 0;
		    		for(WebElement elementdup:elements){
		    			temp++;
		    			if(temp == Integer.parseInt(input)){
		    				elementdup.click();
		    				test.pass("clicked link - " + input+"th element");
		    			}
		    			else{
		    				System.out.println("No of Elements are less than the input");
		    				test.fail("Element not found" + input);
		    			}		
		    		}
	        	}
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