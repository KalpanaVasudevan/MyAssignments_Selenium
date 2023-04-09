package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookApplication {

	public static void main(String[] args) {
			
		// Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		//Maximise the window
		driver.manage().window().maximize();
		
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Click on Create New Account button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		// Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Kalpana");
		
		// Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kripa");
		
		
		// Enter the mobile number
		driver.findElement(By.xpath("//input[contains(@aria-label,'Mobile number')]")).sendKeys("1234567899");
		
		// Enterthe password
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("kripa");
		
		//  Handle all the three drop downs
		
		Select dateDropdown = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		dateDropdown.selectByValue("23");
		
		
		Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		monthDropdown.selectByIndex(0);
		
		Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		yearDropdown.selectByVisibleText("1990");
		
		// Select the radio button "Female" 
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		
		//Close browser
		driver.close();
		            
	}

}
