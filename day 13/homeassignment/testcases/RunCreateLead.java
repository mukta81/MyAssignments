package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import page.LoginPage;


public class RunCreateLead extends BaseClass{
	

@Test
public void runCreateLead() {
	new LoginPage(driver)
	.enterUserName()
	.enterPassword()
	.clickLoginButton()
	.verifyHomePage()
	.clickCRMSFALink()
	.clickLeadsLink()
	.clickCreateLeadsLink()
	.enterCompanyName()
	.enterFirstName()
	.enterLastName()
	.clickSubmitButton()
	.verifyViewLeads();

}
}
