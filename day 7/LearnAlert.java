package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//h5[contains(text(), 'Prompt Dialog)')]/following::span")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		promptAlert.sendKeys("Mukta");
		//promptAlert.accept();
		promptAlert.dismiss();
		//System.out.println(driver.findElement(By.id("confirm_result")).getText());
		String text = driver.findElement(By.id("confirm_result")).getText();
		if(text.contains("Mukta"))
		{
			System.out.println("Alert handled");
		}
		else
		{
			System.out.println(text);
		}
		driver.close();
	}

}
