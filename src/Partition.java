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

    Step 1: Retrieve array from user. Set up two Lists that will store both subsets.
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
        //variables
        int totalSum = Arrays.stream(nums).sum();
        List<Integer> subset1 = new ArrayList<>();
        List<Integer> subset2 = new ArrayList<>();
        boolean canPartition = false;
        //if array is empty return
        if (totalSum == 0){
            System.out.println("Array is empty");
            return;
        }
        //if total sum is odd return
        if (totalSum % 2 != 0) {
            System.out.print("\nSet size: " + nums.length +
                    "\nInteger values: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.print("\nDisjoint subsets with the same sum: No disjoint subsets with the same sum of their elements found");
            return;
        }
        //target sum is half of total sum
        int targetSum = totalSum / 2;

        //loop through all values to find subsets
        for (int i = 0; i < nums.length; i++) {
            //this tracks the sum of the current subset
            int subsetSum = 0;

            //this runs through the list again, starting at the current i value to find a subset whose sum is half of the total sum
            for (int j = i; j < nums.length; j++) {
                //if the target sum is reached, break
                if (subsetSum == targetSum) {
                    break;
                }
                //if the subset is empty add the current value to the subset
                if (subset1.isEmpty()){
                    subset1.add(nums[j]);
                    subsetSum += nums[j];
                }
                //if the subset is smaller than the size of the array then add the current value to the subset
                else if(subset1.size() < j){
                    subset1.add(nums[j]);
                    subsetSum += nums[j];
                }
                //else, make sure there are no duplicates and then add to the subset
                else if (subset1.get(j-1) != nums[j]) {
                    subset1.add(nums[j]);
                    subsetSum += nums[j];
                }
            }
            //if the target sum is reached, then add remaining values to the second subset
            if (subsetSum == targetSum) {
                canPartition = true;
                //these two loops are an oversight for when a partition is available, but all integers are the same
                for (int num : nums){
                    subset2.add(num);
                }
                for (Integer integer : subset1) {
                    subset2.remove(integer);
                }
                break;
            }
            //if not, then clear subset 1 and retry until you have iterated through the entire list
            else{
                subset1.clear();
            }
        }
        //if there is a valid partition, then print said results
        if (canPartition) {
            System.out.print("\nSet size: " + nums.length +
                    "\nInteger values: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.print("\nDisjoint subsets with the same sum: " + subset1 +
                            "\n                                    " + subset2);
        }
        //if not, then print said results
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
        //variables
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[0];
        //loop that controls interface
        while(true){
            System.out.println("\n-----------------MAIN MENU--------------\n" +
                    "1. Read set size (number of integers)\n" +
                    "2. Read set elements (integer values)\n" +
                    "3. Run algorithm and display outputs\n" +
                    "4. Exit program\n\n" +
                    "Enter option number:");
            //switch that controls choices
            switch(sc.nextInt()){
                //enter number of integers
                case 1:
                    sc.nextLine();
                    System.out.println("Enter number of integers:");
                    nums = new int[sc.nextInt()];
                    break;
                    //enter the value for each integer
                    case 2:
                        sc.nextLine();
                        for (int i = 0; i < nums.length; i++) {
                            System.out.println("Enter integer " + i + ":");
                            nums[i] = sc.nextInt();
                        }
                        break;
                        //run algorithm
                        case 3:
                            sc.nextLine();
                            canPartition(nums);
                            break;
                            //end program
                            case 4:
                                System.exit(0);
                                break;
            }
        }
    }
}
