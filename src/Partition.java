// Name:        Lauren Rousell
// Class:       CS 4306/03
// Term: Spring 2024
// Instructor:  Dr. Haddad
// Assignment:  2
// IDE Name:    IntelliJ
//******************************************
/*
Algorithm Design Block

Algorithm title: Partition an array into two disjoint subsets that have the same sum
    of their elements.
Logical steps:

    Step 1: Retreive array from user. Set up two Lists that will store both subsets.
    Step 2: If array is empty then return that information to the user.
    Step 3: If array values sum up to be an odd number, let the user know that the partition cannot take place.
    Step 4: If neither are true, then divide the sum of the array values and set that as an integer that will be the target value.
        After, set up an I loop to run through the array. Within this array, have an integer that
        adds the total of the current subset.
    Step 5: Set a nested loop that runs from I to the end of the array.
    Step 6: If total of the current subset equals the target value, end the loop.
    Step 7: If the current subset is empty, add the value of the array at the index that the for loop is on to the subset
        and add that value to the integer that tracks the value of the total subset.
    Step 8: If the current value is larger than the size of the subset, add the current index to the subset and
        add that value to the integer that tracks the value of the total subset.
    Step 9: If the rest aren't true and the current value isn't in the subset, add the current index to the list and add that value to the integer that tracks the value of the total subset.
    Step 10: If by the end of the nested loop the target value isn't found, then empty the sublist and reset the value that tracks the total of the subset to zero.
    Step 11: Run through these loops until all values have been visited.
    Step 12: If there is such a pair of subsets that exist whose total values equal each other, display these results. Otherwise, notify the user that such subsets
        do not exist in this array.

Pseudocode syntax:

Algorithm: Partition an array into two disjoint subsets that have the same sum
    of their elements.
Input: Array of integers inputted by the user
Output: Prints subsets found

Begin
Read Array from User
List Sublist1;
List Sublist2;
Integer targetValue = Array.Sum / 2
If Array is empty then
    Print Array is Empty
    return
If Array sum is Odd then
    Print Sum is odd, therefore no subsets exist
    return
for i <- 0 to Array length do
    Integer subsetTotal = 0
    for j <- i to Array length do
        if subsetTotal == targetSum
            break loop
        else if Sublist1.isEmpty do
            Sublist1.add(j)
            subsetTotal += Array[j]
        else if Sublist1.length < j do
            Sublist1.add(j)
            subsetTotal += Array[j]
        else if Sublist1.get(j-1) != Array[j] do
            Sublist1.add(j)
            subsetTotal += Array[j]
     End Loop
     if subsetTotal == targetSum
        for k = 0 to Array.length do
            if !Sublist1.contains(k)
                Sublist2.add(k)
        break loop
     else
        Sublist1.clear
Print array size, values of array, and subsets with same sum if they exist.
End;

******************************************/

import java.util.*;
public class Partition {
    public static void canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        List<Integer> subset = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>();
        boolean canPartition = false;
        // If total sum is odd, partitioning is impossible
        if (totalSum == 0){
            System.out.println("Array is empty");
            return;
        }
        if (totalSum % 2 != 0) {
            System.out.print("\nSet size: " + nums.length +
                    "\nInteger values: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.print("\nDisjoint subsets with the same sum: No disjoint subsets with the same sum of their elements found");
            return;
        }

        int targetSum = totalSum / 2;

        // Generate all subsets and check if any has sum = targetSum
        for (int i = 0; i < nums.length; i++) { // Iterate over all subsets
            int subsetSum = 0;

            for (int j = i; j < nums.length; j++) {
                if (subsetSum == targetSum) {
                    break;
                }
                if (subset.isEmpty()){
                    subset.add(nums[j]);
                    subsetSum += nums[j];
                }
                else if(subset.size() < j){
                    subset.add(nums[j]);
                    subsetSum += nums[j];
                }
                else if (subset.get(j-1) != nums[j]) { // Check if jth element is in subset
                    subset.add(nums[j]);
                    subsetSum += nums[j];
                }
            }

            if (subsetSum == targetSum) {
                canPartition = true;
                for (int num : nums) {
                    if (!subset.contains(num)) {
                        remaining.add(num);
                    }
                }
                break;
            }
            else{
                subset.clear();
            }
        }
        if (canPartition) {
            System.out.print("\nSet size: " + nums.length +
                    "\nInteger values: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.print("\nDisjoint subsets with the same sum: " + subset +
                            "\n                                    " + remaining);
        }
        else {
            System.out.print("\nSet size: " + nums.length +
                    "\nInteger values: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.print("\nDisjoint subsets with the same sum: No disjoint subsets with the same sum of their elements found");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[0];
        while(true){
            System.out.println("\n-----------------MAIN MENU--------------\n" +
                    "1. Read set size (number of integers)\n" +
                    "2. Read set elements (integer values)\n" +
                    "3. Run algorithm and display outputs\n" +
                    "4. Exit program\n\n" +
                    "Enter option number:");
            switch(sc.nextInt()){
                case 1:
                    sc.nextLine();
                    System.out.println("Enter number of integers:");
                    nums = new int[sc.nextInt()];
                    break;
                    case 2:
                        sc.nextLine();
                        for (int i = 0; i < nums.length; i++) {
                            System.out.println("Enter integer " + i + ":");
                            nums[i] = sc.nextInt();
                        }
                        break;
                        case 3:
                            sc.nextLine();
                            canPartition(nums);
                            break;
                            case 4:
                                System.exit(0);
                                break;
            }
        }
    }
}
