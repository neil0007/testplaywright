package com.qa.growpital.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.growpital.base.BaseTest;

public class InvestPageTest extends BaseTest{
	@Test(priority = 1)
	public void verifyDashboardPageTitle() throws InterruptedException {
		loginPage.loginToGrowpital("gatrin@gmail.com", "Growpital@123");
		Thread.sleep(5000);
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		String expectedLoginPageTitle = "Dashboard | Growpital";
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
		
	}
	@Test(priority = 2)
	public void verifyInvestPageURL() {
		investPage = dashboardPage.navigateToInvestTab();
		String actualInvestPageURL = investPage.getInvestPageURL();
		String expectedInvestPageURL = "https://app.growpital.com/new-investment";
		Assert.assertEquals(actualInvestPageURL, expectedInvestPageURL);
	}
	
	@Test(priority=3)
	public void verifyInvestPageTitle() {
		String actualInvestPageTitle = investPage.getInvestPageTitle();
		String expectedInvestPageTitle = "New Investment | Growpital";
		Assert.assertEquals(actualInvestPageTitle, expectedInvestPageTitle);
	}
	
	@Test(priority = 4)
	public void verifySelectInvestmentPageURL() {
		String actualInvestmentPageURL = investPage.getInvestmentURL();
		String expectedInvestmentPageURL = "https://app.growpital.com/new-investment/investAmount";
		Assert.assertEquals(actualInvestmentPageURL, expectedInvestmentPageURL);
		}
	
	@Test(priority = 5)
	public void verifySubHeading() {
		String actualSubHeading = investPage.getSubHeading();
		String expectedSubHeading = "Invest directly in farm projects and get fixed payouts";
		Assert.assertEquals(actualSubHeading, expectedSubHeading);
	}
	
	@Test(priority = 6)
	public void verifyUnitCalculationCardHead() {
		String actualUnitCalcualtionCardHeading = investPage.unitCalcualtionCardHeading();
		String expectedUnitCalcualtionCardHeading = "Your Investment Details";
		Assert.assertEquals(actualUnitCalcualtionCardHeading, expectedUnitCalcualtionCardHeading);
	}
	
	@Test(priority = 7)
	public void verifyContinueButtonIsDisabled () {
		Assert.assertFalse(investPage.isContinueButton(), "Continue Button should be disabled before entring Unit");
	}
	
	@Test(priority = 8)
	public void verifyContinueButtonIsEnabled() {
		investPage.enterUnits("1");
		investPage.clickOnContinueButton();
		Assert.assertTrue(investPage.isContinueButton(), "Continue Button should be enable after entring Unit");
	}
	
	@Test(priority = 9)
	public void verifyInvestmentPaymentPageURL() {
		String actualInvestmentPaymentPageURL = investPage.getInvestmentPaymentPageURL();
		String expectedInvestmentPaymentPageURL = "https://app.growpital.com/new-investment/makePayment";
		Assert.assertEquals(actualInvestmentPaymentPageURL, expectedInvestmentPaymentPageURL);
	}
	
	@Test(priority = 10)
	
	public void verifyIsPaymentPageContinueButton() {
		Assert.assertTrue(investPage.isPaymentPageContinueButton(), "Continue Button present in payment section is disable because Money Is insufficient");
	}
	
	@Test(priority = 11)
	public void verifyPaymentMessage () {
		String actualPaymentMessage = investPage.getPaymentMessage();
		String expectedPyamentMessage = "The payment you'll make will be added to your Growpital account wallet first, and will be charged only on completion of all 4 steps.";
		Assert.assertEquals(actualPaymentMessage, expectedPyamentMessage);
	}
	
	@Test(priority = 12)
	public void verifyConsentLetterPageURL() {
		investPage.clickOnNextContinuebutton();
		String actualConsentLetterPageURL = investPage.getConsentLetterPageURL();
		String expectedConsentLetterPageURL = "https://app.growpital.com/new-investment/agreement"; 
		Assert.assertEquals(actualConsentLetterPageURL, expectedConsentLetterPageURL);
		}
	
	@Test(priority = 13)
	public void verifyMandatoryTextInfoBeforeSigningConsentLetter(){
		String actualMandatoryTextInfoBeforeSigningConsentLetter = investPage.getMandatoryTextOfConsentLetter();
		String expectedMandatoryTextInfoBeforeSigningConsentLetter = "Please be advised we shall be liable for the terms only if the informationprovided by you, such as name, gender, date of birth, and Aadhaar number, iscorrect. Please make sure that you are not furnishing any incorrect information.";
		Assert.assertEquals(actualMandatoryTextInfoBeforeSigningConsentLetter, expectedMandatoryTextInfoBeforeSigningConsentLetter);
	}
	
	@Test(priority = 14)
	public void verifyPlanPurchaseText(){
		investPage.signConsentLetter();
		String actualPlanPurchaseText = investPage.getConfirmationTextAfterSigningConsentLetter();
		String expectedPlanPurchaseText = "Your plan is successfully created. ";
		Assert.assertEquals(actualPlanPurchaseText, expectedPlanPurchaseText);
	}
	
	@Test(priority = 15)
	public void verifyCancelPlanPageTitle(){
		String actualCancelPlanPageTitle = investPage.navigateToCancelPlan();
		String expectedCancelPlanPageTitle = "My Investment | Growpital";
		Assert.assertEquals(actualCancelPlanPageTitle, expectedCancelPlanPageTitle);
	}

	@Test(priority = 16)
	public void verifyStatusOfPlan() {
		investPage.cancelPlan();
		String actualStatus = investPage.checkPlanCancel();
		String expectedStatus = "Cancelled";
		Assert.assertEquals(actualStatus, expectedStatus);
		}

}
