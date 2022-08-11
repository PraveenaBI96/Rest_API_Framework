package DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcelSheetTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/dataProvider.xlsx");
	    Workbook book = WorkbookFactory.create(fis);
	    Sheet sh=book.getSheet("dataSupplier");
	    DataFormatter format=new DataFormatter();
	    String value = format.formatCellValue(sh.getRow(2).getCell(3));
	    System.out.println(value);
	    
	}
}
