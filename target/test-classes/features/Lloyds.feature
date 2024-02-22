@Lloyds
Feature: Search Feature Test
  As a user
  I should search and retrieve the relevant products


Scenario Outline:  verify product search with names for
    Given I'm on Lloyds home page
    When I click findBranch
    And I fill search box from given sheetname "<SheetName>" and row number <RowNumber>
    And I click searchIcon
    And I select nearest branch
    Then I get phone number of branch

    Examples:
      |SheetName|RowNumber|
      |PostcodeList|0|
      |PostcodeList|1|
      |PostcodeList|2|
      |PostcodeList|3|
      |PostcodeList|4|
      |PostcodeList|5|
      |PostcodeList|6|
      |PostcodeList|7|
      |PostcodeList|8|
      |PostcodeList|9|