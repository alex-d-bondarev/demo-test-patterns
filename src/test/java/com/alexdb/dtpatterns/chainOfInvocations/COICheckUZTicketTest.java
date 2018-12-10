package com.alexdb.dtpatterns.chainOfInvocations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class COICheckUZTicketTest {

    private COIUZTicketSearchPage uzTicketSearchPage = new COIUZTicketSearchPage();

    @Test
    public void trainListAppears(){
        Assert.assertFalse(
                uzTicketSearchPage
                        .load()
                        .isLoaded()
                        .trainListBlockExists());

        Assert.assertTrue(
                uzTicketSearchPage
                        .clickFirstPopularDestinations()
                        .clickSubmitButton()
                        .trainListBlockExists());
    }
}
