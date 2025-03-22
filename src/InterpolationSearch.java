import java.util.Arrays;

public class InterpolationSearch {
    private boolean found;
    private int index;
    private int divisions;

    public InterpolationSearch(int[] arr, int key) {
        this.found = false;
        this.index = -1;
        this.divisions = 0;
        performSearch(arr, key);
    }

    private void performSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            if (low == high) {
                if (arr[low] == key) {
                    found = true;
                    index = low;
                }
                return;
            }

            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            divisions++;
            if (arr[pos] == key) {
                found = true;
                index = pos;
                return;
            }

            if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
    }

    public boolean isFound() {
        return found;
    }

    public int getIndex() {
        return index;
    }

    public int getDivisions() {
        return divisions;
    }
}
