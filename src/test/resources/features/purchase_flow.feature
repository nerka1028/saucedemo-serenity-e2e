Feature: Purchase flow on Saucedemo

  Scenario Outline: Complete a successful purchase with multiple credentials and product count
    Given the user logs in with username "<username>" and password "<password>"
    When the user adds <productCount> products to the cart
    And completes the checkout process
    Then the confirmation message should be "<confirmationMessage>"

    Examples:
      | username       | password      | productCount | confirmationMessage       |
      | standard_user  | secret_sauce  | 2            | Thank you for your order! |
