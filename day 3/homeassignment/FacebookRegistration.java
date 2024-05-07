package week2.day1.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookRegistration {

	public static void main(String[] args) {
		
		ChromeDriver driver =new ChromeDriver();
		SeleniumElements obj = new SeleniumElements();
		
		obj.openWindowMaximize("https://en-gb.facebook.com/", driver); //used method written in a different class already
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//close the popup to allow cookies
		WebElement element = driver.findElement(By.xpath("(//span[text()='Allow all cookies'])[2]"));
	    driver.executeScript("arguments[0].click();", element); //click on the popup
		driver.findElement(By.xpath("//a[text()='Create new account']")).click(); 
		
		
		driver.findElement(By.name("firstname")).sendKeys("Mukta1");
		driver.findElement(By.name("lastname")).sendKeys("Agarwal");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("9871599595");
		driver.findElement(By.xpath("//div[text()='New password']/following-sibling::input")).sendKeys("TestLeafP");
		
		
		obj.selectDropDown((By.name("birthday_day")), driver, 0, "", "", "Date");
		obj.selectDropDown((By.name("birthday_month")), driver, 0, "", "", "Month");
		obj.selectDropDown((By.name("birthday_year")), driver, -1, "1990", "", "Year");
		
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		
	}
	
}
