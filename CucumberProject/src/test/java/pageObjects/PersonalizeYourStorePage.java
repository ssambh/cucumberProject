package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalizeYourStorePage {
	WebDriver driver;
	
	public PersonalizeYourStorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//button//div[text()='Next']")
	public WebElement configTourPopupNextBtn;
	
	@FindBy(id="store-scope-configuration")
	public WebElement storeConfigDropDown;
	
}
