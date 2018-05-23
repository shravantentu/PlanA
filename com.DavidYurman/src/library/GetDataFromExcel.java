package library;

import tasks.ObjectProperty;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tasks.TasksObject;
import tasks.VRSuperClass;
import tasks.StepObject;
import tasks.TestCasesObject;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Row;

public class GetDataFromExcel extends VRSuperClass {
	private static XSSFSheet ExcelWSheet;
	 
	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	public static int rownum;
	public static int colnum;

	public static HashMap<String, String> propValues = new HashMap<String, String>();
//	public static String ID;
//	public static String name;
//	public static String xpath;
	
	
	public static Map<String, String> readToList(String orPath) throws IOException {
		
		FileInputStream fileInput = new FileInputStream(new File(orPath));
		Properties prop = new Properties();
		prop.load(fileInput);
		
		for(HashMap.Entry<Object, Object> entry : prop.entrySet()){
			propValues.put((String)entry.getKey(), (String)entry.getValue());
		//	System.out.println((String)entry.getKey());
		//	System.out.println((String)entry.getValue());
		}
		
		return propValues;	
		
	}
	
public static Map<String, ObjectProperty> getObjectProperties(HashMap<String, String> keyValuePair) throws IOException {
	Iterator it = keyValuePair.entrySet().iterator();
	String objectId = null;
	String id = null;
	String idValue = null;
	String name = null;
	String nameValue = null;
	String xpath = null;
	String xpathValue = null;
	String[] value = null;
	
//	for (Iterator<String> iterator = keyValuePair.iterator(); iterator.hasNext();) {
//		String objectValue = (String) iterator.next();
//		
//	}
	
	
	
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
//        System.out.println(pair.getKey() + " = " + pair.getValue());
        objectId = pair.getKey().toString(); 
//        System.out.println("object: " + objectId);
        it.remove(); // avoids a ConcurrentModificationException
        value = pair.getValue().toString().split("\\|");
        id = value[0].split(":")[0];
        id=id.replace("\"", "").trim();
//        System.out.println("id: "+id);
        idValue = value[0].split(":")[1];
//        System.out.println("idValue"+idValue);
        name = value[1].split(":")[0];
//        System.out.println("name"+name);
        nameValue = value[1].split(":")[1];
//        System.out.println("nameValue: "+nameValue);
        xpath = value[2].split(":")[0];
//        System.out.println("xpath: "+xpath);
        xpathValue = value[2].split(":")[1];
        xpathValue=xpathValue.replace("\"", "").trim();
//        System.out.println("xpathValue"+xpathValue);
        ObjectProperty ob = new ObjectProperty(objectId,id,idValue,name,nameValue,xpath,xpathValue);
        objectPropertyMap.put(objectId.trim(), ob);
        }
        	
