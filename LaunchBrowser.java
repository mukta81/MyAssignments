package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
	public static void main(String[] args) {
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notifications");
	
	
	ChromeDriver driver = new ChromeDriver(opt);
	//	ChromeDriver driver = new ChromeDriver(opt);
	driver.get("https://www.facebook.com");
	driver.manage().window().maximize();
	//driver.close();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement element = driver.findElement(By.xpath("(//span[text()='Allow all cookies'])[2]"));
    driver.executeScript("arguments[0].click();", element);
    
    driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]")).sendKeys("testleaf.2023@gmail.com");
	driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Tuna@321");
	driver.findElement(By.name("login")).click();
	driver.findElement(By.linkText("Find your account and log in.")).click();
	System.out.println(driver.getTitle());
	
	
	
	}
	
}
