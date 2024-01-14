import java.util.* ;
import java.io.*; 
public class Solution{
    static int fnc(int[] wt,int[] val,int n,int w,int[][] dp){
        if(n==0 || w==0){
            return 0;
        }
        if(dp[n][w]!=-1) return dp[n][w];
        if(wt[n-1]<=w){
            return dp[n][w]=Math.max(val[n-1]+fnc(wt,val,n-1,w-wt[n-1],dp),fnc(wt,val,n-1,w,dp));
        }
        return dp[n][w]=fnc(wt,val,n-1,w,dp);
    }
    static int knapsack(int[] wt, int[] val, int n, int w){
        int[][] dp=new int[n+1][w+1];
        // for(int[] x:dp){
        //     Arrays.fill(x,-1);
        // }
        //memoization
        // return fnc(wt,val,n,w,dp);

        //tabulation
        for(int i=0;i<n+1;i++) dp[i][0]=0;
        for(int i=0;i<w+1;i++) dp[0][i]=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else if(wt[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
