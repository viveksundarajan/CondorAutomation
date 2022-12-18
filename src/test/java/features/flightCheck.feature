Feature: Smoke test for Condor application

  Scenario Outline: verify search flight functionality
    Given Enter the <Origin> and <Destination>
    When Click search flight button
    Then Assert flight are listed with the search inputs <Origin> <Destination>

    Examples:
      | Origin     |   Destination |
      | Frankfurt  |   Athen       |

  Scenario: Verify reset to default function
    Given Fill all the details with "FRA" and "ATH"
    When Click reset filter
    Then Verify the search inputs are reseted




