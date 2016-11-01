import java.util.LinkedList;
import java.util.List;

public class LC377CombinationSumIV {
    // using depth first search will time out given [4,1,2] 32 as input
    // sometimes n! is too big and will overflow
    // the correct is to use DP
    // dp[i] = sum(dp[i-nums[j]], i-nums[j] > 0)
    // if allow negative elements, will have to limit the number of occurrence for each element
    // for example, [-1, 1] 1 can have unlimited possible combinations
    public int combinationSum(int[] nums, int target) {
        // dp[i]: the number of possible combinations that add up to i
        int[] dp = new int[target+1];
        dp[0] = 1;   // there is 1 way to create empty list
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i-n >= 0) {
                    dp[i] += dp[i-n];
                }
            }
        }
        return dp[target];
    }
}
