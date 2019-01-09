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

public class NewOrderProductInfoPage {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(NewOrderProductInfoPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement ContinueButton;
	
	public NewOrderProductInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(ContinueButton, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("NavigationMenu object created");
		new TestBase().getNavigationScreen(driver);
	}
	
	public QuestionAnswer_Page clickOnContinue(){
		log.info("clicking on continue button...");
		logExtentReport("clicking on continue button...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(ContinueButton, 20);
		ContinueButton.click();
		return new QuestionAnswer_Page(driver);
	}

	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
}
