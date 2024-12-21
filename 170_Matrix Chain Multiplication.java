import java.util.*;


class Solution{
    public static int matrixMultiplication(int []arr, int n){
        
        int [][]dp = new int[n][n];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        
        int i = 1;
        int j = n-1;
        
        return f(arr,i,j,dp);
    }
    
    public static int f(int []arr,int i,int j, int [][]dp){
        //base condition 
        if(i==j){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        
        //loop of partitioning
        for(int k = i;k<=j-1;k++){
            int ans = f(arr,i,k,dp) + f(arr,k+1,j,dp) + arr[i-1] * arr[k] * arr[j];
            min = Math.min(ans,min);
        }
        return min;
    }
    
    public static void main(String []args){
        int arr[] = {10, 20, 30, 40, 50};
    	int n = arr.length;
	
	    System.out.println("The minimum number of operations are "+ matrixMultiplication(arr,n));
        
    }
}