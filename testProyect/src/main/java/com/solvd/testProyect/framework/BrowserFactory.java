package com.solvd.testProyect.framework;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
	
	private static WebDriver driver;
	
	public BrowserFactory() {
		
	}
	
	public WebDriver getDriver() {
		if (driver == null) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\julim\\Documents\\SolvdCourse\\testProyect\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		return driver;
	}
}
