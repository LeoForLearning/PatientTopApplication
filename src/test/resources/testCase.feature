@patienttop @BAT
Feature: Validate Patient Top application and comparing score

  
  Scenario Outline: Validate score for a patient
    Given I launch browser "chrome"
    And   I navigate to patienttop checkup application
    When  I Enter "<Patient>" in the practise name text box
    Then  I validate "<Patient Name>" is displayed in drop down and user is able to select it.
    And   I validate all Address and Website details are autopopulated
    And   I select "Obstetrician and Gynecologist (OBGYN)" in the speciality section
    And   I Click on "Compare Now"
    And   I Get scores for competitors , Google Ranking, Web Presence , Website and Reputation
    Then  I validate the same scores are displayed in Summary page for Google Ranking, Web Presence , Website and Reputation
    
    Examples: 
      | Patient      | Patient Name          |
      | Amersi       | Shamsah Amersi        |
      | Prakash Neal | East Duarte Road      |
 
 #Manual Scenaios     
  Scenario : Validate score for a other few more patient
 
  Scenario : Validate "Request Consulation link" link and Perform Request a Demo scenario
  
  Scenario : Validate "Schedule a free consulation" link and Perform Request a Demo scenario
  
  Scenario : Validate chat bot
  
  Scenario : The above automation scenario uses Next button for navigation between different links, the same operation can be tested 
   mouse actions as user is able to next page via mouse scroll
   
  Scenario : Comparing the scores with bar chart 
  
  Scenario : Validate the average score and color of them
  
  
  Scenario : Validating "See details" section
    
  
   
  
  
  
