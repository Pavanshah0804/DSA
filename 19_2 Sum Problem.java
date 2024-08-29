import java.util.*;
class Solution{
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
        
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
    public static void main(String []args){
        int arr[] = {3,2,4};
        int target = 6;
        
        int []ans = twoSum(arr,target);
        
        for(int i=0;i<ans.length;i++){
            System.out.println("Ans is: "+ans[i]);
        }
    }
}