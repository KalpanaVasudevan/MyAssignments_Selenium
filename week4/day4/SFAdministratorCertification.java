package week4.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class SFAdministratorCertification extends SalesForceBaseClass{
	
	@Test(priority=1,dependsOnMethods="week4.day4.SFArchitectCertification.getListOfArchCertification")
	public void runAdminisitratorCertification() {
		
      	//click on Learn More link in Mobile Publisher

    	driver.findElement(By.xpath("//span[text()='Learn More']")).click();
	    	
    	//windows Handling
	    	System.out.println(driver.getWindowHandles());    	
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
		//Click on first resulting Ceritificate
			driver.findElement(By.xpath("(//div[@class='credentials-card_title']//a)[1]")).click();
			
			
		//verify - Administrator Overview page
			WebElement adminBanner = driver.findElement(By.xpath("(//div[@class='certification-banner-text']//div)[2]"));
			String text = adminBanner.getText();
			
			if (text.equals("Administrator")) {
				System.out.println("We are in "+text+ "Page");
			}
			else
			{
				System.out.println("We are not in administrator page");
			}
		//Print the Certifications available for Administrator Certifications (List)
	    	
			List<WebElement> certList = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
			
			int size = certList.size();
			
			for (WebElement ele : certList) {
				String certName = ele.getText();
				System.out.println(certName);
			}
 	}

}
