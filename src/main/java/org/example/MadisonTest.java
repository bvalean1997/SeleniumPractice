package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.example.Main.driver;

public class MadisonTest {

    public static void openWebsite() {
        driver.get("http://qa1magento.dev.evozon.com");
    }

    public static void printTitle() {
        System.out.println("Title: " + driver.getTitle());
    }

    public static void printUrl() {
        System.out.println("Page URL: " + driver.getCurrentUrl());
    }

    public static void clickOnLogo() {
        WebElement element = driver.findElement(By.className("logo"));
        element.click();
    }

    public static void clickOnLogin() {
        driver.navigate().to("http://qa1magento.dev.evozon.com/furniture.html");
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void navigateForward() {
        driver.navigate().forward();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void quit() {
        driver.quit();
    }


    // ACCOUNT

    public static void goToMyAccount() {
        WebElement account = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a"));
        account.click();

        // 3. Click on My Account
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();
    }

    // LANGUAGE

    public static void listNumberOfLanguages() {
        Select oSelect = new Select(driver.findElement(By.id("select-language")));
        List<WebElement> languagesCount = oSelect.getOptions();
        System.out.println("Number of languages:" + languagesCount.size());
    }

    public static void selectSecondLanguage() {
        Select lSelect = new Select(driver.findElement(By.id("select-language")));
        lSelect.selectByIndex(1);
    }

    // Search
    public static void searchField() {
        WebElement searchField = driver.findElement(By.id("search"));
        searchField.clear();
        searchField.sendKeys("woman");

        WebElement submitButton = driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button"));
        submitButton.submit();
    }

    public static void listNumberOfNewProducts() {
        List<WebElement> elements = driver.findElements(By.className("product-image"));
        System.out.println("Number of new products:" + elements.size());
    }

    public static void listAllNewProducts() {
        List<WebElement> elements = driver.findElements(By.className("product-image"));
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getAttribute("title"));
        }
    }

    public static void navigateToSales() {
        WebElement element = driver.findElement(By.id("header-nav"));
        WebElement sale = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        sale.click();
    }

    public static void addProductToCart() {
        openWebsite();

        WebElement menSection = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > a"));
        menSection.click()
        ;
        WebElement shirts = driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(2) > a"));
        shirts.click();

        WebElement firstProduct = driver.findElement(By.className("product-image"));
        firstProduct.click();

        WebElement firstColor = driver.findElement(By.className("option-charcoal"));
        firstColor.click();

        WebElement firstSize = driver.findElement(By.id("option81"));
        firstSize.click();

        WebElement qty = driver.findElement(By.id("qty"));
        qty.sendKeys("1");

        WebElement addButton = driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button"));
        addButton.click();

    }

    public static void removeProductFromCart() {
        addProductToCart();

        WebElement vip = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6"));
        vip.click();

        WebElement firstProduct = driver.findElement(By.id("product-collection-image-373"));
        firstProduct.click();

        WebElement qty = driver.findElement(By.id("qty"));
        qty.sendKeys("1");

        WebElement addButton = driver.findElement(By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div > div > div.add-to-cart-buttons > button"));
        addButton.click();

        WebElement removeButton = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr.first.odd > td.a-center.product-cart-remove.last > a"));
        removeButton.click();

        quit();

    }


}
