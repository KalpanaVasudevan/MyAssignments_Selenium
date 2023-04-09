package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
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
			
			//8	Click on Phone
			driver.findElement(By.linkText("Phone")).click();
			
			//9	Enter phone number
			driver.findElement(By.name("phoneNumber")).sendKeys("123456789");
			
			
			//10	Click find leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			
			Thread.sleep(3000);
			
			//11	Capture lead ID of First Resulting lead
			WebElement firstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
			String firstResultingLead = firstLead.getText();
			System.out.println("first Resulting Lead "+firstResultingLead);
			
			//12	Click First Resulting lead
			firstLead.click();
			
			//13	Click Delete
			driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
			
			Thread.sleep(3000);
			
			//14	Click Find leads
			//driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			
			//15	Enter captured lead ID
			driver.findElement(By.name("id")).sendKeys(firstResultingLead);
			
			//16	Click find leads button
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			
			//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
			WebElement message = driver.findElement(By.xpath("//div[text()='No records to display']"));
			
			if (message.isDisplayed()) {
				System.out.println("Record deleted successfully");
				
			}
			else
			{
				System.out.println("Record is not deleted");
			}
			//18	Close the browser (Do not log out)
			driver.close();
	}

}
