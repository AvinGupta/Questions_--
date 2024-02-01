class Pair{
    int row;
    int col;
    int distance;
    public Pair(int row,int col,int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] isVisited=new int[n][m];
        int[][] ans=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    isVisited[i][j]=1;
                    q.add(new Pair(i,j,0));
                }
                else{
                    isVisited[i][j]=0;
                }
            }
        }
        
        int[] rw={-1,0,1,0};
        int[] cl={0,1,0,-1};
        
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int dis=q.peek().distance;
            q.remove();
            ans[row][col]=dis;
            
            for(int i=0;i<rw.length;i++){
                int nrow=row+rw[i];
                int ncol=col+cl[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && isVisited[nrow][ncol]==0){
                    isVisited[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,dis+1));
                }
            }
        }
        return ans;
    }
}
