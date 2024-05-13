package week3.day1.homeassignment;

public class LoginTestData extends TestData {

	public static void main(String[] args) {
		LoginTestData objLTD = new LoginTestData();
		objLTD.enterUsername();
		objLTD.enterPassword();
		objLTD.enterCredentials();
		objLTD.navigateToHomePage();


	}

	public void enterUsername()
	{
		System.out.println("Method enterUsername() -> from LoginTestData class");
	}
	
	public void enterPassword()
	{
		System.out.println("Method enterPassword() -> from LoginTestData class");
	}
}
