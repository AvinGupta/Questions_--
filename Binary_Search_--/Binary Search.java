class Solution {
    // recusive solution
    int binarysearch(int arr[], int n, int k) {
        return bin(arr,k,0,arr.length-1);
    }
    static int bin(int[] arr,int k,int spt,int ept){
        if(spt>ept) return -1;
        int mid=spt+(ept-spt)/2;
        if(arr[mid]==k) return mid;
        if(arr[mid]<k) return bin(arr,k,mid+1,ept);
        return bin(arr,k,spt,mid-1);
    }
}
class Solution {
    // iterative solution
    int binarysearch(int arr[], int n, int k) {
        int spt=0,ept=arr.length-1;
        while(spt<=ept){
            int mid=spt+(ept-spt)/2;
            if(arr[mid]==k) return mid;
            else if(arr[mid]>k) ept=mid-1;
            else spt=mid+1;
        }
        return -1;
    }
}
