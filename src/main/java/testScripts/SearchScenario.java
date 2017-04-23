package testScripts;

import genericLibraries.BaseClass;
import genericModules.HomePageModules;
import genericModules.LoginModule;

import java.util.Map;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class SearchScenario extends BaseClass {
	
	@Test(dataProvider = "dp", dataProviderClass = dataProvider.DataproviderListObjectofMap.class)
	public void searchBook(Map<String,String> map) throws Exception{
		/*String Expected = map.get("AccountID");
		String ExpectedBooks = map.get("BookNo.");
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://books.rediff.com/");
		
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(map.get("UserName"));
		driver.findElement(By.name("pswd")).sendKeys(map.get("Password"));
		driver.findElement(By.xpath("//td[@class='sb1']/input")).click();
		String actual = driver.findElement(By.xpath("//span[@id='username']/a")).getText();
		if(!actual.equalsIgnoreCase(Expected)){
			System.out.println("The valid login TC has faile" +actual+" "+Expected);
		}
		driver.findElement(By.id("srchword")).sendKeys(map.get("SearchKeyword"));
		driver.findElement(By.cssSelector(".newsrchbtn")).click();
		if(driver.findElements(By.cssSelector(".sorrymsg")).size()==0){
			String totalBooks = driver.findElement(By.id("find")).getText();
			if(totalBooks.equalsIgnoreCase(ExpectedBooks.replace(".0", ""))){
				System.out.println("The books validation is complete");
			}
			else{
				System.out.println("The search book scenario  has failed" + totalBooks+" "+ ExpectedBooks);
			}
		}
		else{
			System.out.println(driver.findElement(By.cssSelector(".sorrymsg")).getText());
		}*/
		
		//driver.quit();
		LoginModule loginModule = new LoginModule(driver);
		HomePageModules homepageModules = new HomePageModules(driver);
		
		loginModule.getUserLogin(map);
		startTest.log(LogStatus.INFO, "User logged in Successfull", "Successfull");
		homepageModules.searchBook(map);
		startTest.log(LogStatus.INFO, "User search book completed", "Successfull");
	}
	

}
