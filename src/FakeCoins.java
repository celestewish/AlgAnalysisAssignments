import java.util.Arrays;
import java.util.Random;
public class FakeCoins {
    public static void main(String[] args) {
        FakeCoin(7);
    }
    public static void FakeCoin(int coinNum){
        //variables
        int[] coins = new int[coinNum];
        int randomCoin = new Random().nextInt(coinNum);
        boolean isFake = false;
        int fakeCoin = 0;
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
        while (!isFake){
            //if there is only one coin left, then that coin is mid and it is the fake coin
            if ((r - l + 1) == 1){
                fakeCoin = mid;
                isFake = true;
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
                isFake = true;
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
