class Solution{
    public static void dfs(int row,int col,char[][] a,int[][] isVisited,int[] rw,int[] cl){
        isVisited[row][col]=1;
        int n=a.length;
        int m=a[0].length;
        
        for(int i=0;i<rw.length;i++){
            int nrow=row+rw[i];
            int ncol=col+cl[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && isVisited[nrow][ncol]==0 && a[nrow][ncol]=='O'){
                dfs(nrow,ncol,a,isVisited,rw,cl);
            }
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int[] rw={-1,0,1,0};
        int[] cl={0,1,0,-1};
        int[][] isVisited=new int[n][m];
        //checking if any zero is present in the first and the last row of matrix.
        for(int j=0;j<m;j++){
            //first row.
            if(a[0][j]=='O' && isVisited[0][j]==0){
                dfs(0,j,a,isVisited,rw,cl);
            }
            //last row.
            if(a[n-1][j]=='O' && isVisited[n-1][j]==0){
                dfs(n-1,j,a,isVisited,rw,cl);
            }
        }
        //checking if any zero is present in the first and last coloumn of the matrix.
        for(int i=0;i<n;i++){
            //first coloumn.
            if(a[i][0]=='O' && isVisited[i][0]==0){
                dfs(i,0,a,isVisited,rw,cl);
            }
            //last column.
            if(a[i][m-1]=='O' && isVisited[i][m-1]==0){
                dfs(i,m-1,a,isVisited,rw,cl);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isVisited[i][j]==0 && a[i][j]=='O'){
                    a[i][j]='X';
                }
            }
        }
        return a;
    }
}
