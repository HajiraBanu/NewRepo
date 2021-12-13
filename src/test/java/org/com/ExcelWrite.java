package org.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
public static void main(String[] args) throws IOException {
	
	File f = new File("E:\\Excel\\Test.xlsx");
	
	FileOutputStream stream = new FileOutputStream(f);
	
	Workbook w = new XSSFWorkbook();
	
	Sheet sheet = w.getSheet("Maven");
	Row row = sheet.createRow(0);
	
		
	
	
	w.write(stream);
	
		
		
	}
	
}

