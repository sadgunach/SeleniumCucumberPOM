package com.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ReportManager;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigFileReader;
import com.automation.utils.DriverManager;
import com.automation.utils.PageObjectManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.testrunners.TestRunner;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.context.Context;

public class LoginStepDefinations {
	ExtentReports reports;
	ExtentTest test;
	ConfigFileReader Prop=new ConfigFileReader();
	   private WebDriver driver;
	   private PageObjectManager pom;
	   private LoginPage loginPage;

	    // PicoContainer shares the exact same context object used in Hooks
	 public LoginStepDefinations(DriverManager context) {
	        this.driver = context.getDriver();
	        this.pom= context.getPageObjectManager();
	    }
	@Before(order = 1)
	public void setup(Scenario scenario)
	{
		scenario.getName();
		System.out.println(scenario.getName());
   	    driver.get(Prop.getProperty("url"));
        pom.getLoginPage().Login(Prop.getProperty("username"), Prop.getProperty("password"));
	   
	}
	@Given("Verify the homepage navigation and check default landing Page")
	public void open_the_browser() throws InterruptedException {
		pom.getHomePage().verifyHome();
		
	}
	@When("Open deduction window and fill the deduction details")
	public void open_deduction_window_and_fill_the_deduction_details() {
    
		try {
			pom.getDeductionsPage().clickNewAndCreatePrededuction();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Then("check the deduction page loading")
	public void login_should_successfull() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
	}	
	   @After
	    public void tearDown(Scenario scenario) {
		   
	        if (scenario.isFailed() && driver != null) {
	            // Capture and embed screenshot directly into the Extent Report
	            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", scenario.getName());
	        }else
	        {
	        //	scenario.log("Scenario is " +scenario.getStatus());
	        }
	        
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
