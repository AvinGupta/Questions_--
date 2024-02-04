// User function Template for Java
class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] isVisited=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        isVisited[i][j]=1;
                    }
                }
            }
        }

        int[] rw={-1,0,1,0};
        int[] cl={0,1,0,-1};

        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();

            for(int i=0;i<rw.length;i++){
                int nrow=row+rw[i];
                int ncol=col+cl[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && isVisited[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol));
                    isVisited[nrow][ncol]=1;
                }
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && isVisited[i][j]==0) count++;
            }
        }
        return count;
    }
}
