package genericLibraries;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
	protected WebDriver driver =null;
	public static ExtentReports extentsReport = null;
	public static ExtentTest startTest = null;
	private String ScreenshotName = null;
	private String ScreenshotPath = System.getProperty("user.dir")+UtilityClass.getConfigFileData("SCREENSHOT_PATH");
	String path = System.getProperty("user.dir")+UtilityClass.getConfigFileData("REPORT_PATH");
	
	@BeforeSuite
	public void intializeSuite(){
		path =path+"_"+getDateInfo()+".html";
		System.out.println(path);
		extentsReport = new ExtentReports(path,true);
	}
	
	@BeforeMethod
	@Parameters("browsertype")
	public void intializeTest(@Optional("chrome")String browsertype, Object[] obj){
		//String browsertype = "chrome";
		Map<String, String> map = getTestDetails(obj);
		String TCName = map.get("TC_ID")+"_"+map.get("Run")+"_"+map.get("Functionality");
		ScreenshotName = TCName;
		startTest = extentsReport.startTest(TCName);
		if(browsertype.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else if(browsertype.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+UtilityClass.getConfigFileData("chromeexe"));
			driver = new ChromeDriver();			
		}else if(browsertype.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+UtilityClass.getConfigFileData("IEexe"));
			driver = new InternetExplorerDriver();			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(UtilityClass.getConfigFileData("IMPLICIT_WAIT")), TimeUnit.SECONDS);
		driver.get(UtilityClass.getConfigFileData("URL"));
		startTest.log(LogStatus.INFO, "Lauched the URL", "Successfull");
	}
	
	@AfterMethod
	public void tearDown(ITestResult res){
		if(res.getStatus()==ITestResult.SUCCESS){
			startTest.log(LogStatus.PASS, "Test Completed", "Successfull");
		}else if(res.getStatus()==ITestResult.FAILURE){
			String screenshot = getScreenshot();
			startTest.log(LogStatus.FAIL, res.getThrowable().getMessage(),startTest.addScreenCapture(screenshot));
		}
		driver.quit();
		extentsReport.endTest(startTest);
		extentsReport.flush();		
	}
	
	public static void forceStopExecution(String exception) throws Exception{
		throw new Exception(exception);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getTestDetails(Object[] obj){
		Map<String,String> map = (Map<String, String>) obj[0];
		return map;
	}
	
	
	public String getScreenshot(){
		
		String path = ScreenshotPath+ScreenshotName+"_"+getDateInfo()+".png";
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	public String getDateInfo(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss");
		return simpleDateFormat.format(date);
	}
	
	

}
