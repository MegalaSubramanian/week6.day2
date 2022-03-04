Feature: TestLeaf functonality 

@smoke
Scenario Outline: Create lead scenario 
	Given Click on Create Leads button
	And Enter CompanyName as <companyname> 
	And Enter FirstName as <firstname> 
	And Enter LastName as <lastname> 
	And Click on Create Lead button
	
	Examples: 
		|companyname|firstname|lastname|
		|'TestLeaf'|'Hari'|'R'|
		
@sanity	
Scenario Outline: Edit lead scenario 
	Given  Click on Find Leads button 
	And  Click on the phone tab 
	And  Enter the phone number as <phonenumber> 
	And  Click on Find the Leads button 
	And  Click on the Lead ID from the result 
	And  Click on the Edit button 
	And  Change the Company name as <company> 
	And  Click on Create Lead button 
	
	Examples: 
		|phonenumber|company|
		|99|'TCS'|		
		
@regression	
Scenario Outline: Delete lead scenario 
	Given  Click on Find Leads button 
	And  Click on the phone tab 
	And  Enter the phone number as <phonenumber> 
	And  Click on Find the Leads button 
	And  Save the Lead ID as leadId 
	And  Click on the Lead ID from the result 
	And  Click on the Delete Lead button 
	And  Click on Find Leads 
	And  Enter the leadID in Lead ID tab 
	And  Click on Find the Leads button 
	Then  Validate the result 
	
	Examples: 
		|phonenumber|
		|9|
				
@sanity			
Scenario Outline: Duplicate lead scenario 
	Given  Click on Find Leads button 
	And  Click on the phone tab 
	And  Enter the phone number as <phonenumber> 
	And  Click on Find the Leads button 
	And  Click on the Lead ID from the result 
	And  Click on the Duplicate Lead button 
	And  Click on Create Lead button 
	
	Examples: 
		|phonenumber|
		|99|
		
@functional		
Scenario Outline: Merge lead scenario 
	Given  Click on Merge Leads button 
	And  Click on the lookup against From Lead 
	And  Enter the FirstName for Merge1 as <merge1> 
	And  Click on the Search button 
	And  Save the Lead ID as "leadID" 
	And  Click on the Lead ID from the result 
	And  Click on the lookup against To Lead 
	And  Enter the FirstName for Merge1 as <merge2> 
	And  Click on the Search button 
	And  Click on the Lead ID for Merge from the result 
	And  Click on the Merge button 
	And  Click ok on the alert 
	And  Search for the saved "leadId" 
	Then  Validate if text is displayed 
	
	
	Examples: 
		|merge1|merge2|
		|'gopi'|'babu'|
