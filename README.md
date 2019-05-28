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
boolean canConstruct(String message, List<Character> bowl) {

    Map<Character, Integer> bowlOccurrences = new HashMap<>(); // O(1)

    for (Character c : bowl) { // O(s)
        if (bowlOccurrences.containsKey(c)) { // O(1)
            bowlOccurrences.put(c, bowlOccurrences.get(c) + 1); // O(1)
        } else {
            bowlOccurrences.put(c, 1); // O(1)
        }
    }

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


    for (Map.Entry<Character, Integer> e : messageOccurrences.entrySet()) { // Very worst case scenario: O(65536) 

        if (bowlOccurrences.getOrDefault(e.getKey(), 0) < e.getValue()) { // O(1)
            return false; // O(1)
        }

    }

    return true; // O(1)
}
    
 ```

### Time complexity

- Time complexity of the algorithm corresponds to _max(0(m), O(s))_. That's to say that the time complexity is the maximum between the message length and the number of letters in the bowl of soup. 


### Space complexity 

- Space complexity could be considered as constant since in the very worst case scenario we would have two maps with 65536 keys each.
