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

public class QuestionAnswer_Page {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(QuestionAnswer_Page.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//a[text()='Cancel']")
	WebElement CancelButton;
	
	@FindBy(xpath="//td[text()='13 Digit Barcode  ']/parent::tr/following-sibling::tr/td[1]/span/span/input")
	WebElement BarcodeButtonText;
	
	@FindBy(xpath="//span[text()='Select Answer']")
	WebElement dropdownmenu;
	
	@FindBy(xpath="//div[@class='dropdown-list']//ul[@class='item2']/li[3]/div")
	WebElement selectanswer;
	
	@FindBy(xpath="//td[text()='Product size for inner label  ']/parent::tr/following-sibling::tr/td[3]/span/input")
	WebElement innerlabel;
	
	@FindBy(xpath="//td[text()='What is the eight character code?  ']/parent::tr/following-sibling::tr/td[4]/span/input")
	WebElement EightCharacterCode;
	
	@FindBy(xpath="//table[@class='table table-borderless  bgW']/tbody/tr/td[1]/a")
	WebElement ConfirmButton;
	
	public QuestionAnswer_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(CancelButton, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("NavigationMenu object created");
		new TestBase().getNavigationScreen(driver);
	}
	
	public void enterBarcode(String Barcode){
		log.info("entering barcode...."+Barcode);
		logExtentReport("entering barcode...."+Barcode);
		this.BarcodeButtonText.sendKeys(Barcode);
	}
	
	public void clickOndrpdown(){
		log.info("clicking on dropdown...");
		logExtentReport("clicking on dropdown...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		waitHelper = new WaitHelper(driver);
		waitHelper.WaitForElementClickable(dropdownmenu, 10);
		dropdownmenu.click();
	}
	
	public void clickOnAnswer(){
		log.info("clicking on answer...");
		logExtentReport("clicking on answer...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		waitHelper = new WaitHelper(driver);
		waitHelper.WaitForElementClickable(selectanswer, 10);
		selectanswer.click();
	}
	
	public void enterInnerLabel(String InnerLabel){
		log.info("entering inner label...."+InnerLabel);
		logExtentReport("entering inner label...."+InnerLabel);
		innerlabel.click();
		this.innerlabel.sendKeys(InnerLabel);
	}
	
	public void enterCharacterCode(String code){
		log.info("entering 8 character code...."+code);
		logExtentReport("entering 8 character code...."+code);
		this.EightCharacterCode.sendKeys(code);
	}
	
	public OrderConfirmation_Page clickOnConfirmButton(){
		log.info("clicking on confirm button...");
		logExtentReport("clicking on confirm button...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		waitHelper = new WaitHelper(driver);
		waitHelper.WaitForElementClickable(ConfirmButton, 10);
		ConfirmButton.click();
		return new OrderConfirmation_Page(driver);
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
}
