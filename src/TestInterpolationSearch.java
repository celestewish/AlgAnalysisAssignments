import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestInterpolationSearch {
    static int[] Values;
    public static void RandomDistinct(){
        Set<Integer> uniqueNumbers = new HashSet<Integer>();
        Random rand = new Random();
        while (uniqueNumbers.size() < 1024){
            uniqueNumbers.add(rand.nextInt(9999)+1);
        }
        Values = uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(Values);
        for (int i = 0; i < Values.length; i++){
            System.out.printf("%-6d", Values[i]);
            if ((i + 1) % 30 == 0){
                System.out.println();
            }
        }
    }
    public static void RunIntSearch(int tableSize){
        Random rand = new Random();
        int key = rand.nextInt(1,9999);
        InterpolationSearch mySearch = new InterpolationSearch(Values, key);
        int divisions = 0;
        System.out.println("  Key    Found    Index    Divisions\n" +
                "-------------------------------------------");
        for (int i = 0; i < tableSize; i++){
            System.out.printf("  %-6d %-8b %-8d %-8d%n", key, mySearch.isFound(), mySearch.getIndex(), mySearch.getDivisions());
            key = rand.nextInt(9999) + 1;
            divisions += mySearch.getDivisions();
            mySearch = new InterpolationSearch(Values, key);
        }
        System.out.println("Divisions average: " + (float)divisions/tableSize);
        System.out.println("Difference:        " + ((Math.log(1024)/Math.log(2)) - divisions));
    }
}
