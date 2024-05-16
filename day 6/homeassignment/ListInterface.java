package week3.day2.homeassignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListInterface {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.ajio.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.name("searchVal")).sendKeys("bags");
		driver.findElement(By.className("rilrtl-button")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id=\"facets\"]/div[2]/ul/li[1]/div/div/div[2]/ul/li[1]/div/div/label")).click();	
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='facets']/div[2]/ul/li[2]/div/div/div[2]/ul/li[2]/div/div/label")).click();
		
		Thread.sleep(5000);
		System.out.println("Total : "+driver.findElement(By.xpath("//div[@class='filter']/div")).getAttribute("aria-label"));
		
		Thread.sleep(5000);
		List<WebElement> allBrand = driver.findElements(By.xpath("//div[@class='brand']/strong"));
		List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='nameCls']"));
		System.out.println(allBrand.size());
		System.out.println(allNames.size());
		
		for(int i=0; i<allBrand.size(); i++)
		{
			String textBrand = allBrand.get(i).getText();
			String textName = allNames.get(i).getText();
			System.out.println("Item"+i+" BrandName: "+textBrand+" Item Name: "+textName);
		}
	}

}
