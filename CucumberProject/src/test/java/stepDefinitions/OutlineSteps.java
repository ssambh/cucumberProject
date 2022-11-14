package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import junit.framework.Assert;
import pageObjects.Dashboard;
import pageObjects.LoginPage;

public class OutlineSteps extends BaseMain{

	public static WebDriver driver;
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	LoginPage loginPage;
	Dashboard dashboard;
	
	@Before
	public static void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/*
	 * @Given("User Launch chrome browser") public void openBrowser() {
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.manage().window().maximize(); }
	 */

	@When("User opens URL {string}")
	public void openLink(String url) {
	    driver.get(url);
	    
	}
	@And("User input the email as {string} and password as {string}")
	public void inputLoginCredentials(String email, String password) {
	   loginPage = new LoginPage(driver);
	    loginPage.emailField.clear();
	    loginPage.emailField.sendKeys(email);
	    loginPage.passwordField.clear();
	    loginPage.passwordField.sendKeys(password);
	}
	@And("User clicks on the login button")
	public void clickLoginBtn() {
		loginPage = new LoginPage(driver);
		loginPage.loginButton.click();
	}
	@Then("The page title should be {string}")
	public void validatePageTitle(String title) {
		loginPage = new LoginPage(driver);
		Assert.assertEquals(title, driver.getTitle());
	}
	
	@And("Click on Catalog button and choose Products")
	public void clickCatalogAndChooseProducts() {
		dashboard = new Dashboard(driver);
		dashboard.catalogDropDown.click();
		dashboard.catalogProductsDropDown.click();
		wait.until(ExpectedConditions.visibilityOf(dashboard.productsPageHeading));
	}
	
	@After
	public static void tearDown() {
	    driver.quit();
	}
	
	/*
	 * @And("close the browser") public void closeBrowser() { driver.quit(); }
	 */
	
	
	/*
	 * WebDriver driver = null;
	 * 
	 * @Given("^I am on Facebook login page$") public void goToFacebook() {
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.navigate().to("https://www.facebook.com/"); }
	 * 
	 * @When("^I enter username as \"(.*)\"$") public void enterUsername(String
	 * arg1) { driver.findElement(By.id("email")).sendKeys(arg1); }
	 * 
	 * @When ("^I enter password as \"(.*)\"$") public void enterPassword(String
	 * arg1) { driver.findElement(By.id("pass")).sendKeys(arg1);
	 * driver.findElement(By.id("u_0_v")).click(); }
	 * 
	 * @Then("^Login should fail$") public void checkFail() {
	 * if(driver.getCurrentUrl().equalsIgnoreCase(
	 * "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
	 * System.out.println("Test1 Pass"); } else {
	 * System.out.println("Test1 Failed"); } driver.close(); }
	 * 
	 * @Then("^Relogin option should be available$") public void checkRelogin() {
	 * if(driver.getCurrentUrl().equalsIgnoreCase(
	 * "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
	 * System.out.println("Test2 Pass"); } else {
	 * System.out.println("Test2 Failed"); } driver.close(); }
	 */
}
