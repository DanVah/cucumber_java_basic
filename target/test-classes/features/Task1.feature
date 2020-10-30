Feature: Verifying input


  Scenario Outline: Checking different incorrect entries in the field

    Given Go to url "https://kristinek.github.io/site/tasks/enter_a_number"
    And I enter number "<number>" in the field
    And Press submit
    Then Check the text "<message>" is displayed

    Examples:
      | number | message               |
      | 48     | Number is too small   |
      | 102    | Number is too big     |
      | hi     | Please enter a number |

  Scenario: Entering a correct number

    Given Go to url "https://kristinek.github.io/site/tasks/enter_a_number"
    And I enter number "64" in the field
    And Press submit
    Then Check that popup displays "Square root of 64 is 8.00"

