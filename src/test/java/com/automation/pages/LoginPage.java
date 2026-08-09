package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.JsonLocatorReader;
import com.automation.utils.NavigationConstants;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver,NavigationConstants.LOGIN_PAGE);

    }
    public void Login(String username,String password)
    {
 	    driver.findElement(locators.getLocator("txtUsername")).sendKeys(username);

 	    driver.findElement(locators.getLocator("txtPassword")).sendKeys(password);
 	    driver.findElement(locators.getLocator("btnSubmit")).click();
    }
	

}
