package com.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.pages.BasePage;

public class WaitHelper  {
	protected static WebDriver driver;
	public WaitHelper(WebDriver driver){
		this.driver=driver;
	}
	public static void elementToBeClickable(String wbLocator)
	{
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(wbLocator)));
	}
	public static void elementToBeVisible(String wbLocator)
	{
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wbLocator)));
	}
}
