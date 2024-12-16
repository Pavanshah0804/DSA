import java.util.*;

class Solution{
    
    public static int lengthOfLIS(int []nums){
        int n = nums.length; 
        int []dp = new int[n];
        Arrays.fill(dp,1);
        
        for(int i=1;i<n;i++){
            //find if smaller number exists.
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1); //update dp[i] to maximum LIS length found so far.
                }
            }
        }
        
        // Find and return the maximum value in the DP array,
        // which represents the length of the longest increasing subsequence.
        return Arrays.stream(dp).max().orElse(-1);
    }
    
    public static void main(String []args){
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS for nums1: " + lengthOfLIS(nums1)); 
    }
}