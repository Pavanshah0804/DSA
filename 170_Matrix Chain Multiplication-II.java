import java.util.*;

class Solution{
    public static int matrixMultiplication(int []arr, int n){
        int [][]dp = new int[n][n];
        
        for(int len = 2;len<n;len++){
            for(int i=1;i<n-len+1;i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i;k<j;k++){
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(cost,dp[i][j]);
                }
            }
        }
        
        return dp[1][n-1];
    }
    
    public static void main(String []args){
        int arr[] = {10, 20, 30, 40, 50};
    	int n = arr.length;
	
	    System.out.println("The minimum number of operations are "+ matrixMultiplication(arr,n));
        
    }
}