		return objectPropertyMap;	
		
	}
	

	public static ArrayList<String> readTestCaseNamesList() throws IOException 

	{
	String Config = System.getProperty("user.dir") + "\\TestData\\DataSheets\\Config.xlsx";
		ArrayList<String> tcNames = new ArrayList<String>();
	FileInputStream ExcelFile = new FileInputStream(Config);
	ExcelWBook = new XSSFWorkbook(ExcelFile);
	ExcelWSheet = ExcelWBook.getSheet("Index");
	Iterator<Row> iterator = ExcelWSheet.iterator();

	while (iterator.hasNext()) {
		Row nextRow = iterator.next();
		Iterator<Cell> cellIterator = nextRow.cellIterator();
		while (cellIterator.hasNext()) {
			DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
			 Cell cell = cellIterator.next();
			 String value = formatter.formatCellValue(cell);
//			System.out.println(value);
			if(value.equalsIgnoreCase("Execute")){
				rownum = cell.getRowIndex();
				colnum = cell.getColumnIndex();
//				System.out.println("row is" + rownum + "col is" +colnum );
				break;
			}
		}
	}
	for(int i=rownum+1;i<=ExcelWSheet.getLastRowNum();i++)
	{
		DataFormatter formatter = new DataFormatter();
		Cell cell = ExcelWSheet.getRow(i).getCell(colnum);
		String value = formatter.formatCellValue(cell);
//		System.out.println("Execution" + value);
		if(value.equalsIgnoreCase("Y"))
		{
			cell=ExcelWSheet.getRow(i).getCell(colnum+1);
			value = formatter.formatCellValue(cell);
			tcNames.add(value);
		}
		
	}
	for(int j=0;j<tcNames.size();j++){
//		System.out.println("tc name is  " + tcNames.get(j));
	}
	return tcNames;
}
	
	public static List<List<String>> readTestSuiteToList(String Path) throws IOException {
		List<List<String>> values = new ArrayList<List<String>>();
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet("Index");
		Iterator<Row> iterator = ExcelWSheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			while (cellIterator.hasNext()) {
				DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
				 Cell cell = cellIterator.next();
				 String value = formatter.formatCellValue(cell);
				if(value.equalsIgnoreCase("Execute")){
//					System.out.println("cell Values" + value);
					rownum = cell.getRowIndex();
					colnum = cell.getColumnIndex();
//					System.out.println("row is" + rownum + "col is" +colnum );
					break;
				}
			}
		}
		
		List<String> inputDataFiles = new ArrayList<String>();
		Iterator<Row> iterator1 = ExcelWSheet.iterator();
		String testScenarioId = "noValue";
		int count = -1;
		for(int j=colnum; j<=5 ;j++ )
		{
			for(int i=rownum+1; i<=ExcelWSheet.getLastRowNum();i++)
			{
				DataFormatter formatter = new DataFormatter();
																																																																																																																																																																																																																																																																																																																																																																																																																																																Cell cell=ExcelWSheet.getRow(i).getCell(j);
				String value = formatter.formatCellValue(cell);
				List<String> lineStr = new ArrayList<String>();
				if(value.equalsIgnoreCase("Y"))
				{
					testScenarioId = "";
					count++;
					Cell cell1=ExcelWSheet.getRow(i).getCell(colnum+1);
//					System.out.println("aut ID" + cell1);
					String automationID = formatter.formatCellValue(cell1);
					lineStr.add(automationID);
					
					String testDesc = "";
					Cell cell2=ExcelWSheet.getRow(i).getCell(colnum+3);
//					System.out.println("test desc" + cell2);
					testDesc  = formatter.formatCellValue(cell2);
					lineStr.add(testDesc );
					
					String module = "";
					Cell cell3=ExcelWSheet.getRow(i).getCell(colnum+5);
//					System.out.println("module" + cell3);
					module   = formatter.formatCellValue(cell3);
					lineStr.add(module);
					
//					System.out.println("count" + count);
					values.add(count, lineStr);
				}
				
				
			}
		}
		
		Iterator iteratorN = values.iterator();
		while(iteratorN.hasNext()){
			String test = iteratorN.next().toString();
//			System.out.println("zzzzzzz" + test);
		}
		
		return values;
	}

	public static Map<Integer, TestCasesObject> getTestCasesToExec(List<List<String>> values){
		Map<Integer, TestCasesObject> testCasesMap = new HashMap<Integer, TestCasesObject>();
		int testScenario = 0;
		for (Iterator<List<String>> iterator = values.iterator(); iterator.hasNext();testScenario++) {
			List<String> testCasesList =  iterator.next();
			//String testScenarioId = "";
			String testCaseModule = "";
			String testCaseDesc = "";
			List<String> inputDataFiles = new ArrayList<String>();
			if(testCasesList.size() > 1 ) {
				TestScenarioId = testCasesList.get(0);
//				System.out.println("ItestScenarioId" + TestScenarioId);
				testCaseDesc = testCasesList.get(1);
//				System.out.println("ItestCaseDesc" + testCaseDesc);
				testCaseModule = testCasesList.get(2);
				testCaseModule.trim();
//				System.out.println("ItestCaseModule" + testCaseModule);
				
			}
			testCasesMap.put(testScenario, new TestCasesObject("",TestScenarioId,testCaseDesc,"","",testCaseModule));
		}
		return testCasesMap;
	}

	public static String[][] ReadSheet(String SuiteName, String SheetName) throws IOException{
		FileInputStream ExcelFile = new FileInputStream(SuiteName);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
//		System.out.println("Sheet name" + SheetName);
		int rowNum = ExcelWSheet.getLastRowNum()+1;
	    int colNum = 5;
	    String[][] data = new String[rowNum][colNum];
	    for (int i=0; i<rowNum; i++){
	        //get the row
	        XSSFRow row = ExcelWSheet.getRow(i);
	            for (int j=0; j<colNum; j++){
	                //this gets the cell and sets it as blank if it's empty.
	                XSSFCell cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
	                String value = String.valueOf(cell); 
	                if(value.length()>0){
	                	data[i][j] = value;
//		                System.out.println("Value: " + i + j + data[i][j]);
	                }
	            }            
	       }
	   // System.out.println("End Value:  " + data[0][2]);
	    return data;
	    }	
	
	public static String ReadConfig(String key) throws IOException{
		
	
		File f1 = new File("Config\\ECOM.properties");
		String path_temp = f1.getAbsolutePath();
		String path = path_temp.replace("\\","\\\\");
//		System.out.println("PATH" + path);
		FileInputStream fileInput = new FileInputStream(new File(path));
		Properties prop = new Properties();
		prop.load(fileInput);
		String value = prop.getProperty(key);
		return value;
	}
	
	public static String writetotext(String key, String value) throws IOException{
		
		
		File f1 = new File("Get_text\\gettext.txt");
		String path_temp = f1.getAbsolutePath();
		String path = path_temp.replace("\\","\\\\");
//		System.out.println("PATH" + path);
		FileInputStream fileInput = new FileInputStream(new File(path));
		FileOutputStream fileOut = new FileOutputStream(new File(path));
		Properties prop = new Properties();
		prop.load(fileInput);   //load(fileOut);		
		prop.setProperty(key,value);
		prop.store(fileOut, "save");
		fileOut.close();
//		System.out.println(prop.getProperty("Date saved to file"));
		
		
		
		return value;
	}
	public static String readfromtext(String key) throws IOException{
		
		
		File f1 = new File("Get_text\\gettext.txt");
		String path_temp = f1.getAbsolutePath();
		String path = path_temp.replace("\\","\\\\");
//		System.out.println("PATH" + path);
		FileInputStream fileInput = new FileInputStream(new File(path));
	//	FileOutputStream fileOut = new FileOutputStream(new File(path));
		Properties prop = new Properties();
		prop.load(fileInput);   //load(fileOut);		
		String propval = prop.getProperty(key);
		System.out.println(prop.getProperty("Date read from text"));		
		return propval;
	}
	
	
	public static HashMap<Integer, TasksObject> getTasksToExec(String value[][], String colName){
		int row = 0;
		int col = 0;

		HashMap<Integer, TasksObject> taskList = new HashMap<Integer, TasksObject>();
		String stepNumber = null;
		String stepName = null;
		Map<Integer, StepObject> steps = new HashMap<Integer,StepObject>();
		String objectID = null;
		String inputData = null;
		
		for (int i=0; i<value.length; i++)
		{
			for(int j=0; j<value[0].length;j++)
			{
				if (value[i][j] != null)
				{
					if (value[i][j].toString().trim().equals(colName))
					{ 													 					
						row = i+1;
						col = j;
					}
				}	
			}
		}
		int totalTasks = 0;
		
		
//		System.out.println("totalTasks"+totalTasks);
		
		boolean b = false;
		boolean nullCell = false;
		int count = 0;
		int taskCount = 0;
		TasksObject tasksObject = null;
		for(int i=row; i<value.length;i++)
		{
			if(value[i][col+1] == null && value[i][col+3] != null)
			{
				value[i][col] = "noValue";
				value[i][col+1] = "noValue";
				value[i][col+2] = "noValue";

			}else if (value[i][col+1] == null && value[i][col+4] == null){
				nullCell = true;
			}
			
			if(!nullCell)
			{
				if (value[i][col+1].trim().equals("Y")){
					if( tasksObject != null ){
						tasksObject.setSteps( steps );
						steps = new HashMap<Integer,StepObject>();
						count = 0;
					}
					if( value[i][col] != null && value[i][col] != "" ){
						stepNumber = value[i][col].trim();
//						System.out.println("stepNumber"+stepNumber);
						stepName = value[i][col+2].trim();
//						System.out.println("stepName"+stepName);
					}
					if(value[i][col+3] == null)
					{
						value[i][col+3] = "noValue";
					}
					if(value[i][col+4] == null)
					{
						value[i][col+4] = "noValue";
					}
					
					
					objectID = value[i][col+3].trim();
//					System.out.println("objectID"+objectID);
					inputData = value[i][col+4];
//					System.out.println("inputData"+inputData);
					tasksObject = new TasksObject(stepNumber, stepName, steps);
					taskList.put( taskCount, tasksObject);
					taskCount++;
					StepObject stepObject = new StepObject(inputData, objectID);
					steps.put( count, stepObject);
					b = true;
					count++;
				}
				if(value[i][col].trim().equals("noValue") && b)
				{
					if(value[i][col+3] == null)
					{
						value[i][col+3] = "noValue";
					}
					if(value[i][col+4] == null)
					{
						value[i][col+4] = "noValue";
					}
					objectID = value[i][col+3].trim();
//					System.out.println("objectID"+objectID);
					inputData = value[i][col+4].trim();
//					System.out.println("inputData"+inputData);
					StepObject stepObject = new StepObject(inputData, objectID);
					
					steps.put( count, stepObject);
					count++;
				}
				
				if(i != value.length-1 && value[i+1][col+1] != null)
				{
					if (value[i+1][col+1].trim().equals("N"))
						b = false;
				}
				
			}
			
		}
		if( tasksObject != null )
			tasksObject.setSteps( steps );
		
		return taskList;
	}
}

