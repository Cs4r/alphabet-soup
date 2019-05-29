# Alphabet Soup

## Prerequisites

- Java 8.

## Main class

```
./src/main/java/cs4r/labs/alphabetsoup/AlphabetSoup.java
```

## Running the tests

```
./gradlew test
```

This project has only unit tests.

## Design decisions 

1. Algorithm is case-sensitive.

## Algorithm analysis

```
 boolean canConstruct(String message, String bowl) {

        if (bowl.length() < message.length()) { // O(1)
            return false; // O(1)
        }

        Map<Character, Integer> messageOccurrences = getOccurrencesPerCharacter(message); // O(m)

        int i = 0;

        while (!messageOccurrences.isEmpty() && i < bowl.length()) { // O(s)

            char character = bowl.charAt(i); // O(1)
            int characterCount = messageOccurrences.getOrDefault(character, 0); // O(1)

            if (characterCount > 1) { // O(1)
                messageOccurrences.put(character, characterCount - 1); // O(1)
            } else if (characterCount == 1) { // O(1)
                messageOccurrences.remove(character); // O(1)
            }
            i++; // O(1)
        }

        return messageOccurrences.size() == 0; // O(1)
    }

    private Map<Character, Integer> getOccurrencesPerCharacter(String message) {
        Map<Character, Integer> messageOccurrences = new HashMap<>(); // O(1)

        for (Character c : message.toCharArray()) { // O(m)
            if (c != ' ') { // O(1)
                if (messageOccurrences.containsKey(c)) { // O(1)
                    messageOccurrences.put(c, messageOccurrences.get(c) + 1); // O(1)
                } else { 
                    messageOccurrences.put(c, 1); // O(1)
                }
            }
        }
        return messageOccurrences; // O(1)
    }


 ```

### Time complexity

- Time complexity of the algorithm corresponds to _O(s)_. Being _s_ the number of characters in the soup. 

In the very worst case scenario we iterate the whole bowl of soup.
That's to say that the time complexity is the the number of characters in the aforementioned bowl. 


### Space complexity 

- Space complexity could be considered as constant since in the very worst case scenario we have a map with 65536 keys (_messageOccurrences_).
