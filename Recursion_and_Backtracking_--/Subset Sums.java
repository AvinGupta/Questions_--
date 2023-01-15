class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans= new ArrayList<>();
        ArrayList<Integer> lst= new ArrayList<>();
        Sub_sum(arr,N,lst,ans);
        return ans;
    }
    public static void Sub_sum(ArrayList<Integer> arr,int n,ArrayList<Integer> lst,ArrayList<Integer>ans){
        if(n==0){
            int sum=0;
            for(int i=0;i<lst.size();i++){
                sum+=lst.get(i);
            }
            ans.add(sum);
            return;
        }
        Sub_sum(arr,n-1,lst,ans);
        lst.add(arr.get(arr.size()-n));
        Sub_sum(arr,n-1,lst,ans);
        lst.remove(lst.size()-1);
    }
}
