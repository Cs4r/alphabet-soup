package cs4r.labs.alphabetsoup;

import java.util.HashMap;
import java.util.Map;

public class AlphabetSoup {


    boolean canConstruct(String message, String bowl) {

        if (bowl.length() < message.length()) {
            return false;
        }

        Map<Character, Integer> messageOccurrences = getOccurrencesPerLetter(message);

        int i = 0;

        while (!messageOccurrences.isEmpty() && i < bowl.length()) {

            char character = bowl.charAt(i);
            int characterCount = messageOccurrences.getOrDefault(character, 0);

            if (characterCount > 1) {
                messageOccurrences.put(character, characterCount - 1);
            } else if (characterCount == 1) {
                messageOccurrences.remove(character);
            }
            i++;
        }

        return messageOccurrences.size() == 0;
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
