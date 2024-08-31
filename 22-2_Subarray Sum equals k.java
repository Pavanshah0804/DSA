import java.util.*;
class Solution{
    public static int subarraySum(int []nums, int k){
        int res = 0;
        int curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // don't forget to put this value.
        for(int i: nums){
            curr += i;
            res += map.getOrDefault(curr-k,0);
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        
        return res;
    }
    public static void main(String []args){
        int k = 2;
        int arr[] = {1,1,1};
        int ans = subarraySum(arr,k);
        System.out.println(ans);

    }
}