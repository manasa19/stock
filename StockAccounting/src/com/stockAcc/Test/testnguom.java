package com.stockAcc.Test;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stockAcc.Master.Testngmaster;

public class testnguom extends Testngmaster {
	@Test
	public void stockacc_uomcreation() throws InterruptedException
	{  
		
		 String uomtext="122324";
           String  uomdiscrptn="dsvfsd";
         boolean flag=false;
		 Actions action=new Actions(driver);
		  String expval="122324";
		  action.moveToElement(driver.findElement(By.linkText("Stock Items"))).build().perform();
		    driver.findElement(By.linkText("Stock Categories")).click();
		    driver.findElement(By.linkText("Unit of Measurement")).click();
		    driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		    driver.findElement(By.id("x_UOM_ID")).clear();
		    driver.findElement(By.id("x_UOM_ID")).sendKeys("uomtext");
		    driver.findElement(By.id("x_UOM_Description")).clear();
		    driver.findElement(By.id("x_UOM_Description")).sendKeys("uomdiscrptn");
		    driver.findElement(By.id("btnAction")).click();
		    driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath(".//button[@class='btn-group ewButtonGroup']")).click();
		    List<WebElement> button=driver.findElements(By.tagName("button"));
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
					Assert.assertEquals(actval, expval, "uom creation has failed");
				}
			
		}
		   
	}

}
