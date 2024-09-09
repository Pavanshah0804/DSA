import java.util.*;

class Solution{
    public static void recurPermute(int index, int []nums, List<List<Integer>> ans){
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds)); // copy ds to ans
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recurPermute(index+1,nums,ans);
            swap(i,index,nums); //don't forget to reswap
        }
    }
    
    private static void swap(int i,int j,int []nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static List<List<Integer>> permute(int []nums){
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0,nums,ans);
        return ans;
    }
    
    public static void main(String []args){
        int arr[] = {1,2,3};
        System.out.println(permute(arr));
    }
}