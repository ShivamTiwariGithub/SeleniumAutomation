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

public class NewOrderProductSearch_Page {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(NewOrderProductSearch_Page.class);
	
	WaitHelper waitHelper;
	
	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-invoice/div/div/div/div/div[2]/div/table[2]/tbody/tr[1]/td/input")
	WebElement ProductSearchBox;
	
	@FindBy(xpath="//a[text()='Search']")
	WebElement SearchButton;
	
	public NewOrderProductSearch_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(ProductSearchBox, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("NavigationMenu object created");
		new TestBase().getNavigationScreen(driver);
	}
	
	public void enterProductCode(String ProductCode){
		log.info("entering product code...."+ProductCode);
		logExtentReport("entering product code...."+ProductCode);
		this.ProductSearchBox.sendKeys(ProductCode);
	}
	
	public NewOrderSupplierSelection_Page clickOnSearchButton(){
		log.info("clicking on search button...");
		logExtentReport("clicking on search button...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		//new JavaScriptHelper(driver).scrollDownVertically();
		SearchButton.click();
		return new NewOrderSupplierSelection_Page(driver);
	}

	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}

}
