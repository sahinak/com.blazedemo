@FlightBookingPage @RunAll
Feature: Flight reservation
  This feature will verify flight reservation with valid confirmation id

  Background: 
    Given navigate to MAIN page

  @tagging @severity=blocker
  Scenario: Book a flight from Boston to Berlin
    Then verify the "header" should be "Welcome to the Simple Travel Agency!" in flight booking page
    Then wait for some time
    Then verify the "Departureheader" should be "Choose your departure city:" in flight booking page
    Then verify the "Desheader" should be "Choose your destination city:" in flight booking page
    And Enter the value in the Flight booking source and Destination field "Departure" as "Boston"
    And Enter the value in the Flight booking source and Destination field "Destination" as "Berlin"
    And in the flight booking page click on the "FindFlightButton" button
    And in the flight booking page click on the "ChooseFirstFlight" button
    Then verify the "FlightreservedHeader" should be "Your flight from TLV to SFO has been reserved." in flight booking page
    Then Fill "name" as "00sk" in passenger data page
    Then Fill "address" as "00sng" in passenger data page
    Then Fill "city" as "Bengaluru" in passenger data page
    Then Fill "state" as "karnataka" in passenger data page
    Then Fill "zipcode" as "560066" in passenger data page
    Then Fill "cardType" as "American Express" in passenger data page
    Then Fill "creditcardnumber" as "567890999" in passenger data page
    Then Fill "creditcardmonth" as "04" in passenger data page
    Then Fill "creditcardyear" as "2022" in passenger data page
        Then Fill "nameoncard" as "putku" in passenger data page
     Then Fill "rememberMe" as "" in passenger data page
    And in the flight booking page click on the "PurchageFlightButton" button
    Then verify the "ThankyouHeader" should be "Thank you for your purchase today!" in flight booking page
    Then verify the "ID" should be "Id" in flight booking page
    Then Store idvalue from "Boston" to "Berlin" of flight booking page
    And verify the booking id should starts with "1623"

  Scenario: Book a flight from Portland to London
    Then verify the "header" should be "Welcome to the Simple Travel Agency!" in flight booking page
    Then wait for some time
    Then verify the "Departureheader" should be "Choose your departure city:" in flight booking page
    Then verify the "Desheader" should be "Choose your destination city:" in flight booking page
    And Enter the value in the Flight booking source and Destination field "Departure" as "Portland"
    And Enter the value in the Flight booking source and Destination field "Destination" as "London"
    And in the flight booking page click on the "FindFlightButton" button
    And in the flight booking page click on the "ChooseFirstFlight" button
    Then verify the "FlightreservedHeader" should be "Your flight from TLV to SFO has been reserved." in flight booking page
    Then Fill "name" as "00sk111" in passenger data page
    Then Fill "address" as "00sng1111" in passenger data page
    Then Fill "city" as "Bengaluru3333" in passenger data page
    Then Fill "state" as "karnatakaggg" in passenger data page
    Then Fill "zipcode" as "56006666" in passenger data page
    Then Fill "cardType" as "Visa" in passenger data page
    Then Fill "creditcardnumber" as "56789099955" in passenger data page
    Then Fill "creditcardmonth" as "03" in passenger data page
    Then Fill "creditcardyear" as "2050" in passenger data page
   
     Then Fill "nameoncard" as "putkuputki" in passenger data page
     Then Fill "rememberMe" as "" in passenger data page
    And in the flight booking page click on the "PurchageFlightButton" button
    Then verify the "ThankyouHeader" should be "Thank you for your purchase today!" in flight booking page
    Then verify the "ID" should be "Id" in flight booking page
    Then Store idvalue from "Portland" to "London" of flight booking page
    Then Compare idvalue of booking "PortlandLondon" and "BostonBerlin"
    And verify the booking id should starts with "1623"
