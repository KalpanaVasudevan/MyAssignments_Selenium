package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Launch URL
		ChromeDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();//maximize window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
		driver.get("https://www.leafground.com/select.xhtml");
		
		//Select Which is your favourite automation tool using selectByIndex()
		WebElement automationTool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select automationToolDropdown = new Select(automationTool);
		automationToolDropdown.selectByIndex(1);
		
		
		Thread.sleep(3000);
		//Select Choose your preferred country. using selectByVisibleText()
		driver.findElement(By.xpath("//label[@id='j_idt87:country_label']")).click();	
		driver.findElement(By.xpath("//li[text()='Germany']")).click();
		Thread.sleep(3000);
		
		//Confirm Cities belongs to Country is loaded
		driver.findElement(By.xpath("//label[@id='j_idt87:city_label']")).click();
		driver.findElement(By.xpath("//li[text()='Frankfurt']")).click();
		
	
		//Choose the Course
		driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
				
		//Choose language randomly
		driver.findElement(By.xpath("//label[@id='j_idt87:lang_label']")).click();
		driver.findElement(By.xpath("//li[text()='English']")).click();
		
				Thread.sleep(2000);
				//Select 'Two' irrespective of the language chosen
				driver.findElement(By.xpath("//label[@id='j_idt87:value_label']")).click();
				driver.findElement(By.xpath("//li[text()='Two']")).click();
		
		//close browser
				driver.close();
	}

}
