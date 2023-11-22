class Solution {
    public long count(int coins[], int n, int sum) {
        // code here.
        long[][] dp=new long[coins.length+1][sum+1];
        for(int i=0;i<sum+1;i++) dp[0][i]=0;
        for(int i=0;i<coins.length+1;i++) dp[i][0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(j>=coins[i-1]){
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[coins.length][sum];
    }
}
