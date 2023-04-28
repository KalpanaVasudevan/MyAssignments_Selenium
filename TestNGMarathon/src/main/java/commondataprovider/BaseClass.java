package commondataprovider;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public String fileName;
	
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void preConditions(String browser,String url,String uName,String pwd)
	{
		if (browser.equalsIgnoreCase("chrome")) {
			
			ChromeOptions options = new ChromeOptions(); 
	        options.addArguments("--disable-notifications");
	        
	         driver = new ChromeDriver(options);
	         
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			EdgeOptions options = new EdgeOptions(); 
	        options.addArguments("--disable-notifications");
	        
	         driver = new EdgeDriver(options);
		}
		
        
        
		//1. Launch https://login.salesforce.com/
		
        driver.get(url); 
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        
        //2. Log in to Salesforce with your username and password and click on Login Button
        
        driver.findElement(By.id("username")).sendKeys(uName);
        
        driver.findElement(By.id("password")).sendKeys(pwd);
        
        driver.findElement(By.id("Login")).click();
        
        
        //3. Click on the App Launcher (dots
        
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        
        
        //4. Click View All 
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        
		
	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException
	{
		return ReadExcel.readData(fileName);
		
	}
	
	
	@AfterMethod
	public void postConditions()
	{
		driver.close();
	}
}
