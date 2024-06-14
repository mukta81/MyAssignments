package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import page.LoginPage;

public class RunLogin extends BaseClass{
	
	
	@Test
	public void runLogin() {
		new LoginPage(driver)
		.enterUserName()
		.enterPassword()
		.clickLoginButton()
		.verifyHomePage();

	}
}
