package commondataprovider;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesforceQuestions extends BaseClass{
	
	
	@BeforeTest
	public void setData()
	{
		fileName="SFQuestions";
	}
	
	
	@Test(dataProvider="fetchData")
	public void runSFQuestions(String questions,String details) throws InterruptedException {
		
        
        //5. Type Content on the Search box 
        
        driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("content",Keys.ENTER);
        
        Thread.sleep(3000);
        
        //6. Click the Content Link
        
        driver.findElement(By.xpath("//p[@class='slds-truncate']/mark")).click();
        
        //7. Click on Chatter Tab
        
       WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
    	
    	driver.executeScript("arguments[0].click()", chatter);
    	
    	 Thread.sleep(2000);
    	 
       // driver.findElement(By.xpath("//span[text()='Chatter']")).click();
        
       // 8. Verify the Chatter title on the page
        String title = driver.getTitle();
        System.out.println("Title : "+title);
        if (title.contains("Chatter Home")) {
			System.out.println("Chatter Home Page displayed as expected");
		}
        else
        {
        	System.out.println("Chatter home page not displayed");
        }
        
        
		//9. Click the Question tab
        
        driver.findElement(By.xpath("//span[text()='Question']")).click();
        
        Thread.sleep(2000);
        
		//10. Type a Question with data (coming from Excel)
        
        driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(questions);
        
		//11. Type Details with data (coming from Excel)
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//div[contains(@class,'slds-rich-text-area__content')]")).sendKeys(details);
        
        
		//12. Click Ask
        driver.findElement(By.xpath("//button[contains(@class,'qe-questionPostDesktop')]")).click();
        
        Thread.sleep(2000);
		//13. Confirm the question appears
        String question = driver.findElement(By.xpath("//div[contains(@class,'forceChatterFeedBodyQuestionWithoutAnswer')]/span")).getText();
        System.out.println(question);
        
		
	}

}
