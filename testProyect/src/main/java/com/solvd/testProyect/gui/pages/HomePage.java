package com.solvd.testProyect.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.solvd.testProyect.gui.components.NavigationBar;

public class HomePage extends AmazonAbstractPage{
	
	//@FindBy(className = "nav-opt-sprite nav-locale-us nav-lang-en nav-ssl nav-unrec nav-flex")
	//@FindBy(id = "topsearch-text")
    private NavigationBar navBar;
	
	@FindBy(className = "nav-input")
	WebElement SearchButton;
    
    @FindBy(id = "topsearch-text")
   	WebElement SearchBox;
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public NavigationBar getNavBar() {
		return navBar;
	}
	
	public SearchResultsPage searchProduct(String product) {
		//navBar.search(product);
		SearchBox.sendKeys(product);
		SearchButton.click();
		return new SearchResultsPage(driver);
	}
	
}
