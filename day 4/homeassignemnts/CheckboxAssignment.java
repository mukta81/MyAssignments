package week2.day2.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckboxAssignment {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Basic Checkbox Click
		driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
		//Notification Click
		driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
		//Check the message on screen
		if(driver.findElement(By.className("ui-growl-title")).getText().equals("Checked"))
		{
			System.out.println("Message Expected after clicking Basic Checkbox, Notification Checkbox: \"Checked\" :Displayed as Expected");
		}
		else
		{
			System.out.println("Message Expected after clicking Basic Checkbox, Notification Checkbox: \"Checked\" : Not Displayed");
		}
		//Favourite Language select
		driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
		
		//Tri State Checkbox
		driver.findElement(By.xpath("(//div[@class='grid formgrid'])[4]//div[2]")).click();
		
		
		System.out.println("After click of Tri State Checkbox, State has been changed to: "+driver.findElement(By.xpath("//p[contains(text(),'State')]")).getText());
		
		
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		
		
		if(driver.findElement(By.className("ui-growl-title")).getText().equals("Checked"))
		{
			System.out.println("Message Expected after Toggle Switch: \"Checked\" :Displayed as Expected");
		}
		else
		{
			System.out.println("Message Expected after Toggle Switch: \"Checked\" : Not Displayed");
		}
		
		
		if(driver.findElement(By.xpath("(//div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget'])[3]")).isSelected()==true)
		{
			System.out.println("'Verify if check box is disabled' Field is enabled");
		}
		else
		{
			System.out.println("'Verify if check box is disabled' field is disabled");
		}
		//select mutiple checkbox
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		driver.findElement(By.xpath("//label[text()='Miami']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//label[text()='Paris']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//label[text()='Amsterdam']/preceding-sibling::div")).click();
		
		//close the multiple checkbox
		driver.findElement(By.xpath("//a[@aria-label='Close']")).click();
		
		//validate selected values
		System.out.print(driver.findElement(By.xpath("(//span[@class='ui-selectcheckboxmenu-token-label'])[1]")).getText()+",");
		System.out.print(driver.findElement(By.xpath("(//span[@class='ui-selectcheckboxmenu-token-label'])[2]")).getText()+",");
		System.out.print(driver.findElement(By.xpath("(//span[@class='ui-selectcheckboxmenu-token-label'])[3]")).getText()+" cities were selected");
		
		driver.close();
	}

}
;