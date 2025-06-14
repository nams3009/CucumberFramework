package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

//dependency injection

public class testConceptSetup {
	
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public BaseTest baseTest;
	public GenericUtils genericUtils;
	
	public testConceptSetup() throws IOException
	{
		baseTest=new BaseTest();
		pageObjectManager=new PageObjectManager(baseTest.WebDriverManager());
		genericUtils=new GenericUtils(baseTest.WebDriverManager());
	}

}
