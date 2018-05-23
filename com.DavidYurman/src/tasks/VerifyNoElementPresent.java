package tasks;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import appObjects.AppObjects;

public class VerifyNoElementPresent extends VRSuperClass {

	public void verifyNoElementPresent() throws IOException, InterruptedException, Exception{
		elementfound = false;
		StepObject stepsObject = TaskSteps.get(new Integer(0));
		String objectID = stepsObject.getObjectId();
		System.out.println("fetched object id" +objectID );
		String input = stepsObject.getInputData();
		System.out.println("fetched input" +input );
		ObjectProperty obj = AppObjects.getObjectLocator(objectID);
		String screenNameFull  = obj.getObjectId();
		String screenName = screenNameFull.split("_")[0];
		System.out.println("screenName"+screenName);	
		WebElement element = AppObjects.getUIObject(objectID, screenName,"xpath" );	
		
		if (element == null && !elementfound){
			System.out.println("pass");
//			System.out.println(element.isDisplayed());
//			System.out.println(element.isEnabled());
		}else {
			System.out.println(element.isDisplayed());
			System.out.println(element.isEnabled());
		}
			
		
		//Assert.assertTrue(element==null);
		//Assert.assertTrue(elementfound==false);
	}
		/*if(element==null)
		{
			Assert);
		}
		boolean result = presentElem(element);
		Assert.assertTrue(result);
		System.out.println("verifyNoElementPresent over");
		//performAction(element,ActionEnum.VERIFY_TEXT_NOT_PRESENT,input);
	}
*/

/*private boolean presentElem(WebElement ele) throws Exception{
	try
	{
	           if(ele.isDisplayed())
	           {
	           return false;
	           }
	           return false;
	        }
	        catch(Exception e)
	        {
	            System.out.println("No element displayed");
	            return true;
	        }
	}*/
}