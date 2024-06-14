package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import page.LoginPage;

public class RunMergeLead extends BaseClass{
	
	@Test
	public void runMergeLead() throws InterruptedException {
		new LoginPage(driver)
		.enterUserName()
		.enterPassword()
		.clickLoginButton()
		.verifyHomePage()
		.clickCRMSFALink()
		.clickLeadsLink()
		.clickLeadsLinkForMergeLink()
		.clickLookUpFromLead()
		.switchToLookupWindow()
		.enterFromNameMergeLookUp()
		.clickFindLeadToMerge()
		.selectFirstLeadFromLookup()
		.switchBackToMainWindow()
		.selectLeadToLookup()
		.switchToLookupWindow()
		.enterToNameMergeLookUp()
		.clickFindLeadToMerge()
		.selectFirstToLeadLookup()
		.switchBackToMainWindow()
		.clickMergeButton()
		.switchBackToMainWindow()
		.acceptAlertOnMergeLead()
		.clickFindLeadsLink()
		.enterLeadIdFromLookUp()
		.clickFindLeadsButton()
		.checkMergeStatus();

	}

}
