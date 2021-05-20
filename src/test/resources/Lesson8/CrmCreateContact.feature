Feature: create new contact

  Background:
    Given I am authorized

    Scenario:
      Given I am on contact page
      When I fill surname field
      And I fill first name field
      And I fill and select organisation
      And I fill position
      And I click save and close button
      Then I see message about success saving


