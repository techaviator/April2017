package genericModules;

import genericLibraries.BaseClass;

import java.util.Map;
import org.openqa.selenium.WebDriver;

import pageObjectMode.HomePage;
import pageObjectMode.LoginPage;

public class LoginModule {
	WebDriver driver = null;
	HomePage homePage = null;
	LoginPage loginPage = null;
	
	public LoginModule(WebDriver driver) {
		this.driver = driver;
	}

	public void getUserLogin(Map<String,String> map) throws Exception{
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		
		
		String Expected = map.get("AccountID");
		homePage.signInLink.click();
		loginPage.UnametextBox.sendKeys(map.get("UserName"));
		loginPage.pwdtextBox.sendKeys(map.get("Password"));
		loginPage.clickButton.click();
		if(loginPage.invalidLoginMessageCount.size()>0){
			System.out.println("The element is  available in the DOM");
			boolean invalidMessageStatus = loginPage.invalidLoginMessage.isDisplayed();
			if(invalidMessageStatus == true){
				String actual = loginPage.invalidLoginMessage.getText();
				if(actual.equalsIgnoreCase(map.get("InvalidMessage"))){
					System.out.println("The invalid login TC has passed" +actual);
				}else{
					
					BaseClass.forceStopExecution("The user information is incorrect");
				}
			}
		}
		else{
			String actual = homePage.validLoginCheckPoint.getText();
			if(actual.equalsIgnoreCase(Expected)){
				System.out.println("The valid login TC has passed");
			}
			
		}
		
		
	}

}
