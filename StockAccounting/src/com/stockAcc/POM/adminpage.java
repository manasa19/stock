package com.stockAcc.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adminpage {
	
	@FindBy(linkText="Dashboard")
	WebElement dashboard;
	
	@FindBy(linkText="Stock Items")
	WebElement stockitems;
	
	@FindBy(linkText="Suppliers")
	WebElement suppliers;
	
	@FindBy(linkText="Purchases")
	WebElement purchases;
	
	@FindBy(linkText="Customers")
	WebElement customers;
	
	@FindBy(linkText="Sales")
	WebElement sales;
	
	@FindBy(linkText="Outstandings")
	WebElement outstandins;
	
	@FindBy(linkText="Administrator")
	WebElement administrator;
	
	
	@FindBy(linkText="Settings")
	WebElement settings;
	
	@FindBy(xpath=".//*[@id='mi_logout']/a")
	WebElement logout2;
	
	@FindBy(xpath=".//*[@id='logout']")
	WebElement logout1;
	public void dashboardclick()
	{
		dashboard.click();
	}
	
	public void stockitemsclick()
	{
		stockitems.click();
	}
	
	public void suppliersclick()
	{
		suppliers.click();
	}
	
	public void purchasesclick()
	{
		purchases.click();
	}
	
	public void customersclick()
	{
		customers.click();
	}
	
}
