package week4.day2.homeassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSnapDeal {

	public static void main(String[] args) throws InterruptedException {
		ActionsSnapDeal obj = new ActionsSnapDeal();
		String ret="";
		String text ="";
		String appendText="";
		
		ChromeDriver driver = new ChromeDriver();
		//load the URL
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Men's Fashion -> Go to Sports Shoes -> Get the count of Sports Shoes
		driver.findElement(By.xpath("//span[@class ='catText' and contains(text(),'Men')]")).click();
		driver.findElement(By.xpath("//span[@class='linkTest' and text()='Sports Shoes']")).click();
		System.out.println("Total Sports Shoes found"+driver.findElement(By.xpath("//input[@id='searchWithinSearch']/parent::div/preceding-sibling::span")).getText());
	
		//Click on Training Shoes -> Sort Products Low to high
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		
		Thread.sleep(3000);
		
		//scroll to "See More" button and load all products
		Actions load = new Actions(driver);
		WebElement elementToScroll = driver.findElement(By.id("see-more-products"));
		load.scrollToElement(elementToScroll).perform();
		
		//load more data
		driver.findElement(By.xpath("//div[contains(text(),'Showing')]"));
		
		//find all elements in LIST
		List<WebElement> allPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	//	System.out.println("Total Training Shoes Loaded: "+allPrice.size());
	
	
		//check price is correct
		for(int i=0;i<allPrice.size()-1;i++)
		{
			int j=i+1;
			String price1 = allPrice.get(i).getText().replace("Rs. ", "").replace(",", "");
			String price2 = allPrice.get(j).getText().replace("Rs. ", "").replace(",", "");
			
			int intprice1=Integer.parseInt(price1);
			int intprice2=Integer.parseInt(price2);
			
			if(intprice1<=intprice2){ret = "T";}
			else{ret = "F";}
		} //end of for
		
		//price is correctly sorted or not
		if(ret=="T"){System.out.println("All items are sorted correctly from price low to high");}
		else if(ret=="F"){System.out.println("All items are not sorted correctly for price low to high");}
		
		
		//load.moveToElement(driver.findElement(By.name("fromVal")));
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("toVal")).clear();

		//Select any price range
		driver.findElement(By.name("fromVal")).sendKeys("500");
		driver.findElement(By.name("toVal")).sendKeys("700");
		driver.findElement(By.name("toVal")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		
		 //Filter by any color
		driver.findElement(By.xpath("//label[@for='Color_s-Black']")).click();
		
		Thread.sleep(2000);
		//check what all filters are selected
		List<WebElement> checkheader = driver.findElements(By.xpath("//div[@class='filters']/div"));
		for(int i=0;i<checkheader.size();i++)
		{
			WebElement value = checkheader.get(i);
			text = value.getText();
			if(!text.isEmpty())
			{
				appendText+=text+",";
			}
		}
		
		System.out.println("All applied filters are: "+appendText);
		
		WebElement mouseHover = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		load.scrollToElement(mouseHover);
		load.moveToElement(mouseHover).perform();
		
		
		Thread.sleep(3000);

		//click on Quick View
		driver.findElement(By.xpath("//picture[@class='picture-elem']/following::div/div")).click();
		
		//display cost and discount percentage
		System.out.println("Cost in Quick View Window: Rs. "+driver.findElement(By.xpath("//div[contains(text(),'Price') and @class='tag-title']/following::div[3]/span")).getText());
		System.out.println("Discount percentage in Quick View Window: "+driver.findElement(By.xpath("//div[contains(text(),'Price') and @class='tag-title']/following::div[3]/span[2]")).getText());
		
		driver.findElement(By.xpath("//div[@id=\"sidebar_modal_right\"]/div[2]/div[2]/i")).click();
		
		driver.close();
	}  //end of main
		

}  //end of class
