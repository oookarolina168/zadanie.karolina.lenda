@MyStore
Feature: the user verifies the added address

  @edit
  Scenario: User adds first address to the account
    Given I'm on the MyStore main page
    When I go to login page
    And I go to my addresses page
    When I add new address
    And I enter new address "testerka", "coders", "Warszawa", "90-234", "United kingdom", "2782992"
    And I verify created address "testerka", "coders", "Warszawa", "90-234", "polska", "2782992"
    And I can see new address



