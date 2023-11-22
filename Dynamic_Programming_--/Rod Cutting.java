class Solution{
    public int cutRod(int val[], int N) {
        //code here
        int[] length=new int[N];
        for(int i=0;i<N;i++) length[i]=i+1;
        int W=length.length;
        int[][] dp=new int[W+1][N+1];
        for(int i=0;i<N+1;i++) dp[i][0]=0;
        for(int i=0;i<W+1;i++) dp[0][1]=0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(j>=length[i-1]){
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
}
