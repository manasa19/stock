package com.stockAcc.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stockAcc.Master.Testngmaster;

public class supplierdataprovider extends Testngmaster

{
	 @Test(dataProvider="data")
	 public void ktest(String br, String u) throws InterruptedException
		{
		if (br.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
			 boolean  flag=false;
			 String actval=null;
			 driver.findElement(By.linkText("Suppliers")).click();
			   
			   Thread.sleep(2000);
					   
			   driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
			   Thread.sleep(2000);
			   expval= driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
			   driver.findElement(By.id("x_Supplier_Name")).sendKeys("manu123");
			   driver.findElement(By.id("x_Address")).sendKeys("nyd");
			   driver.findElement(By.id("x_City")).sendKeys("nzb");
			   driver.findElement(By.id("x_Country")).sendKeys("india");
			   driver.findElement(By.id("x_Contact_Person")).sendKeys("krishna");
			   driver.findElement(By.id("x_Phone_Number")).sendKeys("8330949357");
			   driver.findElement(By.id("x__Email")).sendKeys("manuki@gmail.com");
			   driver.findElement(By.id("x_Mobile_Number")).sendKeys("8330949357");
			   driver.findElement(By.id("x_Notes")).sendKeys("vxwbhx");
			   driver.findElement(By.id("btnAction")).click();
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
				}
	        Assert.assertEquals(actval, expval, "creation has failed");
		
		}
@DataProvider(parallel=true)
public Object[][] data()
{
	Object[][] d=new Object[2][2];
			
			d[0][0]="krijvev";
			d[0][1]="qdwdedwqe";
			
			d[1][0]="dvmd";
			d[1][1]="jjkjhk";
		    
			d[2][0]="lrrrrrrrrt";
			d[2][1]="kkkkk";
			
			d[3][0]="jkkkkkkkkk";
			d[3][1]="777777";
			d[3][2]="fbbbbbbb";
					
			
			return d;
		}


	
	
	
	

}
