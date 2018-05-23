package appObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tasks.VRSuperClass;
import tasks.ObjectProperty;

/**
 * Description : Functional Test Script
 * 
 * @author
 * @author
 * @Date
 * @update
 */

public class AppObjects extends VRSuperClass {

	public static ObjectProperty getObjectLocator(String ObjectID) {
		ObjectProperty obj = objectPropertyMap.get(ObjectID);
		return obj;
	}

	public static List<WebElement> getUIObjects(String ObjectID, String ScreenName, String locatorType) {

		List<WebElement> elem = null;

		if (locatorType.equalsIgnoreCase("xpath")) {
			System.out.println("XPATH" + ObjectID + objectPropertyMap.get(ObjectID).getXpathValue());
			elem = driver.findElements(By.xpath(objectPropertyMap.get(ObjectID).getXpathValue()));

		}
		if (locatorType.equalsIgnoreCase("id")) {
			elem = driver.findElements(By.cssSelector(objectPropertyMap.get(ObjectID).getidValue()));
			System.out.println("ifworking");
		}
		if (locatorType.equalsIgnoreCase("name")) {
			elem = driver.findElements(By.name(objectPropertyMap.get(ObjectID).getNameValue()));
		}
		return elem;
	}
	
	public static WebElement getUIObject(String ObjectID, String ScreenName, String locatorType) {

		WebElement ele = null;

		if (locatorType.equalsIgnoreCase("xpath")) {
			System.out.println("XPATH" + ObjectID + objectPropertyMap.get(ObjectID).getXpathValue());
			ele = driver.findElement(By.xpath(objectPropertyMap.get(ObjectID).getXpathValue()));

		}
		if (locatorType.equalsIgnoreCase("id")) {
			ele = driver.findElement(By.cssSelector((objectPropertyMap.get(ObjectID).getidValue())));
		}
		if (locatorType.equalsIgnoreCase("name")) {
			ele = driver.findElement(By.name(objectPropertyMap.get(ObjectID).getNameValue()));
		}
		return ele;
	}

	public static boolean waitForElement(String ObjectID, String ScreenName, String locatorType) throws InterruptedException {
		boolean flag = false ;
		WebElement webele = null;
		do {
			try {
				if (locatorType.equalsIgnoreCase("xpath")) {
					System.out.println("XPATH" + ObjectID + objectPropertyMap.get(ObjectID).getXpathValue());
					//webele = driver.findElement(By.xpath(objectPropertyMap.get(ObjectID).getXpathValue()));
					webele = (new WebDriverWait(driver, 50)).until(ExpectedConditions.elementToBeClickable(By.xpath(objectPropertyMap.get(ObjectID).getXpathValue())));
					flag = true;
				}
				if (locatorType.equalsIgnoreCase("id")) {
					webele = (new WebDriverWait(driver, 50)).until(ExpectedConditions.elementToBeClickable(By.id(objectPropertyMap.get(ObjectID).getidValue())));
					flag = true;
				}
				if (locatorType.equalsIgnoreCase("name")) {
					webele = (new WebDriverWait(driver, 50)).until(ExpectedConditions.elementToBeClickable(By.name(objectPropertyMap.get(ObjectID).getNameValue())));
					flag = true;
				}
				
				break;
			} catch (Exception e) {
				Thread.sleep(2500);
				continue;
			}
		} while (!flag);
		
		return flag;

	}
}
