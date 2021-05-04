package com.mailtravel.page_object;

import com.mailtravel.browserfactory.DriverHelpers;
import com.mailtravel.task_helper.TaskHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DepartureDatePage extends DriverHelpers {
    @FindBy(css="div.nbf_tpl_pms_calendar_tablecontainer div.nbf_tpl_pms_calendar_days label")
    WebElement firstAvailableDate;
    @FindBy(xpath="//button[@class=\'nbf_button nbf_tpl_pms_book_button\']")
    WebElement continueBtn;
    @FindBy(css="select#room-0-numselect")
    WebElement standardRoomSelect;
    @FindBy(xpath="//div[@id='accomForm-select']/button")
    WebElement selectRoomAndContinue;
    @FindBy(css="#extrasButton")
    WebElement continueWithoutExtra;
    @FindBy(css="#pax-a-title-1")
    WebElement titleAdult1;
    @FindBy(css="#pax-a-first-1")
    WebElement firstNameAdult1;
    @FindBy(css="#pax-a-last-1")
    WebElement lastNameAdult1;
    @FindBy(css="#pax-a-dobd-1")
    WebElement birthDate1;
    @FindBy(css="#pax-a-dobm-1")
    WebElement birthMonth1;
    @FindBy(css="#pax-a-doby-1")
    WebElement birthYear1;
    @FindBy(css="#pax-a-title-2")
    WebElement titleAdult2;
    @FindBy(css="#pax-a-first-2")
    WebElement firstNameAdult2;
    @FindBy(css="#pax-a-last-2")
    WebElement lastNameAdult2;
    @FindBy(css="#pax-a-dobd-2")
    WebElement birthDate2;
    @FindBy(css="#pax-a-dobm-2")
    WebElement birthMonth2;
    @FindBy(css="#pax-a-doby-2")
    WebElement birthYear2;
    @FindBy(xpath="//div[@class='nbf_tpl_pms_totalprice_js heading-sm']/span")
    WebElement priceForTwoAdult;

    public DepartureDatePage(){
        PageFactory.initElements(driver,this);
    }
    public String setPriceForTwoAdult(){
        return priceForTwoAdult.getText();
    }

    public void setPassengerdetails(){
        new Select(titleAdult1).selectByValue("Mr");
        TaskHelpers.customWait(3000);
        firstNameAdult1.click();
        firstNameAdult1.sendKeys("john");
        lastNameAdult1.click();
        lastNameAdult1.sendKeys("Taylor");
        new Select(birthDate1).selectByValue("2");
        new Select(birthMonth1).selectByValue("2");
        new Select(birthYear1).selectByValue("2000");
        new Select(titleAdult2).selectByValue("Mrs");
        firstNameAdult1.click();
        firstNameAdult2.sendKeys("Mary");
        lastNameAdult2.click();
        lastNameAdult2.sendKeys("Taylor");
        new Select(birthDate2).selectByValue("7");
        new Select(birthMonth2).selectByValue("3");
        new Select(birthYear2).selectByValue("2001");
    }

    public String verifyDateContent(){
        TaskHelpers.ScrollByJavaScriptExecutor(0,400);
        String dateContent=firstAvailableDate.getText();
        System.out.println(dateContent);
        return dateContent;
    }
    public void clickOnContinueBtn(){
        continueBtn.click();
    }
    public void setStandardRoomSelect(){
        new Select((standardRoomSelect)).selectByIndex(1);
        selectRoomAndContinue.click();
    }
    public void setContinueWithoutExtra(){
        continueWithoutExtra.click();
    }
    public void passengerDetails(){

    }
}
