class Solution{
    static List<Integer> jugglerSequence(int N){
        List<Integer> lst=new ArrayList<>();
        Jugg_Seq(N,lst);
        return lst;
    }
    public static void Jugg_Seq(int N,List<Integer> lst){
        if(N==1){
            lst.add(1);
            return;
        }
        lst.add(N);
        if(N%2==0){
            N=(int)Math.pow(N,0.5);
            Jugg_Seq(N,lst);
        }
        else{
            N=(int)Math.pow(N,1.5);
            Jugg_Seq(N,lst);
        }
        
    }
}
