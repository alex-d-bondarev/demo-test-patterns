package com.alexdb.dtpatterns.pageElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class PECheckUZTicketTest {

    private String url = "https://booking.uz.gov.ua";
    private PEUZTicketSearchPage uzTicketSearchPage = new PEUZTicketSearchPage();


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
