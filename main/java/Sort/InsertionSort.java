package main.Sort;

public class InsertionSort {
    // to divide into 2 portions: sorted and unsorted
    // at each step, the number is moved from unsorted to sorted
    // https://www.youtube.com/watch?v=DFG-XuyPYUQ
    // advantages of the insertion sort is that it works very efficiently
    // for lists that are nearly sorted initially.
    // Furthermore, it can also work on data sets that are constantly being added to.
    // For instance, if one wanted to maintain a sorted list of
    // the highest scores achieved in a game, an insertion sort would work well,
    // since new elements would be added to the data as the game was played.
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int element = arr[i];
            int j = i;
            while (j > 0 && element < arr[j-1]) {
                arr[j] = arr[j-1];
                j = j-1;
            }
            arr[j] = element;
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();
        int[] arr = new int[]{12, 11, 13, 5, 6};
        s.sort(arr);
        printArray(arr);
    }
}
