import java.util.*;

class Solution {
    
    public static long countWaysToMakeChange(int[] arr, int n, int T) {
        // Create a 2D DP table where dp[i][j] represents the number of ways
        // to make change for amount `j` using the first `i+1` coins.
        long[][] dp = new long[n][T + 1];
        
        // Initialize base condition:
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0) { 
                dp[0][i] = 1;      
            }
        }
        
        for (int index = 1; index < n; index++) { 
            for (int target = 0; target <= T; target++) { 
                // Case 1: Do not take the current coin
                long notTaken = dp[index - 1][target];
                
                // Case 2: Take the current coin (if it does not exceed the target)
                long taken = 0;
                if (arr[index] <= target) {
                    // Use the current coin and reduce the target by the coin's value
                    taken = dp[index][target - arr[index]];
                }
                
                // Total ways to form `target` is the sum of the two cases
                dp[index][target] = notTaken + taken;
            }
        }
        
        // The answer is stored in the last row and column of the DP table
        return dp[n - 1][T];
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3}; 
        int target = 4;        
        
        int n = arr.length;    
        
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
    }
}
