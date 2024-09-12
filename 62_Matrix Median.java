import java.util.*;

class Solution{
    
    public static int median(int matrix[][],int m,int n){
        int low= Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for(int i=0;i<m;i++){
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high,matrix[i][n-1]);
        }
            int req = (m*n)/2;
            while(low<=high){
                int mid = (low+high)/2;
                int smallEqual = countSmallEqual(matrix,m,n,mid);
                if(smallEqual <= req)
                    low = mid+1;
                else
                    high = mid-1;
            }
        return low;
    }
    
    public static int countSmallEqual(int [][]mat,int m,int n,int x){
        int count = 0;
        for(int i=0;i<m;i++){
            count += upperBound(mat[i],x,n);
        }
        return count;
    }
    
    public static int upperBound(int matrix[],int x,int n){
        int low = 0,high = n-1,ans = n;
        
        while(low <= high){
            int mid = (low+high)/2;
            if(matrix[mid]>x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    public static void main(String []args){
        int[][] matrix = {
            {1, 3, 5}, 
            {2, 6, 9}, 
            {3, 6, 9}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = median(matrix, m, n);
        System.out.println("The median element is: " + ans);
    }
}