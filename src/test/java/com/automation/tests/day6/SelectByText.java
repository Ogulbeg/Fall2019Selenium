package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(4);

        //create a webelement object for dropdown first
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));

        //provide weblement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropDown);

        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(4);

        // and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        // Select your DOB(day of birthday)

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));


        selectYear.selectByVisibleText("1992");
        selectMonth.selectByVisibleText("July");
        selectDay.selectByVisibleText("22");
        BrowserUtils.wait(1);



        // Select all month one by one
        //.getOptions();-returns all options from dropdown as List<WebElement>
        List<WebElement> months =selectMonth.getOptions();
        for( WebElement eachMonth: months){
            // get the month name and select based on that
            String monthName =eachMonth.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
            System.out.println(monthName);
        }


        BrowserUtils.wait(4);


        Select stateSelect =new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("New Jersey");

        // option is currently selected
        //.getFirstSelectedOption()-return a webelement, that's why we need to call .getText();
        // .getText()-retrieves visible text from the webelement
        String selected = stateSelect.getFirstSelectedOption().getText();

        if(selected.equals("New Jersey")){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEAR FAILED!");
        }


        List<WebElement> states = stateSelect.getOptions();

        for(WebElement eachState: states){
            System.out.println(eachState.getText());
        }

        BrowserUtils.wait(4);
        driver.quit();
    }
}
