package genericLibraries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDriver {
		static String sheetName=null;
	public static List<Object[]> driverExcelData(String methodName, String path){
		Map<String , String> map = null;
		Object[] obj = null;
		List<Object[]> ls = new ArrayList<Object[]>();
		ExcelReader xl = new ExcelReader(path);
		getSheetName(methodName, xl);
		int getlastRownum = xl.getlastRownum(sheetName);
		int lastCellNumber = xl.getLastCellNumber(sheetName, 0);
		
		for(int i= 1;i<=getlastRownum;i++){
			if(xl.getCellValue(sheetName, i, 2).equalsIgnoreCase(methodName)&&xl.getCellValue(sheetName, i, 3).equalsIgnoreCase("Y")){
			map = new HashMap<String, String>();
			obj = new Object[1];
			for(int j= 0;j<lastCellNumber;j++){				
				String colHeader = xl.getCellValue(sheetName, 0, j);
				String value = xl.getCellValue(sheetName, i, j);
				map.put(colHeader, value);	
			}
			obj[0] = map;
			ls.add(obj);
			}
		}
		return ls;
	}
	
	public static void getSheetName(String methodName, ExcelReader xl){
		String reference = UtilityClass.getConfigFileData("XL_ReferenceSheet");
		int lastRowOfReferenceSheet = xl.getlastRownum(reference);
		for(int i=1;i<=lastRowOfReferenceSheet;i++){
			if(xl.getCellValue(reference, i, 1).equalsIgnoreCase(methodName)){
				sheetName = xl.getCellValue(reference, i, 2);
				break;
			}
		}
	}

}
