package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MergeLeadStepDefinition extends BaseClass{
	private String leadID;
   // private List<String> allhandles;
    
	@When("Click on Merge Lead")
	public void click_on_merge_lead() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	@When("Click on From Lead Popup")
	public void click_on_from_lead_popup() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();	
	}
	
	@When("Move to new popup window")
	public void move_to_new_popup_window() {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}
	
	@When("Enter First Name as (.*)$")
	public void enter_first_name_as_a(String fName) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fName);
	}
	@When("Click on Find Leads Button")
	public void click_on_find_leads_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	}
	@When("Click on First Record")
	public void click_on_first_record() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@When("Keep a note of ID of first record")
	public void keep_a_note_of_id_of_first_record() {
	leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	}
	@When("Come Back to main Window")
	public void come_back_to_main_window() {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(0));
	}
	@When("Click on To Lead Popup")
	public void click_on_to_lead_popup() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	}
	
	@When("Click on Merge Button")
	public void click_on_merge_button() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
	}
	@When("Accept the OK button in alert")
	public void accept_the_ok_button_in_alert() {
		driver.switchTo().alert().accept();
	}
	
	@When("Enter the recorded ID in ID field")
	public void enter_the_recorded_id_in_id_field() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}
	@Then("View Leads page should not return any record")
	public void view_leads_page_should_not_return_any_record() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Merged Successful");
		} else {
			System.out.println("Merged not successful");
		}
	}
		
}