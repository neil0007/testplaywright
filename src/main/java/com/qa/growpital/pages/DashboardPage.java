package com.qa.growpital.pages;

import com.microsoft.playwright.Page;

public class DashboardPage {
	private Page page;
	
	//String Locators
	private String profileIconPopUp = "//div[@class='header-footer_user_name_icon_wapper__dAxRN']";
	private String singOutText = "(//div[@class='header-footer_popup_content__QdhRc'])[5]";
	private String singOutButton = "(//*[local-name()='svg'])[11]";
	private String investTab = "//a[@title='Invest']";
	
	//page constructor
		public DashboardPage(Page page) {
			this.page = page;
		}
		
	//page actions/methods:
		public void clickOnProfileIconPopUp() {
			page.click(profileIconPopUp);
		}
		
		public String verifyTextPresentOnSingOutButton() {
			
			return page.textContent(singOutText);
		}
		
		public void clickOnSignOutButton() {
			page.click(singOutButton);
		}
		
		public String logOutFromApp() {
			String title =  page.title();
			System.out.println("page title: " + title);
			return title;
		}
		
		public String getDashboardPageTitlLe() {
			String title =  page.title();
			System.out.println("page title: " + title);
			return title;
		}
		
		public InvestPage navigateToInvestTab() {
			page.click(investTab);
			return new InvestPage(page);
		}
	
	

}
