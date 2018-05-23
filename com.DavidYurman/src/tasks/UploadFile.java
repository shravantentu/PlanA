/**
 * 
 */
package tasks;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import library.CaptureScreenshot;

//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;


public class UploadFile extends VRSuperClass {

	public void uploadfile() throws IOException, InterruptedException{
			try{
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("Fetched object " +object );
		String input = stepsObject.getInputData();
		System.out.println("Fetched inputData" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(object);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(object, screenName, "id");		
		element.click();
	    //logger.log(LogStatus.PASS, "uploaded file - " + input);
		test.pass("uploaded file - " + input);

	    StringSelection ss = new StringSelection(input);
	    System.out.println(ss);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	
	    Robot robot;
		try {
			robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    Thread.sleep(2000);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    Thread.sleep(2000);
		    
		} catch (AWTException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
			}
			
			catch (Exception e)
			{
				  
				 CaptureScreenshot sc = new CaptureScreenshot();
				screenshotPath = sc.getScreen(driver,"UploadFile_Failed"); 
				
				test.fail("UploadFile_Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
				
				throw e;
				

			}
	}

}

