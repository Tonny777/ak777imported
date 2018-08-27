package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.TestBase.TestBase;

public class contactpage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(xpath="//select[@name='do_action' and @class='select']")
	WebElement checkrecordtable;
	
	@FindBy(xpath="//input[@value='New Contact']")
	WebElement newcontactlabel;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement Title;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='nickname']")
	WebElement NickName;
	
	public contactpage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean contactlabel()
	{
		return contactslabel.isDisplayed();
	}
	
	public boolean checkrecordtable()
	{
		return checkrecordtable.isDisplayed();
	}
	public boolean newcontactlabel()
	{
		return newcontactlabel.isDisplayed();
	}
	
	public void checkboxesbyname(String name) 
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::"
				+ "td//preceding-sibling::td//input[@name='contact_id']")).click();
		
	}
	public void FillForm(String title, String Ftname, String ltname,String Nkname) {
		Title.click();
		Select select =new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		FirstName.sendKeys(Ftname);
		LastName.sendKeys(ltname);
		NickName.sendKeys(Nkname);
	}
	
	
	

	
	
	
	
	
	
}
