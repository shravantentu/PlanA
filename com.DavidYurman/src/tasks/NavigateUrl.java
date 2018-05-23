/**
 * 
 */
package tasks;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import library.CaptureScreenshot;


//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class NavigateUrl extends VRSuperClass {

	public void navigateUrl(String url) throws IOException, InterruptedException{
		
		try{
			
		System.out.println("Entered navigateTo method");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetched object id" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("Fetched inputData " +input );
		 forappend = input; 
		
		 AppObjects appObjects = new AppObjects();

			TasksObject tasksObject = new TasksObject();
			
					
			 //WebDriver driver=new FirefoxDriver();
						 
				String browser = GetDataFromExcel.ReadConfig("browser");
				System.out.println("Browser: " + browser);
				
				String aut = GetDataFromExcel.ReadConfig(url);
				System.out.println("URL: " + aut);
				
			loadBrowser(browser, aut);
			//Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			
		
		if ((input)!= null) {
			//driver.navigate().to(input);
			System.out.println(input + " is present");
			//logger.log(LogStatus.PASS, "navigated to - " + aut);
			test.pass("navigated to - " + url);
		} else{
			System.out.println(input + " is not present");
			//logger.log(LogStatus.PASS, "unable to navigate to - " + aut);
			test.pass("unable to navigate to - " + url);
		}
		}
		
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Navigate_URL_Failed"); 
			
			test.fail("Navigate_URL_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;
			

		}
		
	}
	public void navigateportalUrl() throws IOException, InterruptedException{
		
		try{
		System.out.println("Entered navigateTo method");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetched object id" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("Fetched inputData " +input );
		 forappend = input; 
		
		 AppObjects appObjects = new AppObjects();

			TasksObject tasksObject = new TasksObject();
			
				
					
			 //WebDriver driver=new FirefoxDriver();
				
				
			

			 
				String browser = GetDataFromExcel.ReadConfig("browser");
				System.out.println("browser" + browser);
				
				String port = GetDataFromExcel.ReadConfig("port");
				System.out.println("port" + port);
				
			loadBrowser(browser, port);
			
		 //loadBrowser("chrome", );
		
		Thread.sleep(10000);
		//driver.navigate().refresh();
		//Thread.sleep(20000);
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		
		if ((input)!= null) {
			//driver.navigate().to(input);
			System.out.println(input + " is present");
			//logger.log(LogStatus.INFO, "navigated to url");
		} else{
			System.out.println(input + " is not present");
			//logger.log(LogStatus.INFO, "not able to open desired url");
		}
		}
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Navigate_URL_Failed"); 
			
			test.fail("Navigate_URL_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;
			

		}
		
	}
	

}
