package com.automation.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testrunners.TestRunner;

import io.cucumber.java.Before;

	public class DriverManager {
	    private WebDriver driver;
	    private PageObjectManager pageObjectManager;
	    
	    @Before(order = 0)
	    public void setUpBrowserState() {
	        if (getDriver() == null) {
	            
	        	 // 1. Check JVM System Properties FIRST (e.g., passed via -Dbrowser=firefox)
	            String browserType = System.getProperty("browser");
	            
	            // 2. If no command line override is found, fall back to config.properties
	            if (browserType == null || browserType.trim().isEmpty()) {
	                browserType = ConfigFileReader.getProperty("browser");
	            }
         	            
	            // Final safety net fallback
	            if (browserType == null) {
	                browserType = "chrome"; 
	            }

	            // 2. INITIALIZE SELECTED BROWSER
	            switch (browserType.toLowerCase()) {
	                case "firefox":
	                    driver = new FirefoxDriver();
	                    break;
	                case "edge":
	                    driver = new EdgeDriver();
	                    break;
	                case "chrome":
	                default:
	                    driver = new ChromeDriver();
	                    break;
	            }
	        }
	    }
	    public  WebDriver getDriver() {
	        if (driver == null) {
	            driver=new ChromeDriver(); 
	            driver.manage().window().maximize();
	        }
	        return driver;
	    }
	    public PageObjectManager getPageObjectManager() {
	        if (pageObjectManager == null) {
	            // Pass the thread-safe driver directly into the manager here!
	            pageObjectManager = new PageObjectManager(getDriver());
	        }
	        return pageObjectManager;
	    }

	    // Safely closes and removes the driver instance
	    public  void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


