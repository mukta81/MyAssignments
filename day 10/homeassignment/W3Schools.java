package week5.day2.homeassignment;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class W3Schools {
	public static ChromeDriver driver;
	
	
	@BeforeMethod
	public void Setup() {
	//System.out.println("...setup...");
	driver = new ChromeDriver();
	driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_checkout_form");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
}
	
	@Test(dataProvider="readData")
	public void fillForm(String arr[]) throws InterruptedException {
		//public static ChromeDriver driver;
	System.out.println("..fillFORM...");
		driver.findElement(By.id("accept-choices")).click();
		
		//Switch to the iframe with the id "iframeResult"
		driver.switchTo().frame("iframeResult");
		
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
		String cardName =  arr[0];
		String ccNumber =  arr[1];
		String expMonth =  arr[2];
		String cvvNum =  arr[3];
		String expYear =  arr[4];
		String firstName =  arr[5];
		String email =  arr[6];
		String address =  arr[7];
		String city =  arr[8];
		String zip =  arr[9];
		String state =  arr[10];
		
		
		driver.findElement(By.id("cname")).sendKeys(cardName);
		driver.findElement(By.id("ccnum")).sendKeys(ccNumber);
		driver.findElement(By.id("expmonth")).sendKeys(expMonth);
		driver.findElement(By.id("cvv")).sendKeys(cvvNum);
		driver.findElement(By.id("expyear")).sendKeys(expYear);
		driver.findElement(By.id("fname")).sendKeys(firstName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("adr")).sendKeys(address);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zip")).sendKeys(zip);
		driver.findElement(By.id("state")).sendKeys(state);
		
		Thread.sleep(2000);
		driver.close();
	}
	
	@DataProvider(name="readData")
	public String[][] readFromExcel() throws IOException
	{
	
		System.out.println("...readfromexcel...");
		//workbook path
		XSSFWorkbook wb = new XSSFWorkbook("./data/W3SchoolsSampleData.xlsx");
		
		//work sheet
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		//row and row count
		int rowCount = ws.getLastRowNum(); //total rows
		//System.out.println("RowCount="+rowCount); //1
		
		//column count
		int cellCount = ws.getRow(rowCount).getLastCellNum();
				System.out.println("cellCount="+cellCount); //11
		
		String[][] arr = new String[rowCount][cellCount];
		
	//	System.out.println("Column: "+cellCount);
		
		for(int i=1; i<=rowCount;i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				String val = ws.getRow(i).getCell(j).getStringCellValue();
				arr[i-1][j]=val;
			//	System.out.println("arr:"+arr[i-1][j]);
			}
		}//end of for
		wb.close();
//		for(int i=0; i<arr.length;i++)
//		{
//			for(int j=0; j<arr[i].length; j++)
//			{
//				System.out.println(i+","+j+"arr:"+arr[i][j]);
//			}
//		}//end of for
//		
		
		return arr;
	}//end of readFromExcel
}//end of class W3Schools
