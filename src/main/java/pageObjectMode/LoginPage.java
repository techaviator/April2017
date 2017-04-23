package pageObjectMode;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	/*driver.findElement(By.name("logid")).sendKeys(map.get("UserName"));
	driver.findElement(By.name("pswd")).sendKeys(map.get("Password"));
	driver.findElement(By.xpath("//td[@class='sb1']/input")).click();
	driver.findElements(By.xpath("//b[contains(.,'Sorry')]"))*/
	
	@FindBy(name = "logid")
	public WebElement UnametextBox;
	
	@FindBy(name = "pswd")
	public WebElement pwdtextBox;
	
	@FindBy(xpath = "//td[@class='sb1']/input")
	public WebElement clickButton;
	
	@FindBy(xpath="//b[contains(.,'Sorry')]")
	public List<WebElement> invalidLoginMessageCount;
	
	@FindBy(xpath="//b[contains(.,'Sorry')]")
	public WebElement invalidLoginMessage;
}
