package commondataprovider;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SFCreateNewOpportunity extends BaseClass{
	
	@BeforeTest
	public void setData() {
		fileName="CreateNewOpportunity";
	}
	
	
	
	@Test(dataProvider="fetchData")
	public void runCreateNewOpportunity(String opportunityName,String amount) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
//Handle Notifications
		
       /* EdgeOptions options = new EdgeOptions(); 
        options.addArguments("--disable-notifications");
        
        EdgeDriver driver = new EdgeDriver(options);
        
        
		//1. Launch https://login.salesforce.com/
		
        driver.get("https://login.salesforce.com/"); 
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        
        //2. Log in to Salesforce with your username and password and click on Login Button
        
        driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
        
        driver.findElement(By.id("password")).sendKeys("Leaf@1234");
        
        driver.findElement(By.id("Login")).click();
        
        
        //3. Click on the App Launcher (dots
        
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        
        
        //4. Click View All and click Sales from App Launcher 
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        */
		
        // click Sales from App Launcher 
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
        //Click View All Key Deals in Key Deals 
        WebElement viewAllKey = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
        
        driver.executeScript("arguments[0].click()", viewAllKey);
        
		//6. Click on New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		//7. Give Opportunity Name  (From Excel)
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(opportunityName);
		
		//8. Select Type as New Customer and Lead Source as Partner Referral
		
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input-value')])[2]")).click();
		
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		
		//	Lead Source as Partner Referral
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input-value')])[3]")).click();
		
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		
		//9. Give the Amount as 75000 (from Excel)
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
		
		//10. Select the Close Date as tomorrow
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		DateFormat dateformat = new SimpleDateFormat("dd");
		Date date = new Date();
		
		String date1 = dateformat.format(date);
				
		int  currentdate= Integer.parseInt(date1);
		
		int tomorrow=currentdate+1;
		
		driver.findElement(By.xpath("//td[@class='slds-is-today']/following::span[text()='"+tomorrow+"']")).click();
		
		//11. Select Stage as Needs Analysis
		
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input-value')])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		//12. Click on Primary Campaign  Source and Select the first option
		driver.findElement(By.xpath("//input[@placeholder='Search Campaigns...']")).click();
		
		driver.findElement(By.xpath("//span[text()='REST API']")).click();
		
		
		//13. Click Save and Verify the opportunity is created"
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		WebElement opportunity = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']"));
		
		String text = opportunity.getText();
		System.out.println(text);
		
		if (opportunity.isDisplayed()) {
			
			System.out.println("Opportunity Created successfully");
		}
		else
		{
			System.out.println("opportunity is not created");
		}
		
		
	}

}
