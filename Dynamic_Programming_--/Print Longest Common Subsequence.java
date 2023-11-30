public class Solution {
    public static String findLCS(int x, int y, String s1, String s2){
        // Write your code here.
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
        String str="";
        int i=x,j=y;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                str+=s1.charAt(i-1);
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]) i--;
                else j--;
            }
        }
        StringBuilder sb=new StringBuilder(str);
        return sb.reverse().toString();
    }
}
