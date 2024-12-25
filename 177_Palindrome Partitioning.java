import java.util.*;

class Solution {

    public static int palindromePartitioning(String s) {
        int n = s.length(); 
        
        int[] dp = new int[n + 1];
        dp[n] = 0; 
        
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE; // Initialize the minimum cost for the current index
            
            // Check all substrings starting from index i
            for (int j = i; j < n; j++) {
                // If the substring from i to j is a palindrome
                if (isPalindrome(i, j, s)) {
                    // Calculate the cost as 1 (for the current partition) + cost for the remaining substring
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(cost, minCost);
                }
            }
            dp[i] = minCost;
        }
        
        return dp[0] - 1;
    }

    public static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false; 
            i++;
            j--;
        }
        return true; 
    }

    public static void main(String[] args) {
        String str = "BABABCBADCEDE"; 
        int partitions = palindromePartitioning(str);
        System.out.println("The minimum number of partitions: " + partitions);
    }
}
