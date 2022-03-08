package com.rozkland.pages;

import com.rozkland.utilities.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage {

	@FindBy(css = "div.row.result-container")
	private WebElement trainTable;

	public void verifySearchTrains(){
		Utils.waitForVisibility(trainTable,5);
		Assert.assertTrue(trainTable.isDisplayed());
	}

}
