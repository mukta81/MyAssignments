package week6.marathon3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateOpp extends BaseClass {
	
	@BeforeTest
	public void setValues() {
		fileName="CreateOpp";
	}
	
	@Test(dataProvider = "fetchData", priority=1)
	public void runCreateOpp(String name, String amount) throws InterruptedException {
		System.out.println("Inside Create");
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
		Thread.sleep(1000);
		WebElement stageDD = driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]"));
		driver.executeScript("arguments[0].click();", stageDD);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		//System.out.println(driver.findElement(By.xpath("(//slot[@name='secondaryFields']/records-highlights-details-item[3]/div/p)[2]")).getText());
		WebElement element = driver.findElement(By.xpath("(//slot[@name='secondaryFields']/records-highlights-details-item[3]/div/p)[2]"));
		if (element.getText().contains("75,000")) {
		    System.out.println("Opportunity Created Successfully");
		}
		else
		{
			System.out.println(driver.findElement(By.xpath("(//slot[@name='secondaryFields']/records-highlights-details-item)[2]/div/p[3]/slot/lightning-formatted-text")).getText());
		}
	
	}//end of runCreateOpp
}//end of class


