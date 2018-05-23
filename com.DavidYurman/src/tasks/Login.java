package tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appObjects.AppObjects;
import library.GetDataFromExcel;
import tasks.TasksObject;


public class Login extends VRSuperClass {
	public void execute() throws InterruptedException{
	System.out.println("inside Login");
	AppObjects appObjects = new AppObjects();

	String UserName = "";

	String Password = "";

	String ButtonName = "";
	System.out.println("inside Login");
	TasksObject tasksObject = new TasksObject();
	if(connection == false){
		try {
			String browser = GetDataFromExcel.ReadConfig("browser");
			System.out.println("browser" + browser);
			
			String aut = GetDataFromExcel.ReadConfig("aut");
			System.out.println("aut" + aut);
			
			String app_Url = GetDataFromExcel.ReadConfig(aut);
			System.out.println("app_URL" + app_Url);
                        String cms_wait=GetDataFromExcel.ReadConfig("cms_wait_time");
			System.out.println("cms_wait" + cms_wait);
                        //String cms_wait_no=GetDataFromExcel.ReadConfig(cms_wait);
			//System.out.println("cms_wait_no" + cms_wait_no);
			
			loadBrowser(browser, app_Url);
			performAction(ActionEnum.MAXIMIZE_SCREEN);
                        if(aut.equals("cms_br_url"))
				
			{waitforpageload(cms_wait);}
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> objectID = new ArrayList<String>();
		ArrayList<String> inputData = new ArrayList<String>();
		for (Iterator<Integer> stepsIter = TaskSteps.keySet().iterator(); stepsIter
				.hasNext();) {
				
				StepObject stepObject = TaskSteps.get(stepsIter.next());
				//TasksEnum task = TasksEnum.getTasksEnum(tasksObject.getStepName());			
				String StepName = tasksObject.getStepName();
				String StepNumber = tasksObject.getStepNumber();
				objectID.add(stepObject.getObjectId());
				System.out.println("objID" + objectID);
				inputData.add(stepObject.getInputData());
				System.out.println("InPut" + inputData);
		}
		
		try {
			System.out.println("login button over");
//			performAction(ActionEnum.MAXIMIZE_SCREEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//entering username
				try {
					StepObject stepsObject = TaskSteps.get(new Integer(0));
					String object = stepsObject.getObjectId();
					ObjectProperty obj = AppObjects.getObjectLocator(objectID.get(0));
					System.out.println("beforeswitch"+object);
					String screenNameFull  = obj.getObjectId();
					String screenName = screenNameFull.split("_")[0];
					Thread.sleep(1000);
					System.out.println("screenName"+screenName);
					WebElement element = AppObjects.getUIObject(objectID.get(0), screenName, "xpath" );		
					element.clear();
					performAction(element, ActionEnum.TEXT_BOX,inputData.get(0));

				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
		//entering password		
				try {
					StepObject stepsObject = TaskSteps.get(new Integer(1));
					String object = stepsObject.getObjectId();
					System.out.println("objectID.get(1)"+objectID.get(1));
					ObjectProperty obj = AppObjects.getObjectLocator(objectID.get(1));
					String screenNameFull  = obj.getObjectId();
					String screenName = screenNameFull.split("_")[0];
					System.out.println("screenName"+screenName);
					WebElement element = AppObjects.getUIObject(objectID.get(1), screenName, "xpath");	
					System.out.println("Passwordelement" +element);
					performAction(element, ActionEnum.TEXT_BOX,inputData.get(1));
					
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
		//clicking on login button	
				
				try {
					StepObject stepsObject = TaskSteps.get(new Integer(2));
					String object = stepsObject.getObjectId();
					ObjectProperty obj = AppObjects.getObjectLocator(objectID.get(2));
					String screenNameFull  = obj.getObjectId();
					String screenName = screenNameFull.split("_")[0];
					System.out.println("screenName"+screenName);
					WebElement element = AppObjects.getUIObject(objectID.get(2), screenName,"xpath" );
					performAction(element, ActionEnum.CLICK_BUTTON,inputData.get(2));
//					System.out.println("Before Maximise");
//					performAction(ActionEnum.MAXIMIZE_SCREEN);
					System.out.println("login button over");
				} catch (IOException | InterruptedException e) {
					System.out.println("error");
				}
				
		}
	if(connection==true){
		System.out.println("already logged in");
	}
	
		
	}		
	
	
}


