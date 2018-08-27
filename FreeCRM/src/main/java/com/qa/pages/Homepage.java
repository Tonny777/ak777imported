package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class Homepage extends TestBase {

	@FindBy(xpath="//div[@class='linkStyle']/a")
	WebElement upgradeaccount;
	
	@FindBy(xpath="//td[@class='logo_text']")
	WebElement logotext;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/a")
	WebElement contacts;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontacts;
	
	@FindBy(xpath="html/body/table[1]/tbody/tr[4]/td/form/table/tbody/tr/td[3]/div/input")
	WebElement search;
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	public String validatehomepagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean logotext()
	{
		return logotext.isDisplayed();
	}
	
	public boolean search()
	{
		return search.isDisplayed();
	}
	public Upgradeyouraccount upgradeaccount()
	{
		Homepage elementOnViewPort = new Homepage();
		elementOnViewPort.upgradeaccount.isDisplayed();
		return new Upgradeyouraccount();
	}
	
	public contactpage contactspagelink() {
		contacts.click();
		return new contactpage();
	}
	
	public void clickonNewcontact() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/a")))
		.build()
		.perform();
		newcontacts.click();
	}
	
	
	
	
	
	
	
}
