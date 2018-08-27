package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;//input[@type='submit' and @value='Login' and @class='btn btn-small']
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='loginForm']/div/div/input")
	WebElement loginbtn;
	
	@FindBy(xpath="//font[@color='red']")
	WebElement SignUp;

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatepagetitle()

	{
		return driver.getTitle();
	}
	
	public boolean SignUp()
	{
	   return SignUp.isDisplayed();
	}
	
	public  Homepage login(String un,String pswd) {
		username.sendKeys("naveenk");
		password.sendKeys("test@123");
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", loginbtn);
		return new Homepage();
		
	}	
	public String validateafterloginpagetitle()

	{
		return driver.getTitle();
	}

}
