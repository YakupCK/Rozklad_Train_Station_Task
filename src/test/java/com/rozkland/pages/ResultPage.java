package com.rozkland.pages;

import com.rozkland.utilities.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage {

	@FindBy(css = "div.row.result-container")
	private WebElement trainTable;

	@FindBy(css = "div#wyszukiwarka-wyniki")
	private WebElement searchTable;

	public void verifySearchTrains(){
//		Utils.waitForVisibility(trainTable,5);
		Utils.waitFor(1);
		Assert.assertTrue(searchTable.isDisplayed());
	}

}
