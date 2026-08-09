package com.testrunners;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.automation.utils.DriverManager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber/Cucumber.json",
				"rerun:reports/rerun.txt" }, 
			features = "src/test/resources", 
			glue = "com.stepdefinitions", 
			tags = "@Smoke123",
			dryRun=false,
			monochrome=true
)

public class TestRunner extends AbstractTestNGCucumberTests  {
    @Override
    @DataProvider(parallel = false) 
    public Object[][] scenarios() {
        return super.scenarios();
    }

	public static String getBrowser() {
		// TODO Auto-generated method stub
		return null;
	}


}

