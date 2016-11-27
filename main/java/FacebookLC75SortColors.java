package main.java;

/**
 * Created by joyfeng on 11/21/2016.
 */
public class FacebookLC75SortColors {
    public void sortColors(int[] nums) {
        int[] colorCount = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colorCount[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (colorCount[i] > 0) {
                nums[index++] = i;
                colorCount[i]--;
            }
        }
    }

    public void sortColors2(int[] nums) {
        // Use the idea of quick sort (pivot and partition)
        if (nums == null || nums.length < 2) {
            return;
        }
        int redIndex = 0, blueIndex = nums.length-1, index = 0;
        while (index <= blueIndex) {
            if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                // swap nnums[blueIndex] and nums[index]
                int tmp = nums[blueIndex];
                nums[blueIndex] = 2;
                nums[index] = tmp;
                blueIndex--;
            } else {
                // swap nums[redIndex] and nums[index]
                int tmp = nums[redIndex];
                nums[redIndex] = 0;
                nums[index] = tmp;
                redIndex++;
                index++;  // cannot be less than redIndex
            }
        }
    }

    static void printAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        FacebookLC75SortColors f = new FacebookLC75SortColors();
        int[] arr = new int[]{2, 0, 1, 1, 0, 0, 2, 1, 2, 1, 0};
        f.sortColors(arr);
        printAll(arr);
    }
}
