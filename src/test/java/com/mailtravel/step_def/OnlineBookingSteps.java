package com.mailtravel.step_def;

import com.mailtravel.page_object.DayPriceNumberPage;
import com.mailtravel.page_object.DepartureDatePage;
import com.mailtravel.page_object.HomePage;
import com.mailtravel.page_object.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OnlineBookingSteps {
    HomePage homePage;
    SearchResultPage searchResultPage;
    DayPriceNumberPage dayPriceNumberPage;
    DepartureDatePage departureDatePage;

    public OnlineBookingSteps() {
        homePage = new HomePage();
        searchResultPage = new SearchResultPage();
        dayPriceNumberPage = new DayPriceNumberPage();
        departureDatePage = new DepartureDatePage();
    }

    @Given("User is on mailtravel home page")
    public void user_is_on_mailtravel_home_page() {
        System.out.println("1");
        String actualTitle=homePage.titleVerify();
        String expectedTitle="Mail Travel";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @When("User input {string} in searchfield and press enter")
    public void user_input_in_searchfield_and_press_enter(String destination) {
        System.out.println("2");
        homePage.selectDestination(destination);
        System.out.println(destination);
    }

    @When("User click on more info on first search result")
    public void user_click_on_more_info_on_first_search_result() {
        System.out.println("3");
        searchResultPage.clickOnMoreInfo();
    }
    @Then("user can see the price {string}, days {string}, telephone number {string}")
    public void user_can_see_the_price_days_telephone_number(String price, String days, String contactNumber) {
      String actualPrice=dayPriceNumberPage.setPriceOfHolidays(price);
      String actualDays=dayPriceNumberPage.setDaysOfHolidays(days);
      String actualNumber=dayPriceNumberPage.setTelephoneNumber(contactNumber);
      String expectedDays="10";
      String expectedPrice="990";
      String expectedNumber="0808";
      Assert.assertTrue(actualDays.contains(expectedDays));
      Assert.assertTrue(actualNumber.contains(expectedNumber));
      Assert.assertTrue(actualPrice.contains(expectedPrice));

    }

    @When("User click on book online")
    public void user_click_on_book_online() {
        System.out.println("5");
        dayPriceNumberPage.bookOnlineClick();
    }

    @Then("User should get the first available date with value")
    public void user_should_get_the_first_available_date_with_value() {
        System.out.println("6");
        String actualContent=departureDatePage.verifyDateContent();
        String expectedValue="1,197";
        Assert.assertTrue(actualContent.contains(expectedValue));
    }

    @When("User click on continue")
    public void user_click_on_continue() {
        System.out.println("7");
        departureDatePage.clickOnContinueBtn();
    }

    @When("User select standard room")
    public void user_select_standard_room() {
        System.out.println("8");
        departureDatePage.setStandardRoomSelect();
    }

    @When("User click on continue without extras")
    public void user_click_on_continue_without_extras() {
        System.out.println("9");
        departureDatePage.setContinueWithoutExtra();
    }

    @When("User enter following passenger detail")
    public void user_enter_following_passenger_detail() {
        System.out.println("10");
        departureDatePage.setPassengerdetails();
    }

    @Then("User can see the amount as per accommodation")
    public void user_can_see_the_amount_as_per_accomodation() {
        System.out.println("11");
        String actualPrice=departureDatePage.setPriceForTwoAdult();
        String expectedPrice="2,394";
        Assert.assertTrue(actualPrice.contains(expectedPrice));
    }
}
