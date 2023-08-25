package itech3109;

/**
 * ITECH 3109 Assignment 1 - Task 2
 * InsertionSort Algorithm
 * Adapted from the ITECH 3109 Week 3 Lecture Material
 * @author Benjamin Gardiner - 30399545
 */
public class InsertionSort {
    int comparisons; // Counter for comparisons
    int swaps;		 // Counter for swaps

    /**
	 * Sorts an array of integers in ascending order using the InsertionSort algorithm.
	 * 
	 * @param values The array of integers to be sorted.
	 */
	public void insertionSort(int[] values) {
		comparisons = 0;
		swaps = 0;
		
		for (int i = 1; i < values.length; i++) {
			int currentElement = values[i];
			int previousElementIndex;
//            comparisons++; // Increment comparison count in each iteration

			// Compares next item with previous item, swaps them if the next item is smaller
			for (previousElementIndex = i - 1; previousElementIndex >= 0; previousElementIndex--) {
				comparisons++; // Increment comparison count in each iteration
				
				// Moved the comparison inside the while loop in order to accurately count comparisons
				// Check if currentElement is smaller than previous
				if(currentElement < values[previousElementIndex]) {
					
					// Perform a swap
					values[previousElementIndex + 1] = values[previousElementIndex];
					swaps++; // Increment swap count when a swap occurs
				} else {
					break; // exit the loop
				}
				
				
			}
			values[previousElementIndex + 1] = currentElement;


		}
        
	}
    
	/**
	 * Prints out the number of swaps and comparisons
	 */
	public void printStats() {
		System.out.println("\nSwaps: " + swaps);
	    System.out.println("Comparisons: " + comparisons);
	}
}
