package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		
		
		//1	Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		// Load the URL hhttp://leaftaps.com/opentaps/control/login
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//2	Enter the username
		driver.findElement(By.xpath("//p[@class='top']/input")).sendKeys("Democsr");
		
		// 3	Enter the password
		driver.findElement(By.xpath("(//input[@id='username']/following::input)[1]")).sendKeys("crmsfa");
		
		// 4	Click Login
		driver.findElement(By.xpath("//input[@id='password']/following::input")).click();
		
		// 5	Click crm/sfa link
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
		
		// 6	Click Leads link
		
		driver.findElement(By.xpath("//a[text()='Contacts']/preceding::a[text()='Leads']")).click();
		
		// 7	Click Find leads
		
		driver.findElement(By.xpath("//a[text()='Create Lead']/following::a")).click();
		
		// 8	Enter first name
		driver.findElement(By.xpath("//input[@name='id']/following::input")).sendKeys("Kalpana");
		
		// 9	Click Find leads button
		driver.findElement(By.xpath("//td[@class='x-btn-center']//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		// 10 Click on first resulting lead
		WebElement firstlead_webelement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		
		String firstResultingLead = firstlead_webelement.getText();
		System.out.println("First resulting lead is: "+firstResultingLead);
		
		firstlead_webelement.click();
		
		// 11 Verify title of the page
		String title = driver.getTitle();
		System.out.println(title);
		
		// 12 Click Edit
		driver.findElement(By.xpath("//a[text()='Qualify Lead']/following-sibling::a")).click();
		
		Thread.sleep(2000);
		
		// 13 Change the company name
		WebElement webelement_companyname = driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']"));
		
		
		String companyname = webelement_companyname.getAttribute("value");
		System.out.println("Company Name Displayed is: "+companyname);
		
		webelement_companyname.clear();
		webelement_companyname.sendKeys("Accenture");
		
		
		// 14 Click Update
		driver.findElement(By.xpath("//textarea[@name='importantNote']/following::input[@value='Update']")).click();
		Thread.sleep(2000);
		
		// 15 Confirm the changed name appears
		String updatedCompanyName = driver.findElement(By.xpath("(//span[text()='Company Name']/following::span)[1]")).getText();
		//System.out.println("Updated CompanyName is : "+updatedCompanyName);
		
		if (updatedCompanyName.contains("HCL")) {
			
			System.out.println("Company Name changed successfully: "+updatedCompanyName);
			
		}
		else
		{
			System.out.println("Comapny name not updated as expected: "+updatedCompanyName);
		}
		
		// 16 Close the browser (Do not log out)
		driver.close();
		
	}

}
