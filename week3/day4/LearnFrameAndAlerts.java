package week3.day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrameAndAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		//1	Launch the browser
		ChromeDriver driver = new ChromeDriver();
				
		// Load the URL 
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

				driver.manage().window().maximize(); //maximize window
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				//Switch to Frame
				driver.switchTo().frame("iframeResult");
				
				driver.findElement(By.xpath("//button[text()='Try it']")).click();
				
				
				//Handle prompt alert	
				Alert promptAlert = driver.switchTo().alert();
				
				
				promptAlert.sendKeys("TestLeaf");
				promptAlert.accept();
				
				String text = driver.findElement(By.id("demo")).getText();
				System.out.println(text);
				
				
				
	}

}
