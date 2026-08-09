package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import com.automation.pages.DeductionsPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;


public class PageObjectManager{
    private HomePage homePage;
    private LoginPage loginPage;
	private WebDriver driver;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }
    public LoginPage getLoginPage() {
        if (loginPage == null) {
        	loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public DeductionsPage getDeductionsPage() {
   
        	return new DeductionsPage(driver);
    }
    public PageObjectManager getPOM()
    {
    	return new PageObjectManager(driver);
    }
    
}