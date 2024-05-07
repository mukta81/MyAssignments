package week2.day1.homeassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumElements {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver(); //create a Chrome Driver
		SeleniumElements obj = new SeleniumElements(); //create an object of class
		
		String URL = "http://leaftaps.com/opentaps/"; //URL to OPEN main link
		
		obj.openWindowMaximize(URL, driver);	    //method to open a URL
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();  //submit form
		if(driver.findElement(By.xpath("//a[contains(text(),'CRM')]")) != null) //if CRM link element is found
		{
			System.out.println("Login Successful");
			obj.openHyperlink("CRM/SFA", driver);			//click it
		}
		else
		{
			System.out.println("Could not click on CRM Link");
		}
		
		
		
		if(driver.findElement(By.id("sectionHeaderTitle_myHome")) != null) //if My Home header element is found
		{
			System.out.println("Successfully Reached 'My Home' Screen");
			obj.openHyperlink("Accounts", driver);			//click it
		}
		else
		{
			System.out.println("Could not click on Accounts Tab");
		}
		
		if(driver.findElement(By.id("sectionHeaderTitle_accounts")) != null) //if My Account header element is found
		{
			System.out.println("Successfully Reached 'My Accounts' Screen");
			obj.openHyperlink("Create Account", driver);			//click it
		}
		else
		{
			System.out.println("Could not click on Accounts Tab");
		}
		
		
		System.out.println("Adding Details below to create account.");
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Mukta");
		driver.findElement(By.xpath("//textarea[@class='inputBox'][1]")).sendKeys("Selenium Automation Tester");
		
		
		obj.selectDropDown(By.xpath("//select[@name='industryEnumId']"),driver, -1, "Computer Software", "", "Industry");
		obj.selectDropDown(By.xpath("//select[@name='ownershipEnumId']"),driver, -1, "S-Corporation", "", "Ownership");
		obj.selectDropDown(By.id("dataSourceId"),driver, -1, "", "LEAD_EMPLOYEE", "Source");
		obj.selectDropDown(By.id("marketingCampaignId"),driver, 6, "", "", "Marketing Campaign");
		obj.selectDropDown(By.xpath("//select[@name='generalStateProvinceGeoId']"),driver, -1, "Texas", "", "State/Province");
		
		
		driver.findElement(By.className("smallSubmit")).click();  //Create Account
		System.out.println("here");
		
		WebElement element = driver.findElement(By.xpath("//table[@class='fourColumnForm']//tr[2]/td[2]/span"));
		System.out.println(element);
		if(element.isDisplayed()) //if My Home header element is found
		{
			
			System.out.println("Account name already exist");
			//driver.close();
			
		}
		else 
		{
			System.out.println("Successfully Created Account");
			//driver.close();
		}

	}
	
	
	public void openWindowMaximize(String URL, ChromeDriver driver) //to open a window and maximize
	{
		driver.get(URL); 					 //open the URL
		driver.manage().window().maximize(); //maximize the opened window 
		System.out.println("Windows Opened and Maximized Successfully");
	}
	

	
	public void openHyperlink(String clickHyperlink, ChromeDriver driver) //finds 
	{
		driver.findElement(By.linkText(clickHyperlink)).click();
	}
	
	
	//method to select a drop down on a form
	public void selectDropDown(By locator, ChromeDriver driver, int index, String VisibleText, String Value, String message)
	{
		WebElement objDropDown = driver.findElement(locator);
		Select objSelectValue = new Select(objDropDown);
			//System.out.println("hello "+Value);
		if (index != -1) {
			objSelectValue.selectByIndex(index);
        } else if (!VisibleText.isEmpty()) {
        	objSelectValue.selectByVisibleText(VisibleText);
        } else if (!Value.isEmpty()) {
        	objSelectValue.selectByValue(Value);
        }
		
		System.out.println(message + " selected");
		
	}
	
}
