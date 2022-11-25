package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//*[normalize-space(text())='Catalog']")
	public WebElement catalogDropDown;
	
	@FindBy(xpath="//*[normalize-space(text())='Products']/..")
	public WebElement catalogProductsDropDown;
	
	@FindBy(xpath="//h1[normalize-space(text())='Products']")
	public WebElement productsPageHeading;
	
	// Welcome to your store
	@FindBy(xpath="//h5[contains(text(),'Personalize your store')]")
	public WebElement personaliseYourStoreMenuItem;
	
	@FindBy(xpath="//*[@class='card-header with-border']//button/i")
	public WebElement startAcceptingYourOrdersCardPlusBtn;
}
