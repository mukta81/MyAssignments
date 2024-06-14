package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import page.LoginPage;

public class RunDuplicateLead extends BaseClass{
	
	@Test
	public void runDuplicateLead() throws InterruptedException {
		new LoginPage(driver)
		.enterUserName()
		.enterPassword()
		.clickLoginButton()
		.verifyHomePage()
		.clickCRMSFALink()
		.clickLeadsLink()
		.clickFindLeadsLink()
		.enterPhone()
		.clickFindLeadsButton()
		.getAndClickFirstID()
		.clickDuplicateButton()
		.createDuplicateLead()
		.verifyDuplicateLeadCreated();
	}


}
