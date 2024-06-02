package hooks;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import steps.BaseClass;

public class HooksImplementation extends BaseClass{
	
	@Before
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://leaftaps.com/opentaps/control/main");
		
	}
	
	@After
	public void postCondition() {
		
		driver.close();
	}

}
