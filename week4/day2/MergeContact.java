package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		//Pseudo Code
		  
		 // 1. Launch URL "http://leaftaps.com/opentaps/control/login"		  
			ChromeDriver driver = new ChromeDriver();
		
				driver.manage().window().maximize();//Maximize window

			driver.get("http://leaftaps.com/opentaps/control/login");

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));//Implicit wait time
		
		 // 2. Enter UserName and Password Using Id Locator			
			driver.findElement(By.id("username")).sendKeys("demoSalesManager");
			
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			
		// 3. Click on Login Button using Class Locator			
			driver.findElement(By.className("decorativeSubmit")).click();
		 
		 // 4. Click on CRM/SFA Link			
			driver.findElement(By.xpath("//div[@id='label']/a")).click();
		  
		 // 5. Click on contacts Button			 
			driver.findElement(By.xpath("//a[text()='Contacts']/parent::div")).click();
			
		 // 6. Click on Merge Contacts using Xpath Locator		  
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		  
		 // 7. Click on Widget of From Contact		  
		  driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		  
		  //window handling
		  System.out.println(driver.getWindowHandles());		  
		  Set<String> windowHandles = driver.getWindowHandles();		  
		  List<String> window = new ArrayList<String>(windowHandles);		  
		  driver.switchTo().window(window.get(1));
		  
		// 8. Click on First Resulting Contact		  
		  driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
		 	  
		  driver.switchTo().window(window.get(0));//Transfer control to first window
		  
		 // 9. Click on Widget of To Contact		 
		  driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();		  	
		  
		 // 10. Click on Second Resulting Contact		  
			  System.out.println(driver.getWindowHandles());		  
			  Set<String> windowHandles1 = driver.getWindowHandles();		  
			  List<String> window1 = new ArrayList<String>(windowHandles1);		  
			  driver.switchTo().window(window1.get(1));//Transfer control to newly opened window
		  
		  driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();//Click 2nd resulting conatct
	
		  driver.switchTo().window(window1.get(0));//Transfer control to first window
		  
		 // 11. Click on Merge button using Xpath Locator		  	
		  driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		  	
		 // 12. Accept the Alert		  	
		  	Alert alert = driver.switchTo().alert();
		  	alert.accept();
		  	
		 // 13. Verify the title of the page
		
		  	String title = driver.getTitle();
		  	
		  	if (title.contains("View Contact")) {
		  		
		  		System.out.println("We are in View Contact page");
				
			}
		  	else
		  	{
		  		System.out.println("View Contact page is not available");
		  		
		  	}
		  	
		  //Close browser
		  	driver.close();
		
	}

}
