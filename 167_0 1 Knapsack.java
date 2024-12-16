import java.util.*;

class Solution{
    
    public static int knapsack(int []wt, int []val,int n, int W){
        //create an empty array to store max value for each capacity
        int prev[] = new int[W+1];
        
        //Initialize first row of array.
        for(int i=wt[0];i<=W;i++){
            prev[i]= val[0];
        }
        
        //Iterate through each item and capacity
        for(int ind = 1;ind<n;ind++){
            for(int cap = W;cap>=0;cap--){
                //Calculate max value when current item is not taken.
                int notTaken = prev[cap];
        
                //Calculate the max value when current item is taken.
                int taken = Integer.MIN_VALUE;
                
                if(wt[ind]<=cap){
                    taken = val[ind]+prev[cap-wt[ind]];
                }
                
                //update the array with max value for current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }
        return prev[W];
    }
    
    public static void main(String []args){
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        // Calculate and print the maximum value of items the thief can steal
        System.out.println("The Maximum value of items the thief can steal is " + knapsack(wt, val, n, W));
    }
}