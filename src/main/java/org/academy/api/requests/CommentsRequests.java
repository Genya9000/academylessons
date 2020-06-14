package org.academy.api.requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.Resources;

import java.util.List;

@Slf4j
public class CommentsRequests extends AbstractRequests {

    public void getLastComment(String token, int responseCode) {
        Response response = getRequests.withToken(token, responseCode, Resources.getAllComments());
        List<String> jsonResponse = response.jsonPath().getList("body");

        log.info("Last comment is: ".concat(jsonResponse.get(jsonResponse.size() - 1)));
    }

    public String getCreatedComment(String token, int responseCode) {
        Response response = postRequests.withToken(token, responseCode, Resources.getCommentFromIssue17());
        String body = response.jsonPath().getString("body");

        log.info("Created comment is : ".concat(body));
        return body;
    }

}
