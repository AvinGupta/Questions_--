class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int spt=0;
        int ept=arr.length-1;
        int ans=Integer.MAX_VALUE;
        int idx=-1;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(arr[spt]<=arr[mid]){
                if(arr[spt]<ans){
                    ans=arr[spt];
                    idx=spt;
                }
                spt=mid+1;
            }
            else{
                if(arr[mid]<ans){
                    ans=arr[mid];
                    idx=mid;
                }
                ept=mid-1;
            }
        }
        return idx;
    }
}
