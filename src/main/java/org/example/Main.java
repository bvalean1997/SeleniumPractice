package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static WebDriver driver;

    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
    }

    public static void main(String[] args) {

        MadisonTest tst = new MadisonTest();

//        setup();
//        tst.openWebsite();
//        tst.printTitle();
//        tst.printUrl();
//        tst.clickOnLogin();
//        tst.navigateBack();
//        tst.refreshPage();
//        tst.quit();
//        tst.goToMyAccount();
//        tst.listNumberOfLanguages();
//        tst.selectSecondLanguage();
//        tst.searchField();
//        tst.listNumberOfNewProducts();
//        tst.listAllNewProducts();
//        tst.navigateToSales();
//        tst.addProductToCart();
//        tst.removeProductFromCart();
    }


}