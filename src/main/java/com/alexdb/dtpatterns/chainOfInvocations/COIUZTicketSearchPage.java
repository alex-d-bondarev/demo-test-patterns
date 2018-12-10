package com.alexdb.dtpatterns.chainOfInvocations;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class COIUZTicketSearchPage extends COIHeaderElement implements COILoadableComponent {

    private By calendarPopup = By.xpath("//div[@class='ui-calendar-container']");
    private By dateHoverInput = By.xpath("//input[@name='date-hover']");
    private By popularDestinations = By.xpath("//a[@class='item']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By trainListBlock = By.xpath("//div[contains(@id, 'train-list')]");

    private String url = "https://booking.uz.gov.ua";

    public boolean trainListBlockExists(){
        return $(trainListBlock).exists();
    }

    public COIUZTicketSearchPage clickFirstPopularDestinations(){
        $$(popularDestinations).first().shouldBe(visible).click();
        $(calendarPopup).shouldBe(visible);
        $(dateHoverInput).shouldBe(visible).click();
        $(calendarPopup).shouldNotBe(visible);
        return this;
    }

    public COIUZTicketSearchPage clickSubmitButton(){
        $$(submitButton).filter(visible).first().click();
        $(trainListBlock).should(exist);
        return this;
    }

    public COIUZTicketSearchPage load() {
        open(url);
        return this;
    }

    public COIUZTicketSearchPage isLoaded() {
        waitForLogo();
        return this;
    }
}
