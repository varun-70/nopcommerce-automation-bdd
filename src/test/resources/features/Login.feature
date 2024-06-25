Feature: User Login

  Scenario: Successful Login with valid credentials
    Given user launch chrome browser
    When the user opens URL "https://admin-demo.nopcommerce.com/login"
    And the user enters email as "admin@yourstore.com" and password as "admin"
    And clicks on the login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on log out link
    Then Page title should be "Your store. Login"
    And close browser

  Scenario Outline: Login Data Driven
    Given user launch chrome browser
    When the user opens URL "https://admin-demo.nopcommerce.com/login"
    And the user enters email as "<email>" and password as "<password>"
    And clicks on the login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on log out link
    Then Page title should be "Your store. Login"
    And close browser

    Examples:
      | email | password |
      | admin@yourstore.com | admin |
      | admin@yourstore.com | admin123 |