class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int spt=1;
        int ept=stalls[n-1]-stalls[0];
        int ans=0;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(isPosb(stalls,k,mid)){
                ans=mid;
                spt=mid+1;
            }
            else ept=mid-1;
        }
        return ans;
    }
    public static boolean isPosb(int[] arr,int cows,int dist){
        int cows_placed=1;
        int position=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-position>=dist){
                cows_placed++;
                position=arr[i];
            }
            if(cows_placed==cows) return true;
        }
        return false;
    }
}
