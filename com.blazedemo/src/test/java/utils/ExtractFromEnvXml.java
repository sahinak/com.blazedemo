package utils;

import org.dom4j.Node;

public class ExtractFromEnvXml extends LoadEnvironment {
    // --------- Method to get Setup details -------------------------
    public static String getIP() {
        Node node = env.selectSingleNode("Environment/Setup/IP");
        return node.getText();
    }

    // --------- Methods to get Admin Credentials --------------------------------
    public static String getAdminUserName() {
        String user_name = null;
        Node node = env.selectSingleNode("Environment/Users/AdminUser");
        user_name = node.selectSingleNode("username").getText();
        return user_name;
    }
    public static String getAdminUserPassword() {
        String user_pwd = null;
        Node node = env.selectSingleNode("Environment/Users/AdminUser");
        user_pwd = node.selectSingleNode("pwd").getText();
        return user_pwd;
    }
    public static String getBrowser() {
      return env.selectSingleNode("Environment/browser").getText();
    }

   
}
