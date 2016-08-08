package com.stockAcc.samples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class unitofmearement {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new FirefoxDriver();
		   driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   driver.get("http://webapp.qedgetech.com");
		   driver.findElement(By.id("btnreset")).click();
		   driver.findElement(By.id("username")).sendKeys("admin");
		   driver.findElement(By.id("password")).sendKeys("master");
		   driver.findElement(By.id("btnsubmit")).click();
		   
		   String expval="";  
		   Actions action=new Actions(driver);
		   action.moveToElement(driver.findElement(By.linkText("Stock Items"))).build().perform();
		   driver.findElement(By.linkText("Unit of Measurement")).click();
		   driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		   driver.findElement(By.id("x_UOM_ID")).clear();
		   driver.findElement(By.id("x_UOM_ID")).sendKeys("56665144");
		   driver.findElement(By.id("x_UOM_Description")).clear();
		   driver.findElement(By.id("x_UOM_Description")).sendKeys("sslpeyr545");
		    driver.findElement(By.id("btnAction")).click();
		    driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath(".//button[@class='btn-group ewButtonGroup']")).click();
	}
}
		    
		    