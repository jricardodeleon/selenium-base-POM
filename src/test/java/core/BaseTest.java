package core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
	
	protected WebDriver driver;

	public BaseTest() {

	}


	public WebDriver browserType(DriverType type) {
		switch(type) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		return driver;	
	}
	
	public abstract void setupPages();
	public abstract void startDriver();
	public abstract void tearDown();
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	

}
