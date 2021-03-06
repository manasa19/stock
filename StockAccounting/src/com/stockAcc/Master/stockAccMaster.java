package com.stockAcc.Master;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class stockAccMaster<string> 
{
	//Global Variables
	public static String strUrl="http://webapp.qedgetech.com";
	public static String expval,actval;
	public WebDriver driver;
	public String strUsername="admin",strPassword="master";
	public String prpath="D://stock accounting//StockAccounting//src//com//stockAcc//properties//stockAcc.properties";
	public FileInputStream fi;
	public Properties pr;
	
	
	/*Domain Name:ERP
	Project Name :Stock Accounting
	Function Name: stockAcc_Launch()
	Arguments      : url
	Description    : It will launch Stock Accounting Application
	Return Type    : String
	Author         :xxxxxxxxxxx
	Creation Date  :19/7/2016*/
	
	
	public String stockAcc_Launch(String strUrl)
	{
		fi=FileInputStream(prpath);
		pr=new Properties();
		pr.load(fi);
		expval="Login";
		driver=new FirefoxDriver();
		driver.get(strUrl);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actval=driver.findElement(By.id(pr.getProperty("username"))).getText();
		if (expval.equalsIgnoreCase(actval)) 
		{
			return "Pass";
			
		}
		else
		{
			return "Fail";
		}
		
	}
	
	/*Domain Name:ERP
	Project Name :Stock Accounting
	Function Name: stockAcc_Login()
	Arguments      : strUsername,strPassword
	Description    : It will login  Stock Accounting Application
	Return Type    : String
	Author         :xxxxxxxxxxx
	Creation Date  :19/7/2016*/
	
	private FileInputStream FileInputStream(String prpath2) {
		// TODO Auto-generated method stub
		return null;
	}

	public String stockAcc_Login(String strUsername, String strPassword)

	{
		expval="administrator";
		driver.findElement(By.id(pr.getProperty("username"))).clear();
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys(strUsername);
		
		driver.findElement(By.id(pr.getProperty("password"))).clear();
		driver.findElement(By.id(pr.getProperty("password"))).sendKeys(strPassword);
		
		driver.findElement(By.id(pr.getProperty("login"))).click();
		
		actval=driver.findElement(By.xpath(pr.getProperty(".//*[@id='msUserName']/font/strong"))).getText();
		if (expval.equalsIgnoreCase(actval))
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
}
/*Domain Name:ERP
Project Name :Stock Accounting
Function Name: stockAcc_Logout()
Description    : It will logout  Stock Accounting Application
Return Type    : String
Author         :xxxxxxxxxxx
Creation Date  :19/7/2016*/
public String stockAcc_logout()
{
	{
	expval="Logout";
	driver.findElement(By.id(pr.getProperty("logout")));
	 actval=driver.findElement(By.xpath(pr.getProperty("conform"))).getText();
	 if(expval.equalsIgnoreCase(actval))
	 {
		 return "Pass";
	 }
	 else
	 {
		 return "Fail";
	 
}
}
}

public String stockAcc_cancel()
{
	driver.findElement(By.xpath(pr.getProperty("cancel")));
	
}
}


