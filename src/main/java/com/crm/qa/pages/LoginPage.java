package com.crm.qa.pages;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase { // 'loginpage' class is the child class of TestBase class

	// WebElements/Features r always defined in login page class.
	// PageFactory WebElements/Object Repository (also called).

	@FindBy(name = "username")
	WebElement username; // we r defining var name(username)

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div//input[@value='Login']")
	WebElement LoginBtn;

	// @FindBy(linkText="Sign Up")
	// WebElement signuplnk;

	// @FindBy(xpath = "//li//a[contains(text(),'Features')]")
	// WebElement features;

	@FindBy(className = "img-responsive")
	WebElement crmlogo;

	// initializing the elements with the help of PageFactory:

	public LoginPage() { // creating the constructor of 'loginPage' class
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateloginpageTitle() {
		return driver.getTitle();

	}

	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();

		return new HomePage();

	}

}
