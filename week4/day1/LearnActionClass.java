package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnActionClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		
	
	//02) Load https://in.bookmyshow.com/
		driver.get("https://jqueryui.com/draggable/");
		
		Thread.sleep(2000);
		
		//Frame Handling
		WebElement element = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(element);
		
	
		WebElement ddp = driver.findElement(By.xpath("//p[text()='Drag me around']"));
		
		//Action Class
		Actions builder = new Actions(driver);
		
		builder.dragAndDropBy(ddp, 100, 100).perform();
		
	
	}

}
