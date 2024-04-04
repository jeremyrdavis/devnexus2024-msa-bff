package io.arrogantprogrammer.devnexus2024.bff.infrastructure;

import io.arrogantprogrammer.devnexus2024.bff.domain.CharacterRecord;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient @Consumes(MediaType.TEXT_PLAIN)
public interface SwapiClient {

    @GET
    @Path("/swapi/person")
    CharacterRecord getRandomCharacter();
}
