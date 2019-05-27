package cs4r.labs.alphabetsoup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class AlphabetSoupTest {


    @Test
    void emptyStringCanBeConstructedWithEmptyBowl() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        Assertions.assertTrue(alphabetSoup.canConstruct("", Collections.emptyList()));
    }
}
