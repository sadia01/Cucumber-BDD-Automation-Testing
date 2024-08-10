Feature: Search and Place the order for Products
@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page
    Given User is on GreenKart Landing page
    When User searched with Shortname <Name> and extract actual name of product
    Then User searched for <Name> Shortname in offers page
    And Validate ProductName in Offers Page matches with Landing Page
    
Examples:
| Name  |
| Tom 	|
| Beet  |