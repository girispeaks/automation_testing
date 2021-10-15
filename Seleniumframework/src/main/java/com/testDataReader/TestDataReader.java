package com.testDataReader;

import java.io.FileInputStream;
import java.util.Date;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.qa.util.FrameworkConstants;

public class TestDataReader {
	
	public TestDataReader() {
		
	}
	
	public static Workbook getTestDatafromExcel(String filePath) throws Exception {
		FileInputStream fis = new FileInputStream(filePath);
		return new XSSFWorkbook(fis);
	}
	
	public static String getStringValue(Sheet sheet, HeaderRow index, int ...rowNum) {
		int retrieveRowNum = FrameworkConstants.DEFAULT_ROW_NUM;
		if(rowNum.length>0) {
			retrieveRowNum = rowNum[0];
		}
		sheet.getRow(retrieveRowNum).getCell(index.getCell()).setCellType(CellType.STRING);
		return sheet.getRow(retrieveRowNum).getCell(index.getCell()).getStringCellValue();	
	}
	
	public static boolean getBooleanValue(Sheet sheet, HeaderRow index, int ...rowNum) {
		int retrieveRowNum = FrameworkConstants.DEFAULT_ROW_NUM;
		if(rowNum.length>0) {
			retrieveRowNum = rowNum[0];
		}
		sheet.getRow(retrieveRowNum).getCell(index.getCell()).setCellType(CellType.BOOLEAN);
		return sheet.getRow(retrieveRowNum).getCell(index.getCell()).getBooleanCellValue();	
	}
	
	public static Date getDateValue(Sheet sheet, HeaderRow index, int ...rowNum) {
		int retrieveRowNum = FrameworkConstants.DEFAULT_ROW_NUM;
		if(rowNum.length>0) {
			retrieveRowNum = rowNum[0];
		}
		return sheet.getRow(retrieveRowNum).getCell(index.getCell()).getDateCellValue();
	}
}
