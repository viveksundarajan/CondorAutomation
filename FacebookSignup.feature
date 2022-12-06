Feature: Facebook signup functionalities

  Background:
    Given launch the facebook application
    When Click create new account


    Given Enter the emailId in emailId field
    And Enter the other mandatory information
    When Click signup button
    Then User can successfully create the account with the provided emailAddress

    Given Enter the emailId in userName field
    When Click enter
    Then Verify the Retype emailId field is displaying

    When No details are filled
    Then Verify the Retype emailId field is not displaying

    Given Enter the emailId in username field
    When Enter the different emailId in retype email field
    Then Verify the error message "Your emails do not match. Please try again."

    Given Enter the emailId which already has an account
    And Enter the other mandatory information
    When Click signup button
    Then Verify the error message "Username or email already exists"

    Given Enter the DOB as today's date
    And  Enter the other mandatory information
    When Click signup button
    Then Verify the error message "It looks like you've entered the wrong info. Please make sure that you use your real date of birth."

    Given Enter the all valid details and keep one field blank
    When Click signup button
    And Verify the error message to enter the detail for the corresponding field

    When Clicking the info icon for DOB
    Then Verify the popup is opened with valid information

    When Clicking the info icon for Gender
    Then Verify the popup is opened with valid information for Gender

    When Click signup button
    Then Verify all fields are highlighted with error icon

    Given Enter the mobileNumber in emailId field
    And Enter the other mandatory information
    When Click signup button
    And User can successfully create the account with the provided mobileNumber

    Given Click the custom checkbox in Gender field
    Then  Verify the hidden pronoun fields are displaying

    Given Click the custom checkbox in Gender field
    And Select the pronoun
    And Enter the other mandatory information
    When Click signup button
    Then User can successfully create the account

    Given Enter the password less than 6 digits
    And Enter the other mandatory information
    When Click signup button
    Then Verify the error message "Password should contain atleast 6 characters"

    Given Enter the numbers and special characters in firstName and surName field
    And Enter the other mandatory information
    When Click signup button
    Then User can successfully create the account




