package com.stockAcc.Master;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fi=new FileInputStream("D:\\stock accounting\\StockAccounting\\src\\com\\stockAcc\\Testdata\\Book1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("namesdata");
		XSSFRow r=ws.getRow(3);
		XSSFCell c=r.createCell(2);
		c.setCellValue("webdriver");
		FileOutputStream fp=new FileOutputStream("D:\\stock accounting\\StockAccounting\\src\\com\\stockAcc\\Testdata\\Book2.xlsx");
		wb.write(fp);
		fp.close();
		System.out.println("excel file written");
		
		

	}

}
