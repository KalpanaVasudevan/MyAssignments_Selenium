package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
			//1.launch browser
			
				ChromeDriver driver = new ChromeDriver();
	
				driver.manage().window().maximize();//Maximize window
			
			//2.load url'https://www.irctc.co.in/'
			
				driver.get("https://leafground.com/window.xhtml");
	
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));//Implicit wait time			
			
			//3.click on Open Button
				driver.findElement(By.xpath("//span[text()='Open']")).click();
				
				
			//4.handle window
				
				Set<String> windowHandles = driver.getWindowHandles();
				   
				List<String> windowList= new ArrayList<String>(windowHandles);
				
				driver.switchTo().window(windowList.get(1));
				
			//5.get the title of page & take snap of page
				
				String title = driver.getTitle();
				System.out.println(title);
				
				//Screenshot:
				File src=driver.getScreenshotAs(OutputType.FILE);
				
				File dst = new File("./snaps/s.png");
				
				FileUtils.copyFile(src, dst);
				
				
			//6.close current window 
				driver.close();
				
			//7.swtich to first window 
				driver.switchTo().window(windowList.get(0));
				
			//8.get the title of page
				System.out.println(driver.getTitle());
				
			//9.quit browser
			driver.close();
			
			
	}

}
