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

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class testAdvancedSorting {
    //array that stores the size of data sets we will be using
    static int[] sizes = {1000, 10000, 100000, 1000000};
    //this array stores the populated data
    //first index represents how its populated (0 = rand, 1 = inc, 2 = dec)
    //second represents the size we are using
    //third holds the data that will be sorted
    static int[][][] allData = new int[3][4][];
    //this array stores the results of the sorting
    static long[][][] results = new long[3][3][4]; // [arrayType][algorithm][sizeIndex]

    public static void main(String[] args) {
        //scanner
        Scanner scanner = new Scanner(System.in);
        //loop that controls interface
        while (true) {
            System.out.println("\n--------MAIN MENU-------\n" +
                    "1. Populate All Arrays\n" +
                    "2. Run Algorithms\n" +
                    "3. Display outputs\n" +
                    "4. Exit program\n\n" +
                    "Enter option number:");
            //switch that controls decisions
            switch (scanner.nextInt()) {
                case 1 -> populateMenu(scanner);
                case 2 -> runAlgorithms();
                case 3 -> displayOutputs();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    //this method populates the secondary menu that is used for case 1 above
    private static void populateMenu(Scanner scanner) {
        System.out.println("\n--------Option 1 Submenu-----------\n" +
                "1. Randomly generated integers\n" +
                "2. Increasing integer from 1 to n\n" +
                "3. Decreasing integers from n to 1\n\n" +
                "Enter option number:");
        //switch statement allows the user to swap between different ways of creating arrays
        switch (scanner.nextInt()) {
            case 1 -> populateAllArrays("random");
            case 2 -> populateAllArrays("increasing");
            case 3 -> populateAllArrays("decreasing");
            default -> System.out.println("Invalid option.");
        }
    }

    //populates with random integers
    public static void RandomIntegers(int[] arr, int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }
    }

    //populates with incrementing integers
    public static void IncreasingIntegers(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
    }

    //populates with decrementing integers
    public static void DecreasingIntegers(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
    }

    //this method populates the arrays with the above methods and stores them in the array variables
    //used throughout this class
    public static void populateAllArrays(String type) {
        //loop cycles between each array by size
        for (int i = 0; i < sizes.length; i++) {
            //variables that store the array used in the methods and the size of said array
            int n = sizes[i];
            int[] array = new int[n];

            //runs each method based on user choice
            switch (type) {
                case "random" -> RandomIntegers(array, n);
                case "increasing" -> IncreasingIntegers(array, n);
                case "decreasing" -> DecreasingIntegers(array, n);
            }

            //stores each value into array that stores unsorted data
            switch (type) {
                case "random" -> allData[0][i] = array.clone();
                case "increasing" -> allData[1][i] = array.clone();
                case "decreasing" -> allData[2][i] = array.clone();
            }
        }

        System.out.println("Arrays populated successfully with " + type + " integers.");
    }

    //this method runs each sorting algorithm on the arrays
    //for large data sets, this might take a while
    public static void runAlgorithms() {
        for (int dataType = 0; dataType < 3; dataType++) {
            for (int i = 0; i < sizes.length; i++) {
                //this array stores the information in the array we are currently sdorting
                int[] original = allData[dataType][i];
                if (original == null) continue;

                //mergesort
                try {
                    //creates a copy of the array storing the original data and runs it through the algorithm
                    int[] copy = Arrays.copyOf(original, original.length);
                    Mergesort ms = new Mergesort();
                    ms.sort(copy);
                    //stores the results in the results array
                    results[dataType][0][i] = ms.comparisons;
                } catch (StackOverflowError e) {
                    //if there is a stack overflow error, it is caught here
                    results[dataType][0][i] = -1;
                }

                //quicksort
                try {
                    //creates a copy of the array storing the original data and runs it through the algorithm
                    int[] copy = Arrays.copyOf(original, original.length);
                    Quicksort qs = new Quicksort();
                    qs.sort(copy);
                    //stores the results in the results array
                    results[dataType][1][i] = qs.comparisons;
                } catch (StackOverflowError e) {
                    //if there is a stack overflow error, it is caught here
                    results[dataType][1][i] = -1;
                }

                //heapsort
                try {
                    //creates a copy of the array storing the original data and runs it through the algorithm
                    int[] copy = Arrays.copyOf(original, original.length);
                    Heapsort hs = new Heapsort();
                    hs.sort(copy);
                    //stores the results in the results array
                    results[dataType][2][i] = hs.comparisons;
                } catch (StackOverflowError e) {
                    //if there is a stack overflow error, it is caught here
                    results[dataType][2][i] = -1;
                }
            }
        }

        System.out.println("Sorting complete.");
    }

    //this method displays the outputs
    public static void displayOutputs() {
        //holds the titles of each table
        String[] arrayTypes = {"Random", "Increasing", "Decreasing"};
        String[] algoNames = {"Mergesort", "Quicksort", "Heapsort"};

        for (int dataType = 0; dataType < 3; dataType++) {
            //prints out results in the table format you provided
            System.out.println("\nArray Type: " + arrayTypes[dataType]);
            System.out.println("Algorithm   n=1000   n=10000   n=100000   n=1000000");
            System.out.println("------------------------------------------------------------");

            for (int algo = 0; algo < 3; algo++) {
                System.out.printf("%-10s", algoNames[algo]);
                for (int sizeIndex = 0; sizeIndex < 4; sizeIndex++) {
                    long comp = results[dataType][algo][sizeIndex];
                    if (comp == -1) {
                        System.out.printf(" %-8s", "SOE");
                    } else {
                        System.out.printf(" %-8d", comp);
                    }
                }
                System.out.println();
            }

            System.out.println();
        }
    }
}
