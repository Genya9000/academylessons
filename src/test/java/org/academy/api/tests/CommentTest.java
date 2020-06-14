package org.academy.api.tests;

import org.academy.TestConfigurations;
import org.academy.api.pojo.nameEvgeny.CommentPojo;
import org.academy.api.requests.CommentsRequests;
import org.academy.tools.TestNgListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(TestNgListener.class)
public class CommentTest {

    private CommentsRequests requests;

    @BeforeMethod(alwaysRun = true)
    public void initRequest(){
    requests = new CommentsRequests();}

    @Test
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
    }

    @AfterMethod(alwaysRun = true)
    public void close(){
        requests = null;
    }
}
