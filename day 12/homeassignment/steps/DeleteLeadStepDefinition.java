package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteLeadStepDefinition extends BaseClass{
	private String leadID;
	
	@When("Record ID of first result")
	public void record_id_of_first_result() throws InterruptedException {
		Thread.sleep(2000);
		 leadID = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div/a")).getText();
	}
	@When("Click on Delete Button")
	public void click_on_delete_button() {
		driver.findElement(By.linkText("Delete")).click();
	}
	
	@When("Enter the recorded ID")
	public void enter_the_recorded_id_in_id_field() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}
	
	
	@Then("View Leads page should not return any record indicating record deletion")
	public void view_leads_page_should_not_return_any_record_indicating_record_deletion() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Record Deleted Successfully");
		} else {
			System.out.println("Record not deleted successfully");
		}
	}
		
}