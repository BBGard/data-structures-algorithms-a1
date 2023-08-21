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
		int length = permutation.length;
		int max;
		
		// If n=ai, i>1 aka array has more than 1 element
		if(length > 1 && permutation[0] != max) {
			// Swap ai and ai-1, return true
			int temp = permutation[length-2];
			permutation[length-2] = permutation[length-1];
			permutation[length-1] = temp;
			
			printArray(permutation);
			return true;	
		}
		
		return false;
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
