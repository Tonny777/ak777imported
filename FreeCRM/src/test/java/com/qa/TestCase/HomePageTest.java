package com.qa.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;
import com.qa.pages.Upgradeyouraccount;
import com.qa.pages.contactpage;
import com.qa.util.Testutil;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	Homepage homepage;
	Testutil testutil;
	contactpage contactspage;
	Upgradeyouraccount Upgradeyouracc;
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup() {
		intialize();
		testutil=new Testutil();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Upgradeyouracc =new Upgradeyouraccount();
		contactspage=new contactpage();
	}
	
//	@Test()
//	public void homepagetitleTest()
//	{
//		String htitle=homepage.validatehomepagetitle();
//		Assert.assertEquals(htitle, "CRMPRO");
//	}
	
	
	@Test()
	public void logotextTest()
	{
		testutil.switchtoframe();
		Assert.assertTrue(homepage.logotext());
		
	}
	
	@Test()
	public void searchTest() {
		testutil.switchtoframe();
		Assert.assertTrue(homepage.search());
		
	}
	@Test()
	public void upgradeaccountTest()
	{
		testutil.switchtoframe();
		Upgradeyouracc=homepage.upgradeaccount();
	}
	
	@Test()
	public void contactsTest()
	{
		testutil.switchtoframe();
		contactspage=homepage.contactspagelink();
		
	}

	@AfterMethod
	public void tearsdown()
	{
		driver.quit();
	}
	
}
