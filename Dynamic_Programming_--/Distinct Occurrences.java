class Solution
{
    int  subsequenceCount(String x, String y)
    {
	    // Your code here	
	    int m=x.length();
        int n=y.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++) dp[i][0]=1;
        for(int i=1;i<n+1;i++) dp[0][i]=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%1000000007;
                }
                else{
                    dp[i][j]=(dp[i-1][j])%1000000007;
                }
            }
        }
        return dp[m][n];
    }
}
