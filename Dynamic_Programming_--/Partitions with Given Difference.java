class Solution{

    public int countPartitions(int n, int d, int arr[]){
        // Code here
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if((d+sum)%2!=0) return 0;
        int s1=(d+sum)/2;
        int[][] dp=new int[n+1][s1+1];
        int mod=(int)1e9+7;
	    for(int  i=0;i<s1+1;i++) dp[0][i]=0;
	    for(int  i=0;i<n+1;i++) dp[i][0]=1;
	    for(int i=1;i<n+1;i++){
	        for(int j=0;j<s1+1;j++){
	            if(arr[i-1]<=j){
	                dp[i][j]=(dp[i-1][j-arr[i-1]]+dp[i-1][j])%mod;
	            }
	            else dp[i][j]=dp[i-1][j];
	        }
	    }
	    return dp[n][s1];
        
    }
}
