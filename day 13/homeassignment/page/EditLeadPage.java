package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class EditLeadPage extends BaseClass{
	
	public EditLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public EditLeadPage updateCompName() {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
		return this;
}

	public ViewLeadPage clickUpdateButton() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
}
}
