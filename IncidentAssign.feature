Feature: Incident Assign functonality 

@smoke
Scenario: Assign Incident scenario 
	Given Click Open
	And Enter Inc Id in search box
	And Select the Inc ID from result 
	And Click assignment lookup 
	And Search for software option
	And Select the software option
	And Input short decription
	And Click update
