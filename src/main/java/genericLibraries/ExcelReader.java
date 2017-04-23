package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	XSSFWorkbook wb = null;
	public ExcelReader(String path){
		//String path = System.getProperty("user.dir") +"/src/test/resources/Age.xlsx";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		if(wb!=null){
			System.out.println("wb Successful");
		}
		
	}
	
	
	//Get the no. of rows from a Excel Sheet
	public int getlastRownum(String sheetName){
		return wb.getSheet(sheetName).getLastRowNum();
		
	}
	
	////Get the no. of cell from a Excel Sheet	
	public int getLastCellNumber(String sheetName, int rowIndex){
		return wb.getSheet(sheetName).getRow(rowIndex).getLastCellNum();		
	}
	
	//Read from  cell
	public String getCellValue(String sheetName, int rowIndex, int cellIndex){
		// wqorkbook, Sheet , row index, cell index
		String cellText = null;
		XSSFCell cell = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex);
		if(cell.getCellType()==Cell.CELL_TYPE_STRING){
			cellText = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
			 double numericCellValue = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getNumericCellValue();
			 cellText = String.valueOf(numericCellValue);
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
			 
			 cellText = "";
		}
		 return cellText;
		
	}
	//Write to a cell
	public void setCellValue(String sheetName, int rowIndex, int cellIndex,  String value) throws IOException{
		XSSFRow row = wb.getSheet(sheetName).getRow(rowIndex);
		if(row==null){
			row = wb.getSheet(sheetName).createRow(rowIndex);
		}
		XSSFCell cell = row.getCell(cellIndex);
		if(cell==null){
			cell = row.createCell(cellIndex);
		}
		cell.setCellValue(value);
		
	}
	
	public void writeToExcel(String path) throws IOException{
		FileOutputStream fout  = new FileOutputStream(path);
		wb.write(fout);
		fout.close();
	}
}
