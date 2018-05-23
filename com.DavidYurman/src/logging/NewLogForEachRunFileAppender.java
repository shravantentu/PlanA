package logging;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Category;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.ErrorCode;


/**
 * Script Name   : <b>NewLogForEachRunFileAppender</b>
 * Generated     : <b>March 27, 2012 3:13:05 PM</b>
 * Description   : Exports Content XML to default location from a FolderName specified 
 * Original Host : WinNT Version 6.0  Build 6002 (S)
 * 
 * Log detailed flow of a TestScenario
 * 
 * @since  2012/03/27
 * @author redara 
 */
public class NewLogForEachRunFileAppender extends FileAppender {   
	public NewLogForEachRunFileAppender() 
	{ 
	}
	
	public NewLogForEachRunFileAppender(Layout layout, String filename, 
			boolean append, boolean bufferedIO, int bufferSize) throws IOException {     
		super(layout, filename, append, bufferedIO, bufferSize); 
	}   
	
	public NewLogForEachRunFileAppender(Layout layout, String filename,         
			boolean append) throws IOException {     
		super(layout, filename, append); 
	}   
	
	public void activateOptions() 
	{ 
		if (fileName != null) {     
			try {         
				fileName = getNewLogFileName();         
				setFile(fileName, fileAppend, bufferedIO, bufferSize);     
			} catch (Exception e) {        
				errorHandler.error("Error while activating log options", e,                 
					ErrorCode.FILE_OPEN_FAILURE);     
			} 
		} 
	}
	
	private String getNewLogFileName() 
	{ 
		System.out.println("creating new log file");
		if (fileName != null) {    
			final String DOT = ".";     
			final String HIPHEN = "-";     
			final File logFile = new File(fileName);     
			final String fileName = logFile.getName();     
			String newFileName = "";       

			Date currentDate = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm");

			final int dotIndex = fileName.indexOf(DOT);     
			if (dotIndex != -1) {         
				// the file name has an extension. so, insert the time stamp         
				// between the file name and the extension         
				newFileName = fileName + HIPHEN + date.format(currentDate).toString() + ".txt";
				fileName.substring(dotIndex + 1);     
			} else {         
				// the file name has no extension. So, just append the timestamp         
				// at the end.         
				newFileName = fileName + HIPHEN + date.format(currentDate).toString() + ".txt";
			}     
			return logFile.getParent() + File.separator + newFileName; 
		} 
		return null; 
	} 
} 

