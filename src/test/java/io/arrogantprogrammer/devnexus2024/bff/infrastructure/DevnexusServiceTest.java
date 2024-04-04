package io.arrogantprogrammer.devnexus2024.bff.infrastructure;

import io.arrogantprogrammer.devnexus2024.bff.domain.CharacterAssignment;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.when;

@QuarkusTest
public class DevnexusServiceTest {
    static final Logger LOGGER = LoggerFactory.getLogger(DevnexusServiceTest.class);
    @InjectMock
    @RestClient
    SwapiClient mockSwapiClient;

    @Inject
    DevnexusService devnexusService;

    @BeforeEach
    public void setup() {
        LOGGER.info("Setting up tests");
        when(mockSwapiClient.getRandomCharacter()).thenReturn(TestUtils.LUKE_SKYWALKER_RECORD);
    }

    @Test
    public void testRandomCharacter() {
        LOGGER.info("Testing random character");
        CharacterAssignment characterAssignment = devnexusService.assignCharacter("Buddy");
        assert characterAssignment.characterName().equals(TestUtils.LUKE_SKYWALKER);
        assert characterAssignment.name().equals("Buddy");
    }
}
