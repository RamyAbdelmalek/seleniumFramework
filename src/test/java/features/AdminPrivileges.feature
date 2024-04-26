Feature: Admin privilages
	I want to check that Admin can add/delete user in our Dashboard
	

	Scenario: Admin can Login successfully
	Given Admin can Login with his credentials
	Then The dashboard displayed successfully
	
	
	Scenario: Admin can add new user
	When Admin open user management page
	And He add new user
	Then User will be added successfully
	
	Scenario: Admin can remove added user
	Given Admin want to delete added user
	Then User will be removed successfully