class Solution 
{ 
    static int Search(int arr[], int target)
	{
	    // code here
	    int spt=0;
	    int ept=arr.length-1;
	    while(spt<=ept){
	        int mid=spt+(ept-spt)/2;
	        if(arr[mid]==target) return mid;
	        if(arr[spt]<=arr[mid]){
	            if(target>=arr[spt] && target<arr[mid]) ept=mid-1;
	            else spt=mid+1;
	        }
	        else{
	            if(target>arr[mid] && target<=arr[ept]) spt=mid+1;
	            else ept=mid-1;
	        }
	    }
	    return -1;
	}
} 
