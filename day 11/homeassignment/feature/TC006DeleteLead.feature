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
And Record ID of first result
And Click on First Result
And Click on Delete Button
And Click on Find Leads
And Enter the recorded ID
And Click on Find Leads Button
Then View Leads page should not return any record indicating record deletion


Examples:
|phoneNumber|
|98|