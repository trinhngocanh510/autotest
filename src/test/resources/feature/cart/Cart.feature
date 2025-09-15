Feature: Cart Functionality

  Background:
    Given I am on the SauceDemo login page
    When I login successful with username "standard_user"

  @TC_10
  Scenario: Add 1 product to cart
    When I add product "Sauce Labs Backpack" to cart
    And I open my cart
    Then I should see product "Sauce Labs Backpack" in my cart

  @TC_11
  Scenario: Add multiple products
    When I add product "Sauce Labs Backpack" to cart
    And I add product "Sauce Labs Bike Light" to cart
    And I open my cart
    Then I should see product "Sauce Labs Backpack" in my cart
    And I should see product "Sauce Labs Bike Light" in my cart

  @TC_12
  Scenario: Remove item from cart page
    When I add product "Sauce Labs Backpack" to cart
    And I open my cart
    And I remove product "Sauce Labs Backpack" from cart
    Then I should not see product "Sauce Labs Backpack" in my cart

  @TC_13
  Scenario: Continue shopping from cart
    When I open my cart
    And I click button "Continue Shopping"
    Then I should be redirected to the inventory page

  @TC_14
  Scenario: Verify cart persists after navigation
    When I add product "Sauce Labs Backpack" to cart
    And I open my cart
    And I click button "Continue Shopping"
    Then I should be redirected to the inventory page
    When I open my cart
    Then I should see product "Sauce Labs Backpack" in my cart