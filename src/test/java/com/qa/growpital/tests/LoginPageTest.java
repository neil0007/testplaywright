package com.qa.growpital.tests;

import org.testng.Assert;

import org.testng.annotations.Test;
import com.qa.growpital.base.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		String expectedLoginPageTitle = "Growpital";
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
	}
	@Test(priority = 2)
	public void verifyForgotPasswordLinkExist() {
		Assert.assertTrue(loginPage.isForgotPassLinkExist(), "Forgot Password link is not visible");
	}
	@Test(priority = 3)
	public void verifySignUpLinkExist() {
		Assert.assertTrue(loginPage.isSignUpLinkExist(), "Sign Up link is not visible");
	}
	
	@Test(priority = 4)
	public void loginToGrowpital() throws InterruptedException {
		loginPage.enterEmailAddress("neil@growpital.com");
		loginPage.enterPassword("Liverpool@01");
		loginPage.clickOnLoginButton();
		Thread.sleep(5000);
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		String expectedLoginPageTitle = "Dashboard | Growpital";
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
	}
	
	@Test(priority = 5)
	public void verifyDashboardPageURL() throws InterruptedException {
		String actualDashboardPageURL = loginPage.getDashboardPageURL();
		String expectedDashboardPageURL = "https://app.growpital.com/";
		Assert.assertEquals(actualDashboardPageURL, expectedDashboardPageURL);
		Thread.sleep(5000);
	}
	
	@Test(priority = 6)
	public void verifySingOutText() throws InterruptedException {
		Thread.sleep(5000);
		dashboardPage.clickOnProfileIconPopUp();
		String actualTextPresentOnSingOutButton = dashboardPage.verifyTextPresentOnSingOutButton();
		String expectedlTextPresentOnSingOutButton = "Sign out";
		Assert.assertEquals(actualTextPresentOnSingOutButton, expectedlTextPresentOnSingOutButton);
	}
	
	@Test(priority = 7)
	public void verifySingOutFromApp() throws InterruptedException {
		dashboardPage.clickOnSignOutButton();
		String actualDashboardPageTitlLe = dashboardPage.getDashboardPageTitlLe();
		String expectedDashboardPageTitlLe = "Dashboard | Growpital";
		Assert.assertEquals(actualDashboardPageTitlLe, expectedDashboardPageTitlLe);
	}
	

}
