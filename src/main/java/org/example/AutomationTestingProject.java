package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomationTestingProject {

    // Assignment - Selenium WebDriver Java

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
    public void registerWithValidCredentials(){
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("bianca");
        driver.findElement(By.id("lastname")).sendKeys("valean");
        driver.findElement(By.id("email_address")).sendKeys("biancavalean3@test.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();

        String registerText = driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > ul > li > ul > li > span")).getText();
        String expectedText = "Thank you for registering with Madison Island.";

        Assert.assertEquals(expectedText, registerText);
    }

    @Test
    public void loginWithValidCredentials(){
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("biancavalean@test.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        String welcomeText = driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong")).getText();
        String expectedText = "Hello, bianca valean!";

        Assert.assertEquals(expectedText, welcomeText);
    }

    @Test
    public void addToWishlist(){
        loginWithValidCredentials();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6")).click();
        driver.findElement(By.id("product-collection-image-373")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div > ul.add-to-links > li:nth-child(1) > a")).click();
    }


    @After
    public void closeDriver() {
        driver.quit();
    }

}
