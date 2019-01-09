package com.TicFramework.matalan.testScripts.customerTest;

import org.testng.annotations.Test;
import com.TicFramework.matalan.helper.assertion.AssertionHelper;
import com.TicFramework.matalan.helper.configuration.ObjectReader;
import com.TicFramework.matalan.pageObjects.LoginPage;
import com.TicFramework.matalan.pageObjects.customer.CustomerHome_Page;
import com.TicFramework.matalan.pageObjects.customer.NewOrderProductInfoPage;
import com.TicFramework.matalan.pageObjects.customer.NewOrderProductSearch_Page;
import com.TicFramework.matalan.pageObjects.customer.NewOrderSupplierSelection_Page;
import com.TicFramework.matalan.pageObjects.customer.NewOrder_Page;
import com.TicFramework.matalan.pageObjects.customer.OrderConfirmation_Page;
import com.TicFramework.matalan.pageObjects.customer.QuestionAnswer_Page;
import com.TicFramework.matalan.testbase.TestBase;
import com.TicFramework.matalan.utils.Constant;
/**
 * 
 * @author Shivam Tiwari
 */
public class NewOrder_Test extends TestBase {

	LoginPage loginPage;
	CustomerHome_Page custhomepage;

	@Test(description="new order creation")
	public void NewOrderTest() throws InterruptedException{
		getApplicationUrl(ObjectReader.reader.getUrl());

		loginPage = new LoginPage(driver);

		loginPage.loginToApplication(Constant.CusUsername, Constant.CusPassword);

		boolean status = loginPage.verifySuccessLoginMsg();

		AssertionHelper.updateTestStatus(status);

		custhomepage = new CustomerHome_Page(driver);
		custhomepage.clickOnNewOrderButton("New Orders");

		NewOrder_Page NewOrderPage = new NewOrder_Page(driver);
		boolean status2 = NewOrderPage.verifyNewOrderPageMsg();
		AssertionHelper.updateTestStatus(status2);

		NewOrderPage.retailer(Constant.Retailer);
		NewOrderPage.enterContractNumber(Constant.ContractNumber);
		NewOrderPage.supplierReferenceNumber(Constant.SupplierReferenceNumber);
		NewOrderPage.ProdCountryDropdown(Constant.ProductionCountry);
		NewOrderPage.ShippingModeDropdown(Constant.ShippingMode);
		NewOrderPage.DeliveryAddressDropdown(Constant.DeliveryAddress);
		NewOrderPage.clickOnNextButton();
		NewOrderProductSearch_Page ProductSearchPage = new NewOrderProductSearch_Page(driver);
		ProductSearchPage.enterProductCode(Constant.ProductCode);
		ProductSearchPage.clickOnSearchButton();
		NewOrderSupplierSelection_Page supplierSelection = new NewOrderSupplierSelection_Page(driver);
		supplierSelection.clickOnProductCode();
		NewOrderProductInfoPage NewOrderPInfo = new NewOrderProductInfoPage(driver);
		Thread.sleep(5000);
		NewOrderPInfo.clickOnContinue();
		QuestionAnswer_Page QAPage = new QuestionAnswer_Page(driver);
		QAPage.enterBarcode("6231425167892");
		QAPage.clickOndrpdown();
		QAPage.clickOnAnswer();
		QAPage.enterInnerLabel("765775");
		QAPage.enterCharacterCode("A7342516");
		QAPage.clickOnConfirmButton();	
		OrderConfirmation_Page OCP = new OrderConfirmation_Page(driver);
		OCP.enterquantity("60");
		OCP.clickOnCheckBox();
		OCP.clickOnConfirmButton();
	}
}