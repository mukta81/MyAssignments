package week3.day1.homeassignment;

public class TestData {

	public static void main(String[] args) {
		TestData objTD = new TestData();
		objTD.enterCredentials();
		objTD.navigateToHomePage();

	}
	
	public void enterCredentials()
	{
		System.out.println("Method enterCredentials() -> from TestData class");
	}
	
	public void navigateToHomePage()
	{
		System.out.println("Method navigateToHomePage() -> from TestData class");
	}

}
