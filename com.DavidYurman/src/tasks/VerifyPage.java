/**
 * 
 */
package tasks;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class VerifyPage extends VRSuperClass {

	public void verifyPageTitle() throws IOException, InterruptedException{
		

		
		System.out.println("verifyPageTitle");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("verifyPageTitle" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("verifyPageTitle" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);	
		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );	
		System.out.println("Verify page");
		String actualPage = element.getText();
		Assert.assertEquals(actualPage.contains(input),true);
		System.out.println("Verify page over");
		//performAction(element,ActionEnum.VERIFY_PAGE,input);
	}

}
