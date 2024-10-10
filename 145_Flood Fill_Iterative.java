import java.util.*;

class Solution{
    
    public static int[][] floodFill(int [][]image,int sr,int sc,int newColor){
        int iniColor = image[sr][sc];
        // No need to proceed if the new color is the same as the initial one
        if (iniColor == newColor) return image; 
        
        int n = image.length;
        int m = image[0].length;
        int[][] ans = image;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // Use a stack to simulate recursion
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr, sc});
        ans[sr][sc] = newColor;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];

            // Explore all four directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                    ans[nrow][ncol] = newColor;
                    stack.push(new int[]{nrow, ncol});
                }
            }
        }

        return ans;
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