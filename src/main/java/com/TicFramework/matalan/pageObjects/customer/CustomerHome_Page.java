package com.TicFramework.matalan.pageObjects.customer;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TicFramework.matalan.helper.configuration.ObjectReader;
import com.TicFramework.matalan.helper.logger.LoggerHelper;
import com.TicFramework.matalan.helper.wait.WaitHelper;
import com.TicFramework.matalan.testbase.TestBase;
/**
 * 
 * @author Shivam Tiwari
 */
public class CustomerHome_Page {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(CustomerHome_Page.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-customer-home/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/a[1]/span[2]")
	public WebElement newOrder;
	
	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-customer-home/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[2]/a/span[2]")
	public WebElement orderHistory;
	
	
	@FindBy(xpath="/html/body/app-root/app-role-customer/section/app-customer-home/div/div/div/div/div[2]/div/div/div[2]/div/div/div/div[1]/a[2]/span[2]")
	public WebElement provisionalUpload;

	public CustomerHome_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(newOrder, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("NavigationMenu object created");
		new TestBase().getNavigationScreen(driver);
	}
	
	public NewOrder_Page clickOnNewOrderButton(String data){
		log.info("clickin on :"+data);
		TestBase.logExtentReport("clickin on :"+data);
		driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]")).click();
		return new NewOrder_Page(driver);
	}
}
