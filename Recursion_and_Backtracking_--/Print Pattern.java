class Solution{
    static List<Integer> pattern(int N){
        // code here
        List<Integer> lst=new ArrayList<>();
        Iterator(N,N,lst,true);
        return lst;
    }
    public static void Iterator(int n,int var,List<Integer> lst,boolean check){
        if(var>n) return;
        if(var<=0) check=false;
        if(check==true){
            lst.add(var);
            var-=5;
        }
        else{
            lst.add(var);
            var+=5;
        }
        Iterator(n,var,lst,check);
    }
}
