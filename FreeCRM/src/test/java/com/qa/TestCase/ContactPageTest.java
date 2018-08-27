package com.qa.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.TestBase.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;
import com.qa.pages.contactpage;
import com.qa.util.Testutil;

public class ContactPageTest extends TestBase {

	LoginPage loginpage;
	Homepage homepage;
	Testutil testutil;
	contactpage contactpage;
	String sheetName ="contacts";
	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		intialize();
		testutil=new Testutil();
		contactpage=new contactpage();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoframe();
		contactpage=homepage.contactspagelink();
	}
	
	@Test
	public void verifycontactlabel()
	{
		Assert.assertTrue(contactpage.contactlabel(), "contactlabel is missing");
	}
	
	@Test
	public void verifyrecordtable()
	
	{
		Assert.assertTrue(contactpage.checkrecordtable(),"label is missing");
	}
	
	@Test
	public void verifynewcontactlabel()
	{
		Assert.assertTrue(contactpage.checkrecordtable(),"label is missing");
	}
	
	public void clickoncheckboxes()
	{
		
		contactpage.checkboxesbyname("Aaaron Jacob");
	}
	
	@DataProvider
	public Object[][] gettestdata() {
		Object data[][]=Testutil.gettestdata(sheetName);
		return data;
	}
	
	@Test(dataProvider="gettestdata")
	public void validateFillForm(String Title,String FirstName,String LastName,String NickName) {
		homepage.clickonNewcontact();
		contactpage.FillForm(Title, FirstName, LastName, NickName);
	}
	
	@AfterMethod
	public void tearsdown()
	{
		driver.quit();
	}
	
	
	
	
	
	
}
