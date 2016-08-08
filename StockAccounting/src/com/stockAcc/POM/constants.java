package com.stockAcc.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class constants {
	
	WebDriver driver=new FirefoxDriver();
	ERP_LOGIN el=PageFactory.initElements(driver,ERP_LOGIN.class);
	adminpage ap=PageFactory.initElements(driver, adminpage.class);
	suppliers sp=PageFactory.initElements(driver, suppliers.class);
}
