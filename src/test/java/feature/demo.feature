
Feature: Login and compose email in Gmail
  As a Gmail user
  I want to be able to login to my account and compose and send an email
  So that I can communicate with others through Gmail

Scenario: Login and compose email with subject "incubyte" and body "Automation QA test for incubyte"
  Given I am on the Gmail login page
  When I enter my username "antonyshelton.97@gmail.com" and password "thunderbird03031997$"
  And I click on the sign in button
  Then I should be logged into my Gmail account
  When I click on the compose button
  And I enter "incubyte" as the subject of the email
  And I enter "Automation QA test for incubyte" as the body of the email
  And I click on the send button
  Then the email should be sent successfully
  And I should see a confirmation message that the email has been sent
     
