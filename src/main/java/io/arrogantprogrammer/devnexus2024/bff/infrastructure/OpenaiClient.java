package io.arrogantprogrammer.devnexus2024.bff.infrastructure;

import io.arrogantprogrammer.devnexus2024.bff.domain.*;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/openai")
public interface OpenaiClient {

    @POST
    @Path("/whois")
    WhoIsResponse whois(WhoIsRequest whoIsRequest);

    @POST
    @Path("/poem")
    PoemResponse poem(PoemRequest poemRequest);

    @POST
    @Path("/addtopoem")
    AddToPoemResponse poemWith(AddToPoemRequest addToPoemRequest);
}
