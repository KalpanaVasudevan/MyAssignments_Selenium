package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		//1	Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		// Load the URL hhttp://leaftaps.com/opentaps/control/login
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//2	Enter the username
		driver.findElement(By.xpath("//p[@class='top']/input")).sendKeys("Democsr");
		
		
		//3	Enter the password
		driver.findElement(By.xpath("(//input[@id='username']/following::input)[1]")).sendKeys("crmsfa");
		
		//4	Click Login
		driver.findElement(By.xpath("//input[@id='password']/following::input")).click();
		
		//5	Click crm/sfa link
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
		
		//6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Contacts']/preceding::a[text()='Leads']")).click();
		
		//7	Click Find leads
		driver.findElement(By.xpath("//a[text()='Create Lead']/following::a")).click();
		
		//8	Click on Phone
		driver.findElement(By.xpath("//span[@class='x-tab-strip-inner']/span[text()='Phone']")).click();
		
		//9	Enter phone number
		driver.findElement(By.xpath("//div[contains(@class,'x-plain-body')]/input[@name='phoneNumber']")).sendKeys("123456789");
		
		//10 Click find leads button
		driver.findElement(By.xpath("//td[@class='x-btn-center']//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//11 Capture lead ID of First Resulting lead
		WebElement firstlead_webelement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		
		String firstResultingLead = firstlead_webelement.getText();
		System.out.println("First resulting lead is: "+firstResultingLead);
		
		//12 Click First Resulting lead
		firstlead_webelement.click();
		
		//13 Click Delete
		driver.findElement(By.xpath("//a[text()='Edit']/following-sibling::a")).click();
		
		//14 Click Find leads
		driver.findElement(By.xpath("//a[text()='Create Lead']/following::a")).click();
		
		//15 Enter captured lead ID
		driver.findElement(By.xpath("(//label[text()='Lead ID:']/following::input)[1]")).sendKeys(firstResultingLead);
		
		//16 Click find leads button
		driver.findElement(By.xpath("//td[@class='x-btn-center']//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//17 Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement message = driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']//div"));
		
		if (message.isDisplayed()) {
			System.out.println("No records to display message displayed");
			
		}
		else
		{
			System.out.println("Lead not deleted ");
			
		}
		//18 Close the browser (Do not log out)
		driver.close();
		
	}

}
