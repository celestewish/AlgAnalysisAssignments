import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Name:        Lauren Rousell
// Class:       CS 4306/03
// Term: Spring 2024
// Instructor:  Dr. Haddad
// Assignment:  2
// IDE Name:    IntelliJ
//******************************************
/*
Algorithm Design Block

Algorithm title: Find subscripts that start with a and end with b
Logical steps:

    Step 1: Retreives the chosen string from the user.
    Step 2: Set a loop that compares each character in the string to see if it starts
        with A.
    Step 3: Add a nested loop that compares the following character to see if it ends
        with B.
    Step 4: If the character ends with B, then store it in a list made of strings.
    Step 5: Print the input string, the number of substrings, the substrings themselves,
        and the number of comparisons.

Pseudocode syntax:

Algorithm: Find subscripts that start with a and end with b
Input: String input from user
Output: Prints subscripts that have been found

Begin
Read Input String
Integer Comparisons = 0
List stringList
for i <- 0 to Input String length do
    if Character at i == A
        Comparisons++
        for j <- i + 1 to Input String length do
            if Character at j == B
                Comparisons++
                Store Substring(i, j + 1) in stringList
        End Loop
End Loop
Print Input String, Number of Substrings, List of Substrings, and Number of Comparisons
End;

******************************************/

public class Substrings {
    public static void findSubstrings(String str) {
        List<String> result = new ArrayList<>();
        int comparisons = 0;

        //goes through every single character which is standard for brute force search
        for (int i = 0; i < str.length(); i++) {
            if (Character.toLowerCase(str.charAt(i)) == 'a') {
                comparisons++;
                for (int j = i + 1; j < str.length(); j++) {
                    if (Character.toLowerCase(str.charAt(j)) == 'b') {
                        comparisons++;
                        result.add(str.substring(i, j + 1));
                    }
                }
            }
        }
        //prints out results
        System.out.print("\nInput String: " + str
        + "\n# of substrings: " + result.size()
        + "\nListings of substrings: ");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + ", ");
            }
        }
        System.out.println("\n# of comparisons: " + comparisons);
    }

    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String inputString = "";
        int choice;
        //loop that controls interface
        while (true) {
            System.out.println("-----------------MAIN MENU--------------\n" +
                    "1. Read input string \n" +
                    "2. Run algorithm and display outputs \n" +
                    "3. Exit program \n\n" +
                    "Enter option number:");
            //switch that controls choices
            switch (sc.nextInt()){
                //receives input from user
                case 1:
                    sc.nextLine();
                    System.out.println("Input string: ");
                    inputString = sc.nextLine();
                    break;
                    //inputs user's string into algorithm and prints results
                    case 2:
                        sc.nextLine();
                        findSubstrings(inputString);
                        break;
                        //ends program
                        case 3:
                            System.exit(0);
                            break;
            }
        }
    }
}
