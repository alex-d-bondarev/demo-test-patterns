package com.alexdb.dtpatterns.pageComponents;

import com.alexdb.dtpatterns.common.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PCUZTicketSearchPage extends PCHeaderElement implements Page {

    private By calendarPopup = By.xpath("//div[@class='ui-calendar-container']");
    private By dateHoverInput = By.xpath("//input[@name='date-hover']");
    private By popularDestinations = By.xpath("//a[@class='item']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By trainListBlock = By.xpath("//div[contains(@id, 'train-list')]");

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
