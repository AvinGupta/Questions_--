int spt=0;
        int ept=0;
        int[] ans=new int[N-K+1];///answer of size N-K+1 where n is the size of array and k is window size
        ArrayList<Integer> lst=new ArrayList<>();
        ArrayList<Integer> lst1=new ArrayList<>();
        while(ept<N){
            if(arr[ept]<0) lst.add(arr[ept]);
            if(ept-spt+1<K)ept++;
            else if(ept-spt+1==K){
                if(lst.size()==0) lst1.add(0);
                else {
                    lst1.add(lst.get(0));
                    if(arr[spt]<0) lst.remove(0);
                }
                spt++;
                ept++;
            }
        }
        // converting list into array to match the return type 
        for(int i=0;i< ans.length;i++){
            ans[i]=lst1.get(i);
        }
        return ans;
