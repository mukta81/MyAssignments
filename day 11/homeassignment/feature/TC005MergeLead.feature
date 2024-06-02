Feature: Merge Lead functionality of Leaftaps Application

#Background:
#Given Launch the Browser
#And Load the URL

Scenario Outline: Merge Lead with multiple data
And Enter Username as 'Demosalesmanager' and Password as 'crmsfa'
When Click on Login button
Then Home Page should be displayed
When Click on CRMSFA link
And Click on Leads Link
And Click on Merge Lead
And Click on From Lead Popup
And Move to new popup window
And Enter First Name as <firstName>
And Click on Find Leads Button
And Keep a note of ID of first record
And Click on First Record 
And Come Back to main Window
And Click on To Lead Popup
And Move to new popup window
And Enter First Name as <anotherFirstName>
And Click on Find Leads Button
And Click on First Record
And Come Back to main Window
And Click on Merge Button
And Accept the OK button in alert
And Click on Find Leads
And Enter the recorded ID in ID field
And Click on Find Leads Button
Then View Leads page should not return any record

Examples:
|firstName|anotherFirstName|
|b|a|
|a|b|
