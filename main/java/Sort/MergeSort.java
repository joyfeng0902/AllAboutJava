package main.Sort;

public class MergeSort {
    //    MergeSort(arr[], l,  r)
    //    If r > l
    //    1. Find the middle point to divide the array into two halves:
    //    middle m = (l+r)/2
    //    2. Call mergeSort for first half:
    //    Call mergeSort(arr, l, m)
    //    3. Call mergeSort for second half:
    //    Call mergeSort(arr, m+1, r)
    //    4. Merge the two halves sorted in step 2 and 3:
    //    Call merge(arr, l, m, r)
    private int[] numbers;
    private int[] helper;
    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
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
        MergeSort s = new MergeSort();
        s.numbers = new int[]{12, 11, 13, 5, 6};
        s.sort(s.numbers);
        printArray(s.numbers);
    }
}
