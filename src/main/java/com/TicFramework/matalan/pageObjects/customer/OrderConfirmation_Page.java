package com.TicFramework.matalan.pageObjects.customer;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.TicFramework.matalan.helper.configuration.ObjectReader;
import com.TicFramework.matalan.helper.javascript.JavaScriptHelper;
import com.TicFramework.matalan.helper.logger.LoggerHelper;
import com.TicFramework.matalan.helper.wait.WaitHelper;
import com.TicFramework.matalan.testbase.TestBase;

public class OrderConfirmation_Page {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(OrderConfirmation_Page.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement Checkbox;
	
	@FindBy(xpath="//a[text()='Confirm']")
	WebElement ConfirmButton;
	
	@FindBy(xpath="//input[@type='number']")
	WebElement Quantity;
	
	public OrderConfirmation_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(ConfirmButton, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("NavigationMenu object created");
		new TestBase().getNavigationScreen(driver);
	}
	
	public void enterquantity(String quantity){
		log.info("entering product code...."+quantity);
		logExtentReport("entering product code...."+quantity);
		this.Quantity.sendKeys(quantity);
	}
	
	public void clickOnCheckBox(){
		log.info("clicking on CheckBox...");
		logExtentReport("clicking on CheckBox...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		waitHelper = new WaitHelper(driver);
		waitHelper.WaitForElementClickable(Checkbox, 10);
		Checkbox.click();
	}
	
	public void clickOnConfirmButton(){
		log.info("clicking on ConfirmButton...");
		logExtentReport("clicking on ConfirmButton...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		waitHelper = new WaitHelper(driver);
		waitHelper.WaitForElementClickable(ConfirmButton, 10);
		ConfirmButton.click();
	}

	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
}
