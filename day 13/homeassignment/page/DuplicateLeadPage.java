package page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class DuplicateLeadPage extends BaseClass{
	
	public DuplicateLeadPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public ViewLeadPage createDuplicateLead() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}

}
