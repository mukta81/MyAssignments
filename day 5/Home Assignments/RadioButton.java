package week3.day1.homeassignment;

public class RadioButton extends Button{

	public static void main(String[] args) {
		RadioButton objRadioButton = new RadioButton();
		objRadioButton.selectRadioButton();
		objRadioButton.submit();
		objRadioButton.click();
		objRadioButton.setText();
	}
	
	public void selectRadioButton()
	{
		System.out.println("Method selectRadioButton() -> from RadioButton class");
	}

}
