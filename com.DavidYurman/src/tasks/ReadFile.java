/**
 * 
 */
package tasks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.BufferedReader;

import java.io.FileReader;

import library.CaptureScreenshot;

//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;


public class ReadFile extends VRSuperClass {

	public static void readfile() throws IOException, InterruptedException{
		try{
		System.out.println("Get text");
		
		
		
		System.out.println("entered readMethod");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		//String input = stepsObject.getInputData();
		//System.out.println("Fetched inputData" + input);
		
		

		
		
		BufferedReader br = null;
        String strLine = "";
        try {
   
            br = new BufferedReader( new FileReader("D:\\vicroads-selenium\\vicroads-selenium1\\PPAnumber\\output.txt"));
            //Read the file Line by Line till Null value is encountered
            while( (strLine = br.readLine()) != null){
                //display each line
                System.out.println(strLine);
                outputtext = strLine; 
                //logger.log(LogStatus.PASS, "Text read from output.txt file - " + outputtext);
                test.pass("Text read from output.txt file - " + outputtext);
            }
        } catch (FileNotFoundException e) {
            //Display error message if File was not found
            System.err.println("Unable to find the file");
        } catch (IOException e) {
            //Display error message if an exception is encountered while reading the file
            System.err.println("Unable to read the file");
        }
		
		}
		
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Read_File_Failed"); 
			
			test.fail("Read_File_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;
			

		}
	  
	    
	  
	    
	}

}

