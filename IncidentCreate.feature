Feature: Create Incident functonality 

@smoke
Scenario: Create Incident scenario 
	Given Click All
	And Click New
	And Click Caller lookup 
	And Select the Caller from result
	And Enter short description
	And Get the incident ID created
	And Click on the submit button
	And Search for the incident ID Create

