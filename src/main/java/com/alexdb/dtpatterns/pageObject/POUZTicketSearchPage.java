package com.alexdb.dtpatterns.pageObject;

import com.alexdb.dtpatterns.common.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class POUZTicketSearchPage implements Page{

    private By calendarPopup = By.xpath("//div[@class='ui-calendar-container']");
    private By dateHoverInput = By.xpath("//input[@name='date-hover']");
    private By popularDestinations = By.xpath("//a[@class='item']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By trainListBlock = By.xpath("//div[contains(@id, 'train-list')]");
    private By uzLogo = By.xpath("//a[@class='uz-logo']");

    public void waitForLogo(){
        $(uzLogo).shouldBe(visible);
    }

    public boolean trainListBlockExists(){
        return $(trainListBlock).exists();
    }

    public void clickFirstPopularDestinations(){
        $$(popularDestinations).first().shouldBe(visible).click();
        $(calendarPopup).shouldBe(visible);
        $(dateHoverInput).shouldBe(visible).click();
        $(calendarPopup).shouldNotBe(visible);
    }

    public void clickSubmitButton(){
        $$(submitButton).filter(visible).first().click();
        $(trainListBlock).should(exist);
    }
}
