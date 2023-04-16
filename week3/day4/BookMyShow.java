package week3.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		
		//01) Launch Edge / Chrome 
		   // add  implicitlyWait
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			ChromeDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			
		
		//02) Load https://in.bookmyshow.com/
			driver.get("https://in.bookmyshow.com/");
		
		//03) Type the city as"Hyderabad"in Select City
			
			driver.findElement(By.xpath("//input[@placeholder='Search for your city']")).sendKeys("Hyderabad");
			
			driver.findElement(By.xpath("//strong[text()='Hyderabad']")).click();
		
		//04) Confirm the URL has got loaded with Hyderabad 
			
			
			String city = driver.findElement(By.xpath("//span[@class='sc-kZmsYB ekDEWP ellipsis']")).getText();
			
			
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			
			if (currentUrl.contains("Hyderabad")) {
				
				System.out.println("URL has got loaded with Hyderabad ");
			}
			else
			{
				System.out.println("URL is not loaded with Hyderabad ");
			}
		//05) Search for your favorite movie 
			
			driver.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).sendKeys("Vidudhala Part - 1");
			
			driver.findElement(By.xpath("(//span[@class='sc-jhaWeW ChCae'])[1]")).click();
			
			
		//06) Click on movie
			driver.findElement(By.xpath("//span[text()='Book tickets']")).click();//click Book tickets button
			
		//07) Print the name of the theater displayed first
			
			String theatername = driver.findElement(By.xpath("(//a[@class='__venue-name'])[1]")).getText();
			System.out.println(theatername);
			
		//08) Click on the info of the theater
			
			driver.findElement(By.xpath("(//div[text()='INFO'])[1]")).click();
			
		//09) Confirm if there is a parking facility in the theater
			
			WebElement parking = driver.findElement(By.xpath("//div[contains(text(),'Parking Facility')]"));
			
			if (parking.isDisplayed()) {
				System.out.println("Parking facility is available at this theater");
			}
			
			else
			{
				System.out.println("Parking facility is not available");
			}
			
		//10) Close the theater popup
			
			driver.findElement(By.xpath("//div[contains(@onclick,'CrossIcon')]")).click();
			
		//11) Click on the first green (available) timing
			
			driver.findElement(By.xpath("(//div[@class='showtime-pill-container _available'])[1]")).click();
			
			
		//12) Click Accept
			
			driver.findElement(By.xpath("//div[@id='btnPopupAccept']")).click();
			
			Thread.sleep(2000);
			
		//13) Choose 1 Seat and Click Select Seats
			
			driver.findElement(By.xpath("//li[@id='pop_1']")).click();//Select 1seat
			
			driver.findElement(By.xpath("//div[@id='proceed-Qty']")).click();//click Select Seat
			
			
		//14) Choose any available ticket and Click Pay
			
			driver.findElement(By.xpath("(//a[@class='_available'])[1]")).click(); //click any available seat
			
			driver.findElement(By.xpath("(//a[@id='btmcntbook'])[1]")).click(); // //click pay button
		
		//15) Print the sub total
			
			String subtotal = driver.findElement(By.xpath("//span[@class='__sub-total']")).getText();
			System.out.println("Sub Total is: "+subtotal);
		

		//close browser
			driver.close();
			
	}

}
