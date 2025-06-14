package pageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By search=By.className("search-keyword");
	By productName=By.cssSelector("h4[class='product-name']");
	By topDeals=By.linkText("Top Deals");
	By increament=By.cssSelector(".increment");
	By addToCart=By.cssSelector(".product-action button");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}

	public void increamentQuantity(int quantity)
	{
		int i=quantity-1;
		while(i>0)
		{
			driver.findElement(increament).click();
			i--;
		}
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}

}
