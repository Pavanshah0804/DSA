import java.util.Scanner;

class Solution {
    public int removeDuplicates(int[] nums) {
       if(nums.length <= 0)
            return 0;
       int i = 0;
       for(int j=1;j<nums.length;j++){
        if(nums[j] != nums[i]){
            nums[i+1] = nums[j];
            i++;
        }
       }
       return i+1;
    }
    
    public static void main(String []args){
        int arr[] = {1,1,2,2,2,2,3,3,3,4,4};
        Solution sol = new Solution();
        
        int n = sol.removeDuplicates(arr);
        System.out.println(n);
        
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
