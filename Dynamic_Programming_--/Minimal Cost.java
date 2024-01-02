public class Solution {
    public static int minimizeCost(int n, int k, int []arr){
        // Write your code here.
        int[] dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int ans=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jumps=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                    ans=Math.min(ans,jumps);
                }
            }
            dp[i]=ans;
        }
        return dp[n-1];
    }
}
