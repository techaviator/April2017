package dataProvider;

import genericLibraries.ExcelDriver;
import genericLibraries.UtilityClass;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;





import org.testng.annotations.DataProvider;

public class DataproviderListObjectofMap {
	
	
	@DataProvider(name = "dp")
	public static Iterator<Object[]> setData(Method m){
		String path = System.getProperty("user.dir")+UtilityClass.getConfigFileData("EXCEL_FILE");
		List<Object[]> ls = ExcelDriver.driverExcelData(m.getName(),path);		
		return ls.iterator();
	}

}





