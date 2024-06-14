package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import page.LoginPage;

public class RunEditLead extends BaseClass{
	@Test
	public void runEditLead() throws InterruptedException {
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
		.clickFirstResult()
		.clickEditButton()
		.updateCompName()
		.clickUpdateButton()
		.verifyUpdatedViewLeads();
		

	}

}
