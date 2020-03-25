package com.automation.tests.warmUp;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUpTask2 {
    /**
     * Go to http://practice.cybertekschool.com/tables
     * Click on “Last name” column name
     * Verify that table is sorted by last name in alphabetic order.
     * The Java String compareTo() method is used for comparing two strings lexicographically.
     * Each character of both the strings is converted into a Unicode value for comparison.
     * If both the strings are equal then this method returns 0 else it returns positive or negative value.
     * The result is positive if the first string is lexicographically greater than
     * the second string else the result would be negative.
     *
     * This method is coming from Comparable interface.
     * If you want ot be able to sort collection of some class
     * you need to implement this interface
     * and override compareTo method
     *
     *      "a".compareTo("b") = -1
     *      61 - 62 = -1
     *      a is before b
     *      "a".compareTo("a")
     *      61 - 61 = 0
     *      0 means 2 strings are equals
     *
     */

    private WebDriver driver;
    private String URL = " http://practice.cybertekschool.com/tables";
    private By lastNameBy = By.xpath("//table[1]//*[text()='Last Name']");
    private By column1By = By.xpath("//table[1]//tbody//td[1]");

    @Test
    public void test() {
        driver.findElement(lastNameBy).click();
        BrowserUtils.wait(4);

        List<WebElement> column = driver.findElements(column1By);
        for (int i = 0; i < column.size()-1; i++) {
            String value = column.get(i).getText();
            String nextValue = column.get(i+1).getText();
            System.out.println(value.compareTo(nextValue) );
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);


    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
