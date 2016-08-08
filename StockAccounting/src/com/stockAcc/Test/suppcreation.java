package com.stockAcc.Test;

import java.io.IOException;

import com.stockAcc.Master.stockAcc1;

public class suppcreation {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		stockAcc1 sa=new stockAcc1();
		String resl=sa.stockAcc_Launch("http://webapp.qedgetech.com");
		System.out.println(resl);
		sa.stockAcc_Login("admin", "master");
		System.out.println(resl);
		sa.stockAcc_suppliercreation("gfhnb" , "medgbzx", "vbecc", "india", "nbghgn", "8897151561", "manasa03@gmail.com", "9059449794", "mdbvdvb");
		System.out.println();
		sa.stockAcc_Logout();
		System.out.println(resl);
		sa.stockAcc_Logout();
		System.out.println();

	}

}
