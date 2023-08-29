
/**
 * ITECH 3109 Assignment 1 - Task 2
 * InsertionSort Algorithm
 * Adapted from the ITECH 3109 Week 3 Lecture Material
 * @author Benjamin Gardiner - 30399545
 */
public class InsertionSort implements SortingAlgorithm {
    private long comparisons; // Counter for comparisons

    /**
	 * Sorts an array of integers in ascending order using the InsertionSort algorithm.
	 * 
	 * @param values The array of integers to be sorted.
	 */
//    public void sort(int[] values) {
//		comparisons = 0;
//		
//		for (int i = 1; i < values.length; i++) {
//			int currentElement = values[i];
//			int previousElementIndex;
//			
//			comparisons++;
//			
//			// Compares next item with previous item, swaps them if the next item is smaller
//			for (previousElementIndex = i - 1; previousElementIndex >= 0 && currentElement < values[previousElementIndex];previousElementIndex--) {
//				// Perform a swap
//				values[previousElementIndex + 1] = values[previousElementIndex];	
//			}
//			
//			values[previousElementIndex + 1] = currentElement;
//		}
//        
//	}
	public void sort(int[] values) {
		comparisons = 0;
		
		for (int i = 1; i < values.length; i++) {
			int currentElement = values[i];
			int previousElementIndex;

			// Compares next item with previous item, swaps them if the next item is smaller
			for (previousElementIndex = i - 1; previousElementIndex >= 0; previousElementIndex--) {
				comparisons++; // Increment comparison count in each iteration
				
				// Moved the comparison inside the while loop in order to accurately count comparisons
				// Check if currentElement is smaller than previous
				if(currentElement < values[previousElementIndex]) {
					
					// Perform a swap
					values[previousElementIndex + 1] = values[previousElementIndex];					
				} else {
					break; // exit the loop
				}
				
				
			}
			values[previousElementIndex + 1] = currentElement;


		}
        
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
		return "InsertionSort";
	}
}
