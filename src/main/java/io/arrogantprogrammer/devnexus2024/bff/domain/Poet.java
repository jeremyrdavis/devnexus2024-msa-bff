package io.arrogantprogrammer.devnexus2024.bff.domain;

import java.util.Random;

public enum Poet {

    CHARLES_BAUDELAIRE("Charles Baudelaire"),
    ROBERT_FROST("Robert Frost"),
    EMILY_DICKINSON("Emily Dickinson"),
    WALT_WHITMAN("Walt Whitman"),
    LANGSTON_HUGHES("Langston Hughes"),
    MAYA_ANGELLOU("Maya Angelou"),
    RUMI("Rumi"),
    PABLO_NERUDA("Pablo Neruda"),
    WILLIAM_SHAKESPEARE("William Shakespeare"),
    SYLVIA_PLATH("Sylvia Plath"),
    EDGAR_ALLAN_POE("Edgar Allan Poe");


    public final String name;

    Poet(String name) {
        this.name = name;
    }

    public static String randomPoet() {
        return Poet.values()[new Random().nextInt(Poet.values().length - 1) + 1].name;
    }
}
