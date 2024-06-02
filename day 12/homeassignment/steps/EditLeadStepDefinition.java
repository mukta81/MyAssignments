package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadStepDefinition extends BaseClass{
	
	@When("Click on Find Leads")
	public void click_on_find_leads() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@When("Click on Phone Tab")
	public void click_on_phone_tab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();	
	}

	@When("Enter the Phone Number as (.*)$")
	public void enter_the_phone_number_as_phone_number(String phoneNum) throws InterruptedException {
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).clear();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNum);
	}

	@When("Click on Find Leads button")
	public void click_on_find_leads_button() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@When("Click on First Result")
	public void click_on_first_result() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@When("Click on Edit Button")
	public void click_on_edit_button() {
		driver.findElement(By.linkText("Edit")).click();	
	}

	@When("Enter Company Name as (.*)$")
	public void enter_company_name_as_company_name(String companyName) {
	driver.findElement(By.id("updateLeadForm_companyName")).clear();
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
	}

	@When("Click on Update Button")
	public void click_on_update_button() {
	driver.findElement(By.name("submitButton")).click();	
	}

	
	@Then("View Leads page should be edited with Company Name as (.*)$")
	public void view_leads_page_should_be_displayed_as_with_company_name_as_companyname(String cName) {
	 String msg = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(msg.contains(cName))
		{
			System.out.println("Lead Edited Successfully");
		}
		else
		{
			System.out.println("Lead cannot be Edited Successfully");
		}
	}
		
}