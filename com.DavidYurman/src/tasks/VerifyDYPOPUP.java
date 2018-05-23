package tasks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

//import com.relevantcodes.extentreports.LogStatus;

import appObjects.AppObjects;
import library.CaptureScreenshot;


public class VerifyDYPOPUP extends VRSuperClass {
	public static void closepop() throws IOException, InterruptedException{
		
		try{
			WebElement element  = driver.findElement(By.cssSelector("#dy-insider-subscribe-form[novalidate='novalidate']"));
			if(element.isDisplayed()){
				driver.findElement(By.cssSelector(".mfp-close")).click(); 
	    		System.out.println("Pop up closed");
	    		Thread.sleep(1500);
			}
}
	
			catch (Exception e1)
			{
				  System.out.println("No DY POP up");

			}	
		}	
	}
	