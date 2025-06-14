Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenKart Landing page
When User searched with Shortname <Name> and extracted actual name of the product
Then User searched for <Name> Shortname in offers page
And Validate product name in offer page maches with landing page product name

Examples:
|  Name  |
|  Tom   |
|  Beet  |


