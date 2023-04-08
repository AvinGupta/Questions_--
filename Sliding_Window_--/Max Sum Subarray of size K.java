class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        long Max=0,Sum=0;
        for(int i=0;i<K;i++) Sum+=Arr.get(i);
        Max=Sum;
        for(int i=K;i<Arr.size();i++){
            Sum+=Arr.get(i);
            Sum-=Arr.get(i-K);
            Max=Math.max(Sum,Max);
        }
        return Max;
    }
}
