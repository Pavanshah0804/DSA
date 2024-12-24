import java.util.*;

class Solution{
    
    public static int minCost (int n,int []cuts){
        int m = cuts.length;
        
        int []allCuts = new int[m+2];
        System.arraycopy(cuts,0,allCuts,1,m);
        allCuts[0] = 0;
        allCuts[m+1] = n;
        Arrays.sort(allCuts);
        
        int [][]dp = new int[m+2][m+2];
        
        //Fill Dp table using bottom up approach
        for(int len = 2;len < m+2;len++){ //Segment length
            for(int i=0;i<m+2-len;i++){
                int j = i+len;
                dp[i][j] = Integer.MAX_VALUE;
                
                //Evaluate cost for each possible cuts
                for(int k=i+1;k<j;k++){
                    int notTaken = dp[i][j];
                    int taken = allCuts[j] - allCuts[i] + dp[i][k] + dp[k][j];
                    
                    dp[i][j] = Math.min(notTaken,taken);
                }
            }
        }
        
        return dp[0][m+1];
    }
    
    public static void main(String []args){
        int n = 7;
        int[] cuts = {1,3,4,5};
        System.out.println("The minimum cost to cut the stick is: " + minCost(n, cuts));    
    }
}