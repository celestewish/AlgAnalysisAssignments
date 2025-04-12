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

public class Mergesort {
    //counts comparisons
    public long comparisons = 0;

    //starts the recursive merge sort
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    //divides the array
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            //divides
            int mid = (left + right) / 2;
            //sorts first and second half
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            //merges each half
            merge(arr, left, mid, right);
        }
    }

    //merges both halves
    private void merge(int[] arr, int left, int mid, int right) {
        //stores each half of the array
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        //copies data to these arrays
        System.arraycopy(arr, left, leftArr, 0, leftArr.length);
        System.arraycopy(arr, mid + 1, rightArr, 0, rightArr.length);

        //merges both arrays together
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            comparisons++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        //copies remaining elements
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
}
