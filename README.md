# Data Structures and Algorithms Assignment 1
## University
### Permutations & Sorting Algorithms Implementation

#### Overview:
This programming assignment for ITECH 3109 Data Structures and Algorithms focuses on the implementation and analysis of sorting algorithms (Quicksort, Mergesort, and Insertionsort) in conjunction with the computation of the average number of element comparisons. The assignment also involves generating permutations of integer arrays using a recursive and an iterative algorithm.

#### Key Tasks:
**1. Listing all permutations of n numbers:**
- Task 1.1: Recursive algorithm nextPermutation
  - Implement a recursive function nextPermutation in Java (or C) to generate permutations.
  - The function should take an array of integers representing a permutation and return true (or 1 in C) if the array is changed to the next permutation; otherwise, return false (or 0 in C).

- Task 1.2: Iterative algorithm nextPermutationIter
  - Develop an iterative function with the same functionality as nextPermutation using only looping constructs, without recursive calls.

**2. Adding counters to Quicksort, Mergesort, and Insertionsort algorithms:**
- Modify C/Java code for Quicksort, Mergesort, and Insertionsort to count the number of element comparisons performed by each algorithm.
- Ensure correctness by testing on small arrays where results can be computed manually.

** 3. The main function (method):**
- Compute and print the average number of element comparisons for Quicksort, Mergesort, and Insertionsort when sorting 10-element integer arrays containing elements 1 to 10.
- Utilize the recursive nextPermutation for generating permutations.
- Use a variable n for the array size in the main function to allow verification on small instances (e.g., n = 3 or n = 4).
