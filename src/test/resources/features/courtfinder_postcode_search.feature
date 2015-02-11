@courtfinder
Feature: As a user I need to be able to make a postcode and area of law search so that it will give a list of the closest court/tribunals 


Scenario Outline: Entering a scottish postcode prompts error only courts in uk and wales.

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And  I enter a Scottish postcode "<postcode>" and select continue
          Then I am returned an error message that courtfinder only supports courts in England and Wales
             
         Examples:
         |postcode|law                     |   
         |DG1     |Adoption                |
         |DD5     |Housing possession      |
         |FK21    |Civil partnership       |
         |G12     |Divorce                 |
         |KW2     |Bankruptcy              |
         |PH38    |Children                |
         |PA10    |Money claims            |
         |ML10    |Probate                 |
         |AB37    |Crime                   |
         |DD2     |Domestic violence       |
         |G46     |Forced marriage         |
         |ZE1     |Employment              |
         |EH27    |Social security         |
         |HS1     |All courts and tribunals|
      


Scenario: Returning from the search results the postcode input box should be in focus

             Given I am on the courtfinder area of law selection page
             When I enter an area of law "Crime" and select continue
             And  I enter a postcode "Sg8 0lt" and select continue
             And on postcode search result page I click on the "Search by postcode" breadcrumb
             Then I am redirected to the "Search by postcode " page
             And the postcode search input box is in focus 
             And the input box should contain the postcode entered

          
Scenario Outline: Clicking on the page breadcrumbs returns user to relevant page

             Given I am on the courtfinder area of law selection page
             When I enter an area of law "Crime" and select continue
             And  I enter a postcode "Sg8 0lt" and select continue
             When on postcode search result page I click on the "Search by postcode" breadcrumb
             Then I am redirected to the "<page>" page
             
             Examples:
             |breadcrumb              |page                    |
             |Home                    |courtfinder start       |
             |Find a court or tribunal|courtfinder start       | 
             |Search by postcode      |Search by postcode      |            

  
Scenario: No postcode entered and user requests search prompts error


          Given I am on the courtfinder postcode search page
          When I select continue
          Then I am prompted to enter a postcode
          
     
Scenario Outline: Entering a valid postcode and area of law returns expected courts

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And  I enter a postcode "<postcode>" and select continue
          Then I am redirected to the postcode results displaying the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                 |
          |SW1H9AJ |Adoption         |Inner London Family Proceedings Court  |
          |SW1H9AJ |Crime            |Blackfriars Crown Court                |
          |SW1H9AJ |Civil partnership|Central Family Court                   |
                   

     
Scenario Outline: Entering an Northern Ireland postcode and area of law will return an error 

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And I enter a Northern Ireland postcode "<postcode>" and select continue
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
         |BT68    |Crime                   |
         |BT55    |Domestic violence       |
         |BT21    |Probate                 |
         |BT9     |Crime                   |
         |BT21    |Domestic violence       |
         |BT56    |Forced marriage         |
         |BT6     |Employment              |
         |BT33    |Money Claims            |
         |BT44    |Social security         |
         |BT12    |All courts and tribunals|



Scenario Outline: Entering a valid Northern Ireland postcode and Immigration
                  returns expected courts

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And  I enter a postcode "<postcode>" and select continue
          Then I am redirected to the postcode results displaying the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                          |
          |BT21|Immigration          |Glasgow Tribunal Hearing Centre (Eagle Building)|


               
Scenario Outline: postcode search is not case sensitive 

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And  I enter a postcode "<postcode>" and select continue
          Then I am redirected to the postcode results displaying the closest "<courts>"
          
          Examples:
          |postcode |law              |courts                                |
          |SW1H9AJ  |Adoption         |Inner London Family Proceedings Court |
          |sw1h9aj  |Adoption         |Inner London Family Proceedings Court |
          |Sw1H9Aj  |Adoption         |Inner London Family Proceedings Court |
          |SW1H 9AJ |Adoption         |Inner London Family Proceedings Court |
          |SW1H9AJ  |Children         |Central Family Court                  |
          |sw1h9aj  |Children         |Central Family Court                  |
          |Sw1H9Aj  |Children         |Central Family Court                  |
          |SW1H 9AJ |Children         |Central Family Court                  |


Scenario Outline: Each court name should be a link to the respective court detail page  

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And  I enter a postcode "<postcode>" and select continue
          And select the court link on row 2 of the postcode search results
          Then I am redirected to the selected "<court>" details page
          
          Examples:
          |postcode |law             |court                                              |
          |SW1H9AJ  |Adoption        |Central Family Court                               |
          |BT21     |Immigration     |Glasgow Tribunal Hearing Centre (Wellington House) |

 
Scenario Outline: Each court result should show the dx and court number  

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And  I enter a postcode "<postcode>" and select continue
          Then for the closest court the dx "<dx>" and courtnumber "<courtnumber>" are displayed
          
          Examples:
          |postcode|law                              |dx                 |courtnumber|
          |BB2 1AA  |All courts and tribunals        |742020 Blackburn 10|1725       |
 


Scenario Outline: Each court result should show the postal address 

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And  I enter a postcode "<searchpostcode>" and select continue
          Then for the closest "<court>" the postal address  "<postaladdress>","<postaltown>","<postcode>" is displayed
          
          Examples:
          |searchpostcode |law              |court                                          |postaladdress                       |postaltown|postcode|
          |BT21           |Immigration     |Glasgow Tribunal Hearing Centre (Eagle Building)|Eagle Building 215 Bothwell Street  |Glasgow   |G2 9JR  |

          
Scenario Outline: The number of results found for a postcode search should be displayed   

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And  I enter a postcode "<postcode>" and select continue
          Then the total number of search results <result> should be displayed
          
          Examples:
          |postcode |law              |result|
          |SW1H9AJ  |Adoption         |2     |
          |BT21     |Immigration      |2     |
          |SE1 6AZ  |Crime            |10    |

      
Scenario Outline: Error for postcode returning no results  

          Given I am on the courtfinder area of law selection page
          When I enter an area of law "<law>" and select continue
          And  I enter a postcode "<postcode>" and select continue
          Then I am prompted that the searched postcode could not be found
          
 #        xxxxx is not a valid postcode, please check and try another postcode.          
          
          Examples:
          |postcode            |law                               |
          |zzzzzz              |Crime                             |
          |CX3                 |All courts and tribunals          |
          
            
Scenario: when redirected to the postcode search page the input searchbox is focused

             Given I am on the courtfinder postcode search page
             Then the postcode search input box is in focus          
          
          
                     