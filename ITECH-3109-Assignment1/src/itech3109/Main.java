package itech3109;

import java.util.Arrays;

/**
 * @Author: Benjamin Gardiner - 30399545
 * 
 * This is the main class for running the ITECH-3109 Assignment 1 code.
 * NOTE: Sorting algorithms used are stored in their own separate files
 */
public class Main {
	
	public static void main(String[] args) {
        int[] array = {1, 2, 3};
        
		boolean result = testNextPerm(array, array.length);

		if (result) {
			System.out.println("Next permutation: " + Arrays.toString(array));
		} else {
			System.out.println("No more permutations possible.");
		}
		
		nextPermutation(array);
    }
	
	public static boolean nextPermutation(int[] permutation) {
		int n = permutation.length; // Max element
		System.out.println("n "+n);
		
		// Check if max element is in the first position
		if(permutation[0] == n) {
			System.out.println("in first");
			if(nextPermutation(permutation))
			return false;
		}
		
		// Determine the index of the max element
		int index = -1;
		
		for(int i=0; i<n; i++) {
			if(permutation[i] == n) {
				index = i;
				System.out.println("max index: "+i);
				break;
			}
		}
		
		if(index > 1) {
			// Swap ai and ai-1
			int temp = permutation[index];
			permutation[index] = permutation[index-1];
			permutation[index-1] = temp;
			return true;
		}
		else {
			
		}
		
		return false;
	}
	
	public static boolean testNextPerm(int[] permutation, int n) {

        // Base case: if n=1, no more permutations are possible
		if (n == 1) {
			System.out.println("n=1");
            return false;
        }
		
		// If the maximal element is not in the first position
		if (permutation[n - 1] != n) {
			System.out.println("max is not first");
			// Swap maximal element with the one before it and return true
			int temp = permutation[n - 1];
			permutation[n - 1] = permutation[n - 2];
			permutation[n - 2] = temp;
            return true;
		}
		else {
			System.out.println("max is first");
			// Else, if the maximal element is the first (recursive step)
			if(testNextPerm(permutation, n-1)) {
				int temp = permutation[n - 1];
				permutation[n - 1] = permutation[n - 2];
				permutation[n - 2] = temp;
				return true;
			}
			else {
				// No more permutations
				return false;
			}
		}
		
    }

   

    
}

	// Entry point of the program
//	public static void main(String[] args) {
//
//		int[] permutation = {1,2,3};
//		
//        do {
//            for (int num : permutation) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        } while (nextPermutation(permutation));
//
//	}
//	
//	
//	public static boolean nextPermutation(int[] permutation) {
//		int n = permutation.length;	// Maximal element of permutation
//		int maxElement = n;
//		int maxElementIndex = -1;
//		
//		// Find the index of the max element
//		for(int i=0; i<n; i++) {
//			if(permutation[i] == maxElement) {
//				maxElementIndex = i;
//				break;
//			}
//		}
//		
//		
//		int maxValue = n;
//		int maxIndex = -1;
//		
//		// Find the maximal element
//		for (int i = 0; i < n; i++) {
//			if (permutation[i] == maxValue) {
//				maxIndex = i;
//				break;
//			}
//		}
//		
//		// Check if maximal element is not the first
//		if(maxIndex > 0) {
//			// Swap maximal element with the one before it and return true
//			int temp = permutation[maxIndex];
//			permutation[maxIndex] = permutation[maxIndex - 1];
//			permutation[maxIndex - 1] = temp;
//			return true;
//		}
//		else {
//			// If maximal element is the first, recursivly call the next permutation
//			if(nextPermutation(permutation)) {
//				int temp = permutation[0];
//				permutation[0] = maxValue;
//				
//				for (int i = 1; i < n - 1; i++) {
//                    permutation[i - 1] = permutation[i];
//                }
//				permutation[n-2] = temp;
//				return true;
//			}
//			else {
//				// No more permutations
//				return false;
//			}
//		}
//	}
//
//}
