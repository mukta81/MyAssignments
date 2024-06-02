Feature: Login functionality of Leaftaps Application

#Background:
#Given Launch the Browser
#And Load the URL

Scenario Outline: Create Lead with multiple data
And Enter Username as 'Demosalesmanager' and Password as 'crmsfa'
When Click on Login button
Then Home Page should be displayed
When Click on CRMSFA link
And Click on Leads Link
And Click on Find Leads
And Click on Phone Tab
And Enter the Phone Number as <phoneNumber>
And Click on Find Leads button
And Click on First Result
And Click on Duplicate Lead Button
And Update Company Name as <companyName>
And Click on Create Lead Button
#And Close the window
Then View Leads page should be duplicated with Company Name as <companyName>

Examples:
|phoneNumber|companyName|
|99|CompanyName|
|98|CompName2|