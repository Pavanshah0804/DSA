import java.util.*;

class Solution{
    
    public static int celebrity(int [][]mat){
        int top = 0;
        int down = mat.length-1;
        
        while(top<down){
            if(mat[top][down] == 1){
                //top knows down so it can't be celebrity.
                top++;
            }
            else{
                //top doesn't know down so it can't be celebrity.
                down--;
            }
        }
        
        for(int i=0;i<mat.length;i++){
            //check if top is actual celebrity or not.
            if(i!=top){
                // check if top knows anyone or someone doesn't know top.
                if(mat[top][i] == 1 || mat[i][top]==0)
                    return -1;
            }
        }
        return top;
    }
    
    public static void main(String []args){
        int arr[][] = {{0,1,0},{0,0,0},{0,1,0}};
        int ans = celebrity(arr);
        if(ans != -1){
            System.out.println("celebrity is "+ans);
        }else{
            System.out.println("celebrity does not exist.");
        }
    }
}