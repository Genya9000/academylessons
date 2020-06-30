package org.end2end.tests;

import org.academy.TestConfigurations;
import org.academy.api.pojo.nameEvgeny.CommentPojo;
import org.academy.api.requests.CollaboratorRequests;
import org.academy.api.requests.CommentsRequests;
import org.academy.tools.TestNgListener;
import org.academy.utils.web.AbstractWebDriver;
import org.academy.utils.web.WebHelpers;
import org.academy.web.pages.AccessPage;
import org.academy.web.pages.BasePage;
import org.academy.web.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(TestNgListener.class)
public class CollaboratorTest extends AbstractWebDriver {
    private CollaboratorRequests requests;

    @BeforeMethod(alwaysRun = true)
    public void initRequest() {
        requests = new CollaboratorRequests();
        MainPage mainPage = new MainPage(webDriver, true, TestConfigurations.getUrl());
        mainPage.clickOnSignIn()
                .fillLoginField(TestConfigurations.getLogin())
                .fillPassField(TestConfigurations.getPassword())
                .clickOnSubmit();
    }

    @Test
    public void createCollaboratorTest() {
        requests.createCollaborator(TestConfigurations.getGitToken(), 201);
        WebHelpers.refreshPage(webDriver);
        AccessPage accessPage = new AccessPage(webDriver, true, TestConfigurations.getAccessPageUri());
        assertThat(accessPage.isLinkPresent()).isEqualTo(true);
        accessPage.deleteLink();

    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        requests = null;
    }
}
