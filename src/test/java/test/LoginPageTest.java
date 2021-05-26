package test;

import java.util.concurrent.TimeUnit;

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
	
	
	private static final String WEBURL = "https://www.saucedemo.com/";
	private static final int LONGTIME = 10;
	
	@Override
	@BeforeMethod
	public void setupPages() {
		loginPage = new LoginPage(driver);	
	}
	
	@Override
	@BeforeTest
	public void startDriver() {
		browserType(DriverType.CHROME);
		driver.get(WEBURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(LONGTIME, TimeUnit.SECONDS);
		
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
