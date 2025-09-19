Feature: Checkout Process

  Background:
    Given I am on the SauceDemo login page
    When I login successful with username "standard_user"

  @TC_15
  Scenario: Checkout with valid data
    When I add product "Sauce Labs Backpack" to cart
    And I open my cart
    And I click button "Checkout"
    And I enter first name "Trinh"
    And I enter last name "Anh"
    And I enter zip code "100000"
    And I click button "Continue"
    Then I should see "Checkout: Overview" page

  @TC_16
  Scenario: Checkout with missing first name field
    When I add product "Sauce Labs Backpack" to cart
    And I open my cart
    And I click button "Checkout"
    And I enter last name "Anh"
    And I enter zip code "100000"
    And I click button "Continue"
    Then I should see an error message "Error: First Name is required"

  @TC_17
  Scenario: Checkout with missing last name field
    When I add product "Sauce Labs Backpack" to cart
    And I open my cart
    And I click button "Checkout"
    And I enter first name "Trinh"
    And I enter zip code "100000"
    And I click button "Continue"
    Then I should see an error message "Error: Last Name is required"

  @TC_18
  Scenario: Checkout with missing zip code field
    When I add product "Sauce Labs Backpack" to cart
    And I open my cart
    And I click button "Checkout"
    And I enter first name "Trinh"
    And I enter last name "Anh"
    And I click button "Continue"
    Then I should see an error message "Error: Postal Code is required"


  @TC_19
  Scenario: Finish checkout
    When I add product "Sauce Labs Backpack" to cart
    And I open my cart
    And I click button "Checkout"
    And I enter first name "Trinh"
    And I enter last name "Anh"
    And I enter zip code "100000"
    And I click button "Continue"
    And I click button "Finish"
    And I should see a message "Thank you for your order!"