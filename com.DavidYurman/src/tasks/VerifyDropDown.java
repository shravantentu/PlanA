package tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import appObjects.AppObjects;


public class VerifyDropDown extends VRSuperClass {
	public void verifyDropDownMethod() throws IOException, InterruptedException {
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String object = stepsObject.getObjectId();
		System.out.println("fetched object" + object);
		String input = stepsObject.getInputData();
		System.out.println("fetched input" + input);
		ObjectProperty obj = AppObjects.getObjectLocator(object);
		String screenNameFull = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName" + screenName);

		WebElement element = AppObjects.getUIObject(object, screenName, "xpath");
		// performAction(element, ActionEnum.VERIFY_DROP_DOWN,input);

		StringTokenizer st1 = new StringTokenizer(input, ";");
		
		List<String> dropDownValues = new ArrayList<String>();
		while (st1.hasMoreTokens()) {
			dropDownValues.add(st1.nextToken().trim());
		}

		Select sel = new Select(element);
		List<WebElement> list = sel.getOptions();

		List<String> dropDownList = new ArrayList<String>();

		for (WebElement ele : list) {
			dropDownList.add(ele.getText().toString());
		}

		for (WebElement a : list) {
			for (String b : dropDownList) {

				if (b.equals(a)) {
					System.out.println(a + " is in the DropDown Options");
				}
			}
		}

	}
}
