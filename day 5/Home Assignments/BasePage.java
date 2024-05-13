package week3.day1.homeassignment;

public class BasePage {

	public static void main(String[] args) {
		BasePage obj =  new BasePage();
		
		obj.clickElement();
		obj.findElement();
		obj.enterText();
		obj.performCommonTasks();
	}

	
	public void findElement()
	{
		System.out.println("Method findElement() -> from BasePage class");
	}
	
	public void clickElement()
	{
		System.out.println("Method clickElement() -> from BasePage class");
	}
	
	public void enterText()
	{
		System.out.println("Method enterText() -> from BasePage class");
	}
	
	public void performCommonTasks()
	{
		System.out.println("Method performCommonTasks() -> from BasePage class");
	}
}
