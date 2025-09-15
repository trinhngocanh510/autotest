Feature: Login
  As a SauceDemo user
  I want to login with different credentials
  So that I can access or be restricted from the inventory page

  Background:
    Given I am on the SauceDemo login page


  @TC_01 @smoke
  Scenario: Valid user can login successfully
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be redirected to the inventory page

  @TC_02
  Scenario: Invalid user cannot login
    When I login with username "standard_user" and password "secret_sauced"
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  @TC_03
  Scenario: Locked user cannot login
    When I login with username "locked_out_user" and password "secret_sauce"
    Then I should see an error message "Epic sadface: Sorry, this user has been locked out."

  @TC_04
  Scenario: Login with performance glitch user

  @TC_05
  Scenario: Login with empty user/password
    When I login with username "" and password ""
    Then I should see an error message "Epic sadface: Username is required"