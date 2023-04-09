package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		 
		//Enter username
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
				
		//Enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
				
		// Click on Login
		driver.findElement(By.className("decorativeSubmit")).click();
				
		//Click on CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		 
		//Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		//Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("kalpana");
		
		
		//Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("kripa");
		
		//Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("kalpana");
		
		//Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("vasudevan");
		
		//Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.name("departmentName")).sendKeys("IT");
		
		// Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id("createContactForm_description")).sendKeys("create contact");
		
		// Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("kalpana.kripa@gmail.com");
		
		//Thread.sleep(2000);
		
		//Select State/Province as NewYork Using Visible Text
		Select state = new Select(driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']")));
		state.selectByVisibleText("New York");
		
		Thread.sleep(3000);
		
		// Click on Create Contact
		driver.findElement(By.className("smallSubmit")).click();
		
		//Click on edit button 
		driver.findElement(By.linkText("Edit")).click();
		
		//Clear the Description Field using .clear
		WebElement description = driver.findElement(By.name("description"));
		description.clear();
		
		// Fill ImportantNote Field with Any text
		driver.findElement(By.name("importantNote")).sendKeys("Edit contact");
		
		
		//Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Get the Title of Resulting Page
		String title = driver.getTitle();
		System.out.println(title);
		
		//Close Browser
		driver.close();


	}

}
