package week2.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//1Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		// Load the URL hhttp://leaftaps.com/opentaps/control/login
		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//2	Enter the username
		driver.findElement(By.xpath("//p[@class='top']/input")).sendKeys("Democsr");
		
		//3	Enter the password
		driver.findElement(By.xpath("(//input[@id='username']/following::input)[1]")).sendKeys("crmsfa");
		
		//4	Click Login
		driver.findElement(By.xpath("//input[@id='password']/following::input")).click();
		
		//5	Click crm/sfa link
		driver.findElement(By.xpath("//div[@id='label']/a")).click();
		
		
		//6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Contacts']/preceding::a[text()='Leads']")).click();
		
		//7	Click Find leads
		driver.findElement(By.xpath("//a[text()='Create Lead']/following::a")).click();
		
		//8	Click on Email
		driver.findElement(By.xpath("//span[@class='x-tab-strip-inner']/span[text()='Email']")).click();
		
		//9	Enter Email
		driver.findElement(By.xpath("(//label[text()='Email Address:']/following::input)[1]")).sendKeys("kalpana.kripa@gmail.com");
		
		//10	Click find leads button
		driver.findElement(By.xpath("//td[@class='x-btn-center']//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//11	Capture name of First Resulting lead
		WebElement firstlead_webelement = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		
		String firstResultingLead = firstlead_webelement.getText();
		System.out.println("First resulting lead is: "+firstResultingLead);
		
		//12 Click First Resulting lead
		firstlead_webelement.click();
		
		Thread.sleep(2000);
		
		String leadname = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println("Captured Leadname is: "+leadname);
		
		//13	Click Duplicate Lead
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a")).click();
		
		//14	Verify the title as 'Duplicate Lead'
		String currentPageTitle = driver.getTitle();
		System.out.println(currentPageTitle);
		
		//15	Click Create Lead
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalPostalCodeExt']/following::input")).click();
		
		//16	Confirm the duplicated lead name is same as captured name
		String duplicateLeadname = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println(duplicateLeadname);
		
		if (duplicateLeadname.equalsIgnoreCase(leadname)) {
			System.out.println("Duplicate lead name: "+ duplicateLeadname+" is same as captured lead name: "+leadname);
			
		}
		else
		{
			System.out.println("Dupliacte lead name is not same as captured Leadname");
			
		}
		//17	Close the browser (Do not log out)
		driver.close();
		
	}	

}
