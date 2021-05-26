package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	@FindBy(className = "login_logo")
	private WebElement loginLogo; 
	
	@FindBy(name = "login-button")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//button[@class = 'error-button']")
	private WebElement errorBtn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isLoginVisible() {
		waitForElementToAppear(loginLogo);
		return loginLogo.isDisplayed();
	}
	
	public void clickOnLoginBtn() {
		clickOnElement(loginBtn);
	}
	
	public boolean errorBtnIsVisible() {
		waitForElementToAppear(errorBtn);
		return errorBtn.isDisplayed();
	}
}
