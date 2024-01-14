public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
		int sum=0;
		for(int var:arr) sum+=var;
		if(sum%2!=0) return false;
        return subsetSumToK(n,sum/2,arr);
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
