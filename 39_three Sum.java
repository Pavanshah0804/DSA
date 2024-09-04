import java.util.*;

class Solution{
    public static List<List<Integer>>threesum (int []nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList();
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0)&& nums[i] != nums[i-1]){
                int low = i+1;
                int high = nums.length-1;
                int sum = 0-nums[i];
            
                while(low<high){
                    if(nums[low] + nums[high] == sum){
                        ans.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low<high && nums[low] == nums[low+1]) low++;
                        while(low<high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] > sum){
                        high--;
                    }
                    else{
                        low++;
                    }
                }
            }
        }
        return ans;
    }
    
    public static void main(String []args){
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans = threesum(arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
    
}