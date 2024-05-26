package week4.marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		//load the URL
		driver.get("https://dev200784.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//enter username and password
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("k6C8-ajUWqY%");
		driver.findElement(By.id("sysverb_login")).click();
		
		Thread.sleep(9000);
		
		Shadow dom=new Shadow(driver);
		WebElement element = dom.findElementByXPath("//div[@class='starting-header-zone']/div[2]/div[1]");
		element.click();
		
		
		Thread.sleep(1000);
		WebElement texteleme = dom.findElementByXPath("//label[text()='All filter navigator']/following-sibling::input");
		texteleme.sendKeys("Service Catalog");
		
		Thread.sleep(2000);
		WebElement textFind = dom.findElementByXPath("//mark[text()='Service Catalog']");
		textFind.click();
		//System.out.println("Clicked on catalog");
		
		Thread.sleep(2000);
		WebElement findFrame = dom.findElementByXPath("//iframe[@name='gsft_main']");
		driver.switchTo().frame(findFrame);
		//System.out.println("Inside the frame");
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']")).click();
		
		//fill mandatory fields
		
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		driver.findElement(By.xpath("//span[text()='What was the original phone number?']/following::input[2]")).sendKeys("1234567890");
		WebElement selectElement = driver.findElement(By.xpath("//span[text()='Monthly data allowance']/following::select"));
        Select select = new Select(selectElement);
        select.selectByValue("500MB");
        driver.findElement(By.id("oi_order_now_button")).click();
        WebElement string = driver.findElement(By.xpath("//div[@id='sc_order_status_intro_text']/div/span"));
       
        System.out.println("Message after Order: "+string.getText());
      
        
        WebElement requestNumber = driver.findElement(By.xpath("//div[@id='sc_order_status_intro_text']/dl/dd[2]/a/b"));
        System.out.println("Request Number : "+requestNumber.getText());	
        
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snap/imageServiceNow.png");
		FileUtils.copyFile(screenshotAs, desc);
		
		driver.close();

	}

}
