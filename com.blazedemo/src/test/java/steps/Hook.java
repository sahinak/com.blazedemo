package steps;


import base.BaseUtil;
import base.Browser;
import base.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.dom4j.DocumentException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.HelperUtils;
import utils.LoadEnvironment;

import java.io.IOException;

public class Hook extends BaseUtil {
	
	public static Browser browser;


    @Before
    public void InitilizaBrowser(Scenario scenario) throws Throwable
    {
        String scenarioID=scenario.getId().toString();
        System.out.println("\n\n");
        System.out.println("****************************************************");
        System.out.println("Starting execution of Scenario:-   "+scenario.getName());
        System.out.println("****************************************************");
        System.out.println("\n\n");
        if(scenarioID.contains("loginPage")) {
            browser = new Browser();
        }
        else
        {
            if (Driver.driver == null || Driver.driver.toString() == null) {
                browser = new Browser();
            
            } else if (!Browser.isBrowserReachable()) {
                browser = new Browser();
          
            }

        }

    }

    @After
    public void CloseBrowser() throws IOException, InterruptedException {
              
            browser.close();
     

        }
    

   @Attachment(value = "Screenshot of {0}", type = "image/png",fileExtension = ".png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) Driver.driver).getScreenshotAs(OutputType.BYTES);
    }
}
