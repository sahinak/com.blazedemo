package steps;

import static org.testng.Assert.assertTrue;

import ScreenClasses.*;
import base.BaseUtil;
import base.Browser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.LoadEnvironment;
import java.util.HashMap;
import java.util.Map.Entry;

public class FlightBookingPageSteps extends BaseUtil {
    FlightBookingPage FlightPage = new FlightBookingPage();
    static HashMap<String,String> idValue = new HashMap<String,String>();
    
    		

    @Given("^navigate to MAIN page$")
    public void navigateToLoginPage() throws Throwable {
        LoadEnvironment.loadProperties();
        String MAIN_URL = "https://" + LoadEnvironment.IP;
        System.out.println("The Flight booking main page: " + MAIN_URL);
        Browser.navigateTo(MAIN_URL);
         Thread.sleep(2000);
       
         
    }
    
    @Then("verify the {string} should be {string} in flight booking page")
    public void verifyTheHeaderShouldBeInFlightBookingPage(String field, String expectedValue) {
        String actualValue = "";
        switch (field) {
            case "header":
                actualValue = FlightPage.HeaderText.read();
                break;
            case "Departureheader":
            	
                actualValue = FlightPage.DepHeader.read();
                
                break;
            case "Desheader":
                actualValue = FlightPage.DestiHeader.read();
                break;
                
            case "FlightreservedHeader":
                actualValue = FlightPage.FlightreservedHeader.read();
                break;   
                
            case "ThankyouHeader":
                actualValue = FlightPage.ThankyouHeader.read();
                break;    
                
            case "ID":
                actualValue = FlightPage.ID.read();
                break;    
                
        }
        assertString(actualValue, expectedValue);

    }
  
    @And("Enter the value in the Flight booking source and Destination field {string} as {string}")
	public void enterTheValueInTheDepAndDesFieldAs(String field, String value) throws InterruptedException {
       Thread.sleep(500);
		switch (field) {
		
		case "Departure":
			FlightPage.DepDropdown.selectVisibleText(value);
			break;
		
		case "Destination":
			FlightPage.DestDropdown.selectVisibleText(value);
			break;
		
		}
       
       }
   


    @And("^in the flight booking page click on the \"([^\"]*)\" button$")
    public void inTheFlightBookingPageClickOnTheButton(String button) throws Throwable {
        if (button.equalsIgnoreCase("FindFlightButton")) {
        	FlightPage.FindFlightButton.click();
        }

        if (button.equalsIgnoreCase("ChooseFirstFlight")) {
        	FlightPage.ChooseFifthFlight.click();
        }

        if (button.equalsIgnoreCase("ChooseSecondFlight")) {
        	FlightPage.ChooseSecondFlight.click();
        }

        if (button.equalsIgnoreCase("ChooseThirdFlight")) {
        	FlightPage.ChooseThirdFlight.click();
        }

        if (button.equalsIgnoreCase("ChooseFourthFlight")) {
        	FlightPage.ChooseFourthFlight.click();
        }

        if (button.equalsIgnoreCase("ChooseFifthFlight")) {
        	FlightPage.ChooseFifthFlight.click();
        }

        if (button.equalsIgnoreCase("PurchageFlightButton")) {
        	FlightPage.PurchageFlightButton.click();
        }
        

    }
   
    @Then("Fill {string} as {string} in passenger data page")
    public void FillPassengerdataPage(String field, String value) throws InterruptedException {
        switch (field)
        {
            case "name":
            {
            	FlightPage.NameInput.clearAndWrite(value);
                break;
            }
            case "address":
            {
            	FlightPage.AdressInput.clearAndWrite(value);
                break;
            }
            case "city":
            {
            	FlightPage.CityInput.clearAndWrite(value);
                break;
            }
            case "state":
            {
            	FlightPage.StateInput.clearAndWrite(value);
                break;
            }
            case "zipcode":
            {
            	FlightPage.ZipCodeInput.clearAndWrite(value);
                break;
            }
            case "cardType":
            {
            	FlightPage.CardTypeDropdown.selectVisibleText(value);
                break;
            }
            case "creditcardnumber":
            {
            	FlightPage.CreditCardNumber.clearAndWrite(value);
                break;
            }
            case "creditcardmonth":
            {
            	FlightPage.CreditardMonth.clearAndWrite(value);
                break;
            }
            case "creditcardyear":
            {
            	FlightPage.CreditCardYear.clearAndWrite(value);
                break;
            }
            case "nameoncard":
            {
            	FlightPage.NameOnCard.clearAndWrite(value);
                break;
            }
            case "rememberMe":
            {
            	FlightPage.RememberMeCheckBox.check();
                break;
            }
           
        }
    }

    @And("^verify the booking id should starts with \"([^\"]*)\"$")
    public void verifyThebookingIdShouldBe(String expected) throws Throwable {
        String actual = FlightPage.IdValue.read();
           assertContainsString(actual, expected);
    }
    
    @Then("Store idvalue from {string} to {string} of flight booking page")
	public void provideTheAsInXmlDocumentPage(String source, String destination) throws InterruptedException {
    	String value=source+destination;
    	  String actual = FlightPage.IdValue.read();
    	idValue.put(value, actual);
    	
    	
    	    	
		}

    @Then("Compare idvalue of booking {string} and {string}")
  	public void readtheIdvalue(String booking1,String booking2) throws InterruptedException {
      	
      	 for(Entry<String, String> m:idValue.entrySet()){  
      		
      		   System.out.println(m.getKey()    +"Print the value "+m.getValue());  
      		  }  
      	String first=idValue.get(booking1);
      	String second=idValue.get(booking2);
      	assertBoolean(first.equals(second), false);
      	 
  		}
    @Then("wait for some time")
	public void waitForSomeTime() throws InterruptedException {
		Thread.sleep(1000);
	}
   
}
	
	
	
	
	
	
	
	
