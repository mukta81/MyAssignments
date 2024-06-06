package week6.marathon3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteOpp extends BaseClass{
	
	@BeforeTest
	public void setValues() {
		fileName="CreateOpp";
	}

	@Test(dataProvider = "fetchData", priority=3, dependsOnMethods = {"week6.marathon3.EditOpp.runEditOpp", "week6.marathon3.CreateOpp.runCreateOpp"})
	
	public void runDeleteOpp(String name, String amount) throws InterruptedException {
		System.out.println("Inside Delete");
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys(name, Keys.ENTER);
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']/tbody"));
		
		
		List<WebElement> cellList = table.findElements(By.xpath("//table[@aria-label='Recently Viewed']/tbody/tr[1]/td[8]"));
		
		for (WebElement cell : cellList) {
		    cell.click();
		}
		//click edit
		driver.findElement(By.xpath("//a[@title=\"Delete\"]")).click();	
		Thread.sleep(1000);
		//confirm Delete
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys(name, Keys.ENTER);
		if(driver.findElement(By.xpath("//span[contains(text(),'No items')]")).getText().contains("No items")) 
		{
			System.out.println("Item Deleted successfully, Delete Opportunities validated");
		}
		else
		{
			System.out.println("More Items exist");
		}
	}
}
