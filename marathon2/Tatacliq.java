package week4.marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Tatacliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		String str="";
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		
		ChromeDriver driver = new ChromeDriver(opt);
		//ChromeDriver driver = new ChromeDriver();
		//load the URL
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		Actions load = new Actions(driver);
		WebElement elementBrand = driver.findElement(By.xpath("//div[text()='Brands']"));
		load.moveToElement(elementBrand).perform();

		WebElement elementWA = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		load.moveToElement(elementWA).perform();
		
		driver.findElement(By.xpath("//div[text()='Featured brands']/following-sibling::div")).click();
		
		//select New Arrivals
		WebElement selectElement = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
        Select select = new Select(selectElement);
        select.selectByValue("isProductNew");
		
        //select Men
        driver.findElement(By.xpath("//div[text()='Men']")).click();
        
        Thread.sleep(3000);
        
    	//find all elements in LIST
		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		System.out.println("Total Items: "+allPrice.size());
	
	
		//print price of all items.
		for(int i=0;i<=allPrice.size()-1;i++)
		{
			System.out.println(allPrice.get(i).getText());
			
			
		} //end of for
		str=allPrice.get(0).getText();
		System.out.println("first item cost"+str);
		//click on first item

		//driver.findElement(By.xpath("(//div[@class='ProductModule__base']/a)[1]")).click();
		
			WebElement element=driver.findElement(By.xpath("(//div[@class='ProductModule__imageAndDescriptionWrapper']/a)[1]"));
	        driver.executeScript("arguments[0].click();",element);
	        
	        String text = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
	        String finaltext = text.replace("MRP: ", "");
	        if(finaltext.equals(str))
	        {
	        	//System.out.println(finaltext+","+str);
	        	System.out.println("Price is same");
	        }
	        else
	        {
	        //	System.out.println(finaltext+","+str);
	        	System.out.println("Price is not same");
	        }
	        
	        
	        Set<String> windowHandle = driver.getWindowHandles();
			List<String> listHandle = new ArrayList<>(windowHandle);
			driver.switchTo().window(listHandle.get(1));
			
			Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
	        
	        Thread.sleep(2000);
	        
	        System.out.println("Count in cart: "+driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText());
	        driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).click();
	        
	        Thread.sleep(4000);
	        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			File desc = new File("./snap/imagename.png");
			FileUtils.copyFile(screenshotAs, desc);
	        
//	        File screenshotAs = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
//	        File desc = new File("./snap/imagename.png");
//			FileUtils.copyFile(screenshotAs, desc);
	        
			driver.close();
			Thread.sleep(1000);
			driver.switchTo().window(listHandle.get(0));
			driver.close();
			
			
			
	} //end of main

}	//end of class
