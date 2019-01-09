package com.TicFramework.matalan.pageObjects.customer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

public class NewOrderSupplierSelection_Page {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(NewOrderSupplierSelection_Page.class);
	WaitHelper waitHelper;

	@FindBy(xpath="//input[@type='text']")
	WebElement SearchBoxOnSupplierSelection;

	public NewOrderSupplierSelection_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(SearchBoxOnSupplierSelection, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("NavigationMenu object created");
		new TestBase().getNavigationScreen(driver);
	}

	public String getproductcode() {
		log.info("Getting the product code to math...");
		logExtentReport("Getting the product code to math...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		String SearchBoxText = SearchBoxOnSupplierSelection.getAttribute("ng-reflect-model");
		log.info("Got Product Code " +SearchBoxText);
		return SearchBoxText;
	}

	public WebElement selectRandomProduct(){
		NewOrderSupplierSelection_Page page = new NewOrderSupplierSelection_Page(driver);
		String ptext = page.getproductcode();
		List <WebElement> ProWithSup = driver.findElements(By.xpath("//span[text()='"+ptext+"']"));
	    Random rand = new Random();
	    int randomProduct = rand.nextInt(ProWithSup.size());
	    WebElement RandProEle = ProWithSup.get(randomProduct);
	    return RandProEle;
	}
	
	
	public NewOrderProductInfoPage clickOnProductCode(){
		log.info("clicking on product code...");
		logExtentReport("clicking on product code...");
		JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollDownVertically();
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(SearchBoxOnSupplierSelection, ObjectReader.reader.getExplicitWait());
		NewOrderSupplierSelection_Page page = new NewOrderSupplierSelection_Page(driver);
		waitHelper.setImplicitWait(10, TimeUnit.SECONDS);
		page.selectRandomProduct().click();
		return new NewOrderProductInfoPage(driver);

	}

	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}

}
