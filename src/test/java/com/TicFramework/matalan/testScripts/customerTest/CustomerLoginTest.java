package com.TicFramework.matalan.testScripts.customerTest;

import org.testng.annotations.Test;
import com.TicFramework.matalan.helper.assertion.AssertionHelper;
import com.TicFramework.matalan.helper.configuration.ObjectReader;
import com.TicFramework.matalan.pageObjects.LoginPage;
import com.TicFramework.matalan.testbase.TestBase;
import com.TicFramework.matalan.utils.Constant;
/**
 * 
 * @author Shivam Tiwari
 */
public class CustomerLoginTest extends TestBase{
	
	@Test(description="Login test with valid credentials")
	public void LoginToApplicationTest(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(Constant.CusUsername, Constant.CusPassword);
		
		boolean status = loginPage.verifySuccessLoginMsg();
		
		AssertionHelper.updateTestStatus(status);

	}
	


 
	
}
