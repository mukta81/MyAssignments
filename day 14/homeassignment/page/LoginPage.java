package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(ChromeDriver driver) {
		this.driver=driver;
	}

	public LoginPage enterUserName() {
		driver.findElement(By.id("username")).sendKeys(pr.getProperty("username"));
		return this;	
	}
	
	public LoginPage enterPassword() {
		driver.findElement(By.id("password")).sendKeys(pr.getProperty("password"));
		return this;
	}
	
	public WelcomePage clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage(driver);
	}
}