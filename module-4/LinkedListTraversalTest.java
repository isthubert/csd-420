/* Isaac St Hubert 04/12/2026 Module 4.2
 * This program stores 50,000 and 500,000 integers in a LinkedList 
 * and traverses the list using an iterator and the get(index) method*/

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversalTest {

    public static void main(String[] args) {

        // Run tests for both required sizes
        runTest(50000);
        runTest(500000);
    }

    /**
     * Runs traversal timing tests on a LinkedList of a given size
     * and verifies correctness by counting elements visited.
     * @param size
     */
    public static void runTest(int size) {

        LinkedList<Integer> list = new LinkedList<>();

        // Populate the LinkedList
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        System.out.println("\nTesting LinkedList with " + size + " integers");

        // Iterator Traversal
        int iteratorCount = 0;

        long startIterator = System.nanoTime();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iteratorCount++;
        }

        long endIterator = System.nanoTime();
        long iteratorTime = endIterator - startIterator;

        // get(index) Traversal
        int getCount = 0;

        long startGet = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
            getCount++;
        }

        long endGet = System.nanoTime();
        long getTime = endGet - startGet;

        // Test Code Verification
        if (iteratorCount == getCount && iteratorCount == size) {
            System.out.println("Verification successful: Both traversals visited "
                    + iteratorCount + " elements.");
        } else {
            System.out.println("ERROR: Traversal counts do not match.");
        }

        // Display timing results
        System.out.println("Iterator traversal time: " + iteratorTime + " nanoseconds");
        System.out.println("get(index) traversal time: " + getTime + " nanoseconds");
    }
}

/*

When traversing a LinkedList using an Iterator, the traversal
is efficient because the iterator simply moves from one element
to the next in the list.

When using get(index) with a LinkedList, each call to
get(index) must start at the beginning of the list
and traverse elements until the specified index is reached.

For 50,000 elements:
Iterator traversal completes very quickly because it only
passes through the list once.

get(index) traversal takes noticeably longer because each
access requires searching through the list again.

For 500,000 elements:
The difference becomes extremely large. Iterator traversal
still scales linearly, but get(index) grows immensely, causing a dramatic slowdown.

References:
GeeksforGeeks. (2016, October 14). Iterator in java. GeeksforGeeks. https://www.geeksforgeeks.org/java/iterators-in-java/
GeeksforGeeks. (2018, March 9). ArrayList get(index) Method in Java with Examples. GeeksforGeeks. https://www.geeksforgeeks.org/java/arraylist-get-method-java-examples/

*/