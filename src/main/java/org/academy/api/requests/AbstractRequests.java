package org.academy.api.requests;

import org.academy.utils.api.methods.DeleteRequests;
import org.academy.utils.api.methods.GetRequests;
import org.academy.utils.api.methods.PostRequests;
import org.academy.utils.api.methods.PutRequests;

public class AbstractRequests {
    GetRequests getRequests = new GetRequests();
    PostRequests postRequests = new PostRequests();
    PutRequests putRequests = new PutRequests();
    DeleteRequests deleteRequests = new DeleteRequests();
}
