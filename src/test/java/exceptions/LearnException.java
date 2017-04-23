package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class LearnException {

	public static void getpropertyfile() {
		String path = System.getProperty("user.dir")+"/src/main/resources/Config1.properties";
		FileInputStream fis =null;
		Properties prop = new Properties();
		try {
			 fis = new FileInputStream(path);
			 prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		finally{
			System.out.println("THis is finally block");
		}
		
		System.out.println("Execute after try catch");
	}
	public static void main(String[] args) {
		getpropertyfile();
	}

}
