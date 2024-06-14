package page;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class MergeLeadsPage extends BaseClass{

	public MergeLeadsPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public MergeLeadsPage clickLookUpFromLead() throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		return this;
	}
	
	public MergeLeadsPage switchToLookupWindow() {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		return this;
	}
	
	
	public MergeLeadsPage enterFromNameMergeLookUp() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("an");
		return this;
	}
	
	public MergeLeadsPage clickFindLeadToMerge() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	
	public MergeLeadsPage selectFirstLeadFromLookup() throws InterruptedException {
		Thread.sleep(1000);
		BaseClass.leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return this;
	}

	public MergeLeadsPage switchBackToMainWindow() {
		Set<String> allWindows = driver.getWindowHandles();
	    List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(0));
		return this;
	}
	
	public MergeLeadsPage selectLeadToLookup() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		return this;

	}
	
	public MergeLeadsPage enterToNameMergeLookUp() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("ab");
		return this;
	}
	
	public MergeLeadsPage clickMergeButton() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		return this;
	}
	
	
	public HomePage acceptAlertOnMergeLead() {
		driver.switchTo().alert().accept();
		return new HomePage(driver);

	}
	
	public MergeLeadsPage selectFirstToLeadLookup() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return this;
	}
	
	
}
