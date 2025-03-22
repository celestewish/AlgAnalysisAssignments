// Name: Lauren Rousell
// Class: CS 4306/03
// Term: Spring 2025
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: IntelliJ
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
//tests interpolation search created earlier
public class TestInterpolationSearch {
    //variables
    static int[] Values;
    //creates an array of 1024 size with random, unique numbers
    public static void RandomDistinct(){
        //hashset used to make sure each number is unique
        Set<Integer> uniqueNumbers = new HashSet<Integer>();
        //used to create random values
        Random rand = new Random();
        //storing random values in hashset
        while (uniqueNumbers.size() < 1024){
            uniqueNumbers.add(rand.nextInt(9999)+1);
        }
        //initializes array by taking values from hashset, mapping them to primitive it, and then storing it in an array
        Values = uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
        //sorting said values
        Arrays.sort(Values);
        //printing the values
        for (int i = 0; i < Values.length; i++){
            System.out.printf("%-6d", Values[i]);
            if ((i + 1) % 30 == 0){
                System.out.println();
            }
        }
    }
    //runs the search and prints a table
    public static void RunIntSearch(int tableSize){
        //variables
        Random rand = new Random();
        //random key
        int key = rand.nextInt(9999) + 1;
        InterpolationSearch mySearch = new InterpolationSearch(Values, key);
        int divisions = 0;
        //top of table
        System.out.println("  Key    Found    Index    Divisions\n" +
                "-------------------------------------------");
        //loops through and prints the results
        for (int i = 0; i < tableSize; i++){
            System.out.printf("  %-6d %-8b %-8d %-8d%n", key, mySearch.isFound(), mySearch.getIndex(), mySearch.getDivisions());
            key = rand.nextInt(9999) + 1;
            divisions += mySearch.getDivisions();
            mySearch = new InterpolationSearch(Values, key);
        }
        //prints data about divisions
        System.out.println("Divisions average: " + (float)divisions/tableSize);
        System.out.println("Difference:        " + ((Math.log(1024)/Math.log(2)) - divisions));
    }
}
