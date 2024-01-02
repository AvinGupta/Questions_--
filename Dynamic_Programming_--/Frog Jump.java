import java.util.* ;
import java.io.*; 
public class Solution {
    //memoization
    public static int fnc(int ind,int[] arr,int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int left=fnc(ind-1,arr,dp) + Math.abs(arr[ind]-arr[ind-1]);
        int right=Integer.MAX_VALUE;
        if(ind>1)
            right=fnc(ind-2,arr,dp) + Math.abs(arr[ind]-arr[ind-2]);
        return dp[ind]=Math.min(left,right);
    }
    public static int frogJump(int n, int heights[]) {
        // Write your code here..

        // int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return fnc(n-1,heights,dp);


        //tabulation
        int[] dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int left=dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int right=Integer.MAX_VALUE;
            if(i>1)
                right=dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            dp[i]=Math.min(left,right);
        }
        return dp[n-1];
    }

} 
