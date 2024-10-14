import java.util.*;

class Pair {
    int first;  
    int second; 

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    private static void bfs(int r, int c, int [][]visited, char [][]grid) {
        visited[r][c] = 1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();  

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nRow = row + delRow; 
                    int nCol = col + delCol; 

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                        visited[nRow][nCol] = 1;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }

    public static int numIslands(char [][]grid) {
        int n = grid.length;  
        int m = grid[0].length;  
        
        int [][]visited = new int[n][m];
        int count = 0;  

        // Traverse the entire grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the current cell is land ('1') and has not been visited yet, it is part of a new island
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;  // Increment the island count
                    bfs(i, j, visited, grid);  // Perform BFS to mark all connected land cells as visited
                }
            }
        }
        return count;  
    }

    public static void main(String []args) {
        char grid[][] = {
            {'1', '1', '0', '1', '1'},
            {'1', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '1'},
            {'1', '1', '0', '1', '1'}
        };

        int ans = numIslands(grid);
        System.out.println(ans);  
    }
}
