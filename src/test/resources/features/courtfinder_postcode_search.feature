
Feature: As a user I need to be able to make a postcode and area of law search so that it will give a list of the closest court/tribunals 

@todo  
Scenario: No postcode entered and user requests search prompts error


          Given I am on the courtfinder postcode search page
          When I select continue
          Then I am prompted to enter a postcode
          
        
Scenario Outline: Entering a valid postcode and area of law returns expected courts

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then I am redirected to the postcode results displaying the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                                     |
          |SW1H9AJ |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |SW1H9AJ |Children         |Central Family Court                                       |
          |SW1H9AJ |Civil partnership|Central Family Court,Brighton Family Court                 |
#          |CA488RT |Bankruptcy       |Aberystwyth Justice Centre                                 |
                   

    
Scenario Outline: Entering an Northern Ireland postcode and area of law will return an error 

          Given I am on the courtfinder postcode search page
          When I enter a Northern Ireland postcode "<postcode>" and area of law "<law>" and select continue
          Then I am returned an error message that Northern Ireland is not supported except for immigration
          
 #          "Aside from immigration tribunals, 
 #           this tool does not return results for Northern Ireland. 
 #           Other courts and tribunals in Northern Ireland are handled 
 #           by the Northern Ireland Courts and Tribunals Service."
          
          
         Examples:
         |postcode|law                     |   
         |BT1     |Adoption                |
         |BT60    |Children                |
         |BT18    |Civil partnership       |
         |BT74    |Divorce                 |
         |BT45    |Bankruptcy              |
         |BT68    |Housing possession      |
         |BT55    |Money claims            |
         |BT21    |Probate                 |
         |BT9     |Crime                   |
         |BT21    |Domestic violence       |
         |BT56    |Forced marriage         |
         |BT6     |Employment              |
         |BT33    |Social security         |
 #       |BT44    |High court              |
         |BT      |All courts and tribunals|


Scenario Outline: Entering a valid Northern Ireland postcode and Immigration
                  returns expected courts

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then I am redirected to the postcode results displaying the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                          |
          |BT21|Immigration          |Glasgow Tribunal Hearing Centre (Eagle Building)|

                
Scenario Outline: postcode search is not case sensitive 

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then I am redirected to the postcode results displaying the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                                     |
          |SW1H9AJ  |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |sw1h9aj  |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |Sw1H9Aj  |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |SW1H 9AJ |Adoption         |Inner London Family Proceedings Court,Central Family Court |



Scenario Outline: Each court name should be a link to the respective court detail page  

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          And select the "<court>" link in the postcode search results
          Then I am redirected to the selected "<court>" details page
          
          Examples:
          |postcode|law              |court                                            |
          |SW1H9AJ  |Adoption        |Inner London Family Proceedings Court            |
          |BT21     |Immigration     |Glasgow Tribunal Hearing Centre (Eagle Building) |


Scenario Outline: Each court result should show the dx and court number  

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then for the "<court>" the "<dx>" and "<courtnumber>" are displayed
          
          Examples:
          |postcode|law                              |court                                            |dx|courtnumber|
          |BB2 1AA  |All courts and tribunals        |Accrington Magistrates' Court                    |742020 Blackburn 10|1725|
 


Scenario Outline: Each court result should show the postal address 

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then for the "<court>" the "<postaladdress>" is displayed
          
          Examples:
          |postcode|law              |court                          |postaladdress                                    |
          |BT21     |Immigration     |Glasgow Tribunal Hearing Centre (Eagle Building)|215 Bothwell Street                                          |
           
Scenario Outline: The number of results found for a postcode search should be displayed   

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then the total number of search results <result> should be displayed
          
          Examples:
          |postcode |law              |result|
          |SW1H9AJ  |Adoption         |2     |
          |BT21     |Immigration      |2     |
          |SE1 6AZ  |Crime            |10    |

       
Scenario Outline: Error for postcode returning no results  

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then I am prompted that the searched postcode could not be found
          
 #        xxxxx is not a valid postcode, please check and try another postcode.          
          
          Examples:
          |postcode            |law                               |
          |CD2                 |Crime                             |
          |CX3                 |All courts and tribunals          |
          
@development              
 Scenario Outline: postcode search returns first court name

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then I am redirected to the postcode results with the court "<court>" first in the results
          
          Examples:
          |postcode|law              |court                                                     |
