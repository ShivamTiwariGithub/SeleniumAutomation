package com.TicFramework.matalan.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.TicFramework.matalan.helper.assertion.VerificationHelper;
import com.TicFramework.matalan.helper.configuration.ObjectReader;
import com.TicFramework.matalan.helper.javascript.JavaScriptHelper;
import com.TicFramework.matalan.helper.logger.LoggerHelper;
import com.TicFramework.matalan.helper.wait.WaitHelper;
import com.TicFramework.matalan.pageObjects.customer.CustomerHome_Page;
import com.TicFramework.matalan.testbase.TestBase;

/**
 * 
 * @author Shivam Tiwari
 */
public class LoginPage{
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;
	
	@FindBy(xpath="/html/body/app-root/app-login/div/div/div/div/div[1]/input")
	WebElement username;
	
	@FindBy(xpath="/html/body/app-root/app-login/div/div/div/div/div[2]/input")
	WebElement password;
	
	@FindBy(xpath="/html/body/app-root/app-login/div/div/div/a[1]")
	WebElement loginButton;
	
	@FindBy(xpath="//div[text()=' Welcome to the Customer Dashboard ']")
	WebElement successMsgObject;
	
	@FindBy(xpath="/html/body/app-root/app-role-customer/app-header/nav/div/ul/li/a")
	WebElement logoutDropdown;
	
	@FindBy(xpath="/html/body/app-root/app-role-customer/app-header/nav/div/ul/li/div/a[2]")
	WebElement logout;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(username,ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport("Login Page Object Created");
	}
	
	public void enterUsername(String UserName){
		log.info("entering email address...."+UserName);
		logExtentReport("entering email address...."+UserName);
		this.username.sendKeys(UserName);
	}
	
	public void enterPassword(String password){
		log.info("entering password...."+password);
		logExtentReport("entering password...."+password);
		this.password.sendKeys(password);
	}
	
	public CustomerHome_Page clickOnSubmitButton(){
		log.info("clicking on submit button...");
		logExtentReport("clicking on submit button...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		//new JavaScriptHelper(driver).scrollDownVertically();
		loginButton.click();
		return new CustomerHome_Page(driver);
	}
	
	public boolean verifySuccessLoginMsg(){
		return new VerificationHelper(driver).isDisplayed(successMsgObject);
	}
	
	public void loginToApplication(String UserName, String password){
		enterUsername(UserName);
		enterPassword(password);
		clickOnSubmitButton();
	}
	
	public void logout(){
		logoutDropdown.click();
		log.info("clicked on logout dropdown");
		logout.click();
		log.info("clicked on logout link");
		waitHelper.waitForElement(username, ObjectReader.reader.getExplicitWait());
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}

}
