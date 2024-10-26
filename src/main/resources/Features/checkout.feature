Feature: Checkout Process on nopCommerce

  Scenario Outline: Complete checkout process using data-driven approach
    Given I open the nopCommerce website
    When I add product from data set <index> to the cart
    And I proceed to checkout
    And I enter shipping information for data set <index>
    And I enter billing information for data set <index>
    Then I should see the confirmation message for data set <index>

    Examples:
      | index |
      | 0     |
      | 1     |
