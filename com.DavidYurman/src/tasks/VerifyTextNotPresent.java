package tasks;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import appObjects.AppObjects;

public class VerifyTextNotPresent extends VRSuperClass {

	public void verifyTextNotPresent() throws IOException, InterruptedException, Exception{
		System.out.println("VerifyTextNotPresent");
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched object ID" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetched input" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);	
		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );	
		//System.out.println("VerifyTextNotPresent");
		String actualText = element.getText();
		System.out.println(actualText);
		//Assert.assertEquals(actualPage.contains(input), true);
		boolean result = actualText.contains(input);
		System.out.println(result);
		Assert.assertEquals(actualText.contains(input), false);
		//Assert.assertNull(element);
		//System.out.println("VerifyTextNotPresent over");
		//performAction(element,ActionEnum.VERIFY_TEXT_NOT_PRESENT,input);
	}
}
