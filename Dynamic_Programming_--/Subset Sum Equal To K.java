import java.util.* ;
import java.io.*; 
public class Solution {
    static boolean fnc(int[] arr,int n,int w,boolean[][] dp){
        if(w==0) return true;
        if(n==0) return false;
        if(dp[n][w]!=false) return dp[n][w];
        if(arr[n-1]<=w){
            return dp[n][w]=fnc(arr,n-1,w-arr[n-1],dp) || fnc(arr,n-1,w,dp);
        }
        return fnc(arr,n-1,w,dp);
    }
    public static boolean subsetSumToK(int n, int w, int arr[]){
        // Write your code here.
        boolean[][] dp=new boolean[n+1][w+1];
        //memoization
        // return fnc(arr,n,w,dp);

        //tabulation
        for(int i=0;i<w+1;i++) dp[0][i]=false;
        for(int i=0;i<n+1;i++) dp[i][0]=true;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else if(arr[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
