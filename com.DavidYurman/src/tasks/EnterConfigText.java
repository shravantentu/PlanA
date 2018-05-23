/**
 * 
 */
package tasks;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;

import library.CaptureScreenshot;

//import com.relevantcodes.extentreports.LogStatus;

import library.GetDataFromExcel;

import appObjects.AppObjects;
import tasks.TestDataEnum;


public class EnterConfigText extends VRSuperClass {

	public void enterconfigText() throws IOException, InterruptedException{
		try{

		String testdatavalue = "";
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched object id" +objectID );
		//String input = stepsObject.getInputData();
	   TestDataEnum input = TestDataEnum.getTestDataEnum(stepsObject.getInputData()); 
		System.out.println("fetched input" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);
		WebElement element = AppObjects.getUIObject(objectID, screenName,"id" );
		
		switch(input){
		
//		case CVV:
//		{
//			testdatavalue  = Integer.parseInt("1324");
//			break;
//		}
		//Don't Delete CVV
		case car:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("car");
			break;
		}
		case motorcycle:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("motorcycle");
			break;
		}
		case trailer:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("trailer");
			break;
		}
		case boat:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("boat");
			break;
		}
		case permitstartdate:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("permitstartdate");
			break;
		}
		
		case C1rego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C1rego");
			break;
		}
		
		case C1lastname:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C1lastname");
			break;
		}
	
		case C1customernum:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C1customernum");
			break;
		}
		
		case C1dob:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C1dob");
			break;
		}
			
		case C1address:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C1address");
			break;
		}
				
		case C1email:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C1email");
			break;
		}
		case C1activation:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C1activation");
			break;
		}	
		case C2licence:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C2licence");
			break;
		}	
		
		case C2address:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C2address");
			break;
		}	
		
		case C2rego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C2rego");
			break;
		}
		
		case C2lastname:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C2lastname");
			break;
		}		
			
		case C2dob:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C2dob");
			break;
		}	
		
		case C2email:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C2email");
			break;
		}
		case C2activation:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C2activation");
			break;
		}
				
		case C3licence:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C3licence");
			break;
		}		
				
		case C3address:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C3address");
			break;
		}
				
		case C3lastname:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C3lastname");
			break;
		}
		
		case C3dob:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C3dob");
			break;
		}
		
		case C3email:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C3email");
			break;
		}
		case C3activation:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C3activation");
			break;
		}
		case C2regoconfirm:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("C2regoconfirm");
			break;
		}
		case indvnewemail:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("indvnewemail");
			break;
		}
		
		case HRP1Dealer:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("HRP1Dealer");
			break;
		}
		
		case HRP1Admin1:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("HRP1Admin1");
			break;
		}
			
		case HRP1Admin2:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("HRP1Admin2");
			break;
		}
		
		case HRP2Dealer:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("HRP2Dealer");
			break;
		}
				
		case HRP2Admin1:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("HRP2Admin1");
			break;
		}
		
		case HRP2Admin2:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("HRP2Admin2");
			break;
		}
		
		case HRP2Admin3:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("HRP2Admin3");
			break;
		}
			
		case LRP1Admin1:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("LRP1Admin1");
			break;
		}
		
		case LRP1Admin2:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("LRP1Admin2");
			break;
		}
		
		case LRP1Admin3:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("LRP1Admin3");
			break;
		}
				
		case quickhrp1:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("quickhrp1");
			break;
		}
				
		case quicklrp1:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("quicklrp1");
			break;
		}		
				
		case acquisitiondate:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("acquisitiondate");
			break;
		}
		
		case rwcissuedate:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("rwcissuedate");
			break;
		}
		case rwcreceivedate:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("rwcreceivedate");
			break;
		}
		
		case svnonescrego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("svnonescrego");
			break;
		}	
		
		case svnonescvin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("svnonescvin");
			break;
		}	
				
		case svescrego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("svescrego");
			break;
		}			
				
			
		case svescvin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("svescvin");
			break;
		}			
		
		case mvrego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("mvrego");
			break;
		}
				
		case mvvin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("mvvin");
			break;
		}	
				
		case mvlamsrego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("mvlamsrego");
			break;
		}		
				
		case mvlamsvin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("mvlamsvin");
			break;
		}	
				
			
		case hvrego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("hvrego");
			break;
		}	
		
		case hvvin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("hvvin");
			break;
		}	
		
		case hvfirsrego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("hvfirsrego");
			break;
		}	
		
		case hvfirscheckdigit:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("hvfirscheckdigit");
			break;
		}	
		
		case hvfirsvin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("hvfirsvin");
			break;
		}	
		
		case htrego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("htrego");
			break;
		}	
		
		case htvin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("htvin");
			break;
		}	
		
		case htfirsrego:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("htfirsrego");
			break;
		}	
		
		case htfirsvin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("htfirsvin");
			break;
		}	
		
		case newemail:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("newemail");
			break;
		}	
		
		case addHRPUser:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("addHRPUser");
			break;
		}	
		
		case addHRPAdmin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("addHRPAdmin");
			break;
		}
				
		case addLRPUser:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("addLRPUser");
			break;
		}	
		
		case addLRPAdmin:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("addLRPAdmin");
			break;
		}
			
		case incidentdate:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("incidentdate");
			break;
		}
		
		case writeoffdate:
		{
			testdatavalue = GetDataFromExcel.ReadConfig("writeoffdate");
			break;
		}
		case partnerrejection:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("partnerrejection");		
			break;		
		}		
		case partnerinvalidactivationaccount:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("partnerinvalidactivationaccount");		
			break;		
		}		
		case partnerinvalidactivation:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("partnerinvalidactivation");		
			break;		
		}		
		case quickhrp1activationaccount:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("quickhrp1activationaccount");		
			break;		
		}		
		case LRP1Admin1activation:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("LRP1Admin1activation");		
			break;		
		}		
		case LRP1Admin2activation:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("LRP1Admin2activation");		
			break;		
		}		
		case LRP1Admin3activation:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("LRP1Admin3activation");		
			break;		
		}		
		case HRP1Admin1activation:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("HRP1Admin1activation");		
			break;		
		}		
		case HRP1Admin2activation:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("HRP1Admin2activation");		
			break;		
		}		
		case HRP1Dealeractivation:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("HRP1Dealeractivation");		
			break;		
		}		
				
		case eiacustomernum:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("eiacustomernum");		
			break;		
		}		
		case eiadob:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("eiadob");		
			break;		
		}		
		case eiaemail:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("eiaemail");		
			break;		
		}		
		case EIAactivation:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("EIAactivation");		
			break;		
		}		
		
		case COAlastname:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("COAlastname");		
			break;		
		}
		
		case COAbirthday:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("COAbirthday");		
			break;		
		}
		case COAbirthmonth:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("COAbirthmonth");		
			break;		
		}
		case COAbirthyear:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("COAbirthyear");		
			break;		
		}
		case COAlicencenum:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("COAlicencenum");		
			break;		
		}
		case COAaddress:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("COAaddress");		
			break;		
		}
		case COARaddress:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("COARaddress");		
			break;		
		}
		case COAPaddress:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("COAPaddress");		
			break;		
		}
		case dateregistered:		
		{		
			testdatavalue = GetDataFromExcel.ReadConfig("dateregistered");		
			break;		
		}
		
		
		
		}
		
		
		
		
		/* if(input.equalsIgnoreCase("acquisitiondate"))
		{
			//testdatavalue = GetDataFromExcel.ReadConfig("quickhrp1");
			testdatavalue = GetDataFromExcel.ReadConfig("acquisitiondate");
			

		} */
		
		//else{
	//		testdatavalue = "";
		//}
		
		performAction(element, ActionEnum.TEXT_BOX,testdatavalue);
		//logger.log(LogStatus.PASS, "Entered text from config file - " + testdatavalue);
		test.pass("Entered text from config file - " + testdatavalue);
		
		}
		
		catch (Exception e)
		{
			  
			 CaptureScreenshot sc = new CaptureScreenshot();
			screenshotPath = sc.getScreen(driver,"Enter_ConfigText_Failed"); 
			
			test.fail("Enter_ConfigText_Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
			throw e;

		}
	
	}
	
	

}
