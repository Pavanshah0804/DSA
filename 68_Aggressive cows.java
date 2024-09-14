import java.util.*;

class Solution {
    public static int aggressiveCows(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low =1,high = stalls[n-1] - stalls[0];
        while(low<=high){
            int mid = (low+high)/2;
            if(canWePlace(stalls ,mid,k))
                low = mid+1;
            else
                high = mid-1;
            
        }
        return high;
    }
    
    public static boolean canWePlace(int []stalls,int dist,int cow){
        int n = stalls.length;
        int cntCows = 1;
        int last = stalls[0];
        for(int i=1;i<n;i++){
            if(stalls[i]-last>=dist){
                cntCows++; // place next cow.
                last = stalls[i]; //update last location.
            }
            if(cntCows >= cow) return true;
        }
        return false;
    }
    
    public static void main(String []args){
        int arr[] = {4,8,9,1,2};
        int n = arr.length;
        int k = 3;
        int ans = aggressiveCows(n,k,arr);
    
        System.out.println("The maximum possible minimum distance is: " + ans);

    }
}