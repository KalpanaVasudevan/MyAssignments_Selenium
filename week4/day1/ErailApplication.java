package week4.day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailApplication {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	//Launch Browser
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
	// Load https://erail.in/
		driver.get("https://erail.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		
	//Clear the text in source and enter "ms" and tab or enter(keys.enter or tab )
		//Hint : sendKeys(" ms",Keys.Enter)
		
		WebElement source = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		
		source.clear();
		
		source.sendKeys("ms",Keys.ENTER);
		
		
	//Clear the text in destination and enter "co" and tab or enter
		
		WebElement destination = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		
		destination.clear();
		
		destination.sendKeys("co",Keys.ENTER);	
	
	// Uncheck sort on date
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		
	
	//Store all the train names in a list
	
		List<WebElement> row = driver.findElements(By.xpath("(//div[@id='divTrainsList']/table)[1]//tr"));
		
		List<WebElement> col = driver.findElements(By.xpath("(//div[@id='divTrainsList']/table)[1]//tr[2]/td"));
		
		
		
		int rowsize =row.size();
		System.out.println("Row Size: "+rowsize);
		
		
		int colsize=col.size();
		System.out.println("ColumnSize :"+colsize);
		
		for (int i = 2; i <= rowsize; i++) {
			
				String text = driver.findElement(By.xpath("(//div[@id='divTrainsList']/table)[1]//tr["+i+"]/td[2]")).getText();//print train names

				System.out.println(text);

		}
	
	
		 
		 
	}

}
