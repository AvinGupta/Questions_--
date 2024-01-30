class Solution {
    public static void bfs(int row,int col,char[][] grid,boolean[][] isVisited){
        int n=grid.length;
        int m=grid[0].length;
        
        isVisited[row][col]=true;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col));
        
        while(!q.isEmpty()){
            int rw=q.peek().first;
            int cl=q.peek().second;
            q.remove();
            
            for(int drow=-1;drow<=1;drow++){
                for(int dcol=-1;dcol<=1;dcol++){
                    int nrow=rw+drow;
                    int ncol=cl+dcol;
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]=='1' &&!isVisited[nrow][ncol]){
                        isVisited[nrow][ncol]=true;
                        q.add(new pair(nrow,ncol));
                    }
                }
            }
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] isVisited=new boolean[n][m];
        int count=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]=='1' && !isVisited[row][col]){
                    count++;
                    bfs(row,col,grid,isVisited);
                }
            }
        }
        return count;
    }
}
class pair{
    int first;
    int second;
    public pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
