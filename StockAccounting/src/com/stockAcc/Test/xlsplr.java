package com.stockAcc.Test;

import java.io.FileInputStream;
import java.io.IOException;






import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.stockAcc.Master.stockAcc1;

public class xlsplr {

	public static void main(String[] args) throws IOException, InterruptedException {
		stockAcc1 sa=new stockAcc1();
		String xlpath="D:\\stock accounting\\StockAccounting\\src\\com\\stockAcc\\Testdata\\xldata\\splrctn.xlsx";
		String xopath="D:\\stock accounting\\StockAccounting\\src\\com\\stockAcc\\Results\\splrctn1.xlsx";
		FileInputStream fi=new FileInputStream(xlpath);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("sheet2");
		int rc=ws.getLastRowNum();
		for (int i = 1; i <=rc; i++)
		{
			sa.stockAcc_Launch("http://webapp.qedgetech.com");
			sa.stockAcc_Login("admin", "master");
			
			
		}
	    
		

	}

}
