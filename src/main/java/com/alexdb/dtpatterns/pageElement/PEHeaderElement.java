package com.alexdb.dtpatterns.pageElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PEHeaderElement {
    private By uzLogo = By.xpath("//a[@class='uz-logo']");

    public void waitForLogo(){
        $(uzLogo).shouldBe(visible);
    }
}
