package utils;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class AppData
{
		
	protected String[] readAppData(Object className)
	{
		String fullName = className.getClass().getCanonicalName().toString();
		String packageName = className.getClass().getPackage().toString().replace("package", "").trim();
		String subClassName = className.getClass().getSimpleName().toString();
		String parentClassName = fullName.replace(packageName, "").replace(subClassName, "").replace(".", "").trim();
		XMLHandler file = new XMLHandler();
		Document document = null;
		try
		{
			document = file.getXmlDocument(FileReference.htmlElements+File.separator + parentClassName + ".xml");
		} 
		catch (ParserConfigurationException | SAXException | IOException e)
		{
			System.out.println(e);
		}
		return getXmlNodeKeyValuePair(document, subClassName);	
	}
	
	private String[] getXmlNodeKeyValuePair(Document document, String nodeName)
	{
		String[] pair = new String[2];
		try {
			Element element = (Element) document.getElementsByTagName(nodeName).item(0);
			pair[0] = element.getElementsByTagName("key").item(0).getTextContent().trim();
			pair[1] = element.getElementsByTagName("value").item(0).getTextContent().trim();
		} catch (Exception ex) {
			System.out.println(nodeName + "::" + ex.getMessage());
		}
		return pair;
	}
	
}
