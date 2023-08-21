package itech3109;

/**
 * @Author: Benjamin Gardiner - 30399545
 * 
 * This is the main class for running the ITECH-3109 Assignment 1 code.
 * NOTE: Algorithms used are stored in their own separate files
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArray = {1,2,3};
		
		nextPermutation(testArray);

	}
	
	private static boolean nextPermutation(int[] permutation) {
		
		// Make sure there are at least 2 elements
		if(permutation.length < 2) {
			return false; // Only 1 permutation
		}
		
		// Find max element value and index
		int max = permutation[0]; // initialize max at the start of array
		int index = 0;
		
		for (int i = 1; i < permutation.length; i++) {
            if (permutation[i] > max) {
                max = permutation[i];
                index = i;
            }
        }
		
        System.out.println("Max is: " + max);

		
		// If max is not the first element, swap max with element before it
		if(permutation[0] != max) {
			int temp = permutation[index-1];
			permutation[index-1] = max;
			permutation[index] = temp;
			
			printArray(permutation);
			return true;	
		}
		else {
			// Permutation step
			
		}
		
		return false;
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
