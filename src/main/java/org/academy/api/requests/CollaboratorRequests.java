package org.academy.api.requests;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.Resources;

import java.util.List;

@Slf4j
public class CollaboratorRequests extends AbstractRequests{

    public void createCollaborator(String token, int responseCode) {
        Response response = putRequests.withToken(token, responseCode, Resources.getCollaboratorName());

        log.info("Response code is: {}", response.getStatusCode());
    }

    public void deleteCollaborator(String token, int responseCode) {
        Response response = deleteRequests.withToken(token, responseCode, Resources.getCollaboratorName());

        log.info("Response code is: {}", response.getStatusCode());
    }
}
