@search
Feature: As a user I want to logged in to the amazon E-commerce web site and then I need to do a online shop
  Scenario: Sign into Amazon.co.uk
  Given Amazon.co.uk is open
  When I click Sign-in
  And enter valid user name password
  Then I am logged in

  Scenario: Search for product and verify the first result is related to your product
  Given Amazon.co.uk is open and I am logged in
  When I search for "Apple iphone 6"
  Then the first result has the word  "Apple iphone 6" in it

  Scenario: verify that the original price of the product matches the price seen in the basket
  Given Amazon.co.uk is open and I am logged in
  And I add my favourite item to my basket
  When I check my basket total
  Then it should match the price of "£347.77"

 
 
 