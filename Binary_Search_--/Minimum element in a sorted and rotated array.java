class Solution
{
    int findMin(int arr[], int n)
    {
        //complete the function here
        int spt=0;
        int ept=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(arr[spt]<=arr[mid]){
                ans=Math.min(ans,arr[spt]);
                spt=mid+1;
            }
            else{
                ans=Math.min(ans,arr[mid]);
                ept=mid-1;
            }
        }
        return ans;
    }
}
