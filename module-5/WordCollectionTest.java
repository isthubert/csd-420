/**
 * Isaac St Hubert 05/23/2026 Module 5.2
 * This program references a txt file and displays the words in ascending and descending order
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCollectionTest {

    public static void main(String[] args) {

        // TreeSet removes duplicates and sorts automatically
        TreeSet<String> ascendingWords = new TreeSet<>();

        File file = new File("collection_of_words.txt");

        try {
            Scanner input = new Scanner(file);

            // Read words from the file
            while (input.hasNext()) {
                ascendingWords.add(input.next());
            }

            input.close();

            // Display words in ascending order
            System.out.println("Words in Ascending Order:");
            for (String word : ascendingWords) {
                System.out.println(word);
            }

            // Display words in descending order
            System.out.println("\nWords in Descending Order:");
            for (String word : ascendingWords.descendingSet()) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}