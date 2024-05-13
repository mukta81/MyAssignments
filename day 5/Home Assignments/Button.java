package week3.day1.homeassignment;

public class Button extends WebElement{

	public static void main(String[] args) {
		Button objButton = new Button();
		objButton.submit();
		objButton.click();
		objButton.setText();
	}
	
	public void submit()
	{
		System.out.println("Method submit() -> from Button class");
	}

}
