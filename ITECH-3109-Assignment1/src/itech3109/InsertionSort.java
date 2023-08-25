package itech3109;

/**
 * ITECH 3109 Assignment 1 - Task 2
 * InsertionSort Algorithm
 * Adapted from the ITECH 3109 Week 3 Lecture Material
 * @author Benjamin Gardiner - 30399545
 */
public class InsertionSort {
    int comparisons = 0; // Initialize a counter for comparisons

	public void insertionSort(int[] values) {

		for (int i = 1; i < values.length; i++) {
			int currentElement = values[i];
			int previousElementIndex;
			
			// Compares next item with previous item, swaps them if the next item is smaller
			for (previousElementIndex = i - 1; previousElementIndex >= 0 && currentElement < values[previousElementIndex]; previousElementIndex--) {
				values[previousElementIndex + 1] = values[previousElementIndex];
                comparisons++; // Increment the comparison counter
			}
			values[previousElementIndex + 1] = currentElement;

		}
        System.out.println("Number of comparisons performed: " + comparisons);

	}

}
