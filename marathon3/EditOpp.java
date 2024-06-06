package week6.marathon3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditOpp extends BaseClass{
	
	@BeforeTest
	public void setValues() {
		fileName="CreateOpp";
	}

	@Test(dataProvider = "fetchData", priority=2, dependsOnMethods = "week6.marathon3.CreateOpp.runCreateOpp")

	public void runEditOpp(String name, String amount) throws InterruptedException {
		System.out.println("Inside Edit");
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys(name, Keys.ENTER);
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']/tbody"));
		
		
		List<WebElement> cellList = table.findElements(By.xpath("//table[@aria-label='Recently Viewed']/tbody/tr[1]/td[8]"));
		
		for (WebElement cell : cellList) {
		    cell.click();
		}
		//click edit
		driver.findElement(By.xpath("//a[@title=\"Edit\"]")).click();	
		
		//chose next day as date
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("(//table[@class='slds-datepicker__month']/tbody/tr/td[@aria-selected=\"true\"])/following-sibling::td[1]")).click();
		
		//Stage
		WebElement stageDD = driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]"));
		driver.executeScript("arguments[0].click();", stageDD);
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();

		//	delivery status
		
		//Stage
		WebElement deliveryDD = driver.findElement(By.xpath("//button[contains(@aria-label,'Delivery')]"));
		driver.executeScript("arguments[0].click();", deliveryDD);
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys(name);


		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(2000);
		//validate
		String strValidate=driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']/tbody/tr[1]/td[5]")).getText();
		//System.out.println("value"+strValidate);
		if(strValidate.contains("Perception"))
		{
			
			System.out.println("Stage is updated correctly, Edit Opportunities validated");
		}
		else
		{
			System.out.println("Not edited");
		}
		
	}//end of method
}//end of class

