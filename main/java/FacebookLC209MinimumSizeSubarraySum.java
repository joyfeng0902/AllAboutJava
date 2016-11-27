package main.java;

public class FacebookLC209MinimumSizeSubarraySum {
    // keep in mind the solution as template
    public int minSubArrayLenUsingSlideWindow(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length, minLen = length + 1, sum = 0, left = 0, right = 0;
        while (right < length) {
            // When the sum is smaller than s, move the right pointer to the next index.
            sum += nums[right];
            while (sum >= s) {
                // When sum >= s, which means the sum of subarray
                // between left and right satisfied the requirement. the right - left + 1
                // may be the result.
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return minLen == length + 1 ? 0 : minLen; // did not find the minLen so return  0
    }

    public int minSubArrayLenUsingBinarySearch (int s, int[] nums) {
        // create another array sumArr[nums.length], where sumArr[i] = sum(nums[0]. ..., nums[i])
        // when meet an element, if sumArr[i] >= s, search in range(0,i) an element (index x) such that
        // sumArr[x] is the largest that is smaller than (sumArr[i] -s), to make sure we can find the min path and
        // after substracting sumArr[x], sum is still >= s
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] sumArr = new int[length];
        sumArr[0] = nums[0];
        int minLen = length + 1;
        for (int i = 1; i < length; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i];
            if (sumArr[i] == s) {
                minLen = Math.min(minLen, i+1);
            } else if (sumArr[i] > s) {
                // find an element in [0,i] which is smaller than sumArr[i]-s but the largest
                int x = search(sumArr, sumArr[i] - s, 0, i - 1);
                minLen = Math.min(minLen, i - x);
            }
        }

        return minLen == length + 1 ? 0 : minLen;
    }

    // inthe sorted array
    // find the index whose element is <= target
    int search(int[] arr, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        // unlike traditional binary search which returns the index whoes value == target or -1 if not found
        if (arr[end] <= target) {
            return end;
        } else {
            return start;
        }
    }

    public static void main (String[] args) {
        int[] nums = new int[] {1,4,4};
        int s = 4;
        FacebookLC209MinimumSizeSubarraySum l = new FacebookLC209MinimumSizeSubarraySum();
        System.out.println(l.minSubArrayLenUsingBinarySearch(s, nums));
        System.out.println(l.minSubArrayLenUsingBinarySearch(15, new int[]{1, 2, 3, 4, 5}));

    }
}
