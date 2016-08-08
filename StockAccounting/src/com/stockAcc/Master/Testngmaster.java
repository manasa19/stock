package com.stockAcc.Master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Testngmaster {
	public static String strUrl="http://webapp.qedgetech.com";
	public static String strUsername="admin",strPassword="master";
	public static WebDriver driver;
	public static boolean flag;
	public static Actions action;
	public static Select drop;
	public static Select drop1;
	public static Select drop2;
	public static String expval,actval;
	public static String catname="boxkriscvg";
	public static String uomtext="122324";
	public static String  uomdiscrptn="dsvfsd";
	
	/*public FileInputStream fi;
	public Properties pr;
	public static String prpath="D:\\stock accounting\\StockAccounting\\src\\com\\stockAcc\\properties\\stockAcc.properties";
			*/

	
	@BeforeSuite
	public void stockAcc_Launch() throws IOException
	{
		/*fi=new FileInputStream(prpath);
		pr=new Properties();
		pr.load(fi);*/
		
		expval="Login";
		driver=new FirefoxDriver();
		driver.get(strUrl);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actval=driver.findElement(By.id(("btnsubmit"))).getText();
		Assert.assertEquals(actval, expval, "Lanch has failed");
	}
	@BeforeTest
	public void stockAcc_Login()
	{
		
		expval="Administrator";
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(strUsername);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(strPassword);
		
		driver.findElement(By.id("btnsubmit")).click();
		
		actval=driver.findElement(By.xpath(".//*[@id='msUserName']/font/strong")).getText();
		Assert.assertEquals(actval, expval, "login has failed");
	}
	@AfterTest
	public void stockAcc_Logout()
	{
		expval="Login";
		driver.findElement(By.id("logout")).click();
		Sleeper.sleepTight(5000);
        driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		List<WebElement> button=driver.findElements(By.tagName("button"));
		for (int i = 0; i < button.size(); i++) 
		{
			String bText=button.get(i).getText();
			if (bText.equalsIgnoreCase("ok!"))
			{
				button.get(i).click();
				break;
			}
			
		}
		actval=driver.findElement(By.id("btnsubmit")).getText();
		Assert.assertEquals(actval, expval,"Logout Failed");
		}
	
		@AfterSuite
			public void stockAcc_Close()
			{
			driver.close();
			}
		
		
	}

		

	


