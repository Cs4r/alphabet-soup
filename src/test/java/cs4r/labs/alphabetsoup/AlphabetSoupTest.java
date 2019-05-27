package cs4r.labs.alphabetsoup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class AlphabetSoupTest {


    @Test
    void emptyStringCanBeConstructedWithEmptyBowl() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        Assertions.assertTrue(alphabetSoup.canConstruct("", Collections.emptyList()));
    }

    @Test
    void emptyStringCanBeConstructedWithNonEmptyBowl() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        Assertions.assertTrue(alphabetSoup.canConstruct("", Arrays.asList('A', 'B', 'C')));
    }
}
