package com.rozkland.stepDefs;

import com.rozkland.utilities.ConfigReader;
import com.rozkland.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before()
    public void setUp(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }


    @After()
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.quitDriver();
    }




}
