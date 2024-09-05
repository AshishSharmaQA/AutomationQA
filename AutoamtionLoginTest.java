package com.ashTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
// import org.testng.internal.annotations.TestAnnotation;

import com.in28minutes.webdriver.basics.AbstractChromeWebDriverTest;

public class AutoamtionLoginTest extends AbstractChromeWebDriverTest {

    @Test
    public void loginSuccess() {
        String expectedTitle = "Automation Exercise";
        driver.get("https://automationexercise.com/");
        // Checking Home page visibility
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page visible");
        driver.findElement(By.xpath("//*[@id=\'header\']/div/div/div/div[2]/div/ul/li[4]/a")).click();

        driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[2]"))
                .sendKeys("bizashish16@gmail.com");
        driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[3]")).sendKeys("Ashish11");
        driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/button")).click();
        // Verify correct user name logged in
        Assert.assertEquals(
                driver.findElement(By.xpath("//*[@id=\'header\']/div/div/div/div[2]/div/ul/li[10]/a/b")).getText(),
                "Ashish Sharma");
        driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[5]/a")).click();
    }

    @Test
    public void loginFail() {
        String expectedTitle = "Automation Exercise";
        driver.get("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page visible");
        driver.findElement(By.xpath("//*[@id=\'header\']/div/div/div/div[2]/div/ul/li[4]/a")).click();

        driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[2]"))
                .sendKeys("bizashish16@gmail.com");
        driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[3]")).sendKeys("Ashish21");
        driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\'form\']/div/div/div[1]/div/form/p")).getText(),
                "Your email or password is incorrect!");
        // driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[5]/a")).click();

    }

    @Test
    public void logout() {
        String expectedTitle = "Automation Exercise";
        driver.get("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page visible");
        driver.findElement(By.xpath("//*[@id=\'header\']/div/div/div/div[2]/div/ul/li[4]/a")).click();

        driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[2]"))
                .sendKeys("bizashish16@gmail.com");
        driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/input[3]")).sendKeys("Ashish11");
        driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/button")).click();
        Assert.assertEquals(
                driver.findElement(By.xpath("//*[@id=\'header\']/div/div/div/div[2]/div/ul/li[10]/a/b")).getText(),
                "Ashish Sharma");
        driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")).click();
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login", "Login Page not loaded");
    }

    @Test
    public void existingUserRegister() {
        String expectedTitle = "Automation Exercise";
        driver.get("https://automationexercise.com/");
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Home page visible");
        driver.findElement(By.xpath("//*[@id=\'header\']/div/div/div/div[2]/div/ul/li[4]/a")).click();
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login", "SignUp loaded");
        WebElement signUp = driver.findElement(By.className("signup-form"));
        if (signUp.isDisplayed()) {
            System.out.println("SignUp visible");
        } else
            System.err.println("Signup didn't load up");
        driver.findElement(By.name("name")).sendKeys("Ashish Sharma");
        driver.findElement(By.xpath("//*[@id=\'form']/div/div/div[3]/div/form/input[3]"))
                .sendKeys("bizashish16@gmail.com");
        sleep(5);
        driver.findElement(By.xpath("//*[@id=\'form\']/div/div/div[3]/div/form/button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/p")).getText(),
                "Email Address already exist!");
    }
}
