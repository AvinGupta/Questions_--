class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int range=0;
	    for(int i=0;i<arr.length;i++){
	        range+=arr[i];
	    }
	    boolean[][] dp=new boolean[n+1][range+1];
	    for(int i=0;i<range+1;i++) dp[0][i]=false; 
	    for(int i=0;i<n+1;i++) dp[i][0]=true;
	    for(int i=1;i<dp.length;i++){
	        for(int j=1;j<dp[i].length;j++){
	            if(j>=arr[i-1]){
	                dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
	            }
	            else dp[i][j]=dp[i-1][j];
	        }
	    }
	    ArrayList<Integer> lst=new ArrayList<>();
	    for(int i=0;i<=range/2;i++){
	        if(dp[n][i]==true) lst.add(i);
	    }
	    int ans=Integer.MAX_VALUE;
	    for(int i=0;i<lst.size();i++){
	        ans=Math.min(ans,range-2*lst.get(i));
	    }
	    return ans;
	} 
}
