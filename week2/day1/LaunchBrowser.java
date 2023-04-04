package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();//Maximize the browser
		
		//Navigate to URL
		driver.get("https://login.salesforce.com/");
		
		//Enter Username
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		
		//Enter Password:
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		
		//Click Login Button
		driver.findElement(By.id("Login")).click();
		
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
