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
		// Task 1.1 - Recursive nextPermutation test
//		testRecursiveNextPermutation();
		
		// Task 1.2 Iterative nextPermutation test
//		testIterativeNextPermutation();

		// Task 2 - QuickSort, MergeSort, and InsertionSort
//		testQuickSort();
//		testMergeSort();
		testInsertionSort();

	}

	private static void testRecursiveNextPermutation() {
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
	}

	private static void testIterativeNextPermutation() {
		int[] testArray = { 1, 2, 3 };
		System.out.println("\n------- TESTING ------- \nTask 1.2 - Iterative nextPermutation");
		System.out.println("NOTE: Call count should be 6");
		System.out.println("\nExpected output: \n1 2 3\n1 3 2\n2 1 3\n2 3 1\n3 1 2\n3 2 1\n");
		System.out.println("Actual output:");

		IterativeNextPermutation task1_2 = new IterativeNextPermutation();

		do {
			printArray(testArray);
		} while (task1_2.nextPermutation(testArray));

		System.out.println("\nCall count: " + task1_2.getCallCount());
		System.out.println("\n------ END TEST ------");
	}

	private static void testQuickSort() {
		// Test initial QuickSort
		QuickSort qs = new QuickSort();
		int[] arrayToSort = { 7, 2, 1, 6, 8, 5, 3, 4 };

		System.out.println("\n------- TESTING ------- \nTask 2 - QuickSort\n\nOriginal Array:");
		printArray(arrayToSort);

		qs.quickSort(arrayToSort);

		System.out.println("\nSorted Array:");
		printArray(arrayToSort);

		System.out.println("\n------ END TEST ------");

		// Element Comparison Tests
		System.out.println("\n------- TESTING ------- \nTask 2 - QuickSort Element Comparisons\n\nOriginal Array:");
		int[] smallArray = { 2, 5, 7, 3, 4, 1, 6 };

		qs.quickSort(smallArray);
		System.out.println("Element comparisons: " + qs.getElementComparisons());
	}

	private static void testMergeSort() {
		// Test initial MergeSort
		MergeSort ms = new MergeSort();
		int[] arrayToSort = { 5, 2, 7, 3, 4, 1, 6 };

		System.out.println("\n------- TESTING ------- \nTask 2 - MergeSort\n\nOriginal Array:");
		printArray(arrayToSort);

		ms.mergeSort(arrayToSort);

		System.out.println("\nSorted Array:");
		printArray(arrayToSort);

		System.out.println("\n------ END TEST ------");

	}

	/**
	 * Function to test the InsertionSort algorithm.
	 * Tests 3 different arrays for best, worst, and average case performance.
	 * Outputs the sorted array, number of swaps performed, and number of comparisons
	 */
	private static void testInsertionSort() {
		// Test initial InsertionSort
		InsertionSort is = new InsertionSort();
//		int[] arrayToSort = { 2, 5, 7, 3, 4, 1, 6 };
		int[] worstCaseArray = {  50,40,30,20,10 };
		int[] bestCaseArrray = {  10,20,30,40,50 };
		int[] averageCaseArray = {  30,20,50,10,40 };

		// Test worst case - reverse sorted array
		System.out.println("\n------- TESTING ------- \nTask 2 - InsertionSort\nWorst Case\nOriginal Array:");
		printArray(worstCaseArray);
		is.insertionSort(worstCaseArray);
		System.out.println("\nSorted Array:");
		printArray(worstCaseArray);
		is.printStats();
		System.out.println("\n------ END TEST ------");
		
		// Test best case - sorted array
		System.out.println("\n------- TESTING ------- \nTask 2 - InsertionSort\nBest Case\nOriginal Array:");
		printArray(bestCaseArrray);
		is.insertionSort(bestCaseArrray);
		System.out.println("\nSorted Array:");
		printArray(bestCaseArrray);
		is.printStats();
		System.out.println("\n------ END TEST ------");
		
		// Test average case - random sorted array
		System.out.println("\n------- TESTING ------- \nTask 2 - InsertionSort\nAverage Case\nOriginal Array:");
		printArray(averageCaseArray);
		is.insertionSort(averageCaseArray);
		System.out.println("\nSorted Array:");
		printArray(averageCaseArray);
		is.printStats();
		System.out.println("\n------ END TEST ------");

	}
}