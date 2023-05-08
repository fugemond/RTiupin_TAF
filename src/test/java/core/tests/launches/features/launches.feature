Feature: TAF-03

  Scenario Outline: Check that Launches has correct names
    Given Open page "Login page", by the link "baseUrl"
    And Page "Login page" is opened
    And Into the field "Login field", enter encrypted value "rpLogin"
    And Into the field "Password field", enter encrypted value "rpPassword"
    And Click on element "Sign in button"
    And Page "Common panel block" is opened
    And Page is loaded
    And Click on element "Launches tab"
    When Page "Launches page" is opened
    Then Assert that element "Launch name" by part "<launchNumber>" contains value "<launchName>"

    Examples:
      | launchNumber | launchName       |
      | 1            | Demo Api Tests#5 |
      | 2            | Demo Api Tests#4 |
      | 3            | Demo Api Tests#3 |
      | 4            | Demo Api Tests#2 |
      | 5            | Demo Api Tests#1 |
