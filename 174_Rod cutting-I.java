import java.util.*;

class Solution{
    public static int unboundedKnapsack(int n,int W,int []val, int []wt){
        int [][]dp = new int[n][W+1];
        
        //base condition: Initialize DP array for the first item.
        for(int i=wt[0];i<=W;i++){
            dp[0][i] = ((int) i/wt[0]) * val[0];
        }
        
        for(int i=1;i<n;i++){
            for(int cap=0;cap<=W;cap++){
                //calculate maximum value when current item is not taken.
                int notTaken = 0 + dp[i-1][cap];
                
                // Initialize maximum value when current item is taken as minimum integer value
                int taken = Integer.MIN_VALUE;
                
                // If the weight of the current item is less than or equal to the current capacity (cap),
                // calculate the maximum value when the current item is taken
                if(wt[i] <= cap){
                    taken = val[i] + dp[i][cap-wt[i]];
                }
                
                //Store result in dp Array.
                dp[i][cap] = Math.max(notTaken,taken);
            }
        }
        
        return dp[n-1][W]; // return maximum value
    }
    
    public static void main(String []args){
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;
        int n = wt.length;
        System.out.println("The maximum value of item that theif can steal is: " + unboundedKnapsack(n,W,val,wt));
    }
}