package com.stockAcc.Test;

import java.util.List;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stockAcc.Master.Testngmaster;

public class testngstockcat extends Testngmaster
{
	@Test
	public void stockacc_catcreation() throws InterruptedException
	{
		String expval,actval = null;
		  Actions action=new Actions(driver);
		  boolean flag=false;
		   int count=0;
		   expval="boxkriscvg";
		   action.moveToElement(driver.findElement(By.linkText("Stock Items"))).build().perform();
		   driver.findElement(By.linkText("Stock Categories")).click();
		   driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		   driver.findElement(By.id("x_Category_Name")).sendKeys("expval");
		   driver.findElement(By.id("btnAction")).click();
		   driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		   driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		   Thread.sleep(3000);
		   String pagecount=driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/span[2]")).getText();
			
		     String[] split=pagecount.split(" ");
			
			 String cnt=split[2];
			
			int pc=Integer.parseInt(cnt);
			
			do
			{
				List<WebElement> rows=driver.findElements(By.xpath("//table[@id='tbl_a_stock_categorieslist']/tbody/tr"));
				for (int i = 0; i < rows.size(); i++) 
				{
					List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
					 actval=cols.get(3).getText();
					if (expval.equalsIgnoreCase(actval))
					{
						flag=true;
						break;
					}
				}
				
				if (flag==false)
				{			
					break;
				
				
				
				}
				else
				{
					driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/div/div/div[2]/a[1]")).click();
				}
				count++;
				}
			
				
			while (count<=pc);
			
			Assert.assertEquals(expval, actval, "cat creation has failed");	
				
			
	}
		
	}
			
		
			
		
		
	


