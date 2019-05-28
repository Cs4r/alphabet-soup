package cs4r.labs.alphabetsoup;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlphabetSoupTest {


    @Test
    void emptyStringCanBeConstructedWithEmptyBowl() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("", Collections.emptyList()));
    }

    @Test
    void emptyStringCanBeConstructedWithNonEmptyBowl() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("", Arrays.asList('A', 'B', 'C')));
    }

    @Test
    void messageCannotBeConstructedIfAtLeastOneLetterIsMissingInTheBowl() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola", Arrays.asList('h', 'o', 'l')));
    }

    @Test
    void messageCanBeConstructedIfBowlContainsExactlyAllLetters() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("hola", Arrays.asList('h', 'o', 'l', 'a')));
    }

    @Test
    void messageCannotBeConstructedIfBowlContainsLessLettersThanMessage() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola que pasa", Arrays.asList('h', 'o', 'l', 'a')));
    }

    @Test
    void messageCannotBeConstructedIfBowlContainsAllLettersButOne() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola que pasa", Arrays.asList('h', 'o', 'l', 'a', 'k', 'e', 'p', 'a', 's', 'a')));
    }

    @Test
    void messageCanBeConstructedIfBowlContainsAllLetters() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("hola que pasa", Arrays.asList('h', 'o', 'l', 'a', 'q', 'u', 'e', 'p', 'a', 's', 'a')));
    }

    @Test
    void messageCannotBeConstructedIfBowlContainsAllLettersButWithDifferentFrequencies() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola que pasaaaaaaaaaaa", Arrays.asList('h', 'o', 'l', 'a', 'q', 'u', 'e', 'p', 'a', 's', 'a')));
    }

    @Test
    void canConstructIsCaseSensitive() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola", Arrays.asList('H', 'O', 'L', 'A')));
    }

    @Test
    void canConstructConsidersSymbols() {

        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("HOLA, AMIGO", Arrays.asList('H', 'O', 'L', 'A', ',', 'A', 'M', 'I', 'G', 'O')));
        assertFalse(alphabetSoup.canConstruct("HOLA, AMIGO", Arrays.asList('H', 'O', 'L', 'A', 'A', 'M', 'I', 'G', 'O')));
    }


}
