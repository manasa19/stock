package com.stockAcc.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class grid {
    @Parameter("browser")
	@Test
	public void test(String br) throws MalformedURLException
	{
	
	DesiredCapabilities cap=null;
	if(br.equalsIgnoreCase("firefox"))
	{
		cap=DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
	}
	else if(br.equalsIgnoreCase("chrome"))
	{
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
	}
	WebDriver driver=new RemoteWebDriver(new URL(""), cap);
	driver.get("http://webapp.qedgetech.com");
	driver.manage().window().maximize();
		
	}
	
	

}
