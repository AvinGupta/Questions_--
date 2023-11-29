class Solution{

	public int minCoins(int coins[], int M, int V){ 
	    // Your code goes here
	    int[][] dp=new int[M+1][V+1];
	    for(int i=0;i<M+1;i++) dp[i][0]=0;
	    for(int i=0;i<V+1;i++) dp[0][i]=Integer.MAX_VALUE-1;
	    for(int i=1;i<dp.length;i++){
	        for(int j=1;j<dp[i].length;j++){
	            if(coins[i-1]<=j){
	                dp[i][j]=Math.min((dp[i][j-coins[i-1]])+1,dp[i-1][j]);
	            }
	            else{
	                dp[i][j]=dp[i-1][j];
	            }
	        }
	    }
	    if(dp[M][V]==Integer.MAX_VALUE-1) return -1;
	    return dp[M][V];
	} 
	
}
