import java.util.*;

class Solution{

    public static void helper(int ind, int []arr,int target,List<List<Integer>> ans, List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            
            temp.add(arr[i]);
            helper(i+1,arr,target-arr[i],ans,temp);
            temp.remove(temp.size()-1);
        }
        
    }
    public static List<List<Integer>> CombinationSum2(int []candidates,int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    } 
    
    public static void main(String []args){
        int []candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = CombinationSum2(candidates, target);
        
        System.out.println(ans);
    }
}