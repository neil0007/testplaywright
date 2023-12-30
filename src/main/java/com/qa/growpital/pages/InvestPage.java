package com.qa.growpital.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InvestPage {
private Page page;
	
	//String Locators
	private String investOn2ndPlan = "(//button[text()='Invest Now'])[2]";
	private String investOn3rdPlan = "(//button[text()='Invest Now'])[3]";
	private String subHeading = "//div[@class='bottom-text page-subheading']";
	private String cardHeading = "(//div/div[1])[32]";
	private String continueButton = "//div[2]/button";
	private String enterUnits = "//input[@value='0']";
	private String paymentMessage = "(//div[2]/div[4])[2]";
	private String nextContinueButton = "//div[2]/button";
	private String mandatoryTextOfConsentLetter = "//div[@class='section-description  black-text']";
	private String consentLetterButton = "//button[@class='custom-button active_button']";
	private String proceedToSignButton = "//button[@class='app-button btn-primary']";
	private String typeSign = "(//div/div[2])[7]";
	private String confirmSigniture = "(//button[@class='app-button btn-primary'])[2]";
	private String confirmationText = "//div[3]/div/span";
	private String viewDetailsLink = "//b[@class='gold-text']";
	private String cancelPlanButton = "//button[@class='custom-button red-btn']";
	private String yesConfirmationButton = "//button[@class='custom-button yes  red-btn']";
	private String cancelReason = "(//input[@type='checkbox'])[3]";
	private String submitCancelPlanButton = "//button[@class='custom-button active_button']";
	private String cancelConfirmation = "//div[text()='Cancelled']";
	
	

	//page constructor
	public InvestPage(Page page) {
		this.page = page;
	}

	
	//page actions/methods:

	public String getInvestPageURL() {
		return page.url();
	}
	
	public String getInvestPageTitle() {
		String title =  page.title();
		return title;
	}
	
	public String getInvestmentURL () {
		Locator element = page.locator(investOn2ndPlan).first();
		element.evaluate("element => element.scrollIntoView()");
		page.click(investOn2ndPlan);
		String url = page.url();
		return url;
	}
	
	public String getSubHeading() {
		return page.textContent(subHeading);
	}
	
	public String unitCalcualtionCardHeading() {
		return page.textContent(cardHeading);
	}
	
	public void enterUnits (String i) {
		page.fill(enterUnits, i);
	}
	
	public boolean isContinueButton() {
		return page.isEnabled(continueButton);
	}
	
	public void clickOnContinueButton() {
		page.click(continueButton);
	}
	
	public String getInvestmentPaymentPageURL() {
		return page.url();
	}
	
	public boolean isPaymentPageContinueButton() {
		return page.isEnabled(nextContinueButton);
	}
	
	public String getPaymentMessage () {
		return page.textContent(paymentMessage);
	}
	
	public void clickOnNextContinuebutton() {
		page.click(nextContinueButton);
	}
	
	public String getConsentLetterPageURL() {
		return page.url();
	}
	
	public String getMandatoryTextOfConsentLetter() {
		return page.textContent(mandatoryTextOfConsentLetter);
	}
	
	public void signConsentLetter() {
		Page  popup = page.waitForPopup(()->{
			page.click(consentLetterButton);
		});
		
		popup.click(proceedToSignButton);
		popup.click(typeSign);
		popup.click(confirmSigniture);
	}
	
	public String getConfirmationTextAfterSigningConsentLetter() {
		page.waitForSelector(confirmationText);
		return page.textContent(confirmationText);
	}
		
	public String navigateToCancelPlan() {
		page.click(viewDetailsLink);
		return page.title();
	}
	
	public void cancelPlan() {
		page.waitForSelector(cancelPlanButton);
		page.click(cancelPlanButton);
		page.click(yesConfirmationButton);
		page.click(cancelReason);
		page.click(submitCancelPlanButton);
	}
	
	public String checkPlanCancel() {
		page.waitForSelector(cancelConfirmation);
		return page.textContent(cancelConfirmation);
	}


}
