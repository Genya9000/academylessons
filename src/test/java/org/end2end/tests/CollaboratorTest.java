package org.end2end.tests;

import org.academy.TestConfigurations;
import org.academy.api.pojo.nameEvgeny.CommentPojo;
import org.academy.api.requests.CollaboratorRequests;
import org.academy.api.requests.CommentsRequests;
import org.academy.tools.TestNgListener;
import org.academy.utils.web.AbstractWebDriver;
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
    private AccessPage accessPage;

    @BeforeMethod(alwaysRun = true)
    public void initRequest(){
        requests = new CollaboratorRequests();
        MainPage mainPage = new MainPage(webDriver, true, TestConfigurations.getUrl());
        mainPage.clickOnSignIn()
                .fillLoginField(TestConfigurations.getLogin())
                .fillPassField(TestConfigurations.getPassword())
                .clickOnSubmit();
        accessPage = new AccessPage(webDriver, true, TestConfigurations.getAccessPageUri());
    }

    /*@Test
    public void getAllComments() {
        requests.getLastComment(TestConfigurations.getGitToken(), 200);
    }

    @Test
    public void createComment() {
        CommentPojo comment = new CommentPojo();
        comment.setBody("Best comment");
        String body = requests.getCreatedComment(TestConfigurations.getGitToken(), 201);
        assertThat(comment.getBody()).startsWith("Best")
                .endsWith("ent")
                .isEqualToIgnoringCase(body);
    }*/
    @Test
    public void createCollaboratorTest(){
        requests.createCollaborator(TestConfigurations.getGitToken(), 201);
        assertThat(accessPage.isPresent()).isEqualTo(true);

    }

    @AfterMethod(alwaysRun = true)
    public void close(){

        requests = null;
    }
}
