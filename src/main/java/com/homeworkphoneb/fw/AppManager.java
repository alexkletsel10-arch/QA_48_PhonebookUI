package com.homeworkphoneb.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AppManager {
    UsersHelper user;
    ProductHelper product;

WebDriver driver;
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UsersHelper(driver);
        product = new ProductHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UsersHelper getUser() {
        return user;
    }
    public ProductHelper getProduct(){
        return product;
    }
}
