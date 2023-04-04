package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//amximize window
		driver.manage().window().maximize();
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoCsr");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
		
		//Click on create Lead Button
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter CompanyName using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizant");
		
		// Enter FirstName using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kalpana");
		
		
		//Enter LastName using id locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Vasudevan");
		
		//Enter your mail-id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("kalpana.kripa@gmail.com");
		
		
		//phone number
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("8756454433");
		
		
		//Click on create Lead Button Using name Locator
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(3000);
		
		//close window
		driver.close();
		
	}

}
