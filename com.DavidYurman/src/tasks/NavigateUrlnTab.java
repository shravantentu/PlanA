/**
 * 
 */
package tasks;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;
import library.CaptureScreenshot;


//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class NavigateUrlnTab extends VRSuperClass {

	public void navigateUrl(String url) throws IOException, InterruptedException{
		
		try{
			
		System.out.println("Entered navigateTo method");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("Fetched object id" +objectID );
		String input = stepsObject.getInputData();		
		
		 AppObjects appObjects = new AppObjects();

			TasksObject tasksObject = new TasksObject();
			
					
			 //WebDriver driver=new FirefoxDriver();
									
				String aut = GetDataFromExcel.ReadConfig(url);
				
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
				//driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
				
				
				System.out.println("URL: " + aut);
				aut = "http://stg3.davidyurman.com/content/david-yurman/en_us/products/men/rings.html";
				driver.get(aut);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				  
				  
				  //Initially bellow given if condition will check ready state of page.
				  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
				   System.out.println("Page Is loaded.");
				   return; 
				  } 
				
			//	driver.findElement(By.cssSelector("")).sendKeys(Keys.CONTROL +"t");

			 //   ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			 //   driver.switchTo().window(tabs.get(1)); //switches to new tab
			    
				
		
		Thread.sleep(10000);
		//driver.navigate().refresh();
		//Thread.sleep(20000);
		driver.manage().window().maximize();
		//Thread.sleep(2000);
		
		if ((input)!= null) {
			//driver.navigate().to(input);
			System.out.println(input + " is present");
			//logger.log(LogStatus.PASS, "navigated to - " + aut);
			test.pass("navigated to - " + url);
		} else{
			System.out.println(input + " is not present");
			//logger.log(LogStatus.PASS, "unable to navigate to - " + at);
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
	public void navigateportalUrl() throws Exception{
		
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
			 Robot robot = new Robot();
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_T);

			    Set<String> handles = driver.getWindowHandles();
			    List<String> handlesList = new ArrayList<String>(handles);
			    String newTab = handlesList.get(handlesList.size() - 1);
				
			

			 
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
