package library;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Output {
	public static String subDirName;
	public static String screenshotDir;

	public static void outputFolder() throws IOException {
		Date curDate = new Date();
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String DateToStr = format.format(curDate);
		format = new SimpleDateFormat("dd-M-yyyy HH mm ss");
		DateToStr = format.format(curDate);
		System.out.println(DateToStr);
		String dateOnly = DateToStr.substring(0, 9);
		System.out.println(dateOnly);
		String timeOnly = DateToStr.substring(10, 18);
		System.out.println(timeOnly);
		String directory = "OutputRepository";
		String directoryName = directory + "\\" + dateOnly;
		File dir = new File(directoryName);
		if (!dir.exists()) {
			if (dir.mkdir()) {
				System.out.println("Output directory is created!");
				dir.mkdir();
			} else {
				System.out.println("Failed to create directory!");
			}
		}
		// dir.mkdir();
		timeOnly = timeOnly.replace(' ', '_');
		subDirName = directoryName + "\\" + timeOnly;
		File subDir = new File(subDirName);
		if (!subDir.exists()) {
			if (subDir.mkdir()) {
				System.out.println("Sub Output directory is created!");
				subDir.mkdir();
			} else {
				System.out.println("Failed to create directory!");
			}
		}
		screenshotDir = subDirName + "\\" + "Screenshots";
		File screenDir = new File(screenshotDir);
		if (!screenDir.exists()) {
			if (screenDir.mkdir()) {
				System.out.println("Sub Output directory is created!");
				screenDir.mkdir();
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}
}
