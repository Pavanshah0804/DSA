
import java.util.*;

class Solution {
    public static int maxSubArray(int[] nums) {
        int sum = 0, max=nums[0];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max = sum>max?sum:max;
            if(sum<0)
                sum = 0;
        }
        return max;
    }
   

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int maxSum = maxSubArray(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}

