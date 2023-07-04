class Solution{
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x){
        int spt=0,ept=arr.length-1;
        int ans=-1;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(arr[mid]<=x){
                ans=mid;
                spt=mid+1;
            }
            else if(arr[mid]>x){
                ept=mid-1;
            }
        }
        return ans;
    }   
}
