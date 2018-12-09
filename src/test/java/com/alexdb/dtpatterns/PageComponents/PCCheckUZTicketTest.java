package com.alexdb.dtpatterns.PageComponents;

import com.alexdb.dtpatterns.pageComponents.PCUZTicketSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class PCCheckUZTicketTest {

    private String url = "https://booking.uz.gov.ua";
    private PCUZTicketSearchPage uzTicketSearchPage = new PCUZTicketSearchPage();


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
