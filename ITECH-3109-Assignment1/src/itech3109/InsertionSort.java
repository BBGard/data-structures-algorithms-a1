package itech3109;

/**
 * ITECH 3109 Assignment 1 - Task 2
 * InsertionSort Algorithm
 * Adapted from the ITECH 3109 Week 3 Lecture Material
 * @author Benjamin Gardiner - 30399545
 */
public class InsertionSort {

	public void insertionSort(int[] values) {

		for (int i = 1; i < values.length; i++) {
			int currentElement = values[i];
			int j;

			// Compares next item with previous item, swaps them if the next item is smaller
			for (j = i - 1; j >= 0 && currentElement < values[j]; j--) {
				values[j + 1] = values[j];
			}
			values[j + 1] = currentElement;

		}
	}

}
