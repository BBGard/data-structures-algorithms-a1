package itech3109;

/**
 * This is the main class for running the ITECH-3109 Assignment 1 code.
 * 
 * @author Benjamin Gardiner - Student ID: 30399545
 * 
 *         NOTE: Algorithms used are stored in their own separate files as
 *         listed below:
 * 
 *         Task 1.1 - RecursiveNextPermutation.java Task 1.2 -
 *         IterativeNextPermutation.java Task 2 - QuikSort.java, MergeSort.java,
 *         InsertionSort.java
 */
public class Main {

	/**
	 * Main method to run tests.
	 */
	public static void main(String[] args) {
		// Testing
		runTests();
	}

	/**
	 * Helper function to print all elements in an array.
	 * 
	 * @param array the array to be printed
	 */
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	/**
	 * Runs tests on all algorithms
	 */
	private static void runTests() {
		// Task 1.1 - Recursive nextPermutation
		RecursiveNextPermutation task1_1 = new RecursiveNextPermutation();
		int[] testArray = { 1, 2, 3 };
		System.out.println("\n------- TESTING ------- \nTask 1.1 - Recursive nextPermutation");
		System.out.println("Expected output: \n1 2 3\n1 3 2\n3 1 2\n2 1 3\n2 3 1\n3 2 1\n");
		System.out.println("Actual output:");

		do {
			printArray(testArray);
		} while (task1_1.nextPermutation(testArray));

		System.out.println("\nCall count: " + task1_1.getCallCount());
		System.out.println("\n------ END TEST ------");

		// Task 1.2 Iterative nextPermutation
		int[] testArray2 = { 1, 2, 3 };
		System.out.println("\n------- TESTING ------- \nTask 1.2 - Iterative nextPermutation");
		System.out.println("NOTE: Call count should be 6");
		System.out.println("\nExpected output: \n1 2 3\n1 3 2\n2 1 3\n2 3 1\n3 1 2\n3 2 1\n");
		System.out.println("Actual output:");

		IterativeNextPermutation task1_2 = new IterativeNextPermutation();

		do {
			printArray(testArray2);
		} while (task1_2.nextPermutation(testArray2));

		System.out.println("\nCall count: " + task1_2.getCallCount());
		System.out.println("\n------ END TEST ------");

		// Task 2 - QuickSort, MergeSort, and InsertionSort
		// Test initial QuickSort
		QuickSort qs = new QuickSort();
		int[] arrayToSort1 = { 7, 2, 1, 6, 8, 5, 3, 4 };

		System.out.println("\n------- TESTING ------- \nTask 2 - QuickSort\n\nOriginal Array:");
		printArray(arrayToSort1);

		qs.quickSort(arrayToSort1);

		System.out.println("\nSorted Array:");
		printArray(arrayToSort1);

		System.out.println("\n------ END TEST ------");
		
		// Test initial MergeSort
		MergeSort ms = new MergeSort();
		int[] arrayToSort2 = { 5, 2, 7, 3, 4, 1, 6 };

		System.out.println("\n------- TESTING ------- \nTask 2 - MergeSort\n\nOriginal Array:");
		printArray(arrayToSort2);

		ms.mergeSort(arrayToSort2);

		System.out.println("\nSorted Array:");
		printArray(arrayToSort2);

		System.out.println("\n------ END TEST ------");
		
		// Test initial MergeSort
		InsertionSort is = new InsertionSort();
		int[] arrayToSort3 = { 2, 5, 7, 3, 4, 1, 6 };

		System.out.println("\n------- TESTING ------- \nTask 2 - InsertionSort\n\nOriginal Array:");
		printArray(arrayToSort3);

		is.insertionSort(arrayToSort3);

		System.out.println("\nSorted Array:");
		printArray(arrayToSort3);

		System.out.println("\n------ END TEST ------");
		
	}

}