package week2.day2.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {
		
		RadioButton obj = new RadioButton();
		String path="";
		String strLocalPart1="";
		String strLocalPart2="";
		
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Check 'Your most favorite browser' radio button
		driver.findElement(By.xpath("//h5[text()='Your most favorite browser']/following-sibling::div/div/table/tbody/tr/td[1]/div/div[2]/span")).click();
		
		
		//Check 'UnSelectable' radio button
		driver.findElement(By.xpath("//h5[text()='UnSelectable']/following-sibling::div/div/div//div/div[2]/div/div[2]/span")).click();
		
		//UnCheck 'UnSelectable' radio button
		driver.findElement(By.xpath("//h5[text()='UnSelectable']/following-sibling::div/div/div//div/div[2]/div/div[2]/span")).click();

//		path="//h5[text()='Find the default select radio button']";
		strLocalPart1="//input[@value='Option";
		strLocalPart2="']";
		
		obj.checkRadioChecked(driver, strLocalPart1, strLocalPart2, 4 );
		
		
		WebElement element = driver.findElement(By.xpath("//input[@value='21-40 Years']"));
		
		
		if(element.isSelected())
		{
			System.out.println("21-40 Yrs radio button is already selected");
		}
		else
		{
			System.out.println("hey"+element.isSelected());
			driver.findElement(By.xpath("input[@value='21-40 Years']")).click();
			System.out.println("hey"+element.isSelected());
		}
	}
	
	
		public void checkRadioChecked(ChromeDriver driver, String pathInit, String pathLast, int numOfButton)
		{
			for(int i=1;i<=numOfButton;i++)
			{
				String finalPath=pathInit+i+pathLast;

				if(driver.findElement(By.xpath(finalPath)).isSelected())
				{
					switch(i)
					{
					case 1:
					{
						System.out.println("Chrome Radio Button is selected");
						break;
					}
					case 2:
					{
						System.out.println("Firefox Radio Button is selected");
						break;
					}
					case 3:
					{
						System.out.println("Safari Radio Button is selected");
						break;
					}
					case 4:
					{
						System.out.println("Edge Radio Button is selected");
						break;
					}
					}
					
				}
				else
				{
					switch(i)
					{
					case 1:
					{
						break;
					}
					case 2:
					{
						break;
					}
					case 3:
					{
						break;
					}
					case 4:
					{
						break;
					}
					}
				}
			}
		}
}
