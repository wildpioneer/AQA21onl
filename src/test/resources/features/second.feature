Feature: Параметризированные тесты

  Scenario: Параметризация степов
    Given открыт браузер
    * страница логина открыта
    When user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in
    Then title is "All Projects"
    And project id is 123563

  Scenario: Параметризация степов RegExp
    Given открыт браузер
    * страница логина открыта
    When admin atrostyanko@gmail.com with password "Qwertyu_1" logged in
    Then title is "All Projects"
    And project id is 123563
    And all elements "are not" visible


  Scenario Outline: Параметризация при помощи таблицы значений
    Given открыт браузер
    * страница логина открыта
    When admin <username> with password "<password>" logged in
    Then project id is <prId>

    Examples:
      | username               | password  | prId   |
      | atrostyanko@gmail.com  | Qwertyu_1 | 123563 |
      | atrostyanko1@gmail.com | Qwertyu_2 | 12     |

  Scenario: Параметризация шага
    Given открыт браузер
    * страница логина открыта
    When user logged in
      | username | atrostyanko@gmail.com |
      | password | Qwertyu_1             |
    Then title is "All Projects"
    And project id is 123563
