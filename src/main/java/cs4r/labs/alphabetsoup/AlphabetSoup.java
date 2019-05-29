package cs4r.labs.alphabetsoup;

import java.util.HashMap;
import java.util.Map;

public class AlphabetSoup {


    boolean canConstruct(String message, String bowl) {

        if (bowl.length() < message.length()) {
            return false;
        }

        Map<Character, Integer> messageOccurrences = getOccurrencesPerLetter(message);

        Map<Character, Integer> bowlOccurrences = getOccurrencesPerLetter(bowl);

        for (Map.Entry<Character, Integer> e : messageOccurrences.entrySet()) {

            if (bowlOccurrences.getOrDefault(e.getKey(), 0) < e.getValue()) {
                return false;
            }

        }

        return true;
    }

    private Map<Character, Integer> getOccurrencesPerLetter(String message) {
        Map<Character, Integer> messageOccurrences = new HashMap<>();

        for (Character c : message.toCharArray()) {
            if (c != ' ') {
                if (messageOccurrences.containsKey(c)) {
                    messageOccurrences.put(c, messageOccurrences.get(c) + 1);
                } else {
                    messageOccurrences.put(c, 1);
                }
            }
        }
        return messageOccurrences;
    }
}
