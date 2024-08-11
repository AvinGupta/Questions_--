class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        int i=pre_exp.length()-1;
        Stack<String> st=new Stack<>();
        while(i>=0){
            char ch=pre_exp.charAt(i);
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                st.push(ch+"");
            }
            else{
                String x=st.pop();
                String y=st.pop();
                String ans='('+x+ch+y+')';
                st.push(ans);
            }
            i--;
        }
        return st.peek();
    }
}
