package com.rozkland.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class Utils {


	//wait for an element to be clickable (with web element)
	public static void waitClickability(WebElement element, int timeOut){
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait for an element to be clickable (with By locator)
	public static void waitClickability(By locator, int timeOut){
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(locator)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait till URL contains a specific text
	public static void waitForURLContains(String urlPart, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
			wait.until(ExpectedConditions.urlContains(urlPart));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait for visibility of a web element
	public static void waitForVisibility(WebElement element, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//get the local time of specified time zone
	public static String getLocalTimeHHmm(String timeZone){
		Date appTime2 = null;

		java.util.TimeZone tz = java.util.TimeZone.getTimeZone(timeZone);
		java.util.Calendar c = java.util.Calendar.getInstance(tz);
		String appTime = c.get(java.util.Calendar.HOUR_OF_DAY)+":"+c.get(java.util.Calendar.MINUTE);

		String pattern = "HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		try {
			appTime2 = simpleDateFormat.parse(appTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Time in " + timeZone + " is: " + simpleDateFormat.format(appTime2));
		return simpleDateFormat.format(appTime2);

	}

	public static String getLocalDateddMMyy(){

		Date todaysDate = Calendar.getInstance().getTime();
		String pattern = "dd.MM.yy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String todaysFormattedDate = simpleDateFormat.format(todaysDate);

		System.out.println("Today's date is: " + todaysFormattedDate );
		return todaysFormattedDate;
	}

	public static void waitFor(int second){
		try {
			Thread.sleep(second*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
