package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NykkaApplication {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//1) Go to https://www.nykaa.com/
		
			ChromeDriver driver = new ChromeDriver();
		
				driver.manage().window().maximize();//Maximize window

			driver.get("https://www.nykaa.com/");

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));//Implicit wait time

		
		//2) Mouseover on Brands and Search L'Oreal Paris
			
			WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
			
				//Action class
				Actions builder = new Actions(driver);
				
				builder.moveToElement(brands).perform();
		
		//3) Click L'Oreal Paris
			
			driver.findElement(By.xpath("//img[contains(@src,'lorealparis.png')]")).click();
			
			Thread.sleep(3000);
			
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
			
			String title = driver.getTitle();
			
			if (title.contains("L'Oreal Paris")) {
				
				System.out.println("title contains L'Oreal Paris");
				
			}
			else
			{
				System.out.println("title does not contains L'Oreal Paris");
				
			}
			
		//5) Click sort By and select customer top rated
			
			driver.findElement(By.xpath("(//*[@class='arrow-icon'])[1]")).click();
			
			driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
			Thread.sleep(3000);
			
		
		//6) Click Category and click Hair->Click haircare->Shampoo
			
			
			driver.findElement(By.xpath("(//*[@class='arrow-icon'])[2]")).click();
			
			driver.findElement(By.xpath("(//*[@class='arrow-icon'])[2]")).click();
			
			driver.findElement(By.xpath("(//*[@class='arrow-icon'])[2]")).click();
			
			driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[2]")).click();
			
			Thread.sleep(3000);
			
		//7) Click->Concern->Color Protection
			
			driver.findElement(By.xpath("(//*[@class='arrow-icon'])[12]")).click();
			
			driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
		
		//8)check whether the Filter is applied with Shampoo
			
			
			String filterShampoo = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
			
			if (filterShampoo.contains("Shampoo")) {
				
				System.out.println("Filter is applied with Shampoo");
			}
			else
			{
				System.out.println("Filter is not applied with Shampoo");
			}
			
		//9) Click on L'Oreal Paris Colour Protect Shampoo
			
			driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
			Thread.sleep(4000);
			
			
		//10) GO to the new window and select size as 175ml
			
			//Window handling
			
			Set<String> windowHandles = driver.getWindowHandles();
			   
			List<String> windowList= new ArrayList<String>(windowHandles);
			
			driver.switchTo().window(windowList.get(1));
			
			System.out.println(driver.getWindowHandles().size());
			
			
				Select sizeDropdown= new Select(driver.findElement(By.xpath("//select[@title='SIZE']")));//Select size as 180ml
			
				sizeDropdown.selectByIndex(1);
			
			//driver.findElement(By.xpath("//span[contains(@class,'active css')]")).click();
			
			Thread.sleep(2000);
			
		//11) Print the MRP of the product
			
			String mrp = driver.findElement(By.xpath("//span[text()='₹209']")).getText();
			
			System.out.println("MRP of the product: "+mrp);
			
			
		//12) Click on ADD to BAG
			
			driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
			
		
		//13) Go to Shopping Bag 
			
			driver.findElement(By.xpath("//span[@class='cart-count']")).click();
			Thread.sleep(3000);
			
		//14) Print the Grand Total amount
			
			//Switch to Frame
			WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
			
			driver.switchTo().frame(frame1);
			
			
			
			String grandTotal = driver.findElement(By.xpath("//span[contains(@class,'css-1um1mkq')]")).getText();
			
			System.out.println("Gramds Total is: "+grandTotal);
			
		
		//15) Click Proceed
		
			driver.findElement(By.xpath("//span[text()='Proceed']")).click();
			
		//16) Click on Continue as Guest --after proceed unable to find continue as guest in application
		
		//17) Check if this grand total is the same in step 14
		
		//18) Close all windows
			driver.close();
		
	}

}
