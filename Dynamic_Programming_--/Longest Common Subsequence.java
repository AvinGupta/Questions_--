class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    
  
    //top-down solution --memoization.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int[][] dp=new int[x+1][y+1];
        for(int i=0;i<x+1;i++){
            for(int j=0;j<y+1;j++){
                dp[i][j]=-1;
            }
        }
        return helper(s1,s2,x,y,dp);
    }
    static int helper(String s1,String s2,int x,int y,int[][] dp){
        if(x==0 || y==0){
            return 0;
        }
        if(dp[x][y]!=-1) return dp[x][y];
        if(s1.charAt(x-1)==s2.charAt(y-1)){
            return dp[x][y]=1+helper(s1,s2,x-1,y-1,dp);
        }
        else return dp[x][y]=Math.max(helper(s1,s2,x-1,y,dp),helper(s1,s2,x,y-1,dp));
    }
    
    //bottom-up --tabulation
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int[][] dp=new int[x+1][y+1];
        for(int i=0;i<x+1;i++) dp[i][0]=0;
        for(int i=0;i<y+1;i++) dp[0][i]=0;
        
        for(int i=1;i<x+1;i++){
            for(int j=1;j<y+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }
}
