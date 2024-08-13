class Solution {
    public static int lowerBound(int[] arr,int target){
        int spt=0;
        int ept=arr.length-1;
        int ans=arr.length;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(arr[mid]>=target){
                ans=mid;
                ept=mid-1;
            }
            else if(arr[mid]<target){
                spt=mid+1;
            }
        }
        return ans;
    }
    public int rowWithMax1s(int arr[][]) {
        // code here
        int max=0;
        int idx=-1;
        for(int i=0;i<arr.length;i++){
            int res=arr[0].length-lowerBound(arr[i],1);
            if(res>max){
                max=res;
                idx=i;
            }
        }
        return idx;
    }
}
