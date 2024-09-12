import java.util.*;

class Solution{
    public static int NthRoot(int n,int m){
        int low = 1,high = m;
        while(low<=high){
            int mid = (low+high)/2;
            int midN = helper(mid,n,m);
            if(midN == 1){
                return mid;
            }
            else if(midN == 0){
                low = mid + 1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    
    public static int helper(int mid,int n,int m){
        long ans = 1;
        for(int i=1;i<=n;i++){
            ans = ans * mid;
            if(ans > m)
                return 2;
            
        }
            if(ans == m) return 1;
            return 0;
    }
    
    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans);
    }
}