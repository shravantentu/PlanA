package tasks;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.LogStatus;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/*import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener; */


public class VRSuperClass {

	public static WebDriver driver;
	public static Map<Integer, StepObject> TaskSteps = new HashMap<Integer, StepObject>();

	public static Map<Integer, TasksObject> TaskList = new HashMap<Integer, TasksObject>();

	public static Map<String, ObjectProperty> ObjectTypeMap = new HashMap<String, ObjectProperty>();
	
	public static HashMap<String, ObjectProperty> objectPropertyMap = new HashMap<String, ObjectProperty>();
	
	public static String previousTaskName = "";
	public static String taskName = "";
	public static String itemName = "";
	public static String StepName = "TestMain";
	public static String StepNumber = "0";
	public static boolean connection = false;
	public static boolean elementfound = false;
	public static String oldTab;
	public static String cms_loginpage_wait;
	public static String forappend; 
	public static String outputtext;

	public static String screenshotPath;
	
	public static ExtentReports report;
	public static ExtentTest test; 
	public static ExtentHtmlReporter htmlReporter;
	public static String filePath = "./extentreport.html";

	
	public static String TestScenarioId;
	
	public static void performAction(WebElement element, ActionEnum fieldType, String inputData)
			throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,7);
		
		// ObjectProperty ob = new ObjectProperty();
		// List<String> locatorFull = new ArrayList<String>();
		switch (fieldType) {
		case TEXT_BOX: {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("switch case text box" + inputData);
		//	highlight(driver,element);
		//	element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), inputData);
			element.sendKeys(inputData);
			element.sendKeys(Keys.TAB);
			System.out.println("Value entered : " + inputData);
			break;
		}
		case TEXT_BOX_NUM: {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("switch case text box" + inputData);
		//	highlight(driver,element);
			//Integer inputnum = Integer.parseInt(inputData);
			
			//element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), inputData);
			//element.sendKeys("3234");
			element.sendKeys(Keys.TAB);
			System.out.println("Value entered : " + inputData);
			break;
		}
		case CLICK_BUTTON: {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("switch case button" + inputData + element);			
			element.click();			
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			break;
		}
		case CLICK_ICON: {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("switch case icon" + inputData);
		//	highlight(driver,element);
		//	element.click();
			Actions mouseActions = new Actions(driver);
			mouseActions.moveToElement(element).click().build().perform();			
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);	
			
			break;
		}
		case IS_DISPLAYED: {
			System.out.println("switch case isdisplayed" + inputData);
	//		highlight(driver,element);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			Assert.assertEquals(element.isDisplayed(), true);
			break;
		}
		case IS_ENABLED: {
			System.out.println("switch case isEnabled" + inputData);
	//		highlight(driver,element);
	//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			if(element.isEnabled()){
				System.out.println("Element enabled");
			}
			
	//		Assert.assertEquals(element.isEnabled(), true);
			System.out.println("Assert passed");
			break;
		}
		case IS_DISABLED: {
			System.out.println("switch case isDisabled" + inputData);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			if(!element.isEnabled()){
				System.out.println("Element disabled");
			}
			
			break;
		}
		case TAB: {
			System.out.println("switch case Tab");
			element.sendKeys(Keys.TAB);
			break;
		}
		case ENTER: {
			System.out.println("switch case Enter");
			element.sendKeys(Keys.ENTER);
			break;
		}
		// case VERIFY_PAGE:{
		// System.out.println("Verify page");
		// String actualPage = element.getText();
		// Assert.assertEquals(actualPage.contains(inputData), true);
		// System.out.println("Verify page over");
		// break;
		// }
		// case VERIFY_TEXT_NOT_PRESENT:{
		// System.out.println("switch case VERIFY_TEXT_NOT_PRESENT" +
		// inputData);
		// element.sendKeys(inputData);
		// element.sendKeys(Keys.TAB);
		// break;
		// }
		case CLICK_LINK: {
			try{
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("Verify click link");
		//	highlight(driver,element);
		//	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			element.click();
			}
			catch(Exception e){
				element.click();
			}
			break;
		}
		case SELECT_CHECKBOX_BUTTON: {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Verify click check box in Dynamic Table");
		//	highlight(driver,element);
			
			element.click();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		}	
		case IS_EXPANDED: {
			System.out.println(("switch case isexpanded " + inputData));
		//	highlight(driver,element);
			Assert.assertTrue(inputData.contains("_"), "Facets are not expanded");
			break;
		}
		case IS_COLLAPSED: {
			System.out.println(("switch case iscollapsed " + inputData));
			Assert.assertTrue(inputData.contains("+"), "Facets are not collapsed");
			break;
		}
		case HOVER_MENU_ITEM: {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println(("switch case hovermenuitem " + inputData));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			break;
		}
		case IS_POPUP_DISPLAYED: {
			System.out.println("Verify IS_POPUP_DISPLAYED");
			// element.click();
			break;
		}
		case OPEN_NEW_TAB: {
			System.out.println("Verify Open new tab");
			element.click();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		}
		case CLICK_CHECK_BOX: {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Verify click check box");
		//	highlight(driver,element);
			element.click();
			break;
		}
		case SELECT_RADIO_BUTTON: {

			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Radio button selected");
	//		highlight(driver,element);
			element.click();
		}
			default:
			break;

		}
	
	}
	public static void performAction(ActionEnum fieldType) {
		switch (fieldType) {

		case MAXIMIZE_SCREEN: {
			System.out.println("Max" + fieldType);
			driver.manage().window().maximize();
			break;
		}
		case CLICK_BACK: {
			System.out.println("Verify click back");
			driver.navigate().back();
			break;
		}

		default:
			break;
		}
	}

	public static void loadBrowser(String browser, String app_Url) throws IOException, InterruptedException {
		if (browser.equalsIgnoreCase("chrome")) {
					
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\selenium_drivers\\chromedriver.exe");
			

			String downloadFilepath = "C:\\AUTO_DY\\DY.COM\\OutputRepository";
			//String  = ;
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--disable-extensions");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		       chromePrefs.put("profile.default_content_settings.popups", 0);
		       chromePrefs.put("download.default_directory", downloadFilepath);
		       //ChromeOptions options = new ChromeOptions();
		       HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		       options.setExperimentalOption("prefs", chromePrefs);
		       options.addArguments("--test-type");
		  
		       DesiredCapabilities cap = DesiredCapabilities.chrome();
		       cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		       cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		       cap.setCapability(ChromeOptions.CAPABILITY, options);
		       driver = new ChromeDriver(cap); 
		       
		       
//		       Map<String, Object> chromeOptions = new HashMap<String, Object>();
//		       chromeOptions.put("binary", "/usr/lib/chromium-browser/chromium-browser");
//		       DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		       capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//		       WebDriver driver = new ChromeDriver(capabilities);
	       
		       
			   
			driver.get(app_Url);
			Thread.sleep(1000);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			connection = true;

		} else if (browser.equals("FF")) {
			// uncheck the update automatically check box in firefox browser >
			// options > Advanced > Update
			// Currently using firefox version 25.0.1
//			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//			capabilities.setCapability("marionette", false);
//			
//			capabilities.setCapability("firefox_binary",
//			       new File(("user.dir") + "\\selenium_drivers\\geckodriver.exe"));
//			
//			WebDriver driver = new FirefoxDriver(capabilities);
			
			
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "\\selenium_drivers\\geckodriver.exe");
//			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
//		    capabilities.setCapability("marionette", true);
//		    WebDriver driver = new FirefoxDriver(capabilities);
			
			//String FirefoxNodeURL = ("user.dir") + "\\selenium_drivers\\geckodriver.exe";
		    
		    
		    
		   // File file = new File("C:\\Users\\skumartentu\\Desktop\\selenium-java-3.3.1\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", ("user.dir") + "\\selenium_drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);      
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			
			// remote Code
//			DesiredCapabilities cap = DesiredCapabilities.firefox();
//			cap.setBrowserName("firefox");
//			cap.setPlatform(Platform.WIN8);
//			driver = new RemoteWebDriver(new URL(property.getProperty("FirefoxNodeURL")),cap);
//			driver.manage().window().maximize();
//			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);      
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		    
			
			
//			FirefoxProfile ffProfile = new FirefoxProfile();
//			driver = new FirefoxDriver(ffProfile);
//			System.out.println("Script executing on " + driver + " browser");

			driver.get(app_Url);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			connection = true;

		} else if (browser.equals("IE")) {

			System.setProperty("webdriver.ie.driver",
					"C:\\selenium_drivers\\IEDriverServer_32bit.exe");

			// clearing the browser history and cache

			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			caps.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			caps.setCapability("requireWindowFocus", true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			driver = new InternetExplorerDriver(caps);
			driver.manage().window().maximize();
			driver.get(app_Url);

			// Certificate validation

			Wait<WebDriver> wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.linkText("Continue to this website (not recommended).")));

			boolean flag = false;
			do {
				try {
					System.out.println("am inside the BrowserLaunch trying to find continue to this website link");
					WebElement cert = driver.findElement(By.linkText("Continue to this website (not recommended)."));
					System.out.println(cert.getText() + " " + flag);
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].click()", cert);
					flag = true;
					break;
				} catch (Exception e) {
					System.out.println("error");
					continue;
				}
			} while (!flag);

		}

	}

	public static void waitforpageload(String cms_loginpage_wait) throws IOException, InterruptedException {

		Integer waittime = Integer.parseInt(cms_loginpage_wait);
		System.out.println("waittime" + waittime);

		WebElement loading_image = driver.findElement(By.xpath("//*[@id='zk_loading']/div"));
		if (loading_image.isDisplayed())

			Thread.sleep(waittime);

		else
			System.out.println("loading image did not appear");
	}
	
