Feature: Smoke test for Condor application

    Scenario Outline: verify search flight functionality
      Given Enter the <Origin> and <Destination>
      When Click search flight button
      Then Assert flight are listed with the seach inputs


      Examples:
        | Origin  |    Destination |
        | Berlin  |    Frankfurt   |