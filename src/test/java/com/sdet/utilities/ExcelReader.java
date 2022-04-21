package com.sdet.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;


public class ExcelReader {
	
	static FileInputStream fis;
	static HSSFWorkbook wb;
	ExcelReader exread;
	
	//public static void main(String []args) {
	public ExcelReader(String path){
		try {
			 fis= new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wb = new HSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public   Object[][]  toReadValuedFromExcel(String path) {
		
		exread= new ExcelReader(path);
		
		HSSFSheet sheet= wb.getSheetAt(0);
		
		int rCount= sheet.getLastRowNum();
		System.out.println(rCount);
		
		int cCount=sheet.getRow(0).getLastCellNum();
		System.out.println(cCount);
		 
		Object a[][] =  new Object[rCount][cCount];
		
		for(int i=0;i< rCount;i++) {
			for(int j=0;j<cCount;j++) {
				a[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return a;
	}
	
public   Object[][]  toReadValuedFromExcelAllValues(String path) {
		
		exread= new ExcelReader(path);
		
		HSSFSheet sheet= wb.getSheetAt(0);
		
		int rCount= sheet.getLastRowNum();
		System.out.println(rCount);
		
		int cCount=sheet.getRow(0).getLastCellNum();
		System.out.println(cCount);
		 
		Object k[][] =  new Object[rCount][cCount];
		
		for(int i=0;i< rCount;i++) {
			for(int j=0;j<cCount;j++) {
				
				HSSFCell cell=sheet.getRow(i+1).getCell(j);
				
				CellType type = cell.getCellType();
                if (type == CellType.STRING) {
                	k[i][j]=cell.getRichStringCellValue().toString();
                    //System.out.println(cell.getRichStringCellValue().toString());
                } else if (type == CellType.NUMERIC) {
                	k[i][j]=cell.getNumericCellValue();
                    //System.out.println(cell.getNumericCellValue());
                } else if (type == CellType.BOOLEAN) {
                	k[i][j]=cell.getBooleanCellValue();
                    //System.out.println(cell.getBooleanCellValue());
                } else if (type == CellType.BLANK) {
                    //System.out.println(cell.getColumnIndex());
                }
				
				}
		}
		System.out.println("inside the excel reader object ");
		for (int i=0;i<1;i++) {
			for(int j=0;j<6;j++) {
				System.out.println(k[i][j]);
			}
		}
		
		return k;
	}
	
		
}
