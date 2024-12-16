import java.util.*;

class Solution{
    public static int getLCSLength(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        
        int [][]dp = new int[m+1][n+1];
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    //If characters match then include them in LCS and move diagonally
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                    //otherwise take maximum of excluding one character from either string.
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
    
    public static void main(String []args){
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        
        int ans = getLCSLength(s1,s2);
        System.out.println("The longest Common Subsequence is : "+ ans);
    }
}