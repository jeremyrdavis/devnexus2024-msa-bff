package io.arrogantprogrammer.devnexus2024.bff.infrastructure;

import io.arrogantprogrammer.devnexus2024.bff.domain.CharacterAssignment;
import io.arrogantprogrammer.devnexus2024.bff.domain.PoemRequest;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@Path("/devnexus2024")
public class DevnexusResource {

    private static final Logger LOGGER = getLogger(DevnexusResource.class);

    @Inject
    DevnexusService devnexusService;

    @POST
    @Path("/assign")
    public Response getRandomCharacter(final String name) {
        LOGGER.info("Getting random character");
        CharacterAssignment characterAssignment = devnexusService.assignCharacter(name);
        return Response.ok().entity(characterAssignment).build();
    }


    @POST
    @Path("/whois")
    public Response whois(CharacterAssignment characterAssignment) {
        LOGGER.info("Getting whois information");
        CharacterAssignment updatedCharacterAssignment = devnexusService.whoIs(characterAssignment);
        LOGGER.debug("Returning whois information for {}", updatedCharacterAssignment.characterName());
        return Response.ok().entity(updatedCharacterAssignment).build();
    }

    @POST
    @Path("/poem")
    public Response poem(CharacterAssignment characterAssignment) {
        CharacterAssignment characterAssignmentWithPoem = devnexusService.poem(characterAssignment);
        LOGGER.debug("Returning poem information for {}", characterAssignmentWithPoem);
        return Response.ok().entity(characterAssignmentWithPoem).build();
    }

    @POST
    @Path("/addtopoem")
    public Response addToPoem(CharacterAssignment characterAssignment) {
        CharacterAssignment characterAssignmentWithUpdatedPoem = devnexusService.addToPoem(characterAssignment);
        LOGGER.debug("Returning poem information for {}", characterAssignmentWithUpdatedPoem);
        return Response.ok().entity(characterAssignmentWithUpdatedPoem).build();
    }

}
