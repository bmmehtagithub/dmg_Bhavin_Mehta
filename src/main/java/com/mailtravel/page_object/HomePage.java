package com.mailtravel.page_object;

import com.mailtravel.browserfactory.DriverHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverHelpers {
    @FindBy(css="#searchtext_freetext_search_form")
    WebElement searchField;
    @FindBy(css="div[id='freetext_search_form'] div[class='nbf_button']")
    WebElement searchFieldClick;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public String titleVerify(){
        return driver.getTitle();
    }
    public void selectDestination(String destination){
        searchField.click();
        searchField.sendKeys(destination);
        searchFieldClick.click();
    }
}
