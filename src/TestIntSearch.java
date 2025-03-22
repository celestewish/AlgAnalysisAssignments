// Name: Lauren Rousell
// Class: CS 4306/03
// Term: Spring 2025
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: IntelliJ
import java.util.Scanner;

//allows us to test our interpolation search algorithm with the methods created prior
public class TestIntSearch {
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        int table = 0;
        //loop that controls interface
        while(true) {
            System.out.println("\n----------------------MAIN MENU-------------------\n" +
                    "1. Create, populate, and display array Values[]\n" +
                    "2. Read output table size\n" +
                    "3. Run interpolation search and display outputs\n" +
                    "4. Exit program\n\n" +
                    "Enter option number:");
            //switch that controls options
            switch(sc.nextInt()) {
                //creates random array of distinct values and prints them
                case 1:
                    TestInterpolationSearch.RandomDistinct();
                    break;
                    //allows the user to input a table size
                    case 2:
                        sc.nextLine();
                        System.out.println("Enter output table size:");
                        table = sc.nextInt();
                        break;
                        //creates a table of the input's size and search for random values in our array using our algorithm
                        case 3:
                            TestInterpolationSearch.RunIntSearch(table);
                            break;
                            //ends program
                            case 4:
                                System.exit(0);
                                break;
            }
        }
    }
}
