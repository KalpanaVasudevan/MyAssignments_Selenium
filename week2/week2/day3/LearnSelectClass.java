package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnSelectClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. Launch http://leaftaps.com/opentaps
2. Enter username as demoSalesManager
3. Enter password as crmsfa
4. Click on Login
5. Click on CRM/SFA
6. Click on Leads
7.Click on Create lead
8. Enter the mandatory fields
9. Select Employee in source dropdown using index
10.Select Automobile in MarketCampaign using visibleText
11.Select Corporation in Ownership using value
12.Click create

*/
	
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize window
		driver.manage().window().maximize();
		
		//ImplicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//navigate to url
		driver.get("http://leaftaps.com/opentaps");
		
		//Enter username
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		
		//Enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Click on Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click on Leads
		driver.findElement(By.linkText("Leads")).click();
		
		//Click on Create lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CTS");
		
		//Enter firstName
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kalpana");
		
		//Enter LastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kripa");
		
		
		//Select Employee in source dropdown using index
		Select options = new Select(driver.findElement(By.id("createLeadForm_dataSourceId")));
		options.selectByIndex(4);
		
		//Select Automobile in MarketCampaign using visibleText
		WebElement campaignId = driver.findElement(By.id("createLeadForm_marketingCampaignId"));

		Select option2 = new Select(campaignId);
	
		option2.selectByVisibleText("Automobile");
		
		
		//Select Corporation in Ownership using value
		
		
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		
		Select option3 = new Select(ownership);
		
		option3.selectByValue("OWN_CCORP");
		
		//Click Create Lead Button
		driver.findElement(By.name("submitButton")).click();
		
		
		driver.close();
	}

}
