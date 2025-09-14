Feature: Product Listing & Sorting

  Background:
    Given I am on the SauceDemo login page
    When I login with username "stand_user" and password "secret_sauce"

  @TC_05
  Scenario: Verify all products load after login
    Then I should see a list of products
    And Each product should have a name, description, and price

  @TC_06
  Scenario: Sort products by Name
    When I sort product by "Name (A to Z)"
    Then I should see list of product sorted by "Name (A to Z)"
    When I sort product by "Name (Z to A)"
    Then I should see list of product sorted by "Name (Z to A)"

  @TC_07
  Scenario: Sort products by Price
    When I sort product by "Price (low to high)"
    Then I should see list of product sorted by "Price (low to high)"
    When I sort product by "Name (Z to A)"
    Then I should see list of product sorted by "Name (Z to A)"

  @TC_08
  Scenario: Verify product details page opens when clicking a product
    When I click open product "Sauce Labs Backpack"
    Then I should see only detail of product "Sauce Labs Backpack"
