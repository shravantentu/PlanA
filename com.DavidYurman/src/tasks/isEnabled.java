package tasks;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import appObjects.AppObjects;

public class isEnabled extends VRSuperClass {

	public void isenabled() throws IOException, InterruptedException {
		
		Logger logger = Logger.getLogger("");
		logger.info("getting step details - isEnabled");
		
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		logger.info("Fetched object id : " + objectID);
		String input = stepsObject.getInputData();
		logger.info("Fetched inputData : " + input);
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		logger.info("screenName : " + screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );		
		performAction(element, ActionEnum.IS_ENABLED,input);
	}
}
