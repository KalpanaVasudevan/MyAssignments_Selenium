package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAdvancedXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1. Launch 


			2. Enter username as demoSalesManager
			3. Enter password as crmsfa
			4. Click on Login
			5. Click on CRM/SFA
			6. Click on Leads
			7.Click on Create lead
			8. Enter the mandatory fields
			9Click create
			*/
			
		//Launch browser and navigate to URL
			ChromeDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();//maximize window
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get("http://leaftaps.com/opentaps/control/login");
			
		
		//Enter username
			driver.findElement(By.xpath("(//form[@id='login']//input)[1]")).sendKeys("demoSalesManager");
		//Enter password
			driver.findElement(By.xpath("(//form[@id='login']//input)[2]")).sendKeys("demoSalesManager");
		//Click on Login
			driver.findElement(By.xpath("(//form[@id='login']//input)[3]")).click();
			
		//Click CRM/SFA Link
			driver.findElement(By.xpath("//div[@id='label']/a")).click();
			
		//Click on Leads
			driver.findElement(By.linkText("Leads")).click();
		
		//Click on Create lead
			driver.findElement(By.xpath("(//div[@class='frameSectionBody']//a)[2]")).click();
		
		//Enter the mandatory fields
			driver.findElement(By.xpath("(//div[@class='fieldgroup-body']//input)[1]")).sendKeys("IBM");
		
		//Enter Firstname
			driver.findElement(By.xpath("(//div[@class='fieldgroup-body']//input)[3]")).sendKeys("Kalpana");
			
		//Enter lastname
			driver.findElement(By.xpath("(//div[@class='fieldgroup-body']//input)[4]")).sendKeys("kripa");
			
			driver.findElement(By.xpath("//input[@name='submitButton']")).click();
			
	}

}
