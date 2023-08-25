package itech3109;

/**
 * ITECH 3109 Assignment 1 - Task 2 QuickSort Algorithm Implementation Adapted
 * from the ITECH 3109 Week 3 Lecture Material
 * 
 * @author Benjamin Gardiner - Student ID: 30399545
 */
public class QuickSort {
    private int comparisons; // Counter for element comparisons

	/**
	 * Sorts an array of integers in ascending order using the QuickSort algorithm.
	 * 
	 * @param values The array of integers to be sorted.
	 */
	public void quickSort(int[] values) {
        comparisons = 0; // Initialize the element comparisons counter
		quickSortPart(values, 0, values.length - 1);
	}

	/**
	 * Recursively sorts a subarray of integers between specified left and right
	 * indices.
	 * 
	 * @param values The array to be sorted.
	 * @param left   The left index of the subarray.
	 * @param right  The right index of the subarray.
	 */
	private void quickSortPart(int[] values, int left, int right) {
		// Partition the array and get the pivot index
		int pivot = partition(values, left, right);
		
		// Recursively sort the left subarray (elements less than the pivot)
		if (left < pivot - 1) {
			quickSortPart(values, left, pivot - 1);
		}

		// Recursively sort the right subarray (elements greater than the pivot)
		if (pivot + 1 < right) {
			quickSortPart(values, pivot + 1, right);
		}
	}

	/**
	 * Rearranges the elements in the subarray so that elements less than the pivot
	 * are on the left and elements greater than the pivot are on the right.
	 * 
	 * @param values The array to be partitioned.
	 * @param left   The left index of the subarray.
	 * @param right  The right index of the subarray.
	 * @return The pivot index after partitioning.
	 */
	private int partition(int[] values, int left, int right) {
		int pivotValue = values[(left + right) / 2]; // Choose the pivot element
		
		while (left <= right) {
        	comparisons++; // Increment the element comparisons count

			// Find the first element from the left greater than the pivot
			while (values[left] < pivotValue)
				left++;
            	comparisons++; // Increment the element comparisons count


			// Find the first element from the right smaller than the pivot
			while (values[right] > pivotValue)
				right--;
            	comparisons++; // Increment the element comparisons count


			// Swap the elements if needed
			if (left <= right) {
            	comparisons++; // Increment the element comparisons count

				swap(values, left, right);
				left++;
				right--;
			}
		}
		return left - 1; // Return the pivot index after partitioning
	}

	/**
	 * Swaps two elements in an array.
	 * 
	 * @param array       The array in which elements will be swapped.
	 * @param firstIndex  The index of the first element to be swapped.
	 * @param secondIndex The index of the second element to be swapped.
	 */
	private void swap(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
	
	/**
     * Get the number of element comparisons performed during the sorting process.
     * 
     * @return The count of element comparisons.
     */
    public int getElementComparisons() {
        return comparisons;
    }

}
