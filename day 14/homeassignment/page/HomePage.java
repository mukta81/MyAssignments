package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	
	public CreateLeadPage clickCreateLeadsLink() {
		String valCreateLead = pr.getProperty("createleadslink");
		driver.findElement(By.linkText(valCreateLead)).click();
		
		return new CreateLeadPage(driver);
	}
	
	
	public HomePage clickLeadsLink() {
		String valLeadSLink = pr.getProperty("leadslink");
		driver.findElement(By.linkText(valLeadSLink)).click();
		return this;
	}
	
	
	
	public MergeLeadsPage clickLeadsLinkForMergeLink() {
		driver.findElement(By.linkText("Merge Leads")).click();
		
		return new MergeLeadsPage(driver);
	}



	public FindLeadPage clickFindLeadsLink() {
		String valFindLeads = pr.getProperty("findleadslink");
		driver.findElement(By.linkText(valFindLeads)).click();
		return new FindLeadPage(driver);
	}


	


}
