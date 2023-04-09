package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

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
		
		//8	Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		//9	Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("kalpana.kripa@gmail.com");
		
		//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		//11	Capture name of First Resulting lead
		WebElement firstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String firstResultingLead = firstLead.getText();
		System.out.println("first Resulting Lead "+firstResultingLead);
		
		//12	Click First Resulting lead
		firstLead.click();
		
		
		WebElement firstname_viewleadpage = driver.findElement(By.id("viewLead_firstName_sp"));
		String expected_leadname = firstname_viewleadpage.getText();
		
		//13	Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		Thread.sleep(3000);
		
		//14	Verify the title as 'Duplicate Lead'
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		
		if (actualTitle.equalsIgnoreCase("Duplicate Lead | opentaps CRM")) {
			
			System.out.println("Duplicate Lead Page Displayed");
		}
		
		else
		{
			System.out.println("Duplicate page is not displayed");
		}
		//15	Click Create Lead
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		//16	Confirm the duplicated lead name is same as captured name
		WebElement firstname_duplicatepage = driver.findElement(By.id("viewLead_firstName_sp"));
		String actual_leadName = firstname_duplicatepage.getText();
		
		if (actual_leadName.equalsIgnoreCase(expected_leadname)) {
			System.out.println("Duplicate lead name is same as Captured"+actual_leadName);
		}
		else
		{
			System.out.println("Duplicate lead name is not same as Captured");
		}
		//17	Close the browser (Do not log out)
		driver.close();
	}

}
