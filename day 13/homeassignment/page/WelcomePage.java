package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class WelcomePage extends BaseClass{
	
	public WelcomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public WelcomePage verifyHomePage() {
		String text = driver.getTitle();
		if (text.contains("Leaftaps")) {
			System.out.println("Login Successful");
		}
		else {
			System.out.println("Login is not successful");
		}
		return this;
	}
	
	public HomePage clickCRMSFALink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage(driver);
	}

}
