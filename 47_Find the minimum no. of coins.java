import java.util.*;

class Solution{
    public static int coinChange(int []coins,int amount){
        if(amount < 1)
            return 0;
        int []minCoinsDp = new int [amount+1];
        for(int i=1;i<=amount;i++){
            minCoinsDp[i] = Integer.MAX_VALUE;
            
           for(int coin : coins){
                if(coin<=i && minCoinsDp[i-coin] != Integer.MAX_VALUE){
                    minCoinsDp[i] = Math.min(minCoinsDp[i], 1 + minCoinsDp[i-coin]);
                }
            }
        }
        if(minCoinsDp[amount]  == Integer.MAX_VALUE){
            return -1;
        }
        return minCoinsDp[amount];
    }
    
    public static void main(String []args){
        int amount = 11;
        int coins[] = {1,5,6,9};
        
        int ans = coinChange(coins,amount);
        System.out.println("The min number of coin is:"+ans);
        
    }
}