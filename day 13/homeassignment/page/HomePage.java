package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	
	public CreateLeadPage clickCreateLeadsLink() {
		driver.findElement(By.linkText("Create Lead")).click();
		
		return new CreateLeadPage(driver);
	}
	
	
	public HomePage clickLeadsLink() {
		driver.findElement(By.linkText("Leads")).click();
		return this;
	}
	
	
	
	public MergeLeadsPage clickLeadsLinkForMergeLink() {
		driver.findElement(By.linkText("Merge Leads")).click();
		
		return new MergeLeadsPage(driver);
	}



	public FindLeadPage clickFindLeadsLink() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new FindLeadPage(driver);
	}


	


}
