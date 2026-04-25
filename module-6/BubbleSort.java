/* Isaac St Hubert 04/24/2026 Module 6.2
 * This program uses bubble sort with the comparable and comparator interface to sort an array 
 */

import java.util.Comparator;
import java.util.Arrays;

public class BubbleSort {

    /**
     * Bubble sort using Comparable interface.
     * Sorts the array in ascending order.
     *
     * @param list the array to sort
     * @param <E> the generic type
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {

        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1 - i; j++) {

                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Bubble sort using Comparator interface.
     * Sorts the array using custom comparison logic.
     *
     * @param list the array to sort
     * @param comparator the Comparator object
     * @param <E> the generic type
     */
    public static <E> void bubbleSort(E[] list, Comparator<E> comparator) {

        for (int i = 0; i < list.length - 1; i++) {

            for (int j = 0; j < list.length - 1 - i; j++) {

                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        // Test Comparable with Integer
        Integer[] numbers = {5, 3, 8, 1, 9, 2};

        System.out.println("Before sorting (Comparable):");
        System.out.println(Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("After sorting (Comparable):");
        System.out.println(Arrays.toString(numbers));


        // Test Comparator with descending order
        Integer[] numbers2 = {5, 3, 8, 1, 9, 2};

        System.out.println("\nBefore sorting (Comparator):");
        System.out.println(Arrays.toString(numbers2));

        bubbleSort(numbers2, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a; // descending order
            }
        });

        System.out.println("After sorting (Comparator - Descending):");
        System.out.println(Arrays.toString(numbers2));
    }
}