|AL10 8RU|Housing possession|St Albans County Court|
|AL4 0SW|Housing possession|St Albans County Court|
|AL7 4SQ|Housing possession|Hertford County Court and Family Court|
|B13 8BA|Housing possession|Birmingham Civil and Family Justice Centre|
|B15 1UJ|Housing possession|Birmingham Civil and Family Justice Centre|
|B15 3LH|Housing possession|Birmingham Civil and Family Justice Centre|
|B16 8RF|Housing possession|Birmingham Civil and Family Justice Centre|
|B18 4JT|Housing possession|Birmingham Civil and Family Justice Centre|
|B18 7EN|Housing possession|Birmingham Civil and Family Justice Centre|
|B19 3TZ|Housing possession|Birmingham Civil and Family Justice Centre|
|B2 4BS|Housing possession|Birmingham Civil and Family Justice Centre|
|B2 4SP|Housing possession|Birmingham Civil and Family Justice Centre|
|B20 2EX|Housing possession|Birmingham Civil and Family Justice Centre|
|B25 8LP|Housing possession|Birmingham Civil and Family Justice Centre|
|B26 2DS|Housing possession|Birmingham Civil and Family Justice Centre|
|B27 7AP|Housing possession|Birmingham Civil and Family Justice Centre|
|B27 7LS|Housing possession|Birmingham Civil and Family Justice Centre|
|B28 1EN|Housing possession|Birmingham Civil and Family Justice Centre|
|B28 8JY|Housing possession|Birmingham Civil and Family Justice Centre|
|B3 2DE|Housing possession|Birmingham Civil and Family Justice Centre|
|B33 0JJ|Housing possession|Birmingham Civil and Family Justice Centre|
|B33 0UA|Housing possession|Birmingham Civil and Family Justice Centre|
|B36 0UH|Housing possession|Birmingham Civil and Family Justice Centre|
|B36 9TL|Housing possession|Birmingham Civil and Family Justice Centre|
|B37 5HR|Housing possession|Birmingham Civil and Family Justice Centre|
|B4 7RQ|Housing possession|Birmingham Civil and Family Justice Centre|
|B40 1PQ|Housing possession|Birmingham Civil and Family Justice Centre|
|B42 1LL|Housing possession|Birmingham Civil and Family Justice Centre|
|B42 2HH|Housing possession|Birmingham Civil and Family Justice Centre|
|B42 2QN|Housing possession|Birmingham Civil and Family Justice Centre|
|B42 9FQ|Housing possession|Birmingham Civil and Family Justice Centre|
|B45 9WL|Housing possession|Birmingham Civil and Family Justice Centre|
|B47 5DP|Housing possession|Birmingham Civil and Family Justice Centre|
|B48 7DB|Housing possession|Worcester Combined Court|
|B48 7NF|Housing possession|Worcester Combined Court|
|B5 7NF|Housing possession|Birmingham Civil and Family Justice Centre|
|B50 4LH|Housing possession|Warwick Combined Court|
|B61 0LA|Housing possession|Worcester Combined Court|
|B61 7HZ|Housing possession|Worcester Combined Court|
|B62 0JJ|Housing possession|Dudley County Court and Family Court|
|B62 8EA|Housing possession|Dudley County Court and Family Court|
|B62 8QW|Housing possession|Dudley County Court and Family Court|
|B64 6DT|Housing possession|Dudley County Court and Family Court|
|B65 0QW|Housing possession|Dudley County Court and Family Court|
|B66 4DL|Housing possession|Birmingham Civil and Family Justice Centre|
|B67 6HS|Housing possession|Birmingham Civil and Family Justice Centre|
|B68 0PS|Housing possession|Birmingham Civil and Family Justice Centre|
|B69 1EL|Housing possession|Birmingham Civil and Family Justice Centre|
|B69 2JU|Housing possession|Birmingham Civil and Family Justice Centre|
|B7 4SA|Housing possession|Birmingham Civil and Family Justice Centre|
|B7 5LJ|Housing possession|Birmingham Civil and Family Justice Centre|
|B75 5SU|Housing possession|Birmingham Civil and Family Justice Centre|
|B76 1GU|Housing possession|Birmingham Civil and Family Justice Centre|                       