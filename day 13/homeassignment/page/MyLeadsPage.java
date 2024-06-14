package page;

import org.openqa.selenium.By;

import base.BaseClass;

public class MyLeadsPage extends BaseClass {
	
	public CreateLeadPage clickCreateLead() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new CreateLeadPage(driver);
	}
	
	

}
