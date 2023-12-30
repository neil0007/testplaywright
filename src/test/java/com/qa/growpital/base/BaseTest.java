package com.qa.growpital.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.microsoft.playwright.Page;
import com.qa.growpital.factory.PageFactory;
import com.qa.growpital.pages.DashboardPage;
import com.qa.growpital.pages.InvestPage;
import com.qa.growpital.pages.LoginPage;

public class BaseTest {
	
	
	PageFactory pf;
	Page page;
	protected Properties prop;
	protected LoginPage loginPage;
	protected DashboardPage dashboardPage;
	protected InvestPage investPage;
	
	
	@BeforeTest
	public void setup() {
		pf = new PageFactory();
		prop = pf.init_prop();
		
		page = pf.initBrowser(prop);
		
		loginPage = new LoginPage(page);
		dashboardPage = new DashboardPage (page);
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
