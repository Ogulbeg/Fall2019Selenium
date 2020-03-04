package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class FindElementsPractice {

    public static void main(String[] args) {

        //        WebDriverManager.chromeDriver().setup();
        //        WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");




        driver.quit();//to close everything
    }

}
