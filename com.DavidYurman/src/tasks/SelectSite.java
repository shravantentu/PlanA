package tasks;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import library.CaptureScreenshot;

public class SelectSite extends VRSuperClass{

		
	public void SelectSitelang() throws InterruptedException, IOException,org.openqa.selenium.NoSuchElementException  {
			
			try{
				
			WebElement fram = driver.findElement(By.id("lightbox_pop"));
			driver.switchTo().frame(fram);
			
			driver.findElement(By.cssSelector("#select-countries-styled")).click();
			//	Thread.sleep(1000);
			driver.findElement(By.cssSelector("#select-countries-ulstyled>li[rel='us']")).click();

			driver.findElement(By.cssSelector(".continue.submitButton")).click();			
			driver.switchTo().defaultContent();

		}catch(org.openqa.selenium.NoSuchElementException ex)
			{			  
			System.out.println("No popup displayed to select DY site language");
			}
			
		catch (Exception e){	
			e.printStackTrace();
			CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"exception"); 
			e.printStackTrace();
			test.fail("exception",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;
		}
			

		}	

	}
	


	


