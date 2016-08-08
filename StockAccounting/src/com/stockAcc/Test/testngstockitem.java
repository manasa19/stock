package com.stockAcc.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stockAcc.Master.Testngmaster;

public class testngstockitem extends Testngmaster {
	
	@Test
	public void stockacc_stockitemcreation() throws InterruptedException
	{
		String expva,actval = null;
		
		driver.findElement(By.linkText("Stock Items")).click();
		   driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		   Sleeper.sleepTight(3000);
		   Select drop=new Select(driver.findElement(By.id("x_Category")));
		   drop.selectByVisibleText("market");
		   
		   Sleeper.sleepTight(3000);
		   Select drop1=new Select(driver.findElement(By.id("x_Supplier_Number")));
		   drop1.selectByVisibleText("Honda");
		   
		   expval=driver.findElement(By.id("x_Stock_Number")).getAttribute("value");
		   driver.findElement(By.id("x_Stock_Name")).sendKeys("dcvbgfcdxn");
		   
		   Sleeper.sleepTight(3000);
		   Select drop2=new Select(driver.findElement(By.id("x_Unit_Of_Measurement")));
		   drop2.selectByVisibleText("jgh");
		   
		   driver.findElement(By.id("x_Purchasing_Price")).sendKeys("1233443");
		   driver.findElement(By.id("x_Selling_Price" )).sendKeys("666568");
		   driver.findElement(By.id("x_Notes")).sendKeys("hvjnfhf");
		   driver.findElement(By.id("btnAction")).click();
		   
		   driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		   driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		   Sleeper.sleepTight(3000);
		   driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
		    Thread.sleep(3000);
		   driver.findElement(By.id("psearch")).sendKeys(expval);
		   driver.findElement(By.id("btnsubmit")).click();
		   Sleeper.sleepTight(3000);
		   
		   List<WebElement> rows=driver.findElements(By.xpath(".//table[@id='tbl_a_stock_itemslist']/tbody/tr"));
		   for (int i = 0; i < rows.size(); i++)
		   {
			   List<WebElement>cols=rows.get(i).findElements(By.tagName("a"));
			   
			   
			  actval=cols.get(i).getText();
			   
			
			   if (expval.equalsIgnoreCase(actval))
			   {
				  boolean flag=true;
					 break;
				   }
				}
	           if(flag)
	           {
				  Assert.assertEquals(actval, expval, "stockitem creation has failed");
			   }
			   else
			   {
				   System.out.println("false");
				
			}
		}
		   
	}
	
	
	

	

	


