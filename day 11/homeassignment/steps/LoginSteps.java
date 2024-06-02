package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass{
	//public ChromeDriver driver;
	//ChromeDriver driver = new ChromeDriver();
	
	@Given("Enter Username as {string} and Password as {string}")
	public void enterCredentials(String uName, String pswd) {
	    driver.findElement(By.id("username")).sendKeys(uName);
	    driver.findElement(By.id("password")).sendKeys(pswd);
	}
	@When("Click on Login button")
	public void click_on_login_button() {
	    driver.findElement(By.className("decorativeSubmit")).click();
	}
	@Then("Home Page should be displayed")
	public void home_page_should_be_displayed() {
	   String title = driver.getTitle();
	   if(title.contains("Leaftaps")) {
		   System.out.println("Home Page is verified");
	   }
	   else
	   {
		   System.out.println("Home Page is not verified");
	   }
	}


	
	@But("Error Message should be displayed")
	public void verifyErrorMessage() {
	    String errorMsg = driver.findElement(By.id("errorDiv")).getText();
	    if(errorMsg.contains("Errors"))
	    {
	    	System.out.println("Error message is verified");
	    }
	    else
	    {
	    	System.out.println("Error message is not verified");
	    }
	}		
}