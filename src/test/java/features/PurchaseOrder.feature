Feature: Validate the product price in Add cart section

    Scenario Outline: verify product price details in Add cart section
      Given search for the <productName>
      When Add the first product in add cart twice
      And Assert that total price and quantity are correct
      And Reduce quantity to one in Cart section for the item selected
      Then Assert that total price has been correctly changed


      Examples:
        | productName  |
        | hats for men |