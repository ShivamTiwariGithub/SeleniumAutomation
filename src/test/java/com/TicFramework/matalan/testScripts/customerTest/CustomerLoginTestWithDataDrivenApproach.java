package com.TicFramework.matalan.testScripts.customerTest;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TicFramework.matalan.helper.assertion.AssertionHelper;
import com.TicFramework.matalan.helper.configuration.ObjectReader;
import com.TicFramework.matalan.pageObjects.LoginPage;
import com.TicFramework.matalan.pageObjects.customer.NewOrder_Page;
import com.TicFramework.matalan.testbase.TestBase;
/**
 * 
 * @author Shivam Tiwari
 */
public class CustomerLoginTestWithDataDrivenApproach extends TestBase{
	
	LoginPage login;
	NewOrder_Page retailer;
	
	@DataProvider(name="testData")
	public Object[][] testData(){
		Object[][] data = getExcelData("testData.xlsx", "loginData");
		return data;
	}
	@BeforeClass
	public void beforeClass(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		login = new LoginPage(driver);
	}
	@Test(dataProvider="testData")
	public void loginTest(String userName, String password, String runMode){
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");
		}
		login.loginToApplication(userName, password);
		boolean status = login.verifySuccessLoginMsg();
		AssertionHelper.updateTestStatus(status);
		login.logout();
	}
}
