package io.arrogantprogrammer.devnexus2024.bff.infrastructure;

import io.arrogantprogrammer.devnexus2024.bff.domain.*;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class DevnexusService {

    private static final Logger LOGGER = getLogger(DevnexusService.class);

    private AtomicLong id = new AtomicLong(0);
    @RestClient
    OpenaiClient openaiClient;

    @RestClient
    SwapiClient swapiClient;

    public CharacterAssignment assignCharacter(final String name) {
        CharacterRecord characterRecord = swapiClient.getRandomCharacter();
        CharacterAssignment updatedCharacterAssignment = new CharacterAssignment(id.addAndGet(1), name, characterRecord.name());
        LOGGER.debug("Assigned {} to {}", updatedCharacterAssignment.characterName(), updatedCharacterAssignment.name());
        return updatedCharacterAssignment;
    }

    public CharacterAssignment whoIs(CharacterAssignment characterAssignment) {
        LOGGER.debug("Getting whois information");
        WhoIsResponse whoIsResponse = openaiClient.whois(new WhoIsRequest(characterAssignment.characterName()));
        CharacterAssignment updatedCharacterAssignment = new CharacterAssignment(characterAssignment.id(), characterAssignment.name(), characterAssignment.characterName(), whoIsResponse.whoIs());
        return updatedCharacterAssignment;
    }

    public CharacterAssignment poem(CharacterAssignment characterAssignment) {
        LOGGER.debug("Getting poem information");
        PoemResponse poemResponse = openaiClient.poem(new PoemRequest(characterAssignment.characterName(), Poet.randomPoet()));
        CharacterAssignment updatedCharacterAssignment = new CharacterAssignment(characterAssignment.id(), characterAssignment.name(), characterAssignment.characterName(), characterAssignment.whoIs().get(), poemResponse.poem());
        return updatedCharacterAssignment;
    }

    public CharacterAssignment addToPoem(CharacterAssignment characterAssignment) {
        LOGGER.debug("Getting poem information");
        AddToPoemResponse addToPoemResponse = openaiClient.poemWith(new AddToPoemRequest(characterAssignment.poem().get(), PoeticAddition.randomAddition()));
        LOGGER.debug("Received poem with topic: {}", addToPoemResponse.poemWithTopic());
        CharacterAssignment updatedCharacterAssignment = new CharacterAssignment(characterAssignment.id(), characterAssignment.name(), characterAssignment.characterName(), characterAssignment.whoIs().get(), addToPoemResponse.poem(), addToPoemResponse.poemWithTopic());
        return updatedCharacterAssignment;
    }

    public CharacterAssignment like(CharacterAssignment characterAssignment) {
        LOGGER.debug("Getting like information");
        CharacterAssignment updatedCharacterAssignment = new CharacterAssignment(characterAssignment.id(), characterAssignment.name(), characterAssignment.characterName(), characterAssignment.whoIs(), characterAssignment.poem(), characterAssignment.poem(), Optional.of(Boolean.TRUE));
        return updatedCharacterAssignment;
    }
}
