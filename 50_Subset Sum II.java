import java.util.*;

class Solution{
    public static List<List<Integer>> subsetWithDup(int []nums){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new ArrayList<>(),nums,0);
        return list;
    }
    
    public static void helper(List<List<Integer>> list,List<Integer> temp, int []nums, int start){
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            helper(list,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
    
    public static void main(String []args){
        int []arr= {1,2,2};
        List<List<Integer>> ans = subsetWithDup(arr);
        System.out.println(ans);
    }
}