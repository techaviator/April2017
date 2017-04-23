package testScripts;

import genericLibraries.BaseClass;
import genericModules.LoginModule;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LoginScenario extends BaseClass{
	Logger log = Logger.getLogger(LoginScenario.class);
	@Test (dataProvider= "dp",dataProviderClass = dataProvider.DataproviderListObjectofMap.class)
	public void validLogin(Map<String ,String> map) throws Exception{
		//String Expected = map.get("AccountID");
		/*FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://books.rediff.com/");*/
		
	/*	driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(map.get("UserName"));
		driver.findElement(By.name("pswd")).sendKeys(map.get("Password"));
		driver.findElement(By.xpath("//td[@class='sb1']/input")).click();
		String actual = driver.findElement(By.xpath("//span[@id='username']/a")).getText();
		if(actual.equalsIgnoreCase(Expected)){
			System.out.println("The valid login TC has passed");
		}
		else{
			System.out.println("The valid login TC has failed");
		}*/
		//driver.quit();
		log.info("Starting login");
		LoginModule loginModule = new LoginModule(driver);
		loginModule.getUserLogin(map);
		log.info("Completed login login");
		startTest.log(LogStatus.INFO, "User logged in Successfull", "Successfull");
	}
	
	@Test (dataProvider= "dp",dataProviderClass = dataProvider.DataproviderListObjectofMap.class)
	public void invalidLogin(Map<String ,String> map) throws Exception{
		//String Expected = map.get("InvalidMessage");
		/*FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://books.rediff.com/");*/
		
		/*driver.findElement(By.linkText("Sign In")).click();
		if(driver.findElements(By.xpath("//b[contains(.,'Sorry')]")).size()==0){
			System.out.println("The element is not available in the DOM");
		}
		
		driver.findElement(By.name("logid")).sendKeys(map.get("UserName"));
		driver.findElement(By.name("pswd")).sendKeys(map.get("Password"));
		driver.findElement(By.xpath("//td[@class='sb1']/input")).click();
		if(driver.findElements(By.xpath("//b[contains(.,'Sorry')]")).size()>0){
			System.out.println("The element is  available in the DOM");
		}
		boolean invalidMessageStatus = driver.findElement(By.xpath("//b[contains(.,'Sorry')]")).isDisplayed();
		if(invalidMessageStatus == true){
			String actual = driver.findElement(By.xpath("//b[contains(.,'Sorry')]")).getText();
			if(actual.equalsIgnoreCase(Expected)){
				System.out.println("The invalid login TC has passed" +actual);
			}			
		}
		else{
			System.out.println("The invalid login TC has failed");
		}*/
		//driver.quit();
		
		LoginModule loginModule = new LoginModule(driver);
		loginModule.getUserLogin(map);
		startTest.log(LogStatus.INFO, "invalid login check performed", "Successfull");
	}

}
