package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://qa1magento.dev.evozon.com/");
    }

    @Test
    public void loginWithValidCredentialsTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@test.com");
        driver.findElement(By.id("pass")).sendKeys("123123");
        driver.findElement(By.id("send2")).click();
        String welcomeText = driver.findElement(By.cssSelector(".dashboard .welcome-msg strong")).getText();
        String expectedText = "Hello, asdasd asdasdasd!";
        Assert.assertEquals(expectedText, welcomeText);
    }

    @Test
    public void loginWithoutPasswordTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@test.com");
        driver.findElement(By.id("send2")).click();
        String error = driver.findElement(By.id("advice-required-entry-pass")).getText();
        Assert.assertEquals("This is a required field.", error);
    }

    @Test
    public void loginWithoutEmailTest() {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("pass")).sendKeys("123123");
        driver.findElement(By.id("send2")).click();
        String error = driver.findElement(By.id("advice-required-entry-email")).getText();
        Assert.assertEquals("This is a required field.", error);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
