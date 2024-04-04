package io.arrogantprogrammer.devnexus2024.bff.domain;

import java.util.Random;

public enum PoeticAddition {

    KITTENS("kittens"),
    LAWNGNOMES("lawn gnomes"),
    PUPPIES("puppies"),
    UNICORNS("unicorns"),
    KLINGONS("Klingons"),
    BRITTANYSPEARS("Brittany Spears"),
    JAVASCRIPT("JavaScript"),
    SINGLEMALTTSCOTCH("single malt Scotch"),
    EDDIEMURPHY("Eddie Murphy"),
    HARRYSTYLES("Harry Styles"),
    HARRYKANE("Harry Kane"),
    BEEFJERKY("beef jerky"),
    ROLLERCOASTERS("roller coasters");

    public final String addition;

    PoeticAddition(String addition) {
        this.addition = addition;
    }

    public static String randomAddition() {
        return PoeticAddition.values()[new Random().nextInt(PoeticAddition.values().length - 1) + 1].addition;
    }
}
