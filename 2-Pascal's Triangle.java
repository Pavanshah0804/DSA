//Concept of nCr applies here.
//if rows and cols given then n-1 C r-1.

import java.util.*;

class Solution{
    
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row= 1;row<=numRows;row++){
            ans.add(generateRows(row));
        }
        return ans;

    }
    public static List<Integer> generateRows(int row){
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        for(int col=1;col<row;col++){
            ans= ans * (row-col);
            ans = ans/col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<List<Integer>> ans = generate(n);
        for(List<Integer> it : ans){
            for(int ele: it){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        
    }
}