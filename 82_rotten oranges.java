import java.util.*;

class Solution{
    public static int orangesRotting(int [][]grid){
        if(grid == null || grid.length == 0) return -1;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int []> queue = new LinkedList<>();
        
        int count_fresh = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2){
                    //rotten orange found add it to queue.
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j]!=0){
                    //Any orange found(rotten, fresh) add to queue.
                    count_fresh++;
                }
            }
        }
        
        if(count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;
        
        //directions for adjecent cells
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        
        //bfs starts from initially rotten oranges.
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt += size; // add number of rotten oranges in current level.
            
            for(int i=0;i<size;i++){
                int []point = queue.poll();
                for(int j=0;j<4;j++){
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y] == 0 || grid[x][y] == 2){
                        continue;
                    }
                    grid[x][y] = 2; // mark the fresh orange as rotten.
                    queue.offer(new int[]{x,y}); 
                }
            }
            //Only increament the time if there are more oranges to rot.
            if(queue.size()!=0){
                countMin++;
            }
        }
        return count_fresh == cnt? countMin : -1;
    }
    
    public static void main(String []args){
        int arr[][] = {{2,1,1} , {1,1,0} , {0,1,1}};
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }
}