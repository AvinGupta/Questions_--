class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0;
        int j=0;
        int cnt=0;
        int maxCnt=0;
        while(i<n){
            if(arr[i]<=dep[j]){
                cnt+=1;
                i+=1;
            }
            else{
                cnt-=1;
                j+=1;
            }
            maxCnt=Math.max(cnt,maxCnt);
        }
        return maxCnt;
    }
    
}
