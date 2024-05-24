class Compute {
    public long[] printFirstNegativeInteger(long arr[], int N, int K){
        int spt=0;
        int ept=0;
        long[] ans=new long[N-K+1];// here n-k+1 is the number of windows of size k in array of length n.
        ArrayList<Long> lst=new ArrayList<>();
        ArrayList<Long> lst1=new ArrayList<>();
        while(ept<N){
            if(arr[ept]<0) lst.add(arr[ept]);
            if(ept-spt+1<K)ept++;
            else if(ept-spt+1==K){
                if(lst.size()==0) lst1.add((long)0);
                else {
                    lst1.add(lst.get(0));
                    if(arr[spt]<0) lst.remove(0);
                }
                spt++;
                ept++;
            }
        }//converting the list into the array for output
        for(int i=0;i< ans.length;i++){
            ans[i]=lst1.get(i);
        }
        return ans;
    }
}
