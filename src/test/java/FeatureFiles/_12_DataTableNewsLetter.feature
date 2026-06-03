# Senaryolar
# 1- Newsletter  Subscribe işlemini abone olunuz(YES)  , işlemin başarılı olduğunu kontrol ediniz.
# 2- Ayrı bir test ile Newsletter  Subscribe işlemini abonelikten çıkınız(NO)
# 3- Ayrı bir test ile Newsletter  Subscribe durumunu kontrol ediniz YES ise NO, NO ise YES yapınız.

Feature: DataTable Newsletter Functionality 3 Test Case (3 Senaryo)

  Background:#before senaryo
    Given Navigate to WebSite
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Subcribe to NewsLetter
    And Click on Element Navigate
      | Newsletter |
    When Click on Element Dialog
      | subYes |
      | cntBtn |
    Then Success message should be displayed

  Scenario: UnSubcribe to NewsLetter
    And Click on Element Navigate
      | Newsletter |
    When Click on Element Dialog
      | subNo |
      | cntBtn |
    Then Success message should be displayed

  Scenario: Different Subscribe to NewsLetter
    And Click on Element Navigate
      | Newsletter |
    When checked to unchecked option
    Then Success message should be displayed