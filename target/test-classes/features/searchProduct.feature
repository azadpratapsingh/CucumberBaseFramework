Feature: Search and place for order of product

#Scenario: Search experience for product search in both and offers page
#
#Given User is on Greenkart landing page
#When User searched with shortname "Tom" and extracted actual name of product
#Then User searched for "Tom" shortname in offers page
#And Validate product name in offers page matches with Landing page

Scenario Outline: Search experience for product search in both and offers page

Given User is on Greenkart landing page
When User searched with shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname in offers page
And Validate product name in offers page matches with Landing page

Examples:
 |Name|
 |Tom|
 |Beet|

