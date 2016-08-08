package com.stockAcc.samples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class primusbank {
	String expval="boxkrisha11";
	   WebDriver driver=new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://projects.qedgetech.com/primusbank1/");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login" )).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='images/Branches_but.jpg']")).click();
		driver.findElement(By.id("BtnNewBR")).click();
		driver.findElement(By.id("txtbName")).sendKeys(expval);
		driver.findElement(By.id("txtAdd1")).sendKeys("nzbbnb");
		driver.findElement(By.id("txtZip")).sendKeys("503224");
		
		Select drop=new Select(driver.findElement(By.id("lst_counrtyU")));
		driver.findElement(By.id("lst_counrtyU")).click();
		drop.selectByVisibleText("INDIA");
		Thread.sleep(2000);
		
		Select drop1=new Select(driver.findElement(By.id("lst_stateI" )));
		driver.findElement(By.id("lst_stateI")).click();
		drop1.selectByIndex(1);
		Thread.sleep(2000);
		
	    	Select drop2=new Select(driver.findElement(By.id("lst_cityI")));
			driver.findElement(By.id("lst_cityI")).click();
			drop2.selectByVisibleText("Hyderabad");
			driver.findElement(By.id("lst_stateI")).click();
		
	        driver.findElement(By.id("btn_insert")).click();
	        Thread.sleep(2000);
      	driver.switchTo().alert().accept();
      	
     
      	boolean ISflag=false;
      	
    while (ISflag==true) {
		
			
      		System.out.println(ISflag);
      		
      	List<WebElement> rows=driver.findElements(By.xpath("//table[@id='DG_bankdetails']/tbody/tr"));
      	
      	for (int i = 0; i <rows.size()-1; i++) 
      	{
      		List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
      		
      		for (int j = 0; j <cols.size(); j++) 
      		{
				String actval=cols.get(j).getText();
				if(expval.equalsIgnoreCase(actval))
				{
					System.out.println("true");
					ISflag=true;
					break;
					
				}
				}
      		
      		if(i==rows.size()-2)
     		{
     			
     			int asize=rows.get(i+1).findElements(By.tagName("a")).size();
     			rows.get(i+1).findElements(By.tagName("a")).get(asize-1).click();
     			
     			Thread.sleep(2000);
     		}

      	}
    }

	
}

}
