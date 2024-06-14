package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class FindLeadPage extends BaseClass{
	
	public FindLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}
	

	public FindLeadPage enterPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		return this;
	}
	
	
	
	
	public FindLeadPage clickFindLeadsButton() {
		String valFindButton = pr.getProperty("findleadsbutton");
		driver.findElement(By.xpath("//button[text()='" + valFindButton + "']")).click();
		return this;
	}
	
	
	public ViewLeadPage clickFirstResult() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new ViewLeadPage(driver);
	}
	
	public ViewLeadPage getAndClickFirstID() throws InterruptedException {
		Thread.sleep(2000);
		deletedID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new ViewLeadPage(driver);
	}
	
	
	
	public FindLeadPage enterLeadIdFromLookUp() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(BaseClass.leadID);
		return this;
	}
	
	public FindLeadPage enterDeletedLeadId() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(BaseClass.deletedID);
		return this;
	}
	
	public void checkMergeStatus() throws InterruptedException {
		Thread.sleep(1000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Merge Successful");
		} else {
			System.out.println("Merge not Successful");
		}
		//return this;
	}
	
	
	public void checkDeleteStatus() throws InterruptedException {
		Thread.sleep(1000);
		String valText = driver.findElement(By.className("x-paging-info")).getText();
		if (valText.equals("No records to display")) {
			System.out.println("Delete Successful");
		} else {
			System.out.println("Delete not Successful");
		}
		//return this;
	}
	
}
