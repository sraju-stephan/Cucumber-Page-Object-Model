Feature: Access seleniumframework.com website Use selenium java with cucumber-jvm and navigate to website
  @one
  Scenario: Print title, url
    Given I open seleniumframework website
    Then I validate title and URL
  @two
  Scenario: Read data from json
    Given I navigated to json resource file

  Scenario: work with data tables
    Given I have below data tables
    |username|password|
    | one       |onee        |
    | twoo       |twoo        |
    And I have below data tables for map
      | link_text           | credit_link                     |
      | MACY'S CREDIT CARD  | goto_credit_services            |
      | pay bill            | goto_credit_pay_bill_online     |
      | cardholder benefits | goto_credit_cardholder_benefits |
    Then I have below data list for map
      | firstName | lastName | email             | password |
      | Sukesh    | Kumar    | validemail@aq.com | passwordd |

  Scenario: Perform element actions on web page
    Given I open seleniumframework website
    Then I performing element action on UI page
    And I get credit cards from
    Then I verify xapi response
    Then I verify xapi post response,c
    Then I add reward to wallet










    

