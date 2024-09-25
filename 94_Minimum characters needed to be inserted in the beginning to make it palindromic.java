import java.util.*;

class Solution{
    public static int minInsertion(String s){
        int n = s.length();
        
        int [][]dp = new int[n][n];
        
        for(int length = 2; length <= n; length++){
            for(int i = 0; i <= n - length; i++){
                int j = i + length - 1; // end of the substring
                
                // If characters match, no new insertions are required
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                } 
                // If characters don't match, we need one insertion plus the min insertions 
                // required for the substring without one character at either end
                else{
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        
        return dp[0][n - 1];
    }
    
    public static void main (String[] args){
        String str = "leetcode";
        System.out.println("Min characters needed to insert to make the string a palindrome: " + minInsertion(str));
    }
}
