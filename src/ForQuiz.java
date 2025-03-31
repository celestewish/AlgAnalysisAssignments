import java.util.Random;

public class ForQuiz {
    public static void main(String[] args) {
        // Define the length of the arrays
        int length = 10; // You can change this value as needed

        // Generate two random arrays of the same length
        int[] array1 = generateRandomArray(length);
        int[] array2 = generateRandomArray(length);

        // Print the generated arrays
        System.out.println("Array 1: ");
        printArray(array1);
        System.out.println("Array 2: ");
        printArray(array2);

        // Call the intersection method
        System.out.println("Intersection of Array 1 and Array 2:");
        intersection(array1, array2); // Assuming your method prints the result itself
    }
    public static void intersection(int[] uno, int[] dos){
        mergeSort(uno, 0, uno.length-1);
        mergeSort(dos, 0, dos.length-1);
        int left1 = 0;
        int left2 = 0;
        int right1 = uno.length-1;
        int right2 = dos.length-1;
        int mid1 = (left1 + right1)/2;
        int mid2 = (left2 + right2)/2;
        boolean isIntersection = false;
        int intersection = 0;
        int counter = 0;
        while(counter < uno.length * dos.length){
            counter++;
            if (mid1 > uno.length-1 || mid2 > dos.length-1){
                isIntersection = false;
                break;
            }
            if (mid1 < 0 || mid2 < 0){
                isIntersection = false;
                break;
            }
            if(uno[mid1] == dos[mid2]){
                intersection = uno[mid1];
                isIntersection = true;
                break;
            }
            else if(uno[mid1] > dos[mid2]){
                left1++;
                mid1 = (left1 + right1)/2;
                left2++;
                mid2 = (left2 + right2)/2;
            }
            else{
                right2--;
                mid2 = (left2 + right2)/2;
                right2--;
                mid2 = (left2 + right2)/2;
            }
        }
        if (isIntersection){
            System.out.println("The intersection of the two arrays is: " + intersection);
        }
        else{
            System.out.println("The intersection of the two arrays is: No intersection");
        }
    }
    private static int[] generateRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(50) + 1; // Random numbers from 1 to 50
        }

        return array;
    }
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Recursively sort the left half
            mergeSort(array, left, mid);

            // Recursively sort the right half
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Helper method to merge two sorted subarrays
    private static void merge(int[] array, int left, int mid, int right) {
        // Sizes of the two subarrays
        int size1 = mid - left + 1;
        int size2 = right - mid;

        // Temporary arrays to hold data
        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // Copy data to temporary arrays
        for (int i = 0; i < size1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < size2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = left;

        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of the left array
        while (i < size1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of the right array
        while (j < size2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
