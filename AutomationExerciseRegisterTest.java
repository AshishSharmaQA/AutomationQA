
package com.ashTest.webdriver.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.in28minutes.webdriver.basics.AbstractChromeWebDriverTest;

// import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;

class AutomationExerciseRegisterTest extends AbstractChromeWebDriverTest{

        @Test
        public void register(){
            String expectedTitle = "Automation Exercise";
            driver.get("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(),expectedTitle,"Home page visible");
        driver.findElement(By.xpath("//*[@id=\'header\']/div/div/div/div[2]/div/ul/li[4]/a")).click();
        Assert.assertEquals(driver.getTitle(),"Automation Exercise - Signup / Login","SignUp loaded");
        WebElement signUp = driver.findElement(By.className("signup-form"));
        if (signUp.isDisplayed()) {
            System.out.println("SignUp visible");
        }
        else
            System.err.println("Signup didn't load up");
        driver.findElement(By.name("name")).sendKeys("Ashish Sharma");
        driver.findElement(By.xpath("//*[@id=\'form']/div/div/div[3]/div/form/input[3]")).sendKeys("bizashish16@gmail.com");
        sleep(5);
        driver.findElement(By.xpath("//*[@id=\'form\']/div/div/div[3]/div/form/button")).click();
        sleep(5);
        WebElement accountinfo = driver.findElement(By.xpath("//*[@id=\'form\']/div/div/div/div[1]/h2/b"));
        if(accountinfo.isDisplayed()){
            System.out.println("Enter Account info displayed");
        }
        else
            System.out.println("Account info not displayed");
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("Ashish11");
        Select dropDownDay = new Select(driver.findElement(By.id("days")));
        dropDownDay.selectByValue("30");
        Select dropDownMonth = new Select(driver.findElement(By.id("months")));
        dropDownMonth.selectByIndex(5);
        Select dropDownYearSelect = new Select(driver.findElement(By.id("years")));
        dropDownYearSelect.selectByValue("1996");
        if(!driver.findElement(By.id("newsletter")).isSelected()){
            driver.findElement(By.id("newsletter")).click();
        }
        if(!driver.findElement(By.id("optin")).isSelected()){
            driver.findElement(By.id("optin")).click();
        }
        driver.findElement(By.name("first_name")).sendKeys("Ashish");
        driver.findElement(By.name("last_name")).sendKeys("Sharma");
        driver.findElement(By.name("company")).sendKeys("TCS");
        driver.findElement(By.id("address1")).sendKeys("xrbia");
        Select countrySelect = new Select(driver.findElement(By.id("country")));
        countrySelect.selectByValue("India");
        driver.findElement(By.name("state")).sendKeys("Maharashtra");
        driver.findElement(By.name("city")).sendKeys("Pune");
        driver.findElement(By.name("zipcode")).sendKeys("411057");
        driver.findElement(By.id("mobile_number")).sendKeys("8688257031");
        driver.findElement(By.xpath("//*[@id=\'form\']/div/div/div/div[1]/form/button")).click();
    }

}