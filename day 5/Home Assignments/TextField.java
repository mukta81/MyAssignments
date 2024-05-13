package week3.day1.homeassignment;

public class TextField extends WebElement{

	public static void main(String[] args) {
		TextField objTextField = new TextField();
		objTextField.getText();
		objTextField.click();
		objTextField.setText();
	}
	
	public void getText()
	{
		System.out.println("Method getText() -> from TextField class");
	}


}
