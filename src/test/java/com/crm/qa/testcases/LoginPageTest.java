package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage; // creating the object of 'LoginPage' class
	HomePage homepage;

	public LoginPageTest() { // we r creating the constructor of 'loginpageTest' class.
		super();// this 'super' keyword will call 'TestBase' class 'Constructor'.
	}

	@BeforeMethod
	public void setup() {
		initialization(); // it will call the initializations method of 'TestBase' class.
		loginPage = new LoginPage();
	}

	@Test(priority=1)
	public void loginpageTitleTest() {
		String title = loginPage.validateloginpageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");

	}

	@Test(priority=2)
	public void crmlogoimageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);

	}

	@Test(priority=3)
	public void loginTest() {
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
