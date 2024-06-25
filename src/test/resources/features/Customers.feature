Feature: Customers

  Scenario: Add new Customer
    Given user launch chrome browser
    When the user opens URL "https://admin-demo.nopcommerce.com/login"
    And the user enters email as "admin@yourstore.com" and password as "admin"
    And clicks on the login button
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers menu item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on save button
    Then User can view confirmation message "The new customer has been added sucessfully."
    And close browser