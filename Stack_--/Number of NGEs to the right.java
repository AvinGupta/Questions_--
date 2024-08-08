class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
        int[] ans=new int[queries];
        for(int i=0;i<queries;i++){
            int idx=arr[indices[i]];
            int cnt=0;
            for(int j=indices[i]+1;j<arr.length;j++){
                if(arr[j]>idx) cnt++;
            }
            ans[i]=cnt;
        }
        return ans;
  }
}
// time complexity O(N*queries);
// space complexity O(queries);
