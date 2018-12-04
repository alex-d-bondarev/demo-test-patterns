package com.alexdb.dtpatterns.basic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CheckUZTicketTest {

    private By calendarPopup = By.xpath("//div[@class='ui-calendar-container']");
    private By dateHoverInput = By.xpath("//input[@name='date-hover']");
    private By popularDestinations = By.xpath("//a[@class='item']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By trainListBlock = By.xpath("//div[contains(@id, 'train-list')]");
    private By uzLogo = By.xpath("//a[@class='uz-logo']");

    private String url = "https://booking.uz.gov.ua";



    @Test
    public void trainListAppears(){
        open(url);
        $(uzLogo).shouldBe(visible);
        $(trainListBlock).shouldNot(exist);

        $$(popularDestinations).first().shouldBe(visible).click();
        $(calendarPopup).shouldBe(visible);
        $(dateHoverInput).shouldBe(visible).click();
        $(calendarPopup).shouldNotBe(visible);

        $$(submitButton).filter(visible).first().click();

        $(trainListBlock).should(exist);
    }



    @Test
    public void trainListAppearsWithComments(){
        // Navigate to UZ.gov
        open(url);

        // UZ icon should be visible
        $(uzLogo).shouldBe(visible);

        // Train list should not exist yet
        $(trainListBlock).shouldNot(exist);

        // Click first popular destination
        $$(popularDestinations).first().shouldBe(visible).click();
        $(calendarPopup).shouldBe(visible);
        $(dateHoverInput).shouldBe(visible).click();
        $(calendarPopup).shouldNotBe(visible);

        // Click Submit button
        $$(submitButton).filter(visible).first().click();

        // Train list should exist now
        $(trainListBlock).should(exist);
    }
}
