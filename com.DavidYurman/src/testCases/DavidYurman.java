package testCases;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import library.CaptureScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.util.SystemOutLogger;
import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import library.CaptureScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.util.SystemOutLogger;
import org.jboss.netty.util.internal.SystemPropertyUtil;
import library.GetDataFromExcel;
import tasks.ActionOnNthElement;
import tasks.AppendUrl;
import tasks.Capturescreenprint;
import tasks.ClearText;
import tasks.ClickButton;
import tasks.ClickCheckBox;
import tasks.ClickIcon;
import tasks.ClickLink;
import tasks.ClickLinkXpath;
import tasks.ClosePopUp;
import tasks.DeleteFromList;
import tasks.Downloaddoc;
import tasks.EnterConfigText;
import tasks.EnterDText;
import tasks.EnterText;
import tasks.Fillform;
import tasks.GetText;
import tasks.Login;
import tasks.Logout;
import tasks.Modal;
import tasks.MouseHover;
import tasks.NavigateUrl;
import tasks.ReadFile;
import tasks.Scroll;
import tasks.SelectCheckBox;
import tasks.SelectDropdownValue;
import tasks.SelectRadioButton;
import tasks.SelectSite;
import tasks.Sleep;
import tasks.TasksEnum;
import tasks.TasksObject;
import tasks.UploadFile;
import tasks.VRSuperClass;
import tasks.VerifyDYPOPUP;
import tasks.VerifyPage;
import tasks.VerifyText;
import tasks.VerifyTextformlist;
import tasks.VerifyURL;
import tasks.Verifypopup;
import tasks.Wait;
import tasks.VerifyProductcount;
//import testCases.DriverScript.ExtentManager;
public class DavidYurman extends VRSuperClass {

