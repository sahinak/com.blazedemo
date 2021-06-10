package base;

public class BrowserAlert 
{
	
	public static void acceptAlert()
	{
		Driver.driver.switchTo().alert().accept();
	}
	
	public static void dissmissAlert()
	{
		Driver.driver.switchTo().alert().dismiss();
	}
	
	public static String  getAlertMessage()
	{
		return Driver.driver.switchTo().alert().getText();
	}

}
