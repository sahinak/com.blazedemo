package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CommonUtils 
{

	public static String getString(int length)
	{
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < length) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static String getCurrentDateTimeInString(String format)
	{
		String currentDateTime=null;
		Date now = new Date();
		currentDateTime=new SimpleDateFormat(format).format(now);
		return currentDateTime;
	}

	public static String getContentOfAFile(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		// delete the last new line separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		reader.close();
		String content = stringBuilder.toString();
		return content;
	}
	
	public static Date getCurrentDateTime()
	{
		Date now = new Date();
		return now;
	}
	
	public static Date convertStringToDate(String date, String format) throws ParseException
	{
		Date now=new SimpleDateFormat(format).parse(date); 
		return now;
	}
	public static String convertDateToString(Date date, String format) throws ParseException
	{
		String now =new SimpleDateFormat(format).format(date); 
		return now;
	}
	public static String getPreviousDateInString(String format,int days)
	{
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -days);
        Date todate1 = cal.getTime();    
        String fromdate = new SimpleDateFormat(format).format(todate1);
        return fromdate;
	}

	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}


