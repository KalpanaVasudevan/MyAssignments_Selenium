package week4.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SalesForceBaseClass {

		public ChromeDriver driver;		
		public ChromeOptions options;

		@BeforeMethod
		public void preConditions()
		{			
		//1. Login to https://login.salesforce.com
			
			//disable notifications
			options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			// Launch Chrome  and navigate to URL
	    	driver = new ChromeDriver(options);			    	
	    	driver.get("https://login.salesforce.com");
	    	    		
				driver.manage().window().maximize();//maximize window		
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//add  implicitlyWait								
				
	    //2 Enter Username and Password
	    	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
	    	
	    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
	    	
	    	//Click Login Button
	    	driver.findElement(By.xpath("//input[@id='Login']")).click();
		}
		
		@AfterMethod
		public void postConditions()
		{
			//Close Browser
			driver.close();
		}
}
