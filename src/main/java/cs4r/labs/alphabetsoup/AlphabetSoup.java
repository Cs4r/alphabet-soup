package cs4r.labs.alphabetsoup;

import java.util.List;

public class AlphabetSoup {


    boolean canConstruct(String message, List<Character> bowl) {

        if (message.isEmpty()) {
            return true;
        }

        if (bowl.size() < message.length()) {
            return false;
        }

        for (Character c : message.toCharArray()) {
            if (!bowl.contains(c)) {
                return false;
            }
        }

        return true;
    }
}
