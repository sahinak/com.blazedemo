package utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

public class LoadEnvironment{

    public static Document env = null;
    public static String USER_ADMIN, USER_ADMIN_PWD;
    public static String IP;
    public static String browser;
    public static String mode;

    public static void loadProperties() throws DocumentException {

        File envFile = new File(FileReference.propertyFilePath+File.separator+"Environment.xml");
        SAXReader reader = new SAXReader();
        env = reader.read(envFile);

        /*-------------------- IP --------------------------*/
//        IP = ExtractFromEnvXml.getIP();
        IP=System.getProperty("ctp.hostname",ExtractFromEnvXml.getIP());
        browser=ExtractFromEnvXml.getBrowser();
//        browser=System.getProperty("browser");
        //System.out.println("IP ADDRESS : "+IP);
//        System.out.println(System.getProperty("browser"));
        /*-------------------- ADMIN USER --------------------------*/
//        USER_ADMIN = ExtractFromEnvXml.getAdminUserName();
        USER_ADMIN = System.getProperty("ctp.username",ExtractFromEnvXml.getAdminUserName());
        //System.out.println("ADMIN USER NAME : "+USER_ADMIN);
//        USER_ADMIN_PWD = ExtractFromEnvXml.getAdminUserPassword();
        USER_ADMIN_PWD = System.getProperty("ctp.password",ExtractFromEnvXml.getAdminUserPassword());
        //System.out.println("ADMIN USER PASSWORD : "+USER_ADMIN_PWD);
//        mode=ExtractFromEnvXml.getMode();
       // mode=System.getProperty("ctp.mode",ExtractFromEnvXml.getMode());
    }
}