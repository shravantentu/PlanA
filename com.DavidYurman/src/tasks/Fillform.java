
package tasks;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;
import tasks.TasksObject;
import tasks.ObjectProperty;


public class Fillform extends VRSuperClass {
	public void fillform() throws Exception{
		
		try{
	
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("fetched objectid:" +object );
		String input = stepsObject.getInputData();
		System.out.println("fetched input:" +input );
//		ObjectProperty obj = AppObjects.getObjectLocator(object);
//		String screenNameFull  = obj.getObjectId();
//		String screenName = screenNameFull.split("_")[0];
//		System.out.println("screenName:"+screenName);
		String FiledsIds =null;
		
		if(object.equalsIgnoreCase("Address_Register")){
			FiledsIds = "span[name*='title'];ul[id*='titleSelectBoxItOptions']>li>a;#text-field-firstname;#text-field-lastname;"
				+ "span[name*='country'];ul[id*=countrySelectBoxItOptions]>li>a;#text-field-address;#text-field-address2;#text-field-city;"
				+ "span[name*='state'];ul[id*='stateSelectBoxItOptions']>li>a;#text-field-zipcode;#text-field-phone";
		
		}else if(object.equalsIgnoreCase("Address_Guest")){
			FiledsIds = "span[name='title'];ul[id*='titleSelectBoxItOptions']>li>a;#text-field-firstname;#text-field-lastname;"
					+ "span[name='countryCode'];ul[id*='countrySelectBoxItOptions']>li>a;#text-field-address;#text-field-address2;#text-field-city;"
					+ "span[name='stateCode'];ul[id*='stateSelectBoxItOptions']>li>a;#text-field-zipcode;#text-field-phone;#billing-field-email";
		 
		}else if(object.equalsIgnoreCase("Credit_Card_Details")){
			FiledsIds = "#field-text-card-name;#field-text-card-number;#field-text-card-cvv;span[name='expiration[month]'];"
			 		+ "#text-field-card-expire-monthSelectBoxItOptions>li>a;span[name='expiration[year]'];#text-field-card-expire-yearSelectBoxItOptions>li>a";
		}else if(object.equalsIgnoreCase("MyProfile_Details")){		
			
			FiledsIds = "span[name='title'];ul[id*='titleSelectBoxItOptions']>li>a;#field-text-firstname;#field-text-lastname;#field-text-birthday;"
					+ "#field-text-anniversary;"
					+ "span[name='gender'];ul[id*='genderSelectBoxItOptions']>li>a;span[name='country'];ul[id*='country-dropdownSelectBoxItOptions']>li>a;"
					+ "span[name='state'];ul[id*='state-profileSelectBoxItOptions']>li>a;#text-field-city;#ap-email-signup[type='checkbox']";
//					+ ".field-container.field-radio.field-max.ap-email .input-wrapper>.input-wrapper>label;"
//					+ ".field-container.field-radio.field-max.ap-gender>.input-wrapper>.input-wrapper>label;#ap-email-signup[type='checkbox']";
		}else if(object.equalsIgnoreCase("MyProfile_EPS_Details")){		
			
			FiledsIds = "span[name='title'];ul[id*='titleSelectBoxItOptions']>li>a;#field-text-firstname;#field-text-lastname;#field-text-birthday;"
					+ "#field-text-anniversary;span[name='gender'];ul[id*='genderSelectBoxItOptions']>li>a"
					+ "span[name='state'];ul[id*='state-profileSelectBoxItOptions']>li>a;#text-field-city";					
//					+ ".field-container.field-radio.field-max.ap-email .input-wrapper>.input-wrapper>label;"
//					+ ".field-container.field-radio.field-max.ap-gender>.input-wrapper>.input-wrapper>label;#ap-email-signup[type='checkbox']";
		}
		else{
//			System.out.println("Object not found:" + object);
		}	
//		performAction(element, ActionEnum.CLICK_CHECK_BOX,input);
//		//logger.log(LogStatus.PASS, "clicked checkbox - " + input);
//		test.pass("clicked checkbox - " + input);		
		List<String> strlData = Arrays.asList(input.split(";",-1));
		List<String> strlIDs = Arrays.asList(FiledsIds.split(";",-1));
		System.out.println(strlData);
		WebDriverWait wait = new WebDriverWait(driver,5);
//		wait.until(ExpectedConditions.visibilityOf(element));
		
		for(int i=0;i<strlIDs.size();i++){
//			System.out.println(strlData.size());	
//			System.out.println(i);
			//	for(int j=i;j<strlData.size();j++){
					
					System.out.println(strlIDs.get(i).trim());
					System.out.println(strlData.get(i).trim());
				
				if(strlIDs.get(i).trim().contains("name") && strlIDs.get(i).trim().contains("span")){
					WebElement element  = driver.findElement(By.cssSelector(strlIDs.get(i)));	
					wait.until(ExpectedConditions.visibilityOf(element));
					
					element.click();
					continue;
				}else if(strlIDs.get(i).trim().contains("Options")){
					List<WebElement> element  = driver.findElements(By.cssSelector(strlIDs.get(i).trim()));
					for(WebElement ele:element)
					{	
						System.out.println(strlData.get(i).trim());
						System.out.println(ele.getAttribute("textContent"));
						String comp = ele.getAttribute("textContent");
						if(comp.equalsIgnoreCase(strlData.get(i).trim())){
							System.out.println(ele.getAttribute("textContent"));
							ele.click();					
						break;							
						}						
					}
				}else if(strlIDs.get(i).trim().contains("field-radio")){
					List<WebElement> element  = driver.findElements(By.cssSelector(strlIDs.get(i).trim()));
					for(WebElement ele:element)
					{
						System.out.println(ele.getAttribute("textContent"));						
						if(ele.getAttribute("textContent").equalsIgnoreCase(strlData.get(i).trim())){
						ele.click();							
						continue;							
						}						
					}					
				}else if(strlIDs.get(i).trim().contains("anniversary")){
					WebElement element  = driver.findElement(By.cssSelector(strlIDs.get(i).trim()));
//					
//					DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
//					Date date = new Date();	
					element.clear();
//					element.sendKeys(dateFormat.format(date));	
					element.sendKeys("08/18/2015");
					continue;
				}	
				else if(strlIDs.get(i).trim().contains("checkbox")){
					
					WebElement element  = driver.findElement(By.cssSelector(strlIDs.get(i).trim()));
					if(element.getAttribute("value").equalsIgnoreCase("y")){
						System.out.println("Check box already checked");
						element.click();
						
					}
					else{
						element.click();
						continue;
					}										
					
				}
				else{
					WebElement element  = driver.findElement(By.cssSelector(strlIDs.get(i).trim()));
					//System.out.println(element.getText());
					wait.until(ExpectedConditions.visibilityOf(element));
					element.clear();
					element.sendKeys(strlData.get(i).trim());
					continue;
				}
					
						
		//	}
		}
	
		
		}
		
		
		catch (Exception e)
		{
			try{
	//	System.out.println(e.toString());
		ClosePopUp closepopup = new ClosePopUp();
		closepopup.CloseallPopUp();
			
		 fillform();
	        	         		
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

	private String strlIDs(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
