package io.arrogantprogrammer.devnexus2024.bff.infrastructure;

import io.arrogantprogrammer.devnexus2024.bff.domain.CharacterAssignment;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/characters")
public class CharacterResource {
    static final Logger LOGGER = LoggerFactory.getLogger(CharacterResource.class);

    @Inject
    CharacterService characterService;

    @POST
    @Path("/assign")
    public Response getRandomCharacter(final String name) {
        LOGGER.info("Getting random character");
        CharacterAssignment characterAssignment = characterService.assignCharacter(name);
        return Response.ok().entity(characterAssignment).build();
    }
}
