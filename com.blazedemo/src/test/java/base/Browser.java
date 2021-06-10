package base;

import org.dom4j.DocumentException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import utils.LoadEnvironment;

public class Browser {

	private DriverSettings driverSetting;
	protected static int timeToWait = 30;

	public Browser() throws DocumentException
	{
		LoadEnvironment.loadProperties();
		String browserName=LoadEnvironment.browser;

		driverSetting = new DriverSettings();
		driverSetting.setUpDriver(browserName, timeToWait);
	}

	public Browser(String browserName)
	{
		driverSetting = new DriverSettings();
		driverSetting.setUpDriver(browserName, timeToWait);
	}

	public Browser(String browserName, int timeUnitInSecond)
	{
		driverSetting = new DriverSettings();
		timeToWait = timeUnitInSecond;
		driverSetting.setUpDriver(browserName, timeUnitInSecond);
	}

	public void close()
	{
		try
		{
			driverSetting.closeDriver();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void navigateTo(String URL)
	{
		Driver.driver.get(URL);
	}

	public void refresh()
	{
		Driver.driver.navigate().refresh();
	}

	/**
	 * Read the URL of the current page
	 * @return : String URL
	 */
	public String getCurrntUrl()
	{
		return Driver.driver.getCurrentUrl();
	}

	public static void scrollToBottomOfThePage() throws InterruptedException {
		Thread.sleep(100);
		JavascriptExecutor js = ((JavascriptExecutor) Driver.driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(400);
	}

	public static boolean isBrowserReachable()
	{
		boolean browserReachable=true;
		try {
			Driver.driver.getTitle();
		}catch(NoSuchSessionException e)
		{
			browserReachable=false;
		}
		return browserReachable;
	}

	
}
