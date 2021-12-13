package org.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {

		File f = new File("E:\\Excel\\Test.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet("Maven");
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(physicalNumberOfRows);
		
		for (int i = 0; i < physicalNumberOfRows; i++) {

			Row row = sheet.getRow(i);
			
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			
			

			for (int j = 0; j < physicalNumberOfCells; j++) {
				
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				
				if(cellType==1) {
					
					String string = cell.getStringCellValue();
					System.out.print(string);
					
				}
				
				else if(DateUtil.isCellDateFormatted(cell)) {
					
					Date date = cell.getDateCellValue();
					
					
					SimpleDateFormat s= new SimpleDateFormat("dd-MM-YYYY");
					String format = s.format(date);
					System.out.print(format);}
				
				else {
					double number = cell.getNumericCellValue();
					
					long l = (long)number;
					System.out.print(l);
				}
				
				
				
			}
			
			
			
			System.out.println();
		}
		
		
	}
}