//	public static void highlight(WebDriver driver,WebElement element) throws IOException, InterruptedException{
//		JavascriptExecutor js=(JavascriptExecutor)driver;			  
//		 // call the executeScript method
//		 js.executeScript("arguments[0].style.border='2px groove Red'", element);
//	}
		
	public static class ExtentManager {	
		
		//public static void setUp() throws Exception {
			
			//library.Output.outputFolder();

			//report = new ExtentReports();
		    //logger1 = report.createTest("QAVsite", "Verify HomePage");
		    
			//report = new ExtentReports();
			//logger1 = report.s
			//logger = report.startTest("VicRoadsDemo Test - Set Up");
			//logger.log(LogStatus.INFO, "Output folder created");
		
				//}
	
	public static  ExtentReports GetExtent(){
		
		if (report != null)
                    return report; //avoid creating new instance of html file
                report = new ExtentReports();		
		report.attachReporter(getHtmlReporter());
		return report;
	}
 
	private static  ExtentHtmlReporter getHtmlReporter() {
		
		//library.Output.outputFolder();
        htmlReporter = new ExtentHtmlReporter(library.Output.subDirName + "\\" + "Report.html");
		
	// make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
		
        htmlReporter.config().setDocumentTitle("David Yurman Smoke Automation Report");
        htmlReporter.config().setReportName("Smoke Results");
        return htmlReporter;
	}
	
	//public  ExtentTest createTest(String testi, String testin){
		
		//logger1 = report.createTest(testi, testi);
		//return logger1;
	//}

	
	}
	

	//private static void setUp() {
		//logger1 = report.createTest("QAVsite", "Verify HomePage");
		
	//}
	
	
	


	

	
}
