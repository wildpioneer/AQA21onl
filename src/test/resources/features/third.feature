Feature: Use background and Rules

  Rule: rule 1
    Background:
      Given открыт браузер
      * страница логина открыта

    Scenario: scenario 1
      When user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in
      Then title is "All Projects"
      And project id is 123563

    Scenario: scenario 2
      When user "atrostyanko@gmail.com" with password "Qwertyu_2" logged in
      Then error is displayed

  Rule: rule 2
    Background:
      Given открыт браузер
      * страница логина открыта
      * user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in

    Scenario: scenario 1
      Then title is "All Projects"
      And project id is 123563

    Scenario: scenario 2
      Then error is displayed