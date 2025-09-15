Feature: Product Listing & Sorting

  Background:
    Given I am on the SauceDemo login page
    When I login successful with username "standard_user"

  @TC_05
  Scenario: Verify all products load after login
    Then I should see a list of products
    And Each product should have a name, description, and price

  @TC_06
  Scenario: Sort products by Name
    When I sort product by "Name (A to Z)"
    Then I should see list of product sorted by name "Name (A to Z)"
    When I sort product by "Name (Z to A)"
    Then I should see list of product sorted by name "Name (Z to A)"

  @TC_07
  Scenario: Sort products by Price
    When I sort product by "Price (low to high)"
    Then I should see list of product sorted by price "Price (low to high)"
    When I sort product by "Price (high to low)"
    Then I should see list of product sorted by price "Price (high to low)"

  @TC_08
  Scenario: Verify product details page opens when clicking a product
    When I click view detail product "Sauce Labs Backpack"
    Then I should see only detail of product "Sauce Labs Backpack"