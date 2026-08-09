package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.NavigationConstants;
public class HomePage extends BasePage {
	public HomePage(WebDriver driver){
        super(driver,NavigationConstants.HOME_PAGE);
	}
   public void verifyHome()
   {
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.textToBe(By.xpath("//a[text()='Privacy Policy']"), "Privacy Policy"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='x-mask-msg']/div/div[text()='Loading...']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Save Current Layout']")));
   }
}
