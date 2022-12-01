package pom_scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {
	
	public Workbook workbook;
	public static File filePath=new File("./TestData/testData.xlsx");

	public String getData(String sheet, int row, int column) throws IOException {

		FileInputStream fis = new FileInputStream(filePath);
		workbook=WorkbookFactory.create(fis);
		Cell cell=workbook.getSheet(sheet).getRow(row).getCell(column);
		return cell.getStringCellValue();
	}

	public static String[][] getMultipleData(String sheetName) throws IOException {

		FileInputStream fis=new FileInputStream(filePath);

		 
		Workbook book=new XSSFWorkbook(fis);
		Sheet sheet=book.getSheet(sheetName);
		int row_count=sheet.getPhysicalNumberOfRows();
			
		int col_count=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] data=new String[row_count][col_count];
		
		for(int r=0;r<=row_count-1;r++) {
			Row row=sheet.getRow(r);
			for(int c=0;c<row.getLastCellNum();c++) {
				data[r][c]=row.getCell(c).getStringCellValue();
			}
		}
		book.close();
		return data;
		
	}	

}
