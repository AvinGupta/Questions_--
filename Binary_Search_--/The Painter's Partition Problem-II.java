 class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        long spt=0;
        long ept=0;
        for(int var:arr){
            if(var>spt) spt=var;
            ept+=var;
        }
        long ans=0;
        while(spt<=ept){
            long mid=spt+(ept-spt)/2;
            if(isPosb(arr,mid,k)){
                ans=mid;
                ept=mid-1;
            }
            else spt=mid+1;
        }
        return ans;
    }
    public static boolean isPosb(int[] arr,long mid,int painter){
        int var=1;
        int painted=0;
        for(int i=0;i<arr.length;i++){
            if(painted+arr[i]<=mid){
                painted+=arr[i];
            }
            else{
                var++;
                painted=arr[i];
            }
            if(var>painter) return false;
        }
        return true;
    }
}
