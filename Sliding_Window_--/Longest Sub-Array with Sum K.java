class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        //Complete the function
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int len=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k) len=Math.max(len,i+1);
            int rem=sum-k;
            if(map.containsKey(rem)) len=Math.max(len,i-map.get(rem));
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return len;
    }
    
    
}
