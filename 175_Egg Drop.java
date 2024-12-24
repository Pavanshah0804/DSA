import java.util.*;

class Solution {
    public static int superEggDrop(int k, int n) {
        int attempts = 0; 
        int[][] dp = new int[n+1][k+1]; // DP table to store results of subproblems
        
        // Continue until the maximum number of floors that can be tested with `k` eggs
        // and `attempts` exceeds or equals `n`
        while(dp[attempts][k] < n) {
            attempts++; // Increment the number of attempts
            
            for(int j = 1; j <= k; j++) {
                // dp[attempts-1][j]: Floors that can be tested if the egg doesn't break
                // dp[attempts-1][j-1]: Floors that can be tested if the egg breaks
                dp[attempts][j] = 1 + dp[attempts-1][j] + dp[attempts-1][j-1];
            }
        }
        
        return attempts; // Return the minimum number of attempts required
    }
    
    public static void main(String[] args) {
        int k = 3,n = 14; 
        
        System.out.print("Egg doesn't break at floor no: " + superEggDrop(k, n) + " or below");
    }
}
