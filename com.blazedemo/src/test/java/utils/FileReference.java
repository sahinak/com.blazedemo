package utils;

import java.io.File;

public class FileReference {
    public static String basePath = System.getProperty("user.dir")+ File.separator+"Resources";
    public static String propertyFilePath= basePath+File.separator+"Properties";
    public static String driversFilePath= basePath+File.separator+"Drivers";
    public static String htmlElements=basePath+File.separator+"htmlElements";
   
}
