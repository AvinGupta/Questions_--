class Solution {
    public List<String> find_permutation(String S) {
        char[] arr=S.toCharArray();
        Arrays.sort(arr);
        S=String.valueOf(arr);
        List<String> lst=new ArrayList<>();
        Permute(lst,S,"");
        return lst;
    }
    public static void Permute(List<String> lst,String S,String ans){
        if(S.length()==0){
            if(lst.contains(ans)) return;
            lst.add(ans);
            return;
        }
        for(int i=0;i<S.length();i++){
            String S1=S.substring(0,i);
            String S2=S.substring(i+1);
            char ch=S.charAt(i);
            Permute(lst,S1+S2,ans+ch);
        }
    }

}
