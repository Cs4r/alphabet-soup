package cs4r.labs.alphabetsoup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlphabetSoup {


    boolean canConstruct(String message, List<Character> bowl) {

        if (message.isEmpty()) {
            return true;
        }

        Map<Character, Integer> bowlOccurrences = new HashMap<>();

        for (Character c : bowl) {
            if (bowlOccurrences.containsKey(c)) {
                bowlOccurrences.put(c, bowlOccurrences.get(c) + 1);
            } else {
                bowlOccurrences.put(c, 1);
            }
        }

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

        if (!bowlOccurrences.keySet().containsAll(messageOccurrences.keySet())) {
            return false;
        }

        return true;
    }
}
