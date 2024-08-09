class Solution {
    public static int priority(char ch){
        if(ch=='^') return 3;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='-' || ch=='+') return 1;
        return -1;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        int i=0;
        Stack<Character> st=new Stack<>();
        String ans="";
        while(i<exp.length()){
            char ch=exp.charAt(i);
            if( (ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                ans+=ch;
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans+=st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(st.peek())>=priority(ch)){
                    ans+=st.pop();
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}
