package genericModules;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import pageObjectMode.HomePage;

public class HomePageModules {
	WebDriver driver = null;
	HomePage homePage = null;
	
	public HomePageModules(WebDriver driver){
		this.driver = driver ;
	}
	
	public void searchBook(Map<String,String> map){
		
		homePage = new HomePage(driver);
		
		String ExpectedBooks = map.get("BookNo.");		
		
		homePage.searchTextBox.sendKeys(map.get("SearchKeyword"));
		homePage.searchButton.click();
		if(homePage.invalidSearchMessageList.size()==0){
			String totalBooks = homePage.bookCount.getText();
			if(totalBooks.equalsIgnoreCase(ExpectedBooks.replace(".0", ""))){
				System.out.println("The books validation is complete");
			}
			else{
				System.out.println("The search book scenario  has failed" + totalBooks+" "+ ExpectedBooks);
			}
		}
		else{
			System.out.println(homePage.invalidSearchMessage.getText());
		}
	}

}
