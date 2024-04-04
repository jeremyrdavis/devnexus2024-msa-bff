package io.arrogantprogrammer.devnexus2024.bff.infrastructure;

import io.arrogantprogrammer.devnexus2024.bff.domain.CharacterAssignment;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@QuarkusTest
public class SpiritCharacterResourceTest {
    static final Logger LOGGER = LoggerFactory.getLogger(SpiritCharacterResourceTest.class);

    @InjectMock
    DevnexusService mockDevnexusService;

    @BeforeEach
    public void setup() {
        LOGGER.info("Setting up tests");
        when(mockDevnexusService.assignCharacter(anyString())).thenReturn(new CharacterAssignment(3L, "Buddy", TestUtils.LUKE_SKYWALKER));
    }

    @Test
    public void testGetRandomCharacter() {
        given()
                .with().body("Buddy")
                .when().post("/devnexus2024/assign")
                .then()
                .statusCode(200)
                .body("characterName", is(TestUtils.LUKE_SKYWALKER));
    }
}
