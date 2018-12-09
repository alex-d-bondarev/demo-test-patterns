package com.alexdb.dtpatterns.loadableComponent;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LCCheckUZTicketTest {

    private LCUZTicketSearchPage uzTicketSearchPage = new LCUZTicketSearchPage();


    @Test
    public void trainListAppears(){
        uzTicketSearchPage.load();
        uzTicketSearchPage.isLoaded();

        Assert.assertFalse(uzTicketSearchPage.trainListBlockExists());

        uzTicketSearchPage.clickFirstPopularDestinations();
        uzTicketSearchPage.clickSubmitButton();
        Assert.assertTrue(uzTicketSearchPage.trainListBlockExists());
    }
}
