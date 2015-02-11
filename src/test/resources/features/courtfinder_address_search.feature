@courtfinder
Feature: As a citizen I need to find a court by name, address, county so I can find useful information to help me


 
Scenario Outline: Clicking on the page breadcrumbs returns user to relevant page

             Given I am on the courtfinder address search page
             When on the courtfinder address search page I click on the "<breadcrumb>" breadcrumb
             Then I am redirected to the "<page>" page
             
             Examples:
             |breadcrumb              |page                    |
             |home                    |courtfinder start       |
             |Find a court or tribunal|courtfinder start       |

               
Scenario: when redirected to the address search page the input searchbox is focused

             Given I am on the courtfinder address search page
             Then the address search input box is in focus                 


Scenario Outline: Go back to the address search page from the results the address inputbox should be focused

             Given I am on the courtfinder address search page
             When I enter a court name "Old Bailey" and search
             And on the courtfinder address result search page I click on the "<breadcrumb>" breadcrumb
             Then I am redirected to the "<page>" page
             And the address search input box is in focus 
             Examples:
             |breadcrumb               |page                       |
             |Search by name or address|courtfinder name or address|

             
    

Scenario: No address entered and user requests search prompts error

              Given I am on the courtfinder address search page
              When I select continue
              Then I am prompted to enter a address       

        
Scenario Outline: Complete court name returns individual court entry in the results page

               Given I am on the courtfinder address search page
               When I enter a court name "<courtname>" and search
               Then I will be returned a single court result "<courtname>"
              
              Examples:
              
               
               |courtname|
               |Central Criminal Court|
               |accrington county court|
               |Bath county Court and Family court|
               |Bournemouth Crown court|
 
       
 Scenario Outline: Complete court name returns court details including dx and court number

               Given I am on the courtfinder address search page
               When I enter a court name "<court>" and search
               Then for the closest court the dx "<dx>" and courtnumber "<courtnumber>" are displayed
              
              Examples:
              
               
               |court                 |dx              |courtnumber|
               |Central Criminal Court|46700 Old Bailey|413        |                
                  
                            
                       
Scenario Outline: Partial court name returns result selection

               Given I am on the courtfinder address search page
               When I enter a partial court name "<partialcourtname>" and search
               Then I will be returned court result "<courtname>" in <row> row
              
              Examples:
              

               |partialcourtname  |courtname                                                 |row|
               |bournemouth       |Bournemouth and Poole County Court and Family Court       |1  |
               |bradford court    |Bradford Combined Court Centre                            |1  |



Scenario Outline: Building name returns relevant court 

               Given I am on the courtfinder address search page
               When I enter a building name "<buildingname>" and search
               Then I will be returned court result "<courtname>" in <row> row
              
              Examples:
              
              
               |buildingname      |courtname                                               |row|
               |old bailey        |Central Criminal Court                                  |1  |
               |peak buildings    |High Peak Magistrates' Court                            |1  |
               |first avenue house|Court of Protection                                     |1  |
               

Scenario Outline: Partial address street name will return courts with matching address

               Given I am on the courtfinder address search page
               When I enter a street name "<streetname>" and search
               Then I will be returned court result "<courtname>" in <row> row
              
              Examples:
              

              |streetname        |courtname                                                |row|
              |Tenters Street    |Bury County Court                                        |1|
              |London Road       |Southampton Combined Court Centre                        |1|
              |Laneham Street    |Scunthorpe Magistrates' Court and Family Court           |1|
              |Secretan Way      |South Tyneside Magistrates' Court and Family Court       |1|
              
            
Scenario Outline: Partial address (town/city/county) will return courts with matching address

               Given I am on the courtfinder address search page
               When I enter a town, city or county "<town_city_county>" and search
               Then I will be returned court result "<courtname>" in <row> row
              
              Examples:
              
              |town_city_county|courtname                                    |row|
              |burnley         |Burnley Combined Court Centre                |1|
              |bury            |Bury St Edmunds County Court and Family Court|1|
              |London          |Central London County Court (Bankruptcy)                  |1|
              

             
Scenario Outline: address search that returns no results

               Given I am on the courtfinder address search page
               When I enter a invalid address "<invalidaddress>" and search
               Then I should be prompted that the address is invalid
               
              Examples:
              
              |invalidaddress|
              |zzzzzzzzzz    | 
              
              
              
# error message :
# Sorry, there are no results for xxxxx. Please check and try another name or addresss.                


Scenario Outline: Inactive court should not be displayed

               Given I am on the courtfinder address search page
               When I enter a inactive court "<inactivecourt>" and search
               Then I should be prompted that the address is invalid
               
              Examples:
              
              |inactivecourt               |
              |Southport Magistrates' Court| 


             
Scenario: Sort order will be venue,town,street,county - sub sort is on areas of law

               Given I am on the courtfinder address search page
               When I enter "Derby" and search  
               Then the results should be listed in the following order:
               |court                                           |                    
               |Derby Combined Court Centre                     |
               |Derby Social Security and Child Support Tribunal|
               |Derby Magistrates' Court                        |

             
Scenario: Sort order will be venue,town,street,county - sub sort is on areas of law

               Given I am on the courtfinder address search page
               When I enter "street" and search  
               Then the results should be listed in the following order:
               |court                                           |
               |Pocock Street Tribunal Hearing Centre           |                    
               |Chester-le-Street Magistrates' Court            |
               |Durham Magistrates' Court                       |
               |Consett Magistrates' Court                      |

 
Scenario Outline: Each court name should be a link to the respective court detail page  

          Given I am on the courtfinder address search page
          When I enter "<address>" and search 
          And select the court link on row <row> of the address search results
          Then I am redirected to the selected "<court>" details page
          
          Examples:
          |address            |row|court                                          |
          |Old Bailey         |1|Central Criminal Court                           |
          |Immigration        |1|Birmingham Immigration and Asylum Chamber (First Tier Tribunal)|


Scenario Outline: Each court result should show the postal address 

          Given I am on the courtfinder address search page
          When I enter a town, city or county "<town_city_county>" and search
          Then for in <row> row the court- "<court>" postal address- "<postaladdress>" is displayed
          
          Examples:
          |town_city_county   |row|court                       |postaladdress                       |
          |stevenage          |1  |Stevenage Magistrates' Court|Sish Lane                           | 
          
                          