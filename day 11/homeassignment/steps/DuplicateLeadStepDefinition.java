package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuplicateLeadStepDefinition extends BaseClass{
	
	@When("Click on Duplicate Lead Button")
	public void click_on_duplicate_lead_button() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@When("Update Company Name as (.*)$")
	public void update_company_name_as_duplicated(String compName) {
	 driver.findElement(By.id("createLeadForm_companyName")).clear();
	 driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
	}
	@When("Click on Create Lead Button")
	public void click_on_create_lead_button() {
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("View Leads page should be duplicated with Company Name as (.*)$")
	public void view_leads_page_should_be_duplicated_with_company_name_as_duplicated(String compName) {
	 String errorMsg = driver.findElement(By.id("viewLead_companyName_sp")).getText();
	    if(errorMsg.contains(compName))
	    {
	    	System.out.println("Lead Duplicated Successfully");
	    }
	    else
	    {
	    	System.out.println("Lead cannot be Duplicated Successfully");
	    }
	}
		
}