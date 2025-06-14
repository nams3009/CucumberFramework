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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.testConceptSetup;

//Single responsibility principle
//Loosely coupled
//Factory Design Pattern

public class CheckoutPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckoutPage checkoutPage;
	testConceptSetup testconceptsetup;
	
	public CheckoutPageStepDefinition(testConceptSetup testconceptsetup)
	{
		this.testconceptsetup=testconceptsetup;
		checkoutPage=testconceptsetup.pageObjectManager.getCheckOutPage();
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void Verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		Assert.assertTrue(checkoutPage.VerifyPromoButton());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrderButton());
	}
	
	@Then("^User proceed to Checkout and validate the (.+) items in checkout page$")
	public void User_proceed_to_Checkout_and_validate_items_in_checkout_page(String name) throws InterruptedException
	{
		checkoutPage.CheckOutItems();
		Thread.sleep(2000);
	}
}
