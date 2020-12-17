package com.solvd.testProyect;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.testProyect.framework.BrowserFactory;
import com.solvd.testProyect.gui.pages.HomePage;

public class SearchTestCase extends AbstractTest{

	@Test
	public void checkSearchProduct() {
		HomePage hp = new HomePage(getDriver());
		hp.open();
		hp.searchProduct("iphone");
	}

}
