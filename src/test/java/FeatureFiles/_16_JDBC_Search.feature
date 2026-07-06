Feature: Testing JDBC Search functionality

  Background:
    Given Navigate to WebSite
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Search Functionality
    And User sending info in Dialog
      | searchBox | mac |

    And Click on Element Dialog
      | srcBtn |

    Then Send The query to The database "select name from sakila.urunler where name like '%mac%' order by name" and control match