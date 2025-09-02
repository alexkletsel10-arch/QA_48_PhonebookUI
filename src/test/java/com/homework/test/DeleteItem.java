package com.homework.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class DeleteItem extends TestBase {
    @BeforeMethod
    public void preconditionsDelete() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("aaron18@gmail.com").setPassword("Cadi26$lac"));
        clickOnLoginButton();


        //Select Computer category in header
        selectComputerCategory();
        //Select Notbooks On computers page click on picture
        selectItemNoteBook();
        //click on addToCartButton
        clickOnAddToCartButtton();

    }

    @Test
    public void deleteItemFromShoppingCartTest() {
        // click On Shopping cart link
        clickOnShoppingCartLink();
        int sizeBefore = sizeOfItems();
        //Click on check box
        pause(1000);
        clickOnCheckBox();

        clickOnUpgradePageButton();
        pause(1000);
        int sizeAfter = sizeOfItems();
        Assert.assertEquals( sizeAfter,sizeBefore-1);

    }

}
