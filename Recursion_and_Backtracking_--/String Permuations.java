class Solution
{
    public ArrayList<String> permutation(String S){
        char[] arr=S.toCharArray();
        Arrays.sort(arr);
        S=String.valueOf(arr);
        ArrayList<String> lst=new ArrayList<>();
        Permutations(S,lst,"");
        return lst;
    }
	 public static void Permutations(String S,ArrayList<String> lst,String ans){
        if(S.length()==0){
            // if(lst.contains(ans)) return;
            lst.add(ans);
            return;
        }
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            String s1=S.substring(0,i);
            String s2=S.substring(i+1);
            Permutations(s1+s2,lst,ans+ch);
        }
    }
}
