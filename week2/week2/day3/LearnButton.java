package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnButton {

	public static void main(String[] args) {
		
		// Launch URL
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();//maximize window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.leafground.com/button.xhtml");
		
		
		// Click and Confirm title
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if (title.equalsIgnoreCase("Dashboard")) {
			System.out.println("Title displayed as expected");
		}
		else
			System.out.println("title is not dispalyed");
		

		
		// Confirm if the button is disabled
		driver.navigate().back();
		
		if (driver.findElement(By.xpath("//span[text()='Disabled']")).isEnabled()==true) {
			
			System.out.println("button is enabled");
		}
		else
		{
			System.out.println("Button is disabled");
		}
		
		// Find the position of the Submit button
		Point location = driver.findElement(By.xpath("//span[text()='Submit']")).getLocation();
		System.out.println("Position of submit button: "+location);
		
		//Close Browser
		driver.close();
	}

}
