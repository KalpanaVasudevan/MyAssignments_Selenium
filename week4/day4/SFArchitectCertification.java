package week4.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class SFArchitectCertification extends SalesForceBaseClass{
	
	
	//public ChromeDriver driver;
	
	@Test(priority=2,invocationCount=2)
	public void getListOfArchCertification() {
	
		    //	click on Learn More link in Mobile Publisher

		    	driver.findElement(By.xpath("//span[text()='Learn More']")).click();
			    	
		    	//Window Handling
			    	Set<String> windowHandles = driver.getWindowHandles();    	
			    	List<String> handle = new ArrayList<String>(windowHandles);    	
			    	driver.switchTo().window(handle.get(1));
		    	
			    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			    	 
			    	WebElement until = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Confirm']"))));
			    	
			    	//click on confirm button
			    	driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			    	
			 //Click Learning (under shadow dom)
			    	Shadow dom = new Shadow(driver);
			    	
			    	dom.setImplicitWait(20);
			    	WebElement learning = dom.findElementByXPath("//span[text()='Learning']");
			    	learning.click();
			    	
			    	//Shadow dom1 = new Shadow(driver);
			    	dom.setImplicitWait(20);
			    	WebElement trailHaed = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
			    	
					//Action class
					Actions builder = new Actions(driver);
					builder.moveToElement(trailHaed).perform();
					
			 //Click on Salesforce Certifications
					
					//Shadow dom2 = new Shadow(driver);
			    	dom.setImplicitWait(20);
			    	WebElement cert = dom.findElementByXPath("//a[text()='Salesforce Certification']");
			    	
					//Action class
					//Actions builder2 = new Actions(driver);
					builder.moveToElement(cert).perform();
					
					cert.click();
					
			// Choose Your Role as Salesforce Architect
					driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']")).click();
					
			//Get the Text(Summary) of Salesforce Architect 
					String sfArchitectSummary = driver.findElement(By.xpath("//div[contains(@class,'cert-site_text')]")).getText();
					System.out.println("Text(Summary) of Salesforce Architect ");
					System.out.println(sfArchitectSummary);
			
					System.out.println("----------------------------------------------------------------------------------");
			//Get the List of Salesforce Architect Certifications Available
					
					List<WebElement> architectList = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
					
					int size = architectList.size();
					
					System.out.println("List of Salesforce Architect Certifications: ");
					for (WebElement ele : architectList) {
						
						String architectCert = ele.getText();
						System.out.println(architectCert);
						
					}
					
					System.out.println("----------------------------------------------------------------------------------");
					
			//Click on Application Architect 
					driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
					
			// Get the List of Certifications available
					
				List<WebElement> applArchList = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
				System.out.println("List of Application Architect Certifications:  ");
				
				for (WebElement element : applArchList) {
					
					String applArchCertName = element.getText();
					System.out.println(applArchCertName);
					
				}
	}

}
