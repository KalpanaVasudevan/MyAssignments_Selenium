package week3.day4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		//	01) Launch Chrome and add  implicitlyWait
		
		  ChromeDriver driver = new ChromeDriver();
		  
		//02) Load https://www.redbus.in/
		  driver.get("https://www.redbus.in/");
		  
		  	//maximize window
			driver.manage().window().maximize();
		
			//add  implicitlyWait
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	    	
		//03) Type "Chennai" in the FROM text box
	    	
	    	driver.findElement(By.id("src")).sendKeys("Chennai");
	    	//Thread.sleep(1000);
	    	
		//04) Click the first option from the pop up box
	    	
	    	driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		
		//05) Type "Bangalore" in the TO text box
	    	
	    	driver.findElement(By.id("dest")).sendKeys("Bangalore");
		
		//06) Click the first option from the pop up box
	    	
	    	driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		
		//07) Select tomorrow's date in the Date field
		
			DateFormat dateformat = new SimpleDateFormat("dd");
			Date date = new Date();
			
			String date1 = dateformat.format(date);
			System.out.println(date1);
			
			int  currentdate= Integer.parseInt(date1);
			int tomorrowdate=currentdate+1;
		
			driver.findElement(By.xpath("//table[@class='rb-monthTable first last']//td[text()='"+tomorrowdate+"']")).click();
		
		//08) Click Search Buses
			
			driver.findElement(By.id("search_btn")).click();
		

		//09) Print the number of buses shown as results (107 Buses found) (use .getText())
			
			String noOfBusesFound = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
			
			System.out.println("Total number of buses found in search result: "+noOfBusesFound);
		
		
		//10) Choose SLEEPER in the left menu 
			
			driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		
		
		//11) Print the name of the second resulting bus (use .getText())
			
			String second_busname = driver.findElement(By.xpath("(//div[contains(@class,'travels ')])[2]")).getText();
			
			System.out.println(second_busname);
		
		
		//12) Get the Title of the page(use .getTitle())
			String title = driver.getTitle();
			
			System.out.println(title);
    	
	    //13) close browser
			driver.close();
	}

}
