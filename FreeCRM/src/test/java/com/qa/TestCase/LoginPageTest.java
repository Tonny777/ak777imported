package com.qa.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.TestBase.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialize();
	    loginpage=new LoginPage();
	    homepage=new Homepage();
	}
	
	
	@Test
	public void loginpagetest()
	{
		String title=loginpage.validatepagetitle();
		System.out.println(title);
		Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service","title is not matched");
		
	}
	
	@Test
	public void signup()
	{
		boolean signup=loginpage.SignUp();
		Assert.assertTrue(signup);
	}
	
	@Test
	public void loginpage()
	{
	   homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void afterlogintest()
	{
	String afterlogin =loginpage.validateafterloginpagetitle();
	   System.out.println(afterlogin);
	   Assert.assertEquals(afterlogin, "CRMPRO");
	}
	
	
	@AfterMethod
	public void tearsdown()
	{
		driver.quit();
	}
	
}
