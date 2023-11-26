package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	By search=	By.xpath("//input[@type='search']");
	By productname= By.cssSelector("h4.product-name");
	By topDeals = By.cssSelector("Top Deals");
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText() {
		driver.findElement(search).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productname).getText();
	}
	
	public void selectTopDeals() {
		driver.findElement(topDeals).click();;
		
	}
}
