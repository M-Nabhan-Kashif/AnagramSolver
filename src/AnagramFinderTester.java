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

public class AnagramFinderTester {
    private static final String dictionaryFileName = "d3.txt";

    /**
     * main method that executes tests.
     * @param args Not used.
     */
    public static void main(String[] args) {
        cs314StudentTestsForLetterInventory();
    }

    // 22 Test cases for all public methods.
    private static void cs314StudentTestsForLetterInventory() {

        //Test 1: Constructor
        LetterInventory test1 = new LetterInventory("ABCDEHGF");
        if (test1.toString().equals("abcdefgh")) {
            System.out.println("Passed test 1: Standard constructor");
        }
        else {
            System.out.println("Failed test 1: Standard constructor");
        }

        //Test 2: Constructor
        if (test1.size() == 8) {
            System.out.println("Passed test 2: Standard constructor");
        }
        else {
            System.out.println("Failed test 2: Standard constructor");
        }

        //Test 3: Empty Constructor
        test1 = new LetterInventory();
        if (test1.toString().equals("")) {
            System.out.println("Passed test 3: Empty constructor");
        }
        else {
            System.out.println("Failed test 3: Empty constructor");
        }

        //Test 4: Empty Constructor
        if (test1.size() == 0) {
            System.out.println("Passed test 4: Empty constructor");
        }
        else {
            System.out.println("Failed test 4: Empty constructor");
        }

        // Test 5: LetterInventory Size
        test1 = new LetterInventory("Mohammad Nabhan Kashif");
        Object expected = 20;
        Object actual = test1.size();
        if (expected == actual) {
            System.out.println("Passed test 5: LetterInventory Size");
        }
        else {
            System.out.println("Failed test 5: LetterInventory Size");
        }

        // Test 6: LetterInventory Size
        test1 = new LetterInventory("Nabhan Kashif");
        expected = 12;
        actual = test1.size();
        if (expected == actual) {
            System.out.println("Passed test 6: LetterInventory Size");
        }
        else {
            System.out.println("Failed test 6: LetterInventory Size");
        }

        // Test 7: LetterInventory Get Method
        test1 = new LetterInventory("Mohammad Nabhan Kashif");
        expected = 5;
        actual = test1.get('a');
        if (expected == actual) {
            System.out.println("Passed test 7: LetterInventory Get Method");
        }
        else {
            System.out.println("Failed test 7: LetterInventory Get Method");
        }

        // Test 8: LetterInventory Get Method
        expected = 0;
        actual = test1.get('g');
        if (expected == actual) {
            System.out.println("Passed test 8: LetterInventory Get Method");
        }
        else {
            System.out.println("Failed test 8: LetterInventory Get Method");
        }

        // Test 9: LetterInventory isEmpty Method
        expected = false;
        actual = test1.isEmpty();
        if (expected == actual) {
            System.out.println("Passed test 9: LetterInventory isEmpty Method");
        }
        else {
            System.out.println("Failed test 9: LetterInventory isEmpty Method");
        }

        // Test 10: LetterInventory isEmpty Method
        test1 = new LetterInventory();
        expected = true;
        actual = test1.isEmpty();
        if (expected == actual) {
            System.out.println("Passed test 10: LetterInventory isEmpty Method");
        }
        else {
            System.out.println("Failed test 10: LetterInventory isEmpty Method");
        }

        // Test 11: LetterInventory toString Method
        test1 = new LetterInventory("cdeab");
        expected = "abcde";
        actual = test1.toString();
        if (expected.equals(actual)) {
            System.out.println("Passed test 11: LetterInventory toString Method");
        }
        else {
            System.out.println("Failed test 11: LetterInventory toString Method");
        }

        // Test 12: LetterInventory toString Method
        test1 = new LetterInventory("qrstuv");
        expected = "qrstuv";
        actual = test1.toString();
        if (expected.equals(actual)) {
            System.out.println("Passed test 12: LetterInventory toString Method");
        }
        else {
            System.out.println("Failed test 12: LetterInventory toString Method");
        }

        // Test 13: LetterInventory Add Method
        test1 = new LetterInventory("abcd");
        LetterInventory test2 = new LetterInventory("aabbccddee");
        expected = "aaabbbcccdddee";
        actual = test1.add(test2).toString();
        if (expected.equals(actual)) {
            System.out.println("Passed test 13: LetterInventory Add Method");
        }
        else {
            System.out.println("Failed test 13: LetterInventory Add Method");
        }

        // Test 14: LetterInventory Add Method
        test1 = new LetterInventory();
        test2 = new LetterInventory("aabbccddee");
        expected = "aabbccddee";
        actual = test1.add(test2).toString();
        if (expected.equals(actual)) {
            System.out.println("Passed test 14: LetterInventory Add Method");
        }
        else {
            System.out.println("Failed test 14: LetterInventory Add Method");
        }

        // Test 15: LetterInventory Subtract Method
        test1 = new LetterInventory("aabbccdd");
        test2 = new LetterInventory("aaabbbcccdddeee");
        actual = test1.subtract(test2);
        if (actual == null) {
            System.out.println("Passed test 15: LetterInventory Subtract Method");
        }
        else {
            System.out.println("Failed test 15: LetterInventory Subtract Method");
        }

        // Test 16: LetterInventory Subtract Method
        expected = "abcdeee";
        actual = test2.subtract(test1).toString();
        if (expected.equals(actual)) {
            System.out.println("Passed test 16: LetterInventory Subtract Method");
        }
        else {
            System.out.println("Failed test 16: LetterInventory Subtract Method");
        }

        // Test 17: LetterInventory Equals Method
        test1 = new LetterInventory("aabbccdd");
        test2 = new LetterInventory("ddbbaacc");
        expected = true;
        actual = test1.equals(test2);
        if (expected == actual) {
            System.out.println("Passed test 17: LetterInventory Equals Method");
        }
        else {
            System.out.println("Failed test 17: LetterInventory Equals Method");
        }

        // Test 18: LetterInventory Equals Method
        test1 = new LetterInventory("aabbccddff");
        test2 = new LetterInventory("ddbbaacc");
        expected = false;
        actual = test1.equals(test2);
        if (expected == actual) {
            System.out.println("Passed test 18: LetterInventory Equals Method");
        }
        else {
            System.out.println("Failed test 18: LetterInventory Equals Method");
        }

        // Test 19: AnagramSolver Constructor
        AnagramSolver solver = new AnagramSolver(AnagramMain.readWords(dictionaryFileName));
        if (solver.getAnagrams("hello", 3) != null) {
            System.out.println("Passed test 19: AnagramSolver Constructor");
        }
        else {
            System.out.println("Failed test 19: AnagramSolver Constructor");
        }

        // Test 20: AnagramSolver Constructor
        solver = new AnagramSolver(AnagramMain.readWords(dictionaryFileName));
        if (solver.getAnagrams("hi there", 0) != null) {
            System.out.println("Passed test 20: AnagramSolver Constructor");
        }
        else {
            System.out.println("Failed test 20: AnagramSolver Constructor");
        }

        // Test 21: getAnagrams Method
        if (solver.getAnagrams("cafe", 2).get(0).get(0).equals("cafe") &&
                solver.getAnagrams("cafe", 2).get(1).get(0).equals("face")) {
            System.out.println("Passed test 21: getAnagrams Method");
        }
        else {
            System.out.println("Failed test 21: getAnagrams Method");
        }

        // Test 22: getAnagrams Method
        if (solver.getAnagrams("cafe", 1).get(0).get(0).equals("cafe") &&
                solver.getAnagrams("cafe", 1).get(0).size() == 1) {
            System.out.println("Passed test 22: getAnagrams Method");
        }
        else {
            System.out.println("Failed test 22: getAnagrams Method");
        }

    }
}
