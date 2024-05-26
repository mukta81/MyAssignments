package week2.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class abhibus {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.abhibus.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(3000);
		//select from station as "Chennai"
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		
		
		//select to station as "Bangalore"
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		
		//click Tomorrow Button
		driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();
		
		Thread.sleep(3000);
		//get text of first result
		System.out.println("Name of first resulting bus:"+driver.findElement(By.xpath("(//h5[@class='title'])[1]")).getText());
		
		//click on sleeper 
		driver.findElement(By.xpath("//span[text()='Sleeper']")).click();
		
		//get info of first train
		System.out.println("Total:"+driver.findElement(By.xpath("//div[@id='service-cards-container']/div[1]/div/div/div[2]/div/div[2]/div/small")).getText());
		
		//click on Show Seats
		driver.findElement(By.xpath("//div[@id='service-cards-container']/div[1]/div/div/div[2]/div/div[2]/button")).click();
		
		
		//click on a seat
		driver.findElement(By.xpath("//button[@class='seat sleeper']")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("(//div[@id='place-container']//input) [1]")).click();

		driver.findElement(By.xpath("(//input[contains(@placeholder, 'Dropping Point')]/following:: input[@type='checkbox'])[1]")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[@class='seat sleeper']")).click();
	
		
		System.out.println("Seat Selected is:"+driver.findElement(By.xpath("(//span[@class='text-primary'])[1]")).getText());
		System.out.println("Total fare is:"+driver.findElement(By.xpath("(//span[@class='text-primary'])[2]")).getText());
		
		System.out.println("Title is:"+driver.getTitle());
		
		driver.close();
		
	}

}
