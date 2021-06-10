package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionTime
{
    public static String transactionStartTime;
    public static String transactionEndTime;
    public static Date lastModifiedTimeBeforeUpdate;
    public static Date lastModifiedTimeAfterUpdate;

    public static void setTransactionStartTime()
    {
        long millis= System.currentTimeMillis();
        long deductedMillis = millis - (20*1000);
        System.out.println("Millis "+ millis);
        System.out.println("Deducted "+(20*1000)+" Millis: "+ deductedMillis);
        DateFormat simple = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        Date result = new Date(deductedMillis);
        System.out.println(simple.format(result));
        transactionStartTime= simple.format(result);
        //transactionStartTime=CommonUtils.getCurrentDateTimeInString("dd/MM/YYYY HH:mm:ss");
    }

    public static void setTransactionEndTime()
    {
        transactionEndTime=CommonUtils.getCurrentDateTimeInString("dd/MM/YYYY HH:mm:ss");
    }
    public static void setLastModifiedTimeBeforeUpdate()
    {
    	lastModifiedTimeBeforeUpdate=CommonUtils.getCurrentDateTime();
    }
    public static void setLastModifiedTimeAfterUpdate(String date) throws ParseException
    {
    	lastModifiedTimeAfterUpdate=CommonUtils.convertStringToDate(date, "MMM dd, yyyy, hh:mm:ss a");
    }
    
    

}
