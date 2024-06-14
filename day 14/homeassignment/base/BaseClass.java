package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	//public static ChromeDriver driver;
	public ChromeDriver driver;
	public static String leadID;
	public static String deletedID;
	public static Properties pr = new Properties();
	public static String fileName;
	
	@BeforeMethod
	@Parameters("language")
	public void preCondition(String lang) throws IOException {
		if(lang.equalsIgnoreCase("fr"))
		{
			fileName = "src/main/resources/config.fr.properties";
		}
		else if(lang.equalsIgnoreCase("en"))
		{
			fileName = "src/main/resources/config.en.properties";
		}
		FileInputStream fIS = new FileInputStream(fileName);
		//Properties pr = new Properties();
		pr.load(fIS);
	//	System.out.println(pr.getProperty("username"));
	//	System.out.println(pr.getProperty("password"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
//		driver.findElement(By.id("password")).sendKeys("crmsfa");
//		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();

	}
}
