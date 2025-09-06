package com.homework.test;

import com.homeworkphoneb.fw.AppManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected AppManager app = new AppManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
