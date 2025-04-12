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

public class Heapsort {
    //counts comparisons
    public long comparisons = 0;

    //starts sorting algorithm
    public void sort(int[] arr) {
        int n = arr.length;

        //builds max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //extracts elements from heap
        for (int i = n - 1; i > 0; i--) {
            //moves root to end
            swap(arr, 0, i);
            //calls heapify on reduced heap
            heapify(arr, i, 0);
        }
    }

    //turns a subtree into a heap
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        //if left child is larger than the root, make it the root
        if (l < n) {
            comparisons++;
            if (arr[l] > arr[largest]) {
                largest = l;
            }
        }

        //if right child is larger than root, make it the root
        if (r < n) {
            comparisons++;
            if (arr[r] > arr[largest]) {
                largest = r;
            }
        }

        //if the largest is not the root, make a recursive call to gradually move it upwards
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    //used to swap values
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
