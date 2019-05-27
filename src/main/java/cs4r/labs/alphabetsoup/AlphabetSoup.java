package cs4r.labs.alphabetsoup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlphabetSoup {


    boolean canConstruct(String message, List<Character> bowl) {

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
        } else {

            for (Map.Entry<Character, Integer> e : messageOccurrences.entrySet()) {

                if (bowlOccurrences.getOrDefault(e.getKey(), 0) < e.getValue()) {
                    return false;
                }

            }

            return true;
        }

    }
}
