package com.alexdb.dtpatterns.pageObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class POCheckUZTicketTest {

    private String url = "https://booking.uz.gov.ua";
    private POUZTicketSearchPage uzTicketSearchPage = new POUZTicketSearchPage();


    @Test
    public void trainListAppears(){
        open(url);

        uzTicketSearchPage.waitForLogo();
        Assert.assertFalse(uzTicketSearchPage.trainListBlockExists());

        uzTicketSearchPage.clickFirstPopularDestinations();
        uzTicketSearchPage.clickSubmitButton();
        Assert.assertTrue(uzTicketSearchPage.trainListBlockExists());
    }
}
