package io.arrogantprogrammer.devnexus2024.bff.domain;

import java.util.Optional;

public record CharacterAssignment(Long id, String name, String characterName, Optional<String> whoIs, Optional<String> poem, Optional<String> updatedPoem, Optional<Boolean> isLiked){

    public CharacterAssignment(Long id, String name, String characterName) {
        this(id, name, characterName, null, null, null, null);
    }
    public CharacterAssignment(Long id, String name, String characterName, String whoIs){
        this(id, name, characterName, Optional.of(whoIs), null, null, null);
    }

    public CharacterAssignment(Long id, String name, String characterName, String whoIs, String poem) {
        this(id, name, characterName, Optional.of(whoIs), Optional.of(poem), null, null);
    }

    public CharacterAssignment(Long id, String name, String characterName, String whoIs, String poem, String updatedPoem) {
        this(id, name, characterName, Optional.of(whoIs), Optional.of(poem), Optional.of(updatedPoem), null);
    }
}
