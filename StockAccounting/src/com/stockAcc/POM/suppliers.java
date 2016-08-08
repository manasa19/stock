package com.stockAcc.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

public class suppliers {
	
	public static  boolean  flag=false;
	public static String actval=null;
	private static String value1;
	public static String value=value1;
	public static String name="manasacsvs",  address="hjydnyddd", city="cwsdcscewvc",  country="india", contactperson="nedcvvchewv", phnno="9059449794", email="mankittuhx@gmail.com",  mobileno="9160324355",  notes="svcccxsdxz";
	
	@FindBy(linkText="Suppliers")
	WebElement suppliers;
	
	@FindBy(xpath=".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")
	WebElement Add1;
	
	@FindBy(id="x_Supplier_Number")
	WebElement suppliernumber;
	
	@FindBy(id="x_Address")
	WebElement Address;
	
	@FindBy(id="x_City")
	WebElement city1;
	
	@FindBy(id="x_Country")
	WebElement country1;
	
	@FindBy(id="x_Contact_Person")
	WebElement contactperson1;
	
	@FindBy(id="x_Phone_Number")
	WebElement phonenumber;
	
	@FindBy(id="x__Email")
	WebElement email1;
	
	@FindBy(id="x_Mobile_Number")
	WebElement mobilenumber;
	
	@FindBy(id="x_Notes")
	WebElement notes1;
	
	@FindBy(id="btnAction")
	WebElement submit;
	
	
	


	public void supplier_creation(String name, String address, String city, String country,String contactperson, String phnno, String email, String mobileno, String notes) throws InterruptedException 
	{
		suppliers.click();
		 Thread.sleep(2000);
		Add1.click();
		Thread.sleep(2000);
		suppliernumber.getAttribute(value);
		Address.sendKeys(name);
		Address.sendKeys(address);
		city1.sendKeys(city);
		country1.sendKeys(country);
		contactperson1.sendKeys(contactperson);
		phonenumber.sendKeys(phnno);
		email1.sendKeys(email);
		mobilenumber.sendKeys(mobileno);
		notes1.sendKeys(notes);
		submit.click();	
	} 
	   
	   driver.findElement(By.xpath(".//*[@class='ajs-footer']/div[2]/button[1]")).click();
	   Thread.sleep(3000);
	   driver.findElement(By.xpath(".//*[@class='ajs-footer']/div[2]/button")).click();
	   driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
	   driver.findElement(By.id("psearch")).sendKeys(expval);
	   driver.findElement(By.id("btnsubmit")).click();
	   Thread.sleep(2000);
	   List<WebElement>rows=driver.findElements(By.xpath(".//table[@id='tbl_a_supplierslist']/tbody/tr"));
	 
	 
   
      for (int i = 0; i <rows.size(); i++) 
      {
   	   List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
   	
   	   actval=cols.get(5).getText();
		   if (expval.equalsIgnoreCase(actval))
		   {
			   flag=true;
			 break;
		   }
		}*/





	
}
