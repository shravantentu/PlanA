package tasks;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import appObjects.AppObjects;

public class isPopUpDisplayed extends VRSuperClass {

		public void IsPopUpDisplayed() throws IOException, InterruptedException, Exception{
			Logger resultsLog = Logger.getLogger("");
			resultsLog.info("am inside  'isPopUpDisplayed' task Script");
			System.out.println("IsPopUpDisplayed");
			StepObject stepsObject = TaskSteps.get(new Integer(0));
			String objectID = stepsObject.getObjectId();
			System.out.println("IsPopUpDisplayed" +objectID );
			String input = stepsObject.getInputData();
			System.out.println("IsPopUpDisplayed" +input );
			ObjectProperty obj = AppObjects.getObjectLocator(objectID);
			String screenNameFull  = obj.getObjectId();
			String screenName = screenNameFull.split("_")[0];
			System.out.println("screenName"+screenName);
			if(!screenName.equalsIgnoreCase("NoPopUp")){
				WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );	
				System.out.println("IsPopUpDisplayed");
				element.sendKeys(Keys.ESCAPE);
				element.click();
				String altertText=driver.switchTo().alert().getText();
				System.out.println(altertText);
				System.out.println(input);
			    driver.switchTo().alert().notify();
				Assert.assertEquals(altertText.contains(input), true);
				boolean result = altertText.contains(input);
				System.out.println(result);
				System.out.println("IsPopUpDisplayed over");
			}
			if(screenName.equalsIgnoreCase("NoPopUp")){
				try{
					String altertText=driver.switchTo().alert().getText();
					System.out.println(altertText);
					System.out.println("no pop up alert text" +input);
				    driver.switchTo().alert().notify();
					//Assert.assertEquals(altertText.contains(input), true);
					//boolean result = altertText.contains(input);
				    resultsLog.error("Alert is displayed");					
				}catch(Exception e){
					resultsLog.info("Alert not displayed");
					System.out.println("Alert not displayed ");
				}
			}	
			
			//performAction(element,ActionEnum.VERIFY_TEXT_NOT_PRESENT,input);
		}
}

