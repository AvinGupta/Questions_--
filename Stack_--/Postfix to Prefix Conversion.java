class Solution {
    static String postToPre(String exp) {
        // code here
        int i=0;
        Stack<String> st=new Stack<>();
        while(i<exp.length()){
            char ch=exp.charAt(i);
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                st.push(ch+"");
            }
            else{
                String x=st.pop();
                String y=st.pop();
                String ans=ch+y+x;
                st.push(ans);
            }
            i++;
        }
        return st.peek();
    }
}
