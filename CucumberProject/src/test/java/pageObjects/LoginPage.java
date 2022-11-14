package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	public WebElement emailField;
	
	@FindBy(id="Password")
	public WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Log in']")
	public WebElement loginButton;
	
	@FindBy(xpath="//title[text()='Dashboard / nopCommerce administration']")
	public WebElement loginDashBoardTitle;
	
	
	
}
