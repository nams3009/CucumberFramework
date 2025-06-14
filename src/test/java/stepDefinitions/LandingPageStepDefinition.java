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
import utils.testConceptSetup;

//Single responsibility principle
//Loosely coupled
//Factory Design Pattern

public class LandingPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public LandingPage landingPage;
	testConceptSetup testconceptsetup;
	
	public LandingPageStepDefinition(testConceptSetup testconceptsetup)
	{
		this.testconceptsetup=testconceptsetup;
		this.landingPage=testconceptsetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenKart Landing page")
	public void user_is_on_green_kart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	

	@When("^User searched with Shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {

		//LandingPage landingPage=new LandingPage(testconceptsetup.driver);
		landingPage.searchItem(shortName);
		//testconceptsetup.driver.findElement(By.className("search-keyword")).sendKeys(shortName);
		Thread.sleep(2000);
		testconceptsetup.landingPageProductName = landingPage.getProductName().split("-")[0]
				.trim();
		System.out.println(testconceptsetup.landingPageProductName+" is extracted from home page");

	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_of_the_selected_product_to_cart(String quantity)
	{
		landingPage.increamentQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
}
