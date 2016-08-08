package com.stockAcc.Master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class stockAcc1 
{
	//Global Variables
	public static String strUrl="http://webapp.qedgetech.com";
	public static String expval,actval;
	public WebDriver driver;
	public Actions action;
	public boolean flag;
	public Select drop;
	public Select drop1;
	public Select drop2;
	public String strUsername="admin",strPassword="master";
	public String prPath= "D://stock accounting//StockAccounting//src//com//stockAcc//properties//stockAcc.properties";
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
	
	
	public String stockAcc_Launch(String strUrl) throws IOException
	{
		fi=new FileInputStream(prPath);
		pr=new Properties();
		pr.load(fi);
		expval="Login";
		driver=new FirefoxDriver();
		driver.get(strUrl);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actval=driver.findElement(By.id(pr.getProperty("login"))).getText();
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
	
	public String stockAcc_Login(String strUsername, String strPassword)

	{
		expval="administrator";
		driver.findElement(By.id(pr.getProperty("username"))).clear();
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys(strUsername);
		
		driver.findElement(By.id(pr.getProperty("password"))).clear();
		driver.findElement(By.id(pr.getProperty("password"))).sendKeys(strPassword);
		
		driver.findElement(By.id(pr.getProperty("login"))).click();
		
		actval=driver.findElement(By.xpath(pr.getProperty("administrator"))).getText();
		if (expval.equalsIgnoreCase(actval))
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	public String stockAcc_Logout()
	{
		boolean flag=false;
		expval="login";
		driver.findElement(By.id("logout")).click();
		Sleeper.sleepTight(5000);
        driver.findElement(By.xpath(pr.getProperty("logout_conform"))).click();
		List<WebElement> button=driver.findElements(By.tagName(pr.getProperty("logout_tagname")));
		for (int i = 0; i < button.size(); i++)
		{
			String text=button.get(i).getText();
			if (text.equalsIgnoreCase("ok!"))
			{
				button.get(i).click();
				break;
			}
			if(flag)
			{
				return "true";
			}
			else
			{
				return "false";
			}
			}
		return null;
			
			
		}
			public void stockAcc_Close()
			{
				driver.close();
			}

public String stockAcc_catcration(String text )

{
	expval="text";
	boolean flag=false;
	int count=0;
	action=new Actions(driver);
	action.moveToElement(driver.findElement(By.linkText(pr.getProperty("stockitems")))).build().perform();
	driver.findElement(By.xpath(pr.getProperty("stcokcategorie")));
	driver.findElement(By.xpath(pr.getProperty("add"))).getText();
	driver.findElement(By.id(pr.getProperty("categoryname"))).sendKeys("text");
	driver.findElement(By.id(pr.getProperty("addbutton"))).click();
	driver.findElement(By.xpath(pr.getProperty("ok"))).click();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath(pr.getProperty("add_button"))).click();
	
	 String pagecount=driver.findElement(By.xpath(pr.getProperty("pagecount"))).getText();
	
     String[] split=pagecount.split(" ");
	
	 String cnt=split[2];
	
	int pc=Integer.parseInt(cnt);
	
	do
	{
		List<WebElement> rows=driver.findElements(By.xpath(pr.getProperty("table")));
		for (int i = 0; i < rows.size(); i++) 
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName(pr.getProperty("tagname")));
			String actval=cols.get(3).getText();
			if (expval.equalsIgnoreCase(actval))
			{
				flag=true;
				break;
			}
		}
		if (flag==false)
		{			
			driver.findElement(By.xpath(pr.getProperty("column"))).click();
		}
		count++;
	} 
	while (count <= pc);
	if (flag) 
	{
		return "Pass";
	}
	else
	{
		return "Fail";
	}
	
}

public String stockAcc_unitofmeasurement(String uomtext,String uomdiscrptn) 
{
	
    uomtext="122324";
    uomdiscrptn="dsvfsd";
    flag=false;
	action=new Actions(driver);
	action.moveToElement(driver.findElement(By.linkText(pr.getProperty("stockitems")))).build().perform();
	driver.findElement(By.linkText(pr.getProperty("unitofmeasurement"))).click();
	driver.findElement(By.xpath(pr.getProperty("unitofmeasurement_add"))).click();
	driver.findElement(By.id(pr.getProperty("uom_text"))).sendKeys(uomtext);
	driver.findElement(By.id(pr.getProperty(" uomdis"))).sendKeys(uomdiscrptn);
	driver.findElement(By.id(pr.getProperty("uom_add"))).click();
	Sleeper.sleepTightInSeconds(10);
	List<WebElement> button=driver.findElements(By.tagName(pr.getProperty("tagnameofaddbutton")));
	System.out.println(button.size());
	for (int i = 0; i < button.size(); i++) 
	{
		String text=button.get(i).getText();
		
		if (text.equalsIgnoreCase("OK!"))
		{
			button.get(i).click();
			break;
		}
		if (flag) 
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
		
	}
	return null;
	
}
	
public String stockAcc_suppliercreation(String name, String address, String city, String country,String contactperson, String phnno, String email, String mobileno, String notes ) throws InterruptedException

