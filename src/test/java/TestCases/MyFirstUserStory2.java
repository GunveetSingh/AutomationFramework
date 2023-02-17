package TestCases;
import Utility.HighlightObject;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import Pages.CommonFunctions;
public class MyFirstUserStory2 {
	

	public WebDriver driver;
	static ExtentReports report;
	static ExtentTest test;
	
	@BeforeTest
	public void setup () throws Exception
	{
	String projectPath=System.getProperty("user.dir");
	//chrome setup
	System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	driver =new ChromeDriver(options);
	report= new ExtentReports(projectPath+"/ExtentReport/report.html",true);
	test= report.startTest("Extent Reports");
	}
	
	@BeforeMethod
	public void beformethod(Method method) throws Exception
	{
		test=report.startTest((this.getClass().getSimpleName()+" :: " + method.getName()), method.getName());
		test.assignAuthor("Gunveet Arora");
		test.assignCategory("SmokeReport-Production");
		//test.log(LogStatus.PASS,"Browser Launched Successfully");
		test.log(LogStatus.PASS, method.getName()+"  Execution Started  ");
		
		}
	
	
	
	@Test
	public void TC_01_Verify_Google_SearchSection() throws Exception
	{
		CommonFunctions cf= new CommonFunctions(driver);
		cf.launchApplication();
	
		test.log(LogStatus.INFO, "Test Case Validation Started:Launch Application");
	
		cf.myWait(10);
		
		WebElement ele =driver.findElement(By.xpath("//body[1]/div[1]/div[3]/form[1]/div[1]"));
		cf.highLighterMethod(driver, ele); //Call the highlighterMethod and pass webdriver and WebElement which you want to highlight as arguments.
		cf.myWait(5);
		test.log(LogStatus.INFO,test.addScreenCapture(CaptureScreen(driver))+"Application Launched Successfully" );
		test.log(LogStatus.PASS, "1st Test Case Executed Successfully");
		cf.myWait(10);
	}
	@Test
	public void TC_02_Verify_Google_SearchSection() throws Exception
	{
		CommonFunctions cf= new CommonFunctions(driver);
		cf.launchApplication();
	
		test.log(LogStatus.INFO, "Test Case Validation Started:Launch Application");
	
		cf.myWait(20);
		
		WebElement ele =driver.findElement(By.xpath("//body[1]/div[1]/div[3]/form[1]/div[1]"));
		cf.highLighterMethod(driver, ele); //Call the highlighterMethod and pass webdriver and WebElement which you want to highlight as arguments.
		cf.myWait(5);
		test.log(LogStatus.INFO,test.addScreenCapture(CaptureScreen(driver))+"Application Launched Successfully" );
		test.log(LogStatus.PASS, "1st Test Case Executed Successfully");
	}
	
	@Test
	public void TC_03_Verify_8849m_InputBox() throws Exception
	{
		CommonFunctions cf= new CommonFunctions(driver);
		cf.launchApplication_8849m();
	
		test.log(LogStatus.INFO, "Test Case Validation Started:Launch Application");
	
		cf.myWait(10);
		
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("78787");
		driver.findElement(By.xpath("//input[@id='lname']")).sendKeys("Arora");
		
		WebElement ele =driver.findElement(By.xpath("//input[@id='fname']"));
		cf.highLighterMethod(driver, ele); //Call the highlighterMethod and pass webdriver and WebElement which you want to highlight as arguments.
		cf.myWait(5);
		test.log(LogStatus.INFO,test.addScreenCapture(CaptureScreen(driver))+"Application Launched Successfully" );
		test.log(LogStatus.PASS, "1st Test Case Executed Successfully");
	}
	
	@Test
	public void TC_04_8849m_Verify_RadioButton_is_displayed_for_Genderand_select_female() throws Exception
	{
		CommonFunctions cf= new CommonFunctions(driver);
		cf.launchApplication_8849m();
	
		test.log(LogStatus.INFO, "Test Case Validation Started:Launch Application");
	
		cf.myWait(10);
		
		driver.findElement(By.xpath("//label[contains(text(),'Radio Button Automation:')]")).isDisplayed();
		driver.findElement(By.xpath("//input[@id='female']")).click();

		
		WebElement ele =driver.findElement(By.xpath("//input[@id='female']"));
		cf.highLighterMethod(driver, ele); //Call the highlighterMethod and pass webdriver and WebElement which you want to highlight as arguments.
		cf.myWait(5);
		test.log(LogStatus.INFO,test.addScreenCapture(CaptureScreen(driver))+"Application Launched Successfully" );
		test.log(LogStatus.PASS, "4st Test Case Executed Successfully");
	}

	
	public static String CaptureScreen(WebDriver driver) throws IOException
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String path=System.getProperty("user.dir")+"\\Screenshots\\Screenshot_"+System.currentTimeMillis()+".png";
		 File Destinationfile=new File(path);
		
		String absolutepath_screen = Destinationfile.getAbsolutePath();
		FileUtils.copyFile(srcfile,Destinationfile);
		return absolutepath_screen;
	}
	
	
	@AfterTest
	public void after()
	{
		//driver.manage().deleteAllCookies();
	//	driver.close();
		report.endTest(test);
		report.flush();
	}

}
