@MyStore
Feature: Feature address change tests


  @create
  Scenario Outline: Adding a new user address
    Given User is logged in to CodersLab shop
    When User goes to AddressPage
    And The user clicks Create new address
    And User enters alias <alias> address <address> city <city> zip <zip> country <country> and phone <phone>
    Then User sees success message with text "Address successfully added!"
    And User closes MyStore browser
    Examples:
      | alias | address | city | zip    | country | phone   |
      | karo  | coders  | lab  | 09-121 | polska  | 2346542 |

