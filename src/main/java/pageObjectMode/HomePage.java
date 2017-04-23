package pageObjectMode;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.linkText("Sign In"))
	//driver.findElement(By.xpath("//span[@id='username']/a")
	//driver.findElement(By.id("srchword")).sendKeys(map.get("SearchKeyword"));
	//driver.findElement(By.cssSelector(".newsrchbtn")).click();
	//driver.findElements(By.cssSelector(".sorrymsg"))
	//driver.findElement(By.id("find"))
	
	@FindBy(linkText = "Sign In") 
	public WebElement signInLink;
	
	@FindBy(xpath= "//span[@id='username']/a")
	public WebElement validLoginCheckPoint;
	
	@FindBy(id= "srchword")
	public WebElement searchTextBox;
	
	@FindBy(css = ".newsrchbtn")
	public WebElement searchButton;
	
	@FindBy(css = ".sorrymsg")
	public List<WebElement> invalidSearchMessageList;
	
	@FindBy(css = ".sorrymsg")
	public WebElement invalidSearchMessage;
	
	@FindBy(id = "find")
	public WebElement bookCount;
	
}
