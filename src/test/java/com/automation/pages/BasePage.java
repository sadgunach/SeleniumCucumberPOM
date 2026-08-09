package com.automation.pages;

	import org.openqa.selenium.WebDriver;

import com.automation.utils.JsonLocatorReader;
import com.automation.utils.NavigationConstants;
import com.automation.utils.WaitHelper;

	public class BasePage {
	    protected WebDriver driver;
	    protected WaitHelper wait;
	    protected JsonLocatorReader locators;

	    public BasePage(WebDriver driver,String locatorJsonPath) {
	        this.driver = driver;
	        this.wait = new WaitHelper(driver);
	        this.locators = new JsonLocatorReader(NavigationConstants.LOGIN_PAGE);
// Instantiated once here
	    }
	}