                public void davidyurman() throws Exception,TimeoutException {

                                Logger resultsLog = Logger.getLogger("");
                                
                                report = ExtentManager.GetExtent();
                                //logger1 = report.createTest(TestScenarioID);
                                test = report.createTest(TestScenarioId);                
                                try{                               				
                                for (Iterator<Integer> iter = TaskList.keySet().iterator(); iter.hasNext();) {
                                	
                                                TasksObject tasksObject = TaskList.get(iter.next());
                                                TasksEnum task = TasksEnum.getTasksEnum(tasksObject.getStepName());
                                                StepName = tasksObject.getStepName();
                                                resultsLog.info("searchPStepName : " + StepName);

                                                StepNumber = tasksObject.getStepNumber();
                                                resultsLog.info("searchPStepNumber : " + StepNumber);
                                                previousTaskName = taskName;
                                                System.out.println("previous task name  is present");
                                                taskName = task.toString();
                                                TaskSteps.clear();
                                                TaskSteps = tasksObject.getSteps();
                                                resultsLog.info(task);
//                                                
//							                    if( driver.findElement(By.cssSelector("#dy-insider-subscribe-form[novalidate='novalidate']")) != null){
//							                    	driver.findElement(By.cssSelector(".mfp-close")).click(); 
//							        	    		System.out.println("Pop up closed");
//							        	    		Thread.sleep(2000);
//                                                	
//                                                }else{
//                                                	System.out.println("No DY POP up");
//                                                }
                                                
                                           //     VerifyDYPOPUP.closepop();
                                                switch (task) {
                                                case LOGIN: {
                                                                resultsLog.info("Task LOGIN - Started");
                                                                Login loggin = new Login();

                                                                resultsLog.info("Task LOGIN - Ended");
                                                                //logger.log(LogStatus.INFO, " User logs into");
                                                                break;
                                                }
                                                case MODAL: {
                                                	resultsLog.info("Task MODAL - Started");
                                                    Modal modal = new Modal();
                                                    modal.modal();
                                                    resultsLog.info("Task MODAL - Ended");
                                                    //logger.log(LogStatus.INFO, "modal window appeared");
                                                    break;
                                              }
                                            
                                         

                                                case ENTER_TEXT: {
                                                                resultsLog.info("in case ENTER_TEXT");
                                                                EnterText entertxt = new EnterText();
                                                                entertxt.enterText();
                                                                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                                                //logger.log(LogStatus.INFO, "user successfully entered  text");
                                                                break;
                                                }
                                                
                                                
                                                case ENTER_DTEXT: {
                                                    resultsLog.info("in case ENTER_DYNAMIC_TEXT");
                                                   EnterDText enterdynamictext = new EnterDText();
                                                    EnterDText.enterdynamictext();
                                                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                                    //logger.log(LogStatus.INFO, "user successfully entered desired text");
                                                    break;
                                                }
                                                case ENTER_CONFIGTEXT: {
                                                    resultsLog.info("in case ENTER_TEXT");
                                                    EnterConfigText enterctxt = new EnterConfigText();
                                                    enterctxt.enterconfigText();
                                                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                                    //logger.log(LogStatus.INFO, "user successfully entered  text");
                                                    break;
                                                }

                                                case SELECT_DROP_DOWN_VALUE: {
                                                                resultsLog.info("Calling SELECT_DROP_DOWN_VALUE Task from AccessCMS TestCase Script");
                                                                SelectDropdownValue value = new SelectDropdownValue();
                                                                value.selectDropDownValue();
                                                                //logger.log(LogStatus.PASS, "user successfully selected desired dropdown");
                                                                break;
                                                }

                                                case SLEEP: {
                                                                resultsLog.info("Task SLEEP - Started");
                                                                Sleep sleep = new Sleep();
                                                                sleep.sleepMethod();
                                                                resultsLog.info("Task SLEEP - Ended");
                                                                break;
                                                }

                                                case VERIFY_TEXT: {
                                                                resultsLog.info("Task VERIFY_TEXT - Started");
                                                                VerifyText vText = new VerifyText();
                                                                vText.verifyText();
                                                                resultsLog.info("Task VERIFY_TEXT - Ended");
                                                                //logger.log(LogStatus.PASS, " User successfully verified text");
                                                                break;
                                                }
                                                case NAVIGATE_URL: {
                                                                resultsLog.info("Calling NAVIGATE_URL Task from AccessCMS TestCase Script");
                                                                NavigateUrl nURL = new NavigateUrl();
//                                                                String url = GetDataFromExcel.ReadConfig("DYSTG");
//                                                                nURL.navigateUrl(url);
                                                                String url = "DYSTG";
                                                                nURL.navigateUrl(url);                                                               
                                                                
                                                                //logger.log(LogStatus.PASS, "user successfully navigated to url");
                                                                break;
                                                }
                                                case APPEND_URL: {
                                                                resultsLog.info("Calling APPEND_URL Task from AccessCMS TestCase Script");
                                                                AppendUrl nURL = new AppendUrl();
                                                                nURL.navigateUrl();
                                                                //logger.log(LogStatus.PASS, "user successfully navigated to url");
                                                                break;
                                                }
                                               
                                                case VERIFY_URL: {		
                                                    resultsLog.info("Verifying the URL");		
                                                    VerifyURL vURL = new VerifyURL();		
                                                    vURL.verifyURL();		
                                                    //logger.log(LogStatus.PASS, "user successfully navigated to url");		
                                                    break;		
                                                }
                                                case VERIFY_TEXT_FROM_LIST: {		
                                                    resultsLog.info("Verifying text from list");		
                                                    VerifyTextformlist verifyTextformlist = new VerifyTextformlist();		
                                                    verifyTextformlist.verifyTextformlist();		
                                                    //logger.log(LogStatus.PASS, "user successfully navigated to url");		
                                                    break;		
                                                }
                                                case DOWNLOAD_DOC: {
                                                                System.out.println("rediff");
                                                                resultsLog.info("Task CLICK_BUTTON - Started");
                                                                Downloaddoc upd = new Downloaddoc();
                                                                upd.downloaddoc();
                                                                resultsLog.info("Task CLICK_BUTTON - Ended");
                                                                break;
                                                }
                                                
                                                case UPLOAD_FILE: {
                                                                resultsLog.info("Calling UploadFile Task from AccessCMS TestCase Script");
                                                                UploadFile upf = new UploadFile();
                                                                upf.uploadfile();
                                                                //logger.log(LogStatus.PASS, "user successfully uploaded file");
                                                                break;
                                                }
                                                
                                                case GET_TEXT: {
                                                                resultsLog.info("Calling GetText Task from AccessCMS TestCase Script");
                                                                GetText gTxt = new GetText();
                                                                gTxt.gettext();
                                                                //logger.log(LogStatus.PASS, "user successfully got text");
                                                                break;
                                                }
                                                case CLEAR_TEXT: {
                                                    resultsLog.info("Calling GetText Task from AccessCMS TestCase Script");
                                                    ClearText cTxt = new ClearText();
                                                    cTxt.clearText();
                                                    //logger.log(LogStatus.PASS, "user successfully got text");
                                                    break;
                                                }
                                                case VERIFY_Search_Products: {
                                                    resultsLog.info("Calling VERIFY Search Products");
                                                    VerifyProductcount verifysearch = new VerifyProductcount();
                                                    verifysearch.verifyProductcount();
                                                    //logger.log(LogStatus.PASS, "user successfully got text");
                                                    break;
                                                }
                                                case SCROLL: {
                                                    resultsLog.info("VERIFY Scroll");
                                                    Scroll scroll = new Scroll();
                                                    scroll.scroll();
                                                    //logger.log(LogStatus.PASS, "user successfully got text");
                                                    break;
                                                }
                                    
                                                case SELECT_RADIO_BUTTON: {

                                                                resultsLog.info("Calling CLICK_CHECK_BOX Task from NoPermissions TestCase Script");
                                                                SelectRadioButton radioBtn = new SelectRadioButton();
                                                                radioBtn.selectRadioBtn();
                                                                //logger.log(LogStatus.PASS, "user successfully selected radio button");
                                                                break;
                                                }
                                                case VERIFY_PAGE: {
                                                                resultsLog.info("Task VERIFY_PAGE - Started");
                                                                VerifyPage vPage = new VerifyPage();
                                                                vPage.verifyPageTitle();
                                                                resultsLog.info("Task VERIFY_PAGE - Ended");
                                                                break;
                                                }
                                            	case CLICK_ICON: {
                                    				resultsLog.info("Calling CLICK_ICON Task from AccessingQuestionsonFAQPage TestCase Script");
                                    				ClickIcon cIcon = new ClickIcon();
                                    				cIcon.clickIcon();
                                    				break;

                                    			}
                                            	  case SELECT_CHECKBOX_BUTTON: {
                                                      resultsLog.info("Task SELECT_CHECKBOX_BUTTON - Started");
                                                      SelectCheckBox scb = new SelectCheckBox();
                                                      scb.selectcheckbox();
                                                      resultsLog.info("Task CLICK_LINK - Ended");
                                                      //logger.log(LogStatus.PASS, "user successfully clicked on desired button");
                                                      break;
                                            	  } 
                                            	

                                                case CLICK_BUTTON: {
                                                                resultsLog.info("Task CLICK_BUTTON - Started");
                                                                ClickButton clickButt = new ClickButton();
                                                                clickButt.clickButton();
                                                                resultsLog.info("Task CLICK_BUTTON - Ended");
                                                                break;
                                                }
                                                
                                                case ActionON_Nth_Element: {
                                                    resultsLog.info("Task CLICK_BUTTON - Started");
                                                    ActionOnNthElement ActionOn = new ActionOnNthElement();
                                                    ActionOn.actionOnNthElement();
                                                    resultsLog.info("Task CLICK_BUTTON - Ended");
                                                    break;
                                                }
                                                case READ_FILE: {
                                                	resultsLog.info("Task read file - Started");
                                                	ReadFile readfile = new ReadFile();
                                                	ReadFile.readfile();
                                                    resultsLog.info("Task read file - Ended");
                                                    //logger.log(LogStatus.PASS, "user successfully clicked on desired button");
                                                    break;
                                              }
                                                case CLICK_LINK: {
                                                				//Verifypopup.closepopup();
                                                                resultsLog.info("Task CLICK_LINK - Started");
                                                                ClickLink clickLink = new ClickLink();
                                                                clickLink.clickLink();
                                                                resultsLog.info("Task CLICK_LINK - Ended");
                                                                //logger.log(LogStatus.PASS, "user successfully clicked on desired button");
                                                                break;
                                                }
                                                case CLICK_LINK_Xpath: {
                                                    resultsLog.info("Task CLICK_LINK - Started");
                                                    ClickLinkXpath clickLinkXp= new ClickLinkXpath();
                                                    clickLinkXp.clickLinkXpath();
                                                    resultsLog.info("Task CLICK_LINK - Ended");
                                                    //logger.log(LogStatus.PASS, "user successfully clicked on desired button");
                                                    break;
                                                }
                                                case ClosePopUp: {
                                                    resultsLog.info("Task Close Popups - Started");
                                                    ClosePopUp ClosePopUp= new ClosePopUp();
                                                    ClosePopUp.CloseallPopUp();
                                                    resultsLog.info("Task Close Popups - Ended");
                                                    //logger.log(LogStatus.PASS, "user successfully clicked on desired button");
                                                    break;
                                                }
                                                case WAIT: {
                                                                resultsLog.info("Task WAIT - Started");
                                                                Wait wait = new Wait();
                                                                wait.waitMethod();
                                                                resultsLog.info("Task WAIT - Ended");
                                                                break;
                                                }
                                                case MOUSE_HOVER: {
                                                                resultsLog.info("Task MOUSE_HOVER - Started");
                                                                MouseHover hover = new MouseHover();
                                                                hover.Mousehover();
                                                                resultsLog.info("Task MOUSE_HOVER - Ended");
                                                                break;
                                                }
                                                
                                                case SelectSite: {
                                                    resultsLog.info("Task SelectSite - Started");
                                                    SelectSite SelectSite = new SelectSite();
                                                    SelectSite.SelectSitelang();
                                                    resultsLog.info("Task SelectSite - Ended");
                                                    break;
                                                }
                                                
                                                case CLICK_CHECK_BOX: {
                                                                resultsLog.info("in case CLICK CHECK BOX");
                                                                ClickCheckBox clchkbox = new ClickCheckBox();
                                                                clchkbox.clickcheckbox();
                                                                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                                                //logger.log(LogStatus.PASS, "user successfully clicked check box");
                                                                break;
                                                }
                                                case DELETE_fromList: {
                                                    resultsLog.info("Delete from list");
                                                    DeleteFromList deleteFromList = new DeleteFromList();
                                                    deleteFromList.deleteFromList();
                                                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                                    //logger.log(LogStatus.PASS, "user successfully clicked check box");
                                                    break;
                                    }
                                                case Fill_Form: {
                                                    resultsLog.info("Start filling form");
                                                    Fillform fillform = new Fillform();
                                                    fillform.fillform();
                                                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                                    //logger.log(LogStatus.PASS, "user successfully clicked check box");
                                                    break;
                                                }
                                                case Capturescreenprint: {
                                                    resultsLog.info("captured screenprint");
                                                    Capturescreenprint csp = new Capturescreenprint();
                                                    csp.capturescreenprint();
                                                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                                    //logger.log(LogStatus.PASS, "user successfully clicked check box");
                                                    break;
                                                }
                                                case LOGOUT: {
                                                                resultsLog.info("Task LOGOUT - Started");
                                                                Logout logout = new Logout();
                                                                logout.logout();
                                                                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                                                resultsLog.info("Task LOGOUT - Ended");
                                                                break;
                                                }
                                                
                                                }
                                                
                                                
                                                
                                          
                                }
                                CaptureScreenshot sc = new CaptureScreenshot();
                     			screenshotPath = sc.getScreen(driver,"final screen");  
                     	  
                     			test.pass("Test Case Completed",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
                               
                                resultsLog.info("Testcase completed");
                               }

                             catch (Exception e)
                               {
                            	  
                             	 CaptureScreenshot sc = new CaptureScreenshot();
                      			screenshotPath = sc.getScreen(driver,"exception"); 
                      			e.printStackTrace();
                      			test.fail("Test Case Failed",
                    					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
                      		                            	
                               }
                                     
                            driver.quit();
                     
                            report.flush();
                            
                            
                    		


                            }
                            }

