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
        clickOnLoginLink();
        //Enter Email
        fillLoginForm(new User().setEmail("aaron18@gmail.com").setPassword( "Cadi26$lac"));
        // click on Login button
        clickOnLoginButton();


    }
    @Test
    public void addItemToShoppingCart() {
        //Select Computer category in header
        selectComputerCategory();
        //Select Notebooks On computers page click on picture
        selectItemNoteBook();
        //click on Add to cart Button
        clickOnAddToCartButtton();
        // click On Shopping cart link
        clickOnShoppingCartLink();
        //verify item is added
        Assert.assertTrue(isItemAdded("14.1-inch Laptop"));




        }
    }








