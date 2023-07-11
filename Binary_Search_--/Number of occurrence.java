class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int[] nums=searchRange(arr,x);
        if(nums[0]==-1) return 0;
        return nums[1]-nums[0]+1;
    }
    public static  int[] searchRange(int[] arr, int target) {
        int[] nums={-1,-1};
        int l_Bnd=lowerBound(arr,arr.length,target);
        if(l_Bnd==arr.length||arr[l_Bnd]!=target) return nums;
        nums[0]=l_Bnd;
        nums[1]=upperBound(arr,arr.length,target)-1;
        return nums;
    }
    public static int lowerBound(int[] arr,int n,int tar){
        int spt=0;
        int ept=arr.length-1;
        int ans=n;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(arr[mid]>=tar){
                ans=mid;
                ept=mid-1;
            }
            else spt=mid+1;
        }
        return ans;
    }
    public static int upperBound(int[] arr,int n,int tar){
        int spt=0;
        int ept=arr.length-1;
        int ans=n;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(arr[mid]>tar){
                ans=mid;
                ept=mid-1;
            }
            else spt=mid+1;
        }
        return ans;
    }
}
