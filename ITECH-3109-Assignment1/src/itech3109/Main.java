package itech3109;

/**
 * @Author: Benjamin Gardiner - 30399545
 * 
 * This is the main class for running the ITECH-3109 Assignment 1 code.
 * NOTE: Algorithms used are stored in their own separate files
 */
public class Main {
	private static int callCount = 0;

	public static void main(String[] args) {
		// Testing
		int[] testArray = {1,2,3};
		
		do {
			printArray(testArray);
		} while (nextPermutation(testArray));
		
		System.out.println("Call count: "+callCount);
	}
	
	
	private static boolean nextPermutation(int[] permutation) {
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
//			int temp = permutation[index-1];
//			permutation[index-1] = max;
//			permutation[index] = temp;
			
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
	
	public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
	
	private static void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	
	// Trims array from start index to end index and returns the resulting array
	private static int[] trimArray(int[] array, int start, int end) {

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
	
	// Takes an array, increases its size by one and appends elementToAppend onto it
	private static int[] appendToArray(int[] array, int elementToAppend) {

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
	
	// Helper function to print all elements in an array
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

}