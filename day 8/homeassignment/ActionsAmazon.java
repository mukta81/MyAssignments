package week4.day2.homeassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class ActionsAmazon {

	public static void main(String[] args) throws InterruptedException {
		ActionsAmazon obj = new ActionsAmazon();
		ChromeDriver driver = new ChromeDriver();
		//load the URL
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//search
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//get the price and number of rating of first product
		String price = driver.findElement(By.xpath("((//div[@class='puisg-row'])[2]/div/div/div/div/div/a/span/span)[2]/span[2]")).getText();
		String rating = driver.findElement(By.xpath("((//div[@class='puisg-row'])/div[2]/div/div/div[2]//span[2])[1]")).getText();
		System.out.println("Price of first product: "+ price);
		System.out.println("Number of customer ratings for the first displayed product: "+ rating);		
	
		//click on first item link 
		driver.findElement(By.xpath("(//div[@class='puisg-row']/div[2]/div/div/div/h2/a)[1]")).click();
	
		obj.movetoWindow(driver,1);
		
		//add to cart button
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		
		//read the card subtotal
		String subTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		
		String cleanSubTotal = subTotal.replace("₹", "").replace(".00", "");

		//verify card subtotal is correct
		if(price.equals(cleanSubTotal))
		{
			System.out.println("SubTotal is correct");
		}
		else
		{
			System.out.println("SubTotal is Not correct");
		}
	
		driver.quit();
	}
	
	
	//common method to switch to a particular window whose index is passed as second argument
	public void movetoWindow(ChromeDriver driver, int windowIndex)
	{
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> listHandle = new ArrayList<>(windowHandle);
		driver.switchTo().window(listHandle.get(windowIndex));
	}
	

}
