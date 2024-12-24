import java.util.Arrays;

class Solution {

    public static boolean canPartition(int[] nums,int target) {

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
        
        int arr[] = {3, 34, 4, 12, 5, 2};
        int target = 9;
        System.out.println("Can partition: " + canPartition(arr,target)); // Output: true

        
    }
}
