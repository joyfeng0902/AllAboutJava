package main.Sort;

public class QuickSort {
    //    Always pick first element as pivot.
    //    Always pick last element as pivot (implemented below)
    //    Pick a random element as pivot.
    //    Pick median as pivot.
    //    The key process in quickSort is partition(). Target of partitions is,
    // given an array and an element x of array as pivot, put x at its correct position
    // in sorted array and put all smaller elements (smaller than x) before x, and put all greater
    // elements (greater than x) after x. All this should be done in linear time.
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        quickSort(0, number - 1);
    }

    void quickSort(int low, int high) {
        // not sorted
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(low, pi-1);
            quickSort(pi+1, high);
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int low, int high) {
        int pivot = numbers[high];
        int i = (low-1); // index of smaller element
        for (int j = low; j <= high-1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (numbers[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = numbers[i+1];
        numbers[i+1] = numbers[high];
        numbers[high] = temp;

        return i+1;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] arr = new int[]{12, 11, 13, 5, 6};
        s.sort(arr);
        printArray(arr);
    }
}
