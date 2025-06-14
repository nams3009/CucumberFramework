package stepDefinitions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.testConceptSetup;

//Single responsibility principle
//Loosely coupled
//Factory Design Pattern

public class OfferPageStepDefinition {

	public String offerPageProductName;
	testConceptSetup testconceptsetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(testConceptSetup testconceptsetup)
	{
		this.testconceptsetup=testconceptsetup;
	}


	@Then("^User searched for (.+) Shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {

		switchToOfferPage();	
		//OffersPage offersPage=new OffersPage(testconceptsetup.driver);
		
		OffersPage offersPage=testconceptsetup.pageObjectManager.getOfferPage();
		//testconceptsetup.driver.findElement(By.id("search-field")).sendKeys(shortName);
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName=offersPage.getProductName();
	}
	
	public void switchToOfferPage()
	{
		//If switched to offer page -> skip below part
		//if(testconceptsetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		
		//PageObjectManager pageObjectManager=new PageObjectManager(testconceptsetup.driver);
		LandingPage landingPage=testconceptsetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
//		Set<String> w1=testconceptsetup.driver.getWindowHandles();
//		System.out.println("WINDOW SIZE:: "+w1);
//		Iterator<String> it=w1.iterator();
//		String parentWindow=it.next();
//		String childWindow=it.next();
//		testconceptsetup.driver.switchTo().window(childWindow);
		
		testconceptsetup.genericUtils.switchWindowToChildWindow();
	}
	
	@Then("Validate product name in offer page maches with landing page product name")
	public void Validate_product_name_in_offer_page_maches_with_landing_page_product_name()
	{
		Assert.assertEquals(offerPageProductName, testconceptsetup.landingPageProductName);
	}
}
