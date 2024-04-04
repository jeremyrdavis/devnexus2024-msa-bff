package io.arrogantprogrammer.devnexus2024.bff.infrastructure;

import io.arrogantprogrammer.devnexus2024.bff.domain.CharacterRecord;

import java.net.URI;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

public class TestUtils {
    public static final String LUKE_SKYWALKER = "Luke Skywalker";

    public static final CharacterRecord LUKE_SKYWALKER_RECORD =  new CharacterRecord(
            "Luke Skywalker",
            "172",
            "77",
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male",
            "https://swapi.dev/api/planets/1/",
            Arrays.asList("https://swapi.dev/api/films/1/",
                    "https://swapi.dev/api/films/2/",
                    "https://swapi.dev/api/films/3/",
                    "https://swapi.dev/api/films/6/"),
            Collections.emptyList(),
            Arrays.asList("https://swapi.dev/api/vehicles/14/",
                    "https://swapi.dev/api/vehicles/30/"),
            Arrays.asList("https://swapi.dev/api/starships/12/",
                    "https://swapi.dev/api/starships/22/"),
            Instant.parse("2014-12-09T13:50:51.644000Z"),
            Instant.parse("2014-12-20T21:17:56.891000Z"),
            URI.create("https://swapi.dev/api/people/1/"));

}
