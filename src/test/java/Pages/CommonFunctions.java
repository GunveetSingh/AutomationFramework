package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctions {

	public WebDriver driver=null;
	private String baseUrl;
	public CommonFunctions(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void launchApplication()
	{
		myWait(30);
		driver.get("https://www.wikipedia.org");
	   
	    driver.manage().window().maximize();
	    
	    }
	public void launchApplication_8849m()
	{
		myWait(30);
		driver.get("http://www.8849m.com/2023/01/html-form-automation.html");
	   
	    driver.manage().window().maximize();
	    
	    }
	
		// Method to highlight object
	public void highLighterMethod(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
		}


	public void myWait(int myTime)
	{
		myTime=myTime*10;
		//myTime=myTime*100;
		try {
            
                Thread.sleep(myTime);
        }
        catch (InterruptedException e) {
            System.out.println("thread interrupted");
        }
    
		driver.manage().timeouts().implicitlyWait(myTime, TimeUnit.SECONDS);
	}
}
