package org.academy.web.pages;

import org.academy.utils.web.WebWaiters;
import org.academy.web.AbstractPage;
import org.awaitility.Awaitility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccessPage extends AbstractPage {
    public AccessPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//a[@href=\"/EvgenKhaliman\"]")
    private List<WebElement> collaboratorLinks;

    @FindBy(xpath = "//summary[@class='close-button btn-octicon-danger']")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[contains(text(), 'EvgenKhaliman')]")
    private WebElement confirmButton;

    public boolean isLinkPresent(){

        WebWaiters.waitUntilElementIsDisplayed(collaboratorLinks.get(1), 20);
        return collaboratorLinks.get(1).isDisplayed();
    }

    public void deleteLink(){
        WebWaiters.waitUntilElementIsDisplayed(deleteButton, 20);
        deleteButton.click();
        WebWaiters.waitUntilElementIsDisplayed(confirmButton, 20);
        confirmButton.click();

    }
}

