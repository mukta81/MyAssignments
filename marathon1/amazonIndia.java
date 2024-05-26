package week2.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonIndia {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//search using Bags for b
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for b");
		Thread.sleep(3000);
		
		//click first option
		driver.findElement(By.xpath("(//div[@class='s-suggestion s-suggestion-ellipsis-direction'])[1]")).click();
		System.out.println("Total no of results: "+driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
		
		//select first brand
		driver.findElement(By.xpath("//span[text()='Brand']//following::span/a/div/label/i")).click();
		
		
		System.out.println("Name: "+driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText());
		
		System.out.println("Price: "+driver.findElement(By.className("a-price-whole")).getText());
		
		System.out.println("Title is: "+driver.getTitle());
		
		driver.close();

	}

}
