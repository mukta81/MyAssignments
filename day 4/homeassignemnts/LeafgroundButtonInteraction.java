package week2.day2.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundButtonInteraction {

	public static void main(String[] args) {
		LeafgroundButtonInteraction obj = new LeafgroundButtonInteraction();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String str="";

		
		//Click on the button with the text ‘Click and Confirm title.’
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		if(driver.getTitle().equals("Dashboard"))
			{
				System.out.println("Title is correct-'Dashboard'");
			}
		else
			{
			System.out.println("Title is not correct-'Dashboard'");
			}
		
		
		driver.navigate().back();
		
		str="(//h5[text()='Confirm if the button is disabled.'])/following-sibling::button";
		obj.checkButtonProp(driver, str, "Disabled", "Confirm if the button is disabled");
		
		
		str="(//h5[text()='Find the position of the Submit button'])/following-sibling::button";
		obj.checkButtonProp(driver, str,"Position", "Submit");
		
		str="(//h5[text()='Find the Save button color'])/following-sibling::button";
		obj.checkButtonProp(driver, str,"BackgroundColor", "Find the Save button color");

		
		str="(//h5[text()='Find the height and width of this button'])/following-sibling::button";
		obj.checkButtonProp(driver, str,"HtWt", "Find the height and width of this button.");
	} 
	

	public void checkButtonProp(ChromeDriver driver, String path, String prop, String text)
	{
		switch(prop) {
			case "Disabled":
			{
				if(driver.findElement(By.xpath(path)).isEnabled())
				{

					System.out.println("Button with the text '"+text+"' is not disabled");
				}
				else
				{
					System.out.println("Button with the text '"+text+"' is disabled");
				}
				
				break;
			}
			case "Position":
			{
				System.out.println("Position of the button with text '"+text+"' is: "+ driver.findElement(By.xpath(path)).getLocation());
				break;
			}
			
			
			case "BackgroundColor":
			{
				System.out.println("Background color of the button with text '"+text+"' is: "+ driver.findElement(By.xpath(path)).getCssValue("background"));
				break;
			}
			
			case "HtWt":
			{
				System.out.println("Size of the button with text '"+text+"' is: "+ driver.findElement(By.xpath(path)).getSize());
				break;
			}
		}		
	}
	
}
