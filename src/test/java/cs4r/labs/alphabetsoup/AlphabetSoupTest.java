package cs4r.labs.alphabetsoup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlphabetSoupTest {


    @Test
    void emptyStringCanBeConstructedWithEmptyBowl() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("", ""));
    }

    @Test
    void emptyStringCanBeConstructedWithNonEmptyBowl() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("", "ABC"));
    }

    @Test
    void messageCannotBeConstructedIfAtLeastOneLetterIsMissingInTheBowl() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola", "hol"));
    }

    @Test
    void messageCanBeConstructedIfBowlContainsExactlyAllLetters() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("hola", "hola"));
    }

    @Test
    void messageCannotBeConstructedIfBowlContainsLessLettersThanMessage() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola que pasa", "hola"));
    }

    @Test
    void messageCannotBeConstructedIfBowlContainsAllLettersButOne() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola que pasa", "hola ke pasa"));
    }

    @Test
    void messageCanBeConstructedIfBowlContainsAllLetters() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("hola que pasa", "hola que pasa"));
    }

    @Test
    void messageCannotBeConstructedIfBowlContainsAllLettersButWithDifferentFrequencies() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola que pasaaaaaaaaaaa", "hola que pasa"));
    }

    @Test
    void canConstructIsCaseSensitive() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertFalse(alphabetSoup.canConstruct("hola", "HOLA"));
    }

    @Test
    void canConstructConsidersSymbols() {

        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("HOLA, AMIGO", "HOLA, AMIGO"));
        assertFalse(alphabetSoup.canConstruct("HOLA, AMIGO", "HOLA AMIGO"));
    }

    @Test
    void messageCanBeConstructedIfVeryLargeInputContainsAllLettersOfMessage() {
        AlphabetSoup alphabetSoup = new AlphabetSoup();

        assertTrue(alphabetSoup.canConstruct("hola amigo", "aaaaaaaaaaaaaaaaaaaaaa_______-hola___________amigo____opqrstuvwxyzaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

    }


}
