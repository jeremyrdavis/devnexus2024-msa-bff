package io.arrogantprogrammer.devnexus2024.bff.domain;

import java.util.Optional;

public record CharacterAssignment(String name, String characterName, Optional<String> whoIs, Optional<String> poem, Optional<String> updatedPoem, Optional<Boolean> isLiked){

    public CharacterAssignment(String name, String characterName) {
        this(name, characterName, null, null, null, null);
    }
    public CharacterAssignment(String name, String characterName, String whoIs){
        this(name, characterName, Optional.of(whoIs), null, null, null);
    }

    public CharacterAssignment(String name, String characterName, String whoIs, String poem) {
        this(name, characterName, Optional.of(whoIs), Optional.of(poem), null, null);
    }

    public CharacterAssignment(String name, String characterName, String whoIs, String poem, String updatedPoem) {
        this(name, characterName, Optional.of(whoIs), Optional.of(poem), Optional.of(updatedPoem), null);
    }
}
