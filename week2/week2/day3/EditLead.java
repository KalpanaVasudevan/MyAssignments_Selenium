package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		// 1	Launch the browser
		// 2	Enter the username
		// 3	Enter the password
		// 4	Click Login
		// 5	Click crm/sfa link
		// 6	Click Leads link
		// 7	Click Find leads
		// 8	Enter first name
		// 9	Click Find leads button
		// 10 Click on first resulting lead
		// 11 Verify title of the page
		// 12 Click Edit
		// 13 Change the company name
		// 14 Click Update
		// 15 Confirm the changed name appears
		// 16 Close the browser (Do not log out)
		
		//1	Launch the browser
				ChromeDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();//maximize window
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				driver.get("http://leaftaps.com/opentaps/control/login");
				
				//2	Enter the username
				driver.findElement(By.id("username")).sendKeys("demoSalesManager");
				
				//3	Enter the password
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				
				//4	Click Login
				driver.findElement(By.className("decorativeSubmit")).click();
			
				//5	Click crm/sfa link
				driver.findElement(By.linkText("CRM/SFA")).click();
			
				//6	Click Leads link
				driver.findElement(By.linkText("Leads")).click();
				
				//7	Click Find leads
				driver.findElement(By.linkText("Find Leads")).click();
				
				Thread.sleep(3000);
				// 8	Enter first name
				driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Kalpana");
				
				// 9	Click Find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				Thread.sleep(3000);
				
				// 10 Click on first resulting lead
				WebElement firstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
				String firstResultingLead = firstLead.getText();
				System.out.println("first Resulting Lead "+firstResultingLead);
				
				firstLead.click();
				// 11 Verify title of the page
				String actualTitle = driver.getTitle();
				System.out.println(actualTitle);
				
				
				if (actualTitle.equalsIgnoreCase("View Lead | opentaps CRM")) {
					
					System.out.println("View Lead Page Displayed");
				}
				
				else
				{
					System.out.println("View page is not displayed");
				}
				
				// 12 Click Edit
				driver.findElement(By.linkText("Edit")).click();
				
				// 13 Change the company name
				WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
				String actualCompanyName = companyName.getText();
				
				String update_companyName="Wipro";
				
				companyName.clear();
				companyName.sendKeys(update_companyName);
				
				// 14 Click Update
				driver.findElement(By.xpath("//input[@value='Update']")).click();
				
				// 15 Confirm the changed name appears
				String companyname_afterUpdate = driver.findElement(By.id("viewLead_companyName_sp")).getText();
				
				if (companyname_afterUpdate.contains(update_companyName)) {
					System.out.println("Company Name updated successfully"+companyname_afterUpdate );
					
				}
				else
				{
					System.out.println("Company name is not updated");
				}
				// 16 Close the browser (Do not log out)
				
				driver.close();
	}

}
