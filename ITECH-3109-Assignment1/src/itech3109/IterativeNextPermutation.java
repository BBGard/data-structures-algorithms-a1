/**
 * 
 */
package itech3109;

/**
 * ITECH 3109 Assignment 1 - Task 1.2
 * Iterative implementation of the nextPermutation algorithm
 * @author Benjamin Gardiner - 30399545
 */
public class IterativeNextPermutation {
	private int callCount = 0; // simple integer to count calls

	/*
     * Task 1.2
     * Iterative implementation of the nextPermutation algorithm
     * @param permutation the input array to be permuted
     * @return true if a next permutation exists, false otherwise
     */
    private boolean nextPermutation(int[] permutation) {
        callCount++;

        // Get length of array
        int length = permutation.length;

        // Make sure there are at least 2 elements
        if (length < 2) {
            return false; // Only 1 permutation
        }

        // Find the first element that is smaller than the element to its right
        int currentIndex = length - 2;
        while (currentIndex >= 0 && permutation[currentIndex] >= permutation[currentIndex + 1]) {
            currentIndex--;
        }

        // If no such element is found, it means it's the last permutation
        if (currentIndex < 0) {
            reverse(permutation, 0, length - 1);
            return false;
        }

        // Find the smallest element to the right of currentIndex that is greater than permutation[currentIndex]
        int nextIndex = length - 1;
        while (permutation[nextIndex] <= permutation[currentIndex]) {
            nextIndex--;
        }

        // Swap permutation[currentIndex] and permutation[nextIndex]
        swap(permutation, currentIndex, nextIndex);

        // Reverse the elements to the right of currentIndex
        reverse(permutation, currentIndex + 1, length - 1);

        return true;
    }
	
	/**
     * Reverses the elements in an array between start and end indices (inclusive).
     * 
     * @param array  the array to be reversed
     * @param start the starting index
     * @param end   the ending index
     */
	public void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
	
	/**
     * Swaps two elements in an array.
     * 
     * @param array the array in which elements are to be swapped
     * @param i     the index of the first element
     * @param j     the index of the second element
     */
	private void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	
	 /**
     * Trims an array from a start index to an end index and returns the resulting array.
     * 
     * @param array the input array
     * @param start the starting index (inclusive)
     * @param end   the ending index (exclusive)
     * @return the trimmed array
     */
	private int[] trimArray(int[] array, int start, int end) {

		// Calculate the size of the trimmed array
		int newSize = end - start;
		
		// Create new array - copy from start to end
        int[] result = new int[newSize];
        
        for (int i = start; i < end; i++) {
            result[i - start] = array[i];
        }  
		// Return smaller array
		return result;
	}
	
	 /**
     * Appends an element to an array by increasing its size by one.
     * 
     * @param array           the input array
     * @param elementToAppend the element to append
     * @return the new array with the element appended
     */
	private int[] appendToArray(int[] array, int elementToAppend) {

		// Create new array of size length+1 
		int[] result = new int[array.length+1];
		
		// Copy contents of array to new array
		for(int i = 0; i < result.length-1; i++) {
			result[i] = array[i];
		}
		
		// Append elementToAppend to the new array, and return
		result[result.length-1] = elementToAppend;
		
		return result;
		
	}
	
	/**
	 * Returns the number of recursive calls
	 * @return callCount the number of times the function has been called
	 */
	public int getCallCount() {
		return callCount;
	}
}
