package utils;

import base.Browser;
import base.Driver;


public class HelperUtils
{
   
    public static boolean landToBasePage(Browser browser)
    {
        boolean landedToBasePage=true;
        try
        {
            Browser.navigateTo("https://" + LoadEnvironment.IP+"/b2b/#/welcome");
            browser.refresh();
            acceptAlertIfPresent();

        }catch (Exception e)
        {
            landedToBasePage=false;
        }
        return landedToBasePage;
    }

   
    public static void acceptAlertIfPresent()
    {
        try{
            Driver.driver.switchTo().alert().accept();
        }
        catch(Exception e)
        {

        }

    }

}
