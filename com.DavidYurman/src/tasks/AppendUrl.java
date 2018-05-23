/**
 * 
 */
package tasks;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import library.CaptureScreenshot;

//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;
import tasks.TestDataEnum;

public class AppendUrl extends VRSuperClass {
	
	
	
	String urlvalue = "";

	public void navigateUrl() throws IOException, InterruptedException{
		
		try{
		System.out.println("Entered navigateTo method");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetched object id" +objectID );
		//String input = stepsObject.getInputData();
		TestDataEnum input = TestDataEnum.getTestDataEnum(stepsObject.getInputData()); 
		System.out.println("Fetched inputData" +input );
		
		//loadBrowser("Chrome", input);
		//driver.navigate().to(input);
		//Thread.sleep(10000);
		//driver.navigate().refresh();
		//Thread.sleep(20000);
		//driver.manage().window().maximize();
		//Thread.sleep(2000);
		

		//String test = "APPENDTOKEN";
		//System.out.println(objectID);
		//String finalurl = forappend + input;
		if ((input)!= null) {
			
			String aut = GetDataFromExcel.ReadConfig("aut");
			String port = GetDataFromExcel.ReadConfig("port");
			//System.out.println("aut" + aut);
			//if (objectID.equals("APPENDTOKEN") ){
				//String finalappend = aut + input + outputtext;
				//driver.navigate().to(finalappend);
			//}
			//else{
				switch(input){
				case uvpurl: {
					
					urlvalue = GetDataFromExcel.ReadConfig("uvpurl");
					String finalappend = aut + urlvalue;
					driver.navigate().to(finalappend);
					break;
				}
				
                 case rrurl: {
					
					urlvalue = GetDataFromExcel.ReadConfig("rrurl");
					String finalappend = aut + urlvalue;
					driver.navigate().to(finalappend);
					break;
				}
                 case uploadurl: {
 					
					urlvalue = GetDataFromExcel.ReadConfig("uploadurl");
					String finalappend = aut + urlvalue;
					driver.navigate().to(finalappend);
					break;
				}
                 case uploadurlfordownload: {
  					
 					urlvalue = GetDataFromExcel.ReadConfig("uploadurlfordownload");
 					String finalappend = aut + urlvalue;
 					driver.navigate().to(finalappend);
 					break;
 				}  
                 case activationurl1: {
  					
 					urlvalue = GetDataFromExcel.ReadConfig("activationurl1");
 					String finalappend = aut + urlvalue;
 					driver.navigate().to(finalappend);
 					break;
 				}
                 case activationurl2: {
   					
  					urlvalue = GetDataFromExcel.ReadConfig("activationurl2");
  					String finalappend = aut + urlvalue + outputtext;
  					driver.navigate().to(finalappend);
  					break;
  				}
                 case vreurl: {
 					
 					urlvalue = GetDataFromExcel.ReadConfig("vreurl");
 					String finalappend = aut + urlvalue;
 					driver.navigate().to(finalappend);
 					break;
 				}
				
                 case portalappssearchpartner: {
  					
  					urlvalue = GetDataFromExcel.ReadConfig("portalappssearchpartner");
  					String finalappend = port + urlvalue;
  					driver.navigate().to(finalappend);
  					break;
  				}
                 
                 
                 
                 
                 
                 case loginurl: {
  					
  					urlvalue = GetDataFromExcel.ReadConfig("loginurl");
  					String finalappend = aut + urlvalue;
  					driver.navigate().to(finalappend);
  					break;
  				}
                 case creditcard: {
   					
   					urlvalue = GetDataFromExcel.ReadConfig("creditcard");
   					String finalappend = aut + urlvalue;
   					driver.navigate().to(finalappend);
   					break;
   				}
                 case bankaccount: {
   					
   					urlvalue = GetDataFromExcel.ReadConfig("bankaccount");
   					String finalappend = aut + urlvalue;
   					driver.navigate().to(finalappend);
   					break;
   				}
                 
                 case transferurl: {
  					
  					urlvalue = GetDataFromExcel.ReadConfig("transferurl");
  					String finalappend = aut + urlvalue;
  					driver.navigate().to(finalappend);
  					break;
  				}
                 
                 case nvrurl: {
   					
   					urlvalue = GetDataFromExcel.ReadConfig("nvrurl");
   					String finalappend = aut + urlvalue;
   					driver.navigate().to(finalappend);
   					break;
   				}
                 case nvrsaveurl: {
    					
    					urlvalue = GetDataFromExcel.ReadConfig("nvrsaveurl");
    					String finalappend = aut + urlvalue;
    					driver.navigate().to(finalappend);
    					break;
    				}
                 
                 case nvrmotorcycleurl: {
   					
   					urlvalue = GetDataFromExcel.ReadConfig("nvrmotorcycleurl");
   					String finalappend = aut + urlvalue;
   					driver.navigate().to(finalappend);
   					break;
   				}
                 
                 case nvrstandardurl: {
   					
   					urlvalue = GetDataFromExcel.ReadConfig("nvrstandardurl");
   					String finalappend = aut + urlvalue;
   					driver.navigate().to(finalappend);
   					break;
   				}
                 
                 case nvrheavyvehicleurl: {
   					
   					urlvalue = GetDataFromExcel.ReadConfig("nvrheavyvehicleurl");
   					String finalappend = aut + urlvalue;
   					driver.navigate().to(finalappend);
   					break;
   				}
                 case nvrheavytrailerurl: {
    					
    					urlvalue = GetDataFromExcel.ReadConfig("nvrheavytrailerurl");
    					String finalappend = aut + urlvalue;
    					driver.navigate().to(finalappend);
    					break;
    				}
                 case nvrlighttrailerurl: {
    					
    					urlvalue = GetDataFromExcel.ReadConfig("nvrlighttrailerurl");
    					String finalappend = aut + urlvalue;
    					driver.navigate().to(finalappend);
    					break;
    				}
                 case partnerdashboard: {
    					
    					urlvalue = GetDataFromExcel.ReadConfig("partnerdashboard");
    					String finalappend = aut + urlvalue;
    					driver.navigate().to(finalappend);
    					break;
    				}
				case partnersignupurl: {
    					
    					urlvalue = GetDataFromExcel.ReadConfig("partnersignupurl");
    					String finalappend = aut + urlvalue;
    					driver.navigate().to(finalappend);
    					break;
    				} 
				case individualccurl: {
					
					urlvalue = GetDataFromExcel.ReadConfig("individualccurl");
					String finalappend = aut + urlvalue;
					driver.navigate().to(finalappend);
					break;
				}
                 case individualsignupurl: {
					
					urlvalue = GetDataFromExcel.ReadConfig("individualsignupurl");
					String finalappend = aut + urlvalue;
					driver.navigate().to(finalappend);
					break;
				}
                 case wovrurl: {
 					
 					urlvalue = GetDataFromExcel.ReadConfig("wovrurl");
 					String finalappend = aut + urlvalue;
 					driver.navigate().to(finalappend);
 					break;
 				}  
                 
                 case vrourl: {
  					
  					urlvalue = GetDataFromExcel.ReadConfig("vrourl");
  					String finalappend = aut + urlvalue;
  					driver.navigate().to(finalappend);
  					break;
  				} 
				
                 case indivPSurl: {
   					
   					urlvalue = GetDataFromExcel.ReadConfig("indivPSurl");
   					String finalappend = aut + urlvalue;
   					driver.navigate().to(finalappend);
   					break;
   				}
                 

                 case paymentpreferenceurl: {
 					
 					urlvalue = GetDataFromExcel.ReadConfig("paymentpreferenceurl");
 					String finalappend = aut + urlvalue;
 					driver.navigate().to(finalappend);
 					break;
 				}
                 
				}
				
				
			//System.out.println("aut" + aut);
			//String finalappend = aut + input;
				//driver.navigate().to(finalappend);
			//System.out.println(input + " is present");
			//logger.log(LogStatus.PASS, "appended url - " + urlvalue);
				test.pass("appended url - " + urlvalue);
		    } 
			
	
			else{
			System.out.println(input + " is not present");
			//logger.log(LogStatus.FAIL, "not able to append url");
			test.fail("not able to append url");
		}
		
		
	



}
	
catch (Exception e)
{
	  
	 CaptureScreenshot sc = new CaptureScreenshot();
	screenshotPath = sc.getScreen(driver,"Append_URL_Failed"); 
	
	test.fail("Append_URL_Failed",
			MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 

	throw e;

}
}
}