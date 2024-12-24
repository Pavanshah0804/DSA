import java.util.Arrays;

class Solution {

    public static boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true; 
        
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                // Update dp[j]: it's true if we can achieve j by either:
                // 1. Not using the current number (dp[j] is already true), or
                // 2. Using the current number (dp[j - num] is true)
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        System.out.println("Can partition: " + canPartition(nums1)); // Output: true

        
    }
}
