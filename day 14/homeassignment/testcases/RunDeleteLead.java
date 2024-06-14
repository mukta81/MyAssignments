package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import page.LoginPage;

public class RunDeleteLead extends BaseClass{
	
	@Test
	public void runDeleteLead() throws InterruptedException {
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
		.clickDeleteButton()
		.clickFindLeadsLink()
		.enterDeletedLeadId()
		.clickFindLeadsButton()
		.checkDeleteStatus();

	}


}
