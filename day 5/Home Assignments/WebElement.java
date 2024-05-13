package week3.day1.homeassignment;

public class WebElement {

	public static void main(String[] args) {
		WebElement objWebElement = new WebElement();
		objWebElement.click();
		objWebElement.setText();
	}
	
	public void click()
	{
		System.out.println("Method click() -> from WebElement class");
	}
	
	public void setText()
	{
		System.out.println("Method setText() -> from WebElement class");
	}

}
