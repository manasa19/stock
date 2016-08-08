package com.stockAcc.Test;

import java.io.IOException;

import com.stockAcc.Master.stockAcc1;

public class stockitems {

	public static void main(String[] args) throws IOException {
		stockAcc1 sa=new stockAcc1();
		String resl=sa.stockAcc_Launch("http://webapp.qedgetech.com");
		System.out.println(resl);
		sa.stockAcc_Login("admin", "master");
		System.out.println(resl);
		sa.stockAcc_stockitems(categoryname, stocknumber, stockmeasure, stockname, purchasingprice, sellingprice, stocknotes)
		System.out.println();
		sa.stockAcc_Logout();
		System.out.println(resl);
		sa.stockAcc_Logout();
		System.out.println();

	}

}
