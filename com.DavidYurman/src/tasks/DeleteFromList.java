package tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import appObjects.AppObjects;
import library.CaptureScreenshot;

public class DeleteFromList extends VRSuperClass {
	
public void deleteFromList() throws IOException, InterruptedException{
		
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
		
//		List<WebElement> elemets  = driver.findElements(By.cssSelector(".action-link"));
//		
//		for(WebElement temptele:elemets){
//			System.out.println(temptele.getText());
//		}
		
		List<WebElement> element = AppObjects.getUIObjects(objectID, screenName,"id" );
		List<WebElement> elementrem = driver.findElements(By.cssSelector(".action-link"));
		List<WebElement> elementremADD = new ArrayList<WebElement>();
		
		int temp = 0;
		for(int i = 0;i<element.size();++i){
			System.out.println(element.get(i).getText());
			if(element.get(i).getText().contains(input.trim())){
				for(int j=0;j<=elementrem.size();j++){
					System.out.println(elementrem.get(j).getText());
					if(elementrem.get(j).getText().equalsIgnoreCase("Remove")){	
						elementremADD.add(elementrem.get(j));
						temp++;
						System.out.println(temp);
						System.out.println(i);
						System.out.println(elementremADD.size());
						if (temp == i+1){
							elementremADD.get(i).click();
							break;
						}
						}
						
					}break;
				}
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
