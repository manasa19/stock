package com.stockAcc.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ERP_LOGIN {
	
public static String url="http://webapp.qedgetech.com";
public static String u="admin",p="master";
@FindBy(id="username")
WebElement username;

@FindBy(id="password")
WebElement password;

@FindBy(id="btnsubmit")
WebElement submit;

@FindBy(id="btnreset")
WebElement reset;

public void stock_login(String u, String p)
{
	username.clear();
	username.sendKeys(u);
	password.clear();
	password.sendKeys(p);
	submit.click();
}




}
