package week3.day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlertHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.get("https://www.leafground.com/alert.xhtml");
		
			//maximize window
			driver.manage().window().maximize();
			
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
		//Handling Alert (Simple Dialog)
			driver.findElement(By.xpath("(//button[contains(@class,'ui-button-outlined')])[1]")).click();
			
			//Handle simple alert
			Alert alert = driver.switchTo().alert();
			
			alert.accept();//click OK button
			
			String text = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
			System.out.println(text);
		
		//Handling Confirmation alert
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-warning')]")).click();
		
		alert.accept();//Click OK button
		
		//Get the displayed text
		String text2 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println(text2);
		
		
		//Handling Sweet Alert1
		driver.findElement(By.xpath("(//button[contains(@onclick,'show')])[1]")).click();
		
		//click dismiss button
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		
		
		//Handling Sweet Alert2
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-help')]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		
		
		//Handling Prompt Alert
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-success')]")).click();
		
		alert.sendKeys("Kalpana");
		alert.accept();
		
		//Get displayed text from screen
		String text3 = driver.findElement(By.id("confirm_result")).getText();
		System.out.println(text3);
		
		
		//Handling Sweet confirmation Alert
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-danger')]")).click();
		
		//Click Yes Button
		driver.findElement(By.xpath("//button[contains(@class,'ui-confirmdialog-yes')]")).click();
		
		
		
		//Handling Minimize and Maximize Alert
		
		driver.findElement(By.xpath("(//button[contains(@class,'ui-button-outlined')])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@class,'ui-dialog-titlebar-maximize')]")).click();//Click Maximize icon
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
		
		
		
		//Close Browser
		driver.close();
		
	}

}
