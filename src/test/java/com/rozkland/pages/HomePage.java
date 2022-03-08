package com.rozkland.pages;

import com.rozkland.utilities.ConfigReader;
import com.rozkland.utilities.Driver;
import com.rozkland.utilities.Utils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	@FindBy(css = "fieldset input#from-station")
	private WebElement fromSection;

	@FindBy(css = "fieldset input#to-station")
	private WebElement toSection;

	@FindBy(css = "button#singlebutton")
	private WebElement searchConnection;

	@FindBy(css = "button[mode='primary']")
	private WebElement initialPopupBtn;

	@FindBy(css = "div.popover-content")
	private WebElement tooltip;

	@FindBy(css = "input#hour")
	private WebElement enterTheTime;

	@FindBy(css = "button.left.btn-pkp-reverse")
	private WebElement previousDateBtn;

	@FindBy(css = "input[name='dateStart']")
	private WebElement selectDate;

	@FindBy(css = "span#wcag-h-reload")
	private WebElement newEnquiry;

	@FindBy(css = "ul#ui-id-1 li")
	private WebElement recentlySearched;



	public void closeInitialPopUp(){
		Utils.waitForVisibility(initialPopupBtn,3);

		try {
			Utils.waitClickability(initialPopupBtn,3);
			initialPopupBtn.click();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void goHomePage(){
		Driver.getDriver().get(ConfigReader.getProperty("url"));
	}

	public void setDepartureFrom(String departure){
		Utils.waitClickability(fromSection,3);
		((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",fromSection );
		fromSection.sendKeys(departure);
	}

	public void setDestinationTo(String destination){
		Utils.waitClickability(toSection,3);
		toSection.sendKeys(destination);
	}

	public void clickSearchBtn(){
		Utils.waitForVisibility(searchConnection,3);
		((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",searchConnection );
		Utils.waitClickability(searchConnection,3);
		searchConnection.click();
	}

	public String getURL(){
		return Driver.getDriver().getCurrentUrl();
	}

	public void verifyTooltip(){
		Utils.waitForVisibility(tooltip,3);
		((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",tooltip );
		System.out.println( tooltip.getText() );
		Assert.assertTrue(tooltip.isDisplayed());
	}

	public String getTimeFromApp(){
		Utils.waitClickability(enterTheTime,3);
		System.out.println("application time is: " + enterTheTime.getAttribute("value"));
		return enterTheTime.getAttribute("value");
	}

	public String getDateFromApp(){
		System.out.println("application's date is: " + selectDate.getAttribute("value"));
		return selectDate.getAttribute("value");
	}

	public void clickPreviousDate(){
		Utils.waitClickability(previousDateBtn,3);
		previousDateBtn.click();
	}

	public void clickFromfield(){
		Utils.waitClickability(fromSection,3);
		fromSection.click();
	}

	public String getTextRecentlySearched(){
		String actualText = recentlySearched.getText();
		System.out.println("actualText text is: " + actualText);
		return actualText;
	}


}
