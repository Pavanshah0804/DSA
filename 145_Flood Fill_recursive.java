import java.util.*;

class Solution{
    
    public static int[][] floodFill(int [][]image,int sr,int sc,int newColor){
        //get initial color 
        int iniColor = image[sr][sc];
        int [][]ans = image;
        
        //delta row and delta column for neighbours.
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,-1,0,1};
        dfs(sr,sc,ans,image,newColor,delRow,delCol,iniColor);
        return ans;
    }
    
    private static void dfs(int row,int col,int [][]ans,int [][]image,int newColor,int delRow[],int []delCol,int iniColor){
        int n = image.length;
        int m = image[0].length;
        ans[row][col] = newColor;
        
        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            
            if(nrow >=0 && nrow<n && ncol >= 0 && ncol<n && image[nrow][ncol] == iniColor && ans[nrow][ncol]!=newColor){
                dfs(nrow,ncol,ans,image,newColor,delRow,delCol,iniColor);
            }
        }
    }
    
    
    public static void main(String []args){
        int[][] image =  {
	        {1,1,1},
	        {1,1,0},
	        {1,0,1}
	    };

        int sr = 1, sc = 1, newColor = 2;
        
        int[][] ans = floodFill(image, sr,sc,newColor);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}