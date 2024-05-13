package week3.day1.homeassignment;

public class LoginPage extends BasePage{

	public static void main(String[] args) {
		LoginPage obj = new LoginPage();
		obj.performCommonTasks();
		obj.clickElement();
		obj.enterText();
		obj.findElement();

	}
	
	 @Override
	public void performCommonTasks()
	{
		System.out.println("Overriding Method performCommonTasks() -> from LoginPage class");
	}
}
