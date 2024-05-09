package week2.day1.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//login into TestLeaf
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();  //submit form
		
		//Check login success and click CRM/SFA link if found
		if(driver.findElement(By.xpath("//a[contains(text(),'CRM')]")) != null) //if CRM link element is found
		{
			System.out.println("Login Successful");
			driver.findElement(By.linkText("CRM/SFA")).click();			//click it
		}
		else
		{
			System.out.println("Could not login sucessfully");
		}
		
		
		//Check if "My Home" Header is found: CRM link is clicked successfully, click on Leads
		if(driver.findElement(By.id("sectionHeaderTitle_myHome")).getText().contains("Home")) 
		{
			System.out.println("Successfully Reached 'My Home' Screen");
			driver.findElement(By.linkText("Leads")).click();
		}
		else
		{
			System.out.println("Could not click on CRM Link successfully");
		}
		
		//Check if "My Leads" Header is found: Leads link is clicked successfully, click on Create Leads
		if(driver.findElement(By.id("sectionHeaderTitle_leads")).getText().contains("Leads")) 
		{
			System.out.println("Successfully Reached 'My Leads' Screen");
			driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		}
		else
		{
			System.out.println("Could not reach Leads tab");
		}
		
		
		if(driver.findElement(By.id("sectionHeaderTitle_leads")).getText().contains("Create")) 
		{
			System.out.println("Successfully Reached 'Create Lead' Screen");
			driver.findElement(By.xpath("//input[@name='companyName' and @class='inputBox']")).sendKeys("TestLeaf");
			driver.findElement(By.xpath("//input[@name='firstName' and @class='inputBox']")).sendKeys("Mukta");
			driver.findElement(By.xpath("//input[@name='lastName' and @class='inputBox']")).sendKeys("Agarwal");
			driver.findElement(By.xpath("//input[@name='firstNameLocal' and @class='inputBox']")).sendKeys("M");
			driver.findElement(By.xpath("//input[@name='departmentName' and @class='inputBox']")).sendKeys("TestDepartment");
			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("This is the description field");
			driver.findElement(By.xpath("//input[@name='primaryEmail' and @class='inputBox']")).sendKeys("mukta81.agr@gmail.com");
			WebElement objDD = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select objSelectValue = new Select(objDD);
			objSelectValue.selectByVisibleText("Arizona");
			
			driver.findElement(By.xpath("//input[@name='submitButton' and @value='Create Lead']")).click();
			
		}
		else
		{
			System.out.println("Could not reach Leads tab");
		}

		
		
		if(driver.findElement(By.id("sectionHeaderTitle_leads")).getText().contains("View Lead")) 
		{
			System.out.println("Successfully created a new Lead");
			driver.findElement(By.linkText("Edit")).click();
			driver.findElement(By.xpath("//textarea[@name='description']")).clear();
			driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("This is Important Note field");
			driver.findElement(By.xpath("//input[@name='submitButton' and @value='Update']")).click();
			System.out.println("Updated Lead Page Title is: " +driver.getTitle());
			
			driver.close();
		 	
		}
		else
		{
			System.out.println("Could not load first lead ID");
		}
		
		

	}

}
