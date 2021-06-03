package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.BaseTest;
import core.DriverType;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
	
	LoginPage loginPage;
	
	@Override
	@BeforeMethod
	public void setupPages() {
		loginPage = new LoginPage(driver);	
	}
	
	@Override
	@BeforeTest
	public void startDriver() {
		getHome(DriverType.CHROME);
	}
	
	@Test
	public void CheckErrorUserNameIsRequired() {
		Assert.assertTrue(loginPage.isLoginVisible());
		loginPage.clickOnLoginBtn();
		Assert.assertTrue(loginPage.errorMsgIsVisible());
		Assert.assertEquals(loginPage.getTextErrorMsg(), "Epic sadface: Username is required");
	}

	@AfterTest
	@Override
	public void tearDown() {
		quitDriver();
	}


}
