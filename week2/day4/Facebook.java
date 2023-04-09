package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {

		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		Thread.sleep(3000);
		// Step 7: Enter the first name
		//driver.findElement(By.xpath("(//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']/input)[1]")).sendKeys("Kalpana");
		driver.findElement(By.xpath("(//div[contains(@class,'dbb')]/input)[1]")).sendKeys("Kalpana");
		
		
		// Step 8: Enter the last name
		driver.findElement(By.xpath("(//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']//input)[1]")).sendKeys("Vasudevan");
				
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("1234567899");
		
		// Step 10: Enterthe password
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("abc123");
		
		// Step 11: Handle all the three drop downs
		
		//Select Date of Birth
		WebElement webelement_DateOfBirth = driver.findElement(By.xpath("(//span[@data-name='birthday_wrapper']//select)[1]"));
		Select dropdown_DateOfBirth= new Select(webelement_DateOfBirth);
		dropdown_DateOfBirth.selectByValue("23");
		
		//Select Month from dropdown
		WebElement webelement_Month = driver.findElement(By.xpath("(//select[@id='year']/preceding-sibling::select)[2]"));
		Select dropdown_Month= new Select(webelement_Month);
		dropdown_Month.selectByVisibleText("Apr");
		
		//Select Year from dropdown
		WebElement  webelement_Year= driver.findElement(By.xpath("//select[@id='month']/following-sibling::select"));
		Select dropdown_Year= new Select(webelement_Year);
		dropdown_Year.selectByVisibleText("1990");
		
		
		// Step 12: Select the radio button "Female" ( A normal click will do for this step) 
		driver.findElement(By.xpath("(//span[@data-name='gender_wrapper']//input)[1]")).click();
		
		//close Browser
		driver.close();
		
	}

}
