package com.stockAcc.samples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.base.Splitter;


public class sample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   WebDriver driver=new FirefoxDriver();
   driver.manage().window().maximize();
   driver.get("http://webapp.qedgetech.com");
   driver.findElement(By.id("btnreset")).click();
   driver.findElement(By.id("username")).sendKeys("admin");
   driver.findElement(By.id("password")).sendKeys("master");
   driver.findElement(By.id("btnsubmit")).click();
    String expval="bags";
	boolean flag=false;
	int count=0;
    Actions action=new Actions(driver);
    action.moveToElement(driver.findElement(By.linkText("Stock Items"))).build().perform();
	driver.findElement(By.xpath(".//*[@id='mi_a_stock_categories']/a")).click();
	driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	driver.findElement(By.id("x_Category_Name")).sendKeys("Bags");
	driver.findElement(By.id("btnAction")).click();
	driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();

	String pagecount=driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/span[2]")).getText();
	
	String[] split=pagecount.split(" ");
	
	String cnt=split[2];
	
	int pC=Integer.parseInt(cnt);
	
	do
	{
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='tbl_a_stock_categorieslist']/tbody/tr"));
		for (int i = 0; i < rows.size(); i++) 
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			String actval=cols.get(3).getText();
			if (expval.equalsIgnoreCase(actval))
			{
				flag=true;
				break;
			}
		}
		if (flag==false)
		{			
			driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/div/div/div[2]/a[1]")).click();
		}
		count++;
	} 
	while (count <= pC);
	if (flag) 
	{
	System.out.println("true");
	}
	else
	{
		System.out.println("false");
	
}
}
}






	
