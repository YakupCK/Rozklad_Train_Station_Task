package com.rozkland.pages;

import com.rozkland.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

}
