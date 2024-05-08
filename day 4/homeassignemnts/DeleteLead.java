package week2.day2.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		DeleteLead obj = new DeleteLead();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String searchString = "9876543211";
		
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
		
		
		//Check if "My Leads" Header is found: Leads link is clicked successfully, click on Find Leads
		if(driver.findElement(By.id("sectionHeaderTitle_leads")).getText().contains("Leads")) 
		{
			System.out.println("Successfully Reached 'My Leads' Screen");
			driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		}
		else
		{
			System.out.println("Could not reach Leads tab");
		}
		
		//Check if "Find Leads" Header is found: Find Leads link is clicked successfully, search using Number
		if(driver.findElement(By.id("sectionHeaderTitle_leads")).getText().contains("Find Leads")) 
		{
			System.out.println("Successfully Reached 'Find Leads' Screen");
			obj.findLead(searchString, driver, "PhoneNumber");
		}
		else
		{
			System.out.println("Could not reach 'Find leads' page");
		}
		
		
		//Check if "Lead List" Header is found: Search worked fine, check and click on first ID
		Thread.sleep(2000);
		if(!driver.findElement(By.className("x-paging-info")).getText().contains("No records to display"))
		{
		   if(driver.findElement(By.xpath("//span[text()='Lead List']")).getText().contains("Lead List")) 
			{
				System.out.println("Successfully made search on Leads");
				Thread.sleep(3000);
				searchString = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr/td[1]/div[1]/a)[1]")).getText();
				System.out.println(searchString +" is first lead ID found");
				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr/td[1]/div[1]/a)[1]")).click();
				
				//Check if "View Lead" Header is found: first ID is opened, delete that ID and Find Lead using that ID again
				if(driver.findElement(By.id("sectionHeaderTitle_leads")).getText().contains("View Lead")) 
				{
					System.out.println("Successfully clicked on first lead found");
				 	driver.findElement(By.className("subMenuButtonDangerous")).click();
					Thread.sleep(3000);
					obj.findLead(searchString, driver, "ID");
				}
				else
				{
					System.out.println("Could not load first lead ID");
				}
				
				Thread.sleep(2000);

				// if no records found, mention that else delete success msg to be displayed.	
				if(driver.findElement(By.className("x-paging-info")).getText().contains("No records to display"))
				{
					System.out.println("Successfully deleted first record with ID "+searchString);
				}
				else
				{
					System.out.println("Could not delete first ID");
				}
				
				driver.close();
				
				
				
			}
			else
			{
				System.out.println("Could not search Leads");
			}
		}
		else
		{
			System.out.println("No records were found for this search");
			driver.close();
			
		}
		
	}
	
	
	public void findLead(String number,ChromeDriver driver, String val)
	{
		
		if(val=="PhoneNumber")
		{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(number);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		}
		
		if(val=="ID")
			
		{
			driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(number);
			//driver.findElement(By.xpath("//input[@name='id']")).sendKeys("13151");
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		}
	}
	


}
