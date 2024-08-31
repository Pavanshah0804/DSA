import java.util.*;

class Solution{
    public static int subarraysWithXorK(int []a, int k){
        int n = a.length;
        int xr = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        mpp.put(xr, 1);
        
        int cnt = 0;
        for(int i=0;i<n;i++){
            xr = xr ^ a[i]; // prefix xor till index i
            int x = xr ^ k; // formula
            
            if(mpp.containsKey(x)){
                cnt += mpp.get(x);
            }
            else{
                mpp.put(xr,1);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subarraysWithXorK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }
}