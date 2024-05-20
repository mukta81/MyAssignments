package week4.day1.homeassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandling {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//login
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//click on CRM/SFA link -> Contacts -> Merge Contacts
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//click on 'from contact' widget
		driver.findElement(By.xpath("(//span[text()='From Contact']/following::a)[1]")).click();
	
		// get all window handles and put them in a Set
		Set<String> fromwindowHandle = driver.getWindowHandles();
		List<String> listHandleFrom = new ArrayList<>(fromwindowHandle);
	
		//switch to child window and select required value
		driver.switchTo().window(listHandleFrom.get(1));
		driver.findElement(By.xpath("((//table[@class='x-grid3-row-table'])[1]/tbody/tr/td/div/a)[1]")).click();
		
		//switch back to parent window
		driver.switchTo().window(listHandleFrom.get(0));
		
		//click on 'to contact' widget
		driver.findElement(By.xpath("(//span[text()='To Contact']/following::a)[1]")).click();
	
		// get all window handles and put them in a Set
		Set<String> towindowHandle = driver.getWindowHandles();
		List<String> listHandleTo = new ArrayList<>(towindowHandle);
	
		//switch to child window and select required value
		driver.switchTo().window(listHandleTo.get(1));
		driver.findElement(By.xpath("((//table[@class='x-grid3-row-table'])[1]/tbody/tr/td/div/a)[1]")).click();
		
		//switch back to parent window and click on merge button
		driver.switchTo().window(listHandleTo.get(0));
		driver.findElement(By.className("buttonDangerous")).click();
		
		//switch to alert
		driver.switchTo().alert().accept();
		
		//get current window title
		System.out.println("Title of curent screen is: " +driver.getTitle());

	
	}

}
