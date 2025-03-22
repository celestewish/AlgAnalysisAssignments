// Name: Lauren Rousell
// Class: CS 4306/03
// Term: Spring 2025
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: IntelliJ

//creates and runs an interpolation search
public class InterpolationSearch {
    //variables
    private boolean found;
    private int index;
    private int divisions;

    //constructor
    public InterpolationSearch(int[] arr, int key) {
        this.found = false;
        this.index = -1;
        this.divisions = 0;
        performSearch(arr, key);
    }

    //this is the interpolation search
    private void performSearch(int[] arr, int key) {
        //setting high and low
        int low = 0, high = arr.length - 1;
        //if all important spots have been checked, then the loops since the key doesn't exist in the array
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            //if there is only one index left to check and that index equals the key, the search is over
            if (low == high) {
                if (arr[low] == key) {
                    found = true;
                    index = low;
                }
                return;
            }

            //division
            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            divisions++;
            //if the position equals the key, the search is over
            if (arr[pos] == key) {
                found = true;
                index = pos;
                return;
            }

            //if the position is lower than the key, increment up
            //if the position is higher than the key, go down
            if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
    }
    //returns the found status
    public boolean isFound() {
        return found;
    }
    //returns the index of the key
    public int getIndex() {
        return index;
    }
    //returns the divisions it took to get to the key
    public int getDivisions() {
        return divisions;
    }
}
