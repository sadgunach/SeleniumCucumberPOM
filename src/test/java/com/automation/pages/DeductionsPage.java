package com.automation.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.NavigationConstants;
import com.automation.utils.WaitHelper;

public class DeductionsPage extends BasePage {
	public DeductionsPage(WebDriver driver){
		super(driver,NavigationConstants.DEDUCTION_PAGE);
	}
	public void clickNewAndCreatePrededuction() throws InterruptedException
	{
		WaitHelper.elementToBeClickable("//a[@title='New']/child::span[@aria-labelledby='new']");
	    WebElement newclick=driver.findElement(By.xpath("//a[@title='New']/child::span[@aria-labelledby='new']"));	
	    createPrededuction();
	    }
    public void createPrededuction() throws InterruptedException
    {
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
    	WebElement newclick=driver.findElement(By.xpath("//a[@title='New']/child::span[@aria-labelledby='new']"));
    	//driver.findElement(By.xpath("//a[@data-componentid='createButton']/span[text()='Deduction']")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(newclick).click().build().perform();
    	driver.findElement(By.xpath("//a[@data-componentid='createButton']/span[text()='Deduction']")).click();
    	WaitHelper.elementToBeVisible("//div[contains(@class,'x-title-text') and contains(text(),\"New Deduction\")]");
    //deduction type
        driver.findElement(By.xpath("//input[@name='deductionTypeName']/parent::div/following-sibling::div[contains(@class,'x-form-arrow-trigger')]")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@aria-hidden='false']/div[contains(@class,'x-boundlist-item')]")));
    	driver.findElement(By.xpath("(//ul[@aria-hidden='false']/div[contains(@class,'x-boundlist-item')])[2]")).click();
    	
    	driver.findElement(By.xpath("//input[@name='originalDisputeAmount']")).sendKeys("200");
    	driver.findElement(By.xpath("//input[@name='mapCustomerAccountRadDisplayText']/parent::div/following-sibling::div[contains(@class,'x-form-trigger')]")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'x-title-text') and contains(text(),\"Select Customer Name\")]")));
        Thread.sleep(3000);
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@autoid='plgridDeductionEditmapCustomerAccountRadDisplayText']/div[contains(@id,'paging-grid')]/descendant::table/tbody/tr)[1]"))));
    	WebElement grid=driver.findElement(By.xpath("(//div[@autoid='plgridDeductionEditmapCustomerAccountRadDisplayText']/div[contains(@id,'paging-grid')]/descendant::table/tbody/tr)[1]"));
        grid.click();
    	driver.findElement(By.xpath("//div[@autoid=\"plgridDeductionEditmapCustomerAccountRadDisplayText\"]/parent::div/following-sibling::div/descendant::span[text()='Select']")).click();
    	//Priority Dropdown
        driver.findElement(By.xpath("//input[@name='luDeductionPriorityRadLongName']/parent::div/following-sibling::div[contains(@class,'x-form-arrow-trigger')]")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@aria-hidden='false']/div[contains(@class,'x-boundlist-item')]")));
    	driver.findElement(By.xpath("(//ul[@aria-hidden='false']/div[contains(@class,'x-boundlist-item')])[2]")).click();
    	
    	//Reason Code Picklist
    	
    	driver.findElement(By.xpath("//input[@name='mapReasonCodeAccountRadLongName']/parent::div/following-sibling::div[contains(@class,'x-form-trigger')]")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'x-title-text') and contains(text(),\"Select Reason Code Description\")]")));
        Thread.sleep(3000);
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@autoid='plgridDeductionEditmapReasonCodeAccountRadLongName']/div[contains(@id,'paging-grid')]/descendant::table/tbody/tr)[1]"))));
    	driver.findElement(By.xpath("(//div[@autoid='plgridDeductionEditmapReasonCodeAccountRadLongName']/div[contains(@id,'paging-grid')]/descendant::table/tbody/tr)[1]")).click();
       

    	driver.findElement(By.xpath("//div[@autoid=\"plgridDeductionEditmapReasonCodeAccountRadLongName\"]/parent::div/following-sibling::div/descendant::span[text()='Select']")).click();
    	
    	//Status dropdown
    	 driver.findElement(By.xpath("//input[@name='luDeductionStatusRadLongName']/parent::div/following-sibling::div[contains(@class,'x-form-arrow-trigger')]")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@aria-hidden='false']/div[contains(@class,'x-boundlist-item')]")));
    		driver.findElement(By.xpath("(//ul[@aria-hidden='false']/div[contains(@class,'x-boundlist-item')])[2]")).click();
    	//Document type dropdown
    		
    		 driver.findElement(By.xpath("//input[@name='mapDocumentTypeAccountRadLongName']/parent::div/following-sibling::div[contains(@class,'x-form-arrow-trigger')]")).click();
    			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@aria-hidden='false']/div[contains(@class,'x-boundlist-item')]")));
    			driver.findElement(By.xpath("(//ul[@aria-hidden='false']/div[contains(@class,'x-boundlist-item')])[2]")).click();
    			//claim number
    			Random rand = new Random();
    			// nextInt(10) produces 0-9, so add 1 to get 1-10
    			Integer randomNum = rand.nextInt(10000) + 1;
    			HashMap<String,String> dynamicValue=new HashMap();
    			dynamicValue.put("claimNumber", "automation"+randomNum.toString());
    			driver.findElement(By.xpath("//input[@name='customerClaimNumber']")).sendKeys(dynamicValue.get("claimNumber"));
	
    }
    }
