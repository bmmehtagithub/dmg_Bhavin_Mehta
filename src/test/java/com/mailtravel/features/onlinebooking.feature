Feature: Online travel and accomodation booking feature
  @Regression
  Scenario: End to end holiday package testing
    Given User is on mailtravel home page
    When User input "india" in searchfield and press enter
    And User click on more info on first search result
    Then user can see the price "£990", days "10", telephone number "0808 239 7870"
    When User click on book online
    Then User should get the first available date with value
    When User click on continue
    And User select standard room
    And User click on continue without extras
    And User enter following passenger detail
    Then User can see the amount as per accommodation