package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccessPage extends AbstractPage {
    public AccessPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//a[@href=\"/EvgenKhaliman\"]")
    private List<WebElement> collaboratorLinks;

    @FindBy(xpath = "//summary[@class='close-button btn-octicon-danger']")
    private WebElement deleteButton;

    public boolean isPresent(){
        return collaboratorLinks.get(1).isDisplayed();
    }

    public void deleteLink(){
        deleteButton.click();
    }
}

