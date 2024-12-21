import java.util.*;

class Solution{
    
    public static int maxSum(int []arr){
        int n = arr.length;
        int []dp = new int[n];
        
        System.arraycopy(arr,0,dp,0,n);
        
        //Fill the dp array.
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j] && dp[i] > dp[j] + arr[i]){
                    dp[i] = dp[j] + arr[i];
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
        
    }
    public static void main(String []args){
        int arr[] = {1,101,2,3,100};
        
        System.out.println("Maximum increasing subsequence is: "+maxSum(arr));
    }
}