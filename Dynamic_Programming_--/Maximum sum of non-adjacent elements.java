import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	public static int fnc(ArrayList<Integer> lst,int idx,int[] dp){
		if(idx==0) return lst.get(0);
		if(idx<0) return 0;
		if(dp[idx]!=-1) return dp[idx];
		int pick=lst.get(idx)+fnc(lst,idx-2,dp);
		int notPick=fnc(lst,idx-1,dp);
		return dp[idx]=Math.max(pick,notPick);
	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int[] dp=new int[nums.size()];
		// Arrays.fill(dp,-1);
		// return fnc(nums,nums.size()-1,dp);


		// tabulation 

		// base cases.
		dp[0]=nums.get(0);
		int neg=0;//for index going to negative
		
		for(int i=1;i<dp.length;i++){
			int pick=nums.get(i);
			if(i>1){
				pick+=dp[i-2];
			}
			int notPick=dp[i-1];
			dp[i]=Math.max(pick,notPick);
		}
		return dp[nums.size()-1];
	}
}
