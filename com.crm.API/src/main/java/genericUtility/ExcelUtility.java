package genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/dataProvider.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		DataFormatter format = new DataFormatter();
		String data= format.formatCellValue(row.getCell(cellNum));
		return data;
	}
	public int getIntDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/dataProvider.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Cell cell = sh.getRow(rowNum).getCell(cellNum);
		int data = (int) cell.getNumericCellValue();
		return data;
	}
}
