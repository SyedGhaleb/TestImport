
@tag
Feature: Purchase the order from Ecomerce website
  I want to use this template for my feature file

Background:
Given  I land on Ecommerce Page


  @Regression
  Scenario Outline: Test to Submit Order
  	
    Given Logged in with username <name> and password <password>
    When I add product<productName> to chart 
    And Checkout<productName> and Submit order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confimation page

    Examples: 	
      | name                   | password      | productName  |
      | Selenium1234@gmail.com | Selenium@1234 | ZARA COAT 3  |
     
