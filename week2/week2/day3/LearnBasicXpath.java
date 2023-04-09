package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnBasicXpath {

	public static void main(String[] args) {
				
		//Launch Browser
			ChromeDriver driver = new ChromeDriver();
				
				//Maximize window
				driver.manage().window().maximize();
				
				//ImplicitlyWait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
		//navigate to url
			driver.get("http://leaftaps.com/opentaps");
			
		//Enter Username using attribute based xpath
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCsr");
			
		//Enter Password using collection based xpath:
			driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
			
		//Click Login button using partial attribute based xpath
			driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
		
		//Get Title 
			String title = driver.getTitle();
			System.out.println(title);
			
		//Click CRM/SFA Link using Partial text based xpath
			driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
				
		//Click Leads using text based xpath:
			driver.findElement(By.xpath("//a[text()='Leads']")).click();

		//Close browser	
			driver.close();
	}

}
