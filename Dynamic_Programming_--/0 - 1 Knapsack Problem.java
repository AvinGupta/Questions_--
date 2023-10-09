class Solution 
{   
    //top-down dp.
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
        // your code here
        int[][] dp=new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                dp[i][j]=-1;
            }
        }
        return knapsack(wt,val,w,n,dp);
    } 
    public static int knapsack(int[] wt,int[] val,int w,int n,int[][] dp){
        if(w==0 || n==0) return 0;
        if(dp[n][w]!=-1) return dp[n][w];
        if(w>=wt[n-1]) return dp[n][w]=Math.max(val[n-1]+knapsack(wt, val, w-wt[n-1], n-1,dp), knapsack(wt, val, w, n-1,dp));
        return dp[n][w]=knapsack(wt, val, w, n-1,dp);
    }
  //buttom-up dp
    static int knapSack(int w, int wt[], int val[], int n){
        int[][] dp=new int[n+1][w+1];
        for(int i=0; i<w+1; i++) dp[0][i] = 0;
        for(int j=0; j<n+1; j++) dp[j][0] = 0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(j>=wt[i-1]){
                    dp[i][j]=Math.max((val[i-1]+dp[i-1][j-wt[i-1]]),dp[i-1][j]);
                }
                else if(j<wt[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
