Feature: Purchase flow on Saucedemo

  Scenario: Complete a successful purchase
    Given the user logs in with valid credentials
    When the user adds two products to the cart
    And completes the checkout process
    Then the confirmation message should be "Thank you for your order!"
