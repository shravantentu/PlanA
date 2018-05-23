/**
 * 
 */
package tasks;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TasksObject;

public class ClickBack extends VRSuperClass {

	public void clickBack() throws IOException, InterruptedException{
		System.out.println("Click back");
		performAction(ActionEnum.CLICK_BACK);
	}

}
