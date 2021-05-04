package com.mailtravel.hooks;

import com.mailtravel.browserfactory.DriverHelpers;
import com.mailtravel.task_helper.TaskHelpers;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private DriverHelpers driverHelpers = new DriverHelpers();

    @Before
    public void setUp() {
        driverHelpers.openBrowser();
        driverHelpers.maximiseBrowser();
        driverHelpers.applyImpWaits();
        driverHelpers.navigateToUrl();
    }
    @After
    public void tearDown(){
        TaskHelpers.customWait(5000);
        driverHelpers.closeBrowser();
    }
}
