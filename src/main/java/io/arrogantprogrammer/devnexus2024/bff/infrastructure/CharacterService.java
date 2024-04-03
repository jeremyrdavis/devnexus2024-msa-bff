package io.arrogantprogrammer.devnexus2024.bff.infrastructure;

import io.arrogantprogrammer.devnexus2024.bff.domain.CharacterAssignment;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class CharacterService {

    static final Logger LOGGER = LoggerFactory.getLogger(CharacterService.class);

    @RestClient
    SwapiClient swapiClient;

    public CharacterAssignment assignCharacter(final String name) {
        String characterName = swapiClient.getRandomCharacter();
        CharacterAssignment characterAssignment = new CharacterAssignment(name, characterName);
        LOGGER.debug("Assigned {} to {}", characterName, name);
        return characterAssignment;
    }
}
