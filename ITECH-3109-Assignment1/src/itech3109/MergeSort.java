package itech3109;

/**
 * ITECH 3109 Assignment 1 - Task 2 MergeSort Algorithm Implementation Adapted
 * from the ITECH 3109 Week 3 Lecture Material
 * 
 * @author Benjamin Gardiner - Student ID: 30399545
 */
public class MergeSort {
	private long comparisons; // Counter for comparisons

	/**
	 * Sorts an array of integers in ascending order using the MergeSort algorithm.
	 * 
	 * @param values The array of integers to be sorted.
	 */
	public void mergeSort(int[] values) {
		comparisons = 0;
		mergeSortPart(values, 0, values.length - 1);

	}

	/**
	 * A recursive helper function for the MergeSort algorithm. Sorts a subarray
	 * within 'values' from 'first' to 'last'.
	 * 
	 * @param values The array to be sorted.
	 * @param first  The index of the first element in the subarray.
	 * @param last   The index of the last element in the subarray.
	 */
	private void mergeSortPart(int[] values, int first, int last) {

		// If there is more than one element in the subarray, it needs sorting
		if (first < last) {
			int middle = (first + last) / 2; // Gets the middle index of the array
			mergeSortPart(values, first, middle); // Sort the left part of the array
			mergeSortPart(values, middle + 1, last); // Sort the right part of the array
			merge(values, first, middle, last); // Merge the two sorted halves
		}
	}

	/**
	 * Merges two sorted subarrays within 'values' into a single sorted subarray.
	 * 
	 * @param values The array containing the subarrays to be merged.
	 * @param first  The index of the first element in the first subarray.
	 * @param middle The index of the last element in the first subarray.
	 * @param last   The index of the last element in the second subarray.
	 */
	private void merge(int[] values, int first, int middle, int last) {

		int[] temp = new int[last + 1]; // Temporary array to store elements during merging
		int firstArrayFirstIndex = first; // Index of the first element in the first subarray
		int firstArrayLastIndex = middle; // Index of the last element in the first subarray
		int secondArrayFirstIndex = middle + 1; // Index of the first element in the second subarray
		int secondArrayLastIndex = last; // Index of the last element in the second subarray
		int currentPosition = firstArrayFirstIndex; // Tracks the position in the temporary array

		// Compare values in the two subarrays and merge them into the temporary array
		while (firstArrayFirstIndex <= firstArrayLastIndex && secondArrayFirstIndex <= secondArrayLastIndex) {

			// Comparison between values
			comparisons++;
			if (values[firstArrayFirstIndex] < values[secondArrayFirstIndex]) {
				temp[currentPosition++] = values[firstArrayFirstIndex++];
			}				
			else {
				temp[currentPosition++] = values[secondArrayFirstIndex++];
			}
		}

		// If one subarray is exhausted but elements remain in the other, copy the
		// remaining elements to the temporary array
		while (firstArrayFirstIndex <= firstArrayLastIndex)
			temp[currentPosition++] = values[firstArrayFirstIndex++];
		while (secondArrayFirstIndex <= secondArrayLastIndex)
			temp[currentPosition++] = values[secondArrayFirstIndex++];

		// Copy elements from the temporary array back to the original array, completing
		// the merge
		for (currentPosition = first; currentPosition <= last; currentPosition++)
			values[currentPosition] = temp[currentPosition];
	}
	
	/**
	 * Prints out the number of comparisons
	 */
	public void printStats() {
	    System.out.println("Actual Comparisons: " + comparisons);
	}
	
	/**
	 * Returns the number of comparisons
	 * @return comparisons the number  of comparisons
	 */
	public long getComparisons() {
		return comparisons;
	}
}
