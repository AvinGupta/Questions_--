class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        //solution 1:--
        // By taking the sum of K size window first then do it for the rest of the window.
        long Max=0,Sum=0;
        for(int i=0;i<K;i++) Sum+=Arr.get(i);
        Max=Sum;
        for(int i=K;i<Arr.size();i++){
            Sum+=Arr.get(i);
            Sum-=Arr.get(i-K);
            Max=Math.max(Sum,Max);
        }
        return Max;
        //solution 2:--
        //By taking the sum of whole array at onces.
        long Max=0,Sum=0;
        int s_pt=0;
        int e_pt=0;
        while(e_pt<Arr.size()){
            Sum+=Arr.get(e_pt);
            if((e_pt-s_pt+1)<K) e_pt++;
            else if((e_pt-s_pt+1)==K){
                Max=Math.max(Max,Sum);
                Sum-=Arr.get(s_pt);
                e_pt++;
                s_pt++;
            }
        }
        return Max;
    }
}
