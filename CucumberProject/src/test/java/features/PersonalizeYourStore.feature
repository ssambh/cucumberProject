Feature: Personalize your store

Background: Open URL and login
	 Given User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
   When User inputs the email as "admin@yourstore.com" and password as "admin"
   And User clicks on the login button
   And The page title should be "Dashboard / nopCommerce administration"
   Then User clicks on the Personalize your store menu item with page title "General settings / nopCommerce administration"
   
Scenario: Validate multi-store configuration dropdown
   When User click Multi-Store Config dropdown, it should have "All stores", "Your store name", "Test store 2" as options
   