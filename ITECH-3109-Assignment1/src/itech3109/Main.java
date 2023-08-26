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
		// Initial Testing
//		runTests();
		
		// Task 3
		int n = 3; // Size of array to test
		int[] testArray = {1, 2, 3}; // The array to test
		long totalComparisons = 0;	// Total number of comparisons
		double averageComparisons = 0.0;// Average number of comparisons
		RecursiveNextPermutation permutationGenerator = new RecursiveNextPermutation();

		
		// Compute and print out the average number of element comparisons for each sorting algorithm.
		// QuickSort
		QuickSort qs = new QuickSort(); // QuickSort algorithm
		
		// Run QuickSort for all permutations, calculating totalComparisons
		do {
			printArray(testArray);
			qs.quickSort(testArray);
			totalComparisons += qs.getComparisons();
		} while (permutationGenerator.nextPermutation(testArray));
		
		
		// Calculate averageComparisons
		averageComparisons = totalComparisons/factorial(n);
		System.out.println("Factorial(n): " + factorial(n));
		// Print results
		System.out.println("Total comparisons: " + totalComparisons);
		System.out.println("Average comparisons: ");
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
	 * Recursive function to calculate the factorial of a number
	 * @param n the number to calculate the factorial of
	 * @return n!
	 */
	public static long factorial(int n) {
	    if (n < 0) {
	        throw new IllegalArgumentException("Factorial is undefined for negative numbers.");
	    }
	    
	    if (n == 0 || n == 1) {
	        return 1;
	    } else {
	        return n * factorial(n - 1);
	    }
	}

	/**
	 * Runs tests on all algorithms
	 */
	private static void runTests() {
		// Task 1.1 - Recursive nextPermutation test
		testRecursiveNextPermutation();
		
		// Task 1.2 Iterative nextPermutation test
		testIterativeNextPermutation();

		// Task 2 - QuickSort, MergeSort, and InsertionSort
		testQuickSort();
		testMergeSort();
		testInsertionSort();

	}

	private static void testRecursiveNextPermutation() {
		RecursiveNextPermutation task1_1 = new RecursiveNextPermutation();
		int[] testArray = { 1, 2, 3};
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
		// Best case number of comparisons = nlog(n)
		// Average case numberr of comparisons = 1.39nlog(n)
		// Worst case number of comparisons = n2/2
		QuickSort qs = new QuickSort();
		int[] worstCaseArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // Worst case
		int[] averageCaseArray = { 2, 10, 3, 9, 1, 8, 5, 7, 6, 4 }; // AVG/best case
		
		int nWorst = worstCaseArray.length;
		int nAverage = averageCaseArray.length;
		
		long expectedComparisonsWorst = (nWorst * nWorst) / 2;
		long expectedComparisonsAverage = Math.round(1.39 * (nAverage * (Math.log(nAverage) / Math.log(2)))); // 1.39 * N * log2(N)
		long expectedComparisonsBest = Math.round(nAverage * (Math.log(nAverage) / Math.log(2))); //N * log2(N)

		// Worst Case
		System.out.println("\n------- TESTING ------- \nTask 2 - QuickSort\nWorst Case\nOriginal Array:");
		printArray(worstCaseArray);

		qs.quickSort(worstCaseArray);

		System.out.println("\nSorted Array:");
		printArray(worstCaseArray);
		System.out.println("\nExpected number of comparisons is approx N2/2 or: " + expectedComparisonsWorst);

		qs.printStats();
		System.out.println("\n------ END TEST ------");
		
		// Best/Average Case
		System.out.println("\n------- TESTING ------- \nTask 2 - QuickSort\nBest/Average Case\nOriginal Array:");
		printArray(averageCaseArray);

		qs.quickSort(averageCaseArray);

		System.out.println("\nSorted Array:");
		printArray(averageCaseArray);
		System.out.println("\nExpected number of comparisons is approx Nlog2(N) < 1.39Nlog2(N) or between: " + expectedComparisonsBest + " and " + expectedComparisonsAverage);

		qs.printStats();
		System.out.println("\n------ END TEST ------");

	}

	private static void testMergeSort() {
		// Test initial MergeSort
		// Number of merge sort comparisons  ~  Nlog2N
		MergeSort ms = new MergeSort();
		int[] arrayToSort = { 5, 2, 7, 3, 4, 1, 6 };
		int n = arrayToSort.length;	// length of array to calculate expected comparisons
	    long expectedComparisons = Math.round(n * (Math.log(n) / Math.log(2))); // N * log2(N)


		System.out.println("\n------- TESTING ------- \nTask 2 - MergeSort\n\nOriginal Array:");
		printArray(arrayToSort);

		ms.mergeSort(arrayToSort);

		System.out.println("\nSorted Array:");
		printArray(arrayToSort);
		
		System.out.println("\nExpected number of comparisons is approx Nlog2(N) or: " + expectedComparisons);
		ms.printStats();

		System.out.println("\n------ END TEST ------");

	}

	/**
	 * Function to test the InsertionSort algorithm.
	 * Tests 3 different arrays for best, worst, and average case performance.
	 * Outputs the sorted array, number of swaps performed, and number of comparisons
	 */
	private static void testInsertionSort() {
		// Test initial InsertionSort
		// Minimum number of insertion sort comparisons  =  N - 1
		// Maximum number of insertion sort comparisons  =  1/2(N2 - N)
		// Average number of insertion sort comparisons  =  1/4(N2 - N)
		
		InsertionSort is = new InsertionSort();
//		int[] arrayToSort = { 2, 5, 7, 3, 4, 1, 6 };
		int[] worstCaseArray = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] bestCaseArrray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };;
		int[] averageCaseArray = {  7, 10, 3, 6, 8, 2, 5, 9, 1, 4 };
		
		int nWorst = worstCaseArray.length;
		int nBest = bestCaseArrray.length;
		int nAverage = averageCaseArray.length;
		long expectedComparisonsWorst = Math.round(0.5 * ((nBest * nBest) - nBest));
		long expectedComparisonsBest = nWorst - 1;
		long expectedComparisonsAverage = Math.round(0.25 * ((nBest * nBest) - nBest));

		// Test worst case - reverse sorted array
		System.out.println("\n------- TESTING ------- \nTask 2 - InsertionSort\nWorst Case\nOriginal Array:");
		printArray(worstCaseArray);
		is.insertionSort(worstCaseArray);
		System.out.println("\nSorted Array:");
		printArray(worstCaseArray);
		System.out.println("\nExpected number of comparisons is approx 1/2(N2 - N) or: " + expectedComparisonsWorst);
		is.printStats();
		System.out.println("\n------ END TEST ------");
		
		// Test best case - sorted array
		System.out.println("\n------- TESTING ------- \nTask 2 - InsertionSort\nBest Case\nOriginal Array:");
		printArray(bestCaseArrray);
		is.insertionSort(bestCaseArrray);
		System.out.println("\nSorted Array:");
		printArray(bestCaseArrray);
		System.out.println("\nExpected number of comparisons is approx N - 1 or: " + expectedComparisonsBest);
		is.printStats();
		System.out.println("\n------ END TEST ------");
		
		// Test average case - random sorted array
		System.out.println("\n------- TESTING ------- \nTask 2 - InsertionSort\nAverage Case\nOriginal Array:");
		printArray(averageCaseArray);
		is.insertionSort(averageCaseArray);
		System.out.println("\nSorted Array:");
		printArray(averageCaseArray);
		System.out.println("\nExpected number of comparisons is approx 1/4(N2 - N) or: " + expectedComparisonsAverage);
		is.printStats();
		System.out.println("\n------ END TEST ------");

	}
}