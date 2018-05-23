package tasks;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;

import library.CaptureScreenshot;

public class ClosePopUp extends VRSuperClass{

	public void CloseallPopUp() throws Exception  {
		
		try{

			if(driver.findElement(By.cssSelector("#dy-insider-subscribe-form[novalidate='novalidate']")).isEnabled()){
				Thread.sleep(2000);
				driver.findElement(By.cssSelector(".mfp-close")).click(); 
	    		System.out.println("Pop up closed");
	    		Thread.sleep(2000);
	    		}		
			
	}catch (Exception e)
		{
		  
		 CaptureScreenshot sc = new CaptureScreenshot();
		screenshotPath = sc.getScreen(driver,"exception"); 
		e.printStackTrace();
		test.fail("exception",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
		throw e;

	}

}
}

