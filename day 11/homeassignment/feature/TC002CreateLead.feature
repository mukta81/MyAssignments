Feature: Create Lead functionality of Leaftaps Application

#Background:
#Given Launch the Browser
#And Load the URL

Scenario Outline: Create Lead with multiple data
And Enter Username as 'Demosalesmanager' and Password as 'crmsfa'
When Click on Login button
Then Home Page should be displayed
When Click on CRMSFA link
And Click on Leads Link
And Click on Create Lead
And Enter the Company Name as <companyname>
And Enter the First Name as <firstname>
And Enter the Last Name as <lastname>
And Click on Submit button
Then ViewLeads page should be displayed as <companyname>

Examples:
|companyname|firstname|lastname|
|TestLeaf|Mukta|A|
|TestLeaf|Aditi|B|
