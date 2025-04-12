// Name: Lauren Rousell
// Class: CS 4306/03
// Term: Spring 2025
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: IntelliJ

// Algorithm Design Block
/* For this assignment, we worked with three different sorting algorithms: Merge Sort, Quick Sort,
 and Heap Sort. When it comes to Merge Sort, it has a consistent speed of O(n log n). Same with
 Heap Sort. They are both stable algorithms with a consistent speed. Quick Sort on the other hand is
 an unstable algorithm. Its best and average case are both O(n log n), however, its worst case is
 O(n^2). When this happens, my compiler throws an SOE error due to its inability to handle the processing
 time for this algorithm. After these tests, I can conclude that Quick Sort is an unstable algorithm that
 is more risky to use in comparison to the other two. That being said, Quick Sort is quite fast.
 In my tests, the algorithm with the least comparisons is consistently Merge Sort. While Heap Sort is reliable,
 it is undeniably the slowest algorithm.
 */

public class Quicksort {
    //counts comparisons
    public long comparisons = 0;

    //starts quicksort
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    //quick sort algorithm that calls partitioning algorithm
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    //partitions array using last element as pivot
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        //continually swaps values
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        //swaps pivot into its proper place
        swap(arr, i + 1, high);
        return i + 1;
    }

    //method used for swaps
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
