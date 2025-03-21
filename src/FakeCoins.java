// Name: Lauren Rousell
// Class: CS 4306/03
// Term: Spring 2025
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: IntelliJ

/*
        Algorithm Design Block

        Algorithm title: Find the fake coin

        Logical steps:
            Step 1: Generate an array that represents coins with one randomly generated to be a fake coin.
            Step 2: Identify the left side, right side, and middle of the array.
            Step 3: Compare the left half of the array to the right half and see which side is lighter.
            Step 4: Ignore the heavier half of the array, and repeat the algorithm until there is one coin left to examine.
            Step 5: If both sides weigh the same, this means that the leftmost coin is the only one left to examine and is the fake coin.
            Otherwise, the last coin available is the fake coin.

        Pseudocode syntax:

        Algorithm: Find the fake coin
        Input: Integer value that determines array size (number of coins).
        Output: Displays the array size, the fake coin location, and number of trials needed.
        Begin
            int[] coins = new int[inputNumber];
            int randomCoin = random integer;
            int fakeCoinIndex;
            int weighings;
            for i <- 0 to coins.length do
                if (i == randomCoin)
                    coins[i] = 5;
                else
                    coins[i] = 10;
            End loop
            int l = 0;
            int r = coins.length;
            int mid = (r-l)/2;
            int sumLeft;
            int sumRight;
            while (true)
                if (1 index left to compare)
                    fakeCoin = mid;
                    break
                sumLeft = sum array values from l to mid
                sumRight = sum array values from mid to right
                weighings++;
                if (sumLeft == sumRight)
                    fakeCoin = l;
                    break;
                else if (sumLeft < sumRight)
                    r = mid;
                    mid = (r-l)/2;
                else
                    l = mid;
                    mid = (r-l)/2;
             Print out size of array, fake coin index, and number of weighings
        End;
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class FakeCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCoins = 0;
        while(true) {
            System.out.println("\n\n-----------------MAIN MENU---------------------------\n" +
                    "1. Read number of coins\n" +
                    "2. Run algorithm and display output\n" +
                    "3. Exit program\n\n" +
                    "Enter option number:");
            switch(sc.nextInt()) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter number of coins to read:");
                    numberOfCoins = sc.nextInt();
                    break;
                    case 2:
                        sc.nextLine();
                        FakeCoin(numberOfCoins);
                        break;
                        case 3:
                            System.exit(0);
                            break;
            }
        }
    }
    public static void FakeCoin(int coinNum){
        //variables
        int[] coins = new int[coinNum];
        int randomCoin = new Random().nextInt(coinNum);
        int fakeCoin;
        int weighing = 0;
        //initializes array that has random fake coin in it
        for (int i = 0; i < coinNum; i++){
            if (i == randomCoin){
                coins[i] = 5;
            }
            else{
                coins[i] = 10;
            }
        }
        //stores the left side, right side, mid, and initializes the variables that will hold the sum
        int l = 0;
        int r = coinNum;
        int mid = (l+r)/2;
        int sumLeft = 0;
        int sumRight = 0;
        //loops through array
        while (true){
            //if there is only one coin left, then that coin is mid and it is the fake coin
            if ((r - l + 1) == 1){
                fakeCoin = mid;
                break;
            }
            //if the selection of the array is odd, then that will be accounted for in the calculation
            if ((r - l) % 2 != 0){
                sumLeft = Arrays.stream(Arrays.copyOfRange(coins, l, mid)).sum() + coins[mid];
                sumRight = Arrays.stream(Arrays.copyOfRange(coins, mid, r)).sum();
            }
            //if not, then this code runs
            else {
                sumLeft = Arrays.stream(Arrays.copyOfRange(coins, l, mid)).sum();
                sumRight = Arrays.stream(Arrays.copyOfRange(coins, mid, r)).sum();
            }
            //gets the value to see which side is lighter
            int compare = Integer.compare(sumLeft, sumRight);
            //counts the number of times the coins are weighed
            weighing++;
            //if they are equal, then this means the leftmost coin is the fake coin
            if (compare == 0){
                fakeCoin = l;
                break;
            }
            //if compare is less than 0, the left side is lighter so we look left
            if (compare < 0){
                r = mid;
                mid = (l+r)/2;
            }
            //if compare is greater than 0, the right side is heavier so we look right
            else{
                l = mid;
                mid = (r+l)/2;
            }
        }
        //displays results
        System.out.print("\nTotal number of coins is:     " + coinNum +
                         "\nFake coins index:             " + fakeCoin +
                         "\n# of weighing required:       " + weighing);
    }
}
