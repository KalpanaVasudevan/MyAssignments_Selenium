package week2.day4;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		
			// 1. Launch URL
				ChromeDriver driver = new ChromeDriver();
		
				// Load the URL hhttp://leaftaps.com/opentaps/control/login
				driver.get("http://leaftaps.com/opentaps/control/login");
		
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				// 2. Enter UserName and Password 
				driver.findElement(By.xpath("//p[@class='top']/input")).sendKeys("Democsr");
				
				driver.findElement(By.xpath("(//input[@id='username']/following::input)[1]")).sendKeys("crmsfa");
				
				 // 3. Click on Login Button 
				driver.findElement(By.xpath("//input[@id='password']/following::input")).click();
				
				 // 4. Click on CRM/SFA Link
				 driver.findElement(By.xpath("//div[@id='label']/a")).click();
				 
				 // 5. Click on contacts Button
				 driver.findElement(By.xpath("//a[text()='Contacts']/parent::div")).click();
				 
				 // 6. Click on Create Contact
				 driver.findElement(By.xpath("(//a[text()='My Contacts']/following::a)[1]")).click();
				 
				 
				 // 7. Enter FirstName Field
				 driver.findElement(By.xpath("(//span[text()='First name']/following::input)[1]")).sendKeys("Kalpana");
				 
				 // 8. Enter LastName Field Using 
				 driver.findElement(By.xpath("(//span[text()='Last name']/following::input)[1]")).sendKeys("Kripa");
				 
				 // 9. Enter FirstName(Local) Field 
				 driver.findElement(By.xpath("//span[text()='First Name (Local)']/following::input")).sendKeys("kalp");
				 
				 // 10. Enter LastName(Local) Field 
				 driver.findElement(By.xpath("(//span[text()='Last Name (Local)']/following::input)[1]")).sendKeys("kripa");
				 
				 // 11. Enter Department Field 
				 driver.findElement(By.xpath("(//span[text()='Department']/following::input)[1]")).sendKeys("IT");
				 
				 
				 // 12. Enter Description Field 
				 driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("TestLeaf");
				 
				 // 13. Enter your email in the E-mail address Field 
				 driver.findElement(By.xpath("//textarea[@name='description']/following::input[@name='primaryEmail']")).sendKeys("kalpana.kripa@gmail.com");
				 
				 
				 // 14. Select State/Province as NewYork Using Visible Text
				 WebElement webelement_state = driver.findElement(By.xpath("//span[text()='State/Province']/following::select[@name='generalStateProvinceGeoId']"));
				 
				 Select state_dropdown=new Select(webelement_state);
				 
				 state_dropdown.selectByVisibleText("New York");
				 
				 // 15. Click on Create Contact
				 driver.findElement(By.xpath("//td[@class='label']/following::input[@name='submitButton']")).click();
				 
				 // 16. Click on edit button 
				 driver.findElement(By.xpath("//a[text()='Deactivate Contact']/preceding-sibling::a")).click();
				 
				 // 17. Clear the Description Field using .clear
				 driver.findElement(By.xpath("//span[text()='Important Note']/preceding::textarea")).clear();
				 
				 // 18. Fill ImportantNote Field with Any text
				 driver.findElement(By.xpath("//span[text()='Important Note']/following::textarea")).sendKeys("Test");
				 
				 // 19. Click on update button using Xpath locator
				 driver.findElement(By.xpath("//td[@class='label']/following::input[@value='Update']")).click();
				 
				 // 20. Get the Title of Resulting Page.
				 String currentPageTitle = driver.getTitle();
				 System.out.println(currentPageTitle);
				 
				 //Close Browser
				 driver.close();
				 
	}

}
