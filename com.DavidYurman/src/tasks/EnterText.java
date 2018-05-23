/**
 * 
 */
package tasks;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import library.CaptureScreenshot;

//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class EnterText extends VRSuperClass {

	public void enterText() throws Exception{

		
		try{
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched object id" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetched input" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
//		WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );	
//		performAction(element, ActionEnum.CLICK_BUTTON,input);
//		performAction(element, ActionEnum.TEXT_BOX,input);
		//logger.log(LogStatus.PASS, "Entered text - " + input);
//		test.pass("Entered text - " + input);

		if(input.equalsIgnoreCase("CVV3")){
			List<WebElement> elements = AppObjects.getUIObjects(objectID, screenName,"id" );					
			for(WebElement elementdup:elements){
				elementdup.sendKeys("421");
				break;
			}
		} 
		
		else if	(input.equalsIgnoreCase("CVV4")){
			List<WebElement> elements = AppObjects.getUIObjects(objectID, screenName,"id" );	
			
			for(WebElement elementdup:elements){
				elementdup.sendKeys("4213");
				break;
				}
			}
		else if	(input.equalsIgnoreCase("GFPIN13")){
			WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );	
			element.sendKeys("5102");
				
			}
		else if(input.equalsIgnoreCase("GenerateNewMailID")){
			try{
			WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );
			
				SimpleDateFormat simpleDateFormat =
		        new SimpleDateFormat("MMddyyhhmmss");
				String dateAsString = simpleDateFormat.format(new Date());
		    
		    //System.out.println(dateAsString);
			input = "DYAutomation2017" + dateAsString +"@hotmail.com";
			GetDataFromExcel.writetotext("Guest_Email", input);
			performAction(element, ActionEnum.TEXT_BOX,input);
			}
			
			catch(Exception e){
				System.out.println(e.toString());
				ClosePopUp closepopup = new ClosePopUp();
				closepopup.CloseallPopUp();
				
				WebElement element1 = AppObjects.getUIObject(objectID, screenName,"id" );
				performAction(element1, ActionEnum.TEXT_BOX,input);
			}
			
		}
		else if((input.equalsIgnoreCase("ConfirmNewMailID"))||(input.equalsIgnoreCase("NewExistingUser"))){
			WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );
			
			String regmail = GetDataFromExcel.readfromtext("Guest_Email");
			performAction(element, ActionEnum.TEXT_BOX,regmail);
			
		}
		else{
			
			try{
				WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );
				performAction(element, ActionEnum.TEXT_BOX,input);
				test.pass("Entered text - " + input);	
			}
			catch(Exception e){

				
				ClosePopUp closepopup = new ClosePopUp();
				closepopup.CloseallPopUp();
				
				WebElement element1 = AppObjects.getUIObject(objectID, screenName,"id" );
				performAction(element1, ActionEnum.TEXT_BOX,input);
				test.pass("Entered text - " + input);				
			}
		}		
		
		}
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Enter_Text_Failed"); 
			e.printStackTrace();
			test.fail("Test Case Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;

		}
	}
	
//	public void enterNum() throws IOException, InterruptedException{
//
//		
//		try{
//		StepObject stepsObject = TaskSteps.get(new Integer(0));
//		String objectID = stepsObject.getObjectId();
//		System.out.println("fetched object id" +objectID );
//		String input = stepsObject.getInputData();	
//		System.out.println("fetched input" +input );
//		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
//		String screenNameFull  = obj.getObjectId();
//		String screenName = screenNameFull.split("_")[0];
//		System.out.println("screenName"+screenName);
//		WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );		
//		performAction(element, ActionEnum.TEXT_BOX_NUM,input);
//		//logger.log(LogStatus.PASS, "Entered text - " + input);
//		test.pass("Entered text - " + input);
//		
//		}
//		catch (Exception e)
//		{
//			  
//			 CaptureScreenshot sc = new CaptureScreenshot();
//			screenshotPath = sc.getScreen(driver,"Enter_Text_Failed"); 
//			e.printStackTrace();
//			test.fail("Test Case Failed",
//					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
//			throw e;
//
//		}
//	}
	
	
	public void enterTextforMultipleElements() throws IOException, InterruptedException{
		try{
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched object id " +objectID );
		//driver.findElement("locator").clear();. 
		String input = stepsObject.getInputData();
		System.out.println("fetched input: " +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
	
		String screenName = screenNameFull.split("_")[0];
//		if (input.equalsIgnoreCase("autoamtionth"))
//			System.out.println("reached page 6");
		  //  logger.log(LogStatus.INFO, "dropdown selected");
		System.out.println("screenName : "+screenName);
		List<WebElement> elements = AppObjects.getUIObjects(objectID, screenName,"id" );
		System.out.println("entertextbefore");
		for(WebElement e:elements)
		{
			System.out.println("enteredforloop");
			if(e.isDisplayed() && e.isEnabled())
			{
				System.out.println("enteredifloop");
				performAction(e, ActionEnum.TEXT_BOX,input);
				System.out.println("entertextafter");
				//logger.log(LogStatus.PASS, "Entered text - " + input);
				test.pass("Entered text - " + input);
				break;
			}
		
			else
				continue;
		}
		}
		
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Enter_Text_Failed"); 
			e.printStackTrace();
			test.fail("Enter_Text_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;

		}
		}
	}


