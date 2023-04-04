package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch browser
		ChromeDriver driver = new ChromeDriver();
		
		//Navigate to Url
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Enter Username
		driver.findElement(By.id("username")).sendKeys("DemoCsr");
		
		//Enter Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//click Login button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//click CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		
		//Click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		
		//Enter company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		
		//Enter first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kalpana");
		
		
		//Enter Last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kripa");
		
		//click on Create Lead button  
		driver.findElement(By.name("submitButton")).click();
		
		//Click Edit button
		driver.findElement(By.linkText("Edit")).click();
		
		
		//Change the company name
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys("Wipro");
		
		
		//Click Update
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(3000);
		
		//close window
		driver.close();
		
	}

}
