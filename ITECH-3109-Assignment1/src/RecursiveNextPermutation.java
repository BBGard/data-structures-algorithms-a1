
/**
 * ITECH 3109 Assignment 1 - Task 1.1
 * Recursive implementation of the nextPermutation algorithm
 * @author Benjamin Gardiner - Student ID: 30399545
 */
public class RecursiveNextPermutation {
	private int callCount = 0; // simple integer to count recursive calls


	/*
	 * Task 1.1
	 * Recursive implementation of the nextPermutation algorithm
	 * @param permutation the input array to be permuted
	 * @return true if a next permutation exists, false otherwise
	 */
	public boolean nextPermutation(int[] permutation) {
		callCount++;

		// Get length of array
		int length = permutation.length;
		
		// Make sure there are at least 2 elements
		if(length < 2) {
			return false; // Only 1 permutation
		}
		
		// Find max element value and index of max element
		int max = permutation[0]; // initialize max and index to the start of array
		int index = 0;
		
		for (int i = 1; i < length; i++) {
            if (permutation[i] > max) {
                max = permutation[i];
                index = i;
            }
        }
		
	
		// Check if max is NOT the first element
		if(permutation[0] != max) {
			// If max is not the first element, swap max with element before it			
			swap(permutation, index, index-1);
			
			return true;	
		}
		else {
			 // Call nextPermutation recursively for the smaller (n-1)-element permutation
		    int[] smallerPermutation = trimArray(permutation, 1, length); // Remove the first element (a1)
		    
		    if (nextPermutation(smallerPermutation)) {
		        // If the recursive call returns true, append a1 to the obtained permutation
		        int[] newPermutation = appendToArray(smallerPermutation, permutation[0]);
		        
		        for (int i = 0; i < length; i++) {
		            permutation[i] = newPermutation[i]; // Update the original permutation
		        }
		        return true;
		    } else {
		        return false; // Recursive call returned false, so return false
		    }
			
		}
		
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
