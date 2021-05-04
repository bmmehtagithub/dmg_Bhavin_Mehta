package com.mailtravel.page_object;

import com.mailtravel.browserfactory.DriverHelpers;
import com.mailtravel.task_helper.TaskHelpers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DayPriceNumberPage extends DriverHelpers {
    @FindBy(css="span#price-pin_days-num-01")
    WebElement daysNumber;
    @FindBy(css="span[class='heading-md bold pin-price-normal'] span[class='ibecurr']")
    WebElement priceOfHolidays;
    @FindBy(css="a#supplier-phone")
    WebElement telephoneNumber;
    @FindBy(xpath="//div[@id='book-button-header']/div//div/div")
    WebElement bookOnlineButton;

    public DayPriceNumberPage(){
        PageFactory.initElements(driver,this);
    }

    public String setPriceOfHolidays(String price){
        String priceOgfHoliday=priceOfHolidays.getText();
        System.out.println(priceOgfHoliday);
        return priceOgfHoliday;
    }
    public String setDaysOfHolidays(String days){
        String daysOfHoliday=daysNumber.getText();
        System.out.println(daysOfHoliday);
        return daysOfHoliday;
    }
    public String setTelephoneNumber(String contactNumber){
        String telephoneNumbers=telephoneNumber.getText();
        System.out.println(telephoneNumbers);
        return telephoneNumbers;
    }
    public void bookOnlineClick(){
        TaskHelpers.ScrollByJavaScriptExecutor(0,400);
        bookOnlineButton.click();
    }
}
