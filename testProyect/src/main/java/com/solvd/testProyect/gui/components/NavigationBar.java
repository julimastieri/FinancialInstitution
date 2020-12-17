package com.solvd.testProyect.gui.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractUIComponent{
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement SearchBox;
	
	@FindBy(className = "nav-input")
	WebElement SearchButton;
	
	public NavigationBar(WebDriver driver) {
		super(driver);
	}
	
	public void search(String product) {
		SearchBox.sendKeys(product);
		SearchButton.click();
	}

}
