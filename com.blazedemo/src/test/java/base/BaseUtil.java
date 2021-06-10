package base;
 
import org.dom4j.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class BaseUtil{
    public static WebElement element;
    public static WebDriver driver;
    public static SoftAssert asert;
    public static Document data = null;
    public static String LoginPath= "/login";

    //Function to assert String
    public static Boolean assertString(String actual, String expected) {
        asert = new SoftAssert();
        asert.assertEquals(actual, expected);
        asert.assertAll();
        return null;
    }

    //Function to assert Integer
    public static void assertInt(int actual, int expected) {
        asert = new SoftAssert();
        asert.assertEquals(actual, expected);
        asert.assertAll();
    }

    //Function to assert Boolean
    public static void assertBoolean(boolean actual, boolean expected) {
        asert = new SoftAssert();
        asert.assertEquals(actual, expected);
        asert.assertAll();
    }
    public static void assertContainsString(String actual, String expected) {
        asert = new SoftAssert();
        asert.assertTrue(actual.contains(expected));
        asert.assertAll();
    }

    //Function to check if the html element is present or not
    public static boolean isElementPresent(By locater){
        try {
        	Driver.driver.findElement(locater);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

}
