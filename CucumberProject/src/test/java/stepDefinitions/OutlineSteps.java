package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import baseTest.BaseMain;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import pageObjects.PersonalizeYourStorePage;

public class OutlineSteps extends BaseMain{

	public static WebDriver driver;
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	static LoginPage loginPage;
	static Dashboard dashboard;
	static PersonalizeYourStorePage personalizeStore;
	
	@Before
	public static void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		dashboard = new Dashboard(driver);
		loginPage = new LoginPage(driver);
		personalizeStore = new PersonalizeYourStorePage(driver);
	}
	
	@Given("User opens URL {string}")
	public void openLink(String url) {
	    driver.get(url);
	    
	}
	@When("User inputs the email as {string} and password as {string}")
	public void inputLoginCredentials(String email, String password) {
	    loginPage.emailField.clear();
	    loginPage.emailField.sendKeys(email);
	    loginPage.passwordField.clear();
	    loginPage.passwordField.sendKeys(password);
	}
	@And("User clicks on the login button")
	public void clickLoginBtn() {
		loginPage.loginButton.click();
	}
	@And("The page title should be {string}")
	public void validatePageTitle(String title) {
		Assert.assertEquals(title, driver.getTitle());
	}
	
	@And("Click on Catalog button and choose Products")
	public void clickCatalogAndChooseProducts() {
		dashboard = new Dashboard(driver);
		dashboard.catalogDropDown.click();
		dashboard.catalogProductsDropDown.click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.productsPageHeading));
	}
	
	@Then("User clicks on the Personalize your store menu item with page title {string}")
	public void user_clicks_on_the_personalize_your_store_menu_item_with_page_title(String string) {
		dashboard.startAcceptingYourOrdersCardPlusBtn.click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.
		personaliseYourStoreMenuItem));
		dashboard.personaliseYourStoreMenuItem.click();
		Assert.assertEquals(string, driver.getTitle());
		try {
			if(personalizeStore.configTourPopupNextBtn.isDisplayed()) {
				personalizeStore.configTourPopupNextBtn.click();
			}
		}catch(NoSuchElementException e) {
			System.out.println("Didn't find the dialogue box this time");
		}
	}
	
	@When("User click Multi-Store Config dropdown, it should have {string}, {string}, {string} as options")
	public void user_click_multi_store_config_dropdown_it_should_have_as_options(String string, String string2, String string3) {
	    Select multiStoreConfig = new Select(personalizeStore.storeConfigDropDown);
	    List<WebElement> list = multiStoreConfig.getOptions();
	    for(int i = 0; i < list.size(); i++) {
	    	if(i==0) {
	    		Assert.assertEquals(list.get(i).getText(), string);
	    	}
	    	if(i==1) {
	    		Assert.assertEquals(list.get(i).getText(), string2);
	    	}
	    	if(i==2) {
	    		Assert.assertEquals(list.get(i).getText(), string3);
	    	}
	    }
	}
	
	@After
	public static void tearDown() {
	    driver.quit();
	}
}
