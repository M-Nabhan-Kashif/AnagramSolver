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


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnagramSolver {

    private final Map<String, LetterInventory> words;
    /*
     * pre: dictionary != null
     * @param dictionary Contains the words to form anagrams from.
     * Creates a hashmap to store dictionary words(key) as well as LetterInventory
     * of each word(value).
     */
    public AnagramSolver(Set<String> dictionary) {
        if (dictionary == null) {
            throw new IllegalArgumentException("Dictionary can't be null.");
        }
        words = new HashMap<>();
        for (String str: dictionary) {
            words.put(str, new LetterInventory(str));
        }
    }

    /*
     * pre: maxWords >= 0, s != null, s contains at least one 
     * English letter.
     * Return a list of anagrams that can be formed from s with
     * no more than maxWords, unless maxWords is 0 in which case
     * there is no limit on the number of words in the anagram
     */
    public List<List<String>> getAnagrams(String s, int maxWords) {
        if (maxWords < 0 || s == null || s.length() < 1) {
            throw new IllegalArgumentException("maxWords is less than 0 " +
                    "or String entered is empty or null.");
        }
        LetterInventory original = new LetterInventory(s);
        ArrayList<String> currentWords = new ArrayList<>();
        for (Map.Entry<String, LetterInventory> entry : words.entrySet()) {
            if (original.subtract(entry.getValue()) != null) {
                currentWords.add(entry.getKey());
            }
        }
        Collections.sort(currentWords);
        currentWords.remove(s);
        List<List<String>> results = new ArrayList<>();
        anagramHelper(0, currentWords, new ArrayList<>(), original, maxWords, results);
        Collections.sort(results, new CompareList());
        return results;
    }

    /*
     * pre: none
     * Recursive method for anagram solver. Loops through reduced dictionary with
     * recursive calls at each word to identify all possible anagrams.
     * @param startPoint: Location in dictionary to start checking for anagram possibilities.
     * Recursively incremented in each iteration.
     * @param reducedDictionary. Dictionary containing only all possible words for the
     * required anagram.
     * @param currentAnagram. List of words currently added to possible anagram.
     * Increased list pushed in through each recursive call.
     * @param remaining: LetterInventory of all remaining letters to complete anagram.
     * @param limit: Max. number of words for anagram.
     * @param results: Final list of all possible anagrams.
     */
    private void anagramHelper(int startPoint, ArrayList<String> reducedDictionary,
                               ArrayList<String> currentAnagram, LetterInventory remaining,
                               int limit, List<List<String>> results) {
        if (remaining.isEmpty()) {
            results.add(new ArrayList<>(currentAnagram));
        }
        else if (limit == 0 || currentAnagram.size() < limit) {
            for (int i = startPoint; i < reducedDictionary.size(); i++) {
                String temp = reducedDictionary.get(i);
                LetterInventory tempInventory = remaining.subtract(words.get(temp));
                if (tempInventory != null) {
                    currentAnagram.add(temp);
                    anagramHelper(i, reducedDictionary, currentAnagram, tempInventory,
                            limit, results);
                    currentAnagram.remove(temp);
                }
            }
        }
    }

    /*
     * pre: None
     * Nested class to create a new CompareList object, which will allow us to sort
     * the list of lists/anagrams which is our final result.
     * Implements compare method.
     */
    private static class CompareList implements Comparator<List<String>> {

        /*
         * pre: o1 and o2 can't be null.
         * Compares 2 lists by size, and if size is same, then by lexographical
         * comparison of first element.
         */
        @Override
        public int compare(List<String> o1, List<String> o2) {
            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("Strings compared can't be null.");
            }
            int difference = o1.size() - o2.size();
            if (difference != 0) {
                return difference;
            }
            else {
                return o1.get(0).compareTo(o2.get(0));
            }
        }
    }

}
