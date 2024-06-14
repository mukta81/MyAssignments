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
		String valEditLink = pr.getProperty("editlink");
		driver.findElement(By.linkText(valEditLink)).click();
		return new EditLeadPage(driver);
	}
	
	
	public DuplicateLeadPage clickDuplicateButton() {
		String valDuplicateLink = pr.getProperty("duplicatelink");
		driver.findElement(By.linkText(valDuplicateLink)).click();
		return new DuplicateLeadPage(driver);
	}

	
	public HomePage clickDeleteButton() {
		String valDelButton = pr.getProperty("deletebutton");
		driver.findElement(By.linkText(valDelButton)).click();
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
