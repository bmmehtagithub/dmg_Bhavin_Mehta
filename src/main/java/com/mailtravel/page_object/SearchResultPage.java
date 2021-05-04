package com.mailtravel.page_object;

import com.mailtravel.browserfactory.DriverHelpers;
import com.mailtravel.task_helper.TaskHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends DriverHelpers {
    @FindBy(css="button#iterator_1_product_custom_more-info-button")
    WebElement moreInfo;
    public SearchResultPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnMoreInfo(){
        TaskHelpers.ScrollByJavaScriptExecutor(0,400);
        moreInfo.click();
    }
}
