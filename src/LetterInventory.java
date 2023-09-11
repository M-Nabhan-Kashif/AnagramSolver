/* CS 314 STUDENTS: FILL IN THIS HEADER.
 *
 * Student information for assignment: Mohammad Kashif
 *
 *  On my honor, Mohammad Kashif, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: mnk665
 *  email address: mohammadnkashif@utexas.edu
 *  TA name: Pranav Chandupatla
 *  Number of slip days I am using: 1
 */

public class LetterInventory {
    private static final int ALPHABET_START = 'a';
    private static final int ALPHABET_END = 'z';
    private static final int ALPHABET_LENGTH = 26;

    // Instance Variables
    private final int[] letterReps;
    private int size;

    /*
     * pre: word != null
     * @param word Contains the word to form anagrams from.
     * Constructs a LetterInventory object using the number of repetitions of each
     * character in the string, stored an array of ALPHABET_LENGTH objects.
     */
    public LetterInventory(String word) {
       if (word == null) {
           throw new IllegalArgumentException("Word cannot be null.");
       }
       size = 0;
       letterReps = new int[ALPHABET_LENGTH];
       for (int i = 0; i < word.length(); i++) {
            char temp = Character.toLowerCase(word.charAt(i));
            if (ALPHABET_START <= temp && temp <= ALPHABET_END) {
                letterReps[temp - ALPHABET_START] += 1;
                size++;
            }
       }
    }

    /*
     * pre: word != null
     * Creates an empty LetterInventory object by calling this with an empty string.
     * Logic and pre of @this method applied.
     */
    public LetterInventory() {
        this("");
    }

    /*
     * pre: none
     * Returns size of LetterInventory object.
     */
    public int size () {
        return size;
    }

    /*
     * pre: none
     * @param letter: The letter we need to find number of repetitions for.
     * Returns the number of times a given letter is present in the LetterInventory.
     */
    public int get (char letter) {
        return letterReps[Character.toLowerCase(letter) - ALPHABET_START];
    }

    /*
     * pre: none
     * Returns boolean value for if the LetterInventory is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * pre: none
     * Returns a string representation of the LetterInventory object
     * with letters present in alphabetic order.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            for (int j = 0; j < letterReps[i]; j++) {
                str.append((char) (i + ALPHABET_START));
            }
        }
        return str.toString();
    }

    /*
     * pre: second != null
     * Adds the values contained in the letterReps array of a parameter LetterInventory
     * object to the current LetterInventory Object. Both LetterInventory objects remain unaltered.
     * Returns a new LetterInventory containing the sum of values of both inventories.
     */
    public LetterInventory add(LetterInventory second) {
        if (second == null) {
            throw new IllegalArgumentException("LetterInventory object cannot be null.");
        }
        LetterInventory result = new LetterInventory();
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            result.letterReps[i] = letterReps[i] + second.letterReps[i];
        }
        result.size = size + second.size;
        return result;
    }

    /*
     * pre: second != null
     * Subtracts the values contained in the letterReps array of a parameter LetterInventory
     * object from the current LetterInventory Object. Both LetterInventory objects remain
     * unaltered. Returns a new LetterInventory containing the difference of values of both
     * inventories. Returns null if any difference is negative.
     */
    public LetterInventory subtract(LetterInventory second) {
        if (second == null) {
            throw new IllegalArgumentException("LetterInventory object cannot be null.");
        }
        LetterInventory result = new LetterInventory();
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            int temp = letterReps[i] - second.letterReps[i];
            if (temp >= 0) {
                result.letterReps[i] = temp;
            }
            else {
                return null;
            }
        }
        result.size = size - second.size;
        return result;
    }

    /*
     * pre: none
     * @param Second LetterInventory object to test equality with.
     * Determines if the current LetterInventory is equivalent to a second LetterInventor object.
     * Matches each element of the LetterReps array to determine equivalency.
     * Returns boolean true/false.
     */
    public boolean equals(Object second) {
        if (!(second instanceof LetterInventory)) {
            return false;
        }
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            if (letterReps[i] != ((LetterInventory)second).letterReps[i]) {
                return false;
            }
        }
        return true;
    }

}
