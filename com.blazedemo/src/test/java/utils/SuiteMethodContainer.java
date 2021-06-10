package utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import steps.Hook;

public class SuiteMethodContainer
{
    @AfterSuite
    public void afterSuite()
    {
        Hook.browser.close();
    }
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("before Suite");
    }

}
