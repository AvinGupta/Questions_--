//time complexity-->O(n*m) space complexity-->o(n*m)
class Solution
{
    public static void dfs(int sr,int sc,int[][] image,int[][] ans,int prevC,int newC,int[] rw,int[] cl){
        ans[sr][sc]=newC;
    
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<rw.length;i++){
            int nrow=sr+rw[i];
            int ncol=sc+cl[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && image[nrow][ncol]==prevC && ans[nrow][ncol]!=newC){
                dfs(nrow,ncol,image,ans,prevC,newC,rw,cl);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int prevColor=image[sr][sc];
        int[][] ans=image;
        int[] rw={-1,0,1,0};
        int[] cl={0,1,0,-1};
        dfs(sr,sc,image,ans,prevColor,newColor,rw,cl);
        return ans;
    }
}
