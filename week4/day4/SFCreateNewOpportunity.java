package week4.day4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SFCreateNewOpportunity extends SalesForceBaseClass{
	
	@Test(priority=-1,enabled=true,invocationCount=3)
	public void createOpportunity() throws InterruptedException {
	System.out.println("Create Opportunity");
		//2. Click on toggle menu button from the left corner
	    	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    	Thread.sleep(2000);
	    	
		//3. Click view All and click Sales from App Launcher
	    	driver.findElement(By.xpath("//button[text()='View All']")).click();
	    	
	    	//System.out.println(driver.getWindowHandles());
	    	
	    	driver.findElement(By.xpath("//p[text()='Sales']")).click();//Click on sales 
	    		    		    	    	 
	    	 
	    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));	    	 
	    	WebElement until = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Opportunities']"))));
	    	
		//4. Click on Opportunity tab 
	    	WebElement opportunities = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
	    	
	    	driver.executeScript("arguments[0].click()", opportunities);
	    	
		//5. Click on New button
	    	driver.findElement(By.xpath("//div[@title='New']")).click();
	    	
		//6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it 
	    	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Kalpana");
	    	
	    	
		//7. Choose close date as Today
	    	
	    	driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
	    	
	    	DateFormat dateformat = new SimpleDateFormat("dd");
			Date date = new Date();
			
			String date1 = dateformat.format(date);
			System.out.println(date1);
			
			int  currentdate= Integer.parseInt(date1);
			
	    	driver.findElement(By.xpath("//span[text()='"+currentdate+"']")).click();
	    		    	
		//8. Select 'Stage' as Need Analysis
			driver.findElement(By.xpath("(//button[contains(@id,'combobox')])[1]")).click();						
			
	    	WebElement stage = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
	    	stage.click();
			
		//9. click Save and VerifyOppurtunity Name"
			driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

	}

}
