package week3.day1.homeassignment;

public class CheckBoxButton extends Button{

	public static void main(String[] args) {
		CheckBoxButton objCheckBoxButton = new CheckBoxButton();
		objCheckBoxButton.clickCheckButton();
		objCheckBoxButton.submit();
		objCheckBoxButton.click();
		objCheckBoxButton.setText();

	}
	
	public void clickCheckButton()
	{
		System.out.println("Method clickCheckButton() -> from CheckBoxButton class");
	}


}
