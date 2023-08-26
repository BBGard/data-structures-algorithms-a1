package itech3109;

/**
 * ITECH 3109 Assignment 1 - Task 2 QuickSort Algorithm Implementation Adapted
 * from the ITECH 3109 Week 3 Lecture Material
 * 
 * @author Benjamin Gardiner - Student ID: 30399545
 */
public class QuickSort implements SortingAlgorithm {
    private long comparisons; // Counter for element comparisons

	/**
	 * Sorts an array of integers in ascending order using the QuickSort algorithm.
	 * 
	 * @param values The array of integers to be sorted.
	 */
	public void sort(int[] values) {
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
			comparisons++;
		}

		// Recursively sort the right subarray (elements greater than the pivot)
		if (pivot + 1 < right) {
			quickSortPart(values, pivot + 1, right);
			comparisons++;
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
		while(true) {


			while (left < right && values[left] < values[right]) {
	        	comparisons++; // Increment the element comparisons count

				right--;
			}
			
			if(left < right) {
				swap(values, left++, right);
	        	comparisons++; // Increment the element comparisons count

			} 
			else {

				return left;
			}
			
			while (left < right && values[left] < values[right]) {
	        	comparisons++; // Increment the element comparisons count

				left++;
			}
			
			if(left < right) {
				swap(values, left, right--);
	        	comparisons++; // Increment the element comparisons count

			}
			else {

				return right;
			}
		}
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

	@Override
	public String getName() {
		return "QuickSort";
	}
}
