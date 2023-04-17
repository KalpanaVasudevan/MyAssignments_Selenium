package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnDropableAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		
	
	//02) Load https://in.bookmyshow.com/
		driver.get("https://jqueryui.com/droppable/");
		
		Thread.sleep(2000);
		
		//Frame Handling
		WebElement element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(element);
		
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement dest = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		//Action Class
				Actions builder = new Actions(driver);
				
				builder.dragAndDrop(src, dest).perform();
				
				
	}

}
