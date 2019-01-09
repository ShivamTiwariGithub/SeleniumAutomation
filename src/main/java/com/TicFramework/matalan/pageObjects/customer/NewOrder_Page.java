package com.TicFramework.matalan.pageObjects.customer;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.TicFramework.matalan.helper.assertion.VerificationHelper;
import com.TicFramework.matalan.helper.configuration.ObjectReader;
import com.TicFramework.matalan.helper.select.DropDownHelper;
import com.TicFramework.matalan.helper.javascript.JavaScriptHelper;
import com.TicFramework.matalan.helper.logger.LoggerHelper;
import com.TicFramework.matalan.helper.wait.WaitHelper;
import com.TicFramework.matalan.testbase.TestBase;

public class NewOrder_Page {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(NewOrder_Page.class);
	WaitHelper waitHelper;

	@FindBy(xpath="//div[contains(text(),'New orders')]")
	public WebElement NewOrderPageMsg;

	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-create-order/div/div/div/div/div[2]/table[1]/tbody/tr[1]/td[2]/select")
	public WebElement retailer;

	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-create-order/div/div/div/div/div[2]/table[1]/tbody/tr[2]/td[2]/input")
	public WebElement matalanContractNumber;

	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-create-order/div/div/div/div/div[2]/table[1]/tbody/tr[3]/td[2]/input")
	public WebElement supplierRefNumber;

	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-create-order/div/div/div/div/div[2]/table[1]/tbody/tr[4]/td[2]/select")
	public WebElement productionCountry;

	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-create-order/div/div/div/div/div[2]/table[1]/tbody/tr[5]/td[2]/select")
	public WebElement shippingMode;

	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-create-order/div/div/div/div/div[2]/table[1]/tbody/tr[6]/td[2]/select")
	public WebElement deliveryAddress;

	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-create-order/div/div/div/div/div[2]/table[3]/tbody/tr/td[2]/a")
	public WebElement nextButton;


	public NewOrder_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(retailer, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("NavigationMenu object created");
		new TestBase().getNavigationScreen(driver);
	}

	public boolean verifyNewOrderPageMsg(){
		return new VerificationHelper(driver).isDisplayed(NewOrderPageMsg);
	}

	public void retailer(String retailerName){
		try {
			DropDownHelper dd = new DropDownHelper(driver);
			dd.selectUsingVisibleText(retailer, retailerName);
			log.info(retailerName+" retailer is selected..");
			logExtentReport(retailerName+" retailer is selected..");
		} catch (Exception e) {
			log.info(retailerName+" retailer not found in the list");
			logExtentReport(retailerName+" retailer not found in the list");
			throw(e);
		}
	}

	public void enterContractNumber(String ContractNumber){
		log.info("entering contract number...."+ContractNumber);
		logExtentReport("entering contract number...."+ContractNumber);
		this.matalanContractNumber.sendKeys(ContractNumber);
	}

	public void supplierReferenceNumber(String SupRefNumber){
		log.info("entering supplier reference number...."+SupRefNumber);
		logExtentReport("entering supplier reference number...."+SupRefNumber);
		this.supplierRefNumber.sendKeys(SupRefNumber);
	}

	public void ProdCountryDropdown(String CountryName){
		DropDownHelper dd = new DropDownHelper(driver);
		dd.selectUsingVisibleText(productionCountry, CountryName);
		log.info(CountryName+" production country is selected..");
		logExtentReport(CountryName+" production country is selected..");
	}

	public void ShippingModeDropdown(String ShippingMode){
		DropDownHelper dd = new DropDownHelper(driver);
		dd.selectUsingVisibleText(shippingMode, ShippingMode);
		log.info(ShippingMode+" is selected..");
		logExtentReport(ShippingMode+" is selected..");
	}

	public void DeliveryAddressDropdown(String DeliveryAddress){
		DropDownHelper dd = new DropDownHelper(driver);
		dd.selectUsingVisibleText(deliveryAddress, DeliveryAddress);
		log.info(DeliveryAddress+" is selected..");
		logExtentReport(DeliveryAddress+" is selected..");
	}

	public NewOrderProductSearch_Page clickOnNextButton(){
		log.info("clicking on next button...");
		logExtentReport("clicking on next button...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		//new JavaScriptHelper(driver).scrollDownVertically();
		nextButton.click();
		return new NewOrderProductSearch_Page(driver);
	}


	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}


}
