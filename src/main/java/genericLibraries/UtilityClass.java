package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {
	
	public static String getConfigFileData(String key){
		String configPath = System.getProperty("user.dir")+"/src/main/resources/Config.properties";
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configPath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return prop.getProperty(key);
		
	}
	
}
