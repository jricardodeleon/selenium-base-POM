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
	public void getErrorWhenInfoIsEmpty() {
		Assert.assertTrue(loginPage.isLoginVisible());
		loginPage.clickOnLoginBtn();
		Assert.assertTrue(loginPage.errorBtnIsVisible());
	}

	@AfterTest
	@Override
	public void tearDown() {
		quitDriver();
	}


}
