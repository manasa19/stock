package com.stockAcc.POM;

import org.testng.annotations.Test;

public class logintc extends constants  {
	
	@Test
	public void login()
	{
		driver.get(el.url);
		driver.manage().window().maximize();
		el.stock_login(el.u, el.p);		
		sp.supplier_creation(sp.name, sp.address, sp.city, sp.country, sp.contactperson, sp.phnno, sp.email, sp.mobileno, sp.notes);
		
	}
	

}
