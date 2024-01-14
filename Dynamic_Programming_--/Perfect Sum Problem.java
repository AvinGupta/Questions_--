import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar) {
        return fnc(num.length,tar,num);
    }
    public static int fnc(int n, int w, int arr[]){
        int[][] dp=new int[n+1][w+1];
        int mod=(int)1e9+7;
        for(int i=0;i<w+1;i++) dp[0][i]=0;
        for(int i=0;i<n+1;i++) dp[i][0]=1;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=(dp[i-1][j-arr[i-1]] + dp[i-1][j])%mod;
                }
                else if(arr[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
