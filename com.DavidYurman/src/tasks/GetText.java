/**
 * 
 */
package tasks;

import java.io.BufferedWriter;
import java.io.File;
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


public class GetText extends VRSuperClass {

	public void gettext() throws IOException, InterruptedException{
	
	try{	
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("Fetched object" +object );
		//String input = stepsObject.getInputData();
		//System.out.println("Fetched inputData" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(object);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		if (object.equals("ACTIVATION_readtoken_readtext") ){
			WebElement element = AppObjects.getUIObject(object, screenName, "xpath");		
			String ppanum = element.getText();
			System.out.println(ppanum);
		    //logger.log(LogStatus.PASS, "Text added to output.txt file -" + ppanum);
           test.pass("Text added to output.txt file -" + ppanum);
		    String directory = "D:\\vicroads-selenium\\vicroads-selenium1\\PPAnumber";
		    File dir = new File(directory);
		    if (!dir.exists()) {
				if (dir.mkdir()) {
					System.out.println("Get text file is created!");
					dir.mkdir();
				} else {
					System.out.println("Failed to create get text file!");
				}
			}
		    
		    String file2 = "output" + ".txt";
		    String TestFile = "D:\\vicroads-selenium\\vicroads-selenium1\\PPAnumber" ;
		    String PPAnumber = TestFile + "\\" + file2;
		    File FC = new File(PPAnumber);//Created object of java File class.
		    FC.createNewFile();//Create file.
		    
		    //Writing In to file.
		    //Create Object of java FileWriter and BufferedWriter class.
		    FileWriter FW = new FileWriter(PPAnumber);
		    BufferedWriter BW = new BufferedWriter(FW);
		    BW.write(ppanum); //Writing In To File.
		    //BW.newLine();//To write next string on new line.
		    //BW.write("This Is Second Line."); //Writing In To File.
		    BW.close();
		  
			}
		else {
		WebElement element = AppObjects.getUIObject(object, screenName, "id");		
		String ppanum = element.getText();
		System.out.println(ppanum);
		//logger.log(LogStatus.PASS, "Text added to output.txt file -" + ppanum);
		test.pass("Text added to output.txt file -" + ppanum);
	    String directory = "D:\\vicroads-selenium\\vicroads-selenium1\\PPAnumber";
	    File dir = new File(directory);
	    if (!dir.exists()) {
			if (dir.mkdir()) {
				System.out.println("Get text file is created!");
				dir.mkdir();
			} else {
				System.out.println("Failed to create get text file!");
			}
		}
	    
	    String file2 = "output" + ".txt";
	    String TestFile = "D:\\vicroads-selenium\\vicroads-selenium1\\PPAnumber" ;
	    String PPAnumber = TestFile + "\\" + file2;
	    File FC = new File(PPAnumber);//Created object of java File class.
	    FC.createNewFile();//Create file.
	    
	    //Writing In to file.
	    //Create Object of java FileWriter and BufferedWriter class.
	    FileWriter FW = new FileWriter(PPAnumber);
	    BufferedWriter BW = new BufferedWriter(FW);
	    BW.write(ppanum); //Writing In To File.
	    //BW.newLine();//To write next string on new line.
	    //BW.write("This Is Second Line."); //Writing In To File.
	    BW.close();
	  
	    
	    //FileReader FR = new FileReader(TestFile);
	   // BufferedReader BR = new BufferedReader(FR);
	    //String Content = "";
		}
	}
	
	catch (Exception e)
	{
		  
		 CaptureScreenshot sc = new CaptureScreenshot();
		screenshotPath = sc.getScreen(driver,"Get_Text_Failed"); 
		e.printStackTrace();
		test.fail("Get_Text_Failed",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
		throw e;

	}
	}

}

