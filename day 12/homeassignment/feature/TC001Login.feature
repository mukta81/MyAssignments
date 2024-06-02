Feature: Login functionality of Leaftaps Application

@regression @smoke
Scenario: Login with positive credentials
And Enter Username as 'Demosalesmanager' and Password as 'crmsfa'
When Click on Login button
Then Home Page should be displayed


@functional
Scenario: Login with negative credentials
And Enter Username as 'Demosales' and Password as 'crms'
When Click on Login button
But Error Message should be displayed