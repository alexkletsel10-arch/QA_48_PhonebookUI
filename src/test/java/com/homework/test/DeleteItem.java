package com.homework.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeleteItem extends TestBase {
    @BeforeMethod
    public void preconditionsDelete() {
        click(By.cssSelector(".ico-login"));
        type(By.cssSelector("#Email"), "aaron18@gmail.com");
        type(By.cssSelector("#Password"), "Cadi26$lac");
        click(By.cssSelector("input[value='Log in']"));


        //Select Computer category in header
        driver.findElement(By.cssSelector("a[href='/computers']")).click();
        //Select Notbooks On computers page click on picture
        driver.findElement(By.cssSelector("[alt='Picture for category Notebooks']")).click();
        //click on addToCartButton
        driver.findElement(By.cssSelector(".button-2.product-box-add-to-cart-button")).click();
        // click On Shopping cart link
        driver.findElement(By.id("topcartlink")).click();



    }

    @Test
    public void deleteItemFromShoppingCartTest() {
        int sizeBefore = sizeOfItems();
        driver.findElement(By.name("removefromcart")).click();
        driver.findElement(By.cssSelector(".button-2.update-cart-button")).click();
        pause(1000);
        int sizeAfter = sizeOfItems();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

    private int sizeOfItems() {
        if (isElementPresent(By.name("removefromcart"))){
            return driver.findElements(By.name("removefromcart")).size();
       }
        return 0;
}

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
