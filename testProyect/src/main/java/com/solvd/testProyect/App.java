package com.solvd.testProyect;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.solvd.testProyect.framework.BrowserFactory;
import com.solvd.testProyect.gui.pages.HomePage;

public class App {
	public static void main(String[] args) {
		BrowserFactory bf = new BrowserFactory();
		WebDriver driver = bf.getDriver();
		driver.get("https://www.gsmarena.com/");
		
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.searchProduct("iphone");
	}
}
