package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadStepDefinition extends BaseClass{
	
	@When("Click on CRMSFA link")
	public void click_on_crmsfa_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@When("Click on Leads Link")
	public void click_on_leads_link() {
		driver.findElement(By.linkText("Leads")).click();
	}
	
	@When("Click on Create Lead")
	public void click_on_createleads_link() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@When("Enter the Company Name as (.*)$")
	public void enter_the_company_name_as_test_leaf(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	}

	@When("Enter the First Name as (.*)$")
	public void enter_the_first_name_as_mukta(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}

	@When("Enter the Last Name as (.*)$")
	public void enter_the_last_name_as_a(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}

	@When("Click on Submit button")
	public void click_on_submit_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("ViewLeads page should be displayed as (.*)$")
	public void view_leads_page_should_be_displayed_as_test_leaf(String cName) {
		 String errorMsg = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		    if(errorMsg.contains(cName))
		    {
		    	System.out.println("Lead Created Successfully");
		    }
		    else
		    {
		    	System.out.println("Lead cannot be Created Successfully");
		    }
	}

		
}