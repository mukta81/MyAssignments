package page;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class ViewLeadPage extends BaseClass{
	
	public ViewLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public void verifyViewLeads() {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("TestLeaf")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}

	}
	
	
	public void verifyUpdatedViewLeads() {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("TCS")) {
			System.out.println("Lead edited successfully");
		}
		else {
			System.out.println("Lead is not edited sucessfully");
		}

	}
	
	public EditLeadPage clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
		return new EditLeadPage(driver);
	}
	
	
	public DuplicateLeadPage clickDuplicateButton() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLeadPage(driver);
	}

	
	public HomePage clickDeleteButton() {
		driver.findElement(By.linkText("Delete")).click();
		return new HomePage(driver);
	}
	
	public void verifyDuplicateLeadCreated() {
		if(driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(deletedID))
		{
			System.out.println("Duplicate Lead not successful");
		}
		else
		{
			System.out.println("Duplicate Lead successful");
		}
	}
	


}
