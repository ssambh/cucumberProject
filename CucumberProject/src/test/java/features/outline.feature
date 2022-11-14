Feature: Nop Commerce 

@sanity
Scenario: Validate successful login
   When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
   And User input the email as "admin@yourstore.com" and password as "admin"
   And User clicks on the login button
   Then The page title should be "Dashboard / nopCommerce administration"
@regression
Scenario Outline: Validate Products Page
   When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
   And User input the email as "<email>" and password as "<password>"
   And User clicks on the login button
   Then The page title should be "Dashboard / nopCommerce administration"
   And Click on Catalog button and choose Products

   Examples:
   | email | password|
   | admin@yourstore.com | admin|