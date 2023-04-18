package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//1 Launch Chrome  and navigate to URL
	    	ChromeDriver driver = new ChromeDriver();
		
	    	// Load https://www.amazon.in/
	    	driver.get("https://www.amazon.in/");
	    
	    	//maximize window
			driver.manage().window().maximize();
		
			//add  implicitlyWait
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//2.search as oneplus 9 pro 
	    	
	    	 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro", Keys.ENTER);	    	 
	    	 
	    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    	 
	    	WebElement until = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='a-price-whole']"))));
	   	    	 	
		//3.Get the price of the first product
	    	 
	    	 String firstProductPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
	    		    	
	    	 int price = Integer.parseInt(firstProductPrice.replace(",",""));
	    	 
	    	 System.out.println("Price of the first product: "+price);
	    
	    //4. Print the number of customer ratings for the first displayed product
	    	 
	    	 WebElement rating = driver.findElement(By.xpath("//*[@class='a-popover-trigger a-declarative']"));
	    	 rating.click();
	    	 Thread.sleep(2000);
	    	 String starRating = driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']")).getText();
	    	 System.out.println("Star rating : "+ starRating);
	    	 
		
		//5. Click the first text link of the first image
	    	 	    	    	 
	    	 driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a")).click();	    	 
	    	 Thread.sleep(3000);
	    	 
	    	 //window Handling
	    	 	System.out.println(driver.getWindowHandles());	    	 
	    	 	Set<String> windowHandles = driver.getWindowHandles();
	    	 	List<String> window = new ArrayList<String>(windowHandles);
	    	  
	    	 	driver.switchTo().window(window.get(1));
	    	 
		
		//6. Take a screen shot of the product displayed
	    	  
	    	WebElement phoneImage = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']"));
	    	  
	    	 
	    	 File Src = phoneImage.getScreenshotAs(OutputType.FILE);	    	 
	    	 File dst = new File("./snaps/1plus.png");	    	 
	    	 FileUtils.copyFile(Src, dst);
	    	 
		
		//7. Click 'Add to Cart' button
	    	 
	    	 driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	    	 Thread.sleep(5000);
		
		//8. Get the cart subtotal and verify if it is correct.
	    	 		    	
	    	 String cartSubTotal = driver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-price')]//span[1]")).getText();
	    	 
	    	 String total= cartSubTotal.replace("₹","");
	    	 String finalTotal = total.replace(".00","");
	    	 
	    	 //System.out.println("Cart SubTotal is: "+finalTotal);	    	 	    	 	    	
	    	 
	    	 int  subTotal = Integer.parseInt(finalTotal.replace(",", ""));
	    	 System.out.println("cart subtotal "+subTotal);
	    	 
	    	 if (price==subTotal)
	    	 {
	    		 System.out.println("Product Price "+price+"is matcing with subtotal: "+subTotal);
				
			}
				
	    	 else
	    	 {
	    		 System.out.println("Product Price "+price+"is not matching with subtotal: "+subTotal);
	    	 }
			
		//9.close the browser
	    	driver.close();
	    	
	    //Transfer control to first window
	    	driver.switchTo().window(window.get(0));
	    	
	    //Close browser
	    	driver.close();
	    	 
	    	 
	}

}
