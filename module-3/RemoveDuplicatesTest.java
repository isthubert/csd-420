/* Isaac St Hubert 04/12/2026 Module 3.2
 * This program generates an array list of random integers and returns an array list with duplicates removed*/

import java.util.ArrayList;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {

        ArrayList<Integer> originalList = new ArrayList<>();

        // Fill ArrayList with 50 random integers from 1 to 20
        for (int i = 0; i < 50; i++) {
            int num = (int)(Math.random() * 20) + 1;
            originalList.add(num);
        }

        System.out.println("Original List:");
        System.out.println(originalList);

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("\nList After Removing Duplicates:");
        System.out.println(uniqueList);
    }

    /**
     * Generic method that returns a new ArrayList with duplicates removed
     * @param list
     * @return
     * @param <E>
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> uniqueList = new ArrayList<>();

        for (E element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        return uniqueList;
    }
}