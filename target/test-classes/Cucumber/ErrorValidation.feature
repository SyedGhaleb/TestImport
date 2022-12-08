
@tag
Feature: Check error message when incorrect email or password
  I want to use this template for my feature file

  

  @ErrorValidation
  Scenario Outline: Error validation in Login page
    Given  I land on Ecommerce Page
    Given   Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name                   | password      | productName  |
      | Selenium1234@gmail.com | Selenium@12345 | ZARA COAT 3  |
 
