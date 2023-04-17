package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//1. Launch https://www.snapdeal.com/
		
			ChromeDriver driver = new ChromeDriver();
		
				driver.manage().window().maximize();//Maximize window
		
			driver.get("https://www.snapdeal.com/");
		
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));//Implicit wait time
		
		
		
		//2. Go to Mens Fashion
			
			WebElement mens_fashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]"));
			
			//Action class
			Actions builder = new Actions(driver);
			
			builder.moveToElement(mens_fashion).perform();
			
		
		//3. Go to Sports Shoes
			
			driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
			
		
		//4. Get the count of the sports shoes
		
			String noOfShoes = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span")).getText();
			
			System.out.println("Count of the sports shoes: "+noOfShoes);
			
			
			
		//5. Click Training shoes
			
			driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
			
		
		//6. Sort by Low to High
			
			driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
			
			driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		
		//7. Check if the items displayed are sorted correctly
			
		 String price1 = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[1]")).getText().replace("Rs. ","");
		 
		 
		 String price2 = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[2]")).getText().replace("Rs. ","");
		 
			
			if (Integer.parseInt(price1)<Integer.parseInt(price2)) {
				
				System.out.println("Items are sorted as expected");
			}
			
			else
			{
				System.out.println("Items are not sorted as expected");
				
			}
			 
			Thread.sleep(2000);
		
		
		//8.Select the price range (500-1200)
			
			
			WebElement priceFrom = driver.findElement(By.xpath("//input[@name='fromVal']"));
			priceFrom.clear();
			priceFrom.sendKeys("500");
			
			Thread.sleep(2000);
			
			WebElement priceTo = driver.findElement(By.xpath("//input[@name='toVal']"));
			priceTo.clear();
			priceTo.sendKeys("1200");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click(); //click Go button
			
			
			Thread.sleep(3000);
			
		//9.Filter with color yellow 
			
			driver.findElement(By.xpath("//input[@value='Navy']/parent::div")).click();
			Thread.sleep(3000);
		
		//10 verify the all applied filters 
			
			String appliedFilters = driver.findElement(By.xpath("(//div[@class='filters'])[1]")).getText();
			
			if (appliedFilters.contains("Price")&&(appliedFilters.contains("Navy"))) {
				
				System.out.println("Filters applied successfully");
				
			}
			else
			{
				System.out.println("Filters not applied");
				
			}
			
		
		//11. Mouse Hover on first resulting Training shoes
			
			WebElement element = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
			
			builder.moveToElement(element).perform();
			
			Thread.sleep(2000);
			
		
		//12. click QuickView button
			
			driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		
		//13. Print the cost and the discount percentage
			
			String cost = driver.findElement(By.xpath("//span[contains(@class,'strikee')]")).getText();
			System.out.println(cost);
			
			
			String discountedPrice = driver.findElement(By.xpath("//div[contains(@class,'product-price')]/span")).getText();
			System.out.println(discountedPrice);
			
		//14. Take the snapshot of the shoes.
		
		WebElement shoeImage = driver.findElement(By.xpath("(//ul[@id='bx-slider-qv-image-panel']//img)[1]"));
		
		File src = shoeImage.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./snaps/001.png");
		
		FileUtils.copyFile(src, dest);
		
		//15 Close browser
		driver.close();
		
	}

}
