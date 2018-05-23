package library;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	   public String screenprint;
       public String getScreen(WebDriver driver, String name) throws IOException {
    	   
    	   
              
              Date curDate = new Date();
              Date date = Calendar.getInstance().getTime();
              SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
              String DateToStr = format.format(curDate);
              format = new SimpleDateFormat("dd-M-yyyy HH mm ss");
              DateToStr = format.format(curDate);
              System.out.println(DateToStr);
              String timeOnly = DateToStr.substring(10, 18);
              System.out.println(timeOnly);
              timeOnly = timeOnly.replace(' ', '_');
              
              File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
              screenprint = library.Output.screenshotDir + "\\" + name + timeOnly + "_screenshot.png";
              FileUtils.copyFile(scrFile, new File(screenprint));
              String path = library.Output.screenshotDir + "\\" + name + timeOnly + "_screenshot.png";
          
              return path;
              
       }
}

