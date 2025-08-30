package com.homework.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class AddItemTest extends TestBase {
    @BeforeMethod
    public void preconditionsAdd() {
        click(By.cssSelector(".ico-login"));
        //Enter Email
        type(By.cssSelector("#Email"), "aaron18@gmail.com");
        //Enter Password
        type(By.cssSelector("#Password"), "Cadi26$lac");
        // click on Login button
        click(By.cssSelector("input[value='Log in']"));


    }

    @Test
    public void addItemToShoppingCart() {
        //Select Computer category in header
        driver.findElement(By.cssSelector("a[href='/computers']")).click();
        //Select Notebooks On computers page click on picture
        driver.findElement(By.cssSelector("[alt='Picture for category Notebooks']")).click();
        //click on Add to cart Button
        driver.findElement(By.cssSelector(".button-2.product-box-add-to-cart-button")).click();
        // click On Shopping cart link
        driver.findElement(By.id("topcartlink")).click();
        //verify item is added
        Assert.assertTrue(isItemAdded("14.1-inch Laptop"));


    }

    public boolean isItemAdded(String name) {
        List<WebElement> items = driver.findElements(By.cssSelector(".product-name"));
        for (WebElement item : items) {
            if (item.getText().contains(name))
                return true;
        }
        return false;
    }


    @AfterMethod
    public void postConditionRemove(){
        //Mark CheckBox
        driver.findElement(By.name("removefromcart")).click();
        // Click on Update shopping cart button
        driver.findElement(By.cssSelector(".button-2.update-cart-button")).click();
    }



}
