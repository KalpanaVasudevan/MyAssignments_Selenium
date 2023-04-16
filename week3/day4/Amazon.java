package week3.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
	//	01) Launch Chrome  
    ChromeDriver driver = new ChromeDriver();
	
    //02) Load https://www.amazon.in/
    driver.get("https://www.amazon.in/");
    
    	//maximize window
		driver.manage().window().maximize();
	
		//add  implicitlyWait
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
    // 03) Type "Bags" in the Search box
    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
    
    	
	//04) Choose the item in the result (bags for boys)
    driver.findElement(By.xpath("//span[text()=' for boys']/parent::div[text()='bags']")).click();
    Thread.sleep(5000);
    
	//05) Print the total number of results (like 50000)
	    //1-48 of over 50,000 results for "bags for boys"
    System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
    
    
	//06) Select the first 2 brands in the left menu
	   // (like American Tourister, Generic)
    
    //Select Safari and Generic from Brands
    driver.findElement(By.xpath("//li[contains(@id,'Safari')]//i")).click();
    
    Thread.sleep(5000);
    
   driver.findElement(By.xpath("(//span[@class='a-expander-prompt'])[1]")).click();
    
    
   driver.findElement(By.xpath("//li[contains(@id,'Generic')]//i")).click();
   Thread.sleep(5000);
    
	//07) Choose New Arrivals (Sort)
   
   driver.findElement(By.xpath("//span[@aria-label='Sort by:']")).click();
   
   driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
   
   Thread.sleep(5000);
   
	//08) Print the first resulting bag info (name, discounted price)
      
   driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
   
   Thread.sleep(5000);
   
   	//Window Handling
	   	Set<String> windowHandles = driver.getWindowHandles();
	   
		List<String> cycle= new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(cycle.get(1));
		String text = driver.findElement(By.id("productTitle")).getText();
		
		System.out.println("Product Name displayed is: "+text);
		
		String price = driver.findElement(By.xpath("//span[@class='a-price-symbol']/following-sibling::span")).getText();
		System.out.println("Price: "+price);
		
		driver.close();//close current tab
		
		driver.switchTo().window(cycle.get(0));//Switch to first window
		
	//09) Get the page title and close the browser(driver.close())
		
		String title = driver.getTitle();
		
		System.out.println("Title :"+title);
	
		driver.close();
		
	}

}
