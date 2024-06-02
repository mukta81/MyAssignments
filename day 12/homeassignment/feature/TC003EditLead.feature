Feature: Edit Lead functionality of Leaftaps Application

#Background:
#Given Launch the Browser
#And Load the URL

@functional
Scenario Outline: Edit Lead with multiple data
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
And Click on Edit Button
And Enter Company Name as <companyName>
And Click on Update Button
#And Close the window
Then View Leads page should be edited with Company Name as <companyName>

Examples:
|phoneNumber|companyName|
|98|HCL|
|01|TestLeaf|