package com.solvd.testProyect.gui.components;

import org.openqa.selenium.WebDriver;

public abstract class AbstractUIComponent {
	
	protected WebDriver driver;
	
	public AbstractUIComponent(WebDriver driver) {
		this.driver = driver;
	}

}