{
	 
     name="manu123";
     address="nyd";
     city="hyd113";
     country="india";
     contactperson="krishna";
     phnno="8330949357";
     email="manuki@gmail.com";
     mobileno="8330949357";
     notes="vxwbhx";
     
	 flag=false;
	  driver=new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	   driver.findElement(By.linkText(pr.getProperty("supplier_link"))).click();
	   
	   Thread.sleep(2000);
			   
	   driver.findElement(By.xpath(pr.getProperty(" supplier_add"))).click();
	   Thread.sleep(2000);
	   expval= driver.findElement(By.id(pr.getProperty("supplier_id"))).getAttribute("value");
	   driver.findElement(By.id(pr.getProperty(pr.getProperty("supplier_name")))).sendKeys(name);
	   driver.findElement(By.id(pr.getProperty("supplier_address"))).sendKeys(address);
	   driver.findElement(By.id(pr.getProperty("supplier_city"))).sendKeys(city);
	   driver.findElement(By.id(pr.getProperty("supplier_country"))).sendKeys(country);
	   driver.findElement(By.id(pr.getProperty("supplier_contact"))).sendKeys(contactperson);
	   driver.findElement(By.id(pr.getProperty("supplier_phnno"))).sendKeys(phnno);
	   driver.findElement(By.id(pr.getProperty("supplier_email"))).sendKeys(email);
	   driver.findElement(By.id(pr.getProperty("supplier_mobileno"))).sendKeys(mobileno);
	   driver.findElement(By.id(pr.getProperty("supplier_notes"))).sendKeys(notes);
	   driver.findElement(By.id(pr.getProperty("supplier_addbutton"))).click();
	   driver.findElement(By.xpath(pr.getProperty("supplier_add_ok"))).click();
	   Thread.sleep(3000);
	   driver.findElement(By.xpath(pr.getProperty("supplier_add_ok_conform"))).click();
	   driver.findElement(By.xpath(pr.getProperty(" supplier_add_ok_conform_ok"))).click();
	   driver.findElement(By.id(pr.getProperty(pr.getProperty(" supplier_surch")))).sendKeys(expval);
	   driver.findElement(By.id(pr.getProperty("supplier_search_button"))).click();
	   Thread.sleep(2000);
	   List<WebElement>rows=driver.findElements(By.xpath(pr.getProperty("supplier_surch_row")));
	 
	 
    
       for (int i = 0; i <rows.size(); i++) 
       {
    	   List<WebElement> cols=rows.get(i).findElements(By.tagName(pr.getProperty("supplier_tagname")));
    	
    	   String actval=cols.get(5).getText();
		   if (expval.equalsIgnoreCase(actval))
		   {
			   flag=true;
			 break;
		   }
		}
       if(flag)
       {
    	  return "true";
	   
	   }
       else
       {
    	 return "false";
       }
       }


public String stockAcc_stockitems(String categoryname, String stocknumber, String stockmeasure, String stockname, String purchasingprice, String sellingprice, String stocknotes) throws InterruptedException
{
         categoryname="market";
         stocknumber="dcvbgfcdxn";
         stockmeasure="jgh";
         stockname="Honda";
         purchasingprice="1233443";
         sellingprice="666568";
         stocknotes="hvjnfhf";
		  flag=false;
		  driver=new FirefoxDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		   driver.findElement(By.linkText(pr.getProperty("stockitems"))).click();
		   driver.findElement(By.xpath(pr.getProperty(" stock_add"))).click();
		   Sleeper.sleepTight(3000);
		   drop=new Select(driver.findElement(By.id(pr.getProperty("stockitems_add_category"))));
		   drop.selectByVisibleText("categoryname");
		   
		   Sleeper.sleepTight(3000);
		    drop1=new Select(driver.findElement(By.id(pr.getProperty("stockitems_number"))));
		   drop1.selectByVisibleText("stockname");
		   
		   expval=driver.findElement(By.id(pr.getProperty("stock_number"))).getAttribute("value");
		   driver.findElement(By.id(pr.getProperty("stock_number_number"))).sendKeys(pr.getProperty("stocknumber"));
		   
		   Sleeper.sleepTight(3000);
		    drop2=new Select(driver.findElement(By.id(pr.getProperty("stockitem_measure"))));
		   drop2.selectByVisibleText(pr.getProperty("stockmeasure"));
		   
		   driver.findElement(By.id(pr.getProperty("stockitems_purchasingprice"))).sendKeys(pr.getProperty("purchasingprice"));
		   driver.findElement(By.id(pr.getProperty("stockitems_selling"))).sendKeys(pr.getProperty("sellingprice"));
		   driver.findElement(By.id(pr.getProperty("stock_notes"))).sendKeys(pr.getProperty("stocknotes"));
		   driver.findElement(By.id(pr.getProperty("stockitems_add"))).click();
		   
		   driver.findElement(By.xpath(pr.getProperty("stockitems_add_ok"))).click();
		   driver.findElement(By.xpath(pr.getProperty("stockitems_add_ok_conform"))).click();
		   Sleeper.sleepTight(3000);
		   driver.findElement(By.xpath(pr.getProperty("stockitems_add_ok_conform_ok"))).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath(pr.getProperty("stockitems_search"))).click();
		    Thread.sleep(3000);
		   driver.findElement(By.id(pr.getProperty("stockitems_seaechtext"))).sendKeys(expval);
		   driver.findElement(By.id(pr.getProperty("stockitem_submit"))).click();
		   Sleeper.sleepTight(3000);
		   
		   List<WebElement> rows=driver.findElements(By.xpath(pr.getProperty("stockitem_table")));
		   for (int i = 0; i < rows.size(); i++)
		   {
			   List<WebElement>cols=rows.get(i).findElements(By.tagName(pr.getProperty("stock_tag")));
			   
			   
			   String actval=cols.get(i).getText();
			   
			
			   if (expval.equalsIgnoreCase(actval))
			   {
				   flag=true;
					 break;
				   }
				}
	           if(flag)
	           {
				   return "true";
			   }
			   else
			   {
				   return "false";
				
			}
			
		}
}
		
		
		
		
	    
	    





	





